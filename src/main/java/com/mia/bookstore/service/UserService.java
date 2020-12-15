package com.mia.bookstore.service;

import com.mia.bookstore.model.User;
import com.mia.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserService")
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
}
