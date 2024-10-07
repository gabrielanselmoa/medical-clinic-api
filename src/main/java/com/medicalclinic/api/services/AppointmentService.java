package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.appointment.AppointmentPatientTicketActive;
import com.medicalclinic.api.domain.appointment.AppointmentRequestDTO;
import com.medicalclinic.api.domain.appointment.AppointmentResponseDTO;
import com.medicalclinic.api.domain.exam.Exam;
import com.medicalclinic.api.domain.medChart.MedChart;
import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private AppointmentRepository repository;
    private PersonRepository personRepository;
    private TicketRepository ticketRepository;
    private PaymentRepository paymentRepository;
    private MedChartRepository medChartRepository;
    private  ExamRepository examRepository;

    @Autowired
    public AppointmentService(AppointmentRepository repository, PersonRepository personRepository, TicketRepository ticketRepository, PaymentRepository paymentRepository, MedChartRepository medChartRepository, ExamRepository examRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
        this.medChartRepository = medChartRepository;
        this.examRepository = examRepository;
    }

    @Transactional(readOnly = true)
    public Page<AppointmentResponseDTO> findAll(Pageable pageable){
        Page<Appointment> list = repository.findAll(pageable);
        return list.map(x -> new AppointmentResponseDTO(x));
    }

    @Transactional(readOnly = true)
    public Appointment findById(Long id) {
        Optional<Appointment> appointment = repository.findById(id);
        return appointment.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public AppointmentResponseDTO startAppointment(UUID ticketID, AppointmentRequestDTO dto) {

        var ticket = ticketRepository.findById(ticketID).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));

        var appointment = getAppointment(ticket);

        MedChart medChart = new MedChart();

        medChart.setSymptoms(dto.getMedChart().getSymptoms());
        medChart.setHeight(dto.getMedChart().getHeight());
        medChart.setWeight(dto.getMedChart().getWeight());
        medChart.setPressure(dto.getMedChart().getPressure());

        var medChartSaved = medChartRepository.save(medChart);

        List<Exam> exams = dto.getExams().stream().map(item -> new Exam(item.getName(), item.getType())).collect(Collectors.toList());

        List<Exam> examsListSaved = examRepository.saveAll(exams);

        appointment.setMedChart(medChartSaved);
        appointment.getExams().addAll(examsListSaved);
        appointment.setAppointmentType(dto.getAppointmentType());

        return new AppointmentResponseDTO(appointment);
    }

    private Appointment getAppointment(Ticket ticket) {

        Appointment appointment = repository.findByTicket(ticket);

        return appointment;
    }

    public List<AppointmentPatientTicketActive> findAllAppointmentsWithActiveTickets() {

        List<Appointment> appointments = repository.findAllAppointmentsWithActiveTickets();

        return appointments.stream()
                .map(AppointmentPatientTicketActive::new)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
