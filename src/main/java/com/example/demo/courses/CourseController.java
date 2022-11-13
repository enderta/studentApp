package com.example.demo.courses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/course")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping()
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	@GetMapping(path = "{courseId}")
	public Course getCourse(@PathVariable("courseId") Long courseId) {
		return courseService.getCourse(courseId);
	}
	@PutMapping(path = "{courseId}")
	public void updateCourse(
			@PathVariable("courseId") Long courseId,
			@RequestParam(required = false) Integer note,
			@RequestParam(required = false) String professor
	) {
		courseService.updateCourse(note, professor, courseId);
	}
	@PostMapping()
	public void registerNewCourse(@RequestBody Course course) {
		courseService.addNewCourse(course);
	}
	@DeleteMapping(path = "{courseId}")
	public void deleteCourse(@PathVariable("courseId") Long courseId) {
		courseService.deleteCourse(courseId);
	}



}