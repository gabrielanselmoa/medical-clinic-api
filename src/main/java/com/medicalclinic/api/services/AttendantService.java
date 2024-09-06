package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.attendant.Attendant;
import com.medicalclinic.api.repositories.AttendantRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendantService {

    private AttendantRepository repository;

    @Autowired
    public AttendantService(AttendantRepository repository) {
        this.repository = repository;
    }

    public List<Attendant> findAll(){
        return repository.findAll();
    }

    public Attendant findById(Long id){
        Optional<Attendant> attendant = repository.findById(id);
        return attendant.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
