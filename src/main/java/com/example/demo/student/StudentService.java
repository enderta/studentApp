package com.example.demo.student;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@Service
public class StudentService {
public List<Student> getStudents() {
	return List.of(
			new Student(
					1L,
					"James Bond",
					"jb@gmail.com",
					LocalDate.of(2000, 1, 5),
					21
			)
	);
}


}