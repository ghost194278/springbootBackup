package cn.lzy.customconfig;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean("MyProperties")
    public MyProperties getMyProperties() {
        return new MyProperties();
    }
}
//