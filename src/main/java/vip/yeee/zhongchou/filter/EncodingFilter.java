package vip.yeee.zhongchou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class EncodingFilter implements Filter {

    protected String encoding = null;

    @Override
    public void destroy() {
        this.encoding = null;

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //System.out.println("EncodingFilter获得请求："+req.getRequestURI());

//		if (response.getContentType() == null || response.getContentType().equals("")) {
//			response.setContentType("text/html;charset=utf-8");
//		}

        String encoding = this.encoding;
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        //System.out.println("EncodingFilter被创建");
        this.encoding = config.getInitParameter("encoding");
    }

}
