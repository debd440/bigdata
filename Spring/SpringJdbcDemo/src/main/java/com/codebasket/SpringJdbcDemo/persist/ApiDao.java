package com.codebasket.SpringJdbcDemo.persist;

import java.util.List;

import com.codebasket.SpringJdbcDemo.model.StudentTo;

public interface ApiDao {

	public int insert(StudentTo student);

	public int save(StudentTo student);

	public void batchSave(List<StudentTo> list);

	public StudentTo getRseResult(int id);

	public StudentTo getRmResult(int id);

	public List<StudentTo> getRseResult();

	public List<StudentTo> getRmResult();

	public List<StudentTo> getJ8Result();

	public int getTotalCount(int id);

	public void delete(int id);

	public int saveCourse(int studentId, String courseName);
}
