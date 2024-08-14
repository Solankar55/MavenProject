package com.TAP.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.model.StudentRegistrationTAPModel;
import com.TAP.serviceInterface.StudentLinkServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.util.STCOPSMS;

@Controller
public class StudentLinkController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private StudentLinkServiceInterface studentLinkServiceInterface;

	public StudentLinkServiceInterface getStudentLinkServiceInterface() {
		return studentLinkServiceInterface;
	}

	public void setStudentLinkServiceInterface(StudentLinkServiceInterface studentLinkServiceInterface) {
		this.studentLinkServiceInterface = studentLinkServiceInterface;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("StudentTAPRegistrationForm")
	public ModelAndView studentTAPForm(Model model) {
		System.out.println("Student TAP Form");

		int getTAPID = 0;
		getTAPID = studentLinkServiceInterface.getTAPId();
		System.out.println(getTAPID);
		model.addAttribute("TAPID", getTAPID);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		model.addAttribute("curentdate", curentdate);
		System.out.println(curentdate);

		return new ModelAndView("StudentTAPRegFormPage");
	}

	@RequestMapping("SaveApplicationFormTAP")
	public ModelAndView SaveApplicationFormTAP(HttpServletRequest request) {
		System.out.println("SaveApplicationFormTAP");

		String StudentFullName = request.getParameter("StudentFullName");
		System.out.println(StudentFullName);
		String StudentAddress = request.getParameter("StudentAddress");
		System.out.println(StudentAddress);
		String StudentContactNumber = request.getParameter("StudentContactNumber");
		System.out.println(StudentContactNumber);
		String StudentGender = request.getParameter("StudentGender");
		System.out.println(StudentGender);
		String StudentDOB = request.getParameter("StudentDOB");
		System.out.println(StudentDOB);
		String StudentEmail = request.getParameter("StudentEmail");
		System.out.println(StudentEmail);
		String StudentCategory = request.getParameter("StudentCategory");
		System.out.println(StudentCategory);
		String StudentCast = request.getParameter("StudentCast");
		System.out.println(StudentCast);
		String StudentQualification = request.getParameter("StudentQualification");
		System.out.println(StudentQualification);
		String StudentAreaOfJob = request.getParameter("StudentAreaOfJob");
		System.out.println(StudentAreaOfJob);
		String StudentApplicationDate = request.getParameter("StudentApplicationDate");
		System.out.println(StudentApplicationDate);
		String StudentApplicationPlace = request.getParameter("StudentApplicationPlace");
		System.out.println(StudentApplicationPlace);

		StudentRegistrationTAPModel studentRegistrationTAPModel = new StudentRegistrationTAPModel();
		studentRegistrationTAPModel.setStudentFullName(StudentFullName);
		studentRegistrationTAPModel.setStudentAddress(StudentAddress);
		studentRegistrationTAPModel.setStudentContactNumber(StudentContactNumber);
		studentRegistrationTAPModel.setStudentGender(StudentGender);
		studentRegistrationTAPModel.setStudentDOB(StudentDOB);
		studentRegistrationTAPModel.setStudentEmail(StudentEmail);
		studentRegistrationTAPModel.setStudentCategory(StudentCategory);
		studentRegistrationTAPModel.setStudentCast(StudentCast);
		studentRegistrationTAPModel.setStudentQualification(StudentQualification);
		studentRegistrationTAPModel.setStudentAreaOfJob(StudentAreaOfJob);
		studentRegistrationTAPModel.setStudentApplicationDate(StudentApplicationDate);
		studentRegistrationTAPModel.setStudentApplicationPlace(StudentApplicationPlace);

		studentLinkServiceInterface.saveStudentRegistrationTAPDetails(studentRegistrationTAPModel);

		return new ModelAndView("ThanksPageTAPPage");
	}

	@RequestMapping("SendLinkToStudentTAP")
	public ModelAndView SendLinkToStudentTAP(Model model,HttpServletRequest request,HttpSession session) {
		System.out.println("SendLinkToStudentTAP");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentLinkServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			HashMap<String, String> YearList;
			YearList = studentLinkServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentLinkServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("SendLinkToStudentTAPPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonCTAP")
	@ResponseBody
	public List<String> GetBranchListJsonTAP(int id) {
		List<String> GetBranchList = new ArrayList<>();
		GetBranchList = studentLinkServiceInterface.getBranchList(id);
		return GetBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONTAP")
	@ResponseBody
	public List<String> GetStandardListJSONTAP(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = studentLinkServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping(value = "StudentListTAP")
	@ResponseBody
	public List<String> StudentListTAP(int yearId, int streamid, int branchid, int standardID) {
		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = studentLinkServiceInterface.getStudentDetailsForAdmission(yearId, streamid, branchid,
				standardID);
		return getStudentDetails;
	}

	@RequestMapping(value = "SendTAPMessageToStudent", params = "SendTAPMessage")
	public ModelAndView SendTAPMessageToStudent(HttpServletRequest request) {
		System.out.println("SendTAPMessageToStudent");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers=CheckBoxNumbers+100000;
		// System.out.println(CheckBoxNumbers);
		List<StudentAdmissionModel> studentEmailIDs;
		String messageToStudent = request.getParameter("MessageForStudent");
		System.out.println(messageToStudent);
		String BoxValue1;
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue1 = request.getParameter("StudID" + i);
			if (BoxValue1 == null) {
				continue;
			}
			System.out.println(BoxValue1);

			int BoxValue = Integer.parseInt(BoxValue1);

			studentEmailIDs = studentLinkServiceInterface.getStudentMail(BoxValue);
			final String EmailID = studentEmailIDs.get(0).getStudentEmail();
			System.out.println(EmailID);
			String Name = studentEmailIDs.get(0).getStudentFirstName();
			String LName = studentEmailIDs.get(0).getStudentLastName();

			final String Subject = "Traning And Placement Link ";
			System.out.println("Subject" + Subject);
			final String Message = "Hi " + Name + " " + LName + " " + messageToStudent
					+ " Please Feel the Form http://202.38.172.146/CMS/StudentTAPRegistrationForm.html Training And Placement Registration Form ";
			System.out.println("Message " + Message);
			System.out.println("Sender Mail " + EmailID);

			mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					messageHelper.setTo(EmailID);
					messageHelper.setSubject(Subject);
					messageHelper.setText(Message);
				}
			});
		}

		return new ModelAndView("TaPHomePage");
	}
	
	@RequestMapping(value = "SendTAPMessageToStudent", params = "SendSMS")
	public ModelAndView SendTAPMessageToStudentSMS(HttpServletRequest request,Model model) {
		System.out.println("SendTAPMessageToStudent");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers=CheckBoxNumbers+100000;
		// System.out.println(CheckBoxNumbers);
		List<StudentAdmissionModel> studentEmailIDs;
		String messageToStudent = request.getParameter("MessageForStudent");
		System.out.println(messageToStudent);
		String BoxValue1;
		
		STCOPSMS stcopsms=new STCOPSMS();
		
		for (int i = 0; i <= CheckBoxNumbers; i++) {
			BoxValue1 = request.getParameter("StudID" + i);
			if (BoxValue1 == null) {
				continue;
			}
			System.out.println(BoxValue1);

			int BoxValue = Integer.parseInt(BoxValue1);

			studentEmailIDs = studentLinkServiceInterface.getStudentMail(BoxValue);
			final String EmailID = studentEmailIDs.get(0).getStudentEmail();
			System.out.println(EmailID);
			String Name = studentEmailIDs.get(0).getStudentFirstName();
			String LName = studentEmailIDs.get(0).getStudentLastName();
			String studentContactNumber=studentEmailIDs.get(0).getStudentContactNumber();
			

			final String Subject = "Traning And Placement Link ";
			System.out.println("Subject" + Subject);
			final String Message = "Hi " + Name + " " + LName + " " + messageToStudent;
					
			System.out.println("Message " + Message);

			try {
				stcopsms.sendSMS(studentContactNumber, Message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		model.addAttribute("StudentMSG","Student Has Get Message Succesfully...");
		return new ModelAndView("TaPHomePage");
	}
}
