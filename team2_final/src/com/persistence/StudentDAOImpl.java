package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Student;
import com.domain.Test;
import com.mapper.StudentDashboardMapper;
import com.mapper.StudentInformationMapper01;
import com.mapper.StudentInformationMapper03;
import com.mapper.StudentInformationMapper04;
import com.mapper.StudentInformationMapper05;
import com.mapper.StudentInformationMapper06;
import com.mapper.StudentOCMapper;
import com.mapper.StudentOSMapper;
import com.mapper.StudentScoreMapper;
import com.mapper.StudentScoreMapper01;
import com.mapper.StudentScoreMapper02;
import com.mapper.StudentTestMapper;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public List<Student> list(int pageStart, int pageCount) {
		// 수강생전체출력
		String sql = "SELECT student_id, student_name, phone, s_reg_date, \r\n"
				+ "		(SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) s_courseCount\r\n"
				+ "FROM student st ORDER BY student_id Limit ?,?;";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentInformationMapper03(), pageStart,
				pageCount);
		return result;
	}

	@Override
	public List<Student> list(String key, String value) {
		// 수강생전체출력
		String sql = "SELECT student_id, student_name, phone, s_reg_date, \r\n"
				+ "		(SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) s_courseCount\r\n"
				+ "FROM student st\r\n";

		if (key.equals("student_id")) {
			sql += "WHERE student_id = ?";
		} else if (key.equals("student_name")) {
			sql += "WHERE INSTR(student_name, ?) > 0 ";
		} else if (key.equals("phone")) {
			sql += "WHERE INSTR(phone, ?) > 0 ";
		} else if (key.equals("s_reg_date")) {
			sql += "WHERE INSTR(s_reg_date, ?) > 0 ";
		} else if (key.equals("s_courseCount")) {
			sql += "WHERE (SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) = ?";
		}
		sql += "ORDER BY student_id ";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentInformationMapper03(), value);
		return result;
	}

	@Override
	public List<Student> studentCount(String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> studentManage(String key, String value, int pageStart, int pageCount) {
		// 수강생전체출력 + 페이징
		String sql = "SELECT student_id, student_name, phone, s_reg_date, \r\n"
				+ "		(SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) s_courseCount\r\n"
				+ "FROM student st\r\n";

		if (key.equals("student_id")) {
			sql += "WHERE student_id = ?";
		} else if (key.equals("student_name")) {
			sql += "WHERE INSTR(student_name, ?) > 0 ";
		} else if (key.equals("phone")) {
			sql += "WHERE INSTR(phone, ?) > 0 ";
		} else if (key.equals("s_reg_date")) {
			sql += "WHERE INSTR(s_reg_date, ?) > 0 ";
		} else if (key.equals("s_courseCount")) {
			sql += "WHERE (SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) = ?";
		}
		sql += "ORDER BY student_id Limit ?, ?";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentInformationMapper03(), value, pageStart,
				pageCount);
		return result;
	}

	@Override
	public Student courseCount(String student_id) {
		// 성적조회(수강생별)
		String sql = "SELECT student_id, student_name, phone, s_reg_date, \r\n"
				+ "		(SELECT count(*) FROM course_history ch WHERE ch.student_id = st.student_id) s_courseCount \r\n"
				+ "FROM student st\r\n" + "WHERE st.student_id= ? " + "ORDER BY student_id ";
		Student result = this.jdbcTemplateObject.queryForObject(sql, new StudentInformationMapper03(), student_id);
		return result;
	}

	@Override
	public int studentInsert(Student s) {
		String sql = "INSERT INTO student (student_id, student_name, phone, student_pw, s_reg_date)\r\n" + 
				"	VALUES ((SELECT CONCAT('S', LPAD(IFNULL(SUBSTR(MAX(student_id),2),0)+1,3,0))\r\n" + 
				"		AS newId FROM student s), ?, ?, ?, curdate())";
		return this.jdbcTemplateObject.update(sql, s.getStudent_name(), s.getPhone(), s.getStudent_Pw());
	}

	@Override
	public int studentDelete(Student s) {
		String sql = "DELETE FROM student\r\n" + 
				"WHERE student_id = ?";
		return this.jdbcTemplateObject.update(sql, s.getStudent_id());
	}

	@Override
	public int studentUpdate(Student s) {
		String sql = "UPDATE student\r\n" + 
				"SET student_name = ?, phone = ?\r\n" + 
				"WHERE student_id = ?";
		 
		return this.jdbcTemplateObject.update(sql, s.getStudent_name(), s.getPhone(), s.getStudent_id());
	}

	@Override
	public int studentPwInit(Student s) {
		String sql = "UPDATE student\r\n" + 
				"SET student_pw = ?\r\n" + 
				"WHERE student_id = ?\r\n" + 
				"AND student_pw = ?";
		return this.jdbcTemplateObject.update(sql, s.getStudent_newPw(), s.getStudent_id(), s.getStudent_Pw());
	}

	@Override
	public int picture_insert(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> subjectCheck1(String open_course_id, String test_id, int pageStart) {
		String sql = "SELECT \r\n" + "    a.student_id,\r\n" + "    a.student_name,\r\n" + "    a.phone,\r\n"
				+ "    a.s_status,\r\n" + "    a.s_course_end_date,\r\n" + "    b.attendance_score,\r\n"
				+ "    b.written_score,\r\n" + "    b.practice_score,\r\n" + "    b.total_score\r\n" + "FROM\r\n"
				+ "    (SELECT \r\n" + "        st.student_id,\r\n" + "            st.student_name,\r\n"
				+ "            st.phone,\r\n"
				+ "            IF(ab.student_id IS NULL, IF(oc.course_end_date > SYSDATE(), '수료예정', '수료완료'), '중도포기') s_status,\r\n"
				+ "            IF(ab.student_id IS NULL, course_end_date, class_end_date) s_course_end_date\r\n"
				+ "    FROM\r\n" + "        student st\r\n"
				+ "    LEFT JOIN abandonment ab ON st.student_id = ab.student_id, open_course oc, course_history ch\r\n"
				+ "    WHERE\r\n" + "        ch.student_id = st.student_id\r\n"
				+ "            AND ch.open_course_id = oc.open_course_id\r\n"
				+ "            AND oc.open_course_id = ?\r\n" + "    ORDER BY st.student_id) a\r\n"
				+ "        LEFT JOIN\r\n" + "    (SELECT \r\n" + "        sc.student_id,\r\n"
				+ "            sc.attendance_score,\r\n" + "            sc.written_score,\r\n"
				+ "            sc.practice_score,\r\n"
				+ "            (sc.attendance_score + sc.written_score + sc.practice_score) AS total_score\r\n"
				+ "    FROM\r\n" + "        test t, score sc\r\n" + "    WHERE\r\n"
				+ "        sc.test_id = t.test_id\r\n"
				+ "            AND t.test_id = ? ) b ON a.student_id = b.student_id Limit ? , 10 ";

		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentScoreMapper01(), open_course_id, test_id,
				pageStart);
		return result;
	}

	@Override
	public int subjectCheck1_totalCount(String open_course_id, String test_id) {
		String sql = "SELECT count(*)" + "FROM\r\n" + "    (SELECT \r\n" + "        st.student_id,\r\n"
				+ "            st.student_name,\r\n" + "            st.phone,\r\n"
				+ "            IF(ab.student_id IS NULL, IF(oc.course_end_date > SYSDATE(), '수료예정', '수료완료'), '중도포기') s_status,\r\n"
				+ "            IF(ab.student_id IS NULL, course_end_date, class_end_date) s_course_end_date\r\n"
				+ "    FROM\r\n" + "        student st\r\n"
				+ "    LEFT JOIN abandonment ab ON st.student_id = ab.student_id, open_course oc, course_history ch\r\n"
				+ "    WHERE\r\n" + "        ch.student_id = st.student_id\r\n"
				+ "            AND ch.open_course_id = oc.open_course_id\r\n"
				+ "            AND oc.open_course_id = ?\r\n" + "    ORDER BY st.student_id) a\r\n"
				+ "        LEFT JOIN\r\n" + "    (SELECT \r\n" + "        sc.student_id,\r\n"
				+ "            sc.attendance_score,\r\n" + "            sc.written_score,\r\n"
				+ "            sc.practice_score,\r\n"
				+ "            (sc.attendance_score + sc.written_score + sc.practice_score) AS total_score\r\n"
				+ "    FROM\r\n" + "        test t, score sc\r\n" + "    WHERE\r\n"
				+ "        sc.test_id = t.test_id\r\n"
				+ "            AND t.test_id = ? ) b ON a.student_id = b.student_id  ";

		int result = this.jdbcTemplateObject.queryForObject(sql, Integer.class, open_course_id, test_id);
		return result;
	}

	@Override
	public List<Student> subjectCheck2(String open_course_id, String test_id, String key, String value, int pageStart) {
		String sql = "SELECT \r\n" + "    a.student_id,\r\n" + "    a.student_name,\r\n" + "    a.phone,\r\n"
				+ "    a.s_status,\r\n" + "    a.s_course_end_date,\r\n" + "    b.attendance_score,\r\n"
				+ "    b.written_score,\r\n" + "    b.practice_score,\r\n" + "    b.total_score\r\n" + "FROM\r\n"
				+ "    (SELECT \r\n" + "        st.student_id,\r\n" + "            st.student_name,\r\n"
				+ "            st.phone,\r\n"
				+ "            IF(ab.student_id IS NULL, IF(oc.course_end_date > SYSDATE(), '수료예정', '수료완료'), '중도포기') s_status,\r\n"
				+ "            IF(ab.student_id IS NULL, course_end_date, class_end_date) s_course_end_date\r\n"
				+ "    FROM\r\n" + "        student st\r\n"
				+ "    LEFT JOIN abandonment ab ON st.student_id = ab.student_id, open_course oc, course_history ch\r\n"
				+ "    WHERE\r\n" + "        ch.student_id = st.student_id\r\n"
				+ "            AND ch.open_course_id = oc.open_course_id\r\n"
				+ "            AND oc.open_course_id = ?\r\n" + "    ORDER BY st.student_id) a\r\n"
				+ "        LEFT JOIN\r\n" + "    (SELECT \r\n" + "        sc.student_id,\r\n"
				+ "            sc.attendance_score,\r\n" + "            sc.written_score,\r\n"
				+ "            sc.practice_score,\r\n"
				+ "            (sc.attendance_score + sc.written_score + sc.practice_score) AS total_score\r\n"
				+ "    FROM\r\n" + "        test t, score sc\r\n" + "    WHERE\r\n"
				+ "        sc.test_id = t.test_id\r\n"
				+ "            AND t.test_id = ? ) b ON a.student_id = b.student_id ";
		if (key.equals("student_id")) {
			sql += "WHERE a.student_id = ? ";
		} else if (key.equals("student_name")) {
			sql += "WHERE INSTR(a.student_name, ?) > 0 ";
		}
		sql += " ORDER BY a.student_id Limit ?, 10 ";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentScoreMapper01(), open_course_id, test_id,
				value, pageStart);
		return result;
	}

	@Override
	public List<Student> studentCheck(String key, String value, String pageStart, String pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student scoreStudent(String student_id, String test_id) {
		String sql = "SELECT sc.attendance_score, sc.written_score, sc.practice_score,\r\n" + 
				"		(sc.attendance_score + sc.written_score + sc.practice_score) total_score\r\n" + 
				"			FROM score sc, student st, test t			\r\n" + 
				"			WHERE st.student_id = ? \r\n" + 
				"					AND sc.test_id = t.test_id\r\n" + 
				"					AND st.student_id = sc.student_id\r\n" + 
				"					AND t.test_id = ? ";
	
		Student result = this.jdbcTemplateObject.queryForObject(sql, new StudentScoreMapper(), student_id, test_id);
		return result;
	}

	@Override
	public List<Student> insSubjectCheck(String pro_id, String test_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> insStudentCheck(String pro_id, String key, String value, String pageStart, String pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int scoreInsert(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scoreDelete(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student insScoreStudent(String pro_id, String student_id, String test_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int total_student() {
		String sql = "SELECT count(*) total_student_count FROM student";
		int result = this.jdbcTemplateObject.queryForObject(sql, Integer.class);
		return result;
	}

	@Override
	public List<Student> list() {
		String sql = "SELECT student_id, student_name, phone, s_reg_date\r\n" + "FROM student\r\n"
				+ "ORDER BY student_id";
		return this.jdbcTemplateObject.query(sql, new StudentInformationMapper04());
	}

	/********************************************/
	// 개설과정별 전체수강생 조회 #BR 20190106
	public List<Student> insOCstudentList(String pro_id, String open_course_id) {
		String sql = "SELECT st.student_id, st.student_name, st.phone, st.s_reg_date, st.s_status, st.s_course_end_date, s_file_name\r\n" + 
				"FROM (SELECT s.student_id, s.student_name, s.phone, s.s_reg_date\r\n" + 
				"	, IF(ISNULL(ab.student_id), IF(oc.course_end_date < DATE(now()), '수료완료', '수료예정'), '중도포기') AS s_status\r\n" + 
				"	, IF(ISNULL(ab.student_id), oc.course_end_date, ab.class_end_date) AS s_course_end_date\r\n" + 
				"	FROM student s LEFT JOIN abandonment ab ON s.student_id = ab.student_id\r\n" + 
				"		, course_history ch, open_course oc\r\n" + 
				"	WHERE s.student_id = ch.student_id\r\n" + 
				"		AND oc.open_course_id = ch.open_course_id\r\n" + 
				"		AND oc.open_course_id IN (SELECT oc.open_course_id\r\n" + 
				"						FROM open_course oc, open_subject os, instructor ins\r\n" + 
				"						WHERE ins.pro_id = os.pro_id\r\n" + 
				"							AND oc.open_course_id = os.open_course_id\r\n" + 
				"							ANd ins.pro_id = ?)\r\n" + 
				"		AND oc.open_course_id = ? \r\n" + 
				"	ORDER BY s.student_id) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id ";
		
		return this.jdbcTemplateObject.query(sql, new StudentInformationMapper05(), pro_id, open_course_id);
	}
	

	//
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	@Override
	public List<Student> insScore(String pro_id, String test_id, String open_course_id) {
/*		String sql = "SELECT a.student_id, a.student_name, a.phone, a.s_status, a.s_course_end_date\r\n" + 
				"   , b.attendance_score, b.written_score, b.practice_score, b.total_score\r\n" + 
				"FROM \r\n" + 
				"(SELECT st.student_id, st.student_name, st.phone,  \r\n" + 
				"   IF(ab.student_id IS NULL, IF(oc.course_end_date > SYSDATE(), '수료예정', '수료완료'), '중도포기') AS s_status      \r\n" + 
				"    , IF(ab.student_id IS NULL, course_end_date, class_end_date) AS s_course_end_date   \r\n" + 
				"FROM student st LEFT JOIN abandonment ab \r\n" + 
				"   ON st.student_id = ab.student_id\r\n" + 
				"    , open_course oc, course_history ch\r\n" + 
				"WHERE ch.student_id = st.student_id\r\n" + 
				"    AND ch.open_course_id = oc.open_course_id\r\n" + 
				"    AND oc.open_course_id = ?\r\n" + 
				"    ORDER BY st.student_id) a\r\n" + 
				"LEFT JOIN \r\n" + 
				"(SELECT s.student_id,s.attendance_score, s.written_score, s.practice_score\r\n" + 
				"   , (s.attendance_score + s.written_score + s.practice_score) AS total_score\r\n" + 
				"FROM score s, open_subject os, test t\r\n" + 
				"WHERE s.open_sub_id = os.open_sub_id\r\n" + 
				"AND t.test_id = s.test_id\r\n" + 
				"AND s.test_id = ?\r\n" + 
				"AND os.pro_id = ?) b\r\n" + 
				"ON a.student_id = b.student_id\r\n" + 
				"ORDER BY a.student_id";*/
		
		String sql = "SELECT st.student_id, st.student_name, st.phone,  st.s_status, st.s_course_end_date, st.attendance_score, st.written_score, st.practice_score, st.total_score, s_file_name\r\n" + 
				"FROM(SELECT a.student_id, a.student_name, a.phone, a.s_status, a.s_course_end_date\r\n" + 
				"   , b.attendance_score, b.written_score, b.practice_score, b.total_score\r\n" + 
				"FROM \r\n" + 
				"(SELECT st.student_id, st.student_name, st.phone,  \r\n" + 
				"   IF(ab.student_id IS NULL, IF(oc.course_end_date > SYSDATE(), '수료예정', '수료완료'), '중도포기') AS s_status      \r\n" + 
				"    , IF(ab.student_id IS NULL, course_end_date, class_end_date) AS s_course_end_date   \r\n" + 
				"FROM student st LEFT JOIN abandonment ab \r\n" + 
				"   ON st.student_id = ab.student_id\r\n" + 
				"    , open_course oc, course_history ch\r\n" + 
				"WHERE ch.student_id = st.student_id\r\n" + 
				"    AND ch.open_course_id = oc.open_course_id\r\n" + 
				"    AND oc.open_course_id = ?\r\n" + 
				"    ORDER BY st.student_id) a\r\n" + 
				"LEFT JOIN \r\n" + 
				"(SELECT s.student_id,s.attendance_score, s.written_score, s.practice_score\r\n" + 
				"   , (s.attendance_score + s.written_score + s.practice_score) AS total_score\r\n" + 
				"FROM score s, open_subject os, test t\r\n" + 
				"WHERE s.open_sub_id = os.open_sub_id\r\n" + 
				"AND t.test_id = s.test_id\r\n" + 
				"AND s.test_id = ?\r\n" + 
				"AND os.pro_id = ?) b\r\n" + 
				"ON a.student_id = b.student_id\r\n" + 
				"ORDER BY a.student_id) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id";
		
		return this.jdbcTemplateObject.query(sql, new StudentScoreMapper01(), open_course_id, test_id, pro_id);
	}
	
/*	//
	//scoreCheck_os04 수강생사진
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	@Override
	public String studentPic(String pro_id, String student_id) {
		String sql = "SELECT s_file_name\r\n" + 
				"FROM student s LEFT JOIN s_picturelist sp ON s.student_id = sp.student_id\r\n" + 
				"WHERE\r\n" + 
				"	s.student_id IN (SELECT ch.student_id \r\n" + 
				"				FROM course_history ch, instructor ins, open_course oc, open_subject os\r\n" + 
				"				WHERE os.pro_id = ins.pro_id\r\n" + 
				"                AND s.student_id = ch.student_id\r\n" + 
				"                AND oc.open_course_id = os.open_course_id\r\n" + 
				"                AND oc.open_course_id = ch.open_course_id\r\n" + 
				"                AND ins.pro_id = ?)\r\n" + 
				"	AND s.student_id = ?";
		
		return this.jdbcTemplateObject.queryForObject(sql, String.class , pro_id, student_id);
	}*/
	
	//
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	//수강생 성적등록
	@Override
	public int addScore(Student s) {
		String sql = "INSERT INTO score (score_id, student_id, open_sub_id, attendance_score, practice_score, written_score, test_id) \r\n" + 
				"    VALUES((SELECT CONCAT('Score', lpad(IFNULL(SUBSTR(MAX(score_id), 6), 0 )+1, 3, 0)) AS newid FROM score s)\r\n" + 
				"    , ?, ?, ? , ?, ?, ?)";
		
		
		return this.jdbcTemplateObject.update(sql, s.getStudent_id(),s.getOpen_sub_id()
				, s.getAttendance_score(), s.getPractice_score(), s.getWritten_score(), s.getTest_id());
	}
	//
	//scoreCheck_os04
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 네번째 테이블 #HJ
	//수강생 성적삭제
	@Override
	public int removeScore(String student_id, String test_id) {
		String sql = "DELETE FROM score \r\n" + 
				"WHERE student_id = ?\r\n" + 
				"    AND test_id=?";
		
		
		return this.jdbcTemplateObject.update(sql, student_id, test_id);
	}
	
	
	
	//
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택  #HJ
	@Override
	public List<Student> insStudentAll(String pro_id, int pageStart, int pageCount) {

		
		
/*		String sql = "SELECT student_id, student_name, phone, s_reg_date\r\n" + 
				"FROM student s\r\n" + 
				"WHERE student_id IN (SELECT ch.student_id\r\n" + 
				"						FROM course_history ch, open_course oc, open_subject os, test t\r\n" + 
				"                        WHERE ch.open_course_id = oc.open_course_id\r\n" + 
				"                        AND oc.open_course_id = os.open_course_id\r\n" + 
				"                        AND os.open_sub_id = t.open_sub_id\r\n" + 
				"                        AND pro_id = ?)\r\n" + 
				"ORDER BY s.student_id Limit ?,?";*/
		
		
		
		String sql = "SELECT st.student_id, st.student_name, st.phone,  st.s_reg_date , s_file_name\r\n" + 
				"FROM(SELECT student_id, student_name, phone, s_reg_date\r\n" + 
				"FROM student s\r\n" + 
				"WHERE student_id IN (SELECT ch.student_id\r\n" + 
				"						FROM course_history ch, open_course oc, open_subject os, test  t\r\n" + 
				"                        WHERE ch.open_course_id = oc.open_course_id\r\n" + 
				"                        AND oc.open_course_id = os.open_course_id\r\n" + 
				"                        AND os.open_sub_id = t.open_sub_id\r\n" + 
				"                        AND pro_id = ?)\r\n" + 
				"ORDER BY s.student_id Limit ?,?) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id";
		
		
		
		return this.jdbcTemplateObject.query(sql, new StudentInformationMapper06(), pro_id, pageStart, pageCount);
	}
	//
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택 #HJ
	@Override
	public List<Student> insStudentKeyValue(String pro_id, String key, String value, int pageStart, int pageCount) {
		String sql ="SELECT st.student_id, st.student_name, st.phone,  st.s_reg_date , s_file_name\r\n" + 
				"FROM(SELECT student_id, student_name, phone, s_reg_date\r\n" + 
				"FROM student s\r\n" + 
				"WHERE student_id IN (SELECT ch.student_id\r\n" + 
				"						FROM course_history ch, open_course oc, open_subject os, test t\r\n" + 
				"                        WHERE ch.open_course_id = oc.open_course_id\r\n" + 
				"                        AND oc.open_course_id = os.open_course_id\r\n" + 
				"                        AND os.open_sub_id = t.open_sub_id\r\n" + 
				"                        AND pro_id = ?)\r\n";
		
		if(key.equals("student_id")){
			sql += "AND student_id = ?";
		}else if(key.equals("student_name")) {
			sql += "AND INSTR(student_name, ?) > 0 ";
		}
		sql += "ORDER BY s.student_id Limit ?, ?) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id";
		
		
		return this.jdbcTemplateObject.query(sql, new StudentInformationMapper06(), pro_id, value, pageStart, pageCount);
	}
	//
	//scoreCheck_student01
	//강사 - 성적관리>수강생기준>수강생선택 #HJ
	@Override
	public int insStudentTotalCount(String pro_id) {
		String sql = "SELECT count(*)\r\n" + 
				"FROM(SELECT s.student_id\r\n" + 
				"FROM student s\r\n" + 
				"WHERE student_id IN (SELECT ch.student_id\r\n" + 
				"						FROM course_history ch, open_course oc, open_subject os, test t\r\n" + 
				"                        WHERE ch.open_course_id = oc.open_course_id\r\n" + 
				"                        AND oc.open_course_id = os.open_course_id\r\n" + 
				"                        AND os.open_sub_id = t.open_sub_id\r\n" + 
				"                        AND pro_id = ?)\r\n"+
				"ORDER BY s.student_id) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id";
		
		return this.jdbcTemplateObject.queryForObject(sql, Integer.class, pro_id);
	}
	
	//
	//scoreCheck_student02
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택 -첫번째 테이블 #HJ
	@Override
	public Student choiceInsStudent(String pro_id, String student_id) {
		String sql ="SELECT st.student_id, st.student_name, st.phone,  st.s_reg_date , s_file_name\r\n" +  
				"FROM(SELECT student_id, student_name, phone, s_reg_date\r\n" + 
				"FROM student s\r\n" + 
				"WHERE student_id IN (SELECT ch.student_id\r\n" + 
				"						FROM course_history ch, open_course oc, open_subject os, test  t\r\n" + 
				"                        WHERE ch.open_course_id = oc.open_course_id\r\n" + 
				"                        AND oc.open_course_id = os.open_course_id\r\n" + 
				"                        AND os.open_sub_id = t.open_sub_id\r\n" + 
				"                        AND pro_id = ?)\r\n" + 
				"AND student_id = ?\r\n" + 
				"ORDER BY s.student_id) st LEFT JOIN student_picturelist sp ON st.student_id = sp.student_id";
		
		return this.jdbcTemplateObject.queryForObject(sql, new StudentInformationMapper06(), pro_id, student_id);
	}
	
	//
	//scoreCheck_student05
	//강사 - 성적관리>수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택 - 마지막 테이블 #HJ
	@Override
	public List<Student> studentScoreList(String pro_id, String test_id , String open_course_id, String student_id) {
/*		String sql = "SELECT s.student_id, attendance_score, practice_score, written_score, (attendance_score + practice_score + written_score) total_score\r\n" + 
				"FROM test t LEFT JOIN score s ON t.test_id = s.test_id, open_subject os\r\n" + 
				"WHERE s.test_id = ?\r\n" + 
				"AND t.open_sub_id = os. open_sub_id\r\n" + 
				"AND pro_id = ?\r\n" + 
				"AND s.student_id = ?";*/
		
		String sql = "SELECT a.student_id\r\n" + 
				"   , b.attendance_score, b.written_score, b.practice_score, b.total_score\r\n" + 
				"FROM \r\n" + 
				"(SELECT st.student_id\r\n" + 
				"FROM student st , open_course oc, course_history ch\r\n" + 
				"WHERE ch.student_id = st.student_id\r\n" + 
				"    AND ch.open_course_id = oc.open_course_id\r\n" + 
				"    AND oc.open_course_id = ?) a\r\n" + 
				"LEFT JOIN \r\n" + 
				"(SELECT s.student_id,s.attendance_score, s.written_score, s.practice_score\r\n" + 
				"   , (s.attendance_score + s.written_score + s.practice_score) AS total_score\r\n" + 
				"FROM score s, open_subject os, test t\r\n" + 
				"WHERE s.open_sub_id = os.open_sub_id\r\n" + 
				"AND t.test_id = s.test_id\r\n" + 
				"AND s.test_id = ?\r\n" + 
				"AND os.pro_id = ?) b\r\n" + 
				"ON a.student_id = b.student_id\r\n" + 
				"WHERE a.student_id = ?\r\n" + 
				"ORDER BY a.student_id";
		
		return this.jdbcTemplateObject.query(sql, new StudentScoreMapper02(), open_course_id, test_id, pro_id, student_id);
	}
	/*******************************************************************************************/
	// 수강생 개인정보 조회
	@Override
	public Student student_info(Login l) {
		String sql = "SELECT \r\n" + "s_file_name, s_picture_id, s.student_id, student_name, phone, s_reg_date\r\n" + "FROM\r\n"
				+ "    student s LEFT JOIN student_picturelist sp\r\n" + "    ON s.student_id = sp.student_id\r\n"
				+ "WHERE\r\n" + "	s.student_id = ?";
		Student result = this.jdbcTemplateObject.queryForObject(sql, new StudentInformationMapper01(),
				l.getStudent_id());
		return result;
	}

	// 수강생 비밀번호 변경
	@Override
	public int pw_update(Student s) {
		String sql = "UPDATE student \r\n" + "SET student_pw = ?\r\n" + "WHERE student_id = ?\r\n"
				+ "AND student_pw = ?";
		return this.jdbcTemplateObject.update(sql, s.getStudent_newPw(), s.getStudent_id(), s.getStudent_Pw());
	}

	// 수강생 대쉬보드
	@Override
	public List<OpenCourse> studentDashboard(Login l) {
		String sql = "SELECT oc.open_course_id, course_name, oc.course_start_date, oc.course_end_date\r\n"
				+ "	, IF(ISNULL(ab.student_id), IF(oc.course_end_date < DATE(now()), '수료완료', '수료예정'), '중도포기') AS s_status\r\n"
				+ "    , IF(ISNULL(ab.student_id), course_end_date, class_end_date) AS s_course_end_date\r\n"
				+ "    , IF(course_end_date < DATE(now()), 100, IF(course_start_date > DATE(now()), 0,  DATEDIFF(NOW(), course_start_date) / DATEDIFF(course_end_date, course_start_date) * 100)) AS progress\r\n"
				+ "FROM open_course oc, course c\r\n"
				+ "	, course_history ch LEFT JOIN abandonment ab ON ch.student_id = ab.student_id\r\n"
				+ "WHERE oc.open_course_id = ch.open_course_id\r\n" + "    AND c.course_id = oc.course_id\r\n"
				+ "    AND ch.student_id = ?\r\n" + "ORDER BY oc.open_course_id DESC";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new StudentDashboardMapper(), l.getStudent_id());
		return result;
	}

	// 수강생 성적조회 과정
	@Override
	public List<OpenCourse> studentOC(Login l) {
		String sql = "SELECT oc.open_course_id, c.course_name, course_start_date, course_end_date, IF(ISNULL(ab.student_id), IF(oc.course_end_date > NOW(), '수료예정', '수료'), '중도탈락') s_status\r\n"
				+ ", IF(ISNULL(ab.student_id), course_end_date, class_end_date) s_course_end_date\r\n"
				+ "FROM open_course oc, course c, course_history ch LEFT JOIN abandonment ab\r\n"
				+ "ON ch.student_id = ab.student_id\r\n" + "WHERE oc.course_id = c.course_id\r\n"
				+ "AND  oc.open_course_id = ch.open_course_id\r\n" + "AND ch.student_id  = ?\r\n"
				+ "ORDER BY oc.open_course_id";
		List<OpenCourse> result = this.jdbcTemplateObject.query(sql, new StudentOCMapper(), l.getStudent_id());
		return result;
	}

	// 수강생 성적조회 선택과정
	@Override
	public OpenCourse studentOC01(Login l, String open_course_id) {
		String sql = "SELECT oc.open_course_id, c.course_name, course_start_date, course_end_date, IF(ISNULL(ab.student_id), IF(oc.course_end_date > NOW(), '수료예정', '수료'), '중도탈락') s_status\r\n"
				+ ", IF(ISNULL(ab.student_id), course_end_date, class_end_date) s_course_end_date\r\n"
				+ "FROM open_course oc, course c, course_history ch LEFT JOIN abandonment ab\r\n"
				+ "ON ch.student_id = ab.student_id\r\n" + "WHERE oc.course_id = c.course_id\r\n"
				+ "AND  oc.open_course_id = ch.open_course_id\r\n" + "AND ch.student_id  = ?\r\n"
				+ "AND oc.open_course_id = ?\r\n" + "ORDER BY oc.open_course_id";
		OpenCourse oc = this.jdbcTemplateObject.queryForObject(sql, new StudentOCMapper(), l.getStudent_id(),
				open_course_id);
		return oc;
	}

	// 수강생 성적조회 과목
	@Override
	public List<OpenSubject> studentOS(Login l, String open_course_id) {
		String sql = "SELECT os.open_sub_id, s.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn, i.pro_id, i.pro_name, i_file_name\r\n" + 
				"FROM open_subject os LEFT JOIN book b ON os.book_id = b.book_id\r\n" + 
				", subject_ s, instructor i LEFT JOIN i_picturelist ip ON ip.pro_id = i.pro_id, open_course oc, course_history ch\r\n" + 
				"WHERE os.subject_id = s.subject_id\r\n" + 
				"AND os.pro_id = i.pro_id\r\n" + 
				"AND os.open_course_id = oc.open_course_id\r\n" + 
				"AND oc.open_course_id = ch.open_course_id\r\n" + 
				"AND ch.student_id = ?\r\n" + 
				"AND os.open_course_id=?\r\n" + 
				"ORDER BY os.open_sub_id";

		List<OpenSubject> result = this.jdbcTemplateObject.query(sql, new StudentOSMapper(), l.getStudent_id(),
				open_course_id);
		return result;
	}

	// 수강생 성적조회 선택과목
	@Override
	public OpenSubject studentOS01(Login l, String open_sub_id) {
		String sql = "SELECT os.open_sub_id, s.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn, i.pro_id, i.pro_name, i_file_name\r\n" + 
				"FROM open_subject os LEFT JOIN book b ON os.book_id = b.book_id\r\n" + 
				", subject_ s, instructor i LEFT JOIN i_picturelist ip ON ip.pro_id = i.pro_id, open_course oc, course_history ch\r\n" + 
				"WHERE os.subject_id = s.subject_id\r\n" + 
				"AND os.pro_id = i.pro_id\r\n" + 
				"AND os.open_course_id = oc.open_course_id\r\n" + 
				"AND oc.open_course_id = ch.open_course_id\r\n" + 
				"AND ch.student_id = ?\r\n" + 
				"AND os.open_sub_id = ?\r\n" + 
				"ORDER BY os.open_sub_id";
		
		OpenSubject os = this.jdbcTemplateObject.queryForObject(sql, new StudentOSMapper(), l.getStudent_id(),
				open_sub_id);
		return os;
	}

	@Override
	public List<Test> studentTestPoint(Login l, String open_sub_id) {
		String sql = "SELECT t.test_id, t.attendance_points, t.practice_points , t.written_points, t.test_date, t.test_q\r\n"
				+ "FROM test t, open_subject os, open_course oc, course_history ch\r\n"
				+ "WHERE t.open_sub_id = os.open_sub_id\r\n" + "AND os.open_course_id = oc.open_course_id\r\n"
				+ "AND oc.open_course_id = ch.open_course_id\r\n" + "AND t.open_sub_id = ?\r\n"
				+ "AND ch.student_id = ?\r\n" + "ORDER BY t.test_id";
		List<Test> list = this.jdbcTemplateObject.query(sql, new StudentTestMapper(), open_sub_id, l.getStudent_id());
		return list;
	}

	@Override
	public Test studentTestPoint01(Login l, String test_id) {
		String sql = "SELECT t.test_id, t.attendance_points, t.practice_points , t.written_points, t.test_date, t.test_q\r\n"
				+ "FROM test t, open_subject os, open_course oc, course_history ch\r\n"
				+ "WHERE t.open_sub_id = os.open_sub_id\r\n" + "AND os.open_course_id = oc.open_course_id\r\n"
				+ "AND oc.open_course_id = ch.open_course_id\r\n" + "AND t.test_id = ?\r\n"
				+ "AND ch.student_id = ?\r\n" + "ORDER BY t.test_id";
		Test t = this.jdbcTemplateObject.queryForObject(sql, new StudentTestMapper(), test_id, l.getStudent_id());
		return t;
	}

	@Override
	public List<Student> studentScore(Login l, String open_sub_id, String test_id) {
		String sql = "SELECT \r\n" + "    attendance_score,\r\n" + "    practice_score,\r\n" + "    written_score,\r\n"
				+ "    (attendance_score + practice_score + written_score) total_score\r\n" + "FROM\r\n"
				+ "    score sco,\r\n" + "    test t\r\n" + "WHERE\r\n" + "    sco.test_id = t.test_id\r\n"
				+ "        AND student_id = ?\r\n" + "        AND sco.open_sub_id = ?\r\n"
				+ "        AND sco.test_id = ?";
		List<Student> list = this.jdbcTemplateObject.query(sql, new StudentScoreMapper(), l.getStudent_id(),
				open_sub_id, test_id);
		return list;
	}
}
