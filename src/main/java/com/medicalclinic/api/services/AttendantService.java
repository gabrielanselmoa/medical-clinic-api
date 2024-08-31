package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AttendantRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendantService {

    private AttendantRepository repository;

    @Autowired
    public AttendantService(AttendantRepository repository) {
        this.repository = repository;
    }
}
