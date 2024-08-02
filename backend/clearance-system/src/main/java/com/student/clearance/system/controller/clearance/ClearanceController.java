package com.student.clearance.system.controller.clearance;

import com.student.clearance.system.domain.clearance.Clearance;
import com.student.clearance.system.service.clearance.ClearanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clearance")
public class ClearanceController {

    private final ClearanceService clearanceService;

    @Autowired
    public ClearanceController(ClearanceService clearanceService) {
        this.clearanceService = clearanceService;
    }

    @GetMapping("/clearances")
    public ResponseEntity<List<Clearance>> getAllClearances() {
        return new ResponseEntity<>(clearanceService.getAllClearances(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clearance>> getClearanceById(@PathVariable Long id) {
        Optional<Clearance> clearance = clearanceService.getClearanceById(id);
        return new ResponseEntity<>(clearance, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addClearance(@RequestBody Clearance clearance) {
        try {
            clearanceService.addClearance(clearance);
            return new ResponseEntity<>("Clearance successfully added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateClearance")
    public ResponseEntity<String> updateClearance(@RequestBody Clearance clearance) {
        Clearance updatedClearance = clearanceService.updateClearance(clearance);
        if (updatedClearance != null) {
            return new ResponseEntity<>("Clearance successfully updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Clearance not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClearance(@PathVariable Long id) {
        try {
            Optional<Clearance> clearanceOptional = clearanceService.getClearanceById(id);

            if (clearanceOptional.isPresent()) {
                clearanceService.deleteClearance(id);
                return new ResponseEntity<>("Clearance successfully deleted", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Clearance not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
