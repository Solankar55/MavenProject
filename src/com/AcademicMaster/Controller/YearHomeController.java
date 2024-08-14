package com.AcademicMaster.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AcademicMaster.serviceInterface.StudentControllerYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Controller
public class YearHomeController {

	@Autowired
	private StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface;

	public StudentControllerYearDepartmentServiceInterface getStudentControllerYearDepartmentServiceInterface() {
		return studentControllerYearDepartmentServiceInterface;
	}

	public void setStudentControllerYearDepartmentServiceInterface(
			StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface) {
		this.studentControllerYearDepartmentServiceInterface = studentControllerYearDepartmentServiceInterface;
	}

	@RequestMapping("YearHomePage")
	public ModelAndView YearHomePage(HttpServletRequest request, HttpSession httpSession, Model model) {
		System.out.println("Year Home Page");
		
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentControllerYearDepartmentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);
			return new ModelAndView("YearHomePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}
}
