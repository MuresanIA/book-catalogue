package com.mia.bookstore.service;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.model.Books;
import com.mia.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public Author findById(Integer id) {

        Optional<Author> author = Optional.ofNullable(authorRepository.findByAuthorId(id));
        return author.orElse(null);
    }

    public Author findByAuthorFirstName(String authorFirstName) {
        Author author = authorRepository.findAuthorByFirstName(authorFirstName);
        return author;
    }

    public Author findByAuthorMiddleName(String authorMiddleName) {
        Author author = authorRepository.findAuthorByMiddleName(authorMiddleName);
        return author;
    }

    public Author findByAuthorLastName(String authorLastName) {
        Author author = authorRepository.findAuthorByLastName(authorLastName);
        return author;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    public Optional<List<Books>> findBooksByAuthors(Integer id) {
        return Optional.ofNullable(Objects.requireNonNull(authorRepository.findById(id).orElse(null)).getBooks());
    }
}
