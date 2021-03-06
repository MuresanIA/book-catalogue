package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;

    }


    @RequestMapping(method = RequestMethod.GET, value = "/authors")
    public String showAllAuthors(Model model) {
        List<Author> authorList = authorService.findAllAuthors();
        model.addAttribute("author", authorList);

        return "author/authors";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/createauthor")
    public String createAuthor(Model model) {
//        model.addAttribute("books", booksService.findAllBooks());
        model.addAttribute("author", new Author());
        return "author/createauthor";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createauthor")
    public String createAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editauthor/{id}")
    public String editAuthor(Model model, @PathVariable Integer id) {
        Author author = authorService.findByAuthorId(id);
        model.addAttribute("author", author);
        return "author/editauthor";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editauthor/{id}")
    public String editAuthor(@ModelAttribute Author author, @PathVariable Integer id) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @RequestMapping(method = RequestMethod.GET, value = ("/deleteauthor/{id}"))
    public String deleteAuthor(@PathVariable Integer id) {

        authorService.deleteById(id);
        return "redirect:/authors";

    }

    @RequestMapping(method = RequestMethod.GET, value = ("/author/{id}/books"))
    public String viewAuthorsBooks(Model model, @PathVariable Integer id) {
        model.addAttribute("books", authorService.findBooksByAuthors(id));
        return "author/viewbooks";
    }
}

