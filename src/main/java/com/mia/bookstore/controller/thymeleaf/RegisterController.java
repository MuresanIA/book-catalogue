package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.PendingUser;
import com.mia.bookstore.model.User;
import com.mia.bookstore.repository.PendingUserRepository;
import com.mia.bookstore.repository.UserRepository;
import com.mia.bookstore.service.RandomStringGeneratorService;
import com.mia.bookstore.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
    public String registerUser() {
        return "security/registerform";
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registerUser(HttpServletRequest request, String username, String password, String emailAddress) {

        String validationUrl = "https://" + request.getServerName() + request.getContextPath();

        User user = new User();
        user.setEmail(emailAddress);
        user.setPassword(encoder().encode(password));
        user.setUsername(username);
        userRepository.save(user);

        PendingUser pendingUser = new PendingUser();
        String activationCode = randomStringGeneratorService.getAlphaNumericString(20);
        pendingUser.setActivationCode(activationCode);
        sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com", user.getUsername(),
                "Greetings traveller, we must confirm the account in order to go further.",
                randomStringGeneratorService.linkCreator(activationCode, validationUrl));
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userValidation")
    public String validateUser(String activationCode) {

        System.out.println(activationCode);
        Optional<PendingUser> optionalPendingUser = pendingUserRepository.findByActivationCode(activationCode);
        if (optionalPendingUser.isPresent()) {
            PendingUser pendingUser = optionalPendingUser.get();
            System.out.println(pendingUser.getActivationCode());
        }
        return "redirect:/login";
    }
}
