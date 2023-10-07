package cn.lzy.Security.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 江梅铭
 * @date 10/7/2023 4:14 PM
 */
@Controller
public class FilmeController {
    private String TAG = "FilmeController";

    // 影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type,
                           @PathVariable("path") String path) {
        String value = "detail/" + type + "/" + path;
        System.out.println(TAG + "===toDetail===" + value);
        return value;
    }
}

