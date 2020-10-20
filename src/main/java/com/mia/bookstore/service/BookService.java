package com.mia.bookstore.service;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.model.Book;
import com.mia.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BookService")
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        Optional<List<Book>> book = Optional.of(bookRepository.findAll());
        return book.orElse(null);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Author findAuthorByBook(Integer id) {
        Optional<Author> author = Optional.ofNullable(bookRepository.findById(id).get().getAuthor());
        return author.orElse(null);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }


}
