package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.AdressService;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController {

    private AdressService service;

    @Autowired
    public AdressController(AdressService service) {
        this.service = service;
    }
}
