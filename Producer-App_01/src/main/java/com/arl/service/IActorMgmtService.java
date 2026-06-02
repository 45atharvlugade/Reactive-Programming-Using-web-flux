package com.arl.service;

import com.arl.documents.ActorInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActorMgmtService {

	public Mono<ActorInfo> saveActor(ActorInfo info);
	public Flux<ActorInfo> showAllActors();
	public Mono<ActorInfo> showActorById(Integer id);
	public Mono<Void> removeActorById(Integer id); // i dont want to return any thing.
	public Mono<ActorInfo> updateActor(ActorInfo newInfo); 
}
