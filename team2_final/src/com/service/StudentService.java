package com.service;

import java.util.List;

import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Student;
import com.domain.Test;

public interface StudentService {
	
	//수강생 전체 리스트 (검색X)
	public List<Student> list(int pageStart, int pageCount);
	
	//수강생 전체 리스트 (검색가능)
	//수강생아이디 수강생명 전화번호 등록일 수강횟수
	public List<Student> list(String key, String value);
	
	// 관리자 개설과정관리 수강인원
	// 수강생아이디 수강생명 전화번호 등록일 수강횟수
	public List<Student> studentCount(String open_course_id);

	// 관리자 수강생관리(페이징, 검색기능)
	// 수강생아이디 수강생명 전화번호 등록일
	public List<Student> studentManage(String key, String value, int pageStart, int pageCount);

	// 관리자 수강생관리 수강횟수
	// 수강생아이디 수강생명 전화번호 등록일 수강횟수
	public Student courseCount(String student_id);

	// 신규 수강생 등록
	public int studentInsert(Student s);

	// 수강생 삭제
	public int studentDelete(Student s);

	// 수강생 수정
	public int studentUpdate(Student s);

	// 수강생 PW초기화
	public int studentPwInit(Student s);

	// 수강생 사진등록
	public int picture_insert(Student s);

	// 관리자 성적조회 과목별성적조회
	// 수강생아이디 수강생명 전화번호 수료상태 수료상태날짜 출결점수 필기점수 실기점수 총점
	public List<Student> subjectCheck1(String open_course_id, String test_id, int pageStart);

	// 관리자 성적조회 과목별성적조회
	// 수강생아이디 수강생명 전화번호 수료상태 수료상태날짜 출결점수 필기점수 실기점수 총점
	public List<Student> subjectCheck2(String open_course_id, String test_id, String key, String value, int pageStart);

		
	// 관리자 성적조회 수강생성적조회
	// 수강생아이디 수강생명 전화번호 등록일 수강횟수
	public List<Student> studentCheck(String key, String value, String pageStart, String pageCount);

	// 점수 조회
	// 출결점수 필기점수 실기점수 총점
	public Student scoreStudent(String student_id, String test_id);

	// 강사 성적관리 과목기준
	// 수강생아이디 수강생명 전화번호 수료상태 수료상태날짜 출결점수 필기점수 실기점수 총점
	public List<Student> insSubjectCheck(String pro_id, String test_id);

	// 강사 성적관리 수강생기준
	// 수강생아이디 수강생명 전화번호 등록일
	public List<Student> insStudentCheck(String pro_id, String key, String value, String pageStart, String pageCount);

	// 강사 성적관리 점수등록
	public int scoreInsert(Student s);

	// 강사 성적관리 점수삭제
	public int scoreDelete(Student s);

	// 강사 성적관리 수강생기준 점수
	// 출결점수 필기점수 실기 점수 총점
	public Student insScoreStudent(String pro_id, String student_id, String test_id);

	// 수강생 비밀번호 수정
	public int pw_update(Student s);
	
	//총 수강생
	public int total_student();

	public int subjectCheck1_totalCount(String open_course_id, String test_id);
	
	//수강생출력
	public List<Student> list();
	
	/********************************************/
	//개설과정별 전체수강생 조회  #BR	20190106
	public List<Student> insOCstudentList(String pro_id, String open_course_id);
	
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	public List<Student> insScore(String pro_id, String test_id, String open_course_id);
	
/*	//scoreCheck_os04 수강생사진
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	public String studentPic(String pro_id, String student_id);*/
	
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	//수강생 성적등록
	public int addScore(Student s);
	
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	//수강생 성적삭제
	public int removeScore(String student_id, String test_id);
	
	
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택 #HJ
	public List<Student> insStudentAll(String pro_id, int pageStart, int pageCount);
	
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택 #HJ
	public List<Student> insStudentKeyValue(String pro_id, String key, String value, int pageStart, int pageCount);
	
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택 #HJ
	public int insStudentTotalCount(String pro_id);
	
	//scoreCheck_student02
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 - 첫번째 테이블 #HJ
	public Student choiceInsStudent(String pro_id, String student_id);
	
	//scoreCheck_student05
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택 - 마지막 테이블 #HJ
	public List<Student> studentScoreList(String pro_id, String test_id , String open_course_id, String student_id);
	/****************************************************************************************/
	
	//수강생 개인정보조회
	//수강생아이디 수강생명 전화번호 등록일
	public Student student_info(Login l);

	// 수강생 대쉬보드
	public List<OpenCourse> studentDashboard(Login l);

	// 수강생 성적조회 과정
	public List<OpenCourse> studentOC(Login l);

	// 수강생 성적조회 특정과정
	public OpenCourse studentOC01(Login l, String open_course_id);

	// 수강생 성적조회 과목
	public List<OpenSubject> studentOS(Login l, String open_course_id);

	// 수강생 성적조회 선택과목
	public OpenSubject studentOS01(Login l, String open_sub_id);

	// 수강생 성적조회
	public List<Test> studentTestPoint(Login l, String open_sub_id);

	// 수강생 성적조회 선택시험
	public Test studentTestPoint01(Login l, String test_id);

	// 수강생 성적조회 특정시험 점수
	public List<Student> studentScore(Login l, String open_sub_id, String test_id);


}
