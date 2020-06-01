package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Subject;


public class SubjectViewDeleteMapper implements RowMapper<Subject> {

	//과목아이디/ 과목명 / 삭제가능여부
	@Override
	public Subject mapRow(ResultSet rs, int count) throws SQLException {
		Subject s = new Subject();
		s.setSubject_id (rs.getString("subject_id"));
		s.setSubject_name (rs.getString("subject_name"));
		s.setCount_(rs.getInt("count_"));
		return s;
	}

}
