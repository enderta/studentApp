package com.example.demo.department;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Department {

@Id
@SequenceGenerator(
		name = "department_sequence",
		sequenceName = "department_sequence",
		allocationSize = 1
)
@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "department_sequence"
)
private Long id;
private String name;
private String description;
@OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JsonIgnoreProperties("department")
private List<Student> students;

public Department() {

}
public Department(Long id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
}
public Department(String name, String description) {
	this.name = name;
	this.description = description;
}
public Long getId() {
	return id;}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public List<Student> getStudents()	{
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}



}