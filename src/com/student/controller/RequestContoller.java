package com.student.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.qrcode.decoder.Mode;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.IDCardServiceInterface;
import com.student.serviceInterface.LeavingCertificateInterface;
import com.student.serviceInterface.StudentBonafideRequestInterface;

@Controller
public class RequestContoller {

	@Autowired
	private StudentBonafideRequestInterface studentBonafideRequestInterface;

	@Autowired
	private LeavingCertificateInterface leavingCertificateInterface;

	@Autowired
	private IDCardServiceInterface iDCardServiceInterface;

	@RequestMapping("StudBonafide")
	public ModelAndView StudBonafide(Model model,
			@ModelAttribute("RequestBonafide") StudentBonafideRequestModel studentBonafideRequestModel,
			HttpSession session, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Student Bonafide Page");

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		model.addAttribute("curentdate", curentdate);

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = studentBonafideRequestInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);

			List<String> StudentDetailInfo = new ArrayList<>();
			StudentDetailInfo = studentBonafideRequestInterface.GetDetailInfo(studName, studCon, StudEmail);
			model.addAttribute("StudentDetailInfo", StudentDetailInfo);
			try {
			List<StudentAdmissionModel> CheckStudRequest = new ArrayList<>();
			CheckStudRequest = studentBonafideRequestInterface.getRequestStudInfo(studName, studCon, StudEmail);
			System.out.println("dgesdg"+CheckStudRequest);
			int StudID = 0;
			
				if (StudentDetailInfo.size() == 0) {
					model.addAttribute("MessageOfRequest",
							"You Are Not Reuqest For Addmission Or Your Request Is Not Approve Of Addmission...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = studentBonafideRequestInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");

				} else {
					StudID = CheckStudRequest.get(0).getAdmissionRegId();
					System.out.println(StudID);
					int BonafideCount = 0;
					BonafideCount = studentBonafideRequestInterface.GetBonafideCount(StudID);
					System.out.println(BonafideCount);
					if (BonafideCount >100) {
						return new ModelAndView("ExcideBonafideRequestPage");
					} else {
						return new ModelAndView("StudBonafidePage");
					}
				}
			} catch (Exception e) {
				System.out.println(e);

				return new ModelAndView("StudBonafidePage");

			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "RequestForBonafide", method = RequestMethod.POST)
	public ModelAndView RequestForBonafide(Model model, HttpServletRequest request,
			@ModelAttribute("RequestBonafide") StudentBonafideRequestModel studentBonafideRequestModel,
			HttpSession session) {
		System.out.println("Way to Request Bonafide");
		try {
			int studId = Integer.parseInt(request.getParameter("StudentID"));
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studId);
			studentBonafideRequestModel.setStudentAdmissionModel(studentAdmissionModel);

			studentBonafideRequestInterface.SaveRequest(studentBonafideRequestModel);

			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = studentBonafideRequestInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("StudentMessage", "To Get This Facility,Your Admission Must Be Approved..");
			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = studentBonafideRequestInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		}
	}

	@RequestMapping("LeavingCertificate")
	public ModelAndView LeavingCertificate(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("LeavingCertificateRequest") StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Leaving Certificate Page");

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		model.addAttribute("curentdate", curentdate);

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = leavingCertificateInterface.getStudInfo(username);

		int LCNumber = 0;
		LCNumber = leavingCertificateInterface.GetLCNumber();
		System.out.println(LCNumber);
		model.addAttribute("LCNumber", LCNumber);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String studEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("Stud Email" + studEmail);

			List<String> GetStudentDetails = new ArrayList<>();
			GetStudentDetails = leavingCertificateInterface.GetStudentDetails(studName, studCon, studEmail);
			model.addAttribute("GetStudentDetails", GetStudentDetails);
			System.out.println(GetStudentDetails);
			try {
			List<StudentAdmissionModel> GetRequestedLeavingCertificateStudID = new ArrayList<>();
			GetRequestedLeavingCertificateStudID = leavingCertificateInterface.getStudID(studName, studCon,
					studEmail);
			System.out.println(GetRequestedLeavingCertificateStudID);
			
				if (GetStudentDetails.size() == 0) {
					model.addAttribute("MessageOfRequest",
							"You Have Not Reuqested For Addmission Or Your Request Is Not Approve Of Addmission...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = studentBonafideRequestInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				} else {
					int StudentRequestID = 0;
					StudentRequestID = GetRequestedLeavingCertificateStudID.get(0).getAdmissionRegId();
					System.out.println(StudentRequestID);

					List<String> CheckItInREquestTable = new ArrayList<>();
					CheckItInREquestTable = leavingCertificateInterface.getCheckIDAvailableOrNot(StudentRequestID);
					System.out.println(CheckItInREquestTable);

					if (CheckItInREquestTable.size() == 0) {

						return new ModelAndView("LeavingCertificatePage");
					} else {
						return new ModelAndView("LeavingCertificateRequestedPage");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);

				return new ModelAndView("LeavingCertificatePage");

			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "LeavingCertificateRequest", method = RequestMethod.POST)
	public ModelAndView LeavingCertificateRequest(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("LeavingCertificateRequest") StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		System.out.println("Way to Request for Leaving Certificate");

		try {
			int StudID = Integer.parseInt(request.getParameter("StudentID"));
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(StudID);
			studentLeavingCertificateRequestModel.setStudentAdmissionModel(studentAdmissionModel);

			leavingCertificateInterface.SaveLeavingCertificateRequest(studentLeavingCertificateRequestModel);

			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = leavingCertificateInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("StudentMessage", "To Get This Facility,Your Admission Must Be Approved..");
			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = studentBonafideRequestInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		}
	}

	@RequestMapping("IDCard")
	public ModelAndView IDCard(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("IDCardRequest") StudentIDCardRequestModel studentIDCardRequestModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to ID Card Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = iDCardServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String studEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudentEmail" + studEmail);

			List<String> StudentDetails = new ArrayList<>();
			StudentDetails = iDCardServiceInterface.getStudDetails(studName, studCon,studEmail);
			model.addAttribute("StudentDetails", StudentDetails);
			System.out.println(StudentDetails);
			try {
			List<StudentAdmissionModel> getStudentID;
			getStudentID = iDCardServiceInterface.getStudentID(studName, studCon, studEmail);
			System.out.println(getStudentID);
			
				if (StudentDetails.size() == 0) {

					model.addAttribute("MessageOfRequest",
							"You Are Not Reuqest For Addmission Or Your Request Is Not Approve Of Addmission...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = studentBonafideRequestInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				} else {
					int studID = 0;
					studID = getStudentID.get(0).getAdmissionRegId();
					System.out.println(studID);

					List<String> checkIDRequest;
					checkIDRequest = iDCardServiceInterface.getIdRequestCheck(studID);
					System.out.println(checkIDRequest);
					/*if (checkIDRequest.size() == 0) {*/
						return new ModelAndView("IDCardPage");
					/*} else {
						return new ModelAndView("IDCardPageRequestedPage");
					}*/
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);

				return new ModelAndView("IDCardPage");

			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "StudentIDCardRequest", method = RequestMethod.POST)
	public ModelAndView StudentIDCardRequest(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("IDCardRequest") StudentIDCardRequestModel studentIDCardRequestModel) {
		System.out.println("Way to IDCard REquest");
		try {
			int studID = Integer.parseInt(request.getParameter("StudentID"));
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studID);
			studentIDCardRequestModel.setStudentAdmissionModel(studentAdmissionModel);

			iDCardServiceInterface.SaveIDCardRequest(studentIDCardRequestModel);

			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = iDCardServiceInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("StudentMessage", "To Get This Facility,Your Admission Must Be Approved..");
			session = request.getSession();
			String username = (String) session.getAttribute("Username");

			List<String> GetStudList = new ArrayList<>();
			GetStudList = studentBonafideRequestInterface.GetStudDetails(username);

			model.addAttribute("GetStudInfo", GetStudList);

			return new ModelAndView("StudentHome");
		}
	}

	public StudentBonafideRequestInterface getStudentBonafideRequestInterface() {
		return studentBonafideRequestInterface;
	}

	public void setStudentBonafideRequestInterface(StudentBonafideRequestInterface studentBonafideRequestInterface) {
		this.studentBonafideRequestInterface = studentBonafideRequestInterface;
	}

	public LeavingCertificateInterface getLeavingCertificateInterface() {
		return leavingCertificateInterface;
	}

	public void setLeavingCertificateInterface(LeavingCertificateInterface leavingCertificateInterface) {
		this.leavingCertificateInterface = leavingCertificateInterface;
	}

	public IDCardServiceInterface getiDCardServiceInterface() {
		return iDCardServiceInterface;
	}

	public void setiDCardServiceInterface(IDCardServiceInterface iDCardServiceInterface) {
		this.iDCardServiceInterface = iDCardServiceInterface;
	}

}
