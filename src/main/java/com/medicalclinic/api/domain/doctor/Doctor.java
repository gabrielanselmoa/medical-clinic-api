package com.medicalclinic.api.domain.doctor;

import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor extends Person {

    private String crm;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>();

    public Doctor() {
    }
    public Doctor(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, String crm) {
        super(name, birthdayDate, sexType, email, password, cpf, rg);
        this.crm = crm;
    }

    public Doctor(String crm) {
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }
}
