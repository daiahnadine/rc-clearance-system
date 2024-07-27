package com.example.clearance.system.domain.yearLevel;

import com.example.clearance.system.domain.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class YearLevel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yearLevelId;

    private String yearName;

    @OneToMany(mappedBy = "yearLevel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
}