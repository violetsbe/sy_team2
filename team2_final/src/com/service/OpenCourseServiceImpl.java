package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Student;
import com.persistence.OpenCourseDAO;
import com.persistence.OpenSubjectDAO;

@Service("openCourseService")
public class OpenCourseServiceImpl implements OpenCourseService {

	@Resource(name="openCourseDAO")
	private OpenCourseDAO openCourseDAO;
	//#BR 추가 필요
	@Resource(name="openSubjectDAO")
	private OpenSubjectDAO openSubjectDAO;
	
	@Override
	public List<OpenCourse> list() {
		List<OpenCourse> result = this.openCourseDAO.list();
		return result;
	}
	
	@Override
	public List<OpenCourse> list(String key, String value) {
		return this.openCourseDAO.list(key, value);
	}
	
	@Override
	public List<OpenCourse> list(int pageStart, int pageCount){
		return this.openCourseDAO.list(pageStart, pageCount);
	}
	
	@Override
	public List<OpenCourse> list(String key, String value, int pageStart, int pageCount) {
		return this.openCourseDAO.list(key, value, pageStart, pageCount);
	}

	@Override
	public List<OpenCourse> list(String open_course_id) {
		List<OpenCourse> result = this.openCourseDAO.list(open_course_id);
		return result;
	}

	@Override
	public OpenCourse tablesstudentcount(String open_course_id) {
		OpenCourse result = this.openCourseDAO.tablesstudentcount(open_course_id);
		return result;
	}

	@Override
	public List<Student> tablesstudentcount2(String open_course_id, int pageStart) {
		List<Student> result = this.openCourseDAO.tablesstudentcount2(open_course_id, pageStart);
		return result;
	}
	
	@Override
	public int totalCount() {
		return this.openCourseDAO.totalCount();
	}

	@Override
	public List<Student> tablesstudentcount2(String open_course_id, String key, String value, int pageStart) {
		List<Student> result = this.openCourseDAO.tablesstudentcount2(open_course_id, key, value, pageStart);
		return result;
	}
	@Override
	public int tablesstudent_totalCount(String open_course_id) {
	
		return this.openCourseDAO.tablesstudent_totalCount(open_course_id);
	}
	
	@Override
	public int openCourseInsert(OpenCourse oc) {
		int result = this.openCourseDAO.openCourseInsert(oc);
		return result;
	}

	@Override
	public int openCourseDelete(OpenCourse oc) {
		int result = this.openCourseDAO.openCourseDelete(oc);
		return result;
	}

	@Override
	public int openCourseUpdate(OpenCourse oc) {
		int result = this.openCourseDAO.openCourseUpdate(oc);
		return result;
	}

	@Override
	public List<OpenCourse> courseList() {
		List<OpenCourse> result = this.openCourseDAO.courseList();
		return result;
	}

	@Override
	public List<OpenCourse> roomList() {
		List<OpenCourse> result = this.openCourseDAO.roomList();
		return result;
	}

	@Override
	public List<OpenCourse> studentOpenCourse(String student_id) {
		List<OpenCourse> result = this.openCourseDAO.studentOpenCourse(student_id);
		return result;
	}

	@Override
	public List<OpenCourse> possibleCourse(String student_id) {
		return this.openCourseDAO.possibleCourse(student_id);
	}
	
	@Override
	public List<OpenCourse> courseCansle(String student_id) {
		return this.openCourseDAO.courseCansle(student_id);
	}

	@Override
	public int courseHistory(OpenCourse oc) {
		return this.openCourseDAO.courseHistory(oc);
	}

	@Override
	public int courseHistoryDel(OpenCourse oc) {
		return this.openCourseDAO.courseHistoryDel(oc);
	}

/********************************************************************************/
	
	//강사 대시보드 - 진행중인 개설과정-과목 정보 출력 	#BR
	@Override
	public List<OpenCourse> insProgressOCList(Login l) {
		List<OpenCourse> result = this.openCourseDAO.insProgressOCList(l);
		
		for (OpenCourse oc : result) {
			String pro_id = l.getPro_id();
			String open_course_id = oc.getOpen_course_id();
			List<OpenSubject> subjectList = this.openSubjectDAO.insProgressOSList(pro_id, open_course_id);
			oc.setSubjectList(subjectList);
		}

		return result;
	}
	
	//강사 - 강의예정 리스트		#BR
	@Override
	public List<OpenCourse> plannedList(String pro_id) {
		return this.openCourseDAO.plannedList(pro_id);
	}

	//강사 - 강의중 리스트		#BR
	@Override
	public List<OpenCourse> ingList(String pro_id) {
		return this.openCourseDAO.ingList(pro_id);
	}

	//강사 - 강의종료 리스트		#BR
	@Override
	public List<OpenCourse> endList(String pro_id) {
		return this.openCourseDAO.endList(pro_id);
	}

	//강사 - 특정 강의예정 과정		#BR 20190106
	@Override
	public OpenCourse plannedOpenCourse(String pro_id, String open_course_id) {
		return this.openCourseDAO.plannedOpenCourse(pro_id, open_course_id);
	}

