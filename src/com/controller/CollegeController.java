package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.admin.service.RegisterUserI;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.service.RegisterStudentI;

@Controller
public class CollegeController {

	@Autowired
	private RegisterUserI registerUserI;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	RegisterStudentI registerStudentI;

	/* Login Page Controller */
	@RequestMapping("FirstPage")
	public ModelAndView FirstPage(
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Login Page");
		return new ModelAndView("LoginPage");
	}

	/* Account Login Page Controller */
	@RequestMapping("AccountLogin")
	public ModelAndView AccountLogin(
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("AccountLogin");
		return new ModelAndView("AccountLoginPage");
	}

	/* Library Login Page Controller */
	@RequestMapping("LibraryLogin")
	public ModelAndView LibraryLogin(
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("LibraryLogin");
		return new ModelAndView("LibraryLoginPage");
	}

	/* Administator Login Page Controller */
	@RequestMapping("PrincipalLogin")
	public ModelAndView PrincipalLogin(
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("PrincipalLogin");
		return new ModelAndView("PrincipalLoginPage");
	}

	/* Hod Login Page Contrller */
	@RequestMapping("HODLogin")
	public ModelAndView HODLogin(@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("HODLogin");
		return new ModelAndView("HODLoginPage");
	}

	/* Admin Login Controller */
	@RequestMapping("AdminLogin")
	public ModelAndView AdminP() {
		System.out.println("Way To Admin Login Page");
		return new ModelAndView("AdminLoginPage");
	}

	@RequestMapping(value = "ViewAdmin", method = RequestMethod.POST)
	public ModelAndView ViewAdmin(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response,
			@ModelAttribute("RegisterUser") AdminRegistrationModel adminRegistrationModel) {
		System.out.println("Way To Admin Home Page");
		String UN = request.getParameter("username");
		System.out.println(UN);
		String PS = request.getParameter("password");
		System.out.println(PS);

		if (UN.equals("Admin") && PS.equals("Admin")) {

			httpSession = request.getSession();
			httpSession.setAttribute("Username", UN);

			return new ModelAndView("ViewAdminHomePage");
		} else {
			return new ModelAndView("ErrorPage");
		}

	}

	@RequestMapping("NewUser")
	public ModelAndView NewUser(Model model,
			@ModelAttribute("RegisterUser") AdminRegistrationModel adminRegistrationModel) {
		System.out.println("Way To Create New User Page");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		model.addAttribute("CurrentDate", curentdate);
		return new ModelAndView("NewUserPage");
	}

	@RequestMapping(value = "RegisterUser", method = RequestMethod.POST)
	public ModelAndView RegisterUser(@ModelAttribute("RegisterUser") AdminRegistrationModel adminRegistrationModel) {
		System.out.println("Way To Admin Registration Page");
		registerUserI.RegUser(adminRegistrationModel);
		return new ModelAndView("SuccessPage");
	}

