package com.Exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Exam.model.CreateTimeTableModel;
import com.Exam.serviceInterface.CreateTimeTableServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Controller
public class CreateTimeTableController {

	@Autowired
	private CreateTimeTableServiceInterface createTimeTableServiceInterface;

	@RequestMapping("ExamHomePage")
	public ModelAndView ExamHomePage(HttpServletRequest request, HttpSession httpSession, Model model) {
		System.out.println("Exam Home Page");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = createTimeTableServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			return new ModelAndView("ExamHome");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping("CrateTimeTable")
	public ModelAndView CrateTimeTable(Model model,
			@ModelAttribute("TimeTable") CreateTimeTableModel createTimeTableModel, HttpServletRequest request,
			HttpSession httpSession) {
		System.out.println("Open Time Table Creation Form");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = createTimeTableServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> GetTimeTableList;
			GetTimeTableList = createTimeTableServiceInterface.getTimeTableList();
			model.addAttribute("GetTimeTableList", GetTimeTableList);

			return new ModelAndView("CreateTimeTablePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "SaveTimeTable", params = "SaveEvent")
	public ModelAndView SaveTimeTable(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("TimeTable") CreateTimeTableModel createTimeTableModel) {
		System.out.println("Save Time Table");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			createTimeTableModel.setTeacherName(username);

			createTimeTableServiceInterface.SaveTimeTable(createTimeTableModel);

			List<String> GetTimeTableList;
			GetTimeTableList = createTimeTableServiceInterface.getTimeTableList();
			model.addAttribute("GetTimeTableList", GetTimeTableList);

			return new ModelAndView("ExamHome");
		}
	}

	public CreateTimeTableServiceInterface getCreateTimeTableServiceInterface() {
		return createTimeTableServiceInterface;
	}

	public void setCreateTimeTableServiceInterface(CreateTimeTableServiceInterface createTimeTableServiceInterface) {
		this.createTimeTableServiceInterface = createTimeTableServiceInterface;
	}

}
