package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.ExamService;
import com.medicalclinic.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private ExamService service;

    @Autowired
    public ExamController(ExamService service) {
        this.service = service;
    }
}
