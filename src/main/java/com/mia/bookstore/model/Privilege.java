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
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long privilegeId;

    @Size(min = 3, max = 20)
    @Column(name = "privilege_name", nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

}
