package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.DoctorService;
import com.medicalclinic.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }
}
