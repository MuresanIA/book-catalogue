package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;
    @Column(name = "author_name", nullable = false)
    private String authorName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList;

}
