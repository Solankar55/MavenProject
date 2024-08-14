package com.staff.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.StaffRegistrationModel;
import com.staff.serviceInterface.StaffLoginServiceInterface;
import com.staff.serviceInterface.StaffMenuServiceInterface;

@Controller
public class StaffLoginController {

	@Autowired
	private StaffLoginServiceInterface staffLoginServiceInterface;

	@Autowired
	private StaffMenuServiceInterface staffMenuServiceInterface;

	@Autowired
	private JavaMailSender mailSender;

	public StaffLoginServiceInterface getStaffLoginServiceInterface() {
		return staffLoginServiceInterface;
	}

	public void setStaffLoginServiceInterface(StaffLoginServiceInterface staffLoginServiceInterface) {
		this.staffLoginServiceInterface = staffLoginServiceInterface;
	}

	public StaffMenuServiceInterface getStaffMenuServiceInterface() {
		return staffMenuServiceInterface;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setStaffMenuServiceInterface(StaffMenuServiceInterface staffMenuServiceInterface) {
		this.staffMenuServiceInterface = staffMenuServiceInterface;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("StaffLogin")
	public ModelAndView StaffLogin() {
		System.out.println("Open Login Page");
		return new ModelAndView("StaffLoginPage");
	}

	@RequestMapping(value = "StaffLoginController", params = "StaffCheck")
	public ModelAndView StaffLoginCont(HttpServletRequest request, Model model, HttpSession httpSession) {
		System.out.println("Staff Login Controller");

		String UserName = request.getParameter("Username");
		System.out.println(UserName);
		String PassWord = request.getParameter("Password");
		System.out.println(PassWord);

		List<StaffRegistrationModel> GetStafflist;
		GetStafflist = staffLoginServiceInterface.getStaffList(UserName, PassWord);
		System.out.println(GetStafflist);

		try {
			String Us = GetStafflist.get(0).getUserName();
			System.out.println(Us);
			String Ps = GetStafflist.get(0).getPassword();
			System.out.println(Ps);

			if (GetStafflist.size() == 0) {
				model.addAttribute("message", "Please Enter Correct Details...");
				return new ModelAndView("StaffLoginPage");
			} else {

				httpSession = request.getSession();
				httpSession.setAttribute("Username", UserName);

				if (Us.equals(UserName) && Ps.equals(PassWord)) {
					return new ModelAndView("StaffHomePage");
				} else {
					model.addAttribute("message", "Please Enter Correct Details...");
					return new ModelAndView("StaffLoginPage");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("message", "Please Enter Correct Details...");
			return new ModelAndView("StaffLoginPage");
		}

	}

	@RequestMapping("StaffHome")
	public ModelAndView StaffHome(HttpServletRequest request, HttpSession httpSession, Model model) {
		System.out.println("Staff Home Page");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);
			return new ModelAndView("StaffHomePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}
	}

	@RequestMapping("ForgotPasswordForStaffUser")
	public ModelAndView ForgotPasswordForStaffUser() {
		System.out.println("ForgotPasswordForStaffUser");
		return new ModelAndView("OpenStaffForgotPage");
	}

	@RequestMapping(value = "GetStaffPassword", params = "GetStaffPass")
	public ModelAndView GetStaffpassword(HttpServletRequest request, Model model) {
		System.out.println("Get Staff Password Controller");

		final String UserEmail = request.getParameter("EmailAddress");
		System.out.println(UserEmail);

		List<StaffRegistrationModel> getUserEmailDetails;
		getUserEmailDetails = staffLoginServiceInterface.getEmailDetails(UserEmail);
		System.out.println(getUserEmailDetails);

		if (getUserEmailDetails.size() == 0) {
			model.addAttribute("Message",
					"You Enter Wrong Email Address.Please Enter Correct Email Or Register Again With New Email Address!!!");
		} else {
			String UserName = (String) getUserEmailDetails.get(0).getUserName();
			final String Email = (String) getUserEmailDetails.get(0).getStaffEmail();
			String UserPassword = (String) getUserEmailDetails.get(0).getPassword();
			String UserMobileNumber = (String) getUserEmailDetails.get(0).getMobileNumber();

			final String Subject = "Forgot Password ";
			System.out.println("Subject" + Subject);
			final String Message = "Hi " + UserName + " This Is Mail To Inform You Your Password. Your Email is "
					+ UserEmail + " and Your User name IS " + UserName + " So Your Password Of This Infromation is "
					+ UserPassword;
			System.out.println("Message " + Message);
			System.out.println("Sender Mail " + UserEmail);

			mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					messageHelper.setTo(UserEmail);
					messageHelper.setSubject(Subject);
					messageHelper.setText(Message);
				}
			});

			model.addAttribute("Message", "Mail Send Successfully");
		}

		return new ModelAndView("StaffLoginPage");
	}

	@RequestMapping("StaffLogout")
	public ModelAndView StaffLogout(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("Staff Logout");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");

		return new ModelAndView("StaffLoginPage");
	}
}
