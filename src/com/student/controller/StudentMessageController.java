package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.StudentMessageServiceInterface;

@Controller
public class StudentMessageController {

	@Autowired
	private StudentMessageServiceInterface studentMessageServiceInterface;

	public StudentMessageServiceInterface getStudentMessageServiceInterface() {
		return studentMessageServiceInterface;
	}

	public void setStudentMessageServiceInterface(StudentMessageServiceInterface studentMessageServiceInterface) {
		this.studentMessageServiceInterface = studentMessageServiceInterface;
	}

	@RequestMapping("StudentAssignmentShow")
	public ModelAndView StudentAssignmentShow(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("StudentAssignmentShow");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> CheckStudentRequest = new ArrayList<>();
		CheckStudentRequest = studentMessageServiceInterface.CheckStudent(username);
		try {

			String StudName = CheckStudentRequest.get(0).getStudentName();
			System.out.println(StudName);
			String StudContact = CheckStudentRequest.get(0).getStudentContactNumber();
			System.out.println(StudContact);
			String StudEmail = CheckStudentRequest.get(0).getStudentEmail();
			System.out.println(StudEmail);

			List<Object[]> StudCheckDetails = new ArrayList<>();
			StudCheckDetails = studentMessageServiceInterface.getStudDetailsToCheckPresentOrNot(StudName, StudContact,
					StudEmail);
			System.out.println(StudCheckDetails);
			Integer StudID = 0;
			String StudStatus = null;
			Integer StudYear = 0;
			Integer StudBranch = 0;
			Integer StudStandard = 0;
			Integer StudStream = 0;
			for (Object[] obj : StudCheckDetails) {
				StudID = (Integer) obj[0];
				StudStatus = (String) obj[1];
				StudYear = (Integer) obj[2];
				StudBranch = (Integer) obj[3];
				StudStandard = (Integer) obj[4];
				StudStream = (Integer) obj[5];
			}

			List<String> assignmentDetails;
			assignmentDetails = studentMessageServiceInterface.getAssignmentDetails(StudID, StudStatus, StudYear,
					StudBranch, StudStandard, StudStream);
			System.out.println(assignmentDetails);

			if (assignmentDetails.size() == 0) {
				model.addAttribute("MessageToNotice", "You Have Not Any Assignment Yet...");
				session = request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = studentMessageServiceInterface.GetStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			} else {
				model.addAttribute("assignmentDetails", assignmentDetails);
				return new ModelAndView("StudentAssignmentShowPage");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("NoticeShow")
	public ModelAndView NoticeShow(HttpServletRequest request, HttpSession session, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Notice Show To Student");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> CheckStudentRequest = new ArrayList<>();
		CheckStudentRequest = studentMessageServiceInterface.CheckStudent(username);
		try {

			String StudName = CheckStudentRequest.get(0).getStudentName();
			System.out.println(StudName);
			String StudContact = CheckStudentRequest.get(0).getStudentContactNumber();
			System.out.println(StudContact);
			String StudEmail = CheckStudentRequest.get(0).getStudentEmail();
			System.out.println(StudEmail);

			List<Object[]> StudCheckDetails = new ArrayList<>();
			StudCheckDetails = studentMessageServiceInterface.getStudDetailsToCheckPresentOrNot(StudName, StudContact,
					StudEmail);
			System.out.println(StudCheckDetails);
			Integer StudID = 0;
			String StudStatus = null;
			Integer StudYear = 0;
			Integer StudBranch = 0;
			Integer StudStandard = 0;
			Integer StudStream = 0;
			for (Object[] obj : StudCheckDetails) {
				StudID = (Integer) obj[0];
				StudStatus = (String) obj[1];
				StudYear = (Integer) obj[2];
				StudBranch = (Integer) obj[3];
				StudStandard = (Integer) obj[4];
				StudStream = (Integer) obj[5];
			}

			List<String> NoticeDetails;
			NoticeDetails = studentMessageServiceInterface.getNoticeDetails(StudID, StudStatus, StudYear, StudBranch,
					StudStandard, StudStream);
			System.out.println(NoticeDetails);

			if (NoticeDetails.size() == 0) {
				model.addAttribute("MessageToNotice", "You Have Not Any Notice Yet...");
				session = request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = studentMessageServiceInterface.GetStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			} else {
				model.addAttribute("StudentNotice", NoticeDetails);
				return new ModelAndView("NoticeShowPage");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("AttendenceNoticeShow")
	public ModelAndView AttendenceNoticeShow(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Attendence Notice Show To Student");

		session = request.getSession();
		String userName = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> studList;
		studList = studentMessageServiceInterface.getStudInfo(userName);
		try {
			String sName = studList.get(0).getStudentName();
			String sContact = studList.get(0).getStudentContactNumber();
			String sEmail = studList.get(0).getStudentEmail();

			List<Object[]> studDetailList;
			studDetailList = studentMessageServiceInterface.getStudDetailList(sName, sContact, sEmail);
			System.out.println("studDetailList" + studDetailList);

			Integer StudID = 0;
			Integer StudYear = 0;
			Integer StudStream = 0;
			Integer StudStandard = 0;
			Integer StudBranch = 0;
			String StudStatus = null;

			for (Object[] obj : studDetailList) {
				StudID = (Integer) obj[0];
				StudStatus = (String) obj[1];
				StudYear = (Integer) obj[2];
				StudBranch = (Integer) obj[3];
				StudStandard = (Integer) obj[4];
				StudStream = (Integer) obj[5];

			}

			System.out.println("studentID" + StudID);
			System.out.println("academicYearID" + StudYear);
			System.out.println("streamID" + StudStream);
			System.out.println("standardID" + StudStandard);
			System.out.println("branchID" + StudBranch);
			System.out.println("StudStatus" + StudStatus);

			List<String> getAttendenceNoticeDetail;
			getAttendenceNoticeDetail = studentMessageServiceInterface.getAttendenceNoticeDetail(StudID, StudYear,
					StudStatus, StudBranch, StudStandard, StudStream);
			System.out.println(getAttendenceNoticeDetail);

			if (getAttendenceNoticeDetail.size() == 0) {
				model.addAttribute("MessageToNotice", "You Have Not Any Attendence Notice Yet...");
				session = request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = studentMessageServiceInterface.GetStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			} else {
				model.addAttribute("AttendenceNoticeDetail", getAttendenceNoticeDetail);
				return new ModelAndView("AttendenceNoticeShowPage");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("ExamNoticeShow")
	public ModelAndView ExamNoticeShow(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("ExamNoticeShow");
		session = request.getSession();
		String userName = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> studList;
		studList = studentMessageServiceInterface.getStudInfo(userName);
		try {
			String sName = studList.get(0).getStudentName();
			String sContact = studList.get(0).getStudentContactNumber();
			String sEmail = studList.get(0).getStudentEmail();

			List<Object[]> studDetailList;
			studDetailList = studentMessageServiceInterface.getStudDetailList(sName, sContact, sEmail);
			System.out.println("studDetailList" + studDetailList);

			Integer StudID = 0;
			Integer StudYear = 0;
			Integer StudStream = 0;
			Integer StudStandard = 0;
			Integer StudBranch = 0;
			String StudStatus = null;

			for (Object[] obj : studDetailList) {
				StudID = (Integer) obj[0];
				StudStatus = (String) obj[1];
				StudYear = (Integer) obj[2];
				StudBranch = (Integer) obj[3];
				StudStandard = (Integer) obj[4];
				StudStream = (Integer) obj[5];

			}

			System.out.println("studentID" + StudID);
			System.out.println("academicYearID" + StudYear);
			System.out.println("streamID" + StudStream);
			System.out.println("standardID" + StudStandard);
			System.out.println("branchID" + StudBranch);
			System.out.println("StudStatus" + StudStatus);

			List<String> examNoticeList;
			examNoticeList = studentMessageServiceInterface.getExamNoticeList( StudID,  StudStatus,  StudYear,  StudBranch,
					 StudStandard,  StudStream);
			System.out.println(examNoticeList);

			if (examNoticeList.size() == 0) {
				model.addAttribute("MessageToNotice", "You Have Not Any Exam Notice Yet...");
				session = request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = studentMessageServiceInterface.GetStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			} else {

				model.addAttribute("ExamNoticeList", examNoticeList);

				return new ModelAndView("ExamNoticeShowPage");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}
}
