package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		String query = "Insert into student(id,name,city) value(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	public int change(Student student) {
		String query ="update student set name=? ,city =? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}
	
	public Student getStudent(int studentId) {
		String query="Select * from Student where id=?";
		RowMapper<Student> rowMapper = new RawMapperImpl();
		Student s= this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return s;
	}
	
	public List<Student> getAllStudent() {
		String query="select * from student";
		RowMapper<Student> rowMapper = new RawMapperImpl();
		List<Student> ls= this.jdbcTemplate.query(query, rowMapper);
		return ls;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
