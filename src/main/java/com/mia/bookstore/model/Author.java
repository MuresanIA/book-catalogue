package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
@Table()
public class Author {
//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id", nullable = false)
    private Integer authorId;
    @Column(name = "author_first_name", nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String authorFirstName;
    @Column(name = "author_middle_name", nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String authorMiddleName;
    @Column(name = "author_last_name", nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String authorLastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Books> books;

}
