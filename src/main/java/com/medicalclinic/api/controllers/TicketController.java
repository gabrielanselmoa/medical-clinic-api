package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.ticket.TicketDTO;
import com.medicalclinic.api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService service;

    @Autowired
    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<TicketDTO>> findAll(Pageable pageable) {
        Page<TicketDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
