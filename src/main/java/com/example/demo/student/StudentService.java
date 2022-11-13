package com.example.demo.student;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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


public void addNewStudent(Student student) {
	studentRepo.findByEmail(student.getEmail())
			.ifPresentOrElse(
					(s) -> {
						throw new IllegalStateException("email taken");
					},
					() -> {
						studentRepo.save(student);
					}
			);
	System.out.println(student);
}

public void deleteStudent(Long studentId) {
	boolean exists = studentRepo.existsById(studentId);
	if (!exists) {
		throw new IllegalStateException("student with id " + studentId + " does not exist");
	}
	studentRepo.deleteById(studentId);
}

@Transactional
public void updateStudent(Long studentId, String name, String email) {
	Student student = studentRepo.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
	if (name != null && name.length() > 0 && !student.getName().equals(name)) {
		student.setName(name);
	}
	if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
		student.setEmail(email);
	}
}

public Student getStudent(Long studentId) {
	return studentRepo.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
}

public List<Student> getStudentsByCourseId(Long courseId) {
	List<Student> students = new ArrayList<>();
	studentRepo.findAll().forEach(students::add);
	students.removeIf(student -> !student.getCourses().contains(courseId));
	return students;
}

public void registerStudentForCourse(Long courseId, Long studentId) {
	Student student = studentRepo.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
	student.getCourse().add(courseId);
}

}