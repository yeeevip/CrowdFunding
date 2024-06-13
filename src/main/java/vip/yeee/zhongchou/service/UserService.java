package vip.yeee.zhongchou.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vip.yeee.zhongchou.dao.UserDao;
import vip.yeee.zhongchou.entity.User;
import vip.yeee.zhongchou.utils.Utils;
/**
 * 用户表的Service类
 */

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class UserService {

    private final UserDao userDao = new UserDao();

    public void registerUser(String condition, String password) throws SQLException {
        User user = new User();
        //如果用户输入的是邮箱号码
        if (Utils.isEmail(condition))
            user.setEmail(condition);
            //否则用户输入的就是手机号码
        else
            user.setPhone(condition);
        //设置用户密码
        user.setPassword(Utils.toMD5(password));

        Date current_date = new Date();//生成日期对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式样式为yyyy-MM-dd

        user.setDate_of_registration(simpleDateFormat.format(current_date.getTime()));
        userDao.save(user);


    }

    /**
     * 检查验证码信息
     */
    public boolean checkCode(String right_code, String code) {
        if (right_code == null || "".equals(right_code))
            return false;
        right_code = right_code.toUpperCase();
        code = code.toUpperCase();

        if (right_code.equals(code))
            return true;
        return false;

    }

    /**
     * 验证手机和邮箱的唯一性
     *
     * @throws SQLException
     */
    public boolean checkPhoneAndEmail(String phone, String email, User user) throws SQLException {
        if (!phone.equals(user.getPhone()))
            if (userDao.getUserByCondition(phone) != null)
                return false;

        if (!email.equals(user.getEmail()))
            if (userDao.getUserByCondition(email) != null)
                return false;

        return true;
    }


}
