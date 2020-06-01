package com.persistence;

import java.util.List;

import com.domain.Test;

public interface TestDAO {

	//선택한 시험 정보
	public Test test(String open_sub_id, String test_id);
	
	//관리자 성적조회 과목별성적조회
	public List<Test> list(String open_sub_id);
	
	
	//관리자 성적조회 수강생 성적조회
	public List<Test> list2(String student_id, String open_sub_id);
	
	
	//강사 시험및배점관리
	public List<Test> insList(String pro_id, String open_sub_id);
	
	
	//강사 시험및배점관리 입력
	public int insert(Test t);
	
	
	//강사 시험및배점관리 삭제
	public int delete(Test t);
	
	
	//강사 시험및배점관리 수정
	public int update(Test t);
	
	
	//강사 성적관리 시험선택 출력
	public List<Test> insList2(String open_sub_id, String pro_id);

	
	//강사 성적관리 시험선택 출력
	public List<Test> insList3(String open_sub_id, String pro_id, String student_id);
	
	
	//수강생 성적조회
	//시험아이디 출결배점 필기배점 실기배점 시험문제 시험날짜
	public List<Test> stuList(String student_id, String open_sub_id);
	
	/******************************/
	//scoreCheck_os03
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택 - 세번째 테이블   #HJ
	public List<Test> insTestList(String pro_id, String open_sub_id);
	
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 세번째 테이블   #HJ
	public Test choiceInsTestList(String pro_id, String test_id);
	

	//scoreCheck_student04
	//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택 - 네번째테이블 #HJ
	public List<Test> insTestList02(String pro_id, String open_sub_id);
	
	//scoreCheck_student05
	//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택>특정수강생 성적관리 - 네번째테이블 #HJ
	public Test choiceInsTestList(String pro_id, String open_sub_id, String test_id);
	
}
