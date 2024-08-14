package com.Alumini.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Alumini.model.RegisterAluminiDetailsModel;
import com.Alumini.serviceInterface.AluminiRegistrationserviceInterface;
import com.HOD.model.StaffRegistrationModel;

@Controller
public class AluminiRegistrationController {

	@Autowired
	private AluminiRegistrationserviceInterface aluminiRegistrationserviceInterface;

	@RequestMapping("AluminiRegistrationForm")
	public ModelAndView AluminiRegistrationForm(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterAluminiWay") RegisterAluminiDetailsModel registerAluminiDetailsModel) {
		System.out.println("Alumini Registration Form");

		/*session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = aluminiRegistrationserviceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			*/Date d = new Date();
			SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
			String CurrentDate = s.format(d);
			model.addAttribute("CurrentDate", CurrentDate);

			return new ModelAndView("AluminiRegistrationFormPage");
		/*} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}*/
	}

	@RequestMapping(value = "SaveAluminiFormD", params = "RegisterAluminiD", method = RequestMethod.POST)
	public ModelAndView SaveAluminiForm(
			@ModelAttribute("RegisterAluminiWay") RegisterAluminiDetailsModel registerAluminiDetailsModel) {
		System.out.println("Save Alumini Details");

		aluminiRegistrationserviceInterface.saveEnteredDetails(registerAluminiDetailsModel);

		return new ModelAndView("ThanksPageAluminiD");
	}

	@RequestMapping("AluminiHomePage")
	public ModelAndView AluminiHomePage()
	{
		System.out.println("AluminiHomePage");
		return new ModelAndView("AluminiHomePagePage");
	}
	
	public AluminiRegistrationserviceInterface getAluminiRegistrationserviceInterface() {
		return aluminiRegistrationserviceInterface;
	}

	public void setAluminiRegistrationserviceInterface(
			AluminiRegistrationserviceInterface aluminiRegistrationserviceInterface) {
		this.aluminiRegistrationserviceInterface = aluminiRegistrationserviceInterface;
	}

}
