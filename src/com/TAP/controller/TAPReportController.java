package com.TAP.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import com.TAP.serviceInterface.TAPReportServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class TAPReportController {

	@Autowired
	private TAPReportServiceInterface tapReportServiceInterface;

	public TAPReportServiceInterface getTapReportServiceInterface() {
		return tapReportServiceInterface;
	}

	public void setTapReportServiceInterface(TAPReportServiceInterface tapReportServiceInterface) {
		this.tapReportServiceInterface = tapReportServiceInterface;
	}

	@RequestMapping("ViewStudentRecordTAP")
	public ModelAndView ViewStudentRecordTAP(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("ViewStudentRecordTAP");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = tapReportServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> getStudentTAP;
			getStudentTAP = tapReportServiceInterface.getStudentTapDetails();
			System.out.println(getStudentTAP);
			model.addAttribute("StudentTAP", getStudentTAP);

			return new ModelAndView("ViewStudentRecordTAPPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value="PrintTranindAndPlacmentStudentList",params="PrintTAPReport")
	public ModelAndView PrintTranindAndPlacmentStudentList(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("PrintTranindAndPlacmentStudentList");
		
		String filename = "TAPStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView();
	}
}
