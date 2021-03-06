package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Books;
import com.mia.bookstore.service.AuthorService;
import com.mia.bookstore.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BooksController {
    private final BooksService booksService;
    private final AuthorService authorService;

    public BooksController(BooksService booksService, AuthorService authorService) {
        this.booksService = booksService;
        this.authorService = authorService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String showAllBooks(Model model) {
        List<Books> booksList = booksService.findAllBooks();
        model.addAttribute("books", booksList);

        return "books/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createbooks")
    public String createBooks(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
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
        Books books = booksService.findBooksById(id);
        model.addAttribute("books", books);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "books/editbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/editbooks/{id}"))
    public String editBooks(@ModelAttribute Books books, @PathVariable Integer id) {
        booksService.save(books);
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/deletebooks/{id}"))
    public String deleteBooks(@PathVariable Integer id) {
        booksService.deleteById(id);
        return "redirect:/books";
    }
}
