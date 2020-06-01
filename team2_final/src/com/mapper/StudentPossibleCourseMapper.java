package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenCourse;


public class StudentPossibleCourseMapper implements RowMapper<OpenCourse> {

	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		OpenCourse oc = new OpenCourse();
		oc.setOpen_course_id(rs.getString("open_course_id"));
		oc.setCourse_name(rs.getString("course_name"));
		oc.setCourse_start_date(rs.getDate("course_start_date"));
		oc.setCourse_end_date(rs.getDate("course_end_date"));
		oc.setRoom_name(rs.getString("room_name"));
		return oc;
	}
	
	

}
