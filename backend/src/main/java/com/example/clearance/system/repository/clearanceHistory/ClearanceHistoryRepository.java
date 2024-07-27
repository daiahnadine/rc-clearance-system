package com.example.clearance.system.repository.clearanceHistory;

import com.example.clearance.system.domain.clearanceHistory.ClearanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearanceHistoryRepository extends JpaRepository<ClearanceHistory, Long> {

}
