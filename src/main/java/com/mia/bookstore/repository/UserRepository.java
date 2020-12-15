package com.mia.bookstore.repository;

import com.mia.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername (String username);
//    Optional<User> findByEmailAddress(String email);
}
