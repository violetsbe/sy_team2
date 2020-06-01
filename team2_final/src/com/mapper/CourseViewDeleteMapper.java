package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Course;


public class CourseViewDeleteMapper implements RowMapper<Course> {

	//과정아이디, 과정명, 삭제가능여부
	@Override
	public Course mapRow(ResultSet rs, int count) throws SQLException {
		Course c = new Course();
		c.setCourse_id  (rs.getString("course_id"));
		c.setCourse_name (rs.getString("course_name"));
		c.setCount_(rs.getInt("count_"));
		return c;
	}

}
