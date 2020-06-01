package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Test;
import com.persistence.TestDAO;


@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource(name="testDAO")
	private TestDAO testDAO;

	@Override
	public Test test(String open_sub_id, String test_id) {
		return this.testDAO.test(open_sub_id, test_id);
	}
	
	@Override
	public List<Test> list(String open_sub_id) {
		List<Test> result = this.testDAO.list(open_sub_id);
		return result;
	}

	@Override
	public List<Test> list2(String student_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> insList(String pro_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Test> insList2(String open_sub_id, String pro_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> insList3(String open_sub_id, String pro_id, String student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> stuList(String student_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}


	/******************************/
	//scoreCheck_os03
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택 - 세번째 테이블   #HJ
	@Override
	public List<Test> insTestList(String pro_id, String open_sub_id) {
		List<Test> result = this.testDAO.insTestList(pro_id, open_sub_id);
		return result;
	}

	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 세번째 테이블   #HJ
	@Override
	public Test choiceInsTestList(String pro_id, String test_id) {
		Test result = this.testDAO.choiceInsTestList(pro_id, test_id);
		return result;
	}


	//scoreCheck_student04
	//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택 - 네번째테이블 #HJ
	@Override
	public List<Test> insTestList02(String pro_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return this.testDAO.insTestList02(pro_id, open_sub_id);
	}
	
	//scoreCheck_student05
	//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택>특정수강생 성적관리 - 네번째테이블 #HJ
	@Override
	public Test choiceInsTestList(String pro_id, String open_sub_id, String test_id) {
		// TODO Auto-generated method stub
		return this.testDAO.choiceInsTestList(pro_id, open_sub_id, test_id);
	}

	
}
