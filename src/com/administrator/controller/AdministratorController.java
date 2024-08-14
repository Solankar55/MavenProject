package com.administrator.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.administrator.serviceInterface.AdministratorServiceInterface;
import com.student.model.StudentRegistrationModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class AdministratorController {

	@Autowired
	private AdministratorServiceInterface administratorServiceInterface;

	@RequestMapping("NewAuthorizedUser")
	public ModelAndView NewAuthorizedUser(Model model,
			@ModelAttribute("RegisterUser1") AdminRegistrationModel adminRegistrationModel, HttpServletRequest request,
			HttpSession session, @ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("New Authorised Personal Reg Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = administratorServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);
			model.addAttribute("CurrentDate", curentdate);

			return new ModelAndView("NewAuthorizedUserPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("checkUserData")
	@ResponseBody
	public List<String> checkUserData(String userName)
	{
		System.out.println("checkUserData");
		List<String> checkUserDataList=new ArrayList<>();
		checkUserDataList=administratorServiceInterface.getUserNameCheck(userName);
		System.out.println(checkUserDataList);
		
		return checkUserDataList;
	}
	
	@RequestMapping(value = "RegisterAuthUser", method = RequestMethod.GET)
	public ModelAndView RegisterUser(@ModelAttribute("RegisterUser1") AdminRegistrationModel adminRegistrationModel) {
		System.out.println("Way To Authorised USer Registration Page");
		administratorServiceInterface.RegAuthorisedUser(adminRegistrationModel);
		return new ModelAndView("SuccessAuthPage");
	}

	@RequestMapping("StandardReport")
	public ModelAndView StandardReport(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Print Standard Wise Report");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = administratorServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = administratorServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = administratorServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("AuthorisedStandardReportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "GetBranchListJsonStandard1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = administratorServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandard1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = administratorServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "StudentStandardReport1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardReport(int yearId, int streamid, int branchid, int standardID) {
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList = new ArrayList<>();
		StudentStandardList = administratorServiceInterface.getStandardWiseList(yearId, streamid, branchid, standardID);
		System.out.println(StudentStandardList);

		return StudentStandardList;
	}

	@RequestMapping(value = "GetreportStandard1", method = RequestMethod.POST)
	public ModelAndView GetreportStandard(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws JRException, NamingException, SQLException, IOException {
		System.out.println("Get Student Standard List");

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		// session.setAttribute("StreamID",StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		// session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		// session.setAttribute("StandardID",StandardID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		
		String filename = "StandardWiseStudentReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("YearID", YearID);
		hm.put("streanID", StreanID);
		hm.put("branchID", branchID);
		hm.put("standardID", StandardID);
		hm.put("banner", banner);
		PrintJasperReport.printreport(filename, request, response, hm);

		HashMap<String, String> YearList;
		YearList = administratorServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = administratorServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		return new ModelAndView("AuthorisedStandardReportPage");

	}

	public AdministratorServiceInterface getAdministratorServiceInterface() {
		return administratorServiceInterface;
	}

	public void setAdministratorServiceInterface(AdministratorServiceInterface administratorServiceInterface) {
		this.administratorServiceInterface = administratorServiceInterface;
	}

}
