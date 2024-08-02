package com.student.clearance.system.controller.registrar;

import com.student.clearance.system.domain.registrar.Registrar;
import com.student.clearance.system.service.registrar.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Registrar")
public class RegistrarController {

    private final RegistrarService registrarService;

    @Autowired
    public RegistrarController(RegistrarService registrarService) {
        this.registrarService = registrarService;
    }

    @GetMapping("/registrars")
    public ResponseEntity<List<Registrar>> getAllRegistrars() {
        return new ResponseEntity<>(registrarService.getAllRegistrars(), HttpStatus.OK);
    }
}
