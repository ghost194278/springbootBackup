package cn.lzy.redis;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

public class Address {
    @Indexed
    private String City;
    @Indexed
    private String Country;

    public Address() {
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
//