package com.library.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.LibrarySubjectMaster;
import com.library.serviceInterface.LibrarySubjectMasterServiceInterface;

@Controller
public class LibrarySubjectMasterController {

	@Autowired
	private LibrarySubjectMasterServiceInterface subjectMasterServiceInterface;

	public LibrarySubjectMasterServiceInterface getSubjectMasterServiceInterface() {
		return subjectMasterServiceInterface;
	}

	public void setSubjectMasterServiceInterface(LibrarySubjectMasterServiceInterface subjectMasterServiceInterface) {
		this.subjectMasterServiceInterface = subjectMasterServiceInterface;
	}
	
	@RequestMapping("LibrarySubjectMasterDisplay")
	public ModelAndView SubjectPage(HttpServletRequest request, HttpSession session, Model model) {
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = subjectMasterServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			List<LibrarySubjectMaster> LibrarySubjectList = subjectMasterServiceInterface.librarySubjectSimpleList();
			return new ModelAndView("LibrarySubjectMasterTP", "LSMaster", LibrarySubjectList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("SaveSubjectData")
	public ModelAndView LibrarySubjectSave(@ModelAttribute("librarysubjectmaster") LibrarySubjectMaster lsm,@RequestParam Map<String,String> getting)
	{
		
		subjectMasterServiceInterface.librarySubjectSave(lsm);
		List<LibrarySubjectMaster> LibrarySubjectList = subjectMasterServiceInterface.librarySubjectSimpleList();
		return new ModelAndView("LibrarySubjectMasterTP","LSMaster",LibrarySubjectList);
	}
	
	@RequestMapping("UpdateSubjectData")
	public ModelAndView UpdateSubjectData(@RequestParam("SubjectId") int id, @RequestParam("Subject") String subject)
	{
		//System.out.println("ClassNumber: "+classNumber);
		
		subjectMasterServiceInterface.updateLibraryData(id,subject);	
		List<LibrarySubjectMaster> LibrarySubjectList = subjectMasterServiceInterface.librarySubjectSimpleList();
		System.out.println(LibrarySubjectList);
		return new ModelAndView("LibrarySubjectMasterTP","LSMaster",LibrarySubjectList);
	}
	
	@RequestMapping(value="UpdateSubjectData",params="Delete")
	public ModelAndView DeleteSubjectData(@RequestParam("SubjectId") int id)
	{
		//System.out.println("ClassNumber: "+classNumber);
		
		subjectMasterServiceInterface.deleteLibraryData(id);	
		List<LibrarySubjectMaster> LibrarySubjectList = subjectMasterServiceInterface.librarySubjectSimpleList();
		System.out.println(LibrarySubjectList);
		return new ModelAndView("LibrarySubjectMasterTP","LSMaster",LibrarySubjectList);
	}
}
