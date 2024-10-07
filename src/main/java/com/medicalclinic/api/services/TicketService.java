package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.domain.ticket.TicketDTO;
import com.medicalclinic.api.repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    private TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<TicketDTO> findAll(Pageable pageable){
        Page<Ticket> list = repository.findAll(pageable);
        return list.map(x -> new TicketDTO(x));
    }

    @Transactional(readOnly = true)
    public TicketDTO findById(UUID id){
        Optional<Ticket> ticket = repository.findById(id);
        if (ticket.isEmpty()){
            throw new EntityNotFoundException("Entity not found!");
        }
        return new TicketDTO(ticket.get());
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
