package com.mia.bookstore.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Size(min = 3, max = 20)
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Size(min = 3, max = 20)
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Size(min = 3, max = 20)
    @Column(name = "user_email", nullable = false, length = 20)
    private String email;
    @Size(min = 3, max = 20)
    @Column(name = "user_password", nullable = false, length = 20)
    private String password;
    @Column(name = "is_enabled", nullable = false)
    private boolean enabled;
    @Column(name = "is_token_expired", nullable = false)
    private boolean tokenExpired;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "userId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "roleId"
            )
    )
    private Collection<Role> roles;

}
