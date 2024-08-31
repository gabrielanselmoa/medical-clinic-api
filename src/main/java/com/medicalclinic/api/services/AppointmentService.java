package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }
}
