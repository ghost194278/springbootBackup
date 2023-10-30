package cn.lzy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江梅铭
 * @date 9/18/2023 8:42 AM
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "你好 Spring Boot";
    }

}
//