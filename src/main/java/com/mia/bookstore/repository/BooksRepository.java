package com.mia.bookstore.repository;

import com.mia.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

   Books findByBookId(Integer id);
}
