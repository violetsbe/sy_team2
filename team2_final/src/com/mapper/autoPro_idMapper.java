package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Instructor;

public class autoPro_idMapper implements RowMapper<Instructor> {

	@Override
	public Instructor mapRow(ResultSet rs, int arg1) throws SQLException {
		Instructor i = new Instructor();
		i.setPro_id(rs.getString("pro_id"));
		return i;
	}

}
