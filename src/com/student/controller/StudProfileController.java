package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentRegistrationModel;
import com.student.service.RegisterStudentI;
@Repository
@Controller
public class StudProfileController {

	@Autowired
	RegisterStudentI registerStudentI;
	
	@RequestMapping(value="profile",method=RequestMethod.GET)
	public ModelAndView EditPro(Model model,HttpSession session,HttpServletRequest request)
	{
		System.out.println("Way to Edit Profile");
		session=request.getSession();
		String username=(String)session.getAttribute("Username");
		
		List<StudentRegistrationModel> EditInfoList=new ArrayList<>();
		EditInfoList=registerStudentI.GetDetailsForEdit(username);
		System.out.println(EditInfoList);
		
	/*	String StudentName=(String)EditInfoList.get(0).getStudentName();
		System.out.println(StudentName);
		String StudentContact=EditInfoList.get(0).getStudentContactNumber();
		System.out.println(StudentContact);
		String StudentEmail=EditInfoList.get(0).getStudentEmail();
		System.out.println(StudentEmail);
		
		List<String> StudentDetailInfo=new ArrayList<>();
		StudentDetailInfo=registerStudentI.getStudentDetailInfo(StudentName,StudentContact,StudentEmail);
		System.out.println(StudentDetailInfo);
		
		model.addAttribute("StudentDetailInfo",StudentDetailInfo);*/
		
		model.addAttribute("EditInfo",EditInfoList);
		
		return new ModelAndView("EditProfilePage");
				
	}
	
	@RequestMapping(value="SaveImage",method=RequestMethod.GET)
	@ResponseBody
	public List<String> SaveImage(String id)
	{
		List<String> SaveImage=null;
		System.out.println(id);
		
		return SaveImage;
	}
	
}
