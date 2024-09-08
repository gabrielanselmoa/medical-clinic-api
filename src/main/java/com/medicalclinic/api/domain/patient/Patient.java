package com.medicalclinic.api.domain.patient;


import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.person.Person;
import com.medicalclinic.api.domain.phone.Phone;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Patient extends Person {

    public Patient(){}

    public Patient(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, Address address, Phone phone) {
        super(id, name, birthdayDate, sexType, email, password, cpf, rg, address, phone);
    }
}
