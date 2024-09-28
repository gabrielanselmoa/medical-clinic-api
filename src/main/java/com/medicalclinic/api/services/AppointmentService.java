package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.appointment.AppointmentPatientTicketActive;
import com.medicalclinic.api.domain.appointment.AppointmentRequestDTO;
import com.medicalclinic.api.domain.appointment.AppointmentResponseDTO;
import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository repository;
    private PersonRepository personRepository;
    private TicketRepository ticketRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository repository, PersonRepository personRepository, TicketRepository ticketRepository, PaymentRepository paymentRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
    }

    public Appointment findById(Long id){
        Optional<Appointment> appointment = repository.findById(id);
        return appointment.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto){
        var appointment = new Appointment();

        var patient = (Patient) personRepository.findById(dto.getPatientId()).orElseThrow(() -> new EntityNotFoundException("Patient not found!"));
        var doctor = (Doctor) personRepository.findById(dto.getDoctorId()).orElseThrow(() -> new EntityNotFoundException("Doctor not found!"));

        var payment = new Payment();
        var paymentSaved = paymentRepository.save(payment);

        var ticket = new Ticket();
        var ticketSaved = ticketRepository.save(ticket);

        appointment.setDate(LocalDate.now());
        appointment.setDescription(dto.getDescription());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setTicket(ticketSaved);
        appointment.setPayment(paymentSaved);

        return new AppointmentResponseDTO(appointment);
    }

    public List<AppointmentPatientTicketActive>  findAllAppointmentsWithActiveTickets() {

        List<Appointment> appointments = repository.findAllAppointmentsWithActiveTickets();

        return appointments.stream()
                .map(AppointmentPatientTicketActive::new)
                .toList();
    }
}
