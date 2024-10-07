package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.payment.PaymentDTO;
import com.medicalclinic.api.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<PaymentDTO> findAll(Pageable pageable){
        Page<Payment> list = repository.findAll(pageable);
        return list.map(x -> new PaymentDTO(x));
    }

    @Transactional(readOnly = true)
    public Payment findById(UUID id){
        Optional<Payment> payment = repository.findById(id);
        return payment.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
