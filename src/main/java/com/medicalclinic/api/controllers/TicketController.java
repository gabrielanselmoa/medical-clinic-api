package com.medicalclinic.api.controllers;

import com.medicalclinic.api.services.AdressService;
import com.medicalclinic.api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService service;

    @Autowired
    public TicketController(TicketService service) {
        this.service = service;
    }
}
