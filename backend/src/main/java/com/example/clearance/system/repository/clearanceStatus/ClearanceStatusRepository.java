package com.example.clearance.system.repository.clearanceStatus;

import com.example.clearance.system.domain.clearanceStatus.ClearanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearanceStatusRepository extends JpaRepository<ClearanceStatus, Long> {

}
