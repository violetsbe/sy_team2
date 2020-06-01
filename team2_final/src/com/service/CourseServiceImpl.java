package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Course;
import com.persistence.CourseDAO;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Resource(name="courseDAO")
	private CourseDAO courseDAO;
	

	@Override
	public List<Course> list() {
		List<Course> result = this.courseDAO.list();
		return result;
	}

	@Override
	public int courseInsert(Course c) {
		int result = this.courseDAO.courseInsert(c);
		return result;
	}

	@Override
	public int courseDelete(Course c) {
		int result = this.courseDAO.courseDelete(c);
		return result;
	}

	@Override
	public int courseUpdate(Course c) {
		int result = this.courseDAO.courseUpdate(c);
		return result;
	}

}
