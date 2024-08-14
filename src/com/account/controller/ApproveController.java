package com.account.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.LedgerFeePaidModel;
import com.account.serviceInterface.ApproveBonafideServiceInterface;
import com.account.serviceInterface.ApproveLeavingServiceInterface;
import com.account.serviceInterface.ApproveStudentIDCardServiceInterface;
import com.account.serviceInterface.FeePaymentServiceInterface;
import com.account.serviceInterface.StudentAddmissionMasterinterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

@Controller
public class ApproveController {

	@Autowired
	private FeePaymentServiceInterface feePaymentServiceInterface;

	@Autowired
	StudentAddmissionMasterinterface studentAddmissionMasterInterface;

	@Autowired
	private ApproveStudentIDCardServiceInterface approveStudentIDCardServiceInterface;

	@Autowired
	private ApproveBonafideServiceInterface approveBonafideServiceInterface;

	@Autowired
	private ApproveLeavingServiceInterface approveLeavingServiceInterface;

	@RequestMapping("AccountHome")
	public ModelAndView AccountHome(HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel, Model model) {
		System.out.println("AccountHome");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("AccHome");

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("ApproveAdmission")
	public ModelAndView ApproveAdmission(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("StudentRequestForAddmission") StudentAdmissionModel studentAdmissionModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Student Approve Addmission");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			List<String> StudentList = new ArrayList<>();
			StudentList = studentAddmissionMasterInterface.GetStudentAddmissionList();
			System.out.println(StudentList);
			if (StudentList.size() == 0) {
				model.addAttribute("NoRequest", "Student Request Is Not Present Yet...");
				return new ModelAndView("AccHome");
			} else {
				model.addAttribute("StudentAddmissionList", StudentList);
				return new ModelAndView("ApproveAdmissionPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("GetStudentListJSONAccount")
	@ResponseBody
	public List<String> GetStudentListJSONAccount(String StudentName) {
		System.out.println("Get Student List JSON Account");
		List<String> StudentList;
		StudentList = studentAddmissionMasterInterface.getStudentList(StudentName);
		System.out.println(StudentName);
		return StudentList;
	}

	@RequestMapping(value = "TakeAddmission", method = RequestMethod.GET)
	public ModelAndView TakeAddmission(HttpServletRequest request, Model model,
			@ModelAttribute("TakeAddmission") StudentAdmissionModel studentAdmissionModel) {
		System.out.println("way to take addmission");
		int StudentID = Integer.parseInt(request.getParameter("admissionId"));
		System.out.println("Student ID ");

		studentAddmissionMasterInterface.TakeAddmission(StudentID);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		model.addAttribute("currentdate", curentdate);
		System.out.println(curentdate);
		/* model.addAttribute("academic", str1); */

		HashMap<String, String> BankList;
		BankList = feePaymentServiceInterface.GetBankList();
		System.out.println(BankList);
		model.addAttribute("BankList", BankList);

		int ReceiptNumber = 0;
		ReceiptNumber = feePaymentServiceInterface.getReceiptNumber();
		System.out.println(ReceiptNumber);
		model.addAttribute("ReceiptNumber", ReceiptNumber);

		model.addAttribute("StudentID",StudentID);
		return new ModelAndView("PayMakePaymentPage");
	}

	@RequestMapping(value = "CancelStudAddmission", method = RequestMethod.GET)
	public ModelAndView CancelStudAddmission(HttpServletRequest request, Model model,
			@ModelAttribute("CancelStudAddmission") StudentAdmissionModel studentAdmissionModel) {
		System.out.println("Way to Cancel Student Addmission");
		int StudentID = Integer.parseInt(request.getParameter("admissionId1"));
		System.out.println(StudentID);

		studentAddmissionMasterInterface.CancelAdmission(StudentID);

		List<String> StudentList = new ArrayList<>();
		StudentList = studentAddmissionMasterInterface.GetStudentAddmissionList();
		System.out.println(StudentList);

		model.addAttribute("StudentAddmissionList", StudentList);

		return new ModelAndView("ApproveAdmissionPage");
	}

	@RequestMapping("ApproveIDCard")
	public ModelAndView ApproveIDCard(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approve ID Card");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> StudIDRequestInfo = new ArrayList<>();
			StudIDRequestInfo = approveStudentIDCardServiceInterface.GetRequestListIDCard();
			model.addAttribute("StudIDRequestInfo", StudIDRequestInfo);

			if (StudIDRequestInfo.size() == 0) {
				model.addAttribute("NoRequest", "Student Request Is Not Present Yet...");
				return new ModelAndView("AccHome");
			} else {
				System.out.println(StudIDRequestInfo);
				return new ModelAndView("ApproveIDCardPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "TakeID", method = RequestMethod.POST)
	public ModelAndView TakeID(Model model, HttpServletRequest request,
			@ModelAttribute("") StudentIDCardRequestModel studentIDCardRequestModel) {
		System.out.println("Way To Complete ID Card Request");

		int studID = Integer.parseInt(request.getParameter("admissionId"));
		System.out.println(studID);

		approveStudentIDCardServiceInterface.TakeIDCardRequest(studID);

		List<String> StudIDRequestInfo = new ArrayList<>();
		StudIDRequestInfo = approveStudentIDCardServiceInterface.GetRequestListIDCard();
		model.addAttribute("StudIDRequestInfo", StudIDRequestInfo);
		System.out.println(StudIDRequestInfo);

		return new ModelAndView("ApproveIDCardPage");
	}

	@RequestMapping(value = "IDCardCancel", method = RequestMethod.POST)
	public ModelAndView cancelIDCard(Model model, HttpServletRequest request,
			@ModelAttribute("") StudentIDCardRequestModel studentIDCardRequestModel) {
		System.out.println("Way to Cancel Student ID card Request");

		int studID = Integer.parseInt(request.getParameter("admissionId1"));
		System.out.println(studID);

		approveStudentIDCardServiceInterface.cancelIDCrard(studID);

		List<String> StudIDRequestInfo = new ArrayList<>();
		StudIDRequestInfo = approveStudentIDCardServiceInterface.GetRequestListIDCard();
		model.addAttribute("StudIDRequestInfo", StudIDRequestInfo);
		System.out.println(StudIDRequestInfo);

		return new ModelAndView("ApproveIDCardPage");
	}

	@RequestMapping("ApproveBonafide")
	public ModelAndView ApproveBonafide(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approve Bonafied");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> StudBonafideRequestInfo = new ArrayList<>();
			StudBonafideRequestInfo = approveBonafideServiceInterface.GetRequestBonafide();
			model.addAttribute("StudBonafideRequestInfo", StudBonafideRequestInfo);

			if (StudBonafideRequestInfo.size() == 0) {
				model.addAttribute("NoRequest", "Student Request Is Not Present Yet...");
				return new ModelAndView("AccHome");
			} else {
				System.out.println(StudBonafideRequestInfo);
				return new ModelAndView("ApproveBonafidePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "TakeBonafide", method = RequestMethod.POST)
	public ModelAndView TakeBonafide(Model model, HttpServletRequest request,
			@ModelAttribute() StudentBonafideRequestModel studentBonafideRequestModel) {
		System.out.println("Way to Take Bonafide");

		int studID = Integer.parseInt(request.getParameter("admissionId"));
		System.out.println(studID);

		approveBonafideServiceInterface.TakeBonafideRequest(studID);

		List<String> StudBonafideRequestInfo = new ArrayList<>();
		StudBonafideRequestInfo = approveBonafideServiceInterface.GetRequestBonafide();
		model.addAttribute("StudBonafideRequestInfo", StudBonafideRequestInfo);
		System.out.println(StudBonafideRequestInfo);

		return new ModelAndView("ApproveBonafidePage");
	}

	@RequestMapping(value = "BonafideCancel", method = RequestMethod.POST)
	public ModelAndView BonafideCancel(Model model, HttpServletRequest request,
			@ModelAttribute() StudentBonafideRequestModel studentBonafideRequestModel) {
		System.out.println("Way to cancel Bonafide");

		int studID = Integer.parseInt(request.getParameter("admissionId1"));
		System.out.println(studID);

		approveBonafideServiceInterface.cancelBonafide(studID);

		List<String> StudBonafideRequestInfo = new ArrayList<>();
		StudBonafideRequestInfo = approveBonafideServiceInterface.GetRequestBonafide();
		model.addAttribute("StudBonafideRequestInfo", StudBonafideRequestInfo);
		System.out.println(StudBonafideRequestInfo);

		return new ModelAndView("ApproveBonafidePage");
	}

	@RequestMapping("ApproveLeavingCertificate")
	public ModelAndView ApproveLeavingCertificate(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approve Leaving Certificate");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> StudLeavingRequestInfo = new ArrayList<>();
			StudLeavingRequestInfo = approveLeavingServiceInterface.GetRequestLeaving();
			model.addAttribute("StudLeavingRequestInfo", StudLeavingRequestInfo);

			if (StudLeavingRequestInfo.size() == 0) {
				model.addAttribute("NoRequest", "Student Request Is Not Present Yet...");
				return new ModelAndView("AccHome");
			} else {
				System.out.println(StudLeavingRequestInfo);
				return new ModelAndView("ApproveLeavingCertificatePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "TakeLeavingCertificate", method = RequestMethod.POST)
	public ModelAndView TakeLeavingCertificate(Model model, HttpServletRequest request,
			@ModelAttribute() StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		System.out.println("Way to Take Leaving Certificate");

		int studID = Integer.parseInt(request.getParameter("admissionId"));
		System.out.println(studID);

		int yearID1=Integer.parseInt(request.getParameter("yearID1"));
		System.out.println(yearID1);
		
		int standardID1=Integer.parseInt(request.getParameter("standardID1"));
		System.out.println(standardID1);
		
		int streamID1=Integer.parseInt(request.getParameter("streamID1"));
		System.out.println(streamID1);
		
		int branchID1=Integer.parseInt(request.getParameter("branchID1"));
		System.out.println(branchID1);
		
		String studentName=request.getParameter("studentName");
		System.out.println(studentName);
		
		String studentGender=request.getParameter("studentGender");
		System.out.println(studentGender);
		
		String studentDateofBirth=request.getParameter("dateOfBirth");
		System.out.println(studentDateofBirth);
		
		String studentAdmissionYear=request.getParameter("academicYear");
		System.out.println(studentAdmissionYear);
		
		String studentStream=request.getParameter("studentStream");
		System.out.println(studentStream);
		
		String studentStandard=request.getParameter("studentStandard");
		System.out.println(studentStandard);
		
		
		List<LedgerFeePaidModel> FeeList;
		FeeList=approveLeavingServiceInterface.getStudentPendingFee(yearID1,standardID1,streamID1,branchID1,studID);
		System.out.println(FeeList);
		
		float PendingFee=FeeList.get(0).getPendingFees();
		System.out.println(PendingFee);
		
		if(PendingFee>0){
			
			model.addAttribute("LCMSG","Student Has Pending Fees Rupess "+PendingFee+" You Can't Approved This Request.");
			
			List<String> StudLeavingRequestInfo = new ArrayList<>();
			StudLeavingRequestInfo = approveLeavingServiceInterface.GetRequestLeaving();
			model.addAttribute("StudLeavingRequestInfo", StudLeavingRequestInfo);
			System.out.println(StudLeavingRequestInfo);

			return new ModelAndView("ApproveLeavingCertificatePage");
			
		}else {
		
			model.addAttribute("StudentId",studID);
			model.addAttribute("studentName",studentName);
			model.addAttribute("studentGender",studentGender);
			model.addAttribute("studentDOB",studentDateofBirth);
			model.addAttribute("studentYear",studentAdmissionYear);
			model.addAttribute("studentStream",studentStream);
			model.addAttribute("studentStandard",studentStandard);
			
			/*model.addAttribute("",);*/
			
			//approveLeavingServiceInterface.TakeLeavingRequest(studID);
			
			//approveLeavingServiceInterface.updateStudentStatus(studID);
			
			/*List<String> StudLeavingRequestInfo = new ArrayList<>();
			StudLeavingRequestInfo = approveLeavingServiceInterface.GetRequestLeaving();
			model.addAttribute("StudLeavingRequestInfo", StudLeavingRequestInfo);
			System.out.println(StudLeavingRequestInfo);*/

			return new ModelAndView("FeeLeavingCertifivateInformationPage");
		}
	}

	@RequestMapping(value="appeoveLeavingCertificateofStudent",params="ApproveLC")
	public ModelAndView appeoveLeavingCertificateofStudent(HttpServletRequest request,Model model)
	{
		System.out.println("appeoveLeavingCertificateofStudent");
		
		int studID = Integer.parseInt(request.getParameter("StudentId"));
		System.out.println(studID);
		
		String conduct=request.getParameter("conduct");
		System.out.println(conduct);
		
		String dateOfLeaving=request.getParameter("dateOfLeaving");
		System.out.println(dateOfLeaving);
		
		String reasonOfLeaving=request.getParameter("reasonforLeaving");
		System.out.println(reasonOfLeaving);
		
		String remark=request.getParameter("remark");
		System.out.println(remark);
		
		approveLeavingServiceInterface.TakeLeavingRequest(studID,conduct,dateOfLeaving,reasonOfLeaving,remark);
		
		approveLeavingServiceInterface.updateStudentStatus(studID,conduct,dateOfLeaving,reasonOfLeaving,remark);
		
		model.addAttribute("approvMessage","Your request has been approved,For downloading leaving certificate go to download section.");
		
		List<String> StudLeavingRequestInfo = new ArrayList<>();
		StudLeavingRequestInfo = approveLeavingServiceInterface.GetRequestLeaving();
		model.addAttribute("StudLeavingRequestInfo", StudLeavingRequestInfo);
		System.out.println(StudLeavingRequestInfo);

		return new ModelAndView("ApproveLeavingCertificatePage");
	}
	
	@RequestMapping(value = "LCCancel", method = RequestMethod.POST)
	public ModelAndView LCCancel(Model model, HttpServletRequest request,
			@ModelAttribute() StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		System.out.println("Way to cancel Leaving Certificate");

		int studID = Integer.parseInt(request.getParameter("admissionId1"));
		System.out.println(studID);

		approveLeavingServiceInterface.cancelLeaving(studID);

		List<String> StudLeavingRequestInfo = new ArrayList<>();
		StudLeavingRequestInfo = approveLeavingServiceInterface.GetRequestLeaving();
		model.addAttribute("StudLeavingRequestInfo", StudLeavingRequestInfo);
		System.out.println(StudLeavingRequestInfo);

		return new ModelAndView("ApproveLeavingCertificatePage");
	}

	public StudentAddmissionMasterinterface getStudentAddmissionMasterInterface() {
		return studentAddmissionMasterInterface;
	}

	public void setStudentAddmissionMasterInterface(StudentAddmissionMasterinterface studentAddmissionMasterInterface) {
		this.studentAddmissionMasterInterface = studentAddmissionMasterInterface;
	}

	public ApproveStudentIDCardServiceInterface getApproveStudentIDCardServiceInterface() {
		return approveStudentIDCardServiceInterface;
	}

	public void setApproveStudentIDCardServiceInterface(
			ApproveStudentIDCardServiceInterface approveStudentIDCardServiceInterface) {
		this.approveStudentIDCardServiceInterface = approveStudentIDCardServiceInterface;
	}

	public ApproveBonafideServiceInterface getApproveBonafideServiceInterface() {
		return approveBonafideServiceInterface;
	}

	public void setApproveBonafideServiceInterface(ApproveBonafideServiceInterface approveBonafideServiceInterface) {
		this.approveBonafideServiceInterface = approveBonafideServiceInterface;
	}

	public ApproveLeavingServiceInterface getApproveLeavingServiceInterface() {
		return approveLeavingServiceInterface;
	}

	public void setApproveLeavingServiceInterface(ApproveLeavingServiceInterface approveLeavingServiceInterface) {
		this.approveLeavingServiceInterface = approveLeavingServiceInterface;
	}

	public FeePaymentServiceInterface getFeePaymentServiceInterface() {
		return feePaymentServiceInterface;
	}

	public void setFeePaymentServiceInterface(FeePaymentServiceInterface feePaymentServiceInterface) {
		this.feePaymentServiceInterface = feePaymentServiceInterface;
	}
}
