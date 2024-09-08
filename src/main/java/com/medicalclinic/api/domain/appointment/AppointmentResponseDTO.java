package com.medicalclinic.api.domain.appointment;

import com.medicalclinic.api.domain.doctor.DoctorResponseDTO;
import com.medicalclinic.api.domain.exam.ExamDTO;
import com.medicalclinic.api.domain.medChart.MedChartDTO;
import com.medicalclinic.api.domain.patient.PatientResponseDTO;
import com.medicalclinic.api.domain.payment.PaymentDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AppointmentResponseDTO {

    private Long id;
    private LocalDate date;
    private String description;

    private PatientResponseDTO patient;
    private DoctorResponseDTO doctor;
    private MedChartDTO medChart;
    private PaymentDTO payment;
    private Set<ExamDTO> exams = new HashSet<>();

    public AppointmentResponseDTO(){}

    public AppointmentResponseDTO(Long id, LocalDate date, String description, PatientResponseDTO patient, DoctorResponseDTO doctor, MedChartDTO medChart, PaymentDTO payment, Set<ExamDTO> exams) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.medChart = medChart;
        this.payment = payment;
        this.exams = exams;
    }

    public AppointmentResponseDTO(Appointment appointment){
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.description = appointment.getDescription();
        this.patient = new PatientResponseDTO(appointment.getPatient());
        this.doctor = new DoctorResponseDTO(appointment.getDoctor());
        this.medChart = new MedChartDTO(appointment.getMedChart());
        this.payment = new PaymentDTO(appointment.getPayment());
        this.exams = appointment.getExams().stream().map(x -> new ExamDTO(x)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientResponseDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientResponseDTO patient) {
        this.patient = patient;
    }

    public DoctorResponseDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorResponseDTO doctor) {
        this.doctor = doctor;
    }

    public MedChartDTO getMedChart() {
        return medChart;
    }

    public void setMedChart(MedChartDTO medChart) {
        this.medChart = medChart;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public Set<ExamDTO> getExams() {
        return exams;
    }
}
