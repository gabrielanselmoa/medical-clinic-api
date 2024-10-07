package com.medicalclinic.api.domain.appointment;

import com.medicalclinic.api.domain.exam.ExamDTO;
import com.medicalclinic.api.domain.medChart.MedChartDTO;
import com.medicalclinic.api.domain.payment.PaymentDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AppointmentRequestDTO {

    private String description;
    private MedChartDTO medChart;
    private Set<ExamDTO> exams = new HashSet<>();
    private AppointmentType appointmentType;

    public AppointmentRequestDTO(){}

    public AppointmentRequestDTO(String description, MedChartDTO medChart, Set<ExamDTO> exams, AppointmentType appointmentType) {
        this.description = description;
        this.medChart = medChart;
        this.exams = exams;
        this.appointmentType = appointmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public MedChartDTO getMedChart() {
        return medChart;
    }

    public void setMedChart(MedChartDTO medChart) {
        this.medChart = medChart;
    }


    public Set<ExamDTO> getExams() {
        return exams;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }
}
