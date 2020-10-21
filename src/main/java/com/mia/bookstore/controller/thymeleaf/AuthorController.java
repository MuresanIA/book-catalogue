package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, value = "/authors")
    public String showAllAuthors(Model model) {

        model.addAttribute("authors", authorService.findAllAuthors());

        return "author/authors.html";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/createauthor")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/createauthor.html";
    }
}

