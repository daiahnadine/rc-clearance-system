package com.student.clearance.system.domain.clearanceStatus;

import com.student.clearance.system.domain.clearance.Clearance;
import com.student.clearance.system.domain.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class ClearanceStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "clearance_id", nullable = false)
    private Clearance clearance;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    private String reason;

    public enum Status {
        PENDING, CLEARED
    }
}
