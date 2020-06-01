package com.persistence;

import java.util.List;

import com.domain.Subject;

public interface SubjectDAO {

	//과목관리 출력
	//과목아이디 과목명 삭제여부
	public List<Subject> list();
	
	
	//과목입력
	public int subjectInsert(Subject s);
	
	
	//과목삭제
	public int subjectDelete(Subject s);
	
	
	//과목수정
	public int subjectUpdate(Subject s);
}
