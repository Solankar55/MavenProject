package com.HOD.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.serviceInterface.StaffInformationEditServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

@Controller
public class StaffInformationEditController {

	@Autowired
	private StaffInformationEditServiceInterface staffInformationEditServiceInterface;

	public StaffInformationEditServiceInterface getStaffInformationEditServiceInterface() {
		return staffInformationEditServiceInterface;
	}

	public void setStaffInformationEditServiceInterface(
			StaffInformationEditServiceInterface staffInformationEditServiceInterface) {
		this.staffInformationEditServiceInterface = staffInformationEditServiceInterface;
	}

	@RequestMapping("EditDeleteStaff")
	public ModelAndView EditDeleteStaff(Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("EditDeleteStaff");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = staffInformationEditServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> staffInfo;
			staffInfo = staffInformationEditServiceInterface.getStaffInformation();
			System.out.println("staffInfo" + staffInfo);

			model.addAttribute("StaffInfo", staffInfo);

			return new ModelAndView("EditDeleteStaffPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "updateStaffInformation", params = "UpdateInfo")
	public ModelAndView updateStaffInformation(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("updateStaffInformation");

		int StaffId = Integer.parseInt(request.getParameter("StaffId"));
		System.out.println(StaffId);

		String StaffName = request.getParameter("StaffName");
		System.out.println(StaffName);

		String StaffMb = request.getParameter("StaffMb");
		System.out.println(StaffMb);

		String StaffEmail = request.getParameter("StaffEmail");
		System.out.println(StaffEmail);

		String StaffQ = request.getParameter("StaffQ");
		System.out.println(StaffQ);

		String StaffD = request.getParameter("StaffD");
		System.out.println(StaffD);

		String StaffT = request.getParameter("StaffT");
		System.out.println(StaffT);

		String Barcode = request.getParameter("Barcode");
		System.out.println(Barcode);

		String StaffAdd = request.getParameter("StaffAdd");
		System.out.println(StaffAdd);

		String StaffExp = request.getParameter("StaffExp");
		System.out.println(StaffExp);

		staffInformationEditServiceInterface.updateStaffInfo(StaffId, StaffName, StaffMb, StaffEmail, StaffQ, StaffD,
				StaffT, Barcode, StaffAdd, StaffExp);

		List<String> staffInfo;
		staffInfo = staffInformationEditServiceInterface.getStaffInformation();
		System.out.println("staffInfo" + staffInfo);

		model.addAttribute("StaffInfo", staffInfo);

		return new ModelAndView("EditDeleteStaffPage");
	}

	@RequestMapping(value = "updateStaffInformation", params = "DeleteInfo")
	public ModelAndView deleteStaffInformation(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("updateStaffInformation");

		int StaffId = Integer.parseInt(request.getParameter("StaffId"));
		System.out.println(StaffId);

		String StaffName = request.getParameter("StaffName");
		System.out.println(StaffName);

		String StaffMb = request.getParameter("StaffMb");
		System.out.println(StaffMb);

		String StaffEmail = request.getParameter("StaffEmail");
		System.out.println(StaffEmail);

		String StaffQ = request.getParameter("StaffQ");
		System.out.println(StaffQ);

		String StaffD = request.getParameter("StaffD");
		System.out.println(StaffD);

		String StaffT = request.getParameter("StaffT");
		System.out.println(StaffT);

		String Barcode = request.getParameter("Barcode");
		System.out.println(Barcode);

		String StaffAdd = request.getParameter("StaffAdd");
		System.out.println(StaffAdd);

		String StaffExp = request.getParameter("StaffExp");
		System.out.println(StaffExp);

		staffInformationEditServiceInterface.deleteStaffInfo(StaffId);

		List<String> staffInfo;
		staffInfo = staffInformationEditServiceInterface.getStaffInformation();
		System.out.println("staffInfo" + staffInfo);

		model.addAttribute("StaffInfo", staffInfo);

		return new ModelAndView("EditDeleteStaffPage");
	}
}
