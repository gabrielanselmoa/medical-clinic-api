package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.medChart.MedChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedChartRepository extends JpaRepository<MedChart, Long> {
}
