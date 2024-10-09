package com.medicalclinic.api.domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDTO {

    private UUID id;
    private LocalDate paymentDate;
    private String type;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal total;

    private PaymentStatus status;

    public PaymentDTO(){}

    public PaymentDTO(UUID id, LocalDate paymentDate, String type, BigDecimal subTotal, BigDecimal discount, BigDecimal total, PaymentStatus status) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.type = type;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
        this.status = status;
    }

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.paymentDate = payment.getPaymentDate();
        this.type = payment.getType();
        this.subTotal = payment.getSubTotal();
        this.discount = payment.getDiscount();
        this.total = payment.getTotal();
        this.status = payment.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
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

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
