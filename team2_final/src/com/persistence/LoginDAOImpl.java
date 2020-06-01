package com.persistence;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Login;
import com.mapper.InstructorInfoMapper01;
import com.mapper.OwnerInfoMapper;
import com.mapper.StudentLoginMapper;
import com.mapper.adminLoginMapper;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{

	@Resource(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public Login admin_login(String owner_id, String owner_pw) {
		
		String sql = "SELECT owner_id, grade, accountlocking, owner_reg_date, owner_phone \r\n"
				+ "FROM owner_ WHERE owner_id=? AND owner_pw=?";
		
		return this.jdbcTemplate.queryForObject(sql, new adminLoginMapper()
							,owner_id, owner_pw);
	}

	@Override
	public Login ins_login(String pro_name, String pro_pw)  throws DataAccessException {
		String sql = "SELECT ins.pro_id, pro_name, i.i_file_name\r\n" + 
				"FROM instructor ins LEFT JOIN i_picturelist i ON ins.pro_id = i.pro_id\r\n" + 
				"WHERE ins.pro_name = ? AND pro_pw = ?";

		return this.jdbcTemplate.queryForObject(sql, new InstructorInfoMapper01()
				,pro_name, pro_pw);
	}

	@Override
	public Login student_login(String student_name, String student_pw) throws DataAccessException {
		String sql ="SELECT s_picture_id, s_file_name, s.student_id, student_name, phone, s_reg_date\r\n" + 
				"FROM student s, student_picturelist sp\r\n" + 
				"WHERE s.student_id = sp.student_id\r\n" + 
				"AND s.student_name = ?\r\n" + 
				"AND student_pw = ?";
		return this.jdbcTemplate.queryForObject(sql, new StudentLoginMapper(), student_name, student_pw);
	}

	@Override
	public Login admin_info(String owner_id) {
		String sql = "SELECT owner_phone, owner_reg_date FROM owner_ WHERE owner_id=? ";
		return this.jdbcTemplate.queryForObject(sql, new OwnerInfoMapper(), owner_id);
	}

	
	

}
