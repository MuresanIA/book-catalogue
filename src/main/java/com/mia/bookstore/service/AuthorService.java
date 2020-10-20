package com.mia.bookstore.service;

import com.mia.bookstore.model.Author;
import com.mia.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AuthorService")
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findById(Integer id){
        return authorRepository.findByAuthorId(id);
    }
}
