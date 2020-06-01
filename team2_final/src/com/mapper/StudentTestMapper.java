package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Test;

public class StudentTestMapper implements RowMapper<Test>{

	//시험아이디/시험날짜/출결점수/실기점수/필기점수/시험문제
	@Override
	public Test mapRow(ResultSet rs, int count) throws SQLException {
		Test t = new Test();
		t.setTest_id(rs.getString("test_id"));
		t.setTest_date(rs.getDate("test_date"));
		t.setAttendance_points(rs.getInt("attendance_points"));
		t.setPractice_points(rs.getInt("practice_points"));
		t.setWritten_points(rs.getInt("written_points"));
		t.setTest_q(rs.getString("test_q"));
		return t;
	}

}
