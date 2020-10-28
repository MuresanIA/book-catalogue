package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.repository.AuthorRepository;
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

        try {
            return ResponseEntity.ok(authorRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        try {
            return ResponseEntity.of(authorRepository.findById(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/authors/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

        try {
            authorRepository.save(author);
            return ResponseEntity.ok(author);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/authors/edit")
    public ResponseEntity<Author> editAuthor(@RequestBody Author author) {
        try {
            return ResponseEntity.ok(authorRepository.save(author));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteauthor/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {

        try {
            authorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
