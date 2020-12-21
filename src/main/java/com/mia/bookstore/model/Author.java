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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "author_first_name", length = 50)
    @Size(min = 3, max = 50)
    private String authorFirstName;
    @Column(name = "author_middle_name", length = 50)
    @Size(min = 3, max = 50)
    private String authorMiddleName;
    @Column(name = "author_last_name", length = 50)
    @Size(min = 3, max = 50)
    private String authorLastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Books> books;
}
