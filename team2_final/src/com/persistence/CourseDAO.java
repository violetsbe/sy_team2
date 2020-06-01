package com.persistence;

import java.util.List;

import com.domain.Course;

public interface CourseDAO {

	//과정출력
	public List<Course> list();
	
	
	//과정입력
		public int courseInsert(Course c);
		
		
	//과정삭제
		public int courseDelete(Course c);
		
		
	//과정수정
		public int courseUpdate(Course c);
	}

