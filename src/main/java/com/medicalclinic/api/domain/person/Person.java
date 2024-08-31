package com.medicalclinic.api.domain.person;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.patient.Sex;
import com.medicalclinic.api.domain.phone.Phone;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdayDate;
    @Enumerated(value = EnumType.STRING)
    private Sex sexType;
    private String email;
    private String password;
    private String cpf;
    private String rg;

    @ManyToOne
    private Address address;
    @ManyToOne
    private Phone phone;

    public Person() {
    }

    public Person(String name, Date birthdayDate, Sex sexType, String email, String password, String cpf, String rg) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Person(String name, Date birthdayDate, Sex sexType, String email, String cpf, String rg, String password, Long id) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.password = password;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
