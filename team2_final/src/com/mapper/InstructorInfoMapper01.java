package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.domain.Login;

public class InstructorInfoMapper01 implements RowMapper<Login>{

   //강사 아이디, 강사 이름, 강사 프로필 사진
   @Override
   public Login mapRow(ResultSet rs, int count) throws SQLException {
   
      Login l = new Login();
      l.setPro_id(rs.getString("pro_id"));
      l.setPro_name(rs.getString("pro_name"));
      l.setPro_fileName(rs.getString("i_file_name"));
      
      return l;
   }

}