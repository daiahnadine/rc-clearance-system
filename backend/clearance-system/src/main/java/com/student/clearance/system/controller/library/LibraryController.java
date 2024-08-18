package com.student.clearance.system.controller.library;

import com.student.clearance.system.domain.library.Library;
import com.student.clearance.system.service.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/libraries")
    public ResponseEntity<List<Library>> getAllLibraries() {
        return new ResponseEntity<>(libraryService.getAllLibraries(), HttpStatus.OK);
    }

    @GetMapping("/libraries/count")
    public ResponseEntity<Integer> getLibraryCount() {
        int count = libraryService.getLibraryCount();
        return ResponseEntity.ok(count);
    }
}
