package com.Alumini.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Alumini.serviceInterface.AluminiSendLinkToStudentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.util.STCOPSMS;

@Controller
public class AluminiStudentMasterController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private AluminiSendLinkToStudentServiceInterface aluminiSendLinkToStudentServiceInterface;

	public AluminiSendLinkToStudentServiceInterface getAluminiSendLinkToStudentServiceInterface() {
		return aluminiSendLinkToStudentServiceInterface;
	}

	public void setAluminiSendLinkToStudentServiceInterface(
			AluminiSendLinkToStudentServiceInterface aluminiSendLinkToStudentServiceInterface) {
		this.aluminiSendLinkToStudentServiceInterface = aluminiSendLinkToStudentServiceInterface;
	}

	@RequestMapping("SendLinkToStudent")
	public ModelAndView SendLinkToStudent(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("Send Link To Student");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = aluminiSendLinkToStudentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			HashMap<String, String> YearList;
			YearList = aluminiSendLinkToStudentServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = aluminiSendLinkToStudentServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("SendLinkToStudentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonAlumini")
	@ResponseBody
	public List<String> GetBranchListJsonAlumini(int id) {
		List<String> GetBranchList = new ArrayList<>();
		GetBranchList = aluminiSendLinkToStudentServiceInterface.getBranchList(id);
		return GetBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONAlumini")
	@ResponseBody
	public List<String> GetStandardListJSONAlumini(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = aluminiSendLinkToStudentServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping(value = "StudentListAlumini")
	@ResponseBody
	public List<String> StudentListAlumini(int yearId, int streamid, int branchid, int standardID) {
		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = aluminiSendLinkToStudentServiceInterface.getStudentDetailsForAdmission(yearId, streamid,
				branchid, standardID);
		return getStudentDetails;
	}

	@RequestMapping(value = "SendLinkAlumini", params = "SendAluminiMessage")
	public ModelAndView SendLinkAlumini(HttpServletRequest request, Model model) {
		System.out.println("Send Link Alumini");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers = CheckBoxNumbers + 1;

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
			try {
				studentEmailIDs = aluminiSendLinkToStudentServiceInterface.getStudentMail(BoxValue);
				final String EmailID = studentEmailIDs.get(0).getStudentEmail();
				String Name = studentEmailIDs.get(0).getStudentFirstName();
				String LName = studentEmailIDs.get(0).getStudentLastName();

				final String Subject = "Alumini Memorandum";
				System.out.println("Subject" + Subject);
				final String Message = "Hi " + Name + " " + LName + " " + messageToStudent;
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

			} catch (Exception e) {
				model.addAttribute("MessageAlumini", "Student Mail Send SuccessFully...");
				return new ModelAndView("AluminiHomePagePage");
			}
		}
		model.addAttribute("MessageAlumini", "Student Mail Send SuccessFully...");
		return new ModelAndView("AluminiHomePagePage");

	}

	@RequestMapping(value = "SendLinkAlumini", params = "SendSMS")
	public ModelAndView SendLinkAluminiSMS(HttpServletRequest request, Model model) {
		System.out.println("Way To Send SMS to Student");

		int CheckBoxNumbers = Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers = CheckBoxNumbers + 1;
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

			studentEmailIDs = aluminiSendLinkToStudentServiceInterface.getStudentMail(BoxValue);
			String Name = studentEmailIDs.get(0).getStudentFirstName();
			String LName = studentEmailIDs.get(0).getStudentLastName();
			String ContactNumber = studentEmailIDs.get(0).getStudentContactNumber();

			String Subject = "Alumini Memorandum";
			System.out.println("Subject" + Subject);
			String Message = "Hi " + Name + " " + LName + " " + messageToStudent;
			System.out.println("Message " + Message);

			STCOPSMS stcopsms = new STCOPSMS();

			try {
				stcopsms.sendSMS(ContactNumber, Message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("MessageAlumini", "SMS Has been SuccessFully Send...");
		return new ModelAndView("AluminiHomePagePage");
	}

	@RequestMapping("SendSMSToStudent")
	public ModelAndView SendSMSToStudent(HttpSession session, Model model, HttpServletRequest request) {
		System.out.println("SendSMSToStudent");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = aluminiSendLinkToStudentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);
			return new ModelAndView("SendSMSToStudentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "SendSMSAlumini", params = "SendSMS")
	public ModelAndView SendSMSAlumini(HttpServletRequest request, Model model) {
		System.out.println("Send SMS Alumini");

		String StudentContactNumber = request.getParameter("StudentContactNumber");
		System.out.println(StudentContactNumber);

		String MessageForStudent = request.getParameter("MessageForStudent");
		System.out.println(MessageForStudent);

		String Message = MessageForStudent;/* "%20 http://202.38.172.146/CMS/AluminiRegistrationForm.html For Alumini Registration Form " */

		System.out.println("Message " + Message);

		STCOPSMS stcopsms = new STCOPSMS();

		try {
			stcopsms.sendSMS(StudentContactNumber, Message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("StudentMsg", "Student Has Get Message Successfully...");
		return new ModelAndView("SendSMSToStudentPage");
	}
}
