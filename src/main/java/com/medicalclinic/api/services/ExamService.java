package com.medicalclinic.api.services;

import com.medicalclinic.api.domain.exam.Exam;
import com.medicalclinic.api.domain.exam.ExamDTO;
import com.medicalclinic.api.repositories.ExamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ExamService {

    private ExamRepository repository;

    @Autowired
    public ExamService(ExamRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ExamDTO> findAll(Pageable pageable){
        Page<Exam> list = repository.findAll(pageable);
        return list.map(x -> new ExamDTO(x));
    }

    @Transactional(readOnly = true)
    public Exam findById(Long id){
        Optional<Exam> exam = repository.findById(id);
        return exam.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
