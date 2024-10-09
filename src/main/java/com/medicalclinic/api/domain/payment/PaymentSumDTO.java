package com.medicalclinic.api.domain.payment;

public class PaymentSumDTO {

    private Double totalSum;

    public PaymentSumDTO(){}

    public PaymentSumDTO(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }
}
