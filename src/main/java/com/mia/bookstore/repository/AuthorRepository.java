package com.mia.bookstore.repository;

import com.mia.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("FROM author a WHERE a.authorFirstName = :authorFirstName")
    Author findAuthorByFirstName(String authorFirstName);

    @Query("FROM author a WHERE a.authorMiddleName = :authorMiddleName")
    Author findAuthorByMiddleName(String authorMiddleName);

    @Query("FROM author a WHERE a.authorLastName = :authorLastName")
    Author findAuthorByLastName(String authorLastName);


    Author findByAuthorId(Integer id);

}
