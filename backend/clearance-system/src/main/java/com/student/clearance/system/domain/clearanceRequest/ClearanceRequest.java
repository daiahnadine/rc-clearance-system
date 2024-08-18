package com.student.clearance.system.domain.clearanceRequest;

import com.student.clearance.system.domain.student.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClearanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String remarks;

    public enum Status {
        CLEARED, PENDING
    }
}
