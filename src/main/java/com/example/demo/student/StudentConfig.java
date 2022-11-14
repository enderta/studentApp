/*
package com.example.demo.student;
import com.example.demo.department.Department;
import com.example.demo.department.DepartmentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {
@Bean
CommandLineRunner commandLineRunner(StudentRepo studentRepo, DepartmentRepo departmentRepo) {
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

		Department cs=new Department(
				"Computer Science",
				"Computer Science"
		);
		Department it=new Department(
				"Information Technology",
				"Information Technology"
		);

		departmentRepo.saveAll(List.of(cs,it));

		mariam.setDepartment(cs);
		alex.setDepartment(it);

		studentRepo.saveAll(List.of(mariam,alex));



	};
}

}*/