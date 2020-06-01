package com.persistence;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.OpenSubject;
import com.mapper.OpenSubjectDefaultMapper;
import com.mapper.OpenSubjectProgressMapper;
import com.mapper.OpenSubjectRowMapper00;
import com.mapper.OpenSubjectRowMapper01;

@Repository("openSubjectDAO")
public class OpenSubjectDAOImpl implements OpenSubjectDAO {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<OpenSubject> adminList(String open_course_id) {
		String sql = "SELECT open_sub_id, subject_name, sub_start_date, sub_end_date\r\n" + 
				"				   , b.book_name, pro_name, b.isbn\r\n" + 
				"				FROM opensubview osv LEFT JOIN book b\r\n" + 
				"				ON osv.book_id = b.book_id\r\n" + 
				"				WHERE open_course_id = ? \r\n" + 
				"				ORDER BY open_sub_id ";
		
		return this.jdbcTemplate.query(sql, new OpenSubjectRowMapper00()
										, open_course_id);
	}
	
	@Override
	public OpenSubject subject(String open_course_id, String open_sub_id) {
		String sql = "SELECT os.open_sub_id, sb.subject_name, os.sub_start_date, os.sub_end_date,"
				+ " 			b.book_name, i.pro_name, b.isbn "
				+ "			FROM open_subject os LEFT JOIN book b ON b.book_id = os.book_id, "
				+ "				subject_ sb, open_course oc, course c, instructor i "
				+ "			WHERE sb.subject_id = os.subject_id     "
				+ "			AND c.course_id = oc.course_id     "
				+ "			AND oc.open_course_id = os.open_course_id  "
				+ "			AND os.pro_id= i.pro_id     "
				+ "			AND oc.open_course_id = ?     "
				+ "			AND os.open_sub_id = ? "
				+ "		ORDER BY open_sub_id";
				
		return this.jdbcTemplate.queryForObject(sql, new OpenSubjectRowMapper00()
				,open_course_id, open_sub_id);
	}

	
	@Override
	public List<OpenSubject> adminList1(String open_course_id) {
		String sql = "SELECT open_sub_id, subject_name, sub_start_date, sub_end_date\r\n" + 
				"   , b.book_name, b.isbn, pro_name, count_\r\n" + 
				"FROM opensubview osv LEFT JOIN book b\r\n" + 
				"ON osv.book_id = b.book_id\r\n" + 
				"WHERE open_course_id = ?\r\n" + 
				"ORDER BY open_sub_id";
		
		return this.jdbcTemplate.query(sql, new OpenSubjectRowMapper01()
										, open_course_id);
	}

