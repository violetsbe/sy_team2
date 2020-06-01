package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentScoreMapper implements RowMapper<Student>{

	//출결점수/ 실기점수 / 필기점수 / 총점
	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student s = new Student();
		s.setAttendance_score(rs.getString("attendance_score"));
		s.setPractice_score(rs.getString("practice_score"));
		s.setWritten_score(rs.getString("written_score"));
		s.setTotal_score(rs.getString("total_score"));
		return s;
	}
}
