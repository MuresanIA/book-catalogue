package com.mia.bookstore.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage(Model model){
        return "security/loginform";
    }
}
