package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
