package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

    private final AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> showAllAuthors() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Integer id) {
        return ResponseEntity.of(authorRepository.findById(id));
    }

    @PostMapping("/authors/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

        authorRepository.save(author);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/authors/edit")
    public ResponseEntity<Author> editAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorRepository.save(author));
    }

    @DeleteMapping("/authors/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Integer id) {

        try {
            authorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
