package com.codebasket.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebasket.db.persist.Course;
import com.codebasket.db.persist.CourseRepository;
import com.codebasket.db.persist.Student;
import com.codebasket.db.persist.StudentRepository;

@Service
public class ApiService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ApiHelper apiHelper;
	
	//@Transactional
	public void execute() {

		List<Student> list = new ArrayList<Student>();

		Student student = new Student();
		student.setName("Ram");
		student.setCity("BLR");

		Student student1 = new Student();
		student1.setName("Sunil");
		student1.setCity("HYD");

		list.add(student);
		list.add(student1);

		// studentRepository.save(student);
		// studentRepository.saveAll(list);
		// List<Student> students=studentRepository.findAll();
		// students.forEach(System.out::println);
		// Optional<Student> result = studentRepository.findById(10);
		// System.out.println("Result:"+result);
		// List<Student> sudent = studentRepository.findByName("Ram");
		// sudent.forEach(System.out::println);
		// studentRepository.deleteById(51);
		// studentRepository.deleteAll();

		try {
		apiHelper.testTxn();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
