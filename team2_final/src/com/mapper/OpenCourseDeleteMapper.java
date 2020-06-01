package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenCourse;

public class OpenCourseDeleteMapper implements RowMapper<OpenCourse> {

	
	//개설과정아이디/ 과정명/ 개설과정 시작일/ 개설과정 종료일/ 강의실명/ 수강인원/ 삭제가능여부
	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		OpenCourse oc = new OpenCourse();
		oc.setOpen_course_id(rs.getString("open_course_id"));
		oc.setCourse_name(rs.getString("course_name"));
		oc.setCourse_start_date(rs.getDate("course_start_date"));
		oc.setCourse_end_date(rs.getDate("course_end_date"));
		oc.setRoom_name(rs.getString("room_name"));
		oc.setTotal_student(rs.getInt("total_student"));
		oc.setCount_(rs.getInt("count_"));
		return oc;
	}
}
