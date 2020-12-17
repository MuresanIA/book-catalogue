package com.mia.bookstore.repository;

import com.mia.bookstore.model.PendingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PendingUserRepository extends JpaRepository<PendingUser, Integer> {
    Optional<PendingUser> findByActivationCode(String activationCode);

    @Query
    Optional<PendingUser> findByUsername(@Param("username") String username);
}
