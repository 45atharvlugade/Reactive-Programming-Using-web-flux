package com.arl.runnners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.arl.document.ActorInfo;

import reactor.core.publisher.Mono;

// @Component
public class SaveDocumentRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		WebClient client=WebClient.create("http://localhost:4042");
		
		Mono<ActorInfo> mono=client
				.post() // for post mode Request.
				.uri("/actor/save") // endpoint
				.body(Mono.just(new ActorInfo(1021,"Ishan Kishan","Bihar",5000.00)),ActorInfo.class) // converting the Object to the Json data
				.retrieve() // calls the provider api endpoint
				.bodyToMono(ActorInfo.class); // converting the Json to the mono
		 
		  mono.subscribe(System.out::println);

	}

}
