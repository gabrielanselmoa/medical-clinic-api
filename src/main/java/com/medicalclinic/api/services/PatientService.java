package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.PatientRepository;
import com.medicalclinic.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }
}
