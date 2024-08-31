package com.medicalclinic.api.domain.attendant;

import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.person.Person;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class Attendant extends Person {

    private String sectorNumber;

    public Attendant() {
    }

    public Attendant(String name, Date birthdayDate, Sex sexType, String email, String cpf, String rg, String password, Long id, String sectorNumber) {
        super(name, birthdayDate, sexType, email, cpf, rg, password, id);
        this.sectorNumber = sectorNumber;
    }

    public String getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(String sectorNumber) {
        this.sectorNumber = sectorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attendant attendant = (Attendant) o;
        return Objects.equals(sectorNumber, attendant.sectorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sectorNumber);
    }
}
