package com.arl.runnners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.arl.document.ActorInfo;

import reactor.core.publisher.Flux;

// @Component
public class SearchDocumentRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		WebClient client=WebClient.create("http://localhost:4042");
		
		Flux<ActorInfo> flux=client
				.get()
				.uri("actor/all")
				.retrieve()
				.bodyToFlux(ActorInfo.class);
				
				flux.doOnNext(System.out::println).blockLast();
	}

}
