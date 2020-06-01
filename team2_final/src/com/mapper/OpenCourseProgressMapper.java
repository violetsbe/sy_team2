package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.*;

public class OpenCourseProgressMapper implements RowMapper<OpenCourse> {

	//개설과정아이디/개설과정명/개설과정시작일/개설과정종료일/강의실/현재수강인원/중도포기인원/수강신청인원
	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		//open_course_id, course_name, course_start_date, course_end_date, room_name, current_student, abandon_student, total_student
		OpenCourse oc = new OpenCourse();
		oc.setOpen_course_id(rs.getString("open_course_id"));
		oc.setCourse_name(rs.getString("course_name"));
		oc.setCourse_start_date(rs.getDate("course_start_date"));
		oc.setCourse_end_date(rs.getDate("course_end_date"));
		oc.setRoom_name(rs.getString("room_name"));
		oc.setTotal_student(rs.getInt("total_student"));
		oc.setCurrent_student(rs.getInt("current_student"));
		oc.setAbandon_student(rs.getInt("abandon_student"));
		
		return oc;
	}
	

}
