package com.arl.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.arl.document.Teacher;

import reactor.core.publisher.Mono;

@Component
public class RegisterTeacherRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		WebClient client=WebClient
				.create("http://localhost:4042");
		
		Mono<Teacher> mono=client
				.post()
				.uri("/teacher/save")
				.body(Mono.just(new Teacher("T220", "Athya", "hii", "Hello", "8900.09")),Teacher.class)
				.retrieve()
				.bodyToMono(Teacher.class);
	    mono.subscribe(System.out::println);
				

	}

}
