package com.student.clearance.system.controller.adviser;

import com.student.clearance.system.domain.adviser.Adviser;
import com.student.clearance.system.service.adviser.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Adviser")
public class AdviserController {

    private final AdviserService adviserService;

    @Autowired
    public AdviserController(AdviserService adviserService) {
        this.adviserService = adviserService;
    }

    @GetMapping("/advisers")
    public ResponseEntity<List<Adviser>> getAllAdvisers() {
        return new ResponseEntity<>(adviserService.getAllAdvisers(), HttpStatus.OK);
    }

    @GetMapping("/advisers/count")
    public ResponseEntity<Integer> getAdviserCount() {
        int count = adviserService.getAdviserCount();
        return ResponseEntity.ok(count);
    }
}
