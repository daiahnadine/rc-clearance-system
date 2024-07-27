package com.example.clearance.system.repository.admin;

import com.example.clearance.system.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
