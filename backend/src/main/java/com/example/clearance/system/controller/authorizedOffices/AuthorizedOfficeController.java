package com.example.clearance.system.controller.authorizedOffices;

import com.example.clearance.system.domain.authorizedOffice.AuthorizedOffice;
import com.example.clearance.system.service.authorizedOffice.AuthorizedOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Authorized")
public class AuthorizedOfficeController {

    private final AuthorizedOfficeService authorizedOfficeService;

    @Autowired
    public AuthorizedOfficeController(AuthorizedOfficeService authorizedOfficeService) {
        this.authorizedOfficeService = authorizedOfficeService;
    }

    @GetMapping("/offices")
    public ResponseEntity<List<AuthorizedOffice>> getAllAuthorizedOffices() {
        return new ResponseEntity<>(authorizedOfficeService.getAllAuthorizedOffices(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AuthorizedOffice>> getAuthorizedOfficeById(@PathVariable Long id) {
        Optional<AuthorizedOffice> office = authorizedOfficeService.getAuthorizedOfficeById(id);
        return new ResponseEntity<>(office, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addAuthorizedOffice(@RequestBody AuthorizedOffice authorizedOffice) {
        try {
            authorizedOfficeService.addAuthorizedOffice(authorizedOffice);
            return new ResponseEntity<>("Authorized Office successfully added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Authorized Office cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateOffice")
    public ResponseEntity<String> updateAuthorizedOffice(@RequestBody AuthorizedOffice authorizedOffice) {
        AuthorizedOffice updatedOffice = authorizedOfficeService.updateAuthorizedOffice(authorizedOffice);
        if (updatedOffice != null) {
            return new ResponseEntity<>("Authorized Office successfully updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authorized Office not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorizedOffice(@PathVariable Long id) {
        try {
            Optional<AuthorizedOffice> officeOptional = authorizedOfficeService.getAuthorizedOfficeById(id);

            if (officeOptional.isPresent()) {
                authorizedOfficeService.deleteAuthorizedOffice(id);
                return new ResponseEntity<>("Authorized Office successfully deleted", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Authorized Office not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Authorized Office cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
