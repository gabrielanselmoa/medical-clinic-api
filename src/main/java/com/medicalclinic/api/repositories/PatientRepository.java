package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
