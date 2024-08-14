package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentRegistrationModel;
import com.student.service.RegisterStudentI;
@Repository
@Controller
public class StudentRegistrationController {

	@Autowired
	private RegisterStudentI registerStudentI;
	
	@RequestMapping(value="checkStudentEmailJSON",method=RequestMethod.GET)
	@ResponseBody
	public List<String> checkStudentAvalibility(String StudEmail,String studContact)
	{
		System.out.println("Check Email Address");
		
		System.out.println(StudEmail);
		
		List<String> StudentEmailList=new ArrayList<>();
		StudentEmailList=registerStudentI.getStudentList(StudEmail,studContact);
		System.out.println(StudentEmailList);
		return StudentEmailList;
	}
	
	@RequestMapping(value="checkStudentUserNameJSON",method=RequestMethod.GET)
	@ResponseBody
	public List<String> checkStudentUserNameJSON(String UserNameValue,String StudEmail,String studContact)
	{
		System.out.println("Check User Name");
		System.out.println(UserNameValue);
		
		List<String> StudentUserNameList=new ArrayList<>();
		StudentUserNameList=registerStudentI.getUserNameList(UserNameValue,StudEmail,studContact);
		System.out.println(StudentUserNameList);
		return StudentUserNameList;
	}
	
	@RequestMapping(value="RegisterStudent",method=RequestMethod.POST)
	public ModelAndView RegisterStudent(Model model,@ModelAttribute("RegisterStudent")StudentRegistrationModel studentRegistrationModel)
	{
		System.out.println("Way To Register New Student");
		registerStudentI.RegisterStudent(studentRegistrationModel);
		model.addAttribute("RegProc","Your Registration Process Done Successfully... ");
		return new ModelAndView("LoginPage");
	}

	
	public RegisterStudentI getRegisterStudentI() {
		return registerStudentI;
	}

	public void setRegisterStudentI(RegisterStudentI registerStudentI) {
		this.registerStudentI = registerStudentI;
	}
	
}
