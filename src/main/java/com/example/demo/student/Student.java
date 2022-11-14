package com.example.demo.student;
import com.example.demo.department.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



@Entity
@Table
public class Student {
@Id
@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
)
@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
)
private Long id;
private String name;
private String email;
private LocalDate dob;



@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(
		nullable = false,
		name = "department_id",
		referencedColumnName = "id"
)
@JsonIgnoreProperties("students")
private Department department;

public Student() {
}

public Student(Long id, String name, String email, LocalDate dob) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.dob = dob;

}

public Student(String name, String email, LocalDate dob) {
	this.name = name;
	this.email = email;
	this.dob = dob;

}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public void setDepartment(Department department) {
	this.department = department;
}

public Department getDepartment() {
	return department;}



}