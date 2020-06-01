package com.domain;

import java.util.Date;

public class Login {
	
	//관리자아이디, 관리자비밀번호
	//관리자등급, 관리자잠금설정
	//관리자전화번호, 강사전화번호, 수강생전화번호, 관리자등록날짜
	//강사아이디, 강사이름, 강사사진번호, 강사파일이름, 강사비밀번호
	//수강생아이디, 수강생이름, 수강생사진번호, 수강생파일이름
	
	private String owner_id, owner_pw;
	private int grade, accountlocking;
	private String owner_phone, pro_phone, phone;
	private String pro_id, pro_name, pro_picture_id, pro_fileName, pro_pw;;
	private String student_id, student_name, s_picture_id, s_file_name;
	private Date owner_reg_date, s_reg_date;
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_pw() {
		return owner_pw;
	}
	public void setOwner_pw(String owner_pw) {
		this.owner_pw = owner_pw;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getAccountlocking() {
		return accountlocking;
	}
	public void setAccountlocking(int accountlocking) {
		this.accountlocking = accountlocking;
	}
	public String getOwner_phone() {
		return owner_phone;
	}
	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}
	public String getPro_phone() {
		return pro_phone;
	}
	public void setPro_phone(String pro_phone) {
		this.pro_phone = pro_phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPro_picture_id() {
		return pro_picture_id;
	}
	public void setPro_picture_id(String pro_picture_id) {
		this.pro_picture_id = pro_picture_id;
	}
	public String getPro_fileName() {
		return pro_fileName;
	}
	public void setPro_fileName(String pro_fileName) {
		this.pro_fileName = pro_fileName;
	}
	public String getPro_pw() {
		return pro_pw;
	}
	public void setPro_pw(String pro_pw) {
		this.pro_pw = pro_pw;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getS_picture_id() {
		return s_picture_id;
	}
	public void setS_picture_id(String s_picture_id) {
		this.s_picture_id = s_picture_id;
	}
	public String getS_file_name() {
		return s_file_name;
	}
	public void setS_file_name(String s_file_name) {
		this.s_file_name = s_file_name;
	}
	public Date getOwner_reg_date() {
		return owner_reg_date;
	}
	public void setOwner_reg_date(Date owner_reg_date) {
		this.owner_reg_date = owner_reg_date;
	}
	public Date getS_reg_date() {
		return s_reg_date;
	}
	public void setS_reg_date(Date s_reg_date) {
		this.s_reg_date = s_reg_date;
	}
	
	
	
	
}
