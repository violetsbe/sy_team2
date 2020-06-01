package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.domain.*;
import com.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name = "loginService")
	private LoginService loginService;
	@Resource(name = "openCourseService")
	private OpenCourseService openCourseService;
	@Resource(name = "openSubjectService")
	private OpenSubjectService openSubjectService;
	@Resource(name = "testService")
	private TestService testService;
	@Resource(name = "studentService")
	private StudentService studentService;
	@Resource(name = "bookService")
	private BookService bookService;
	@Resource(name = "classroomService")
	private ClassroomService classroomService;
	@Resource(name = "subjectService")
	private SubjectService subjectService;
	@Resource(name = "courseService")
	private CourseService courseService;
	@Resource(name = "instructorService")
	private InstructorService instructorService;
	/****************************************************************************************************/
	//로그인시 대쉬보드로 이동 - 유신
	@RequestMapping(value = { "/dashboard"})
	public String dashBoard(Model model) {
		
		return "/admin/index";
	}
	
	//관리자 개인정보 조회 - 유신
	@RequestMapping("/info")
	public String admin_info(Model model, String owner_id) {
		Login login = this.loginService.admin_info(owner_id);
		model.addAttribute("login", login);
				
		return "/admin/admin_info";
	}
	/****************************************************************************************************/
	// 기초정보관리 과정- 시후
	@RequestMapping(value = { "/course/list" })
	public String courseList(Model model) {
		List<Course> list = this.courseService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables";
	}

	// 과정 추가
	@RequestMapping("/course/insert")
	public String courseInsert(Course c, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.courseService.courseInsert(c);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/course/list";
	}

	// 과정 삭제
	@RequestMapping("/course/delete")
	public String courseDelete(Course c, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.courseService.courseDelete(c);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/course/list";
	}

	// 과정 수정
	@RequestMapping("/course/update")
	public String course(Course c, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.courseService.courseUpdate(c);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/course/list";
	}
	

	// 기초정보관리 과목- 시후
	@RequestMapping(value = { "/subject/list" })
	public String subjectList(Model model) {
		List<Subject> list = this.subjectService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables02";
	}

	// 과목 추가
	@RequestMapping("/subject/insert")
	public String subjectInsert(Subject s, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.subjectService.subjectInsert(s);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/subject/list";
	}

	// 과목 삭제
	@RequestMapping("/subject/delete")
	public String subjectDelete(Subject s, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.subjectService.subjectDelete(s);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/subject/list";
	}

	// 과목 수정
	@RequestMapping("/subject/update")
	public String subject(Subject s, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.subjectService.subjectUpdate(s);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/subject/list";
	}
	// 기초정보관리 강의실- 시후
	@RequestMapping(value = { "/classroom/list" })
	public String classroomList(Model model) {
		List<Classroom> list = this.classroomService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables03";
	}

	// 강의실 추가
	@RequestMapping("/classroom/insert")
	public String classroomInsert(Classroom cr, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.classroomService.classroomInsert(cr);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/classroom/list";
	}

	// 강의실 삭제
	@RequestMapping("/classroom/delete")
	public String classroomDelete(Classroom cr, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.classroomService.classroomDelete(cr);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/classroom/list";
	}

	// 강의실 수정
	@RequestMapping("/classroom/update")
	public String classroom(Classroom cr, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.classroomService.classroomUpdate(cr);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/classroom/list";
	}


	//교재 목록
	@RequestMapping(value = {"/book/list" })
	public String bookList(Model model) {
		List<Book> list = this.bookService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables04";
	}
	

	// 교재 추가
	@RequestMapping("/book/insert")
	public String bookInsert(Book b, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.bookService.bookInsert(b);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/book/list";
	}

	// 교재 삭제
	@RequestMapping("/book/delete")
	public String bookDelete(Book b, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.bookService.bookDelete(b);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/book/list";
	}


	/****************************************************************************************************/
	// 강사계정관리 - 유신
	@RequestMapping("/instructor_/list")
	public String instructorList(Model model) {
		List<Instructor> list = this.instructorService.list();
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		List<Subject> SubList = this.subjectService.list();
		model.addAttribute("SubList",SubList);
		return "/admin/tables05";
	}
	
	@RequestMapping("/instructor_/insert")
	public String instructorInsert(Model model, Instructor i
			, @RequestParam("sub") String[] subject_name , RedirectAttributes rttr) {
		String pro_id = this.instructorService.auto_pro_id().getPro_id();
		i.setPro_id(pro_id);
		int result = this.instructorService.insert(i, subject_name);
		
		String txt = "fail";
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		
		return "redirect:/admin/instructor_/list";
	}
	
	@RequestMapping("/instructor_/delete")
	public String instructorDelete(Model model, Instructor i , RedirectAttributes rttr) {
		int result = this.instructorService.delete(i);
		
		String txt = "fail";
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/instructor_/list";
	}
	
	@RequestMapping("/instructor_/update")
	public String instructorUpdate(Model model, Instructor i , RedirectAttributes rttr) {
		int result = this.instructorService.update(i);
		
		String txt = "fail";
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/instructor_/list";
	}

	/****************************************************************************************************/
	// 개설과정관리 - 유신

	@RequestMapping(value = { "/openCourse/list" })
	public String openCourseList(Model model, String key, String value) {
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<OpenCourse> list = null;
		if (key.equals("all")) {
			list = this.openCourseService.list();
		} else {
			list = this.openCourseService.list(key, value);
		}
		List<OpenCourse> courseList = this.openCourseService.courseList();
		model.addAttribute("courseList", courseList);
		List<OpenCourse> roomList = this.openCourseService.roomList();
		model.addAttribute("roomList", roomList);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables06";
	}
	

	// 수강인원 선택시 넘어가는 페이지
	@RequestMapping("/openCourse/tablesstudentcount")
	public String tablestudentcount(Model model, String open_course_id, String key, String value, String pageNum_) {
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		if (pageNum_ == null) {
			pageNum_ = "1"; 
		}
		int pageNum = Integer.parseInt(pageNum_);
		int pageStart = 10*(pageNum - 1);
		
		int firstPage = 1; 
		int lastPage = 1; 
		int totalCount = this.openCourseService.tablesstudent_totalCount(open_course_id);
		
		lastPage = (int)Math.ceil(totalCount /10.0);
		
		//수강생 성적 목록
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<Student> list = null;
		if (key.equals("all")) {
			list = this.openCourseService.tablesstudentcount2(open_course_id, pageStart);
		} else {
			list = this.openCourseService.tablesstudentcount2(open_course_id, key, value, pageStart);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		//
		return "/admin/tablesstudentcount";
	}

	// 개설과정 추가 - 과정목록
	@RequestMapping("/openCourse/insert")
	public String openCourseInsert(OpenCourse oc, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.openCourseService.openCourseInsert(oc);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);

		return "redirect:/admin/openCourse/list";
	}

	// 개설과정 삭제
	@RequestMapping("/openCourse/delete")
	public String openCourseDelete(OpenCourse oc, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.openCourseService.openCourseDelete(oc);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		
		return "redirect:/admin/openCourse/list";
	}

	// 개설과정 수정
	@RequestMapping("/openCourse/update")
	public String openCourseUpdate(OpenCourse oc, RedirectAttributes rttr) {

		String txt = "fail";
		int result = this.openCourseService.openCourseUpdate(oc);
		if (result == 1) {
			txt += "success";
		}
		rttr.addFlashAttribute("result", txt);
		return "redirect:/admin/openCourse/list";
	}

	/****************************************************************************************************/
	//개설과목관리 - 형용
	
	//개설과목관리 -> 개설과정선택
	@RequestMapping("/openSubject/list")
	public String tables07(Model model, String key, String value, String pageNum_) {
		
		if (pageNum_ == null) {
			//페이지 초기값
			pageNum_ = "1"; 
		}
		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount*(pageNum - 1);
		
		//첫페이지 초기값
		int firstPage = 1; 
		//마지막페이지 초기값
		int lastPage = 1;
		
		int totalCount = this.openCourseService.totalCount();
		
		lastPage = (int)Math.ceil(totalCount / (double)pageCount);
		
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<OpenCourse> list = null;
		if (key.equals("all")) {
			list = this.openCourseService.list(pageStart, pageCount);
		} else {
			list = this.openCourseService.list(key, value, pageStart, pageCount);
		}
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalCount", totalCount);
		
		return "/admin/tables07";
	}
		
		//개설과목관리 -> 개설과목출력
		@RequestMapping("/openSubject/list2")
		public String tables07_1(String open_course_id, Model model) {
			
			List<OpenCourse> result1 = this.openCourseService.list(open_course_id);
			List<OpenSubject> result2 = this.openSubjectService.adminList1(open_course_id);
			List<Subject> result3 = this.subjectService.list();
			List<Book> result4 = this.bookService.list();
			List<Instructor> result5 = this.instructorService.list();

			int count = result2.size();
			
			model.addAttribute("courseList", result1);
			model.addAttribute("subList", result2);
			model.addAttribute("count", count);
			model.addAttribute("subject", result3);
			model.addAttribute("book", result4);
			model.addAttribute("instructor", result5);
			
			//WEB-INF/views/admin/tables07_1
			return "/admin/tables07_1";
		}	
		
		//개설과목관리 -> 개설과목등록
		@RequestMapping("/openSubject/insert")
		private String openSubject_insert(OpenSubject os, RedirectAttributes rttr) {
			
			String txt = "fail";
			int result = this.openSubjectService.insert(os);
			if (result == 1) {
				txt = "success";
			}
			rttr.addFlashAttribute("result", txt);

			return "redirect:/admin/openSubject/list2?open_course_id="+os.getOpen_course_id();
		}
		
		//개설과목관리 -> 개설과목삭제
		@RequestMapping("/openSubject/delete")
		private String openSubject_delete(OpenSubject os, RedirectAttributes rttr) {
			
			String txt = "fail";
			int result = this.openSubjectService.delete(os);
			if (result == 1) {
				txt = "success";
			}
			rttr.addFlashAttribute("result", txt);

			return "redirect:/admin/openSubject/list2?open_course_id="+os.getOpen_course_id();
		}
		
		//개설과목관리 -> 개설과목수정
		@RequestMapping("/openSubject/update")
		private String openSubject_update(OpenSubject os, RedirectAttributes rttr) {
			
			String txt = "fail";
			int result = this.openSubjectService.update(os);
			if (result == 1) {
				txt = "success";
			}
			rttr.addFlashAttribute("result", txt);

			return "redirect:/admin/openSubject/list2?open_course_id="+os.getOpen_course_id();
		}
		/****************************************************************************************************/
		//수강생관리 - 형용
		//수강생관리 - 수강생출력페이지
		  @RequestMapping("/student/list")
		   private String student_list(Model model, String key, String value, String pageNum_) {
		      
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
		      
		      int totalCount = this.studentService.total_student();
		      
		      //마지막 페이지 계산 과정 추가
		      //게시물총수(31) / (double)pageCount(10) 연산의 결과값에서 가장 가까운 큰 정수
		      lastPage = (int)Math.ceil(totalCount / (double)pageCount);
		      
		      if (key == null || key.equals("")) {
		         key = "all";
		      }
		      List<Student> list = null;
		      if (key.equals("all")) {
		         list = this.studentService.list(pageStart, pageCount);
		      } else {
		         list = this.studentService.studentManage(key, value, pageStart, pageCount);
		      }
		      model.addAttribute("pageNum", pageNum);
		      model.addAttribute("pageCount", pageCount);
		      model.addAttribute("pageStart", pageStart);
		      model.addAttribute("firstPage", firstPage);
		      model.addAttribute("lastPage", lastPage);
		      model.addAttribute("list", list);
		      model.addAttribute("count", list.size());
		      model.addAttribute("totalCount", totalCount);
		         
		      return "/admin/tables08";
		   }
		
		//수강생관리 - 수강횟수
			@RequestMapping("/course/count")
			private String course_count(Model model, String student_id) {
				
				Student result = this.studentService.courseCount(student_id);
				List<OpenCourse> result2 = this.openCourseService.studentOpenCourse(student_id);
				int count = result2.size();
				
				model.addAttribute("student", result);
				model.addAttribute("openCourse", result2);
				model.addAttribute("count", count);
				
				return "/admin/tablescoursecount";
			}
			
			//수강생관리 - 과정등록
			@RequestMapping("/student/course")
			private String student_course(Model model, String student_id) {
				
				Student result = this.studentService.courseCount(student_id);
				List<OpenCourse> result2 = this.openCourseService.possibleCourse(student_id);
				
				model.addAttribute("student", result);
				model.addAttribute("openCourse", result2);
				model.addAttribute("count", result2.size());
			
				return "/admin/tables08_1";
			}
			
			//수강생생관리 - 과정등록 - 입력
			@RequestMapping("/courseHistory/add")
			private String courseHistory_add(OpenCourse oc, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.openCourseService.courseHistory(oc);
				if(result == 1) {
					txt = "success";
				}
				
				rttr.addFlashAttribute("result", txt);
				
				return "redirect:/admin/student/course?student_id="+oc.getStudent_id();
			}
			
			//수강생생관리 - 과정취소 - 취소
			@RequestMapping("/courseHistory/delete")
			private String courseHistory_del(OpenCourse oc, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.openCourseService.courseHistoryDel(oc);
				if(result ==1) {
					txt = "success";
				}
				
				rttr.addFlashAttribute("result", txt);
				
				return "redirect:/admin/student/cansle?student_id="+oc.getStudent_id();
			}
			
			
			//수강생관리 - 과정취소
			@RequestMapping("/student/cansle")
			private String student_cansle(Model model, String student_id) {
				
				Student result = this.studentService.courseCount(student_id);
				List<OpenCourse> result2 = this.openCourseService.courseCansle(student_id);
				
				model.addAttribute("student", result);
				model.addAttribute("openCourse", result2);
				model.addAttribute("count", result2.size());
				
				return "/admin/tables08_2";
			}
			
			//수강생관리 - 수정
			@RequestMapping("/student/update")
			private String student_update(Student s, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.studentService.studentUpdate(s);
				if(result == 1) {
					txt = "success";
				}
				
				rttr.addFlashAttribute("result", txt);
				
				return "redirect:/admin/student/list";
			}
			
			//수강생관리 - 삭제
			@RequestMapping("/student/delete")
			private String student_delete(Student s, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.studentService.studentDelete(s);
				if(result == 1) {
					txt = "success";
				}
				
				rttr.addFlashAttribute("result", txt);
				
				return "redirect:/admin/student/list";
			}
			
			//수강생관리 - 등록
			@RequestMapping("/student/insert")
			private String student_insert(Student s, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.studentService.studentInsert(s);
				if(result==1) {
					txt="success";
				}
				
				rttr.addFlashAttribute("result", txt);
				return "redirect:/admin/student/list";
			}
			
			//수강생관리 - 비밀번호초기화
			@RequestMapping("/student/pwModify")
			private String student_pwModify(Student s, RedirectAttributes rttr) {
				
				String txt = "fail";
				int result = this.studentService.studentPwInit(s);
				if(result==1) {
					txt="success";
				}
				
				rttr.addFlashAttribute("result", txt);
				return "redirect:/admin/student/list";
			}
			
		
	/****************************************************************************************************/
	// 성적조회 - 유신
	// 과목별성적조회 - 개설과정선택 페이지
	@RequestMapping("/score/subject" )
	public String scoreList1_course(Model model, String key, String value) {
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<OpenCourse> list = null;
		if (key.equals("all")) {
			list = this.openCourseService.list();
		} else {
			list = this.openCourseService.list(key, value);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables09_1";
	}

	// 과목별성적조회 - 개설과목선택 페이지
	@RequestMapping("/score/subject2")
	public String scoreList1_subject(Model model, String open_course_id) {
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		// 개설과목 리스트
		List<OpenSubject> list = this.openSubjectService.adminList(open_course_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		System.out.println();
		return "/admin/tables09_1_subject";
	}
	
	// 과목별성적조회 - 시험선택 페이지
	@RequestMapping("/score/subject3")
	public String scoreList1_test(Model model, String open_course_id, String open_sub_id) {
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.openSubjectService.subject(open_course_id, open_sub_id);
		model.addAttribute("os", os);
		
		//시험목록
		List<Test> list = this.testService.list(open_sub_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "/admin/tables09_1_test";
	}
	
	// 과목별성적조회 - 성적조회
	@RequestMapping("/score/subject4")
	public String scoreList1_score(Model model, String open_course_id, String open_sub_id
			, String test_id, String key, String value, String pageNum_) {
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.openSubjectService.subject(open_course_id, open_sub_id);
		model.addAttribute("os", os);
		Test t = this.testService.test(open_sub_id, test_id);
		model.addAttribute("t", t);
		
		if (pageNum_ == null) {
			pageNum_ = "1"; 
		}
		int pageNum = Integer.parseInt(pageNum_);
		int pageStart = 10*(pageNum - 1);
		
		int firstPage = 1; 
		int lastPage = 1; 
		int totalCount = this.studentService.subjectCheck1_totalCount(open_course_id, test_id);
		
		lastPage = (int)Math.ceil(totalCount /10.0);
		
		//수강생 성적 목록
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<Student> list = null;
		if (key.equals("all")) {
			list = this.studentService.subjectCheck1(open_course_id, test_id, pageStart);
		} else {
			list = this.studentService.subjectCheck2(open_course_id, test_id, key, value, pageStart);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		return "/admin/tables09_1_score";
	}

	// 수강생별 성적조회 - 수강생 선택 페이지
	@RequestMapping( "/score/student" )
	public String scoreList2_student(Model model, String key, String value, String pageNum_) {
		if (pageNum_ == null) {
			pageNum_ = "1"; 
		}
		int pageNum = Integer.parseInt(pageNum_);
		int pageCount = 10;
		int pageStart = pageCount*(pageNum - 1);
		
		int firstPage = 1; 
		int lastPage = 1; 
		
		int totalCount = this.studentService.total_student();
		
		lastPage = (int)Math.ceil(totalCount / (double)pageCount);
		
		if (key == null || key.equals("")) {
			key = "all";
		}
		List<Student> list = null;
		if (key.equals("all")) {
			list = this.studentService.list(pageStart, pageCount);
		} else {
			list = this.studentService.studentManage(key, value, pageStart, pageCount);
		}
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageStart", pageStart);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("totalCount", totalCount);
		return "/admin/tables09_2";
	}

	// 수강생별 성적조회 - 개설과정 선택 페이지
	@RequestMapping(value = { "/score/student2" })
	public String scoreList2_course(Model model, String student_id) {
		Student student = this.studentService.courseCount(student_id);
		model.addAttribute("student", student);
		List<OpenCourse> list = this.openCourseService.studentOpenCourse(student_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/admin/tables09_2_course";
	}

	// 수강생별 성적조회 - 개설과목 선택 페이지
	@RequestMapping(value = { "/score/student3" })
	public String scoreList2_subject(Model model, String student_id, String open_course_id) {
		Student student = this.studentService.courseCount(student_id);
		model.addAttribute("student", student);
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		// 개설과목 리스트
		List<OpenSubject> list = this.openSubjectService.adminList(open_course_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "/admin/tables09_2_subject";
	}
	
	// 수강생별 성적조회 - 시험 선택 페이지
	@RequestMapping(value = { "/score/student4" })
	public String scoreList2_test(Model model, String student_id, String open_course_id, String open_sub_id) {
		Student student = this.studentService.courseCount(student_id);
		model.addAttribute("student", student);
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.openSubjectService.subject(open_course_id, open_sub_id);
		model.addAttribute("os", os);
		//시험목록
		List<Test> list = this.testService.list(open_sub_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "/admin/tables09_2_test";
	}
	
	// 수강생별 성적조회 - 성적
	@RequestMapping(value = { "/score/student5" })
	public String scoreList2_score(Model model, String student_id, String open_course_id, String open_sub_id, String test_id) {
		Student student = this.studentService.courseCount(student_id);
		model.addAttribute("student", student);
		OpenCourse oc = this.openCourseService.tablesstudentcount(open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.openSubjectService.subject(open_course_id, open_sub_id);
		model.addAttribute("os", os);
		Test t = this.testService.test(open_sub_id, test_id);
		model.addAttribute("t", t);
		//성적
		Student score = this.studentService.scoreStudent(student_id, test_id);
		model.addAttribute("score", score);
		return "/admin/tables09_2_score";
	}
	
	@RequestMapping("/book/info")
	public @ResponseBody Map<?, ?> infoBook(String isbn) throws IOException{
		
		String str = String.format(
	    		"http://book.interpark.com/api/search.api?"
	    		+ "key=7F02945A8E0D731BED5FF398D523FECB607FD3331AF4A91AEE19FF93D23884E6"
	    		+ "&query=%s&queryType=isbn&output=json", isbn);
	    
		URL url = new URL(str);
	    
	    ObjectMapper mapper = new ObjectMapper();
	    Map<?, ?> temp = mapper.readValue(url.openStream(), Map.class);
	    
		return temp;
	}
}
