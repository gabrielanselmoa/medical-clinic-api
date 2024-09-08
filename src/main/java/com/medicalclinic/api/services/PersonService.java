package com.medicalclinic.api.services;

import com.medicalclinic.api.controllers.exceptions.EntityNotFoundException;
import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.domain.attendant.Attendant;
import com.medicalclinic.api.domain.attendant.AttendantRequestDTO;
import com.medicalclinic.api.domain.attendant.AttendantResponseDTO;
import com.medicalclinic.api.domain.doctor.Doctor;
import com.medicalclinic.api.domain.doctor.DoctorRequestDTO;
import com.medicalclinic.api.domain.doctor.DoctorResponseDTO;
import com.medicalclinic.api.domain.patient.Patient;
import com.medicalclinic.api.domain.patient.PatientRequestDTO;
import com.medicalclinic.api.domain.patient.PatientResponseDTO;
import com.medicalclinic.api.domain.person.Person;
import com.medicalclinic.api.domain.phone.Phone;
import com.medicalclinic.api.domain.phone.PhoneDTO;
import com.medicalclinic.api.repositories.AddressRepository;
import com.medicalclinic.api.repositories.PersonRepository;
import com.medicalclinic.api.repositories.PhoneRepository;
import com.medicalclinic.api.repositories.SpecialtyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;
    private PhoneRepository phoneRepository;
    private SpecialtyRepository specialtyRepository;

    @Autowired
    public PersonService(PersonRepository repository, AddressRepository addressRepository, PhoneRepository phoneRepository, SpecialtyRepository specialtyRepository) {
        this.personRepository = repository;
        this.addressRepository = addressRepository;
        this.phoneRepository = phoneRepository;
        this.specialtyRepository = specialtyRepository;
    }

    public AttendantResponseDTO findAttendantById(Long id){
        Attendant attendant = (Attendant) personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendant not found!"));
        return new AttendantResponseDTO(attendant);
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO dto) {
        var doctor = new Doctor();

        var address = createAddress(dto.getAddress());
        var addressSaved = addressRepository.save(address);

        var phone = createPhone(dto.getPhone());
        var phoneSaved = phoneRepository.save(phone);

        var specialty = specialtyRepository.findById(dto.getSpecialtyId()).orElseThrow(() -> new EntityNotFoundException("Specialty not found!"));

        doctor.setName(dto.getName());
        doctor.setBirthdayDate(dto.getBirthdayDate());
        doctor.setSexType(dto.getSexType());
        doctor.setEmail(dto.getEmail());
        doctor.setPassword(dto.getPassword());
        doctor.setCpf(dto.getCpf());
        doctor.setRg(dto.getRg());
        doctor.setCrm(dto.getCrm());
        doctor.setAddress(addressSaved);
        doctor.setPhone(phoneSaved);
        doctor.setSpecialty(specialty);

        var doctorSaved = personRepository.save(doctor);

        return new DoctorResponseDTO(doctorSaved);
    }

    private Address createAddress(AddressDTO dto) {
        var address = new Address();
        BeanUtils.copyProperties(dto, address);
        return address;
    }

    private Phone createPhone(PhoneDTO dto) {
        var phone = new Phone();
        BeanUtils.copyProperties(dto, phone);
        return phone;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        var patient = new Patient();

        var address = createAddress(dto.getAddress());
        var addressSaved = addressRepository.save(address);

        var phone = createPhone(dto.getPhone());
        var phoneSaved = phoneRepository.save(phone);

        patient.setName(dto.getName());
        patient.setBirthdayDate(dto.getBirthdayDate());
        patient.setSexType(dto.getSexType());
        patient.setEmail(dto.getEmail());
        patient.setPassword(dto.getPassword());
        patient.setCpf(dto.getCpf());
        patient.setRg(dto.getRg());
        patient.setAddress(addressSaved);
        patient.setPhone(phoneSaved);

        var patientSaved = personRepository.save(patient);

        return new PatientResponseDTO(patientSaved);
    }

    public AttendantResponseDTO createAttendant(AttendantRequestDTO dto) {
        var attendant = new Attendant();

        var address = createAddress(dto.getAddress());
        var addressSaved = addressRepository.save(address);

        var phone = createPhone(dto.getPhone());
        var phoneSaved = phoneRepository.save(phone);

        attendant.setName(dto.getName());
        attendant.setBirthdayDate(dto.getBirthdayDate());
        attendant.setSexType(dto.getSexType());
        attendant.setEmail(dto.getEmail());
        attendant.setPassword(dto.getPassword());
        attendant.setCpf(dto.getCpf());
        attendant.setRg(dto.getRg());
        attendant.setAddress(addressSaved);
        attendant.setPhone(phoneSaved);

        var attendantSaved = personRepository.save(attendant);

        return new AttendantResponseDTO(attendantSaved);
    }
}
