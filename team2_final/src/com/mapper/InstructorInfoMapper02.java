package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Instructor;

public class InstructorInfoMapper02 implements RowMapper<Instructor>{

	//강사아이디 / 강사명 / 강사번호 / 강사등록일 / 강사 사진 파일명
	@Override
	public Instructor mapRow(ResultSet rs, int count) throws SQLException {
	
		Instructor i = new Instructor();
		i.setPro_id(rs.getString("pro_id"));
		i.setPro_name(rs.getString("pro_name"));
		i.setPro_phone(rs.getString("pro_phone"));
		i.setP_reg_date(rs.getDate("p_reg_date"));
		i.setI_file_name(rs.getString("i_file_name"));
		
		return i;
	}

}