package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Classroom;
import com.persistence.ClassroomDAO;
@Service("classroomService")
public class ClassroomServiceImpl implements ClassroomService{

	@Resource(name="classroomDAO")
	private ClassroomDAO classroomDAO;
	@Override
	public List<Classroom> list() {
		List<Classroom> result = this.classroomDAO.list();
		return result;
	}
	@Override
	public int classroomInsert(Classroom cr) {
		int result = this.classroomDAO.classroomInsert(cr);
		return result;
	}

	@Override
	public int classroomDelete(Classroom cr) {
		int result = this.classroomDAO.classroomDelete(cr);
		return result;
	}

	@Override
	public int classroomUpdate(Classroom cr) {
		int result = this.classroomDAO.classroomUpdate(cr);
		return result;
	}
	
	
	
	
	

}
