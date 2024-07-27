package com.example.clearance.system.domain.student;

import com.example.clearance.system.domain.clearance.Clearance;
import com.example.clearance.system.domain.person.Person;
import com.example.clearance.system.domain.course.Course;
import com.example.clearance.system.domain.yearLevel.YearLevel;
import com.example.clearance.system.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Student extends Person implements Serializable {

    @ManyToOne
    @JoinColumn(name = "year_level_id")
    private YearLevel yearLevel;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clearance> clearances;
}
