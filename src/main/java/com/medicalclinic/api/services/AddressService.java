package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


//    @Transactional(readOnly = true)
//    public Page<ProductMinDTO> findAllProducts(String name, String category, Pageable pageable) {
//        return productRepository.searchByNameProduct(name, category, pageable);
//    }
}
