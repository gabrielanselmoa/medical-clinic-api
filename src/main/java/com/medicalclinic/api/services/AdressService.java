package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.AddressRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    private AddressRepository repository;

    @Autowired
    public AdressService(AddressRepository repository) {
        this.repository = repository;
    }
}
