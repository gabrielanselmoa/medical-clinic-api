package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
