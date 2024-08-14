package com.staff.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.HODSubjectMasterModel;
import com.HOD.model.StaffRegistrationModel;
import com.staff.serviceInterface.AssignmentManagementServiceInterface;
import com.staff.serviceInterface.StaffMenuServiceInterface;

@Controller
public class AssignmentManagementController {

	@Autowired
	private AssignmentManagementServiceInterface assignmentManagementServiceInterface;

	@Autowired
	private StaffMenuServiceInterface staffMenuServiceInterface;

	public AssignmentManagementServiceInterface getAssignmentManagementServiceInterface() {
		return assignmentManagementServiceInterface;
	}

	public void setAssignmentManagementServiceInterface(
			AssignmentManagementServiceInterface assignmentManagementServiceInterface) {
		this.assignmentManagementServiceInterface = assignmentManagementServiceInterface;
	}

	public StaffMenuServiceInterface getStaffMenuServiceInterface() {
		return staffMenuServiceInterface;
	}

	public void setStaffMenuServiceInterface(StaffMenuServiceInterface staffMenuServiceInterface) {
		this.staffMenuServiceInterface = staffMenuServiceInterface;
	}

	@RequestMapping("RemoveAssignment")
	public ModelAndView RemoveAssignment(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("RemoveAssignment");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<HODSubjectMasterModel> SubjectList;
			SubjectList = assignmentManagementServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);
			try {
				String SubjectName = SubjectList.get(0).getSubjectName();

				List<String> GivenAssignmentList;
				GivenAssignmentList = assignmentManagementServiceInterface.getGivenAssignMentListToRemove(SubjectName);
				System.out.println(GivenAssignmentList);

				model.addAttribute("GivenAssignmentList", GivenAssignmentList);

				return new ModelAndView("RemoveAssignmentPage");
			} catch (Exception e) {
				System.out.println("Exception" + e);
				return new ModelAndView("StaffNotAssignSubjectPage");
			}

		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}
	}

	@RequestMapping(value = "deleterowAssignment")
	@ResponseBody
	public String deleterowAssignment(int assid) {
		String Op = assignmentManagementServiceInterface.deleteAssignment(assid);
		return Op;
	}

	@RequestMapping("GivenAssignMentList")
	public ModelAndView GivenAssignMentList(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("Given AssignMent List");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<HODSubjectMasterModel> SubjectList;
			SubjectList = assignmentManagementServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);

			try {
				String SubjectName = SubjectList.get(0).getSubjectName();

				List<String> GivenAssignmentList;
				GivenAssignmentList = assignmentManagementServiceInterface.getGivenAssignMentList(SubjectName);
				System.out.println(GivenAssignmentList);

				model.addAttribute("GivenAssignmentList", GivenAssignmentList);
				return new ModelAndView("GivenAssignMentListPage");
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("StaffNotAssignSubjectPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}
	}

	@RequestMapping("RemoveAssignmentList")
	public ModelAndView RemoveAssignmentList(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("RemoveAssignmentList");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<HODSubjectMasterModel> SubjectList;
			SubjectList = assignmentManagementServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);

			try {
				String SubjectName = SubjectList.get(0).getSubjectName();

				List<String> RemoveAssignmentList;
				RemoveAssignmentList = assignmentManagementServiceInterface.getRemoveAssignmentList(SubjectName);
				System.out.println(RemoveAssignmentList);

				model.addAttribute("RemoveAssignmentList", RemoveAssignmentList);

				return new ModelAndView("RemoveAssignmentListPage");
			} catch (Exception e) {

				System.out.println(e);
				return new ModelAndView("StaffNotAssignSubjectPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}
	}
}
