package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Book;
import com.mia.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> showAllBooks() {

        try {
            return ResponseEntity.ok(bookRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> showBook(@PathVariable Integer id) {
        try {
            return ResponseEntity.of(bookRepository.findById(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/books/edit")
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookRepository.save(book));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id) {

        try {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

    }

}
