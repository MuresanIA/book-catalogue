package com.mia.bookstore.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "privilegeId"
            )
    )
    private Collection<Privilege> privileges;

}
