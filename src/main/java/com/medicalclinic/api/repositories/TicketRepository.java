package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
