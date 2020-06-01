package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Student;

public class StudentScoreMapper02 implements RowMapper<Student>{

	//수강생아이디/출결점수/필기점수/실기점수/총점
	@Override
	public Student mapRow(ResultSet rs, int count) throws SQLException {
		Student s = new Student();
		s.setStudent_id(rs.getString("student_id"));
		
		String attendance_score = rs.getString("attendance_score");
		if(attendance_score==null) {
			
			s.setAttendance_score("--");
			
			System.out.println("attendance_score가 null인경우 ");
		}else {
			
			System.out.println("attendance_score가 null이 아닌경우 ");
			s.setAttendance_score(attendance_score);
			
		}
		
		
		String written_score = rs.getString("written_score");
		if(written_score==null) {
			
			s.setWritten_score("--");
		}else {
			s.setWritten_score(written_score);
			
		}

		String practice_score = rs.getString("practice_score");
		if(practice_score==null) {
			
			s.setPractice_score("--");
		}else {
			s.setPractice_score(practice_score);
			
		}
		
		
		String total_score = rs.getString("total_score");
		if(total_score==null) {
			
			s.setTotal_score("--");
		}else {
			s.setTotal_score(total_score);
			
		}
		return s;
	}
}
