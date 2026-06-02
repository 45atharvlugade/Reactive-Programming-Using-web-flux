package com.arl.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="jpa_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	private String teacherId;
	private String teacherName;
	private String teacherEmail;
	private String teacherMobile;
	private String teacherPassword;
}
