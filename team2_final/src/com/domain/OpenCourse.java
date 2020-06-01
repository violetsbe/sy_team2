package com.domain;

import java.sql.Date;
import java.util.List;

public class OpenCourse {
	// 개설과정아이디
	// 개설과정시작일, 개설과정종료일
	// 강의실아이디 강의실명
	// 수강인원, 강의실수용인원
	// 과정아이디 , 과정명
	// 강사아이디, 수강생아이디
	// 삭제가능여부
	// 수료상태, 수료상태날짜
	// 진행현황
	// 현재수강인원, 중도포기인원 #2019.01.02 추가
	// 각 과정에 포함된 과목 리스트		#2019.01.03 추가

	private String open_course_id;
	private Date course_start_date, course_end_date;
	private String room_id, room_name;
	private int total_student, room_capacity;
	private String pro_id;
	private String course_id, course_name;
	private String student_id;
	private int count_;
	private String s_status, s_course_end_date;
	private int progress;
	private int current_student, abandon_student;
	private List<OpenSubject> subjectList;
	
	public String getOpen_course_id() {
		return open_course_id;
	}

	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
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

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getTotal_student() {
		return total_student;
	}

	public void setTotal_student(int total_student) {
		this.total_student = total_student;
	}

	public int getRoom_capacity() {
		return room_capacity;
	}

	public void setRoom_capacity(int room_capacity) {
		this.room_capacity = room_capacity;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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

	public String getS_status() {
		return s_status;
	}

	public void setS_status(String s_status) {
		this.s_status = s_status;
	}

	public String getS_course_end_date() {
		return s_course_end_date;
	}

	public void setS_course_end_date(String s_course_end_date) {
		this.s_course_end_date = s_course_end_date;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getCurrent_student() {
		return current_student;
	}

	public void setCurrent_student(int current_student) {
		this.current_student = current_student;
	}

	public int getAbandon_student() {
		return abandon_student;
	}

	public void setAbandon_student(int abandon_student) {
		this.abandon_student = abandon_student;
	}

	public List<OpenSubject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<OpenSubject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
}
