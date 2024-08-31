package com.medicalclinic.api.domain.patient;


import com.medicalclinic.api.domain.person.Person;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Patient extends Person {

    public Patient(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg) {
        super(name, birthdayDate, sexType, email, password, cpf, rg);
    }

}
