package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BooksController {
    @Autowired
    public BooksService booksService;


    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String showAllBooks(Model model) {

        model.addAttribute("books", booksService.findAllBooks());

        return "books/books";
    }
}
