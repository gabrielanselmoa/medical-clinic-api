package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.exam.Exam;
import com.medicalclinic.api.repositories.ExamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private ExamRepository repository;

    @Autowired
    public ExamService(ExamRepository repository) {
        this.repository = repository;
    }

    public Exam findById(Long id){
        Optional<Exam> exam = repository.findById(id);
        return exam.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }
}
