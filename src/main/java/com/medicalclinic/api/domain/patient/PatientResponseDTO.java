package com.medicalclinic.api.domain.patient;

import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.phone.PhoneDTO;

import java.util.Date;

public class PatientResponseDTO {

    private Long id;
    private String name;
    private Date birthdayDate;
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;

    private AddressDTO address;
    private PhoneDTO phone;

    public PatientResponseDTO(){}

    public PatientResponseDTO(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg) {
        this.id = id;
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
    }

    public PatientResponseDTO(Patient patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthdayDate = patient.getBirthdayDate();
        this.sexType = patient.getSexType();
        this.email = patient.getEmail();
        this.password = patient.getPassword();
        this.cpf = patient.getCpf();
        this.rg = patient.getRg();
        this.address = new AddressDTO(patient.getAddress());
        this.phone = new PhoneDTO(patient.getPhone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
