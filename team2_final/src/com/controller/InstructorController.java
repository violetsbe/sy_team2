package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.Instructor;
import com.domain.Login;
import com.domain.OpenCourse;
import com.domain.OpenSubject;
import com.domain.Student;
import com.domain.Test;
import com.service.InstructorService;
import com.service.OpenCourseService;
import com.service.OpenSubjectService;
import com.service.StudentService;
import com.service.TestService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Resource(name="openCourseService")
	private OpenCourseService openCourseService;
	
	@Resource(name="openSubjectService")
	private OpenSubjectService openSubjectService;
	
	@Resource(name="instructorService")
	private InstructorService instructorService;
	
	@Resource(name="testService")
	private TestService testService;
	
	@Resource(name="studentService")
	private StudentService studentService;
	
	//byType - 자료형 기준 의존주입
    @Autowired
    private ServletContext context;
	
	
	private String open_course_id;
	private String open_sub_id;
	private String test_id;
	private String student_id;
	
	//강사 대시보드		#BR
	@RequestMapping(value = { "/index" })
	public String insIndex(Model model, HttpSession session) {
		Login l = (Login) session.getAttribute("instructor");
		List<OpenCourse> list = this.openCourseService.insProgressOCList(l);
		model.addAttribute("list", list);
		
		return "/instructor/index";
	}
	
	//강사 개인정보조회	#BR
	@RequestMapping(value = { "/instructor_info" })
	public String instructor_info(Model model, HttpSession session) {
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		Instructor result = this.instructorService.instructor_info(pro_id);
		
		model.addAttribute("list", result);
		
		return "/instructor/instructor_info";
	}
	
	//강사 비밀번호 변경	#BR
	@RequestMapping(value="/pwUpdate")
	public String insPwUpdate(Instructor ins, RedirectAttributes rttr) {
		
		String txt = "fail";

		int result = this.instructorService.pw_update(ins);
		if (result == 1) {
			txt = "success";
		}
		rttr.addFlashAttribute("result", txt);
		System.out.println(txt);
		return "redirect:/instructor/instructor_info";
	}
	
	// 강의예정 과목조회(과정) #BR 20190109 #####
	@RequestMapping(value = "/schedule_planned01")
	public String schedule_planned01(Model model, HttpSession session, String key, String value, String pageNum_) {
		// 강사 로그인 정보 얻어오기
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();

		// 페이징 처리
		if (pageNum_ == null) {
			// 페이징 번호 초기값
			pageNum_ = "1";
		}

		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount * (pageNum - 1);

		// 첫 페이지
		int firstPage = 1;
		// 마지막 페이지
		int lastPage = 1;

		int totalcount = this.openCourseService.insPlannedTotalcount(pro_id);
		lastPage = (int) Math.ceil(totalcount / (double) pageCount);

		if (key == null || key.equals("")) {
			key = "all";
		}

		List<OpenCourse> list = null;

		if (key.equals("all")) {
			list = this.openCourseService.plannedList(pro_id);
		} else {
			list = this.openCourseService.plannedList(pro_id, key, value, pageStart, pageCount);
		}

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		
		model.addAttribute("totalcount", totalcount);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		// .jsp로
		return "/instructor/schedule_planned01";
	}
		
		
	// 강의중 과목조회(과정) #BR 20190109 #####
	@RequestMapping(value = "/schedule_ing01")
	public String schedule_ing01(Model model, HttpSession session, String key, String value, String pageNum_) {

		// 강사 로그인 정보 얻어오기
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();

		if (key == null || key.equals("")) {
			key = "all";
		}
		
		// 페이징 처리
		if (pageNum_ == null) {
			// 페이징 번호 초기값
			pageNum_ = "1";
		}

		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount * (pageNum - 1);

		// 첫 페이지
		int firstPage = 1;
		// 마지막 페이지
		int lastPage = 1;

		int totalcount = this.openCourseService.insIngTotalcount(pro_id);
		lastPage = (int) Math.ceil(totalcount / (double) pageCount);

		List<OpenCourse> list = null;

		if (key.equals("all")) {
			list = this.openCourseService.ingList(pro_id);
		} else {
			list = this.openCourseService.ingList(pro_id, key, value, pageStart, pageCount);
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);

		model.addAttribute("totalcount", totalcount);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "/instructor/schedule_ing01";
	}
		
	// 강의종료 과목조회(과정) #BR 20190109
	// *현재 DB 등록된 강의종료 과정이 없음 (서강준/I003)* #####
	@RequestMapping(value = "/schedule_end01")
	public String schedule_end01(Model model, HttpSession session, String key, String value, String pageNum_) {
		// 강사 로그인 정보 얻어오기
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();

		if (key == null || key.equals("")) {
			key = "all";
		}
		
		// 페이징 처리
		if (pageNum_ == null) {
			// 페이징 번호 초기값
			pageNum_ = "1";
		}

		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount * (pageNum - 1);

		// 첫 페이지
		int firstPage = 1;
		// 마지막 페이지
		int lastPage = 1;

		int totalcount = this.openCourseService.insEndTotalcount(pro_id);
		lastPage = (int) Math.ceil(totalcount / (double) pageCount);

		List<OpenCourse> list = null;

		if (key.equals("all")) {
			list = this.openCourseService.endList(pro_id);
		} else {
			list = this.openCourseService.endList(pro_id, key, value, pageStart, pageCount);
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);

		model.addAttribute("totalcount", totalcount);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "/instructor/schedule_end01";
	}
		
		
		//강의예정 과목조회(과정+과목)	#BR			20190106
		@RequestMapping(value="/schedule_planned02")
		public String schedule_planned02(Model model, HttpSession session, String open_course_id) {
			Login l = (Login) session.getAttribute("instructor");
			String pro_id = l.getPro_id();
			
			OpenCourse list = this.openCourseService.plannedOpenCourse(pro_id, open_course_id);
			List<OpenSubject> osList = this.openSubjectService.insOSList(pro_id, open_course_id);
			
			model.addAttribute("oc", list);
			model.addAttribute("osList", osList);
			model.addAttribute("count", osList.size());
			
			//.jsp로
			return "/instructor/schedule_planned02";
		}
		
		
		//강의중 과목조회(과정+과목)	#BR		20190106
		@RequestMapping(value="/schedule_ing02")
		public String schedule_ing02(Model model, HttpSession session, String open_course_id) {
			Login l = (Login) session.getAttribute("instructor");
			String pro_id = l.getPro_id();
			
			OpenCourse list = this.openCourseService.ingOpenCourse(pro_id, open_course_id);
			List<OpenSubject> osList = this.openSubjectService.insOSList(pro_id, open_course_id);
			
			model.addAttribute("oc", list);
			model.addAttribute("osList", osList);
			model.addAttribute("count", osList.size());
			
			//.jsp로
			return "/instructor/schedule_ing02";
		}
		
		
		//강의완료 과목조회(과정+과목)	#BR		20190106
		@RequestMapping(value="/schedule_end02")
		public String schedule_end02(Model model, HttpSession session, String open_course_id) {
			Login l = (Login) session.getAttribute("instructor");
			String pro_id = l.getPro_id();
			
			OpenCourse list = this.openCourseService.endOpenCourse(pro_id, open_course_id);
			List<OpenSubject> osList = this.openSubjectService.insOSList(pro_id, open_course_id);
			
			model.addAttribute("oc", list);
			model.addAttribute("osList", osList);
			model.addAttribute("count", osList.size());
			
			//.jsp로
			return "/instructor/schedule_end02";
		}
		
		// 개설과정별 전체수강생 조회(전체 과정 리스트) #BR 20190109 #####
		@RequestMapping("/os_student01")
		public String os_student01(Model model, HttpSession session, String key, String value, String pageNum_) {

			// 강사 로그인 정보 얻어오기
			Login l = (Login) session.getAttribute("instructor");
			String pro_id = l.getPro_id();

			if (key == null || key.equals("")) {
				key = "all";
			}
			
			// 페이징 처리
			if (pageNum_ == null) {
				// 페이징 번호 초기값
				pageNum_ = "1";
			}

			int pageNum = Integer.parseInt(pageNum_);
			int pageCount = 10;
			int pageStart = pageCount * (pageNum - 1);

			// 첫 페이지
			int firstPage = 1;
			// 마지막 페이지
			int lastPage = 1;

			int totalcount = this.openCourseService.insAllTotalcount(pro_id);
			lastPage = (int) Math.ceil(totalcount / (double) pageCount);

			List<OpenCourse> list = null;

			if (key.equals("all")) {
				list = this.openCourseService.insAllList(pro_id);
			} else {
				list = this.openCourseService.insAllList(pro_id, key, value, pageStart, pageCount);
			}
			
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("pageStart", pageStart);
			model.addAttribute("firstPage", firstPage);
			model.addAttribute("lastPage", lastPage);

			model.addAttribute("totalcount", totalcount);
			model.addAttribute("list", list);
			model.addAttribute("count", list.size());

			return "/instructor/os_student01";
		}
		
		//개설과정별 전체수강생 조회(선택한 특정 과정+수강생리스트)  #BR	20190106
		@RequestMapping("/os_student02")
		public String os_student02(Model model, HttpSession session, String open_course_id) {
			Login l = (Login) session.getAttribute("instructor");
			String pro_id = l.getPro_id();
			
			OpenCourse list = this.openCourseService.insOCstudent(pro_id, open_course_id);
			List<Student> sList = this.studentService.insOCstudentList(pro_id, open_course_id);
			
			model.addAttribute("oc", list);
			model.addAttribute("sList", sList);
			model.addAttribute("count", sList.size());
			
			return "/instructor/os_student02";
		}
		
	
	
	
	
	/********************************************************************/
	//scoreCheck_os01       #HJ
	@RequestMapping(value="/scoreCheck_os01")
	public String scoreCheck_os01(Model model, HttpSession session,  String key, String value, String pageNum_) {
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
	      if (pageNum_ == null) {
	          //페이징 번호 초기값
	          pageNum_ = "1"; 
	       }
	      
	      int pageNum = Integer.parseInt(pageNum_);
	      int pageCount = 10;
	      int pageStart = pageCount*(pageNum - 1);
	      
	      
	      //첫 페이지
	      int firstPage = 1; 
	      //마지막 페이지
	      int lastPage = 1; 
	      
	      int totalCount = this.openCourseService.insListTotalCount(pro_id);
	      
	      lastPage = (int)Math.ceil(totalCount / (double)pageCount);
	      
	      if (key == null || key.equals("")) {
	          key = "all";
	       }
	      
	      
	      List<OpenCourse> list = null;
	      if (key.equals("all")) {
	         list = this.openCourseService.insListAll(pro_id, pageStart, pageCount);
	      } else {
	         list = this.openCourseService.insListKeyValue(pro_id, key, value, pageStart, pageCount);
	      }
		
	      model.addAttribute("pageNum", pageNum);
	      model.addAttribute("pageCount", pageCount);
	      model.addAttribute("pageStart", pageStart);
	      model.addAttribute("firstPage", firstPage);
	      model.addAttribute("lastPage", lastPage);
	      model.addAttribute("list", list);
	      model.addAttribute("count", list.size());
	      model.addAttribute("totalCount", totalCount);

		//.jsp로
		return "/instructor/scoreCheck_os01";
	}
	
	//scoreCheck_os02       #HJ
	@RequestMapping(value="/scoreCheck_os02")
	public String scoreCheck_os02(Model model, HttpSession session, String open_course_id) {
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		this.open_course_id = open_course_id;
		
		
		//첫번째 테이블
		OpenCourse choiceInsList = this.openCourseService.choiceInsList( pro_id , open_course_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		//두번째 테이블
		List<OpenSubject> list = this.openSubjectService.insOpenSubjectList(pro_id, open_course_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());

		//.jsp로
		return "/instructor/scoreCheck_os02";
	}
	
	
	//scoreCheck_os03       #HJ
	@RequestMapping(value="/scoreCheck_os03")
	public String scoreCheck_os03(Model model, HttpSession session, String open_sub_id) {
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		this.open_sub_id = open_sub_id;
		
		//첫번째 테이블
		OpenCourse choiceInsList = this.openCourseService.choiceInsList( pro_id , this.open_course_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		//두번째 테이블
		OpenSubject choiceInsList02 = this.openSubjectService.choiceInsOpenSubjectList(pro_id,  this.open_course_id, this.open_sub_id);
		model.addAttribute("choiceInsList02", choiceInsList02);
		
		//세번째 테이블
		List<Test> list = this.testService.insTestList(pro_id, this.open_sub_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());

		//.jsp로
		return "/instructor/scoreCheck_os03";
	}
	
	//scoreCheck_os04       #HJ
	@RequestMapping(value="/scoreCheck_os04")
	public String scoreCheck_os04(Model model, HttpSession session, String test_id) {
		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		if(test_id!=null) {
			
			this.test_id = test_id;		
		}
		
		
		
		//첫번째 테이블
		OpenCourse choiceInsList = this.openCourseService.choiceInsList( pro_id , this.open_course_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		//두번째 테이블
		OpenSubject choiceInsList02 = this.openSubjectService.choiceInsOpenSubjectList(pro_id,  this.open_course_id, this.open_sub_id);
		model.addAttribute("choiceInsList02", choiceInsList02);
		
		//세번째 테이블
		Test choiceInsList03 = this.testService.choiceInsTestList(pro_id, this.test_id);
		model.addAttribute("choiceInsList03", choiceInsList03);

		//네번째 테이블
		System.out.println(this.open_course_id);
		List<Student> list =this.studentService.insScore(pro_id, this.test_id, this.open_course_id);
		
		

		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());
		
		//.jsp로
		return "/instructor/scoreCheck_os04";
	}
	
/*	//scoreCheck_os04       #HJ
	@RequestMapping(value="/student_pic")
	public ResponseEntity<String> student_pic(Model model, HttpSession session, String student_id) {
		

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		String s_file_name =this.studentService.studentPic(pro_id, student_id);


        String json = "{\"s_file_name\":"+s_file_name+"}";
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
		
		
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}*/
	
	
	//scoreCheck_os04       #HJ
	@RequestMapping(value="/addScore")
	public String scoreCheck_os04_addScore(Model model, Student s, RedirectAttributes rttr) {
		String txt = "fail";
		
		
		s.setTest_id(this.test_id);
		s.setOpen_sub_id(this.open_sub_id);
		
		//네번째 테이블
		int result =this.studentService.addScore(s);
		
		if (result == 1) {
			txt = "success";
		}
	
		rttr.addFlashAttribute("addResult", txt);

		return "redirect:/instructor/scoreCheck_os04";
	}
	
	//scoreCheck_os04       #HJ
	@RequestMapping(value="/removeScore")
	public String scoreCheck_os04_removeScore(Model model, String student_id, RedirectAttributes rttr) {
		String txt = "fail";

		
		//네번째 테이블
		int result =this.studentService.removeScore(student_id, this.test_id);
		
		if (result == 1) {
			txt = "success";
		}
	
		rttr.addFlashAttribute("removeResult", txt);

		return "redirect:/instructor/scoreCheck_os04";
	}
	
	
	
	//scoreCheck_student01       #HJ
	@RequestMapping(value="/scoreCheck_student01")
	public String scoreCheck_student01(Model model, HttpSession session,  String key, String value, String pageNum_) {

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		
	      if (pageNum_ == null) {
	          //페이징 번호 초기값
	          pageNum_ = "1"; 
	       }
		
	      int pageNum = Integer.parseInt(pageNum_);
	      int pageCount = 10;
	      int pageStart = pageCount*(pageNum - 1);
	      
	      //첫 페이지
	      int firstPage = 1; 
	      //마지막 페이지
	      int lastPage = 1; 
		
	      int totalCount = this.studentService.insStudentTotalCount(pro_id);
	      
	      lastPage = (int)Math.ceil(totalCount / (double)pageCount);
	      
	      if (key == null || key.equals("")) {
	          key = "all";
	       }
	      
	      List<Student> list = null;
	      if (key.equals("all")) {
	         list = this.studentService.insStudentAll(pro_id, pageStart, pageCount);
	      } else {
	         list = this.studentService.insStudentKeyValue(pro_id, key, value, pageStart, pageCount);
	      }
	      
		
		
	      model.addAttribute("pageNum", pageNum);
	      model.addAttribute("pageCount", pageCount);
	      model.addAttribute("pageStart", pageStart);
	      model.addAttribute("firstPage", firstPage);
	      model.addAttribute("lastPage", lastPage);
	      model.addAttribute("list", list);
	      model.addAttribute("count", list.size());
	      model.addAttribute("totalCount", totalCount);

		return "/instructor/scoreCheck_student01";
	}
	
	
	//scoreCheck_student02       #HJ
	@RequestMapping(value="/scoreCheck_student02")
	public String scoreCheck_student02(Model model, HttpSession session, String student_id) {

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		
		this.student_id = student_id;
		
		Student choiceInsList  =this.studentService.choiceInsStudent(pro_id, this.student_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		
		List<OpenCourse> list = this.openCourseService.studentOpenCourse(pro_id, student_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());

		return "/instructor/scoreCheck_student02";
	}
	
	
	//scoreCheck_student03       #HJ
	@RequestMapping(value="/scoreCheck_student03")
	public String scoreCheck_student03(Model model, HttpSession session, String open_course_id) {

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		
		this.open_course_id = open_course_id;
		
		Student choiceInsList  =this.studentService.choiceInsStudent(pro_id, this.student_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		
		OpenCourse choiceInsList02 = this.openCourseService.choiceStudentOpenCourse(pro_id, this.student_id, this.open_course_id);
		model.addAttribute("choiceInsList02", choiceInsList02);
		
		List<OpenSubject> list = this.openSubjectService.studentOpenSubjectList(pro_id, this.open_course_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());

		return "/instructor/scoreCheck_student03";
	}

	//scoreCheck_student04       #HJ
	@RequestMapping(value="/scoreCheck_student04")
	public String scoreCheck_student04(Model model, HttpSession session, String open_sub_id) {

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		
		this.open_sub_id = open_sub_id;
		
		Student choiceInsList  =this.studentService.choiceInsStudent(pro_id, this.student_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		OpenCourse choiceInsList02 = this.openCourseService.choiceStudentOpenCourse(pro_id, this.student_id, this.open_course_id);
		model.addAttribute("choiceInsList02", choiceInsList02);
		
		OpenSubject choiceInsList03 = this.openSubjectService.choiceStudentOpenSubjectList(pro_id,this.open_course_id ,this.open_sub_id);
		model.addAttribute("choiceInsList03", choiceInsList03);
		
		List<Test> list = this.testService.insTestList02(pro_id, this.open_sub_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());

		
		return "/instructor/scoreCheck_student04";
	}
	
	//scoreCheck_student05       #HJ
	@RequestMapping(value="/scoreCheck_student05")
	public String scoreCheck_student05(Model model, HttpSession session, String test_id) {

		Login l = (Login) session.getAttribute("instructor");
		String pro_id = l.getPro_id();
		
		
		if(test_id!=null) {
			
			this.test_id = test_id;		
		}
		
		
		Student choiceInsList  =this.studentService.choiceInsStudent(pro_id, this.student_id);
		model.addAttribute("choiceInsList", choiceInsList);
		
		OpenCourse choiceInsList02 = this.openCourseService.choiceStudentOpenCourse(pro_id, this.student_id, this.open_course_id);
		model.addAttribute("choiceInsList02", choiceInsList02);
		
		OpenSubject choiceInsList03 = this.openSubjectService.choiceStudentOpenSubjectList(pro_id,this.open_course_id ,this.open_sub_id);
		model.addAttribute("choiceInsList03", choiceInsList03);
		
		Test choiceInsList04 = this.testService.choiceInsTestList(pro_id, this.open_sub_id, this.test_id);
		model.addAttribute("choiceInsList04", choiceInsList04);
		
		List<Student> list = this.studentService.studentScoreList(pro_id,  this.test_id ,  this.open_course_id,  this.student_id);
		model.addAttribute("list", list);
	    model.addAttribute("count", list.size());
		
		
		
		return "/instructor/scoreCheck_student05";
	}
	
	
	//scoreCheck_student05       #HJ
	@RequestMapping(value="/addScore02")
	public String scoreCheck_student05_addScore(Model model, Student s, RedirectAttributes rttr) {
		String txt = "fail";
		
		
		s.setTest_id(this.test_id);
		s.setOpen_sub_id(this.open_sub_id);
		
		//네번째 테이블
		int result =this.studentService.addScore(s);
		
		if (result == 1) {
			txt = "success";
		}
	
		rttr.addFlashAttribute("addResult", txt);

		return "redirect:/instructor/scoreCheck_student05";
	}
	
	//scoreCheck_student05       #HJ
	@RequestMapping(value="/removeScore02")
	public String scoreCheck_student05_removeScore(Model model, String student_id, RedirectAttributes rttr) {
		String txt = "fail";

		
		//네번째 테이블
		int result =this.studentService.removeScore(student_id, this.test_id);
		
		if (result == 1) {
			txt = "success";
		}
	
		rttr.addFlashAttribute("removeResult", txt);

		return "redirect:/instructor/scoreCheck_student05";
	}
	
	//kbs----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/test_management01")
	public String test_management01(Model model, HttpSession session, String key, String value, String pageNum_) {

		Login l = (Login) session.getAttribute("instructor");

		if (pageNum_ == null) {
			// 페이징 번호 초기값
			pageNum_ = "1";
		}

		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount * (pageNum - 1);

		// 첫 페이지
		int firstPage = 1;
		// 마지막 페이지
		int lastPage = 1;

		int totalCount = this.instructorService.insTestOpenCourseTotalCount(l.getPro_id());

		lastPage = (int) Math.ceil(totalCount / (double) pageCount);

		if (key == null || key.equals("")) {
			key = "all";
		}

		List<OpenCourse> list = null;
		if (key.equals("all")) {
			list = this.instructorService.insCourseList(l, pageStart, pageCount);
		} else {
			list = this.instructorService.insCourseList(l, key, value, pageStart, pageCount);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalCount", totalCount);

		return "/instructor/test_management01";
	}
	
	@RequestMapping(value="/test_management02")
	public String test_management02(Model model, HttpSession session, String open_course_id) {
		
		Login l = (Login) session.getAttribute("instructor");
		
		OpenCourse oc = this.instructorService.insCourseList(l, open_course_id);
		model.addAttribute("oc", oc);
		
		List<OpenSubject> list = this.instructorService.insSubjectList(l, open_course_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "/instructor/test_management02";
	}
	
	@RequestMapping(value="/test_management03")
	public String test_management03(Model model, HttpSession session, String open_course_id, String open_sub_id) {
		this.open_course_id = open_course_id;
		this.open_sub_id = open_sub_id;
		Login l = (Login) session.getAttribute("instructor");
		
		OpenCourse oc = this.instructorService.insCourseList(l, open_course_id);
		model.addAttribute("oc", oc);
		
		OpenSubject os = this.instructorService.insSubjectList(l, open_course_id, open_sub_id);
		model.addAttribute("os", os);
		
		List<Test> list = this.instructorService.insTestList(l, open_sub_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		
		return "/instructor/test_management03";
	}
	
	@RequestMapping(value="/testInsert", method=RequestMethod.POST)
	public String testInsert(Test t, RedirectAttributes rttr) throws IOException{
		
		String txt = "fail1";
		String test_id = this.instructorService.auto_test_id().getTest_id();
		MultipartFile fileName = t.getTest_q_file();		
		
		String uploadPath = this.context.getRealPath("") + "resources" + File.separator + "test" + File.separator;
		System.out.println(uploadPath);
		
		String temp = fileName.getOriginalFilename();
		String ext = temp.substring(temp.lastIndexOf("."));
		
		String newFileName = t.getOpen_sub_id()+"_"+ test_id + ext;
		
		FileCopyUtils.copy(fileName.getBytes(), new File(uploadPath + newFileName));
		
		t.setTest_q(newFileName);
		
		int result = this.instructorService.testInsert(t);
		
		if (result == 1) {
			txt = "success1";
		}
		rttr.addFlashAttribute("result", txt);
		
		return "redirect:/instructor/test_management03?open_course_id="+this.open_course_id+"&open_sub_id="+open_sub_id;
	}
	
	@RequestMapping(value="/testUpdate", method=RequestMethod.POST)
	public String testUpdate(Test t, RedirectAttributes rttr) throws IOException {
		
		String txt = "fail2";
		System.out.println(txt);
		MultipartFile fileName = t.getTest_q_file();
		
		String uploadPath = this.context.getRealPath("") + "resources" + File.separator + "test" + File.separator;
		
		String temp = fileName.getOriginalFilename();
		String ext = temp.substring(temp.lastIndexOf("."));
		
		String newFileName = t.getOpen_sub_id()+"_"+ t.getTest_id() + ext +"2";
		
		t.setTest_q(newFileName);
		
		FileCopyUtils.copy(fileName.getBytes(), new File(uploadPath + newFileName));
		
		int result = this.instructorService.testUpdate(t);
		
		if (result == 1) {
			txt = "success2";
		}
		rttr.addFlashAttribute("result", txt);
		System.out.println(txt);
		
		return "redirect:/instructor/test_management03?open_course_id="+this.open_course_id+"&open_sub_id="+this.open_sub_id;
	}
	
	@RequestMapping(value="/testDelete")
	public String testDelete(String test_id, RedirectAttributes rttr) {
		
		String txt = "fail3";
		
		int result = this.instructorService.testDelete(test_id);
		
		if (result == 1) {
			txt = "success3";
		}
		rttr.addFlashAttribute("result", txt);
		System.out.println(txt);
		
		return "redirect:/instructor/test_management03?open_course_id="+this.open_course_id+"&open_sub_id="+this.open_sub_id;
	}
	
	//kbs--------------------------------------------------------------------------------------------
	
}
