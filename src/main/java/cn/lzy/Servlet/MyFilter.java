package cn.lzy.Servlet;

/**
 * @author 江梅铭
 * @date 9/18/2023 10:42 AM
 */

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 江梅铭
 * @date ${DATE} ${TIME}
 */
@Component

//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {   }
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("hello MyFilter");
//        filterChain.doFilter(servletRequest,servletResponse);}
//    @Override
//    public void destroy() {   }}


@WebFilter(value = {"/antionLogin", "/antionMyFilter"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello MyFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
