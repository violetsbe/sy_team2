package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.domain.Instructor;

public class InstructorMapper  implements RowMapper<Instructor> {

	//강사아이디 / 강사명 / 강의가능과목 / 강사전화번호 / 삭제가능여부
   @Override
   public Instructor mapRow(ResultSet rs, int count) throws SQLException {
      Instructor i = new Instructor();
      i.setPro_id(rs.getString("pro_id"));
      i.setPro_name(rs.getString("pro_name"));
      i.setPossible_sub(rs.getString("possible_sub"));
      i.setPro_phone(rs.getString("pro_phone"));
      i.setCount_(rs.getInt("count_"));
      return i;
   }
   
   
   
   
   
}