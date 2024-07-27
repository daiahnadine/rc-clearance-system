package com.example.clearance.system.domain.authorizedOffice;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class AuthorizedOffice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    private String officeName;
}
