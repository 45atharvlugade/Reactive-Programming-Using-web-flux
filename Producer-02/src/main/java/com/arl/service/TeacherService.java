package com.arl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arl.documents.Teacher;
import com.arl.repository.TeacherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeacherService implements ITeacherService {

	@Autowired
	private TeacherRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Mono<Teacher> register(Teacher teacher) {
		
		return repo.save(teacher);
	}

	@Override
	public Mono<Teacher> getTeaceherById(String id) {
		Mono<Teacher> mono=repo.findById(id);
		return mono;
	}

	@Override
	public Mono<Void> deleteTeacherById(String id, String password) {
		
		return repo.findById(id).switchIfEmpty(
				Mono.error(new RuntimeException("Teacher not Found for id : "+id))
				).flatMap(
						teacher->{
							if(!encoder.matches(password, teacher.getTeacherPassword())) {
								return Mono.error(new RuntimeException("Invalid Password"));
							}
							return repo.deleteById(id);
							
						}
						);
	}

	@Override
	public Flux<Teacher> getAllTeachers() {	
		return repo.findAll();
	}
	
	

}
