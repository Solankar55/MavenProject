package com.HOD.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.HOD.serviceInterface.UserInformationHODServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class UserInformationHODController {
	
	@Autowired
	private UserInformationHODServiceInterface userInformationHODServiceInterface;

	@RequestMapping("TeachingStaffLoginDetails")
	public ModelAndView userInfo(Model model)
	{
		System.out.println("userInfoPage");
		
		List<String> TeachingStaffRegistrationInfoL = new ArrayList<>();
		TeachingStaffRegistrationInfoL = userInformationHODServiceInterface.getTeachingStaffRegistrationInfo();
		System.out.println("TeachingStaffRegistrationInfoL controller :" +TeachingStaffRegistrationInfoL);
		model.addAttribute("TeachingStaffRegistrationInfo", TeachingStaffRegistrationInfoL);

		return new ModelAndView("userInformationPage");
	}
	
	@RequestMapping("TeachingStaffRegistrationInfoPrintP")
	public ModelAndView UserInfoPage(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("on click of Print of student issue-returned");

		String filename = "TeachingStaffRegistrationInfoPrint";
		

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner",banner);
	
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}
	
	

	@RequestMapping("Non-TeachingStaffLoginDetails")
	public ModelAndView userInfo1(Model model)
	{
		System.out.println("NTuserInfoPage");
		
		List<String> NonTeachingStaffRegistrationInfoL = new ArrayList<>();
		NonTeachingStaffRegistrationInfoL = userInformationHODServiceInterface.getNonTeachingStaffRegistrationInfo();
		System.out.println("TeachingStaffRegistrationInfoL controller :" +NonTeachingStaffRegistrationInfoL);
		model.addAttribute("NonTeachingStaffRegistrationInfo", NonTeachingStaffRegistrationInfoL);

		return new ModelAndView("userNTInformationPage");
	}
	
	@RequestMapping("NonTeachingStaffRegistrationInfoPrintP")
	public ModelAndView UserNTInfoPage(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("on click of Print of student issue-returned");

		String filename = "Non-TeachingStaffRegistrationPrint";
		

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner",banner);
	
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}
	public UserInformationHODServiceInterface getUserInformationHODServiceInterface() {
		return userInformationHODServiceInterface;
	}
	public void setUserInformationHODServiceInterface(
			UserInformationHODServiceInterface userInformationHODServiceInterface) {
		this.userInformationHODServiceInterface = userInformationHODServiceInterface;
	}



}
