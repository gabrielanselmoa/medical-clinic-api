package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.PersonService;
import com.medicalclinic.api.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private PhoneService service;

    @Autowired
    public PhoneController(PhoneService service) {
        this.service = service;
    }
}
