package cn.lzy.Security.redis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 江梅铭
 * @date 10/10/2023 3:51 PM
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username =?1", nativeQuery = true)
    public List<Authority> findAuthoritiesByUsername(String username);
}
//