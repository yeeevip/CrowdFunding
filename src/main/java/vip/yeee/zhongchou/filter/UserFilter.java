package vip.yeee.zhongchou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.yeee.zhongchou.constant.Constants;
import vip.yeee.zhongchou.entity.User;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class UserFilter implements Filter {

    //可以免验证的url链接群
    private String checked = null;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        //转换HttpServletRequest的类型
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取当前请求URL，没有其他，没有其他参数
        String url = req.getRequestURI();

        //判断URL是否需要执行登陆状态信息验证。如果不需要 则直接通过
        if (!isChecked(url)) {
            chain.doFilter(request, response);
            return;
        }

        //如果用户已登录，则通过验证
        User user = (User) req.getSession().getAttribute(Constants.USER_KEY);
        if (user != null) {
            chain.doFilter(request, response);
            return;
        }
        resp.sendRedirect("include/login.jsp?re=" + url);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub
        checked = config.getInitParameter("checked");

    }

    private boolean isChecked(String url) {
        //获取所有隐私资源
        String[] checkedArray = checked.split(";");
        for (String memeber : checkedArray) {
            if (url.contains(memeber))
                return true;
        }
        return false;
    }

}
