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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Size(min = 3, max = 20)
    @Column(name = "role_name", nullable = false, length = 20)
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
