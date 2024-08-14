package com.Exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamMasterController {

	@RequestMapping("SemisterMaster")
	public ModelAndView SemisterMaster() {
		System.out.println("SemisterMaster");

		return new ModelAndView("SemisterMasterPage");
	}

	@RequestMapping("SubjectMasterE")
	public ModelAndView SubjectMasterE() {
		System.out.println("SubjectMasterE");

		return new ModelAndView("SubjectMasterEPage");
	}

	@RequestMapping("ThoeryPracticleMaster")
	public ModelAndView ThoeryPracticleMaster() {
		System.out.println("ThoeryPracticleMaster");

		return new ModelAndView("ThoeryPracticleMasterPage");
	}

	@RequestMapping("ExamTypeMaster")
	public ModelAndView ExamTypeMaster() {
		System.out.println("ExamTypeMaster");

		return new ModelAndView("ExamTypeMaster");
	}

	/*
	 * @RequestMapping("") public ModelAndView { System.out.println("");
	 * 
	 * return new ModelAndView(""); }
	 * 
	 * 
	 * 
	 * @RequestMapping("") public ModelAndView { System.out.println("");
	 * 
	 * return new ModelAndView(""); }
	 */
}
