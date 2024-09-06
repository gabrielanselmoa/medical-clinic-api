package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.specialty.Specialty;
import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    private SpecialtyRepository repository;

    @Autowired
    public SpecialtyService(SpecialtyRepository repository) {
        this.repository = repository;
    }

    public Specialty findById(Long id){
        Optional<Specialty> specialty = repository.findById(id);
        return specialty.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
