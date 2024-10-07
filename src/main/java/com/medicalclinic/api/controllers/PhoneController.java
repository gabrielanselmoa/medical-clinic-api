package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.payment.PaymentDTO;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.services.PersonService;
import com.medicalclinic.api.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private PhoneService service;

    @Autowired
    public PhoneController(PhoneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<PhoneDTO>> findAll(Pageable pageable) {
        Page<PhoneDTO> page = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
