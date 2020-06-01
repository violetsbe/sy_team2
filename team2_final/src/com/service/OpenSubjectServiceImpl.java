package com.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.OpenSubject;
import com.persistence.OpenSubjectDAO;

@Service("openSubjectService")
public class OpenSubjectServiceImpl implements OpenSubjectService {

	@Resource(name = "openSubjectDAO")
	private OpenSubjectDAO openSubjectDAO;

	@Override
	public OpenSubject subject(String open_course_id, String open_sub_id) {

		return this.openSubjectDAO.subject(open_course_id, open_sub_id);
	}

	@Override
	public List<OpenSubject> adminList(String open_course_id) {
		return this.openSubjectDAO.adminList(open_course_id);
	}

	@Override
	public List<OpenSubject> adminList1(String open_course_id) {
		return this.openSubjectDAO.adminList1(open_course_id);
	}

	@Override
	public List<OpenSubject> adminList2(String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(OpenSubject os) {
		return this.openSubjectDAO.insert(os);
	}

	@Override
	public int update(OpenSubject os) {
		return this.openSubjectDAO.update(os);
	}

	@Override
	public int delete(OpenSubject os) {
		return this.openSubjectDAO.delete(os);
	}

	@Override
	public List<OpenSubject> insList(String pro_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> insList2(String pro_id, String open_course_id, Date sub_end_date, Date sub_start_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> insList3(String pro_id, String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> stList(String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/******************************************************************/
	// 강사 - 개설과정별 전체수강생 조회(선택한 특정 과정) #BR 20190106
	@Override
	public List<OpenSubject> insOSList(String pro_id, String open_course_id) {

		return this.openSubjectDAO.insOSList(pro_id, open_course_id);
	}

	// 강사 대시보드 하단 #BR
	@Override
	public List<OpenSubject> insProgressOSList(String pro_id, String open_course_id) {
		return this.openSubjectDAO.insProgressOSList(pro_id, open_course_id);
	}

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과목조회 #BR
	@Override
	public List<OpenSubject> plannedList(String pro_id, String open_course_id) {
		return this.openSubjectDAO.plannedList(pro_id, open_course_id);
	}

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의중 과목조회 #BR
	@Override
	public List<OpenSubject> ingList(String pro_id, String open_course_id) {
		return this.openSubjectDAO.ingList(pro_id, open_course_id);
	}

	// 강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과목조회 #BR
	@Override
	public List<OpenSubject> endList(String pro_id, String open_course_id) {
		return this.openSubjectDAO.endList(pro_id, open_course_id);
	}

	/******************************************************************/
	// scoreCheck_os02
	// 강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 - 두번째 테이블 #HJ
	@Override
	public List<OpenSubject> insOpenSubjectList(String pro_id, String open_course_id) {
		// TODO Auto-generated method stub
		return this.openSubjectDAO.insOpenSubjectList(pro_id, open_course_id);
	}

	// scoreCheck_os03
	// 강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택 - 두번째 테이블 #HJ
	@Override
	public OpenSubject choiceInsOpenSubjectList(String pro_id, String open_course_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return this.openSubjectDAO.choiceInsOpenSubjectList(pro_id, open_course_id, open_sub_id);
	}

	// scoreCheck_student03
	// 강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 - 두번째 테이블 #HJ
	@Override
	public List<OpenSubject> studentOpenSubjectList(String pro_id, String open_course_id) {
		// TODO Auto-generated method stub
		return this.openSubjectDAO.studentOpenSubjectList(pro_id, open_course_id);
	}

	@Override
	public OpenSubject choiceStudentOpenSubjectList(String pro_id, String open_course_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return this.openSubjectDAO.choiceStudentOpenSubjectList(pro_id, open_course_id, open_sub_id);
	}

}
