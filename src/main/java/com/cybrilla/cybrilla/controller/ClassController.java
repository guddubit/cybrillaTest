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

import com.cybrilla.cybrilla.model.ClassModel;
import com.cybrilla.cybrilla.repository.ClassRepository;

@RestController
@RequestMapping("/api")
public class ClassController {
	
	@Autowired
	private ClassRepository classRepository;
	
	@GetMapping("/classes")
	public Map<String,Object> getclass() {
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			List<ClassModel> classses = classRepository.findAll();
			response.put("status", "success");
			response.put("classses", classses);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getMessage());
		}
		return response;
		
	}

	@GetMapping("/classes/{classId}")
	public Map<String,Object> getclassById(@PathVariable Long classId) {
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			Optional<ClassModel> classObj = classRepository.findById(classId);
			response.put("status", "success");
			response.put("class", classObj.get());
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getMessage());
		}
		return response;
		
	}
	
	@PostMapping("/classes")
	public Map<String,Object> getShortenUrl(@Valid @RequestBody ClassModel classModel){
		Map<String,Object> response = new HashMap<String,Object>();
		try {
			ClassModel classObj = classRepository.save(classModel);
			response.put("status", "success");
			response.put("message", "class record created successfully!");
			response.put("classId", classObj.getClassId());
		}catch(Exception ex) {
			ex.printStackTrace();
			response.put("status", "failed");
			response.put("message", ex.getMessage());
		}
		return response;
		
	}

}
