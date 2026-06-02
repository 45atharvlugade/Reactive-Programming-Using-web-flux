package com.arl.service;

import com.arl.documents.Teacher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeacherService{

	public Mono<Teacher> register(Teacher teacher);
	public Mono<Teacher> getTeaceherById(String id);
	public Mono<Void> deleteTeacherById(String id,String password);
	public Flux<Teacher> getAllTeachers();
}