	//강사 - 특정 강의중 과정		#BR 20190106
	@Override
	public OpenCourse ingOpenCourse(String pro_id, String open_course_id) {
		return this.openCourseDAO.ingOpenCourse(pro_id, open_course_id);
	}

	//강사 - 특정 강의종료 과정		#BR 20190106
	@Override
	public OpenCourse endOpenCourse(String pro_id, String open_course_id) {
		return this.openCourseDAO.endOpenCourse(pro_id, open_course_id);
	}
	
	//강사 - 개설과정별 전체수강생 조회(담당 전체 과정 리스트)	#BR	20190106
	public List<OpenCourse> insAllList(String pro_id) {
		return this.openCourseDAO.insAllList(pro_id);
	}
	
	//강사 - 개설과정별 전체수강생 조회(담당 과정 리스트 검색)	#BR	20190109 #####
	public List<OpenCourse> insAllList(String pro_id, String key, String value, int pageStart, int pageCount) {
		return this.openCourseDAO.insAllList(pro_id, key, value, pageStart, pageCount);
	}
	
	//강사 - 개설과정별 전체수강생 조회 (totalcount)	#BR	20190106
	public int insAllTotalcount(String pro_id) {
		int result = 0;
		try {
			result = this.openCourseDAO.insAllTotalcount(pro_id);
		}catch(Exception e) {
			
		}
		return result;
	}
	
	
	//강사 - 개설과정별 전체수강생 조회(선택한 특정 과정) #BR	20190106
	public OpenCourse insOCstudent(String pro_id, String open_course_id) {
		return this.openCourseDAO.insOCstudent(pro_id, open_course_id);
	}
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과정조회		#BR	20190109 #####
	@Override
	public List<OpenCourse> plannedList(String pro_id, String key, String value, int pageStart, int pageCount) {
		return this.openCourseDAO.plannedList(pro_id, key, value, pageStart, pageCount);
	}

	//강사 - 강의스케쥴조회>강의일정별 조회>강의중 과정조회		#BR	20190109 #####
	@Override
	public List<OpenCourse> ingList(String pro_id, String key, String value, int pageStart, int pageCount) {
		return this.openCourseDAO.ingList(pro_id, key, value, pageStart, pageCount);
	}

	//강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과정조회		#BR	20190109 #####
	@Override
	public List<OpenCourse> endList(String pro_id, String key, String value, int pageStart, int pageCount) {
		return this.openCourseDAO.endList(pro_id, key, value, pageStart, pageCount);
	}
	
	//강사 - 강의스케쥴조회>강의예정 과정 (totalcount)	#BR	20190106
	public int insPlannedTotalcount(String pro_id) {
		int result = 0;
		try {
			result = this.openCourseDAO.insPlannedTotalcount(pro_id);
		}catch(Exception e) {
			
		}
		return result;
	}
	
	//강사 - 강의스케쥴조회>강의중 과정 (totalcount)	#BR	20190106
	public int insIngTotalcount(String pro_id) {
		int result = 0;
		try {
			result = this.openCourseDAO.insIngTotalcount(pro_id);
		}catch(Exception e) {
			
		}
		return result;
	}
	
	//강사 - 강의스케쥴조회>강의종료 과정 (totalcount)	#BR	20190106
	public int insEndTotalcount(String pro_id) {
		int result = 0;
		try {
			result = this.openCourseDAO.insEndTotalcount(pro_id);
		}catch(Exception e) {
			
		}
		return result;
	}
	
	/********************************************************************/
	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public List<OpenCourse> insListAll(String pro_id, int pageStart, int pageCount){
		
		return this.openCourseDAO.insListAll(pro_id, pageStart, pageCount);
	};
	
	
	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public List<OpenCourse> insListKeyValue(String pro_id, String key, String value, int pageStart, int pageCount){
		
		return this.openCourseDAO.insListKeyValue(pro_id, key, value, pageStart, pageCount);
	};
	

	//scoreCheck_os01
	//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
	public int insListTotalCount(String pro_id){
		return this.openCourseDAO.insListTotalCount(pro_id);
	};
	
	//scoreCheck_os02
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 - 첫번째 테이블	 #HJ
	@Override
	public OpenCourse choiceInsList(String pro_id, String open_course_id) {
		// TODO Auto-generated method stub
		return this.openCourseDAO.choiceInsList(pro_id, open_course_id);
	}

	
	
	//scoreCheck_student02
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 - 두번째 테이블 #HJ
	@Override
	public List<OpenCourse> studentOpenCourse(String pro_id, String student_id) {
		// TODO Auto-generated method stub
		return this.openCourseDAO.studentOpenCourse(pro_id, student_id);
	}
	
	//scoreCheck_student03
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 > 개설과목선택 - 두번째 테이블 #HJ
	@Override
	public OpenCourse choiceStudentOpenCourse(String pro_id, String student_id, String open_course_id) {
		return this.openCourseDAO.choiceStudentOpenCourse(pro_id, student_id, open_course_id);
	}



}
