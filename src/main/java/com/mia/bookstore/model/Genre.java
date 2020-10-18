package com.mia.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "BOOK_GENRE", length = 50, nullable = false, unique = false)
    private String genre;

    @OneToMany(mappedBy = "BOOK_GENRE", cascade = CascadeType.ALL)
    private List<Book> bookList;
}
