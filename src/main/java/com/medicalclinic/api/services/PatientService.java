package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.repositories.PatientRepository;
import com.medicalclinic.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient findById(Long id){
        Optional<Patient> patient = repository.findById(id);
        return patient.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
