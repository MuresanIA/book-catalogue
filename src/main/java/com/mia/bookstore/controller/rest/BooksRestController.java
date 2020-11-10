package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Books;
import com.mia.bookstore.repository.BooksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksRestController {
    private final BooksRepository booksRepository;

    public BooksRestController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>> showAllBooks() {

        try {
            return ResponseEntity.ok(booksRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBook(@PathVariable Integer id) {
        try {
            return ResponseEntity.of(booksRepository.findById(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books/create")
    public ResponseEntity<Books> createBooks(@RequestBody Books books) {
        try {
            booksRepository.save(books);
            return ResponseEntity.ok(books);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/books/edit")
    public ResponseEntity<Books> editBooks(@RequestBody Books books) {

        try {
            return ResponseEntity.ok(booksRepository.save(books));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletebooks/{id}")
    public ResponseEntity<Books> deleteBooks(@PathVariable Integer id) {
        try {
            booksRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
