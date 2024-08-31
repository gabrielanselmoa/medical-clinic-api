package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {

    private SpecialtyRepository repository;

    @Autowired
    public SpecialtyService(SpecialtyRepository repository) {
        this.repository = repository;
    }
}
