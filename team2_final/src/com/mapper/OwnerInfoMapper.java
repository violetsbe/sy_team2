package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Login;

public class OwnerInfoMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int arg1) throws SQLException {
		Login l = new Login();
		l.setOwner_phone(rs.getString("owner_phone"));
		l.setOwner_reg_date(rs.getDate("owner_reg_date"));
		return l;
	}

}
