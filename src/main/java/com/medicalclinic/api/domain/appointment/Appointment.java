package com.medicalclinic.api.domain.appointment;

import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.domain.exam.Exam;
import com.medicalclinic.api.domain.medChart.MedChart;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.ticket.Ticket;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String description;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "med_chart_id")
    private MedChart medChart;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private Payment payment;

    @OneToMany
    private Set<Exam> exams = new HashSet<>();


    public Appointment() {
    }

    public Appointment(Long id, LocalDate date, String description, Patient patient, Doctor doctor, MedChart medChart, Ticket ticket, Payment payment, Set<Exam> exams) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.medChart = medChart;
        this.ticket = ticket;
        this.payment = payment;
        this.exams = exams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public MedChart getMedChart() {
        return medChart;
    }

    public void setMedChart(MedChart medChart) {
        this.medChart = medChart;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}