package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.phone.Phone;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.repositories.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PhoneService {

    private PhoneRepository repository;

    @Autowired
    public PhoneService(PhoneRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<PhoneDTO> findAll(Pageable pageable){
        Page<Phone> list = repository.findAll(pageable);
        return list.map(x -> new PhoneDTO(x));
    }

    @Transactional(readOnly = true)
    public Phone findById(Long id){
        Optional<Phone> phone = repository.findById(id);
        return phone.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
