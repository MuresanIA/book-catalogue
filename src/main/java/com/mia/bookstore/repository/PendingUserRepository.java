package com.mia.bookstore.repository;

import com.mia.bookstore.model.PendingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingUserRepository extends JpaRepository<PendingUser, Long> {
}
