package com.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Test;
import com.mapper.TestRowMapper;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO{

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public Test test(String open_sub_id, String test_id) {
		String sql = "SELECT t.test_id, t.test_date, t.attendance_points, t.written_points, "
				+ "			t.practice_points, t.test_q "
				+ "			FROM test t, open_subject os "
				+ "			WHERE t.open_sub_id = os.open_sub_id  "
				+ "			AND os.open_sub_id= ?     "
				+ "			AND t.test_id = ? ";
		return this.jdbcTemplateObject.queryForObject(sql, new TestRowMapper(), open_sub_id, test_id);
	}
	
	@Override
	public List<Test> list(String open_sub_id) {
		String sql = "SELECT t.test_id, t.test_date, t.attendance_points,"
				+ " t.written_points, t.practice_points, t.test_q "
				+ "		FROM test t, open_subject os "
				+ "		WHERE t.open_sub_id = os.open_sub_id "
				+ "		AND os.open_sub_id= ? ";
		return this.jdbcTemplateObject.query(sql, new TestRowMapper(), open_sub_id);
	}

	@Override
	public List<Test> list2(String student_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> insList(String pro_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Test t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Test> insList2(String open_sub_id, String pro_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> insList3(String open_sub_id, String pro_id, String student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> stuList(String student_id, String open_sub_id) {
		// TODO Auto-generated method stub
		return null;
	}
	//scoreCheck_os03
		//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택 - 세번째 테이블   #HJ
		
		@Override
		public List<Test> insTestList(String pro_id, String open_sub_id) {
			String sql = "	SELECT t.test_id, t.test_date, t.attendance_points, t.written_points, t.practice_points, t.test_q\r\n" + 
					"	FROM open_subject os, test t\r\n" + 
					"	WHERE os.open_sub_id = t.open_sub_id\r\n" + 
					"	AND t.open_sub_id=?\r\n" + 
					"	AND os.pro_id = ?\r\n" + 
					"	ORDER BY t.test_id";
			
			List<Test> result = this.jdbcTemplateObject.query(sql, new TestRowMapper()
											, open_sub_id, pro_id);
			
			return result;
		}

		//scoreCheck_os04
		//강사 - 성적관리>과목기준>개설과정 선택 >개설과목선택 >시험선택>전체수강생 성적관리 - 세번째 테이블   #HJ
		@Override
		public Test choiceInsTestList(String pro_id, String test_id) {
			Test result = null;
			
			String sql = "SELECT t.test_id, t.test_date, t.attendance_points, t.written_points, t.practice_points, t.test_q\r\n" + 
					"FROM open_subject os, test t\r\n" + 
					"WHERE os.open_sub_id = t.open_sub_id\r\n" + 
					"AND t.test_id=?\r\n" + 
					"AND os.pro_id = ?";
			
			
			try {
				result = this.jdbcTemplateObject.queryForObject(sql, new TestRowMapper()
						, test_id, pro_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			return result;
		}
		
		

		//scoreCheck_student04
		//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택 - 네번째테이블 #HJ
		@Override
		public List<Test> insTestList02(String pro_id, String open_sub_id) {
			
			String sql = "SELECT t.test_id, test_date, attendance_points, practice_points, written_points, test_q\r\n" + 
					"FROM test t, open_subject os\r\n" + 
					"WHERE t.open_sub_id = os.open_sub_id\r\n" + 
					"AND pro_id = ?\r\n" + 
					"AND t.open_sub_id = ?";
			
			List<Test> result = this.jdbcTemplateObject.query(sql, new TestRowMapper(), pro_id, open_sub_id);
			
			return result;
		}

		
		//scoreCheck_student05
		//강사 - 성적관리> 수강생기준>수강생선택>개설과정선택>개설과목선택>시험선택>특정수강생 성적관리 - 네번째테이블 #HJ
		@Override
		public Test choiceInsTestList(String pro_id, String open_sub_id, String test_id) {
			Test result = null;
			
			String sql = "SELECT t.test_id, test_date, attendance_points, practice_points, written_points, test_q\r\n" + 
					"FROM test t, open_subject os\r\n" + 
					"WHERE t.open_sub_id = os.open_sub_id\r\n" + 
					"AND pro_id = ?\r\n" + 
					"AND t.open_sub_id = ?\r\n" + 
					"AND t.test_id = ?";
			
			
			try {
				result = this.jdbcTemplateObject.queryForObject(sql, new TestRowMapper()
						, pro_id, open_sub_id, test_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			return result;
		}

	
	

}
