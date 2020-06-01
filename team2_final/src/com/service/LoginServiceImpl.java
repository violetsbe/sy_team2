package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Login;
import com.persistence.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	
	@Override
	public Login admin_login(String id_, String pw_) {
		Login login = this.loginDAO.admin_login(id_, pw_);
		return login;
	}
	
	@Override
	public Login ins_login(String pro_name, String pro_pw) {
		Login login = this.loginDAO.ins_login(pro_name,pro_pw );
		return login;
	}

	@Override
	public Login student_login(String student_name, String student_pw) {
		Login login = this.loginDAO.student_login(student_name, student_pw);
		return login;
	}


	@Override
	public Login admin_info(String owner_id) {
	
		return this.loginDAO.admin_info(owner_id);
	}


	

}
