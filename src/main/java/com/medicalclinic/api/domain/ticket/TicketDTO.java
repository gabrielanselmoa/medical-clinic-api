package com.medicalclinic.api.domain.ticket;

import java.time.Instant;
import java.util.UUID;

public class TicketDTO {

    private UUID id;
    private Instant created_at;
    private Instant expire_in;

    public TicketDTO(){}

    public TicketDTO(UUID id, Instant created_at, Instant expire_in) {
        this.id = id;
        this.created_at = created_at;
        this.expire_in = expire_in;
    }

    public TicketDTO(Ticket ticket) {
        id = ticket.getId();
        created_at = ticket.getCreated_at();
        expire_in = ticket.getExpire_in();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(Instant expire_in) {
        this.expire_in = expire_in;
    }
}
