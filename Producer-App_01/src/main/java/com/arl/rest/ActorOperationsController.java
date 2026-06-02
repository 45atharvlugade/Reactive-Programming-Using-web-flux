package com.arl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.arl.documents.ActorInfo;
import com.arl.service.IActorMgmtService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("actor")
public class ActorOperationsController {

	@Autowired
	private IActorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<Mono<ActorInfo>> saveActor(@RequestBody ActorInfo info){
		Mono<ActorInfo> mono=service.saveActor(info);
		return new ResponseEntity<Mono<ActorInfo>>(mono,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Flux<ActorInfo>> findAllActors(){
		Flux<ActorInfo> flux=service.showAllActors();
		return new ResponseEntity<Flux<ActorInfo>>(flux,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findActorByid(@PathVariable Integer id){
		Mono<ActorInfo> mono=service.showActorById(id);
		return new ResponseEntity<Mono<ActorInfo>>(mono,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateActor(@RequestBody ActorInfo info){
		Mono<ActorInfo> msg=service.updateActor(info);
		return new ResponseEntity<Mono<ActorInfo>>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable Integer id){
		service.removeActorById(id);
		return new ResponseEntity<String>("Document is Deleted",HttpStatus.OK);
	}
}
