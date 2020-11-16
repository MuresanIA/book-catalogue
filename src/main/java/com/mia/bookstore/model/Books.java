package com.mia.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
@Table()
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    private Integer bookId;
    @Column(name = "book_name", nullable = false, length = 20)
    private String bookName;
    @Column(name = "book_genre", nullable = false, length = 20)
    private String bookGenre;
    @Column(name = "book_year_release", nullable = false, length = 20)
    private Date bookYearRelease;
    @Column(name = "book_language", nullable = false, length = 20)
    private String bookLanguage;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

}