	@RequestMapping(value = "StudentHome")
	public ModelAndView StudentHome(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {

		System.out.println("Way to Student Home Page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = registerStudentI.GetStudDetails(username);

		List<StudentRegistrationModel> getStudentList;
		getStudentList = registerStudentI.getStudDetailsHome(username);
		System.out.println(getStudentList);

		try {
			String SName = getStudentList.get(0).getStudentName();
			String SMail = getStudentList.get(0).getStudentEmail();
			String SContact = getStudentList.get(0).getStudentContactNumber();

			List<StudentAdmissionModel> StudentDetailsForStatus;
			StudentDetailsForStatus = registerStudentI.getStudentStatus(SName, SMail, SContact);
			System.out.println(StudentDetailsForStatus);

			try {
				String StatusStudent = StudentDetailsForStatus.get(0).getStatus();
				if (StatusStudent.equals("Cancel")) {
					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("HomePageWithStatusHomePage");
				} else {
					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				}
			} catch (Exception e) {
				System.out.println(e);
				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "HomeP", method = RequestMethod.POST)
	public ModelAndView HomeP(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String UN = request.getParameter("username");
		System.out.println(UN);
		String PS = request.getParameter("password");
		System.out.println(PS);
		System.out.println("Way To Home Page");

		List<String> StudentList = new ArrayList<>();
		StudentList = registerStudentI.GetStudentDetails(UN, PS);

		List<Object[]> AdminList = new ArrayList<>();
		AdminList = registerUserI.GetAdminList(UN, PS);
		System.out.println(AdminList);

		try {

			List<StudentRegistrationModel> getStudentList;
			getStudentList = registerStudentI.getStudDetails(UN, PS);
			System.out.println(getStudentList);

			String SName = getStudentList.get(0).getStudentName();
			String SMail = getStudentList.get(0).getStudentEmail();
			String SContact = getStudentList.get(0).getStudentContactNumber();

			if (StudentList.size() > 0) {
				System.out.println("User Present In Database");

				httpSession = request.getSession();
				httpSession.setAttribute("Username", UN);

				List<StudentAdmissionModel> StudentDetailsForStatus;
				StudentDetailsForStatus = registerStudentI.getStudentStatus(SName, SMail, SContact);
				System.out.println(StudentDetailsForStatus);

				String StatusStudent = StudentDetailsForStatus.get(0).getStatus();

				if (StatusStudent.equals("Cancel")) {
					model.addAttribute("StudentList", StudentList);
					return new ModelAndView("HomePageWithStatusPage");
				} else {
					model.addAttribute("StudentList", StudentList);
					return new ModelAndView("HomePage");
				}
				// return StudentList;
			} else if (AdminList.size() > 0) {
				System.out.println("User type is present");
				httpSession = request.getSession();
				httpSession.setAttribute("Username", UN);

				String userType = null;
				for (Object[] objects : AdminList) {

					System.out.println(objects[7]);
					userType = (String) objects[7];
				}

				if (userType.equals("Accountant")) {
					System.out.println("User Type is accountant");
					model.addAttribute("AccountList", AdminList);
					return new ModelAndView("AccHome");
				} else if (userType.equals("Administrator")) {
					System.out.println("User type is aministrator");
					/// model.addAttribute("AdminstratorList",AdminList);
					return new ModelAndView("AdministratorHome");
				} else if (userType.equals("HOD")) {
					System.out.println("User Type Is HOD");
					return new ModelAndView("HODHome");
				} else if (userType.equals("Librarian")) {
					System.out.println("User Type Is Librarian");
					return new ModelAndView("LibHome");
				} else {

				}
			} else {
				return new ModelAndView("ErrorPageForUser");
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			if (StudentList.size() > 0) {
				System.out.println("User Present In Database");

				httpSession = request.getSession();
				httpSession.setAttribute("Username", UN);

				/*
				 * String
				 * StatusStudent=StudentDetailsForStatus.get(0).getStatus();
				 *
				 *
				 * if(StatusStudent.equals("Cancel")) {
				 * model.addAttribute("StudentList",StudentList); return new
				 * ModelAndView("HomePageWithStatusPage"); }else {
				 */ model.addAttribute("StudentList", StudentList);
				 return new ModelAndView("HomePage");
				 /* } */
				 // return StudentList;
			} else if (AdminList.size() > 0) {
				System.out.println("User type is present");
				httpSession = request.getSession();
				httpSession.setAttribute("Username", UN);

				String userType = null;
				for (Object[] objects : AdminList) {

					System.out.println(objects[7]);
					userType = (String) objects[7];
				}

				if (userType.equals("Accountant")) {
					System.out.println("User Type is accountant");
					model.addAttribute("AccountList", AdminList);
					return new ModelAndView("AccHome");
				} else if (userType.equals("Administrator")) {
					System.out.println("User type is aministrator");
					/// model.addAttribute("AdminstratorList",AdminList);
					return new ModelAndView("AdministratorHome");
				} else if (userType.equals("HOD")) {
					System.out.println("User Type Is HOD");
					return new ModelAndView("HODHome");
				} else if (userType.equals("Librarian")) {
					System.out.println("User Type Is Librarian");
					return new ModelAndView("LibHome");
				} else {

				}
			} else {
				return new ModelAndView("ErrorPageForUser");
			}
			return null;
		}

		/*
		 * if (StudentList.size() > 0) { System.out.println(
		 * "User Present In Database");
		 *
		 * httpSession=request.getSession();
		 * httpSession.setAttribute("Username", UN);
		 *
		 * String StatusStudent=StudentDetailsForStatus.get(0).getStatus();
		 *
		 *
		 * if(StatusStudent.equals("Cancel")) {
		 * model.addAttribute("StudentList",StudentList); return new
		 * ModelAndView("HomePageWithStatusPage"); }else {
		 * model.addAttribute("StudentList",StudentList); return new
		 * ModelAndView("HomePage"); } // return StudentList; } else if
		 * (AdminList.size() > 0) { System.out.println("User type is present");
		 * httpSession=request.getSession();
		 * httpSession.setAttribute("Username", UN);
		 *
		 * String userType=null; for (Object[] objects : AdminList) {
		 *
		 * System.out.println(objects[7]); userType=(String)objects[7]; }
		 *
		 * if (userType.equals("Accountant")) { System.out.println(
		 * "User Type is accountant");
		 * model.addAttribute("AccountList",AdminList); return new
		 * ModelAndView("AccHome"); } else if (userType.equals("Administrator"))
		 * { System.out.println("User type is aministrator"); ///
		 * model.addAttribute("AdminstratorList",AdminList); return new
		 * ModelAndView("AdministratorHome"); }else if(userType.equals("HOD")){
		 * System.out.println("User Type Is HOD"); return new
		 * ModelAndView("HODHome"); } else { //return new
		 * ModelAndView("LoginPage"); } } else { return new
		 * ModelAndView("ErrorPageForUser"); } return null;
		 */
	}

	@RequestMapping(value = "sendEMail", method = RequestMethod.POST)
	public ModelAndView sendEMail(HttpServletRequest request, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Send Mail");

		final String SendTo = request.getParameter("emailTo");
		System.out.println(SendTo);

		List<StudentRegistrationModel> StudEmailNeedInfo = new ArrayList<>();
		StudEmailNeedInfo = registerUserI.getEmailRelatedDetails(SendTo);
		System.out.println(StudEmailNeedInfo);

		if (StudEmailNeedInfo.size() == 0) {
			model.addAttribute("Message",
					"You Enter Wrong Email Address.Please Enter Correct Email Or Register Again With New Email Address!!!");
		} else {
			String UserName = StudEmailNeedInfo.get(0).getStudentUserName();
			String StudentName = StudEmailNeedInfo.get(0).getStudentName();
			String StudentEmail = StudEmailNeedInfo.get(0).getStudentEmail();
			String StudentPassword = StudEmailNeedInfo.get(0).getStudentPassword();

			final String Subject = "Forgot Password ";
			System.out.println("Subject" + Subject);
			final String Message = "Hi " + StudentName + " This Is Mail To Inform You Your Password. Your Email is "
					+ StudentEmail + " and Your User name IS " + UserName + " So Your Password Of This Infromation is "
					+ StudentPassword;
			System.out.println("Message " + Message);
			System.out.println("Sender Mail " + SendTo);

			mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					// TODO Auto-generated method stub
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					// message.setFrom("me@mail.com");
					message.setTo(SendTo);
					message.setSubject(Subject);
					message.setText(Message);

				}
			});

			model.addAttribute("Message", "Mail Send Successfully");
		}

		return new ModelAndView("LoginPage");
	}

	/*
	 * @RequestMapping("profile") public ModelAndView profile() {
	 * System.out.println("Way to Student Profile"); return new
	 * ModelAndView("UserPro");
	 *
	 * }
	 */

	@RequestMapping("LogoutMgnt")
	public ModelAndView LogoutMgnt(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Logout");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");
		return new ModelAndView("LoginPage");
	}

	@RequestMapping("AdminLogout")
	public ModelAndView AdminLogout(Model model, HttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response) {
		System.out.println("Way To Logout");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");

		httpSession.invalidate();
		model.addAttribute("message", "You are Successfully Logout Succefully Admin Bhau...Login Again");
		return new ModelAndView("AdminLoginPage");
	}

	@RequestMapping("AccountantLogout")
	public ModelAndView AccountantLogout(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Logout");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");
		return new ModelAndView("AccountLoginPage");
	}

	@RequestMapping("AdministratorLogout")
	public ModelAndView AdministratorLogout(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Logout");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");
		return new ModelAndView("PrincipalLoginPage");
	}

	@RequestMapping("HODLogout")
	public ModelAndView HODLogout(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Logout");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");
		return new ModelAndView("HODLoginPage");
	}

	@RequestMapping("LibraryLogout")
	public ModelAndView LibraryLogout(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Logout");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		session.invalidate();
		model.addAttribute("message", "You are Successfully Logout...Login Again");
		return new ModelAndView("LibraryLoginPage");
	}

	public RegisterUserI getRegisterUserI() {
		return registerUserI;
	}

	public void setRegisterUserI(RegisterUserI registerUserI) {
		this.registerUserI = registerUserI;
	}

	public RegisterStudentI getRegisterStudentI() {
		return registerStudentI;
	}

	public void setRegisterStudentI(RegisterStudentI registerStudentI) {
		this.registerStudentI = registerStudentI;
	}

}
