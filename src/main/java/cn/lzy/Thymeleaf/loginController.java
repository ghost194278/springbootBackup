package cn.lzy.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
public class loginController {
    @GetMapping("/toLoginPage")
    public String toLoginPage(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
//@Controller
//public class loginController {
//    @GetMapping("/toLoginPage")
//    public String toLoginPage(Model model){
//        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
//        return "login";
//    }
//}
