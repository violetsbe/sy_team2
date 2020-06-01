package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Login;

public class adminLoginMapper implements RowMapper<Login>{

	@Override
	public Login mapRow(ResultSet rs, int count) throws SQLException {

		Login l = new Login();
		l.setOwner_id(rs.getString("owner_id"));
		l.setGrade(rs.getInt("grade"));
		l.setAccountlocking(rs.getInt("accountlocking"));
		l.setOwner_reg_date(rs.getDate("owner_reg_date"));
		l.setOwner_phone(rs.getString("owner_phone"));
		
		return l;
	}
	
	

}
