package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT ap FROM Appointment ap WHERE ap.ticket.expire_in > CURRENT_TIMESTAMP")
    List<Appointment> findAllAppointmentsWithActiveTickets();
}
