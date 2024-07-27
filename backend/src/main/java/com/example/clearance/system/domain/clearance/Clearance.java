package com.example.clearance.system.domain.clearance;

import com.example.clearance.system.domain.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Clearance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clearanceNo;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
