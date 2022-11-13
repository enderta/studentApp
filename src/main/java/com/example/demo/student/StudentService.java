package com.example.demo.student;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@Service
public class StudentService {
private final StudentRepo studentRepo;

@Autowired
public StudentService(StudentRepo studentRepo) {
	this.studentRepo = studentRepo;
}

public List<Student> getStudents() {
	return studentRepo.findAll();
}


}