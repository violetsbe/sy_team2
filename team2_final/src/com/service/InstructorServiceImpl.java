package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Instructor;
import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Test;
import com.persistence.InstructorDAO;

@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {

	@Resource(name = "instructorDAO")
	private InstructorDAO instructorDAO;

	@Override
	public List<Instructor> list() {

		List<Instructor> result = this.instructorDAO.list();
		return result;
	}

	@Override
	public List<Instructor> list(String key, String value, String pageStart, String pageCount) {

		return this.instructorDAO.list(key, value, pageStart, pageCount);
	}

	@Override
	public int insert(Instructor i, String[] pc_list) {
		int result = 0;
		result = this.instructorDAO.insert(i);

		for (String s : pc_list) {
			if (s.toString() != null && s.toString() != "") {
				this.pc_insert(i.getPro_id(), s.toString());
			}
		}
		return result;
	}
	
	@Override
	public Instructor auto_pro_id() {
		return this.instructorDAO.auto_pro_id();
	}

	

	@Override
	public int pc_insert(String pro_id, String subject_id) {
		return this.instructorDAO.pc_insert(pro_id, subject_id);
	}

	

	@Override
	public int delete(Instructor i) {
		int result = this.instructorDAO.delete(i);
		return result;
	}

	@Override
	public int update(Instructor i) {
		int result = this.instructorDAO.update(i);
		return result;
	}

	@Override
	public int pw_init(Instructor i) {
		int result = this.instructorDAO.pw_init(i);
		return result;
	}

	@Override
	public int picture_insert(Instructor i) {
		int result = this.instructorDAO.picture_insert(i);
		return result;
	}

	@Override
	public Instructor instructor_info(String pro_id) {

		return this.instructorDAO.instructor_info(pro_id);
	}

	@Override
	public int pw_update(Instructor i) {

		return this.instructorDAO.pw_update(i);
	}
	
   //kbs--------------------------------------------------------------------------------------------------------------------------
   
   @Override
   public List<OpenCourse> insCourseList(Login l, int pageStart, int pageCount) {
	   List<OpenCourse> list = this.instructorDAO.insCourseList(l, pageStart, pageCount);
	   return list;
   }
   
	@Override
	public List<OpenCourse> insCourseList(Login l, String key, String value, int pageStart, int pageCount) {
		List<OpenCourse> list = this.instructorDAO.insCourseList(l, key, value, pageStart, pageCount);
		return list;
	}
	
	@Override
	public int insTestOpenCourseTotalCount(String pro_id) {
		int result = this.instructorDAO.insTestOpenCourseTotalCount(pro_id);
		return result;
	}
	
	@Override
	public OpenCourse insCourseList(Login l, String open_course_id) {
		OpenCourse oc = this.instructorDAO.insCourseList(l, open_course_id);
		return oc;
	}
	
	@Override
	public List<OpenSubject> insSubjectList(Login l, String open_course_id) {
		List<OpenSubject> list = this.instructorDAO.insSubjectList(l, open_course_id);
		return list;
	}
	
	@Override
	public OpenSubject insSubjectList(Login l, String open_course_id, String open_sub_id) {
		OpenSubject os = this.instructorDAO.insSubjectList(l, open_course_id, open_sub_id);
		return os;
	}
	
	@Override
	public List<Test> insTestList(Login l, String open_sub_id) {
		List<Test> t = this.instructorDAO.insTestList(l, open_sub_id);
		return t;
	}
	
	@Override
	public int testInsert(Test t) {
		int result = this.instructorDAO.testInsert(t);
		return result;
	}
	
	@Override
	public Test auto_test_id() {
		Test t = this.instructorDAO.auto_test_id();
		return t;
	}
	
	@Override
	public int testUpdate(Test t) {
		int result = this.instructorDAO.testUpdate(t);
		return result;
	}
	
	@Override
	public int testDelete(String test_id) {
		int result = this.instructorDAO.testDelete(test_id);
		return result;
	}
	//kbs--------------------------------------------------------------------------------------------------------------------------

}