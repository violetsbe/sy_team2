package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Instructor;
import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Test;
import com.mapper.AutoTest_idMapper;
import com.mapper.InstructorInfoMapper02;
import com.mapper.InstructorMapper;
import com.mapper.OpenCourseRowMapper;
import com.mapper.OpenSubjectDefaultMapper;
import com.mapper.TestRowMapper;
import com.mapper.autoPro_idMapper;

@Repository("instructorDAO")
public class InstructorDAOImpl implements InstructorDAO {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	// 강사계정관리 강사정보출력
	@Override
	public List<Instructor> list() {
		String sql = "SELECT i.pro_id, i.pro_name, i.pro_phone, i.p_reg_date\r\n"
				+ "    , (SELECT GROUP_CONCAT(s.subject_name)\r\n" + "    FROM subject_ s, possible_course pc\r\n"
				+ "    WHERE pc.subject_id = s.subject_id\r\n" + "    AND pc.pro_id = i.pro_id)  possible_sub \r\n"
				+ "    , (SELECT COUNT(pro_id) FROM open_subject WHERE pro_id = i.pro_id) AS count_ \r\n"
				+ "    FROM instructor i";
		List<Instructor> result = this.jdbcTemplateObject.query(sql, new InstructorMapper());
		return result;
	}

	@Override
	public List<Instructor> list(String key, String value, String pageStart, String pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	// 강사계정관리 강사정보등록
	@Override
	public int insert(Instructor i) {
		String sql = "INSERT INTO instructor (pro_id, pro_name, pro_phone, p_reg_date, pro_pw)\r\n"
				+ "VALUES ((SELECT CONCAT('I', LPAD(IFNULL(SUBSTR(MAX(pro_id), 2), 0 )+1, 3, 0)) AS newid FROM instructor i), ?, ?, ?, ? )";

		int result = this.jdbcTemplateObject.update(sql, i.getPro_name(), i.getPro_phone(), i.getP_reg_date(),
				i.getPro_pw());
		return result;
	}
	
	@Override
	public Instructor auto_pro_id() {
		String sql ="(SELECT CONCAT('I', LPAD(IFNULL(SUBSTR(MAX(pro_id), 2), 0 )+1, 3, 0)) AS pro_id FROM instructor i)";
		Instructor result = this.jdbcTemplateObject.queryForObject(sql, new autoPro_idMapper());
		return result;
	}
	
	//강의가능과목 등록
	@Override
	public int pc_insert(String pro_id, String subject_id) {
		String sql = "INSERT INTO possible_course (subject_id, pro_id)"
				+ " VALUES (? , ?)";
		int result = this.jdbcTemplateObject.update(sql, subject_id, pro_id);
		return result;
	}

	

	// 강사계정관리 강사정보삭제
	@Override
	public int delete(Instructor i) {
		String sql = "DELETE FROM instructor\r\n" + "WHERE pro_id = ?";
		int result = this.jdbcTemplateObject.update(sql, i.getPro_id());
		return result;
	}

	// 강사계정관리 강사정보수정
	@Override
	public int update(Instructor i) {
		String sql = "UPDATE instructor\r\n" + "SET pro_name=?, pro_phone=?\r\n" + "WHERE pro_id = ?";
		int result = this.jdbcTemplateObject.update(sql, i.getPro_name(), i.getPro_phone(), i.getPro_id());
		return result;
	}

	// 강사계정관리 강사 PW초기화
	@Override
	public int pw_init(Instructor i) {
		String sql = "UPDATE instructor\r\n" + "SET pro_pw = ?\r\n" + "WHERE pro_id = ?";
		int result = this.jdbcTemplateObject.update(sql, i.getPro_pw(), i.getPro_id());
		return result;
	}

	// 강사계정관리 사진등록
	@Override
	public int picture_insert(Instructor i) {
		String sql = "INSERT INTO i_picturelist(i_picture_id, i_file_name,pro_id)\r\n"
				+ "VALUES ((SELECT CONCAT('IPIC', LPAD(IFNULL(SUBSTR(MAX(i_picture_id), 5), 0 )+1, 3, 0)) AS newid FROM i_picturelist ip)\r\n"
				+ "      , ?, ?)";
		int result = this.jdbcTemplateObject.update(sql, i.getI_file_name(), i.getPro_id());
		return result;
	}

	/********************************************************************************************/
	// 강사 개인정보 조회 #BR
	@Override
	public Instructor instructor_info(String pro_id) {
		String sql = "SELECT ins.pro_id, pro_name, pro_phone, p_reg_date, i_file_name\r\n"
				+ "FROM instructor ins LEFT JOIN i_picturelist i ON ins.pro_id = i.pro_id\r\n"
				+ "WHERE ins.pro_id = ?\r\n";

		return this.jdbcTemplateObject.queryForObject(sql, new InstructorInfoMapper02(), pro_id);
	}

	// 강사 비밀번호 변경 #BR
	@Override
	public int pw_update(Instructor i) {
		String sql = "UPDATE instructor\r\n" + "SET pro_pw = ?\r\n" + "WHERE pro_id = ? AND pro_pw = ?\r\n";

		return this.jdbcTemplateObject.update(sql, i.getPro_newPw(), i.getPro_id(), i.getPro_pw());
	}
	
	//kbs--------------------------------------------------------------------------------------------------------------------------------------------------
	//강사 배점관리 개설과정 List
	@Override
	public List<OpenCourse> insCourseList(Login l, int pageStart, int pageCount) {
		String sql ="SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
				"    (SELECT COUNT(*)\r\n" + 
				"        FROM course_history ch\r\n" + 
				"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND oc.open_course_id IN(SELECT os.open_course_id\r\n" + 
				"							FROM instructor ins, open_subject os\r\n" + 
				"							WHERE ins.pro_id = os.pro_id \r\n" + 
				"							AND ins.pro_id = ?) \r\n" +	
				"ORDER BY oc.open_course_id LIMIT ?, ?";
		List<OpenCourse> list = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), l.getPro_id(), pageStart, pageCount);
		return list;
	}
	
	@Override
	public List<OpenCourse> insCourseList(Login l, String key, String value, int pageStart, int pageCount) {
		String sql ="SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
				"    (SELECT COUNT(*)\r\n" + 
				"        FROM course_history ch\r\n" + 
				"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND oc.open_course_id IN(SELECT os.open_course_id\r\n" + 
				"							FROM instructor ins, open_subject os\r\n" + 
				"							WHERE ins.pro_id = os.pro_id \r\n" + 
				"							AND ins.pro_id = ?) \r\n";
		
		if(key.equals("open_course_id")) {
			sql +="AND oc.open_course_id = ?\r\n"; 
		}else if(key.equals("course_name")) {
			sql +="AND INSTR(c.course_name, ?) > 0\r\n";
		}
		
		sql +="ORDER BY oc.open_course_id LIMIT ?, ?";
		List<OpenCourse> list = this.jdbcTemplateObject.query(sql, new OpenCourseRowMapper(), l.getPro_id(), value, pageStart, pageCount);
		return list;
	}
	
	//강사 배점관리 개설과정 totalcount
	@Override
	public int insTestOpenCourseTotalCount(String pro_id) {
		String sql = "SELECT COUNT(*) FROM open_course\r\n" + 
				"WHERE open_course_id IN(SELECT os.open_course_id\r\n" + 
				"							FROM instructor ins, open_subject os\r\n" + 
				"							WHERE ins.pro_id = os.pro_id \r\n" + 
				"							AND ins.pro_id = ?)";
		int totalcount = this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
		return totalcount;
	}
	
	//강사 배점관리 개설과정 Object
	@Override
	public OpenCourse insCourseList(Login l, String open_course_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, oc.course_start_date, oc.course_end_date, cr.room_name,\r\n" + 
				"    (SELECT COUNT(*)\r\n" + 
				"        FROM course_history ch\r\n" + 
				"        WHERE oc.open_course_id = open_course_id) AS total_student\r\n" + 
				"FROM open_course oc, course c, classroom cr\r\n" + 
				"WHERE oc.course_id = c.course_id\r\n" + 
				"AND oc.room_id = cr.room_id\r\n" + 
				"AND oc.open_course_id IN(SELECT os.open_course_id\r\n" + 
				"							FROM instructor ins, open_subject os\r\n" + 
				"							WHERE ins.pro_id = os.pro_id \r\n" + 
				"							AND ins.pro_id = ?)\r\n" + 
				"AND oc.open_course_id = ?\r\n" + 
				"ORDER BY oc.open_course_id";
		OpenCourse oc = this.jdbcTemplateObject.queryForObject(sql, new OpenCourseRowMapper(), l.getPro_id(), open_course_id);
		return oc;
	}

	//강사 배점관리 개설과목 List
	@Override
	public List<OpenSubject> insSubjectList(Login l, String open_course_id) {
		String sql = "SELECT open_sub_id, sub.subject_name, sub_start_date, sub_end_date, book_name, isbn\r\n" + 
				"FROM open_subject os LEFT JOIN book b\r\n" + 
				"ON os.book_id = b.book_id\r\n" + 
				", subject_ sub\r\n" + 
				"WHERE os.open_course_id = ?\r\n" + 
				"AND os.pro_id = ?\r\n" + 
				"AND os.subject_id = sub.subject_id\r\n" + 
				"ORDER BY open_sub_id";
		List<OpenSubject> list = this.jdbcTemplateObject.query(sql, new OpenSubjectDefaultMapper(), open_course_id, l.getPro_id());
		return list;
	}

	//강사 배점관리 개설과목 List
	@Override
	public OpenSubject insSubjectList(Login l, String open_course_id, String open_sub_id) {
		String sql = "SELECT open_sub_id, sub.subject_name, sub_start_date, sub_end_date, book_name, isbn\r\n" + 
				"FROM open_subject os LEFT JOIN book b\r\n" + 
				"ON os.book_id = b.book_id\r\n" + 
				", subject_ sub\r\n" + 
				"WHERE os.open_course_id = ?\r\n" + 
				"AND os.pro_id = ?\r\n" + 
				"AND os.open_sub_id = ?\r\n" + 
				"AND os.subject_id = sub.subject_id\r\n" + 
				"ORDER BY open_sub_id";
		OpenSubject os = this.jdbcTemplateObject.queryForObject(sql, new OpenSubjectDefaultMapper(), open_course_id, l.getPro_id(), open_sub_id);
		return os;
	}

	//강사 배점관리 시험배점 List
	@Override
	public List<Test> insTestList(Login l, String open_sub_id) {
		String sql = "SELECT test_id, test_date, attendance_points, practice_points, written_points, test_q\r\n" + 
				"			, (SELECT COUNT(*) \r\n" + 
				"				FROM score s \r\n" + 
				"                WHERE s.test_id = t.test_id) as count_\r\n" + 
				"FROM test t, open_subject os\r\n" + 
				"WHERE t.open_sub_id = os.open_sub_id\r\n" + 
				"AND t.open_sub_id = ?\r\n" + 
				"AND pro_id = ?\r\n" + 
				"ORDER BY test_id";
		List<Test> list = this.jdbcTemplateObject.query(sql, new TestRowMapper(), open_sub_id, l.getPro_id());
		return list;
	}

	//강사 배점관리 시험 입력
	@Override
	public int testInsert(Test t) {
		String sql = "INSERT INTO test(test_id, attendance_points, practice_points, written_points, test_q, test_date, open_sub_id)\r\n" + 
				"VALUE((SELECT CONCAT('T', LPAD(IFNULL(SUBSTR(MAX(test_id), 3), 0) + 1, 3, 0))AS newId FROM test t), ?, ? ,?, ?, ? ,?)";
		int result = this.jdbcTemplateObject.update(sql, t.getAttendance_points(), t.getPractice_points(), t.getWritten_points(), t.getTest_q(), t.getTest_date(), t.getOpen_sub_id());
		return result;
	}
	//강사 배점관리 시험 입력 test_id 가져오기
	@Override
	public Test auto_test_id() {
		String sql = "SELECT CONCAT('T', LPAD(IFNULL(SUBSTR(MAX(test_id), 3), 0) + 1, 3, 0))AS test_id FROM test t";
		Test t = this.jdbcTemplateObject.queryForObject(sql, new AutoTest_idMapper());
		return t;
	}
	//강사 배점관리 시험 수정
	@Override
	public int testUpdate(Test t) {
		String sql ="UPDATE test\r\n" + 
				"SET\r\n" + 
				"	test_q = ?\r\n" + 
				"    , test_date = ?\r\n" + 
				"    , attendance_points = ?\r\n" + 
				"    , practice_points = ?\r\n" + 
				"    , written_points = ?\r\n" + 
				"WHERE\r\n" + 
				"	test_id = ?";
		int result = this.jdbcTemplateObject.update(sql, t.getTest_q(), t.getTest_date(), t.getAttendance_points(), t.getPractice_points(), t.getWritten_points(), t.getTest_id());
		return result;
	}
	
	//강사 배점관리 시험 삭제
	@Override
	public int testDelete(String test_id) {
		String sql = "DELETE FROM test\r\n" + 
				"WHERE test_id = ?";
		int result = this.jdbcTemplateObject.update(sql, test_id);
		return result;
	}
	//kbs--------------------------------------------------------------------------------------------------------------------------
}