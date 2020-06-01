package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.OpenSubject;

public class StudentOSMapper implements RowMapper<OpenSubject> {

	//개설과목아이디/ 과목명/ 과목시작일/ 과목종료일/ 교재아이디/ isbn/ 강사아이디 / 강사명
	@Override
	public OpenSubject mapRow(ResultSet rs, int count) throws SQLException {
		
		OpenSubject os = new OpenSubject();
		os.setOpen_sub_id(rs.getString("open_sub_id"));
		os.setSubject_name(rs.getString("subject_name"));
		os.setSub_start_date(rs.getDate("sub_start_date"));
		os.setSub_end_date(rs.getDate("sub_end_date"));
		os.setBook_name(rs.getString("book_name"));
		os.setIsbn(rs.getString("isbn"));
		os.setPro_id(rs.getString("pro_id"));
		os.setPro_name(rs.getString("pro_name"));
		os.setI_file_name(rs.getString("i_file_name"));
		
		if(rs.getString("book_name")==null) {
			os.setBook_name("-");
		}
		
		return os;
	}

}
