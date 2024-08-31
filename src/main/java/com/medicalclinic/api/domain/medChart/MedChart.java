package com.medicalclinic.api.domain.medChart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class MedChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symptoms;
    private Double weight;
    private Double height;
    private Double pressure;

    public MedChart() {
    }

    public MedChart(Long id, String symptoms, Double pressure, Double height, Double weight) {
        this.id = id;
        this.symptoms = symptoms;
        this.pressure = pressure;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedChart medChart = (MedChart) o;
        return Objects.equals(id, medChart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
