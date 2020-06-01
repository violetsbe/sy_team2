package com.persistence;

import com.domain.Login;

public interface LoginDAO {
	
	public Login admin_login(String id_, String pw_);
	
	public Login ins_login(String pro_name, String pro_pw);
	
	public Login student_login(String student_name, String student_pw);
	
	public Login admin_info(String owner_id);

}
