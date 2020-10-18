package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "AUTHOR_NAME", nullable = false, unique = false)
    private String name;

    @OneToMany(mappedBy = "AUTHOR_NAME", cascade = CascadeType.ALL)
    private List<Book> bookList;

}
