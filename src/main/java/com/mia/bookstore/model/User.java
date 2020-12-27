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

    @Size(min = 3, max = 50)
    @Column(name = "user_name")
    private String username;

    @Size(min = 3, max = 50)
    @Column(name = "email_address")
    private String email;

    @Size(min = 3, max = 50)
    @Column(name = "user_password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
}
