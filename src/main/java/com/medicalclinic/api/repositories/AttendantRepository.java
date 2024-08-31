package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.attendant.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Long> {
}
