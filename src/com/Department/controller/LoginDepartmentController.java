package com.Department.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

import com.Department.serviceInterface.DepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Controller
public class LoginDepartmentController {

	@Autowired
	private DepartmentServiceInterface departmentServiceInterface;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("DepartmentLogin")
	public ModelAndView DepartmentLogin() {
		System.out.println("Way to Open Department Login Page");
		return new ModelAndView("DepartmentLoginPage");
	}

	@RequestMapping(value = "GetDepartmentLoginCheck", params = "DepartmentCheck")
	public ModelAndView GetDepartmentLoginCheck(HttpServletRequest request, HttpSession httpSession,Model model) {
		System.out.println("Check User Is Persent or Not");

		String DepartmentName = request.getParameter("DepartmentName");
		System.out.println(DepartmentName);

		String Username = request.getParameter("Username");
		System.out.println(Username);

		String Password = request.getParameter("Password");
		System.out.println(Password);

		List<String> LoginData = new ArrayList<>();

		ArrayList data = new ArrayList<>();
		LoginData = departmentServiceInterface.checkStaff(Password, Username, DepartmentName);

		if(LoginData.size()==0)
		{
			model.addAttribute("message","Please Enter Correct UserName And Password To Enjoy Service!!!");
			return new ModelAndView("DepartmentLoginPage");
		}
		else
		{
			Iterator itr = LoginData.iterator();
			while (itr.hasNext()) {
				List Al = (List) itr.next();

				System.out.println("Al" + Al);

				Iterator itr1 = Al.iterator();
				while (itr1.hasNext()) {
					String object = itr1.next().toString();
					System.out.println("object" + object);
					data.add(object);
				}
			}

			String DepartmentStatus = data.get(4).toString();
			String Department = data.get(3).toString();
			// int staffRegistrationId = (int) data.get(0);
			String UserNamedb = data.get(2).toString();
			String userPassword = data.get(1).toString();

			httpSession = request.getSession();
			httpSession.setAttribute("Username", Username);

			if (UserNamedb.equals(Username) && userPassword.equals(Password)) {
				if (Department.equals("NSS")) {
					return new ModelAndView("NSSHome");
				} else if (Department.equals("Academic")) {
					return new ModelAndView("AcademicHome");
				} else if (Department.equals("Exam")) {
					return new ModelAndView("ExamHome");
				} else if (Department.equals("Training And Placement")) {
					return new ModelAndView("TaPHomePage");
				} else if (Department.equals("Alumni")) {
					return new ModelAndView("AlumniHome");
				} else if (Department.equals("Cultural")) {
					return new ModelAndView("CulturalHome");
				} else {
					return new ModelAndView("DepartmentLoginPage");
				}

			}
		}
		
		return new ModelAndView("DepartmentHome");
	}

	@RequestMapping("ForgotPasswordForDepartmentUser")
	public ModelAndView ForgotPasswordForDepartmentUser() {
		System.out.println("Open forgot password page");

		return new ModelAndView("OpenDeparmentForgotPage");
	}

	@RequestMapping(value = "GetDepartmentPassword")
	public ModelAndView GetDepartmentPassword(HttpServletRequest request,Model model) {
		System.out.println("Get Password");

		final String EmailAddress = request.getParameter("EmailAddress");
		System.out.println(EmailAddress);

		List<StaffRegistrationModel> getUserEmailDetails;
		getUserEmailDetails=departmentServiceInterface.getEmailDetails(EmailAddress);
		System.out.println(getUserEmailDetails);
		
		if(getUserEmailDetails.size()==0)
		{
			model.addAttribute("Message","You Enter Wrong Email Address.Please Enter Correct Email Or Register Again With New Email Address!!!");
		}
		else
		{
			String UserName=(String)getUserEmailDetails.get(0).getUserName();
			final String UserEmail=(String)getUserEmailDetails.get(0).getStaffEmail();
			String UserPassword=(String)getUserEmailDetails.get(0).getPassword();
			String UserMobileNumber=(String)getUserEmailDetails.get(0).getMobileNumber();
			
			final String Subject="Forgot Password ";
			System.out.println("Subject"+Subject);
			final String Message="Hi "+ UserName +" This Is Mail To Inform You Your Password. Your Email is "+ UserEmail +" and Your User name IS "+ UserName +" So Your Password Of This Infromation is "+ UserPassword;
			System.out.println("Message "+Message);
			System.out.println("Sender Mail "+EmailAddress);
		
			mailSender.send(new MimeMessagePreparator() {
			 
	            @Override
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper messageHelper = new MimeMessageHelper(
	                        mimeMessage, true, "UTF-8");
	                messageHelper.setTo(EmailAddress);
	                messageHelper.setSubject(Subject);
	                messageHelper.setText(Message);
	            }
			});
		
		model.addAttribute("Message","Mail Send Successfully");
		}
		
		return new ModelAndView("DepartmentLoginPage");
	}

	@RequestMapping("DepartmentLogout")
	public ModelAndView DepartmentLogout(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("way to logout Department User");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");

		return new ModelAndView("DepartmentLoginPage");
	}

	public DepartmentServiceInterface getDepartmentServiceInterface() {
		return departmentServiceInterface;
	}

	public void setDepartmentServiceInterface(DepartmentServiceInterface departmentServiceInterface) {
		this.departmentServiceInterface = departmentServiceInterface;
	}
}
