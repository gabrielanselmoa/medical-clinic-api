package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

//    @Query(nativeQuery = true, value = "SELECT * " +
//            "FROM payment " +
//            "WHERE payment.payment_date IS NOT NULL " +
//            "AND payment.payment_date >= NOW() - INTERVAL '?1'")
//    Payment getByPaymentDate(String number);

    @Query(value = "SELECT SUM(p.total) " +
            "FROM Payment p " +
            "WHERE p.paymentDate IS NOT NULL " +
            "AND p.paymentDate BETWEEN :beginDate AND :finishDate")
    Double getPaymentSumByDate(LocalDate beginDate, LocalDate finishDate);

}
