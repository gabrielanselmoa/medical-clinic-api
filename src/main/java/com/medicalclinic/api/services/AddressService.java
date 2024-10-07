package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.exceptions.EntityNotFoundException;
import com.medicalclinic.api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;
    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAll(Pageable pageable) {
        Page<Address> address = repository.findAll(pageable);
        return address.map(x -> new AddressDTO(x));
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) throws EntityNotFoundException {
        Optional<Address> address = repository.findById(id);
        if (address.isEmpty()){
            throw new EntityNotFoundException("Entity not found!");
        }
        return new AddressDTO(address.get());
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


//    @Transactional(readOnly = true)
//    public Page<ProductMinDTO> findAllProducts(String name, String category, Pageable pageable) {
//        return productRepository.searchByNameProduct(name, category, pageable);
//    }
}
