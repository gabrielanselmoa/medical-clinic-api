package com.medicalclinic.api.domain.ticket;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Instant created_at;

    private Instant expire_in;

    public Ticket() {
    }

    public Ticket(UUID id, Instant created_at, Instant expire_in) {
        this.id = id;
        this.created_at = created_at;
        this.expire_in = expire_in;
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

    @PrePersist
    public void setInstant() {
        Instant now = Instant.now();
        setCreated_at(now);

        Instant expireAt = now.plus(5, java.time.temporal.ChronoUnit.HOURS);
        setExpire_in(expireAt);
    }

    public Instant getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(Instant expire_in) {
        this.expire_in = expire_in;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String getFormattedCreatedAt() {
        ZonedDateTime createdAtZoned = ZonedDateTime.ofInstant(created_at, ZoneId.of("America/Sao_Paulo"));
        return createdAtZoned.format(formatter);
    }

    public String getFormattedExpireIn() {
        ZonedDateTime expireInZoned = ZonedDateTime.ofInstant(expire_in, ZoneId.of("America/Sao_Paulo"));
        return expireInZoned.format(formatter);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
