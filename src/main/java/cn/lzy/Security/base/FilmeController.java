package cn.lzy.Security.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/userLogin")
    public String toLoginPage(){
        return "login/login";
    }
    @GetMapping("/getuserByContext")
    @ResponseBody
    public String getUser2() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        System.out.println("username: "+principal.getUsername());
        return principal.getUsername();
    }
}

