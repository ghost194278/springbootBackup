package cn.lzy.Security.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 江梅铭
 * @date 10/10/2023 3:57 PM
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    public Customer getCustomer(String usernmae) {
        Customer customer = null;
        Object o = redisTemplate.opsForValue().get("customer_" + usernmae);
        if (o != null) {
            customer = (Customer) o;
        } else {
            customer = customerRepository.findByUsername(usernmae);
            if (customer != null) {
                redisTemplate.opsForValue().set("customer_" + usernmae, customer);
                ;
            }
        }
        return customer;
    }

    public List<Authority> getCustomerAuthority(String username) {
        List<Authority> authorities = null;
        Object o = redisTemplate.opsForValue().get("authorities_" + username);
        if (o != null) {
            authorities = (List<Authority>) o;
        } else {
            authorities = authorityRepository.findAuthoritiesByUsername(username);
            if (authorities.size() > 0) {
                redisTemplate.opsForValue().set("authorities_" + username, authorities);
            }
        }
        return authorities;
    }
}
