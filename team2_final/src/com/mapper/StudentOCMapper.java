package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenCourse;

public class StudentOCMapper implements RowMapper<OpenCourse>{

	//개설과정아이디/ 과정명/ 과정시작일/ 과정종료일/ 수료여부/ 수료날짜
	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		OpenCourse oc = new OpenCourse();
		oc.setOpen_course_id(rs.getString("open_course_id"));
		oc.setCourse_name(rs.getString("course_name"));
		oc.setCourse_start_date(rs.getDate("course_start_date"));
		oc.setCourse_end_date(rs.getDate("course_end_date"));
		oc.setS_status(rs.getString("s_status"));
		oc.setS_course_end_date(rs.getString("s_course_end_date"));
		return oc;
	}
}
