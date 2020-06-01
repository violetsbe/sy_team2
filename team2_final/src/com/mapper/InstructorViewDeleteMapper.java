package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Instructor;

public class InstructorViewDeleteMapper implements RowMapper<Instructor>{

	//강사아이디 / 강사명 / 강의가능과목
	@Override
	public Instructor mapRow(ResultSet rs, int count) throws SQLException {
		Instructor i = new Instructor();
		i.setPro_id(rs.getString("pro_id"));
		i.setPro_name(rs.getString("pro_name"));
		i.setPossible_sub(rs.getString("possible_sub"));
		return i;
	}

}
