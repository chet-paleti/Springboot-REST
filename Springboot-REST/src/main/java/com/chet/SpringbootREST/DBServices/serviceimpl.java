package com.chet.SpringbootREST.DBServices;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviceimpl {
	
	@Autowired
	private course_repo course_repo;
	
	@Autowired
	private student_repo student_repo;
	
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return course_repo.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Optional<Course> retrievecourse(@PathVariable int id) {
		return course_repo.findById(id);
	}
	
	@GetMapping("/courses/{id}/students")
	public List<Student> retrieveCourseStudents(@PathVariable int id) {
		Optional<Course> course = course_repo.findById(id);
		
		
		return course.get().getStudents();
	}
	
	@PostMapping("/courses/{id1}/students/{id2}")
	@Transactional
	public void add_course_student(@PathVariable int id1, @PathVariable int id2) {
		
		Optional<Course> course_optional = course_repo.findById(id1);
		
		Course course = course_optional.get();
		
		Optional<Student> student_optional = student_repo.findById(id2);
		
		Student student = student_optional.get();
		
		course.addStudent(student) ;
		
		course_repo.save(course);
		

	}
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return student_repo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> retrievestudent(@PathVariable int id) {
		return student_repo.findById(id);
	}
	
	@GetMapping("/students/{id}/courses")
	public List<Course> retrieveStudentCourses(@PathVariable int id) {
		Optional<Student> student = student_repo.findById(id);
		
		
		return student.get().getCourses();
	}
	
	@PostMapping("/students/{id1}/courses/{id2}")
	@Transactional
	public void add_student_course(@PathVariable int id1, @PathVariable int id2) {
		
		Student student = student_repo.findById(id1).get();
		
		
		Course course = course_repo.findById(id2).get();
		
		
		student.addCourse(course) ;
		
		student_repo.save(student);
		

	}

}
