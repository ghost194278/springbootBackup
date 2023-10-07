package cn.lzy.cache.RedisCache;

import cn.lzy.mydatiscatalog.jpa.Discuss;
import cn.lzy.mydatiscatalog.jpa.DiscussRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 江梅铭
 * @date 9/23/2023 10:53 AM
 */
@Service
public class RedisService {
    @Autowired
    private DiscussRepositroy discussRepositroy;
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Discuss findById(int comment_id){
        Optional<Discuss> optional=discussRepositroy.findById(comment_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Discuss updateComment(Discuss comment){
        discussRepositroy.updateComment(comment.getAuthor(),comment.getaId());
        return comment;
    }
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        discussRepositroy.deleteById(comment_id);
    }
}
