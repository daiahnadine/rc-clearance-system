package com.student.clearance.system.controller.dean;

import com.student.clearance.system.domain.dean.Dean;
import com.student.clearance.system.service.dean.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dean")
public class DeanController {

    private final DeanService deanService;

    @Autowired
    public DeanController(DeanService deanService) {
        this.deanService = deanService;
    }

    @GetMapping("/deans")
    public ResponseEntity<List<Dean>> getAllDeans() {
        return new ResponseEntity<>(deanService.getAllDeans(), HttpStatus.OK);
    }
}
