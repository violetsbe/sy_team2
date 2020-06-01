package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	//index.jsp파일을 loginForm으로 연결해야함!
	
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	
	@RequestMapping(value= {"/indexx", "/login/loginForm"})
	public String index() {
		
		//WEB-INF/views/login/loginForm.jsp
		return "/login/loginForm";
	}
	
	
	@RequestMapping("/login/login")
	public String login(String optradio, String id_ ,String pw, HttpSession session) {
		
		
		//로그인실패일경우
		String url = "redirect:/login/loginForm";
		
		Login login = null;
		
		if(optradio.equals("instructor")) {
			
			try {
			 login = this.loginService.ins_login(id_,pw);
			
			 
				if(login!=null) {
					session.setAttribute("instructor", login);
				    url = "redirect:/instructor/index";
					
				}
			}catch(Exception e) {
				
			}	
			
		}else if(optradio.equals("student")) {
			try {
				 login = this.loginService.student_login(id_, pw);
				
				 
					if(login!=null) {
						session.setAttribute("student", login);
					    url = "redirect:/students/studentdashboard";
						
					}
				}catch(Exception e) {
			}
		}else if(optradio.equals("admin")) {
			
			try {
				 login = this.loginService.admin_login(id_, pw);
				
				 
					if(login!=null) {
						session.setAttribute("admin", login);
					    url = "redirect:/admin/dashboard";
						
					}
				}catch(Exception e) {
					
				}	

			
		}
		

		return url;
	}

	@RequestMapping("/login/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		
		return "redirect:/login/loginForm";
		
	}
	

}
