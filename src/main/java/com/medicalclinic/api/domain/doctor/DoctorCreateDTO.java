package com.medicalclinic.api.domain.doctor;

import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.phone.PhoneDTO;

import java.util.Date;

public class DoctorCreateDTO {

    private String name;
    private Date birthdayDate;
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;

    private AddressDTO address;
    private PhoneDTO phone;

    public DoctorCreateDTO(){}

    public DoctorCreateDTO(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, AddressDTO address, PhoneDTO phone) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
        this.address = address;
        this.phone = phone;
    }

    public DoctorCreateDTO(Doctor doctor){
        this.name = doctor.getName();
        this.birthdayDate = doctor.getBirthdayDate();
        this.sexType = doctor.getSexType();
        this.email = doctor.getEmail();
        this.password = doctor.getPassword();
        this.cpf = doctor.getCpf();
        this.rg = doctor.getRg();
        this.address = new AddressDTO(doctor.getAddress());
        this.phone = new PhoneDTO(doctor.getPhone());
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
