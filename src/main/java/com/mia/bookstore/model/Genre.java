package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "genre")
@Table()
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private Long genreId;
    @Column(name = "book_genre", length = 50, nullable = false)
    private String genreName;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Book> bookList;
}
