package com.mia.bookstore.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Size(min = 3, max = 30)
    @Column(name = "user_name", length = 30, nullable = false)
    private String userName;

    @Size(min = 3, max = 30)
    @Column(name = "email_address", length = 30, nullable = false)
    private String email;

    @Size(min = 3, max = 30)
    @Column(name = "user_password", length = 30, nullable = false)
    private String password;


}
