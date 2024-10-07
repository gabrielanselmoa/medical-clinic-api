package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.specialty.SpecialtyDTO;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    private SpecialtyService service;

    @Autowired
    public SpecialtyController(SpecialtyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<SpecialtyDTO>> findAll(Pageable pageable) {
        Page<SpecialtyDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping
    public ResponseEntity<SpecialtyDTO> create(@RequestBody SpecialtyDTO dto) {
        var res = service.createSpecialty(dto);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
