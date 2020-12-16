package com.mia.bookstore.repository;

import com.mia.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByAuthorId(Integer id);

}
