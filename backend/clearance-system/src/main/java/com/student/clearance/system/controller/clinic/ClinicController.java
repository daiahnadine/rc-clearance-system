package com.student.clearance.system.controller.clinic;

import com.student.clearance.system.domain.clinic.Clinic;
import com.student.clearance.system.service.clinic.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clinic")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/clinics")
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return new ResponseEntity<>(clinicService.getAllClinics(), HttpStatus.OK);
    }
}
