package com.mia.bookstore.repository;

import com.mia.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("FROM author a WHERE a.name = :name")
    public Author findByAuthorName(String name);

}
