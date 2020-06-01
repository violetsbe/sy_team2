package com.service;

import java.util.List;

import com.domain.Subject;

public interface SubjectService {

	//과목 출력
	public List<Subject> list();
	
	//과목 추가
	public int subjectInsert(Subject s);
	
	//과목 삭제
	public int subjectDelete(Subject s);
		
	//과목 수정
	public int subjectUpdate(Subject s);
			

	
}

