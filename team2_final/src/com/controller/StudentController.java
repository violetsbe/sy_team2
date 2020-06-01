package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.*;
import com.persistence.OpenCourseDAO;
import com.persistence.StudentDAO;
import com.persistence.TestDAO;
import com.service.OpenCourseService;
import com.service.StudentService;

@Controller
public class StudentController {
	@Resource(name = "openCourseDAO")
	private OpenCourseDAO openCourseDAO;
	@Resource(name = "openCourseService")
	private OpenCourseService openCourseService;
	@Resource(name = "testDAO")
	private TestDAO testDAO;
	@Resource(name = "studentDAO")
	private StudentDAO studentDAO;
	@Resource(name = "studentService")
	private StudentService studentService;
	
	@RequestMapping(value = {"dashboard", "/students/studentdashboard"})
	public String studentDashboard(Model model, HttpSession session) {
		
		Login l = (Login) session.getAttribute("student");
		
		List<OpenCourse> list = this.studentService.studentDashboard(l);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/students/studentdashboard";
	}
	
	@RequestMapping(value="/students/studentinformation")
	public String studentInformation(Model model, HttpSession session) {
		
		Login l = (Login) session.getAttribute("student");
		
		Student list = this.studentService.student_info(l);
		model.addAttribute("list", list);
		return "/students/studentinformation";
	}
	
	@RequestMapping(value="/students/pwUpdate")
	public String studentUpdate(Student s, RedirectAttributes rttr) {
		
		String txt ="fail";
		
		int result = this.studentService.pw_update(s);
		if(result == 1) {
			txt="success";
		}
		rttr.addFlashAttribute("result", txt);
		System.out.println(txt);
		return "redirect:/students/studentinformation";
	}
	
	@RequestMapping(value="/students/studentOC")
	public String studentOC(Model model, HttpSession session) {
		
		Login l = (Login) session.getAttribute("student");
		
		List<OpenCourse> list = this.studentService.studentOC(l);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/students/studentOC";
	}
	
	@RequestMapping(value="/students/studentOS")
	public String studentOS(Model model, HttpSession session, String open_course_id) {
		
		Login l = (Login) session.getAttribute("student");
		
		OpenCourse oc = this.studentService.studentOC01(l, open_course_id);
		model.addAttribute("oc", oc);
		List<OpenSubject> list = this.studentService.studentOS(l, open_course_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/students/studentOS";
	}
	
	@RequestMapping(value="/students/studentTestPoint")
	public String studentTestPoint(Model model, HttpSession session, String open_course_id, String open_sub_id) {
		
		Login l = (Login) session.getAttribute("student");
		
		OpenCourse oc = this.studentService.studentOC01(l, open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.studentService.studentOS01(l, open_sub_id);
		model.addAttribute("os", os);
		List<Test> list = this.studentService.studentTestPoint(l, open_sub_id);
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		return "/students/studentTestPoint";
	}
	
	@RequestMapping(value="/students/studentScore")
	public String studentScore(Model model, HttpSession session, String open_course_id, String open_sub_id, String test_id) {
		
		Login l = (Login) session.getAttribute("student");
		
		OpenCourse oc = this.studentService.studentOC01(l, open_course_id);
		model.addAttribute("oc", oc);
		OpenSubject os = this.studentService.studentOS01(l, open_sub_id);
		model.addAttribute("os", os);
		Test t = this.studentService.studentTestPoint01(l, test_id);
		model.addAttribute("t", t);
		List<Student> list = this.studentService.studentScore(l, open_sub_id, test_id);
		model.addAttribute("list", list);
		return "/students/studentScore";
	}
}
