package com.medicalclinic.api.domain.doctor;

import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.domain.specialty.SpecialtyDTO;

import java.util.Date;

public class DoctorResponseDTO {

    private Long id;
    private String name;
    private Date birthdayDate;
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;
    private String crm;

    private AddressDTO address;
    private PhoneDTO phone;
    private SpecialtyDTO specialty;

    public DoctorResponseDTO(){}

    public DoctorResponseDTO(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, String crm) {
        this.id = id;
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
        this.crm = crm;
    }

    public DoctorResponseDTO(Long id, String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, String crm, AddressDTO address, PhoneDTO phone, SpecialtyDTO specialty) {
        this.id = id;
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
        this.crm = crm;
        this.address = address;
        this.phone = phone;
        this.specialty = specialty;
    }

    public DoctorResponseDTO(Doctor doctor){
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.birthdayDate = doctor.getBirthdayDate();
        this.sexType = doctor.getSexType();
        this.email = doctor.getEmail();
        this.password = doctor.getPassword();
        this.cpf = doctor.getCpf();
        this.rg = doctor.getRg();
        this.crm = doctor.getCrm();
        this.address = new AddressDTO(doctor.getAddress());
        this.phone = new PhoneDTO(doctor.getPhone());
        this.specialty = new SpecialtyDTO(doctor.getSpecialty());
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
