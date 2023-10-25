package cn.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@ImportResource("classpath:xmlproperties.xml")
public class ChapterApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
    }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder.sources(ChapterApplication.class);

    }
}
