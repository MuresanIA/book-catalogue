package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Books;
import com.mia.bookstore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(method = RequestMethod.GET, value = "/createbooks")
    public String createBooks(Model model) {
        model.addAttribute("books", new Books());
        return "books/createbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/createbooks"))
    public String createBooks(@ModelAttribute Books books) {
        booksService.save(books);
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/editbooks/{id}"))
    public String editBooks(Model model, @PathVariable Integer id) {
        Books books = booksService.findByBookById(id);
        model.addAttribute("books", books);
        return "books/editbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/editbooks/{id}"))
    public String editBooks(@ModelAttribute Books books, @PathVariable Integer id){
        booksService.save(books);
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/deletebooks/{id}"))
    public String deleteBooks(@PathVariable Integer id){
        booksService.deleteById(id);
        return "redirect:/books";
    }
}
