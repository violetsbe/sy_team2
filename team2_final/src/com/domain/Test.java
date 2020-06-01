package com.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Test {
	//시험아이디 시험날짜 출결배점 필기배점 실기배점 시험문제
	//개설과목아이디, 수강생아이디, 강사아이디
	//시험문제 파일
	//삭제가능여부
	private String test_id;
	private Date test_date;
	private int attendance_points, written_points, practice_points;
	private String test_q;
	private MultipartFile test_q_file;
	private String open_sub_id, student_id, pro_id;
	private int count_;
	
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public Date getTest_date() {
		return test_date;
	}
	public void setTest_date(Date test_date) {
		this.test_date = test_date;
	}
	public int getAttendance_points() {
		return attendance_points;
	}
	public void setAttendance_points(int attendance_points) {
		this.attendance_points = attendance_points;
	}
	public int getWritten_points() {
		return written_points;
	}
	public void setWritten_points(int written_points) {
		this.written_points = written_points;
	}
	public int getPractice_points() {
		return practice_points;
	}
	public void setPractice_points(int practice_points) {
		this.practice_points = practice_points;
	}
	public String getTest_q() {
		return test_q;
	}
	public void setTest_q(String test_q) {
		this.test_q = test_q;
	}
	public String getOpen_sub_id() {
		return open_sub_id;
	}
	public void setOpen_sub_id(String open_sub_id) {
		this.open_sub_id = open_sub_id;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
	public MultipartFile getTest_q_file() {
		return test_q_file;
	}
	public void setTest_q_file(MultipartFile test_q_file) {
		this.test_q_file = test_q_file;
	}
	
	
	
}
