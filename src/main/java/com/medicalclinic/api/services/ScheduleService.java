package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.attendant.Attendant;
import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.schedule.Schedule;
import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.repositories.PaymentRepository;
import com.medicalclinic.api.repositories.PersonRepository;
import com.medicalclinic.api.repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScheduleService {


    private PersonRepository personRepository;
    private TicketRepository ticketRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public ScheduleService(PersonRepository personRepository, TicketRepository ticketRepository, PaymentRepository paymentRepository) {
        this.personRepository = personRepository;
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Ticket createSchedule(Schedule schedule) {

        Appointment appointment = new Appointment();

        Payment payment = new Payment();

        payment.setType(schedule.getType());
        payment.setSubTotal(schedule.getSubTotal());
        payment.setDiscount(schedule.getDiscount());
        var totalTemp = payment.calcTotal(schedule.getSubTotal(), schedule.getDiscount());
        payment.setTotal(totalTemp);
        payment.setStatus(schedule.getStatus());

        var paymentSaved = paymentRepository.save(payment);

        Ticket ticket = new Ticket();
        var ticketSaved = ticketRepository.save(ticket);

        var patient = (Patient) personRepository.findById(schedule.getPatientId()).orElseThrow(() -> new EntityNotFoundException("Patient not found!"));
        var doctor = (Doctor) personRepository.findById(schedule.getDoctorId()).orElseThrow(() -> new EntityNotFoundException("Doctor not found!"));
        var attendant = (Attendant) personRepository.findById(schedule.getAttendantId()).orElseThrow(() -> new EntityNotFoundException("Attendant not found!"));

        appointment.setDate(LocalDate.now());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAttendant(attendant);
        appointment.setTicket(ticketSaved);
        appointment.setPayment(paymentSaved);

        doctor.getAppointments().add(appointment);

        personRepository.save(doctor);

        return ticketSaved;
    }

}
