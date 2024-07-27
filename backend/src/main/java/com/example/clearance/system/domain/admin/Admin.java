package com.example.clearance.system.domain.admin;

import com.example.clearance.system.domain.person.Person;
import com.example.clearance.system.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Admin extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adminNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
