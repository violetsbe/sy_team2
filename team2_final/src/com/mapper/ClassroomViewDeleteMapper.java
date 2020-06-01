package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Classroom;


public class ClassroomViewDeleteMapper implements RowMapper<Classroom> {
	//강의실아이디, 강의실명, 수용인원, 삭제가능여부
	@Override
	public Classroom mapRow(ResultSet rs, int count) throws SQLException {
		Classroom c = new Classroom();
		c.setRoom_id(rs.getString("room_id"));
		c.setRoom_name(rs.getString("room_name"));
		c.setRoom_capacity(rs.getInt("room_capacity"));
		c.setCount_(rs.getInt("count_"));
		return c;
	}

}
