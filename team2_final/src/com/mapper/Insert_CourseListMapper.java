package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.*;

public class Insert_CourseListMapper implements RowMapper<OpenCourse> {

	//과정아이디 /  과정명
	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		OpenCourse c = new OpenCourse();
		c.setCourse_id(rs.getString("course_id"));
		c.setCourse_name(rs.getString("course_name"));
		return c;
	}
}
