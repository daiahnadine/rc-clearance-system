package com.student.clearance.system.controller.clearanceStatus;

import com.student.clearance.system.domain.clearanceStatus.ClearanceStatus;
import com.student.clearance.system.service.clearanceStatus.ClearanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clearance-status")
public class ClearanceStatusController {

    private final ClearanceStatusService clearanceStatusService;

    @Autowired
    public ClearanceStatusController(ClearanceStatusService clearanceStatusService) {
        this.clearanceStatusService = clearanceStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClearanceStatus>> getAllClearanceStatuses() {
        List<ClearanceStatus> statuses = clearanceStatusService.getAllClearanceStatuses();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClearanceStatus>> getClearanceStatusById(@PathVariable Long id) {
        Optional<ClearanceStatus> status = clearanceStatusService.getClearanceStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addClearanceStatus(@RequestBody ClearanceStatus clearanceStatus) {
        try {
            clearanceStatusService.addClearanceStatus(clearanceStatus);
            return new ResponseEntity<>("Clearance status successfully added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance status cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClearanceStatus(@PathVariable Long id, @RequestBody ClearanceStatus clearanceStatusDetails) {
        try {
            Optional<ClearanceStatus> statusOptional = clearanceStatusService.getClearanceStatusById(id);

            if (statusOptional.isPresent()) {
                ClearanceStatus clearanceStatus = statusOptional.get();
                clearanceStatus.setClearance(clearanceStatusDetails.getClearance());
                clearanceStatus.setStatus(clearanceStatusDetails.getStatus());
                clearanceStatus.setReason(clearanceStatusDetails.getReason());

                clearanceStatusService.updateClearanceStatus(clearanceStatus);
                return new ResponseEntity<>("Clearance status successfully updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Clearance status not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance status cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClearanceStatus(@PathVariable Long id) {
        try {
            Optional<ClearanceStatus> statusOptional = clearanceStatusService.getClearanceStatusById(id);

            if (statusOptional.isPresent()) {
                clearanceStatusService.deleteClearanceStatus(id);
                return new ResponseEntity<>("Clearance status successfully deleted", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Clearance status not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance status cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
