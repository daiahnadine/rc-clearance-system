package com.student.clearance.system.domain.student;

import com.student.clearance.system.domain.clearance.Clearance;
import com.student.clearance.system.domain.person.Person;
import com.student.clearance.system.domain.course.Course;
import com.student.clearance.system.domain.yearLevel.YearLevel;
import com.student.clearance.system.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Student extends Person implements Serializable {

    @Column(length = 10)
    private String studentNumber;

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
