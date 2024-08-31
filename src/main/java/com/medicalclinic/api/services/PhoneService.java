package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.PatientRepository;
import com.medicalclinic.api.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private PhoneRepository repository;

    @Autowired
    public PhoneService(PhoneRepository repository) {
        this.repository = repository;
    }
}
