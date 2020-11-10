package com.mia.bookstore.service;

import com.mia.bookstore.model.Books;
import com.mia.bookstore.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BooksService")
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> findAllBooks() {
        Optional<List<Books>> books = Optional.of(booksRepository.findAll());
        return books.orElse(null);
    }

    public Books findByBookById(Integer id) {
        Optional<Books> books = Optional.ofNullable(booksRepository.findByBookById(id));
        return books.orElse(null);
    }

    public Books save(Books books) {
        return booksRepository.save(books);
    }

    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
        ;
    }
}
