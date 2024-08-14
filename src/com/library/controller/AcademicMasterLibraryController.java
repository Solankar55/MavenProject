package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.LibraryAcademicYearModel;
import com.library.serviceInterface.AcademicMasterLibraryServiceInterface;

@Controller
public class AcademicMasterLibraryController {

	@Autowired
	private AcademicMasterLibraryServiceInterface academicMasterLibraryServiceInterface;

	public AcademicMasterLibraryServiceInterface getAcademicMasterLibraryServiceInterface() {
		return academicMasterLibraryServiceInterface;
	}

	public void setAcademicMasterLibraryServiceInterface(
			AcademicMasterLibraryServiceInterface academicMasterLibraryServiceInterface) {
		this.academicMasterLibraryServiceInterface = academicMasterLibraryServiceInterface;
	}
	
	@RequestMapping("LibraryYearMaster")
	public ModelAndView LibraryYearMaster(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("LibraryYearMaster");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = academicMasterLibraryServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> yearList;
			yearList = academicMasterLibraryServiceInterface.getYearList();
			System.out.println(yearList);

			model.addAttribute("yearList", yearList);

			return new ModelAndView("LibraryYearMasterPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	@RequestMapping(value = "LibraryAcadamicMasterSave", params = "AddAcademicYear")
	public ModelAndView LibraryAcadamicMasterSave(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("") LibraryAcademicYearModel libraryAcademicYearModel) {
		System.out.println("LibraryAcadamicMasterSave");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = academicMasterLibraryServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			academicMasterLibraryServiceInterface.saveLabAcademicMaster(libraryAcademicYearModel);

			List<String> yearList;
			yearList = academicMasterLibraryServiceInterface.getYearList();
			System.out.println(yearList);

			model.addAttribute("yearList", yearList);

			return new ModelAndView("LibraryYearMasterPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	@RequestMapping(value = "YearLabupdate", params = "Update")
	public ModelAndView YearLabupdate(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("") LibraryAcademicYearModel libraryAcademicYearModel) {
		System.out.println("YearLabupdate");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = academicMasterLibraryServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int yearId = Integer.parseInt(request.getParameter("labacademicyearid"));
			System.out.println(yearId);

			String yearLab = request.getParameter("labacademicyear");
			System.out.println(yearLab);

			academicMasterLibraryServiceInterface.updateYearOfLibrary(yearId, yearLab);

			List<String> yearList;
			yearList = academicMasterLibraryServiceInterface.getYearList();
			System.out.println(yearList);

			model.addAttribute("yearList", yearList);

			return new ModelAndView("LibraryYearMasterPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	@RequestMapping(value = "YearLabupdate", params = "Delete")
	public ModelAndView YearLabdelete(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("") LibraryAcademicYearModel libraryAcademicYearModel) {
		System.out.println("YearLabDelete");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = academicMasterLibraryServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int yearId = Integer.parseInt(request.getParameter("labacademicyearid"));
			System.out.println(yearId);

			String yearLab = request.getParameter("labacademicyear");
			System.out.println(yearLab);

			academicMasterLibraryServiceInterface.deleteYearOfLibrary(yearId);

			List<String> yearList;
			yearList = academicMasterLibraryServiceInterface.getYearList();
			System.out.println(yearList);

			model.addAttribute("yearList", yearList);

			return new ModelAndView("LibraryYearMasterPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}
	
	
}
