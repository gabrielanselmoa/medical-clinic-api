package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.exam.ExamDTO;
import com.medicalclinic.api.services.ExamService;
import com.medicalclinic.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private ExamService service;

    @Autowired
    public ExamController(ExamService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ExamDTO>> findAll(Pageable pageable) {
        Page<ExamDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
