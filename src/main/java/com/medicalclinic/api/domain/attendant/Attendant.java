package com.medicalclinic.api.domain.attendant;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.person.Person;
import com.medicalclinic.api.domain.phone.Phone;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class Attendant extends Person {

    private String sectorNumber;

    public Attendant() {
    }

    public Attendant(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, Address address, Phone phone, String sectorNumber) {
        super(id, name, birthdayDate, sexType, email, password, cpf, rg, address, phone);
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
