package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.medChart.MedChart;
import com.medicalclinic.api.repositories.MedChartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedChartService {

    private MedChartRepository repository;

    @Autowired
    public MedChartService(MedChartRepository repository) {
        this.repository = repository;
    }

    public MedChart findById(Long id){
        Optional<MedChart> medChart = repository.findById(id);
        return medChart.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
