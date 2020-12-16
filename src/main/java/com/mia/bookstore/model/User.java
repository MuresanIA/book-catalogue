package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Size(min = 3, max = 30)
    @Column(name = "user_name", length = 30, nullable = false)
    private String userName;

    @Size(min = 3, max = 30)
    @Column(name = "email_address", length = 30, nullable = false)
    private String email;

    @Size(min = 3, max = 30)
    @Column(name = "user_password", length = 30, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
}
