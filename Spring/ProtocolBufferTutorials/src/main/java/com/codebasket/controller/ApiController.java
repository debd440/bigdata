package com.codebasket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.helper.AppHelper;
import com.codebasket.proto.StudentProto.StudentTo;
import com.codebasket.proto.StudentProto.SubjectTo;



@RestController
public class ApiController {

	@Autowired
	private AppHelper appHelper;
	
	@RequestMapping(value = "healthCheck", method = RequestMethod.GET, produces = "application/x-protobuf")
	public ResponseEntity<StudentTo> check() {

		List<SubjectTo> subjects = new ArrayList<>();
		SubjectTo science =  SubjectTo.newBuilder().setSubject("Science").build();
		SubjectTo eng =  SubjectTo.newBuilder().setSubject("English").build();
		subjects.add(eng);
		subjects.add(science);
//		StudentTo student = StudentTo.newBuilder().setId(1).setEmail("ram@test.com").setName("Ram")
//				.setSubjects(0, science).setSubjects(1, eng).build();
		StudentTo student = StudentTo.newBuilder().setId(1).setEmail("ram@test.com").setName("Ram")
				.addAllSubjects(subjects).build();
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET, produces = "application/x-protobuf")
	public ResponseEntity<String> read() {
		appHelper.getData();
		return new ResponseEntity<>("Response Received", HttpStatus.OK);
	}
}
