package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.PatientService;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }
}
