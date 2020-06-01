package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.domain.Subject;
import com.mapper.SubjectViewDeleteMapper;

@Repository("subjectDAO")
public class SubjectDAOImpl implements SubjectDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public List<Subject> list() {
		String sql= "SELECT subject_id, subject_name,\r\n" + 
				"      (SELECT COUNT(*)\r\n" + 
				"      FROM open_subject os\r\n" + 
				"      WHERE os.subject_id = s.subject_id) count_\r\n" + 
				"FROM subject_ s";
		List<Subject> result = this.jdbcTemplateObject.query(sql, new SubjectViewDeleteMapper());
		return result;
	}
	
	@Override
	
	public int subjectInsert(Subject s) {
		String sql="INSERT INTO subject_ (subject_id, subject_name)\r\n" + 
				"VALUES ((SELECT CONCAT('SUB', LPAD(IFNULL(SUBSTR(MAX(subject_id), 4), 0 )+1, 3, 0)) AS newid FROM subject_ s), ?)";
		int result = this.jdbcTemplateObject.update(sql, s.getSubject_name());
		return result;
	}

	@Override
	public int subjectDelete(Subject s) {
		String sql="DELETE FROM subject_\r\n" + 
				"WHERE subject_id = ?";
		int result = this.jdbcTemplateObject.update(sql,s.getSubject_id());
		return result;
	}

	@Override
	public int subjectUpdate(Subject s) {
		String sql="UPDATE subject_\r\n" + 
				"SET subject_name = ?\r\n" + 
				"WHERE subject_id = ?";
		int result = this.jdbcTemplateObject.update(sql,s.getSubject_name(),s.getSubject_id());
		return result;
	}



}
