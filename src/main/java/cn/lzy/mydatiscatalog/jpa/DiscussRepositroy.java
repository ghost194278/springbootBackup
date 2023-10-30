package cn.lzy.mydatiscatalog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

public interface DiscussRepositroy extends JpaRepository<Discuss, Integer> {
    public List<Discuss> findByAuthorNotNull();

    @Query("SELECT c FROM t_comment c WHERE  c.aId = ?1")
    public List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);

    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1", nativeQuery = true)
    public List<Discuss> getDiscussPaged2(Integer aid, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE  c.id = ?2")
    public int updateDiscuss(String author, Integer id);

    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE  c.id = ?1")
    public int deleteDiscuss(Integer id);

    @org.springframework.transaction.annotation.Transactional
    @Modifying
    @Query("update t_comment c set c.author = ?1 where c.id = ?2")
    public int updateComment(String author,Integer id);

}
//