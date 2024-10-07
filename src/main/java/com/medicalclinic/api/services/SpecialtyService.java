package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.specialty.Specialty;
import com.medicalclinic.api.domain.specialty.SpecialtyDTO;
import com.medicalclinic.api.repositories.SpecialtyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpecialtyService {

    private SpecialtyRepository repository;

    @Autowired
    public SpecialtyService(SpecialtyRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<SpecialtyDTO> findAll(Pageable pageable){
        Page<Specialty> list = repository.findAll(pageable);
        return list.map(x -> new SpecialtyDTO(x));
    }

    @Transactional(readOnly = true)
    public Specialty findById(Long id){
        Optional<Specialty> specialty = repository.findById(id);
        return specialty.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public SpecialtyDTO createSpecialty(SpecialtyDTO dto) {
        Specialty specialty = new Specialty();

        specialty.setName(dto.getName());

        var saved = repository.save(specialty);

        return new SpecialtyDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
