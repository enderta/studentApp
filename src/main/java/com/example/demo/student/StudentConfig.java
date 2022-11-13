package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
@Bean
CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
	return args -> {
		Student mariam = new Student(

				"Mariam",
				"mar@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
		);
		Student alex = new Student(
				"Alex",
				"al@gamil.com",
				LocalDate.of(2004, Month.JANUARY, 5),
				21
		);
		studentRepo.saveAll(
				List.of(mariam, alex)
		);
	};
}



}