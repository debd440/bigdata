package com.codebasket.SpringJdbcDemo.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.codebasket.SpringJdbcDemo.model.StudentTo;

@Component
public class ApiDaoImpl implements ApiDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(StudentTo student) {

		String sql = "INSERT INTO STUDENT (NAME,CITY) VALUES('" + student.getName() + "','" + student.getCity() + "')";
		return jdbcTemplate.update(sql);
	}

	public int save(StudentTo student) {

		String sql = "INSERT INTO STUDENT (NAME,CITY) VALUES(?, ?)";
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				statement.setString(1, student.getName());
				statement.setString(2, student.getCity());
				return statement;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	public void batchSave(List<StudentTo> list) {

		String sql = "INSERT INTO STUDENT (NAME,CITY) VALUES( ?, ?)";
		int[] result = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				StudentTo student = list.get(i);
				ps.setString(1, student.getName());
				ps.setString(2, student.getCity());
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		for (int i : result) {
			System.out.println("Result Output: " + i);
		}
	}

	public StudentTo getRseResult(int id) {
		String sql = "SELECT ID,NAME,CITY FROM STUDENT WHERE ID = ?";
		StudentTo reuslt = jdbcTemplate.query(sql, new Object[] { id }, new ResultSetExtractor<StudentTo>() {

			@Override
			public StudentTo extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					StudentTo student = new StudentTo();
					student.setId(rs.getInt("ID"));
					student.setName(rs.getString("NAME"));
					student.setCity(rs.getString("CITY"));
					return student;
				}
				return null;
			}
		});
		return reuslt;
	}

	public StudentTo getRmResult(int id) {
		String sql = "SELECT ID,NAME,CITY FROM STUDENT WHERE ID = ?";
		StudentTo reuslt = jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<StudentTo>() {
			@Override
			public StudentTo mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentTo student = new StudentTo();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("NAME"));
				student.setCity(rs.getString("CITY"));
				return student;
			}
		});
		return reuslt;
	}

	public List<StudentTo> getRseResult() {
		String sql = "SELECT ID,NAME,CITY FROM STUDENT";
		List<StudentTo> reuslt = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentTo.class));
		return reuslt;
	}

	public List<StudentTo> getRmResult() {
		String sql = "SELECT ID,NAME,CITY FROM STUDENT";
		List<StudentTo> reuslt = jdbcTemplate.query(sql, new RowMapper<StudentTo>() {
			@Override
			public StudentTo mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentTo student = new StudentTo();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("NAME"));
				student.setCity(rs.getString("CITY"));
				return student;
			}
		});
		return reuslt;
	}

	public List<StudentTo> getJ8Result() {

		String sql = "SELECT ID,NAME,CITY FROM STUDENT";
		List<StudentTo> reuslt = jdbcTemplate.query(sql,
				(rs, rowNum) -> new StudentTo(rs.getInt("ID"), rs.getString("NAME"), rs.getString("CITY")));
		return reuslt;
	}

	public int getTotalCount(int id) {
		String sql = "SELECT COUNT(*) FROM STUDENT WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
	}

	public void delete(int id) {
		String sql = "DELETE FROM STUDENT WHERE ID = "+id;
		jdbcTemplate.execute(sql); // Void Return
	}

	public int saveCourse(int studentId, String courseName) {

		throw new NullPointerException();
	/*	String sql = "INSERT INTO COURSE (SID,COURSE_NAME) VALUES(?, ?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				statement.setInt(1, studentId);
				statement.setString(2, courseName);
				return statement;
			}
		}, holder);
		return holder.getKey().intValue();*/
	}

	public void executeProc() {

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource()).withProcedureName("PROC_NAME");
		SqlParameterSource in = new MapSqlParameterSource().addValue("PARAM_1", 0);
		jdbcCall.execute(in);
	}
}
