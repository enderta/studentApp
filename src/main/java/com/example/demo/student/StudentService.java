package com.example.demo.student;
import com.example.demo.department.Department;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
	boolean exists = studentRepo.findByEmail(student.getEmail()).isPresent();
	if (exists) {
		throw new IllegalStateException("email taken");
	}
	studentRepo.save(student);
}
public void deleteStudent(Long studentId) {
	boolean exists = studentRepo.existsById(studentId);
	if (!exists) {
		throw new IllegalStateException("student with id " + studentId + " does not exist");
	}
	studentRepo.deleteById(studentId);}
public void updateStudent(Long studentId, String name, String email, Department department) {
	Student student = studentRepo.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
	if (name != null && name.length() > 0 && !student.getName().equals(name)) {
		student.setName(name);
	}
	if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
		student.setEmail(email);
	}
	if (department != null && !student.getDepartment().equals(department)) {
		student.setDepartment(department);
	}
}

public Student getStudent(Long studentId) {
	return studentRepo.findById(studentId)
			.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
}

}