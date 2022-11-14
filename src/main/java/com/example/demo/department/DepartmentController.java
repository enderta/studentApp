package com.example.demo.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {
private final DepartmentService departmentService;

@Autowired
public DepartmentController(DepartmentService departmentService) {
	this.departmentService = departmentService;
}

@GetMapping()
public List<Department> getDepartments() {
	return departmentService.getDepartments();
}
@PostMapping()
public void addNewDep(@RequestBody Department department) {
	departmentService.saveDepartment(department);
}
@PutMapping(path = "{departmentId}")
public void updateDepartment(
		@PathVariable("departmentId") Long departmentId,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String description
) {
	departmentService.updateDepartment(departmentId, name, description);
}
@DeleteMapping(path = "{departmentId}")
public void deleteDepartment(@PathVariable("departmentId") Long departmentId) {
	departmentService.deleteDepartment(departmentId);
}

@GetMapping(path = "{departmentId}")
public Department getDepartment(@PathVariable("departmentId") Long departmentId) {
	return departmentService.getDepartment(departmentId);
}




}