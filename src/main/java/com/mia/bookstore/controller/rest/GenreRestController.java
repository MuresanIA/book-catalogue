package com.mia.bookstore.controller.rest;

import com.mia.bookstore.model.Genre;
import com.mia.bookstore.repository.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreRestController {

    private final GenreRepository genreRepository;

    public GenreRestController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> showAllGenres() {
        try {
            return ResponseEntity.ok(genreRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Integer id) {
        try {
            return ResponseEntity.of(genreRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/genre/create")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        try {
            genreRepository.save(genre);
            return ResponseEntity.ok(genre);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/genre/edit")
    public ResponseEntity<Genre> editGenre(@RequestBody Genre genre) {
        try {
            return ResponseEntity.ok(genreRepository.save(genre));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/genre/delete/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Integer id) {
        try {
            genreRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}