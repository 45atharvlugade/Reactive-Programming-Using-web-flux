package com.arl.document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActorInfo {
	private Integer aid;
	private String name;
	private String category;
	private Double fee; 
}
