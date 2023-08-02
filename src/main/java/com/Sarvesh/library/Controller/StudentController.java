package com.Sarvesh.library.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sarvesh.library.DTO.Student.UpdateStudentCardRequest;
import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Student;
import com.Sarvesh.library.Repository.StudentRepo;
import com.Sarvesh.library.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepo studentrepo;
	@Autowired
	StudentService service;
	
	@GetMapping("/test")
	public String test() {
		return "Test API works";
	}
	
	@PostMapping("/add")
	public Student save(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		studentrepo.deleteById(id);
		return "Delete Successful";
	}
	

	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
			Optional<Student>optionalStudent =  studentrepo.findById(id);
			if(optionalStudent.isPresent()) {
				Student student = optionalStudent.get();
				return student;
			}
			else {
				return new Student();
			}
	}
	
	@PostMapping("/updateCard")
	public Student addCard(@RequestBody UpdateStudentCardRequest updateCardDTO) {
		try {
			return service.addCard(updateCardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
