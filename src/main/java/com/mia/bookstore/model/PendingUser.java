package com.mia.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pending_user")
public class PendingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pending_user_id")
    private Integer pendingUserId;


    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "expiration_date")
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}
