package com.arl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arl.documents.Teacher;
import com.arl.service.TeacherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/teacher")
public class TeacherOperationController {

	
	@Autowired
	private TeacherService service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/save")
	public ResponseEntity<?> registerTeacher(@RequestBody Teacher teacher){
	teacher.setTeacherPassword(encoder.encode(teacher.getTeacherPassword()));
		Mono<Teacher> mono=service.register(teacher);
		return new ResponseEntity<Mono<Teacher>>(mono,HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findTeacherById(@PathVariable String id){
		Mono<Teacher> mono=service.getTeaceherById(id);
		return new ResponseEntity<Mono<Teacher>>(mono,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}/{password}")
	public ResponseEntity<?> unRegisterTeacher(@PathVariable String  id, @PathVariable  String password){
		Mono<Void> mono=service.deleteTeacherById(id, password);
	  return new ResponseEntity<Mono<Void>>(mono,HttpStatus.OK);
	
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<?> getAllRegisteredTeachers(){
		Flux<Teacher> flux=service.getAllTeachers();
				return new ResponseEntity<Flux<Teacher>>(flux,HttpStatus.OK);
	}
	
	
	
}
