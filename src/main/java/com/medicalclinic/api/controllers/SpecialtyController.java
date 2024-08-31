package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.DoctorService;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    private SpecialtyService service;

    @Autowired
    public SpecialtyController(SpecialtyService service) {
        this.service = service;
    }
}
