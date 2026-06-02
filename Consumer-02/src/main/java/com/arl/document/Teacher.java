package com.arl.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
