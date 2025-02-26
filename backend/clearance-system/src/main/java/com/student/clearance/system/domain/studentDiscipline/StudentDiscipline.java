package com.student.clearance.system.domain.studentDiscipline;

import com.student.clearance.system.domain.person.Person;
import com.student.clearance.system.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class StudentDiscipline extends Person implements Serializable {

    private Long StudentDisciplineId;
    private String EmployeeNumber;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
