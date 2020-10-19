package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorRestController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> showAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/authors")
    public Author editAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @DeleteMapping("/authors")
    public void deleteAuthor(@PathVariable Author author) {
        authorRepository.deleteById(author.getId());
    }
}
