package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.appointment.AppointmentPatientTicketActive;
import com.medicalclinic.api.domain.appointment.AppointmentRequestDTO;
import com.medicalclinic.api.domain.appointment.AppointmentResponseDTO;
import com.medicalclinic.api.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentPatientTicketActive>> getAllPatientOnTicket(){
        List<AppointmentPatientTicketActive> list = service.findAllAppointmentsWithActiveTickets();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(AppointmentRequestDTO dto){
        var appointment = service.createAppointment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }
}
