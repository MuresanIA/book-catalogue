package com.mia.bookstore.service;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AuthorService")
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {

        Optional<List<Author>> author = Optional.of(authorRepository.findAll());
        return author.orElse(null);
    }


    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    //TODO: authorFindById();
}
