package cn.lzy.Servlet;

/**
 * @author 江梅铭
 * @date 9/18/2023 10:50 AM
 */

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {
    //    @Bean
//    public ServletRegistrationBean getServlet(MyServlet myServlet) {
//        ServletRegistrationBean registrationBean =
//                new ServletRegistrationBean(myServlet, "/myServlet");
//        return registrationBean;
//    }
//    @Bean
//    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
//        ServletListenerRegistrationBean registrationBean =
//                new ServletListenerRegistrationBean(myListener);
//        return registrationBean;
//    }
//    @Bean
//    public FilterRegistrationBean getFilter(MyFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setUrlPatterns(Arrays.asList("/toLoginPage", "/myFilter"));
//        return registrationBean;
//    }


}

