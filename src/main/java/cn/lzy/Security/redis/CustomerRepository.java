package cn.lzy.Security.redis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 江梅铭
 * @date 10/10/2023 3:48 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
}
