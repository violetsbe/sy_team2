package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentInformationMapper01 implements RowMapper<Student>{

	//수강생사진아이디/ 수강생명 / 수강생아이디 / 수강생번호 / 수강생등록일
	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student s = new Student();
		s.setS_picture_id(rs.getString("s_picture_id"));
		s.setS_file_name(rs.getString("s_file_name"));
		s.setStudent_name(rs.getString("student_name"));
		s.setStudent_id(rs.getString("student_id"));
		s.setPhone(rs.getString("phone"));
		s.setS_reg_date(rs.getDate("s_reg_date"));
		return s;
	}
}