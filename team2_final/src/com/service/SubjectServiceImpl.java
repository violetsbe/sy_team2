package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Subject;
import com.persistence.SubjectDAO;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Resource(name="subjectDAO")
	private SubjectDAO subjectDAO;
	
	@Override
	public List<Subject> list() {
		List<Subject> result = this.subjectDAO.list();
		return result;
	}

	@Override
	public int subjectInsert(Subject s) {
		int result = this.subjectDAO.subjectInsert(s);
		return result;
	}
	@Override
	public int subjectDelete(Subject s) {
		int result = this.subjectDAO.subjectDelete(s);
		return result;
	}

	@Override
	public int subjectUpdate(Subject s) {
		int result = this.subjectDAO.subjectUpdate(s);
		return result;
	}




}
