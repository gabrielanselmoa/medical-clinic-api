package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.DoctorRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private DoctorRepository repository;

    @Autowired
    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }
}
