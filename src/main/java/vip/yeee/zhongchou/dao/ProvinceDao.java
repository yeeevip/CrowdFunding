package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vip.yeee.zhongchou.entity.Province;
import vip.yeee.zhongchou.utils.JDBCUtils;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProvinceDao {

    public List<Province> queryProvinceList(int pid) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from province_city_district WHERE pid =" + pid;
        List<Province> provinceList = new ArrayList<>();

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Province p = new Province();
            p.setId(rs.getInt("id"));
            p.setPid(rs.getInt("pid"));
            p.setName(rs.getString("name"));
            provinceList.add(p);
        }
        JDBCUtils.releaseConnection(con);
        return provinceList;
    }

}
