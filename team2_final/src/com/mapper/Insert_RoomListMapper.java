package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenCourse;

public class Insert_RoomListMapper implements RowMapper<OpenCourse> {

	//강의실아이디, 수용인원, 강의실명
	@Override
	public OpenCourse mapRow(ResultSet rs, int count) throws SQLException {
		OpenCourse oc = new OpenCourse();
		oc.setRoom_id(rs.getString("room_id"));
		oc.setRoom_capacity(rs.getInt("room_capacity"));
		oc.setRoom_name(rs.getString("room_name"));
		return oc;
	}

}
