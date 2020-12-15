package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

public class RegisterController {

    @RequestMapping(method = RequestMethod.GET, value = "/user/registration")
    public String showRegistrationForm(WebRequest request, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration/registration";
    }
}
