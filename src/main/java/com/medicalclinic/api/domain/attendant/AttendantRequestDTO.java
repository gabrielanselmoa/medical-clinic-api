package com.medicalclinic.api.domain.attendant;

import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.domain.specialty.SpecialtyDTO;

import java.util.Date;

public class AttendantRequestDTO {

    private String name;
    private Date birthdayDate;
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;
    private String sectorNumber;

    private AddressDTO address;
    private PhoneDTO phone;

    public AttendantRequestDTO(){}

    public AttendantRequestDTO(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg, String sectorNumber, AddressDTO address, PhoneDTO phone) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
        this.sectorNumber = sectorNumber;
        this.address = address;
        this.phone = phone;
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

    public String getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(String sectorNumber) {
        this.sectorNumber = sectorNumber;
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
