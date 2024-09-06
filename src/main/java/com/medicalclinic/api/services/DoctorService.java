package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.repositories.DoctorRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository repository;

    @Autowired
    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor findById(Long id){
        Optional<Doctor> doctor = repository.findById(id);
        return doctor.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
