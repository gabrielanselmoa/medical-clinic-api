package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.appointment.AppointmentPatientTicketActive;
import com.medicalclinic.api.domain.appointment.AppointmentRequestDTO;
import com.medicalclinic.api.domain.appointment.AppointmentResponseDTO;
import com.medicalclinic.api.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/start-appointment/{ticket}")
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@PathVariable UUID ticket, @RequestBody AppointmentRequestDTO dto){
        var app = service.startAppointment(ticket, dto);
        return ResponseEntity.status(HttpStatus.OK).body(app);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
