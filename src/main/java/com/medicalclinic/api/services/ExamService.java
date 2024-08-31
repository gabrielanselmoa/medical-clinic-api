package com.medicalclinic.api.services;

import com.medicalclinic.api.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    private ExamRepository repository;

    @Autowired
    public ExamService(ExamRepository repository) {
        this.repository = repository;
    }
}
