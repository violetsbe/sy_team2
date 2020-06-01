package com.service;

import java.util.List;

import com.domain.Instructor;
import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Test;

public interface InstructorService {

	//강사아이디 강사명 강의가능과목 전화번호
	public List<Instructor> list(String key, String value, String pageStart, String pageCount);
	
	
	//강사계정관리 강사등록
	public int insert(Instructor i, String[] pc_list);
	//강사아이디 자동증가
	public Instructor auto_pro_id();
	//강의가능과목 등록
	public int pc_insert(String i, String pc_subject);
	
	//강사계정관리 강사삭제
	public int delete(Instructor i);
	
	
	//강사계정관리 강사정보수정
	public int update(Instructor i);
	
	
	//강사계정관리 강사 PW초기화
	public int pw_init(Instructor i);
	
	
	//강사계정관리 사진등록
	public int picture_insert(Instructor i);
	
	
	//강사 개인정보조회
	//강사아이디 강사명 전화번호 등록일
	public Instructor instructor_info(String pro_id);
	
	
	//강사 비밀번호 변경
	public int pw_update(Instructor i);


	public List<Instructor> list();
	
	//kbs--------------------------------------------------------------------------------------------------------------------------
	//강사 시험및 배점관리 개설과정 선택
	//전체
	public List<OpenCourse> insCourseList(Login l, int pageStart, int pageCount);
	//검색
	public List<OpenCourse> insCourseList(Login l, String key, String value, int pageStart, int pageCount);
	
	//강사 시험및 배점관리 개설과정 totalcount
	public int insTestOpenCourseTotalCount(String pro_id);
	
	//강사 시험및 배점관리 특정 개설과정
	public OpenCourse insCourseList(Login l, String open_course_id);
	
	//강사 시험및 배점관리 개설과목 선택
	public List<OpenSubject> insSubjectList (Login l, String open_course_id);
	
	//강사 시험및 배점관리 특정 개설과목
	public OpenSubject insSubjectList (Login l, String open_course_id, String open_sub_id);
	
	//강사 시험및 배점관리 시험배점 리스트
	public List<Test> insTestList (Login l, String open_sub_id);
	
	//강사 시험및 배점관리 시험및배점 등록
	public int testInsert(Test t);
	
	//강사 시험및 배점관리 test_id 가져오기
	public Test auto_test_id();
	
	//강사 시험및 배점관리 시험및배점 수정
	public int testUpdate(Test t);
	
	//강사 시험및 배점관리 시험및배점 삭제
	public int testDelete(String test_id);
	//kbs--------------------------------------------------------------------------------------------------------------------------
}
