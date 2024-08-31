package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
