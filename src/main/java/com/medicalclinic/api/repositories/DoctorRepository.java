package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
