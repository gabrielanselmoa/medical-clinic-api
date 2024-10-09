package com.medicalclinic.api;

import com.medicalclinic.api.domain.payment.Payment;
import com.medicalclinic.api.domain.payment.PaymentDTO;
import com.medicalclinic.api.domain.payment.PaymentStatus;
import com.medicalclinic.api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private PaymentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
//		LocalDate date = LocalDate.of(2024,8,10);
//		date.atStartOfDay(ZoneId.systemDefault()).toInstant();

//		String beginDate = "2024-10-06T15:30:00";
//		String beginDate = "2024-10-06T15:30:00";
//		LocalDateTime localDateTime = LocalDateTime.parse(date);
//		Double obj = repository.getPaymentSumByDate(localDateTime);
//		System.out.println(obj);

//		List<PaymentDTO> result = repository.getByPaymentDate("1");
//		for (PaymentDTO p : result){
//			System.out.println(p);
//		}
	}
}
