package cn.lzy.Thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        String header = request.getHeader("Accept-Language");
        Locale locale = null;
        if (!StringUtils.isEmpty(l)) {
            String[] splits = l.split(",");
            String[] split = splits[0].split("_");
            locale = new Locale(split[0], split[1]);
        } else {
            String[] splits = header.split(",");
            String[] split = splits[0].split("-");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResovel();
    }
}
//
