package com.codebasket.SpringJdbcDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebasket.SpringJdbcDemo.model.StudentTo;
import com.codebasket.SpringJdbcDemo.persist.ApiDao;

@Service
public class ApiService {

	@Autowired
	private ApiDao apiDao;

	@Autowired
	private ApiHelper apiHelper;
	
	public void execute() {
		List<StudentTo> list = new ArrayList<StudentTo>();

		StudentTo student = new StudentTo();
		student.setName("Ram");
		student.setCity("BLR");

		StudentTo student1 = new StudentTo();
		student1.setName("Sunil");
		student1.setCity("HYD");

		list.add(student);
		list.add(student1);
		// System.out.println(apiDao.insert(student));
		// System.out.println(apiDao.save(student));
		// apiDao.batchSave(list);
		// System.out.println(apiDao.getRseResult(2));
		// System.out.println(apiDao.getRmResult(2));
		// apiDao.getRseResult().forEach(System.out::println);
		// apiDao.getRmResult().forEach(System.out::println);
		// apiDao.getJ8Result().forEach(System.out::println);
		// System.out.println(apiDao.getTotalCount(2));
		// apiDao.delete(2);
		try {
		apiHelper.transExample();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
