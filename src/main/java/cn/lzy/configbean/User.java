package cn.lzy.configbean;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@ConfigurationProperties(prefix = "user")
@Validated
public class User {
    @Email
    String emai;
    @URL
    String url;

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "emai='" + emai + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
