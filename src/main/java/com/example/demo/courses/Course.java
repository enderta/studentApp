package com.example.demo.courses;

import com.example.demo.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Course {
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
	)
	private Long id;
	private String name;
	private Integer note;
	private String professor;

	@OneToMany(
			mappedBy = "course",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Student> students = new ArrayList<>();


	public Course() {
	}

	public Course(Long id, String name, Integer note, String professor) {
		this.id = id;
		this.name = name;
		this.note = note;
		this.professor = professor;
	}

	public Course(String name, Integer note, String professor) {
		this.name = name;
		this.note = note;
		this.professor = professor;
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

public Integer getNote() {
	return note;
}

public void setNote(Integer note) {
	this.note = note;
}

public String getProfessor() {
	return professor;
}

public void setProfessor(String professor) {
	this.professor = professor;
}

public void add(Long courseId) {

}
}