	@Override
	public List<OpenSubject> adminList2(String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(OpenSubject os) {
		String sql = "INSERT INTO open_subject (open_sub_id, open_course_id, subject_id, sub_start_date, sub_end_date, book_id, pro_id)\r\n" + 
				"    VALUES((SELECT CONCAT('OS', LPAD(IFNULL(SUBSTR(MAX(open_sub_id), 3), 0 )+1, 3, 0)) AS newid FROM open_subject os)\r\n" + 
				"    , ?, ?, ?, ?, ?, ?)";

		return this.jdbcTemplate.update(sql, 
							os.getOpen_course_id(), os.getSubject_id(), os.getSub_start_date().toString()
							, os.getSub_end_date().toString(), os.getBook_id(), os.getPro_id());
	}

	@Override
	public int update(OpenSubject os) {
		String sql = "UPDATE open_subject\r\n" + 
				"SET sub_start_date = ?, sub_end_date = ?\r\n" + 
				"WHERE open_sub_id=?";
		
		return this.jdbcTemplate.update(sql, os.getSub_start_date().toString()
					, os.getSub_end_date().toString(), os.getOpen_sub_id());
	}

	@Override
	public int delete(OpenSubject os) {
		String sql = "DELETE FROM open_subject\r\n" + 
				"WHERE open_sub_id=?";
		
		return this.jdbcTemplate.update(sql, os.getOpen_sub_id());
	}

	@Override
	public List<OpenSubject> insList(String pro_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> insList2(String pro_id, String open_course_id, Date sub_end_date, Date sub_start_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> insList3(String pro_id, String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpenSubject> stList(String student_id, String open_course_id) {
		// TODO Auto-generated method stub
		return null;
	}

/*************************************************************************************/

	//강사 - 강의스케쥴조회>강의일정별 조회>강의예정/강의중/강의종료 과목조회 통합	#BR		20190106	
	@Override
	public List<OpenSubject> insOSList(String pro_id, String open_course_id) {
		String sql = "SELECT os.open_sub_id, s.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn\r\n" + 
				"FROM open_subject os LEFT JOIN book b ON os.book_id = b.book_id, subject_ s, instructor ins\r\n" + 
				"WHERE os.subject_id = s.subject_id\r\n" + 
				"    AND ins.pro_id = os.pro_id\r\n" + 
				"    AND ins.pro_id = ?\r\n" + 
				"    AND os.open_course_id = ?\r\n" + 
				"ORDER BY os.open_sub_id\r\n";
		
		List<OpenSubject> result = this.jdbcTemplate.query(sql, new OpenSubjectDefaultMapper(), pro_id, open_course_id);
		return result;
	}
	

	//#BR 강사 대시보드 하단
	@Override
	public List<OpenSubject> insProgressOSList(String pro_id, String open_course_id) {
		String sql = "SELECT os.open_sub_id, s.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn\r\n" + 
				"		, IF(os.sub_end_date < DATE(now()), 100, IF(os.sub_start_date > DATE(now()), 0, DATEDIFF(NOW(), os.sub_start_date)) / DATEDIFF(os.sub_end_date, os.sub_start_date) * 100) AS progress\r\n" + 
				"FROM open_subject os LEFT JOIN book b ON os.book_id = b.book_id, subject_ s, instructor ins\r\n" + 
				"WHERE os.subject_id = s.subject_id\r\n" + 
				"    AND ins.pro_id = os.pro_id\r\n" + 
				"    AND ins.pro_id = ?\r\n" + 
				"    AND os.open_course_id = ?\r\n" + 
				"    AND os.sub_start_date <= DATE(now())\r\n" + 
				"    AND os.sub_end_date >= DATE(now())\r\n";
		
		List<OpenSubject> result = this.jdbcTemplate.query(sql, new OpenSubjectProgressMapper(), pro_id, open_course_id);
		
		return result;
	}
	
	//강사 - 강의스케쥴조회>강의일정별 조회>강의예정 과목조회		#BR
	@Override
	public List<OpenSubject> plannedList(String pro_id, String open_course_id) {
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
				"	AND oc.open_course_id = ?\r\n";
		List<OpenSubject> result = this.jdbcTemplate.query(sql, new OpenSubjectDefaultMapper(), pro_id, open_course_id);
		return result;
	}

	//강사 - 강의스케쥴조회>강의일정별 조회>강의중	과목조회		#BR
	@Override
	public List<OpenSubject> ingList(String pro_id, String open_course_id) {

		return null;
	}

	//강사 - 강의스케쥴조회>강의일정별 조회>강의종료 과목조회		#BR
	@Override
	public List<OpenSubject> endList(String pro_id, String open_course_id) {

		return null;
	}

	
	
	/*************************************************************************************/

	//
	//scoreCheck_os02
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택  - 두번째 테이블	 #HJ
	@Override
	public List<OpenSubject> insOpenSubjectList(String pro_id, String open_course_id) {
		String sql = "SELECT os.open_sub_id,s.subject_name,os.sub_start_date,os.sub_end_date,b.book_name,b.isbn\r\n" + 
				"FROM subject_ s, open_subject os LEFT JOIN book b ON os.book_id = b.book_id\r\n" + 
				"WHERE os.open_sub_id IN (SELECT t.open_sub_id\r\n" + 
				"FROM test t, open_subject os, instructor ins, open_course oc\r\n" + 
				"WHERE os.open_sub_id = t.open_sub_id\r\n" + 
				"AND ins.pro_id = os.pro_id\r\n" + 
				"AND oc.open_course_id = os.open_course_id\r\n" + 
				"AND ins.pro_id = ? \r\n" + 
				"AND oc.open_course_id = ?)\r\n" + 
				"AND os.subject_id = s.subject_id\r\n" + 
				"ORDER BY os.open_sub_id";
		
		List<OpenSubject> result = this.jdbcTemplate.query(sql, new OpenSubjectDefaultMapper(), pro_id, open_course_id);
		
		return result;
	}

	//
	//scoreCheck_os03
	//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택  - 두번째 테이블	 #HJ
	@Override
	public OpenSubject choiceInsOpenSubjectList(String pro_id, String open_course_id, String open_sub_id) {
		OpenSubject result =null;
		
		String sql = "SELECT os.open_sub_id, s.subject_name, os.sub_start_date, os.sub_end_date,b.book_name, b.isbn\r\n" + 
				"FROM subject_ s, open_subject os LEFT JOIN  book b ON os.book_id = b.book_id\r\n" + 
				"WHERE os.open_sub_id IN (SELECT t.open_sub_id FROM test t, open_subject os , instructor ins, open_course oc\r\n" + 
				"WHERE os.open_sub_id = t.open_sub_id\r\n" + 
				"AND ins.pro_id = os.pro_id\r\n" + 
				"AND oc.open_course_id = os.open_course_id\r\n" + 
				"AND ins.pro_id = ?\r\n" + 
				"AND oc.open_course_id =?)\r\n" + 
				"AND os.subject_id = s.subject_id\r\n" + 
				"AND os.open_sub_id =?";
		
		
		try {
			 result = this.jdbcTemplate.queryForObject(sql, new OpenSubjectDefaultMapper(), pro_id, open_course_id,open_sub_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	
	//
	//scoreCheck_student03
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택  - 두번째 테이블	 #HJ
	@Override
	public List<OpenSubject> studentOpenSubjectList(String pro_id, String open_course_id) {
/*		String sql = "SELECT os.open_sub_id, sub.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn\r\n" + 
				"FROM test t , open_subject os LEFT JOIN book b ON os.book_id = b.book_id, subject_ sub\r\n" + 
				"WHERE os.subject_id = sub.subject_id\r\n" + 
				"AND t.open_sub_id = os.open_sub_id\r\n" + 
				"AND os.open_course_id = ?\r\n" + 
				"AND pro_id = ?";*/
		
		
		String sql = "SELECT os.open_sub_id, sub.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn\r\n" + 
				"FROM open_subject os LEFT JOIN book b ON os.book_id = b.book_id, subject_ sub\r\n" + 
				"WHERE os.subject_id = sub.subject_id\r\n" + 
				"AND os.open_sub_id IN (SELECT os2.open_sub_id from test t, open_subject os2 where  t.open_sub_id = os2.open_sub_id )\r\n" + 
				"AND os.open_course_id = ?\r\n" + 
				"AND pro_id = ?";
		
		
		List<OpenSubject> result = this.jdbcTemplate.query(sql, new OpenSubjectDefaultMapper(), open_course_id, pro_id);
		
		return result;
	}
	
	//
	//scoreCheck_student04
	//강사 - 성적관리 > 과목기준 > 개설과정선택> 개설과목선택 > 시험선택  - 세번째 테이블	 #HJ
	@Override
	public OpenSubject choiceStudentOpenSubjectList(String pro_id, String open_course_id , String open_sub_id) {
		String sql = "SELECT os.open_sub_id, sub.subject_name, os.sub_start_date, os.sub_end_date, b.book_name, b.isbn\r\n" + 
				"FROM  open_subject os LEFT JOIN book b ON os.book_id = b.book_id, subject_ sub\r\n" + 
				"WHERE os.subject_id = sub.subject_id\r\n" + 
				"AND os.open_course_id = ?\r\n" + 
				"AND pro_id = ?\r\n" + 
				"AND os.open_sub_id = ?";
		
		OpenSubject result = this.jdbcTemplate.queryForObject(sql, new OpenSubjectDefaultMapper(), open_course_id, pro_id, open_sub_id);
		
		return result;
	}
	
}



	

