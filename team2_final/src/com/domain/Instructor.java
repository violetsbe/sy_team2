package com.domain;

import java.sql.Date;

public class Instructor {
	//강사아이디 강사명 
	//강의가능과목 
	//전화번호, 기존패스워드, 신규패스워드, 패스워드(로그인시 사용)
	//강사사진아이디, 강사사진파일명
	//강사등록일
	
	private String pro_id, pro_name;
	private String possible_sub;
	private String pro_phone, pro_newPw, pro_pw;
	private String i_picture_id, i_file_name;
	private Date p_reg_date;
	private int count_;
	
	
	public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPossible_sub() {
		return possible_sub;
	}
	public void setPossible_sub(String possible_sub) {
		this.possible_sub = possible_sub;
	}
	public String getPro_phone() {
		return pro_phone;
	}
	public void setPro_phone(String pro_phone) {
		this.pro_phone = pro_phone;
	}
	public String getPro_newPw() {
		return pro_newPw;
	}
	public void setPro_newPw(String pro_newPw) {
		this.pro_newPw = pro_newPw;
	}
	public String getPro_pw() {
		return pro_pw;
	}
	public void setPro_pw(String pro_pw) {
		this.pro_pw = pro_pw;
	}
	public String getI_picture_id() {
		return i_picture_id;
	}
	public void setI_picture_id(String i_picture_id) {
		this.i_picture_id = i_picture_id;
	}
	public String getI_file_name() {
		return i_file_name;
	}
	public void setI_file_name(String i_file_name) {
		this.i_file_name = i_file_name;
	}
	public Date getP_reg_date() {
		return p_reg_date;
	}
	public void setP_reg_date(Date p_reg_date) {
		this.p_reg_date = p_reg_date;
	}

	
}
