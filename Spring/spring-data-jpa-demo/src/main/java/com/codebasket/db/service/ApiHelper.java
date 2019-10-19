package com.codebasket.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebasket.db.persist.Course;
import com.codebasket.db.persist.Student;
import com.codebasket.db.persist.StudentRepository;

@Service
public class ApiHelper {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void testTxn() {

		Student student = new Student();
		student.setName("Ram");
		student.setCity("BLR");
		Student a = studentRepository.save(student);
		System.out.println("Student Id: " + a.getId());

		Course course = new Course("12", a.getId(), "Science");
		// courseRepository.save(course);
		throw new NullPointerException();

	}

}
