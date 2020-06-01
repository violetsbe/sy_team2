package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.*;
import com.persistence.StudentDAO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource(name = "studentDAO")
	private StudentDAO studentDAO;

	@Override
	public List<Student> list(String key, String value) {
		List<Student> result = this.studentDAO.list(key, value);
		return result;
	}

	@Override
	public List<Student> studentCount(String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> studentManage(String key, String value, int pageStart, int pageCount) {

		return this.studentDAO.studentManage(key, value, pageStart, pageCount);
	}

	@Override
	public Student courseCount(String student_id) {

		return this.studentDAO.courseCount(student_id);
	}

	@Override
	public int studentInsert(Student s) {
		return this.studentDAO.studentInsert(s);
	}

	@Override
	public int studentDelete(Student s) {
		return this.studentDAO.studentDelete(s);
	}

	@Override
	public int studentUpdate(Student s) {
		return this.studentDAO.studentUpdate(s);
	}

	@Override
	public int studentPwInit(Student s) {
		return this.studentDAO.studentPwInit(s);
	}


	@Override
	public int picture_insert(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> subjectCheck1(String open_course_id, String test_id, int pageStart) {

		return this.studentDAO.subjectCheck1(open_course_id, test_id, pageStart);
	}

	@Override
	public List<Student> subjectCheck2(String open_course_id, String test_id, String key, String value, int pageStart) {

		return this.studentDAO.subjectCheck2(open_course_id, test_id, key, value, pageStart);
	}

	@Override
	public List<Student> studentCheck(String key, String value, String pageStart, String pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student scoreStudent(String student_id, String test_id) {
		Student result = null;
		try{
			result = this.studentDAO.scoreStudent(student_id, test_id);
		}catch(Exception e){
			
		}
		return result;
	}

	@Override
	public List<Student> insSubjectCheck(String pro_id, String test_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> insStudentCheck(String pro_id, String key, String value, String pageStart, String pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int scoreInsert(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scoreDelete(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student insScoreStudent(String pro_id, String student_id, String test_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> list(int pageStart, int pageCount) {

		return this.studentDAO.list(pageStart, pageCount);
	}

	@Override
	public int total_student() {

		return this.studentDAO.total_student();
	}

	@Override
	public int subjectCheck1_totalCount(String open_course_id, String test_id) {

		return this.studentDAO.subjectCheck1_totalCount(open_course_id, test_id);
	}

	@Override
	public List<Student> list() {
		return this.studentDAO.list();
	}

	/********************************************/
	// ���������� ��ü������ ��ȸ #BR 20190106
	@Override
	public List<Student> insOCstudentList(String pro_id, String open_course_id) {

		return this.studentDAO.insOCstudentList(pro_id, open_course_id);
	}

	// scoreCheck_os04
	// ���� - ��������>�������>�������� ���� >���������� >���輱��>��ü������ �������� - �׹�° ���̺� #HJ

	@Override
	public List<Student> insScore(String pro_id, String test_id, String open_course_id) {
		// TODO Auto-generated method stub
		return this.studentDAO.insScore(pro_id, test_id, open_course_id);
	}

/*	// scoreCheck_os04 ����������
	// ���� - ��������>�������>�������� ���� >���������� >���輱��>��ü������ �������� - �׹�° ���̺� #HJ
	@Override
	public String studentPic(String pro_id, String student_id) {

		return this.studentDAO.studentPic(pro_id, student_id);

	}*/

	// scoreCheck_os04
	// ���� - ��������>�������>�������� ���� >���������� >���輱��>��ü������ �������� - �׹�° ���̺� #HJ
	// ������ �������
	@Override
	public int addScore(Student s) {
		// TODO Auto-generated method stub
		return this.studentDAO.addScore(s);
	}

	// scoreCheck_os04
	// ���� - ��������>�������>�������� ���� >���������� >���輱��>��ü������ �������� - �׹�° ���̺� #HJ
	// ������ ��������
	@Override
	public int removeScore(String student_id, String test_id) {
		// TODO Auto-generated method stub
		return this.studentDAO.removeScore(student_id, test_id);
	}

	// scoreCheck_student01
	// ���� - ��������>����������>���������� #HJ
	@Override
	public List<Student> insStudentAll(String pro_id, int pageStart, int pageCount) {

		return this.studentDAO.insStudentAll(pro_id, pageStart, pageCount);
	}

	// scoreCheck_student01
	// ���� - ��������>����������>���������� #HJ
	@Override
	public List<Student> insStudentKeyValue(String pro_id, String key, String value, int pageStart, int pageCount) {

		return this.studentDAO.insStudentKeyValue(pro_id, key, value, pageStart, pageCount);
	}

	// scoreCheck_student01
	// ���� - ��������>����������>���������� #HJ
	@Override
	public int insStudentTotalCount(String pro_id) {
		return this.studentDAO.insStudentTotalCount(pro_id);
	}

	// scoreCheck_student02
	// ���� - ��������>����������>����������>������������ - ù���� ���̺� #HJ
	@Override
	public Student choiceInsStudent(String pro_id, String student_id) {
		// TODO Auto-generated method stub
		return this.studentDAO.choiceInsStudent(pro_id, student_id);
	}

	// scoreCheck_student05
	// ���� - ��������>����������>����������>������������>����������>���輱�� - ������ ���̺� #HJ
	@Override
	public List<Student> studentScoreList(String pro_id, String test_id , String open_course_id, String student_id) {
		// TODO Auto-generated method stub
		return this.studentDAO.studentScoreList( pro_id,  test_id ,  open_course_id,  student_id);
	}
	/******************************************************************************/
	//수강생 개인조회
	@Override
	public Student student_info(Login l) {
		Student result = this.studentDAO.student_info(l);
		return result;
	}
	
	//수강생 비밀번호 업데이트
	@Override
	public int pw_update(Student s) {
		return this.studentDAO.pw_update(s);
	}
	
	//수강생 대쉬보드
	@Override
	public List<OpenCourse> studentDashboard(Login l) {
		List<OpenCourse> result = this.studentDAO.studentDashboard(l);
		return result;
	}

	//수강생 성적조회 개설과정
	@Override
	public List<OpenCourse> studentOC(Login l) {
		List<OpenCourse> result = this.studentDAO.studentOC(l);
		return result;
	}
	
	@Override
	public OpenCourse studentOC01(Login l, String open_course_id) {
		OpenCourse oc = this.studentDAO.studentOC01(l, open_course_id);
		return oc;
	}
	
	@Override
	public List<OpenSubject> studentOS(Login l, String open_course_id) {
		List<OpenSubject> result = this.studentDAO.studentOS(l, open_course_id);
		return result;
	}
	
	@Override
	public OpenSubject studentOS01(Login l, String open_sub_id) {
		OpenSubject os = this.studentDAO.studentOS01(l, open_sub_id);
		return os;
	}
	
	@Override
	public List<Test> studentTestPoint(Login l, String open_sub_id) {
		List<Test> result = this.studentDAO.studentTestPoint(l, open_sub_id);
		return result;
	}
	
	@Override
	public Test studentTestPoint01(Login l, String test_id) {
		Test t = null;
		try {
			t = this.studentDAO.studentTestPoint01(l, test_id);
		}catch(Exception e) {
			
		}
		return t;
	}
	
	@Override
	public List<Student> studentScore(Login l, String open_sub_id, String test_id) {
		
		List<Student> list = this.studentDAO.studentScore(l, open_sub_id, test_id);

		return list;
	}
	

}
