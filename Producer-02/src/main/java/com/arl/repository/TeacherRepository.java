package com.arl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.arl.documents.Teacher;

public interface TeacherRepository extends ReactiveMongoRepository<Teacher,String> {

}
