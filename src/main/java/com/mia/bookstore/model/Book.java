package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "book_name", nullable = false, unique = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

}
