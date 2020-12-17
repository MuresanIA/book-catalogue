package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.repository.PendingUserRepository;
import com.mia.bookstore.repository.UserRepository;
import com.mia.bookstore.service.RandomStringGeneratorService;
import com.mia.bookstore.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PendingUserRepository pendingUserRepository;

    @Autowired
    private RandomStringGeneratorService randomStringGeneratorService;

    @Autowired
    private SendGridEmailService sendGridEmailService;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String registerUser(){
        return "security/register";
    }
}
