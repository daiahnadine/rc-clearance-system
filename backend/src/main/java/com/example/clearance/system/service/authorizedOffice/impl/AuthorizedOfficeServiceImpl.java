package com.example.clearance.system.service.authorizedOffice.impl;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;
import com.example.clearance.system.repository.authorizedOffice.AuthorizedOfficeRepository;
import com.example.clearance.system.service.authorizedOffice.AuthorizedOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizedOfficeServiceImpl implements AuthorizedOfficeService {

    private final AuthorizedOfficeRepository authorizedOfficeRepository;

    @Autowired
    public AuthorizedOfficeServiceImpl(AuthorizedOfficeRepository authorizedOfficeRepository) {
        this.authorizedOfficeRepository = authorizedOfficeRepository;
    }

    @Override
    public List<AuthorizedOffice> getAllAuthorizedOffices() {
        return authorizedOfficeRepository.findAll();
    }

    @Override
    public Optional<AuthorizedOffice> getAuthorizedOfficeById(Long id) {
        return authorizedOfficeRepository.findById(id);
    }

    @Override
    public AuthorizedOffice addAuthorizedOffice(AuthorizedOffice authorizedOffice) {
        return authorizedOfficeRepository.save(authorizedOffice);
    }

    @Override
    public AuthorizedOffice updateAuthorizedOffice(AuthorizedOffice authorizedOffice) {
        return authorizedOfficeRepository.save(authorizedOffice);
    }

    @Override
    public void deleteAuthorizedOffice(Long id) {
        authorizedOfficeRepository.deleteById(id);
    }
}
