package com.example.demo.department;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class DepartmentService {
private final DepartmentRepo departmentRepo;

@Autowired
public DepartmentService(DepartmentRepo departmentRepo) {
	this.departmentRepo = departmentRepo;
}

public Department saveDepartment(Department department) {
	List<Student> students = new ArrayList<>();
	Student s1 = new Student(
			"John",
			"js@g.com",
			LocalDate.of(2000, 1, 1)
	);
	Student s2 = new Student(
			"Mary",
			"md@g.com",
			LocalDate.of(2000, 1, 1)
	);
	students.add(s1);
	students.add(s2);

	s1.setDepartment(department);
	s2.setDepartment(department);

	department.setStudents(students);
	return departmentRepo.save(department);

}
public List<Department> getDepartments() {
	return departmentRepo.findAll();
}
public Department getDepartment(Long id) {
	return departmentRepo.findDepartmentById(id);
}

public void updateDepartment(Long departmentId, String name, String description) {
	Department department = departmentRepo.findDepartmentById(departmentId);
	department.setName(name);
	department.setDescription(description);
	departmentRepo.save(department);
}

public void deleteDepartment(Long departmentId) {
	if (departmentRepo.existsById(departmentId)) {
		departmentRepo.deleteById(departmentId);
	} else {
		throw new IllegalStateException("Department with id " + departmentId + " does not exist");
	}
}
}