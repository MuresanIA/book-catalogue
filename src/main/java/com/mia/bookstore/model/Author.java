package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
@Table()
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id", nullable = false)
    private Integer authorId;
    @Column(name = "author_first_name", nullable = false)
    private String authorFirstName;
    @Column(name = "author_middle_name", nullable = false)
    private String authorMiddleName;
    @Column(name = "author_last_name", nullable = false)
    private String authorLastName;

}
