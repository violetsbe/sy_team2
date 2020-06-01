package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Classroom;
import com.mapper.ClassroomViewDeleteMapper;
@Repository("classroomDAO")
public class ClassroomDAOImpl implements ClassroomDAO {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public List<Classroom> list() {
		String sql= "SELECT room_id, r.room_capacity, r.room_name, \r\n" + 
				"   (SELECT COUNT(*)\r\n" + 
				"   FROM open_course oc\r\n" + 
				"   WHERE r.room_id = oc.room_id) count_\r\n" + 
				"FROM classroom r";
		
		List<Classroom> result = this.jdbcTemplateObject.query(sql, new ClassroomViewDeleteMapper());
		return result;
	}

	@Override
	public int classroomInsert(Classroom cr) {
		String sql="INSERT INTO classroom (room_id, room_capacity, room_name)\r\n" + 
				"    VALUES ((SELECT CONCAT('R', LPAD(IFNULL(SUBSTR(MAX(room_id), 2), 0 )+1, 3, 0)) AS newid FROM classroom cr), ?, ?)";
				
		int result = this.jdbcTemplateObject.update(sql, cr.getRoom_capacity(),cr.getRoom_name());
		return result;
	}

	@Override
	public int classroomDelete(Classroom cr) {
		String sql="DELETE FROM classroom\r\n" + 
				"    WHERE room_id = ?";
		int result = this.jdbcTemplateObject.update(sql, cr.getRoom_id());
		return result;
	}

	@Override
	public int classroomUpdate(Classroom cr) {
		String sql="UPDATE classroom\r\n" + 
				"SET room_capacity = ? , room_name = ?\r\n" + 
				"WHERE room_id = ?";
		int result = this.jdbcTemplateObject.update(sql, cr.getRoom_capacity(),cr.getRoom_name(),cr.getRoom_id());
		return result;
	}


	

	
}
