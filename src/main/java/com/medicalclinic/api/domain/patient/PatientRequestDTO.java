package com.medicalclinic.api.domain.patient;

import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.domain.specialty.SpecialtyDTO;

import java.util.Date;

public class PatientRequestDTO {

    private String name;
    private Date birthdayDate;
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;

    private AddressDTO address;
    private PhoneDTO phone;
    
    public PatientRequestDTO(){}

    public PatientRequestDTO(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Sex getSexType() {
        return sexType;
    }

    public void setSexType(Sex sexType) {
        this.sexType = sexType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public PhoneDTO getPhone() {
        return phone;
    }

    public void setPhone(PhoneDTO phone) {
        this.phone = phone;
    }
}
