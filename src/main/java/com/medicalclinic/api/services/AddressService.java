package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.repositories.AddressRepository;
import com.medicalclinic.api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;
    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address findById(Long id){
        Optional<Address> address = repository.findById(id);
        return address.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
