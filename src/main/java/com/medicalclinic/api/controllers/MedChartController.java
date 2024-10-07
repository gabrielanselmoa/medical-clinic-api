package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.medChart.MedChartDTO;
import com.medicalclinic.api.services.MedChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medchart")
public class MedChartController {

    private MedChartService service;

    @Autowired
    public MedChartController(MedChartService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<MedChartDTO>> findAll(Pageable pageable) {
        Page<MedChartDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
