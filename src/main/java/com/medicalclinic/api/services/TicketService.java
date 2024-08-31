package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }
}
