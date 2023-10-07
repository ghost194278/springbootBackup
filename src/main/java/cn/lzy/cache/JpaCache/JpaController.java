package cn.lzy.cache.JpaCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author 江梅铭
 * @date 9/22/2023 9:48 AM
 */
@RestController
public class JpaController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/get/{id}")
    @Cacheable(cacheNames = "article")
    public Article finById(@PathVariable("id") int article_id){
        Optional<Article> optional =articleRepository.findById(article_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
