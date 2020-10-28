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

    public Author findById(Long id) {

        Optional<Author> author = Optional.ofNullable(authorRepository.findByAuthorId(id));
        return author.orElse(null);
    }

    public Author findByAuthorName(String authorName) {
        Author author = authorRepository.findByAuthorName(authorName);
        return author;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
