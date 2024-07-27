package com.example.clearance.system.repository.clearance;

import com.example.clearance.system.domain.clearance.Clearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearanceRepository extends JpaRepository<Clearance, Long> {

}
