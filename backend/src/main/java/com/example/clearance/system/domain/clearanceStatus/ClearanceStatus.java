package com.example.clearance.system.domain.clearanceStatus;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;
import com.example.clearance.system.domain.clearance.Clearance;
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
    @JoinColumn(name = "clearance_id")
    private Clearance clearance;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private AuthorizedOffice office;

    private String status;
    private String reason;
}
