package com.example.clearance.system.repository.authorizedOffice;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizedOfficeRepository extends JpaRepository<AuthorizedOffice, Long> {

}
