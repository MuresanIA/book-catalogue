package com.mia.bookstore.repository;

import com.mia.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("FROM author a WHERE a.authorName = :authorName")
     Author findByAuthorName(String authorName);

    Author findByAuthorId(Long id);

}
