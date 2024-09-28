package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> findAll(){
        List<Payment> list = repository.findAll();
        return list;
    }

    public Payment findById(UUID id){
        Optional<Payment> payment = repository.findById(id);
        return payment.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
