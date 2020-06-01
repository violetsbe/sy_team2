package com.service;

import java.util.Date;
import java.util.List;

import com.domain.OpenSubject;

public interface OpenSubjectService {

	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명 강사명
	public OpenSubject subject(String open_course_id, String open_sub_id);
		
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명 강사명
	public List<OpenSubject> adminList(String open_course_id);
	
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명 강사명 삭제가능여부
	public List<OpenSubject> adminList1(String open_course_id);


	//성적조회 수강생의과목 개설과목선택
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재며 강사명
	public List<OpenSubject> adminList2(String student_id, String open_course_id);
	
	
	//개설과목관리 개설과목등록
	public int insert(OpenSubject os);
	
	
	//개설과목관리 수정
	public int update(OpenSubject os);
	
	
	//개설과목관리 삭제
	public int delete(OpenSubject os);
	
	
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명
	public List<OpenSubject> insList(String pro_id, String open_course_id);
	

	//강사 강의예정, 강의중, 강의종료
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명
	public List<OpenSubject> insList2(String pro_id, String open_course_id, Date sub_end_date, Date sub_start_date);

	
	//강사 성적관리 수강생기준 개설과목선택
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명
	public List<OpenSubject> insList3(String pro_id, String student_id, String open_course_id);
	
	
	//수강생 성적조회 개설과목 선택
	//개설과목아이디 개설과목명 개설과목시작일 개설과목종료일 교재명 강사명
	public List<OpenSubject> stList(String student_id, String open_course_id);

/*************************************************************************************/
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의예정/강의중/강의종료 과목조회 통합		#BR	20190106
	public List<OpenSubject> insOSList(String pro_id, String open_course_id);
		
	//강사 전용 대시보드 하단		#BR
	//개설과목아이디, 개설과목명, 개설과목시작일, 개설과목종료일, 교재명, isbn, 과목진행현황(%)
	public List<OpenSubject> insProgressOSList(String pro_id, String open_course_id);
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과목조회		#BR
	public List<OpenSubject> plannedList(String pro_id, String open_course_id);
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의중	과목조회		#BR
	public List<OpenSubject> ingList(String pro_id, String open_course_id);
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과목조회		#BR
	public List<OpenSubject> endList(String pro_id, String open_course_id);
	
	
	/*************************************************************************************/
	//scoreCheck_os02
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택  - 두번째 테이블	 #HJ
	public List<OpenSubject> insOpenSubjectList(String pro_id, String open_course_id);
	
	//scoreCheck_os03
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택  - 두번째 테이블	 #HJ
	public OpenSubject choiceInsOpenSubjectList(String pro_id, String open_course_id, String open_sub_id);
	
	//scoreCheck_student03
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택  - 두번째 테이블	 #HJ
	public List<OpenSubject> studentOpenSubjectList(String pro_id, String open_course_id);
	
	//scoreCheck_student04
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 > 시험선택  - 세번째 테이블	 #HJ
	public OpenSubject choiceStudentOpenSubjectList(String pro_id, String open_course_id , String open_sub_id);
}
