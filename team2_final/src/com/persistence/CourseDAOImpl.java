package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Course;
import com.mapper.CourseViewDeleteMapper;
@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public List<Course> list() {
		String sql= "SELECT course_id, course_name, \r\n" + 
				"        (SELECT COUNT(*) \r\n" + 
				"            FROM open_course oc \r\n" + 
				"            WHERE oc.course_id = c.course_id) count_\r\n" + 
				"FROM course c";
		List<Course> result = this.jdbcTemplateObject.query(sql, new CourseViewDeleteMapper());
		return result;
	}

	@Override
	public int courseInsert(Course c) {
		String sql="INSERT INTO course (course_id, course_name)\r\n" + 
				"VALUES ((SELECT CONCAT('C', LPAD(IFNULL(SUBSTR(MAX(course_id), 2), 0 )+1, 3, 0)) AS newid FROM course c), ?)";
		int result = this.jdbcTemplateObject.update(sql, c.getCourse_name());
		return result;
	}

	@Override
	public int courseUpdate(Course c) {
		String sql="UPDATE course\r\n" + 
				"SET course_name = ?\r\n" + 
				"WHERE course_id = ?";
		int result = this.jdbcTemplateObject.update(sql,c.getCourse_name(),c.getCourse_id());
		return result;
	}

	@Override
	public int courseDelete(Course c) {
		String sql="DELETE FROM course\r\n" + 
				"WHERE course_id = ?";
		int result = this.jdbcTemplateObject.update(sql,c.getCourse_id());
		return result;
	}

	
	

	

}
