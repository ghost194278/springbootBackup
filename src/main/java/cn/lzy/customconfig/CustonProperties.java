package cn.lzy.customconfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:fku.properties")
@EnableConfigurationProperties(CustonProperties.class)
@ConfigurationProperties(prefix = "ez")
public class CustonProperties {
    @Value("${ez.s}")
    private int s;
    @Value("${ez.s}")
    private String w;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "CustonProperties{" +
                "s=" + s +
                ", w='" + w + '\'' +
                '}';
    }
}
