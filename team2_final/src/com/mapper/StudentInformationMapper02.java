package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentInformationMapper02 implements RowMapper<Student>{

	//수강생아이디/ 수강생명 / 수강생번호 / 수강생등록일 / 수료여부 / 수료날짜
	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student s = new Student();
		s.setStudent_id(rs.getString("student_id"));
		s.setStudent_name(rs.getString("student_name"));
		s.setPhone(rs.getString("phone"));
		s.setS_reg_date(rs.getDate("s_reg_date"));
		s.setS_status(rs.getString("s_status"));
		s.setS_course_end_date(rs.getDate("s_course_end_date"));

		return s;
	}

}
