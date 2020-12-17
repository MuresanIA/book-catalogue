package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.repository.PendingUserRepository;
import com.mia.bookstore.repository.UserRepository;
import com.mia.bookstore.service.RandomStringGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PendingUserRepository pendingUserRepository;

    @Autowired
    private RandomStringGeneratorService randomStringGeneratorService;

}
