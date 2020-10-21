package com.mia.bookstore.service;

import com.mia.bookstore.model.Genre;
import com.mia.bookstore.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAllGenres() {
        Optional<List<Genre>> genre = Optional.of(genreRepository.findAll());
        return genre.orElse(null);
    }


    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
