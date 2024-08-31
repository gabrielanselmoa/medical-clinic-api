package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.MedChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedChartService {

    private MedChartRepository repository;

    @Autowired
    public MedChartService(MedChartRepository repository) {
        this.repository = repository;
    }
}
