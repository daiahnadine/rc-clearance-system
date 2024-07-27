package com.example.clearance.system.domain.clearanceHistory;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;
import com.example.clearance.system.domain.clearance.Clearance;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class ClearanceHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "clearance_id")
    private Clearance clearance;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private AuthorizedOffice office;

    private String status;
    private Timestamp timestamp;
    private String remarks;
}
