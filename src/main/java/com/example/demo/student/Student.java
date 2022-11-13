package com.example.demo.student;

import com.example.demo.courses.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
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
@Transient
private Integer age;

@ManyToOne
@JoinColumn(
		nullable = false,
		name = "course_id"
)
private Course course;

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

public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
}

public void setAge(Integer age) {
	this.age = age;
}

public void setCourse(Course course) {
this.course = course;
}

public Course getCourse() {
return course;
}


public List<Course> getCourses() {
	return List.of(course);
}
}