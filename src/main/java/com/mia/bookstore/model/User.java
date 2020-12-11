package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Size(min = 3, max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 3, max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Size(min = 3, max = 20)
    @Column(name = "user_email")
    private String email;
    @Size(min = 3, max = 20)
    @Column(name = "user_password")
    private String password;
    @Column(name = "is_enabled")
    private boolean enabled;
    @Column(name = "is_token_expired")
    private boolean tokenExpired;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "userId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "roleId"
            )
    )
    private Collection<Role> roles;

}
