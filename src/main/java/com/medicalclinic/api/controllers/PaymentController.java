package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.services.PaymentService;
import com.medicalclinic.api.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        var list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
