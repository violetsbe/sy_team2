package com.service;

import java.util.List;

import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.Student;

public interface OpenCourseService {
	//개설과정 출력
	public List<OpenCourse> list();
	
	//개설과정 출력(해당과정출력)
	public List<OpenCourse> list(String open_course_id);
	
	//개설과정 검색 출력
	public List<OpenCourse> list(String key, String value);
	
	public List<OpenCourse> list(int pageStart, int pageCount);

	public List<OpenCourse> list(String key, String value, int pageStart, int pageCount);

	//수강인원 선택시 - 선택한 개설과정
	public OpenCourse tablesstudentcount(String open_course_id);
	
	//수강인원선택시 - 수강생 목록
	public List<Student> tablesstudentcount2(String open_course_id, int pageStart);
	public List<Student> tablesstudentcount2(String open_course_id, String key, String value, int pageStart);

	public int totalCount();
	
	//수강인원 - totalcount
	public int tablesstudent_totalCount(String open_course_id);
	
	//개설과정 추가
	public int openCourseInsert(OpenCourse oc);
	
	//개설과정 삭제
	public int openCourseDelete(OpenCourse oc);
		
	//개설과정 수정
	public int openCourseUpdate(OpenCourse oc);

	//개설과정 추가 - 과정목록
	public List<OpenCourse> courseList();
	
	//개설과정 추가 - 강의실목록
	public List<OpenCourse> roomList();
	
	//특정수강생이 듣는 개설과정목록
	public List<OpenCourse> studentOpenCourse(String student_id);
	
	//수강생 등록가능한 과정
	public List<OpenCourse> possibleCourse(String student_id);
	
	public List<OpenCourse> courseCansle(String student_id);
	
	public int courseHistory(OpenCourse oc);
	
	public int courseHistoryDel(OpenCourse oc);
	
	/********************************************************************/
	
	// 강사 전용 인덱스 페이지 대시보드 #BR
	// [상단]개설과정아이디/개설과정명/개설과정시작일/개설과정종료일/강의실/현재수강인원/중도포기인원/수강신청인원
	public List<OpenCourse> insProgressOCList(Login l);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과정조회 #BR
	public List<OpenCourse> plannedList(String pro_id);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의중 과정조회 #BR
	public List<OpenCourse> ingList(String pro_id);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과정조회 #BR
	public List<OpenCourse> endList(String pro_id);

	// 강사 - 강의스케쥴조회>강의예정 과정 (totalcount) #BR 20190106
	public int insPlannedTotalcount(String pro_id);

	// 강사 - 강의스케쥴조회>강의중 과정 (totalcount) #BR 20190106
	public int insIngTotalcount(String pro_id);

	// 강사 - 강의스케쥴조회>강의종료 과정 (totalcount) #BR 20190106
	public int insEndTotalcount(String pro_id);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과정조회 #BR 20190109 #####
	public List<OpenCourse> plannedList(String pro_id, String key, String value, int pageStart, int pageCount);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의중 과정조회 #BR 20190109 #####
	public List<OpenCourse> ingList(String pro_id, String key, String value, int pageStart, int pageCount);

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과정조회 #BR 20190109 #####
	public List<OpenCourse> endList(String pro_id, String key, String value, int pageStart, int pageCount);

	// 강사 - 특정 강의예정 과정 #BR 20190106
	public OpenCourse plannedOpenCourse(String pro_id, String open_course_id);

	// 강사 - 특정 강의중 과정 #BR 20190106
	public OpenCourse ingOpenCourse(String pro_id, String open_course_id);

	// 강사 - 특정 강의종료 과정 #BR 20190106
	public OpenCourse endOpenCourse(String pro_id, String open_course_id);

	// 강사 - 개설과정별 전체수강생 조회(담당 전체 과정 리스트) #BR 20190106
	public List<OpenCourse> insAllList(String pro_id);

	// 강사 - 개설과정별 전체수강생 조회(담당 과정 리스트 검색) #BR 20190109 #####
	public List<OpenCourse> insAllList(String pro_id, String key, String value, int pageStart, int pageCount);

	// 강사 - 개설과정별 전체수강생 조회 (totalcount) #BR 20190106
	public int insAllTotalcount(String pro_id);

	// 강사 - 개설과정별 전체수강생 조회(선택한 특정 과정) #BR 20190106
	public OpenCourse insOCstudent(String pro_id, String open_course_id);
	
			
	/********************************************************************/
	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public List<OpenCourse> insListAll(String pro_id, int pageStart, int pageCount);
	
	
	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public List<OpenCourse> insListKeyValue(String pro_id, String key, String value, int pageStart, int pageCount);
	

	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public int insListTotalCount(String pro_id);

	//scoreCheck_os02
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 - 첫번째 테이블	 #HJ
	public OpenCourse choiceInsList(String pro_id, String open_course_id);
	
	
	//scoreCheck_student02
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 - 두번째 테이블 #HJ
	public List<OpenCourse> studentOpenCourse(String pro_id, String student_id);
	
	//scoreCheck_student03
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 > 개설과목선택 - 두번째 테이블 #HJ
	public OpenCourse choiceStudentOpenCourse(String pro_id, String student_id, String open_course_id);
}
