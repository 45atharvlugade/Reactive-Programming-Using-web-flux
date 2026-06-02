package com.arl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.arl.documents.ActorInfo;

public interface IActorInfoRepository extends ReactiveMongoRepository<ActorInfo, Integer> {

	
}
