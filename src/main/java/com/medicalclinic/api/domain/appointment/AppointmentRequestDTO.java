package com.medicalclinic.api.domain.appointment;

import com.medicalclinic.api.domain.exam.ExamDTO;
import com.medicalclinic.api.domain.medChart.MedChartDTO;
import com.medicalclinic.api.domain.payment.PaymentDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AppointmentRequestDTO {

    private LocalDate date;
    private String description;

    private Long patientId;
    private Long doctorId;
    private MedChartDTO medChart;
    private PaymentDTO payment;
    private Set<ExamDTO> exams = new HashSet<>();

    public AppointmentRequestDTO(){}

    public AppointmentRequestDTO(LocalDate date, String description, Long patientId, Long doctorId, MedChartDTO medChart, PaymentDTO payment, Set<ExamDTO> exams) {
        this.date = date;
        this.description = description;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medChart = medChart;
        this.payment = payment;
        this.exams = exams;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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
