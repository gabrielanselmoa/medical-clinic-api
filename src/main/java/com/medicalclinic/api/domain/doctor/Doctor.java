package com.medicalclinic.api.domain.doctor;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.person.Person;
import com.medicalclinic.api.domain.phone.Phone;
import com.medicalclinic.api.domain.specialty.Specialty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor extends Person {

    private String crm;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToOne
    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, Address address, Phone phone, String crm, Set<Appointment> appointments, Specialty specialty) {
        super(id, name, birthdayDate, sexType, email, password, cpf, rg, address, phone);
        this.crm = crm;
        this.appointments = appointments;
        this.specialty = specialty;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
