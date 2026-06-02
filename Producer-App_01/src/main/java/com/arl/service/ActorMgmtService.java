package com.arl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arl.documents.ActorInfo;
import com.arl.repository.IActorInfoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorMgmtService implements IActorMgmtService{

	@Autowired
	private IActorInfoRepository repo;

	@Override
	public Mono<ActorInfo> saveActor(ActorInfo info) {
		Mono<ActorInfo> savedDoc=repo.save(info);
		return savedDoc;
	}

	@Override
	public Flux<ActorInfo> showAllActors() {
		
		return repo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<ActorInfo> showActorById(Integer id) {
		
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> removeActorById(Integer id) {
		
		Mono<ActorInfo> mono=repo.findById(id);
		
		return mono.flatMap(obj->{
			return repo.deleteById(obj.getAid());
		})
				.onErrorResume(e->{
					return Mono.error(new RuntimeException("Actor Info Document did not found for deletion ",e));
				});
	}

	@Override
	public Mono<ActorInfo> updateActor(ActorInfo newInfo) {
		return null;
	}

	
}
