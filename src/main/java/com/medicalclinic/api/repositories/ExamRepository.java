package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
