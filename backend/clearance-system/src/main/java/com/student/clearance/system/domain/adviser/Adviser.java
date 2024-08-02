package com.student.clearance.system.domain.adviser;

import com.student.clearance.system.domain.person.Person;
import com.student.clearance.system.domain.user.User;
import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Adviser extends Person implements Serializable {

    private Long AdviserId;
    private String EmployeeNumber;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
