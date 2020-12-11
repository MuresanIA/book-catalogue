package com.mia.bookstore.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer privilegeId;

    private String name;

}
