/*
package com.example.demo.courses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
@Bean
CommandLineRunner commandLineRunner(CourseRepo courseRepo){
	return args -> {
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
	};
	}
}*/