package cn.lzy.Security.redis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author 江梅铭
 * @date 10/10/2023 3:48 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
    @Transactional
    @Modifying
    @Query("UPDATE t_customer c SET c.username = ?1 WHERE  c.username = ?2")
    void updateByUsername(String name,String username);
}
//