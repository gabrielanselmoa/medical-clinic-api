package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.appointment.Appointment;
import com.medicalclinic.api.repositories.AppointmentRepository;
import com.medicalclinic.api.repositories.ExamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment findById(Long id){
        Optional<Appointment> appointment = repository.findById(id);
        return appointment.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
