package cn.lzy.cache.JpaCache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 江梅铭
 * @date 9/22/2023 10:03 AM
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

        @Query("select c FROM t_article c WHERE  c.id = ?2")
        public List<Article> selectarticle(Integer id);


//    @Query("SELECT c FROM t_comment c WHERE  c.aId = ?1.hrml")
//    public List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);
  }



