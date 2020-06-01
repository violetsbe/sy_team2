package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.Student;
import com.mapper.Insert_CourseListMapper;
import com.mapper.Insert_RoomListMapper;
import com.mapper.OpenCourseProgressMapper;
import com.mapper.OpenCourseRowMapper;
import com.mapper.OpenCourseStatusMapper;
import com.mapper.StudentInformationMapper03;
import com.mapper.StudentPossibleCourseMapper;

@Repository("openCourseDAO")
public class OpenCourseImpl implements OpenCourseDAO {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public List<OpenCourse> list() {
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				" , (SELECT COUNT(*) \r\n" + 
				"   FROM course_history chis\r\n" + 
				"   WHERE chis.open_course_id = oc.open_course_id) total_student\r\n" + 
				"    FROM open_course oc, course c, classroom cr\r\n" + 
				"    WHERE oc.course_id = c.course_id\r\n" + 
				"    AND oc.room_id = cr.room_id\r\n" + 
				"    ORDER BY oc.open_course_id\r\n" + 
				"LIMIT 10;\r\n";
		
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper());
		return result;
	}
	
	@Override
	public List<OpenCourse> list(String open_course_id) {
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				" , (SELECT COUNT(*) \r\n" + 
				"   FROM course_history chis\r\n" + 
				"   WHERE chis.open_course_id = oc.open_course_id) total_student\r\n" + 
				"    FROM open_course oc, course c, classroom cr\r\n" + 
				"    WHERE oc.course_id = c.course_id\r\n" + 
				"    AND oc.room_id = cr.room_id\r\n" + 
				"    AND open_course_id = ? \r\n" +
				"    ORDER BY oc.open_course_id";
	
		return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper()
												, open_course_id);
	}
	
	@Override
	public List<OpenCourse> list(String key, String value) {
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				" , (SELECT COUNT(*) \r\n" + 
				"   FROM course_history chis\r\n" + 
				"   WHERE chis.open_course_id = oc.open_course_id) total_student\r\n" + 
				"    FROM open_course oc, course c, classroom cr\r\n" + 
				"    WHERE oc.course_id = c.course_id\r\n" + 
				"    AND oc.room_id = cr.room_id";
		
		if(key.equals("open_course_id")) {
			sql += " AND oc.open_course_id = ? ";
		}else if(key.equals("course_name")) {
			sql += " AND INSTR(course_name , ? ) > 0 ";
		}
		 sql += "  ORDER BY oc.open_course_id LIMIT 10";
		
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), value);
		
		return result;
	}

	
	@Override
	public List<OpenCourse> list(int pageStart, int pageCount){
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				" , (SELECT COUNT(*) \r\n" + 
				"   FROM course_history chis\r\n" + 
				"   WHERE chis.open_course_id = oc.open_course_id) total_student\r\n" + 
				"    FROM open_course oc, course c, classroom cr\r\n" + 
				"    WHERE oc.course_id = c.course_id\r\n" + 
				"    AND oc.room_id = cr.room_id\r\n" +
				"    LIMIT ?,?";
		
		return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pageStart, pageCount);
	}
	
	@Override
	public List<OpenCourse> list(String key, String value, int pageStart, int pageCount) {
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				" , (SELECT COUNT(*) \r\n" + 
				"   FROM course_history chis\r\n" + 
				"   WHERE chis.open_course_id = oc.open_course_id) total_student\r\n" + 
				"    FROM open_course oc, course c, classroom cr\r\n" + 
				"    WHERE oc.course_id = c.course_id\r\n" + 
				"    AND oc.room_id = cr.room_id\r\n";
		
		if(key.equals("open_course_id")){
			sql+="AND open_course_id = ?\r\n";
		} else if(key.equals("course_name")){
			sql+="AND INSTR(course_name, ?)>0 \r\n";
		}
		sql += "ORDER BY open_course_id LIMIT ?,?";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(),value, pageStart, pageCount);
		
		return result;
	}
	
	@Override
	public int totalCount() {
		String sql = "SELECT COUNT(*) as count_ FROM open_course";
		
		return this.jdbcTemplateObject.queryForObject(sql, Integer.class);
	}

	@Override
	public int openCourseInsert(OpenCourse oc) {
		String sql="INSERT INTO open_course(open_course_id, course_id, room_id, course_start_date, course_end_date)\r\n" + 
				"VALUES ((SELECT CONCAT('OC', LPAD(IFNULL(SUBSTR(MAX(open_course_id), 3), 0)+1, 3, 0)) AS newid FROM open_course oc)\r\n" + 
				"      , ?, ?, ?, ?)";
		int result = this.jdbcTemplateObject.update(sql, oc.getCourse_id(), oc.getRoom_id()
				, oc.getCourse_start_date().toString(), oc.getCourse_end_date().toString());
		return result;
	}

	@Override
	public int openCourseDelete(OpenCourse oc) {
		String sql="DELETE FROM open_course\r\n" + 
				"WHERE open_course_id = ? ";
		int result = this.jdbcTemplateObject.update(sql, oc.getOpen_course_id());
		return result;
	}

	@Override
	public int openCourseUpdate(OpenCourse oc) {
		String sql="UPDATE open_course\r\n" + 
				"SET course_start_date = ?, course_end_date = ?, room_id = ?\r\n" + 
				"WHERE open_course_id = ? ";
		int result = this.jdbcTemplateObject.update(sql,oc.getCourse_start_date().toString(), oc.getCourse_end_date().toString() 
				, oc.getRoom_id(), oc.getOpen_course_id());
		return result;
	}

	@Override
	public OpenCourse tablesstudentcount(String open_course_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, course_start_date,\r\n" + 
				"	course_end_date, cr.room_name\r\n" + 
				"	, (SELECT COUNT(*) FROM course_history\r\n" + 
				"			WHERE open_course_id = oc.open_course_id) as total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND oc.open_course_id = ? LIMIT 10\r\n";
		OpenCourse result = this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), open_course_id);
		return result;
	}

	@Override
	public List<Student> tablesstudentcount2(String open_course_id, int pageStart) {
		String sql = "SELECT s.student_id, student_name, phone, s_reg_date,\r\n" + 
				"   (SELECT COUNT(*) FROM course_history \r\n" + 
				"		WHERE student_id = s.student_id) as s_courseCount\r\n" + 
				"FROM student s, course_history ch\r\n" + 
				"WHERE s.student_id = ch.student_id\r\n" + 
				"AND ch.open_course_id = ? " +
				"ORDER BY s.student_id LIMIT ?,10 ";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentInformationMapper03(), open_course_id, pageStart);
		return result; 
	}
	
	@Override
	public List<Student> tablesstudentcount2(String open_course_id, String key, String value, int pageStart) {
		String sql = "SELECT s.student_id, student_name, phone, s_reg_date,\r\n" + 
				"   (SELECT COUNT(*) FROM course_history \r\n" + 
				"		WHERE student_id = s.student_id) as s_courseCount\r\n" + 
				"FROM student s, course_history ch\r\n" + 
				"WHERE s.student_id = ch.student_id\r\n" + 
				"AND ch.open_course_id = ? " ;
		if(key.equals("student_id")) {
			sql += "AND s.student_id = ? ";
		}else if(key.equals("student_name")) {
			sql += "AND INSTR(s.student_name , ?) > 0  ";
		}else if(key.equals("s_courseCount")) {
			sql += "AND (SELECT COUNT(*) FROM course_history WHERE student_id = s.student_id) = ? ";
		}
			sql += "ORDER BY s.student_id LIMIT ?, 10 ";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentInformationMapper03(), open_course_id, value, pageStart);
		return result; 
	}
	
	@Override
	public int tablesstudent_totalCount(String open_course_id) {
		String sql = "SELECT count(*) " + 
				"FROM student s, course_history ch\r\n" + 
				"WHERE s.student_id = ch.student_id\r\n" + 
				"AND ch.open_course_id = ? " +
				"ORDER BY s.student_id ";
		return this.jdbcTemplateObject.queryForObject(sql, Integer.class, open_course_id);
	}

	@Override
	public List<OpenCourse> courseList() {
		String sql = "SELECT course_id, course_name FROM course ORDER BY course_id ";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new Insert_CourseListMapper());
		return result;
	}


	@Override
	public List<OpenCourse> roomList() {
		String sql = "SELECT room_id, room_capacity, room_name FROM classroom ORDER BY room_id ";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new Insert_RoomListMapper());
		return result;
	}


	@Override
	public List<OpenCourse> studentOpenCourse(String student_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date,\r\n" + 
				"	oc.course_end_date, cl.room_name,\r\n" + 
				"    (SELECT count(*)  FROM course_history ch \r\n" + 
				"    WHERE oc.open_course_id = open_course_id ) total_student\r\n" + 
				"FROM open_course oc, course c, classroom cl, course_history ch\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"	AND cl.room_id = oc.room_id\r\n" + 
				"    AND ch.open_course_id = oc.open_course_id\r\n" + 
				"    AND ch.student_id = ?\r\n" + 
				"ORDER BY open_course_id ";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), student_id);
		return result;
	}

	@Override
	public List<OpenCourse> possibleCourse(String student_id) {
		String sql = "SELECT open_course_id, course_name, course_start_date, course_end_date, room_name\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND NOW() < course_start_date\r\n" + 
				"AND open_course_id NOT IN (SELECT oc1.open_course_id\r\n" + 
				"								FROM open_course oc1, course_history ch\r\n" + 
				"                                WHERE oc1.open_course_id = ch.open_course_id\r\n" + 
				"                                AND student_id = ?)";
		
		return this.jdbcTemplateObject.query(sql, new StudentPossibleCourseMapper(), student_id);
	}
	
	@Override
	public List<OpenCourse> courseCansle(String student_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, course_start_date\r\n" + 
				"	, course_end_date, cr.room_name\r\n" + 
				"FROM open_course oc, course c, classroom cr, course_history ch, student s\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND oc.open_course_id = ch.open_course_id\r\n" + 
				"AND s.student_id = ch.student_id\r\n" + 
				"AND ch.student_id = ?\r\n" + 
				"AND course_end_date > NOW()";
				
		return this.jdbcTemplateObject.query(sql, new StudentPossibleCourseMapper(), student_id);
	}

	@Override
	public int courseHistory(OpenCourse oc) {
		String sql = "INSERT INTO course_history (student_id, open_course_id, enrollment_date)"
				+ "	VALUES (?, ? ,curdate())";
		
		return this.jdbcTemplateObject.update(sql, oc.getStudent_id(), oc.getOpen_course_id());
	}

	@Override
	public int courseHistoryDel(OpenCourse oc) {
		String sql = "DELETE FROM course_history WHERE student_id=? AND open_course_id=?";
		
		return this.jdbcTemplateObject.update(sql, oc.getStudent_id(), oc.getOpen_course_id());
	}

	
	
	/********************************************************************/
	
	//강사 대시보드 상단		#BR 
	@Override
	public List<OpenCourse> insProgressOCList(Login l) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
				"	, cr.room_name\r\n" + 
				"    , (SELECT COUNT(*) \r\n" + 
				"					FROM course_history ch \r\n" + 
				"					WHERE open_course_id = oc.open_course_id) - (SELECT COUNT(*)\r\n" + 
				"					FROM abandonment ab, course_history ch\r\n" + 
				"                    WHERE ab.student_id = ch.student_id\r\n" + 
				"						AND ch.open_course_id = oc.open_course_id) AS current_student\r\n" + 
				"	, (SELECT COUNT(*)\r\n" + 
				"					FROM abandonment ab, course_history ch\r\n" + 
				"                    WHERE ab.student_id = ch.student_id\r\n" + 
				"						AND ch.open_course_id = oc.open_course_id) AS abandon_student\r\n" + 
				"    , (SELECT COUNT(*) \r\n" + 
				"					FROM course_history ch \r\n" + 
				"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
				"				FROM instructor ins, open_subject os\r\n" + 
				"				WHERE os.pro_id = ins.pro_id\r\n" + 
				"                AND ins.pro_id = ?)	\r\n" + 
				"	AND oc.room_id = cr.room_id\r\n" + 
				"    AND oc.course_start_date <= DATE(now())\r\n" + 
				"    AND oc.course_end_date >= DATE(now())\r\n" + 
				"ORDER BY open_course_id ";
		
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseProgressMapper(), l.getPro_id());
		
		return result;
	}
	
	//강사 - 강의예정 리스트		#BR
	@Override
	public List<OpenCourse> plannedList(String pro_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
				"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
				"					FROM course_history ch \r\n" + 
				"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
				"				FROM instructor ins, open_subject os\r\n" + 
				"				WHERE os.pro_id = ins.pro_id\r\n" + 
				"                AND ins.pro_id = ?)	\r\n" + 
				"	AND oc.room_id = cr.room_id\r\n" + 
				"    AND oc.course_start_date > DATE(now())\r\n" + 
				"ORDER BY oc.open_course_id\r\n" + 
				"LIMIT 10 ";
		
		return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id);
	}

	//강사 - 강의중 리스트		#BR
	@Override
	public List<OpenCourse> ingList(String pro_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
				"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
				"					FROM course_history ch \r\n" + 
				"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
				"				FROM instructor ins, open_subject os\r\n" + 
				"				WHERE os.pro_id = ins.pro_id\r\n" + 
				"                AND ins.pro_id = ?)	\r\n" + 
				"	AND oc.room_id = cr.room_id\r\n" + 
				"    AND oc.course_start_date <= DATE(now())\r\n" + 
				"    AND oc.course_end_date >= DATE(now())\r\n" + 
				"ORDER BY open_course_id\r\n" + 
				"LIMIT 10 ";
		
		return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id);
	}

	//강사 - 강의종료 리스트		#BR
	@Override
	public List<OpenCourse> endList(String pro_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
				"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
				"					FROM course_history ch \r\n" + 
				"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
				"				FROM instructor ins, open_subject os\r\n" + 
				"				WHERE os.pro_id = ins.pro_id\r\n" + 
				"                AND ins.pro_id = ?)	\r\n" + 
				"	AND oc.room_id = cr.room_id\r\n" + 
				"    AND oc.course_end_date < DATE(now())\r\n" + 
				"ORDER BY oc.open_course_id\r\n" + 
				"LIMIT 10 ";
		
		return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id);
	}

		//강사 - 강의스케쥴조회>강의예정 과정 (totalcount)	#BR	20190106
		public int insPlannedTotalcount(String pro_id) {
			String sql = "SELECT COUNT(*) \r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id\r\n" + 
					"    AND oc.course_start_date > DATE(now()) ";
			
			return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		}
		
		//강사 - 강의스케쥴조회>강의중 과정 (totalcount)	#BR	20190106
		public int insIngTotalcount(String pro_id) {
			String sql = "SELECT COUNT(*)\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id\r\n" + 
					"    AND oc.course_start_date <= DATE(now())\r\n" + 
					"    AND oc.course_end_date >= DATE(now()) ";
			
			return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		}
		
		//강사 - 강의스케쥴조회>강의종료 과정 (totalcount)	#BR	20190106
		public int insEndTotalcount(String pro_id) {
			String sql = "SELECT COUNT(*)\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"   AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"            FROM instructor ins, open_subject os\r\n" + 
					"            WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)   \r\n" + 
					"   AND oc.room_id = cr.room_id\r\n" + 
					"    AND oc.course_end_date < DATE(now())\r\n" + 
					"ORDER BY oc.open_course_id ";
			return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		}
		

		// 강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과정조회 #BR 20190109 #####
		@Override
		public List<OpenCourse> plannedList(String pro_id, String key, String value, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "   AND oc.course_start_date > DATE(now())\r\n";

			if (key.equals("open_course_id")) {
				sql += " AND oc.open_course_id = ? ";
			} else if (key.equals("course_name")) {
				sql += " AND INSTR(course_name , ? ) > 0 ";
			}
			sql += "  ORDER BY oc.open_course_id LIMIT ?, ?";
			
			return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id, value, pageStart, pageCount);
		}

		// 강사 - 강의스케쥴조회>강의일정별 조회>강의중 과정조회 #BR 20190109 #####
		@Override
		public List<OpenCourse> ingList(String pro_id, String key, String value, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
					"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
					"					FROM course_history ch \r\n" + 
					"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id\r\n" + 
					"    AND oc.course_start_date <= DATE(now())\r\n" + 
					"    AND oc.course_end_date >= DATE(now())r\n";
			
			if (key.equals("open_course_id")) {
				sql += " AND oc.open_course_id = ? ";
			} else if (key.equals("course_name")) {
				sql += " AND INSTR(course_name , ? ) > 0 ";
			}
			sql += "  ORDER BY oc.open_course_id LIMIT ?, ?";
			
			return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id, value, pageStart, pageCount);
		}

		// 강사 - 강의스케쥴조회>강의일정별 조회>강의완료 과정조회 #BR 20190109 #####
		@Override
		public List<OpenCourse> endList(String pro_id, String key, String value, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
					"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
					"					FROM course_history ch \r\n" + 
					"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id\r\n" + 
					"    AND oc.course_end_date < DATE(now())\r\n";
			
			if (key.equals("open_course_id")) {
				sql += " AND oc.open_course_id = ? ";
			} else if (key.equals("course_name")) {
				sql += " AND INSTR(course_name , ? ) > 0 ";
			}
			sql += "  ORDER BY oc.open_course_id LIMIT ?, ?";
			
			return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id, value, pageStart, pageCount);
		}
		
		// 강사 - 특정 강의예정 과정 #BR 20190106
		@Override
		public OpenCourse plannedOpenCourse(String pro_id, String open_course_id) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "    AND oc.course_start_date > DATE(now())\r\n"
					+ "	AND oc.open_course_id = ? ";

			return this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), pro_id, open_course_id);
		}

		// 강사 - 특정 강의중 과정 #BR 20190106
		@Override
		public OpenCourse ingOpenCourse(String pro_id, String open_course_id) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "    AND oc.course_start_date <= DATE(now())\r\n"
					+ "    AND oc.course_end_date >= DATE(now())\r\n" 
					+ "    AND oc.open_course_id = ?\r\n";

			return this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), pro_id, open_course_id);
		}

		// 강사 - 특정 강의종료 과정 #BR 20190106
		@Override
		public OpenCourse endOpenCourse(String pro_id, String open_course_id) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "    AND oc.course_end_date < DATE(now())\r\n"
					+ "    AND oc.open_course_id = ?\r\n";

			return this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), pro_id, open_course_id);
		}

		// 강사 - 개설과정별 전체수강생 조회(담당 전체 과정 리스트) #BR 20190106
		@Override
		public List<OpenCourse> insAllList(String pro_id) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "ORDER BY oc.open_course_id\r\n";

			return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id);
		}
		
		//강사 - 개설과정별 전체수강생 조회(담당 과정 리스트 검색)	#BR	20190109 #####
		public List<OpenCourse> insAllList(String pro_id, String key, String value, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n" + 
					"	, cr.room_name, (SELECT COUNT(*) \r\n" + 
					"					FROM course_history ch \r\n" + 
					"					WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id ";
			
			if (key.equals("open_course_id")) {
				sql += " AND oc.open_course_id = ? ";
			} else if (key.equals("course_name")) {
				sql += " AND INSTR(course_name , ? ) > 0 ";
			}
			sql += "  ORDER BY oc.open_course_id LIMIT ?, ?";
			
			return this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id, value, pageStart, pageCount);
		}
		
		//강사 - 개설과정별 전체수강생 조회 (totalcount)	#BR	20190106
		public int insAllTotalcount(String pro_id) {
			String sql = "SELECT COUNT(*)\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"	AND oc.open_course_id IN (SELECT os.open_course_id \r\n" + 
					"				FROM instructor ins, open_subject os\r\n" + 
					"				WHERE os.pro_id = ins.pro_id\r\n" + 
					"                AND ins.pro_id = ?)	\r\n" + 
					"	AND oc.room_id = cr.room_id ";
			
			return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		}
		

		// 강사 - 개설과정별 전체수강생 조회(선택한 특정 과정) #BR 20190106
		public OpenCourse insOCstudent(String pro_id, String open_course_id) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date\r\n"
					+ "	, cr.room_name, (SELECT COUNT(*) \r\n" 
					+ "					FROM course_history ch \r\n"
					+ "					WHERE open_course_id = oc.open_course_id) AS total_student\r\n"
					+ "FROM open_course oc, course c, classroom cr\r\n" 
					+ "WHERE oc.course_id = c.course_id\r\n"
					+ "	AND oc.open_course_id IN (SELECT os.open_course_id \r\n"
					+ "				FROM instructor ins, open_subject os\r\n"
					+ "				WHERE os.pro_id = ins.pro_id\r\n" 
					+ "                AND ins.pro_id = ?)	\r\n"
					+ "	AND oc.room_id = cr.room_id\r\n" 
					+ "    AND oc.open_course_id = ?\r\n";

			return this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), pro_id, open_course_id);
		}

	
	

	/********************************************************************/
		/********************************************************************/
		//
		//scoreCheck_os01
		//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
		@Override
		public List<OpenCourse> insListAll(String pro_id, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
					"    (SELECT COUNT(*) FROM course_history ch\r\n" + 
					"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM instructor ins, open_subject os, test t\r\n" + 
					"WHERE ins.pro_id = os.pro_id\r\n" + 
					"AND t.open_sub_id = os.open_sub_id\r\n" + 
					"AND ins.pro_id = ?)\r\n" + 
					"ORDER BY oc.open_course_id Limit ?,?";
			
			List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id,  pageStart,  pageCount);
			return result;
		}
		
		
		//
		//scoreCheck_os01
		//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
		@Override
		public List<OpenCourse> insListKeyValue(String pro_id, String key, String value, int pageStart, int pageCount) {
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
					"    (SELECT COUNT(*) FROM course_history ch\r\n" + 
					"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM instructor ins, open_subject os, test t\r\n" + 
					"WHERE ins.pro_id = os.pro_id\r\n" + 
					"AND t.open_sub_id = os.open_sub_id\r\n" + 
					"AND ins.pro_id = ?)\r\n";
			
			if(key.equals("open_course_id")){
				sql += "AND open_course_id = ?";
			}else if(key.equals("course_name")) {
				sql += "AND INSTR(course_name, ?) > 0 ";
			}
			sql += "ORDER BY oc.open_course_id Limit ?, ?";
			
			
			List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), pro_id, value, pageStart, pageCount);
			return result;
		}
		
		
		//
		//scoreCheck_os01
		//강사 - 성적관리 > 과목기준 > 개설과정선택   #HJ
		@Override
		public int insListTotalCount(String pro_id) {
			String sql = "SELECT count(*)\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM instructor ins, open_subject os, test t\r\n" + 
					"WHERE ins.pro_id = os.pro_id\r\n" + 
					"AND t.open_sub_id = os.open_sub_id\r\n" + 
					"AND ins.pro_id = ?)\r\n" + 
					"ORDER BY oc.open_course_id";
			
			return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		}
		
		//
		//scoreCheck_os02
		//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택  - 첫번째 테이블	 #HJ
		@Override
		public OpenCourse choiceInsList(String pro_id, String open_course_id) {
			OpenCourse result = null;
			
			String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
					"    (SELECT COUNT(*) FROM course_history ch\r\n" + 
					"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM instructor ins, open_subject os, test t\r\n" + 
					"WHERE ins.pro_id = os.pro_id\r\n" + 
					"AND t.open_sub_id = os.open_sub_id\r\n" + 
					"AND ins.pro_id = ?)\r\n" + 
					"AND oc.open_course_id = ?\r\n" + 
					"ORDER BY oc.open_course_id";
			
			
			try {
			 result = this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), pro_id, open_course_id);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		//
		//scoreCheck_student02
		//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 - 두번째 테이블 #HJ
		@Override
		public List<OpenCourse> studentOpenCourse(String pro_id, String student_id) {
			
			String sql = "SELECT a.open_course_id, a.course_name, a.course_start_date\r\n" + 
					"   , a.course_end_date, a.room_name, a.total_student\r\n" + 
					"    , b.s_status, b.s_course_end_date\r\n" + 
					"FROM\r\n" + 
					"(SELECT oc.open_course_id, c.course_name, course_start_date\r\n" + 
					"   , course_end_date, cr.room_name\r\n" + 
					"   , (SELECT COUNT(*) FROM course_history\r\n" + 
					"         WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM open_subject os ,test t\r\n" + 
					"WHERE os.pro_id = ?\r\n" + 
					"AND t.open_sub_id = os.open_sub_id)) a\r\n" + 
					",\r\n" + 
					"(SELECT s.student_id, oc.open_course_id,\r\n" + 
					"   IF(ab.student_id IS NOT NULL, '중도포기',\r\n" + 
					"    IF(oc.course_end_date > NOW(), '수료예정', '수료완료')) AS s_status,\r\n" + 
					"    IF(ab.student_id IS NULL, course_end_date, class_end_date) s_course_end_date   \r\n" + 
					"FROM student s LEFT JOIN abandonment ab\r\n" + 
					"ON s.student_id = ab.student_id\r\n" + 
					", course_history ch, open_course oc\r\n" + 
					"WHERE ch.student_id = s.student_id\r\n" + 
					"AND ch.open_course_id = oc.open_course_id) b\r\n" + 
					"WHERE a.open_course_id = b.open_course_id\r\n" + 
					"AND b.student_id = ?";
			
			
			return this.jdbcTemplateObject.query(sql, new OpenCourseStatusMapper(), pro_id, student_id);
		}
		
		//
		//scoreCheck_student03
		//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 > 개설과목선택 - 두번째 테이블 #HJ
		@Override
		public OpenCourse choiceStudentOpenCourse(String pro_id, String student_id, String open_course_id) {
			String sql = "SELECT a.open_course_id, a.course_name, a.course_start_date\r\n" + 
					"   , a.course_end_date, a.room_name, a.total_student\r\n" + 
					"    , b.s_status, b.s_course_end_date\r\n" + 
					"FROM\r\n" + 
					"(SELECT oc.open_course_id, c.course_name, course_start_date\r\n" + 
					"   , course_end_date, cr.room_name\r\n" + 
					"   , (SELECT COUNT(*) FROM course_history\r\n" + 
					"         WHERE open_course_id = oc.open_course_id) AS total_student\r\n" + 
					"FROM open_course oc, course c, classroom cr\r\n" + 
					"WHERE oc.course_id = c.course_id\r\n" + 
					"AND oc.room_id = cr.room_id\r\n" + 
					"AND oc.open_course_id IN (SELECT os.open_course_id\r\n" + 
					"FROM open_subject os ,test t\r\n" + 
					"WHERE os.pro_id = ?\r\n" + 
					"AND t.open_sub_id = os.open_sub_id)) a\r\n" + 
					",\r\n" + 
					"(SELECT s.student_id, oc.open_course_id,\r\n" + 
					"   IF(ab.student_id IS NOT NULL, '중도포기',\r\n" + 
					"    IF(oc.course_end_date > NOW(), '수료예정', '수료완료')) AS s_status,\r\n" + 
					"    IF(ab.student_id IS NULL, course_end_date, class_end_date) s_course_end_date   \r\n" + 
					"FROM student s LEFT JOIN abandonment ab\r\n" + 
					"ON s.student_id = ab.student_id\r\n" + 
					", course_history ch, open_course oc\r\n" + 
					"WHERE ch.student_id = s.student_id\r\n" + 
					"AND ch.open_course_id = oc.open_course_id) b\r\n" + 
					"WHERE a.open_course_id = b.open_course_id\r\n" + 
					"AND b.student_id = ?\r\n" + 
					"AND a.open_course_id = ?";
			
			return this.jdbcTemplateObject.queryForObject(sql, new OpenCourseStatusMapper(), pro_id, student_id, open_course_id);
		}
		
	}



