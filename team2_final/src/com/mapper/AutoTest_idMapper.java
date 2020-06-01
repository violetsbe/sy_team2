package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Test;

public class AutoTest_idMapper implements RowMapper<Test> {

	@Override
	public Test mapRow(ResultSet rs, int arg1) throws SQLException {
		Test t = new Test();
		t.setTest_id(rs.getString("test_id"));
		return t;
	}
}
