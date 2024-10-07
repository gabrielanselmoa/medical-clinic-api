package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.medChart.MedChart;
import com.medicalclinic.api.domain.medChart.MedChartDTO;
import com.medicalclinic.api.repositories.MedChartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MedChartService {

    private MedChartRepository repository;

    @Autowired
    public MedChartService(MedChartRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<MedChartDTO> findAll(Pageable pageable){
        Page<MedChart> list = repository.findAll(pageable);
        return list.map(x -> new MedChartDTO(x));
    }

    @Transactional(readOnly = true)
    public MedChart findById(Long id){
        Optional<MedChart> medChart = repository.findById(id);
        return medChart.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
