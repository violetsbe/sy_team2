package com.domain;

import java.sql.Date;

public class OpenSubject {
		//개설과목아이디 과목명 
		//개설과목시작일 개설과목종료일 
		//교재아이디 교재명 ISBN 강사아이디 강사명 
		//개설과정아이디
		//수강생아이디
		//과목아이디
		//대시보드-과목진행현황(%)
		//삭제여부
		//강사 사진이름
	private String open_sub_id, subject_name;
	private Date sub_start_date, sub_end_date;
	private String book_id, book_name, isbn, pro_id, pro_name;
	private String open_course_id;
	private String student_id;
	private String subject_id;
	private int progress;
	private int count_;
	private String i_file_name;
	
	
	
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
	public String getOpen_sub_id() {
		return open_sub_id;
	}
	public void setOpen_sub_id(String open_sub_id) {
		this.open_sub_id = open_sub_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public Date getSub_start_date() {
		return sub_start_date;
	}
	public void setSub_start_date(Date sub_start_date) {
		this.sub_start_date = sub_start_date;
	}
	public Date getSub_end_date() {
		return sub_end_date;
	}
	public void setSub_end_date(Date sub_end_date) {
		this.sub_end_date = sub_end_date;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getOpen_course_id() {
		return open_course_id;
	}
	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getI_file_name() {
		return i_file_name;
	}
	public void setI_file_name(String i_file_name) {
		this.i_file_name = i_file_name;
	}
	
	
	
	
	
}
