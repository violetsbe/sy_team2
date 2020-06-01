package com.service;

import java.util.List;

import com.domain.Course;

public interface CourseService {
	//과정 출력
	public List<Course> list();
	
	//과정 추가
	public int courseInsert(Course c);
	
	//과정 삭제
	public int courseDelete(Course c);
		
	//과정 수정
	public int courseUpdate(Course c);

}
