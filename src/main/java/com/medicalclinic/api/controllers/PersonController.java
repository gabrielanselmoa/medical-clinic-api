package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.attendant.Attendant;
import com.medicalclinic.api.domain.attendant.AttendantRequestDTO;
import com.medicalclinic.api.domain.attendant.AttendantResponseDTO;
import com.medicalclinic.api.domain.doctor.DoctorRequestDTO;
import com.medicalclinic.api.domain.doctor.DoctorResponseDTO;
import com.medicalclinic.api.domain.patient.PatientRequestDTO;
import com.medicalclinic.api.domain.patient.PatientResponseDTO;
import com.medicalclinic.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorResponseDTO> createDoctor(@RequestBody DoctorRequestDTO dto){
        var res = service.createDoctor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody PatientRequestDTO dto){
        var res = service.createPatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/attendant")
    public ResponseEntity<AttendantResponseDTO> createAttendant(@RequestBody AttendantRequestDTO dto){
        var res = service.createAttendant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/attendant/{id}")
    public ResponseEntity<AttendantResponseDTO> findById(@PathVariable Long id){
        var attendant = service.findAttendantById(id);
        return ResponseEntity.status(HttpStatus.OK).body(attendant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
