package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }
}
