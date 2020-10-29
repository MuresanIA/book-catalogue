package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Book;
import com.mia.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String showAllBooks(Model model) {

        model.addAttribute("book", bookService.findAllBooks());
        return "book/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createbook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/createbook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createbook")
    public String createBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/editbook/{id}")
    public String editBook(Model model, @PathVariable Long id) {

        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/editbook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editbook/{id}")
    public String editBook(@ModelAttribute Book book, @PathVariable Long id) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deletebook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
