package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.person.Person;
import com.medicalclinic.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person findById(Long id){
        Optional<Person> person = repository.findById(id);
        return person.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
