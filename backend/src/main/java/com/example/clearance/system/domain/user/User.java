package com.example.clearance.system.domain.user;

import com.example.clearance.system.domain.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String username;
    private String password;
    private Date lastLoginDate;
    private Date joinDate;
    private String role;

    @OneToOne(mappedBy = "user")
    private Student student;
}
