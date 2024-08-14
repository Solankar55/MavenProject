package com.HOD.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.StaffRegistrationModel;
import com.HOD.serviceInterface.CreateUserControllerServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

@Controller
@Repository
public class CreateUserController {

	@Autowired
	private CreateUserControllerServiceInterface createUserControllerServiceInterface;

	@RequestMapping("HODHomeP")
	public ModelAndView HODHomeP(Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel,
			HttpServletRequest request, HttpSession session) {
		System.out.println("Way To HOD Home Page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = createUserControllerServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("HODHome");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("CreateTeachingStaff")
	public ModelAndView NonTeachingStaff(Model model,
			@ModelAttribute("saveStaffcommand") StaffRegistrationModel staffRegistrationModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel,
			HttpServletRequest request, HttpSession session) {
		System.out.println("Way To Create Teaching Staff Reg Page");
 
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = createUserControllerServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);
			model.addAttribute("CurrentDate", curentdate);

			int StaffID;
			StaffID = createUserControllerServiceInterface.getStaffRegID();
			System.out.println(StaffID);
			model.addAttribute("StaffID", StaffID);

			return new ModelAndView("CreateTeachingStaffRegPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("SaveStaff")
	public ModelAndView saveTechingNonteaching(HttpServletRequest request, Model model,
			@ModelAttribute("saveStaffcommand") StaffRegistrationModel staffRegistrationModel) {
		String StaffID = request.getParameter("StaffID");
		String name = staffRegistrationModel.getStaffName().toString();
		String type = staffRegistrationModel.getStaffType().toString();
		String number = staffRegistrationModel.getMobileNumber().toString();

		String barcode = "LECT".concat(type.substring(0, 3).toUpperCase().concat(StaffID));
		staffRegistrationModel.setBarcode(barcode);
		createUserControllerServiceInterface.saveStaff(staffRegistrationModel);

		return new ModelAndView("HODHome");

	}
	
	public CreateUserControllerServiceInterface getCreateUserControllerServiceInterface() {
		return createUserControllerServiceInterface;
	}

	public void setCreateUserControllerServiceInterface(
			CreateUserControllerServiceInterface createUserControllerServiceInterface) {
		this.createUserControllerServiceInterface = createUserControllerServiceInterface;
	}
}
