package com.arl.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection  = "WEBFLUX_ACTOR_INFO")
@Data
public class ActorInfo {

	private Integer aid;
	private String name;
	private String category;
	private Double fee; 
}
