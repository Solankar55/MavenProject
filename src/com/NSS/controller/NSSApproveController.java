package com.NSS.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.StaffRegistrationModel;
import com.NSS.serviceInterface.NSSApproveServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class NSSApproveController {

	@Autowired
	private NSSApproveServiceInterface nssApproveServiceInterface;

	public NSSApproveServiceInterface getNssApproveServiceInterface() {
		return nssApproveServiceInterface;
	}

	public void setNssApproveServiceInterface(NSSApproveServiceInterface nssApproveServiceInterface) {
		this.nssApproveServiceInterface = nssApproveServiceInterface;
	}

	@RequestMapping("NssHome")
	public ModelAndView NssHome()
	{
		System.out.println("NssHome");
		return new ModelAndView("NSSHome");
	}
	
	@RequestMapping("ApproveStudentNSS")
	public ModelAndView ApproveStudentNSS(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("Apprive Student Who requested");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> GetNSSStudentList;
			GetNSSStudentList = nssApproveServiceInterface.GetNSSStudentList();
			model.addAttribute("GetNSSStudentList", GetNSSStudentList);

			return new ModelAndView("ApproveStudentNSSPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "ApproveNSSStudent", params = "SubmitStudentNSS")
	public ModelAndView ApproveNSSStudent(HttpServletRequest request, Model model) {
		System.out.println("Check CheckBox");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers=CheckBoxNumbers+100000;
		// System.out.println(CheckBoxNumbers);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String CurrentDate = sdf.format(d);
		System.out.println(CurrentDate);

		String BoxValue;
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue = request.getParameter("NSSStudentCount" + i);
			if (BoxValue == null) {
				continue;
			}
			System.out.println(BoxValue);

			nssApproveServiceInterface.updateStudentStatus(BoxValue, CurrentDate);
		}

		List<String> GetNSSStudentList;
		GetNSSStudentList = nssApproveServiceInterface.GetNSSStudentList();
		model.addAttribute("GetNSSStudentList", GetNSSStudentList);

		return new ModelAndView("ApproveStudentNSSPage");
	}

	@RequestMapping("RemoveStudentNSS")
	public ModelAndView RemoveStudentNSS(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("Remove/DosApprove Nss Student");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> GetNSSStudentListDisApproved;
			GetNSSStudentListDisApproved = nssApproveServiceInterface.GetNSSStudentListDisApproved();
			model.addAttribute("GetNSSStudentListDisApproved", GetNSSStudentListDisApproved);

			return new ModelAndView("DisApproveNssStudentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "DisApproveNSSStudent", params = "SubmitStudentNSSDis")
	public ModelAndView DisApproveNSSStudent(HttpServletRequest request, Model model) {
		System.out.println("Dis Approve Nss Approved Student");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCountDis"));
		CheckBoxNumbers=CheckBoxNumbers+100000;
		// System.out.println(CheckBoxNumbers);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String CurrentDate = sdf.format(d);
		System.out.println(CurrentDate);

		String BoxValue;
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue = request.getParameter("NSSStudentCount" + i);
			if (BoxValue == null) {
				continue;
			}
			System.out.println(BoxValue);

			nssApproveServiceInterface.updateStudentStatusDisApproved(BoxValue, CurrentDate);
		}

		List<String> GetNSSStudentListDisApproved;
		GetNSSStudentListDisApproved = nssApproveServiceInterface.GetNSSStudentListDisApproved();
		model.addAttribute("GetNSSStudentListDisApproved", GetNSSStudentListDisApproved);

		return new ModelAndView("DisApproveNssStudentPage");
	}

	@RequestMapping("ActiveStudentListNSS")
	public ModelAndView ActiveStudentListNSS(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("List Of Approved Student");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> GetNSSStudentList;
			GetNSSStudentList = nssApproveServiceInterface.GetNSSStudentListApproved();
			model.addAttribute("GetNSSStudentList", GetNSSStudentList);

			return new ModelAndView("ActiveStudentListNSSPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "PrintApproveNSSStudent", params = "ApproveStudentPrint")
	public ModelAndView PrintApproveNSSStudent(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Print Approve Student NSS List");

		/*int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));*/
		// System.out.println(CheckBoxNumbers);
		String filename = "NSSActiveStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		/*String BoxValue;
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue = request.getParameter("NSSStudentCount" + i);
			if (BoxValue == null) {
				continue;
			}
			System.out.println(BoxValue);
			hm.put("NSSID", BoxValue);
			
		}*/
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("deActiveStudentListNSS")
	public ModelAndView deActiveStudentListNSS(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("List of Dis Approved Nss Student");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = nssApproveServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> GetNSSStudentListDisApproved;
			GetNSSStudentListDisApproved = nssApproveServiceInterface.GetNSSStudentDisApprovedList();
			model.addAttribute("GetNSSStudentListDisApproved", GetNSSStudentListDisApproved);

			return new ModelAndView("deActiveStudentListNSSPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "PrintDisApproveNSSStudent", params = "PrintSubmitStudentNSSDis")
	public ModelAndView PrintDisApproveNSSStudent(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Print Dis Appproved Student NSS List");

		String filename = "NSSDeActiveStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCountDis"));
		// System.out.println(CheckBoxNumbers);

		String BoxValue;
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue = request.getParameter("NSSStudentCount" + i);
			if (BoxValue == null) {
				continue;
			}
			System.out.println(BoxValue);

		}*/

		return new ModelAndView("");
	}
}
