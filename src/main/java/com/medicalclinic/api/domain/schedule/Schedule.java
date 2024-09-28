package com.medicalclinic.api.domain.schedule;


import com.medicalclinic.api.domain.payment.PaymentStatus;

import java.math.BigDecimal;

public class Schedule {

    private Long doctorId;
    private Long patientId;
    private Long attendantId;
    private String type;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal total;
    private String status;

    public Schedule() {
    }

    public Schedule(Long doctorId, Long patientId, Long attendantId, String type, BigDecimal subTotal, BigDecimal discount, BigDecimal total, String status) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.attendantId = attendantId;
        this.type = type;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
        this.status = status;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(Long attendantId) {
        this.attendantId = attendantId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
