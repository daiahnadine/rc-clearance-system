package com.student.clearance.system.domain.clusterCoordinator;

import com.student.clearance.system.domain.person.Person;
import com.student.clearance.system.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class ClusterCoordinator extends Person implements Serializable {

    private Long ClusterCoordinatorId;
    private String EmployeeNumber;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
