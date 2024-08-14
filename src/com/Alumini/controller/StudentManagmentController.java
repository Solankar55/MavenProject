package com.Alumini.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Alumini.serviceInterface.StudentManagmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.NSS.serviceInterface.NSSApproveServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class StudentManagmentController {

	@Autowired
	private StudentManagmentServiceInterface studentManagmentServiceInterface;

	@Autowired
	private NSSApproveServiceInterface nssApproveServiceInterface;

	public NSSApproveServiceInterface getNssApproveServiceInterface() {
		return nssApproveServiceInterface;
	}

	public void setNssApproveServiceInterface(NSSApproveServiceInterface nssApproveServiceInterface) {
		this.nssApproveServiceInterface = nssApproveServiceInterface;
	}

	public StudentManagmentServiceInterface getStudentManagmentServiceInterface() {
		return studentManagmentServiceInterface;
	}

	public void setStudentManagmentServiceInterface(StudentManagmentServiceInterface studentManagmentServiceInterface) {
		this.studentManagmentServiceInterface = studentManagmentServiceInterface;
	}

	@RequestMapping("StudentSubmitFormList")
	public ModelAndView StudentSubmitFormList(Model model,HttpSession httpSession,HttpServletRequest request) {
		System.out.println("StudentSubmitFormList");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> getStudentList;
			getStudentList = studentManagmentServiceInterface.getStudentList();
			System.out.println(getStudentList);

			model.addAttribute("StudentList", getStudentList);

			return new ModelAndView("StudentSubmitFormListPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping("StudentListAluminiFormPrint")
	public ModelAndView StudentListAluminiFormPrint(Model model,HttpSession httpSession,HttpServletRequest request) {
		System.out.println("StudentListAluminiFormPrint");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> getStudentList;
			getStudentList = studentManagmentServiceInterface.getStudentList();
			System.out.println(getStudentList);

			model.addAttribute("StudentList", getStudentList);

			return new ModelAndView("StudentListAluminiFormPrintPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "PrintAluminiFormStudentList", params = "PrintList")
	public ModelAndView PrintAluminiFormStudentList(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		System.out.println("PrintAluminiFormStudentList");

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "AluminiStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView();
	}
}
