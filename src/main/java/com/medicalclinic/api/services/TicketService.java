package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    private TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket findById(UUID id){
        Optional<Ticket> address = repository.findById(id);
        return address.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
