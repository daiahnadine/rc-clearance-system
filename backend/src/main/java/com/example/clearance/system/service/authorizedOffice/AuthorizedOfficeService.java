package com.example.clearance.system.service.authorizedOffice;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;

import java.util.List;
import java.util.Optional;

public interface AuthorizedOfficeService {
    List<AuthorizedOffice> getAllAuthorizedOffices();
    Optional<AuthorizedOffice> getAuthorizedOfficeById(Long id);
    AuthorizedOffice addAuthorizedOffice(AuthorizedOffice authorizedOffice);
    AuthorizedOffice updateAuthorizedOffice(AuthorizedOffice authorizedOffice);
    void deleteAuthorizedOffice(Long id);
}
