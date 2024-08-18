package com.student.clearance.system.controller.clearanceRequest;

import com.student.clearance.system.domain.clearanceRequest.ClearanceRequest;
import com.student.clearance.system.domain.statusUpdateRequest.StatusUpdateRequest;
import com.student.clearance.system.service.clearanceRequest.ClearanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Requests")
public class ClearanceRequestController {

    private final ClearanceRequestService clearanceRequestService;

    @Autowired
    public ClearanceRequestController(ClearanceRequestService clearanceRequestService) {
        this.clearanceRequestService = clearanceRequestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClearanceRequest>> getAllClearanceRequests() {
        List<ClearanceRequest> requests = clearanceRequestService.getAllClearanceRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ClearanceRequest>> getClearanceRequestsByStatus(@PathVariable ClearanceRequest.Status status) {
        List<ClearanceRequest> requests = clearanceRequestService.getClearanceRequestsByStatus(status);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClearanceRequest> getClearanceRequestById(@PathVariable Long id) {
        Optional<ClearanceRequest> request = clearanceRequestService.getClearanceRequestById(id);
        return request.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/student/name/{name}")
    public ResponseEntity<List<ClearanceRequest>> getClearanceRequestsByStudentName(@PathVariable String name) {
        List<ClearanceRequest> requests = clearanceRequestService.getClearanceRequestsByStudentName(name);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addClearanceRequest(@RequestBody ClearanceRequest clearanceRequest) {
        try {
            clearanceRequestService.addClearanceRequest(clearanceRequest);
            return new ResponseEntity<>("Clearance request successfully added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance request cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClearanceRequest(@PathVariable Long id, @RequestBody ClearanceRequest clearanceRequestDetails) {
        try {
            Optional<ClearanceRequest> requestOptional = clearanceRequestService.getClearanceRequestById(id);

            if (requestOptional.isPresent()) {
                ClearanceRequest clearanceRequest = requestOptional.get();
                clearanceRequest.setStudent(clearanceRequestDetails.getStudent());
                clearanceRequest.setStatus(clearanceRequestDetails.getStatus());
                clearanceRequest.setRemarks(clearanceRequestDetails.getRemarks());

                clearanceRequestService.updateClearanceRequest(clearanceRequest);
                return new ResponseEntity<>("Clearance request successfully updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Clearance request not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance request cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClearanceRequest(@PathVariable Long id) {
        try {
            Optional<ClearanceRequest> requestOptional = clearanceRequestService.getClearanceRequestById(id);

            if (requestOptional.isPresent()) {
                clearanceRequestService.deleteClearanceRequest(id);
                return new ResponseEntity<>("Clearance request successfully deleted", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Clearance request not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Clearance request cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
