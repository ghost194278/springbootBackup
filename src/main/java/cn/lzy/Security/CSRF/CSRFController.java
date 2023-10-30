package cn.lzy.Security.CSRF;

import cn.lzy.Security.base.FilmeController;
import cn.lzy.Security.redis.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 江梅铭
 * @date 10/14/2023 10:44 AM
 */
@Controller
public class CSRFController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FilmeController filmeController;
    @GetMapping("/toUpdate")
    public String toUpdate() { return "csrf/csrfTest";}
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        String csrf_token = request.getParameter("_csrf");
        System.out.println(csrf_token);
        customerRepository.updateByUsername(username,filmeController.getUser2());
        return "ok";}}
//



