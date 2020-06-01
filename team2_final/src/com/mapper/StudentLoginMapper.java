package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Login;

public class StudentLoginMapper implements RowMapper<Login>{

	//수강생사진아이디/ 수강생아이디/ 수강생명 / 수강생번호 / 수강생등록일
	@Override
	public Login mapRow(ResultSet rs, int count) throws SQLException {
		Login l = new Login();
		l.setS_picture_id(rs.getString("s_picture_id"));
		l.setStudent_id(rs.getString("student_id"));
		l.setStudent_name(rs.getString("student_name"));
		l.setPhone(rs.getString("phone"));
		l.setS_reg_date(rs.getDate("s_reg_date"));
		l.setS_file_name(rs.getString("s_file_name"));
		return l;
	}

}
