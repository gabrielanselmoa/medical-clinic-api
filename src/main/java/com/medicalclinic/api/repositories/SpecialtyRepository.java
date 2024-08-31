package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.specialty.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
