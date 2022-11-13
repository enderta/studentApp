package com.example.demo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {
private final CourseRepo courseRepo;

@Autowired
public CourseService(CourseRepo courseRepo) {
	this.courseRepo = courseRepo;
}

public List<Course> getCourses() {
	return courseRepo.findAll();
}

public void addNewCourse(Course course) {
	courseRepo.save(course);
}

public void deleteCourse(Long courseId) {
	boolean exists = courseRepo.existsById(courseId);
	if (!exists) {
		throw new IllegalStateException("course with id " + courseId + " does not exist");
	}
	courseRepo.deleteById(courseId);
}
public Course updateCourse(Integer note, String professor, Long courseId) {
	Course course = courseRepo.findById(courseId)
			.orElseThrow(() -> new IllegalStateException("course with id " + courseId + " does not exist"));
	if (note != null && note > 0 && !course.getNote().equals(note)) {
		course.setNote(note);
	}
	if (professor != null && professor.length() > 0 && !course.getProfessor().equals(professor)) {
		course.setProfessor(professor);
	}
	return course;
}





public Course getCourse(Long courseId) {
	return courseRepo.findById(courseId)
			.orElseThrow(() -> new IllegalStateException("course with id " + courseId + " does not exist"));
}



}