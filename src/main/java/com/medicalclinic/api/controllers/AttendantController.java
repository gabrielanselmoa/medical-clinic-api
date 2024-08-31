package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.AttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendant")
public class AttendantController {

    private AttendantService service;

    @Autowired
    public AttendantController(AttendantService service) {
        this.service = service;
    }
}
