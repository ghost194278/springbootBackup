package cn.lzy.web.functionextensionmvc;

/**
 * @author 江梅铭
 * @date 9/18/2023 10:51 AM
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/toLoginPage1").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }
    @Autowired
    MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html");
    }

}
