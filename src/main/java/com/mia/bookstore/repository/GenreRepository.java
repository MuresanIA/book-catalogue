package com.mia.bookstore.repository;

import com.mia.bookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    public Genre findByGenreId(Integer id);

}
