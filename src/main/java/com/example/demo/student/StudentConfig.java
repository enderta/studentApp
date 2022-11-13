package com.example.demo.student;

import com.example.demo.courses.Course;
import com.example.demo.courses.CourseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
@Bean
CommandLineRunner commandLineRunner(StudentRepo studentRepo, CourseRepo courseRepo){
	return args -> {
		Student mariam=new Student(
		"Mariam",
		"mar@gmail",
		LocalDate.of(2000, Month.JANUARY,5)
		);
		Student alex=new Student(
		"Alex",
		"alex@gmail",
		LocalDate.of(2004, Month.JANUARY,5)
		);


		Course math=new Course(
		"Math",
		8,
		"John"
		);
		Course physics=new Course(
		"Physics",
		9,
		"Jordan"
		);
		courseRepo.saveAll(
		List.of(math,physics)
		);

		mariam.setCourse(math);
		alex.setCourse(physics);
		studentRepo.saveAll(
		List.of(mariam,alex)
		);


	};
}



}