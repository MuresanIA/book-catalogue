package com.mia.bookstore.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer privilegeId;

    private String name;

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
