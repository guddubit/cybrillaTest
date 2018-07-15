package com.cybrilla.cybrilla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybrilla.cybrilla.model.Student;
import com.cybrilla.cybrilla.repository.ClassRepository;
import com.cybrilla.cybrilla.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@GetMapping("/students")
	public Map<String,Object> getStudent() {
		Map<String,Object> response = new HashMap<String,Object>(); 
		try {
			List<Student> students = studentRepository.findAll();
			response.put("status", "success");
			response.put("students", students);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getMessage());
		}
		return response;
		
	}

	@GetMapping("/students/{studentId}")
	public Map<String,Object> getStudentById(@PathVariable Long studentId) {
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			ObjectMapper oMapper = new ObjectMapper();
			Student student = studentRepository.findById(studentId).get();
			// object -> Map
	        Map<String, Object> map = oMapper.convertValue(student, Map.class);
	        map.put("classId", student.getClassModel().getClassId());
			response.put("status", "success");
			response.put("students", map);
			response.put("classId", student.getClassModel().getName());
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getMessage());
		}
		return response;
		
	}
	
	@PostMapping("/students")
	public Map<String,Object> registerStudent(@Valid @RequestBody Student student){
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			student.setClassModel(classRepository.findById(student.getClassId()).get());
			Student studentObj = studentRepository.save(student);
			response.put("status", "success");
			response.put("message", "student record created successfully!");
			response.put("studentId", studentObj.getStudentId());
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getLocalizedMessage());
		}
		return response;
		
	}
}
