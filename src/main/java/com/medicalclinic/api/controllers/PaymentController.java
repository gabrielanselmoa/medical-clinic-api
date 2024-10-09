package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.payment.PaymentDTO;
import com.medicalclinic.api.domain.payment.PaymentSumDTO;
import com.medicalclinic.api.services.PaymentService;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<PaymentDTO>> findAll(Pageable pageable) {
        Page<PaymentDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping(value = "/sum/{beginDate}/{finishDate}")
    public ResponseEntity<PaymentSumDTO> getPaymentSumByDate(@PathVariable String beginDate, @PathVariable String finishDate){
        PaymentSumDTO result = service.getPaymentSumByDate(beginDate, finishDate);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
