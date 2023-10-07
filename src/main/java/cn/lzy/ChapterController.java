package cn.lzy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChapterController {
    @RequestMapping(value = "hello")
    public String sayHello() {
        return "你好,hello spring boot";
    }

}
