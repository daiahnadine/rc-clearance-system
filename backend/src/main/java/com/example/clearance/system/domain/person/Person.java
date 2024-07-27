package com.example.clearance.system.domain.person;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    private String birthplace;
    private String sex;
    private String civilStatus;
    private String citizenship;
    private String religion;
    private String email;
    private String address;
    private String contactNumber;
}
