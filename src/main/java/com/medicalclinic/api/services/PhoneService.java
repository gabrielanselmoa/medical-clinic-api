package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.phone.Phone;
import com.medicalclinic.api.repositories.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService {

    private PhoneRepository repository;

    @Autowired
    public PhoneService(PhoneRepository repository) {
        this.repository = repository;
    }

    public Phone findById(Long id){
        Optional<Phone> phone = repository.findById(id);
        return phone.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
