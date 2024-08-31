package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.AdressService;
import com.medicalclinic.api.services.MedChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medchart")
public class MedChartController {

    private MedChartService service;

    @Autowired
    public MedChartController(MedChartService service) {
        this.service = service;
    }
}
