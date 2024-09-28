package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.specialty.SpecialtyDTO;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping
    public ResponseEntity<SpecialtyDTO> create(@RequestBody SpecialtyDTO dto) {
        var res = service.createSpecialty(dto);
        return ResponseEntity.ok(res);
    }
}
