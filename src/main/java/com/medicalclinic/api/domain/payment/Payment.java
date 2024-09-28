package com.medicalclinic.api.domain.payment;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String type;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public Payment() {
    }

    public Payment(UUID id, String type, BigDecimal total, BigDecimal subTotal, BigDecimal discount, PaymentStatus status) {
        this.id = id;
        this.type = type;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void setStatus(String status) {
        this.status = PaymentStatus.valueOf(status);
    }

    public BigDecimal calcTotal(BigDecimal subTotal, BigDecimal discount) {

        if (subTotal == null || discount == null) {
            return null;
        }

        if (subTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }

        if (discount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Discount cannot be negative");
        }

        BigDecimal discountAmount = subTotal.multiply(discount).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);

        BigDecimal total = subTotal.subtract(discountAmount);

        return total.max(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
