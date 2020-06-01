package com.domain;

import java.sql.Date;

public class Student {
	//수강생아이디 수강생명 전화번호 등록일 수강횟수
	//수료상태 수료상태날짜
	//개설과정시작날짜 개설과정종료날짜
	//출결점수 필기점수 실기점수 총점
	//개설과정아이디 개설과목아이디 시험아이디 성적아이디
	//수강생기존패스워드 새패스워드
	//수강생사진아이디 수강생사진파일명
	//강사아이디
	private String student_id, student_name, phone; 
	private Date s_reg_date;
	private int s_courseCount;
	private String s_status;
	private Date s_course_end_date, course_start_date, course_end_date;
	private String attendance_score, written_score, practice_score, total_score;
	private String open_course_id, open_sub_id, test_id, score_id;
	private String student_Pw, student_newPw;
	private String s_picture_id, s_file_name;
	private String pro_id;
	
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
	public Date getS_reg_date() {
		return s_reg_date;
	}
	public void setS_reg_date(Date s_reg_date) {
		this.s_reg_date = s_reg_date;
	}
	public int getS_courseCount() {
		return s_courseCount;
	}
	public void setS_courseCount(int s_courseCount) {
		this.s_courseCount = s_courseCount;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public Date getS_course_end_date() {
		return s_course_end_date;
	}
	public void setS_course_end_date(Date s_course_end_date) {
		this.s_course_end_date = s_course_end_date;
	}
	
	public String getAttendance_score() {
		return attendance_score;
	}
	public void setAttendance_score(String attendance_score) {
		this.attendance_score = attendance_score;
	}
	public String getWritten_score() {
		return written_score;
	}
	public void setWritten_score(String written_score) {
		this.written_score = written_score;
	}
	public String getPractice_score() {
		return practice_score;
	}
	public void setPractice_score(String practice_score) {
		this.practice_score = practice_score;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
	public String getOpen_course_id() {
		return open_course_id;
	}
	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}
	public String getOpen_sub_id() {
		return open_sub_id;
	}
	public void setOpen_sub_id(String open_sub_id) {
		this.open_sub_id = open_sub_id;
	}
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public String getScore_id() {
		return score_id;
	}
	public void setScore_id(String score_id) {
		this.score_id = score_id;
	}
	public String getStudent_newPw() {
		return student_newPw;
	}
	public void setStudent_newPw(String student_newPw) {
		this.student_newPw = student_newPw;
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
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(Date course_start_date) {
		this.course_start_date = course_start_date;
	}
	public Date getCourse_end_date() {
		return course_end_date;
	}
	public void setCourse_end_date(Date course_end_date) {
		this.course_end_date = course_end_date;
	}
	public String getStudent_Pw() {
		return student_Pw;
	}
	public void setStudent_Pw(String student_Pw) {
		this.student_Pw = student_Pw;
	}
}
