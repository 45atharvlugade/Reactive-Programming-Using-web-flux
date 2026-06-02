package com.arl.runnners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class DeleteDocTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		WebClient client=WebClient.create("http://localhost:4042");
		Mono<String> mono=client.
				        delete().
				        uri("/actor/delete/108").
				        retrieve().
				        bodyToMono(String.class);
		
		mono.subscribe(System.out::println);
		System.out.println("Deleted!");
				        
	}

}
