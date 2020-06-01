package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentInformationMapper03 implements RowMapper<Student> {

	//수강생아이디/ 수강생명 / 수강생번호 / 수강생등록일 / 수강횟수
	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student s = new Student();
		s.setStudent_id(rs.getString("student_id"));
		s.setStudent_name(rs.getString("student_name"));
		s.setPhone(rs.getString("phone"));
		s.setS_reg_date(rs.getDate("s_reg_date"));
		s.setS_courseCount(rs.getInt("s_courseCount"));
		return s;
	}
}