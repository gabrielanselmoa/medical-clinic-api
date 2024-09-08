package com.medicalclinic.api.domain.medChart;

public class MedChartDTO {

    private Long id;
    private String symptoms;
    private Double weight;
    private Double height;
    private Double pressure;

    public MedChartDTO(){}

    public MedChartDTO(Long id, String symptoms, Double weight, Double height, Double pressure) {
        this.id = id;
        this.symptoms = symptoms;
        this.weight = weight;
        this.height = height;
        this.pressure = pressure;
    }

    public MedChartDTO(MedChart medChart) {
        this.id = medChart.getId();
        this.symptoms = medChart.getSymptoms();
        this.weight = medChart.getWeight();
        this.height = medChart.getHeight();
        this.pressure = medChart.getPressure();
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
}
