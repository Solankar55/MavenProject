package com.account.controller;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.DuplicateLeavingCertificateModel;
import com.account.model.LedgerFeePaidModel;
import com.account.serviceInterface.DownloadServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class DownloadStudenntReuqestController {

	@Autowired
	private DownloadServiceInterface downloadServiceInterface;

	public DownloadServiceInterface getDownloadServiceInterface() {
		return downloadServiceInterface;
	}

	public void setDownloadServiceInterface(DownloadServiceInterface downloadServiceInterface) {
		this.downloadServiceInterface = downloadServiceInterface;
	}

	@RequestMapping("DownloadStudentBonafide")
	public ModelAndView DownloadStudentBonafide(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("DownloadStudentBonafide");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("DownloadStudentBonafidePage");

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getstudentBonafideDetails")
	@ResponseBody
	public List<String> getstudentBonafideDetails(int registrationID) {
		System.out.println("getstudentBonafideDetails");

		List<String> getStudentData;
		getStudentData = downloadServiceInterface.getStudentDetails(registrationID);
		return getStudentData;
	}

	@RequestMapping(value = "DwonloadStudentBonafideAC", params = "DownloadB")
	public ModelAndView DwonloadStudentBonafideAC(HttpSession session, HttpServletResponse response,
			HttpServletRequest request, Model model) {
		System.out.println("DownLoad");

		int StudID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "NewBonafide";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudID);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		downloadServiceInterface.UpdateBonafideFlag(StudID);

		return new ModelAndView();
	}

	@RequestMapping("DownloadStudentBonafideAnyCondition")
	public ModelAndView DownloadStudentBonafideAnyCondition(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
		System.out.println("DownloadStudentBonafideAnyCondition");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("DownloadStudentBonafideAnyConditionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("getStudentDetailsForBonafideAnyCondition")
	@ResponseBody
	public List<String> getStudentDetailsForBonafideAnyCondition(int studentId) {
		System.out.println("getStudentDetailsForBonafideAnyCondition");
		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = downloadServiceInterface.getStudentDetailsAnyConditionBonafide(studentId);
		return getStudentDetails;

	}

	@RequestMapping(value = "DownloadStudentBonafideACAnyCondition", params = "DownloadBAnyCondition")
	public ModelAndView DownloadStudentBonafideACAnyCondition(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("DownloadStudentBonafideACAnyCondition");

		int studentId = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(studentId);

		List<StudentAdmissionModel> getStatus = new ArrayList<>();
		getStatus = downloadServiceInterface.getStudentStatus(studentId);

		String status = getStatus.get(0).getStatus();
		System.out.println(status);

		if (status.equals("Approved")) {

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);

			StudentBonafideRequestModel studentBonafideRequestModel = new StudentBonafideRequestModel();
			studentBonafideRequestModel.setBonafideDate(curentdate);
			studentBonafideRequestModel.setBonafideFlag(1);

			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studentId);
			studentBonafideRequestModel.setStudentAdmissionModel(studentAdmissionModel);

			downloadServiceInterface.saveStudentBonfideAnycondition(studentBonafideRequestModel);

			ServletContext context = session.getServletContext();
			String banner = context.getRealPath("/images/report/Capturenew.jpg");

			String filename = "NewBonafideAnyCondition";
			HashMap<String, Object> hm = new HashMap<>();
			hm.put("StudentID", studentId);
			hm.put("banner", banner);

			try {
				PrintJasperReport.printreport(filename, request, response, hm);
			} catch (JRException | NamingException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			downloadServiceInterface.UpdateBonafideFlagAnyCondition(studentId);
		} else {
			model.addAttribute("statusOfStudent",
					"Student admission is not approved yet/Student Already take his/her Leaving Certificate");
			return new ModelAndView("DownloadStudentBonafideAnyConditionPage");
		}

		return new ModelAndView("");
	}

	@RequestMapping("DownloadStudentIDCard")
	public ModelAndView DownloadStudentIDCard(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("DownloadStudentIDCard");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("DownloadStudentIDCardPage");

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getstudentIDCardDetails")
	@ResponseBody
	public List<String> getstudentIDCardDetails(int registrationID) {
		System.out.println("getstudentIDCardDetails");

		List<String> studInfo;
		studInfo = downloadServiceInterface.getStudentIDDetails(registrationID);
		return studInfo;
	}

	@RequestMapping(value = "DownloadStudentIDCardAC", params = "DownloadIDCard")
	public ModelAndView DownloadStudentIDCardAC(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		System.out.println("Download ID Card Student ");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudentID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "id";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		downloadServiceInterface.updateIDCardFlag(StudentID);

		return new ModelAndView("");
	}

	@RequestMapping("DownloadStudentIDCardAnyCondition")
	public ModelAndView DownloadStudentIDCardAnyCondition(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
		System.out.println("DownloadStudentIDCardAnyCondition");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("DownloadStudentIDCardAnyConditionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getStudentDetailsForIDAnyConditiion")
	@ResponseBody
	public List<String> getStudentDetailsForIDAnyConditiion(int studentId) {
		System.out.println("getStudentDetailsForIDAnyConditiion");

		List<String> getStudentData = new ArrayList<>();
		getStudentData = downloadServiceInterface.getStudentDataIDAnyCondition(studentId);
		return getStudentData;
	}

	@RequestMapping(value = "DownloadStudentIDCardACAnyCondition", params = "DownloadIDCardAnyCondition")
	public ModelAndView DownloadStudentIDCardACAnyCondition(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
		System.out.println("DownloadStudentIDCardACAnyCondition");

		int studentId = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(studentId);

		List<StudentAdmissionModel> getStatus = new ArrayList<>();
		getStatus = downloadServiceInterface.getStudentStatus(studentId);

		String status = getStatus.get(0).getStatus();
		System.out.println(status);

		if (status.equals("Approved")) {

			StudentIDCardRequestModel studentIDCardRequestModel=new StudentIDCardRequestModel();
			studentIDCardRequestModel.setIDrequestFlag(1);
			
			StudentAdmissionModel studentAdmissionModel=new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studentId);
			studentIDCardRequestModel.setStudentAdmissionModel(studentAdmissionModel);
			
			downloadServiceInterface.saveStudentIdAnyConditionDetails(studentIDCardRequestModel);
			
			ServletContext context = session.getServletContext();
			String banner = context.getRealPath("/images/report/Capturenew.jpg");

			String filename = "idAnyCondition";
			HashMap<String, Object> hm = new HashMap<>();
			hm.put("StudentID", studentId);
			hm.put("banner", banner);
			try {
				PrintJasperReport.printreport(filename, request, response, hm);
			} catch (JRException | NamingException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			downloadServiceInterface.updateIDCardFlag(studentId);
		} else {

			model.addAttribute("statusOfStudent",
					"Student admission is not approved yet/Student Already take his/her Leaving Certificate");
			return new ModelAndView("DowonloadStudentLCAnyConditionPage");
		}
		return new ModelAndView("");
	}

	@RequestMapping("DowonloadStudentLC")
	public ModelAndView DowonloadStudentLC(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("DowonloadStudentLC");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("DowonloadStudentLCPage");

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getstudentLCDetails")
	@ResponseBody
	public List<String> getstudentLCDetails(int registrationID) {
		System.out.println("getstudentLCDetails");

		List<String> getStudentInfo;
		getStudentInfo = downloadServiceInterface.getSTudentLCDetails(registrationID);

		return getStudentInfo;

	}

	@RequestMapping(value = "DownloadLCAC", params = "DownloadCertificate")
	public ModelAndView DownloadLCAC(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println(" Download Leaving Certificate ");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println("StudentID " + StudentID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "LC";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		downloadServiceInterface.updateLeavingCertificateFlag(StudentID);

		return new ModelAndView("");
	}

	@RequestMapping("DowonloadStudentLCDuplicate")
	public ModelAndView DowonloadStudentLCDuplicate(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("DowonloadStudentLCDuplicate");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("DowonloadStudentLCDuplicatePage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getstudentLCDetailsDuplicate")
	@ResponseBody
	public List<String> getstudentLCDetailsDuplicate(int registrationID) {
		System.out.println("getstudentLCDetailsDuplicate");

		List<String> getstudentLCDetailsDuplicateList = new ArrayList<>();
		getstudentLCDetailsDuplicateList = downloadServiceInterface.getStudentDetailsForDuplicateLC(registrationID);
		System.out.println(getstudentLCDetailsDuplicateList);

		return getstudentLCDetailsDuplicateList;
	}

	@RequestMapping(value = "DownloadLCACDuplicate", params = "DownloadDuplicateCertificate")
	public ModelAndView DownloadLCACDuplicate(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DownloadLCACDuplicate");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println("StudentID " + StudentID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "LCDuplicate";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);

		DuplicateLeavingCertificateModel duplicateLeavingCertificateModel = new DuplicateLeavingCertificateModel();

		duplicateLeavingCertificateModel.setLcdate(curentdate);
		duplicateLeavingCertificateModel.setStudentid(StudentID);

		downloadServiceInterface.saveDuplicateLcDetails(duplicateLeavingCertificateModel);

		return new ModelAndView();
	}

	@RequestMapping("DowonloadStudentLCAnyCondition")
	public ModelAndView DowonloadStudentLCAnyCondition(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("DowonloadStudentLCDuplicate");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = downloadServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("DowonloadStudentLCAnyConditionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getStudentDetailsForAnyConditionLC")
	@ResponseBody
	public List<String> getStudentDetailsForAnyConditionLC(String studentName) {
		System.out.println("getStudentDetailsForAnyConditionLC");

		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = downloadServiceInterface.getStudentDetailsAnyConditionLC(studentName);
		System.out.println(getStudentDetails);

		return getStudentDetails;

	}

	@RequestMapping("issueStudentLCAnyCondition")
	public ModelAndView issueStudentLCAnyCondition(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		System.out.println("issueStudentLCAnyCondition");

		int studentId = Integer.parseInt(request.getParameter("studentId"));
		System.out.println("studentId" + studentId);

		List<StudentAdmissionModel> getStatus = new ArrayList<>();
		getStatus = downloadServiceInterface.getStudentStatus(studentId);

		String status = getStatus.get(0).getStatus();
		System.out.println(status);

		if (status.equals("Approved")) {

			List<String> getStudentDetails = new ArrayList<>();
			getStudentDetails = downloadServiceInterface.getStudentDetailsTogetLC(studentId);
			System.out.println(getStudentDetails);

			List<LedgerFeePaidModel> getStudentFeeDetails = new ArrayList<>();
			getStudentFeeDetails = downloadServiceInterface.getStudentDetailsAnyFeeCondition(studentId);
			System.out.println(getStudentFeeDetails);

			// float AlPaidFee=getStudentFeeDetails.get(0).getAlreadyPaidFees();
			// float paidFee=getStudentFeeDetails.get(0).getPaidFees();
			float pendingFee = getStudentFeeDetails.get(0).getPendingFees();
			String feeStatus = getStudentFeeDetails.get(0).getFeeStatus();
			System.out.println("status" + feeStatus);

			if (feeStatus.equals("pending")) {
				model.addAttribute("pendingFee", "Student having Pending fee " + pendingFee + "");
				model.addAttribute("studentInfoLC", getStudentDetails);
				return new ModelAndView("issueStudentLCAnyConditionPage");
			} else if (feeStatus.equals("Completed")) {
				model.addAttribute("pendingFee", "Student Has No Panding Fee");
				model.addAttribute("studentInfoLC", getStudentDetails);
				return new ModelAndView("issueStudentLCAnyConditionPage");
			}
		} else {

			model.addAttribute("statusOfStudent",
					"Student admission is not approved yet/Student Already take his/her Leaving Certificate");
			return new ModelAndView("DowonloadStudentLCAnyConditionPage");
		}
		return new ModelAndView("");
	}

	@RequestMapping("saveAnyConditionLCDetailsAndGetPrint")
	public ModelAndView saveAnyConditionLCDetailsAndGetPrint(HttpServletResponse response, HttpServletRequest request,
			HttpSession session, Model model) {
		System.out.println("saveAnyConditionLCDetailsAndGetPrint");

		int studentId = Integer.parseInt(request.getParameter("StudentId"));
		System.out.println("studentId" + studentId);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String LCDate = sdf.format(d);

		String conduct = request.getParameter("conduct");
		System.out.println(conduct);

		String dateOfLeaving = request.getParameter("dateOfLeaving");
		System.out.println(dateOfLeaving);

		String reasonforLeaving = request.getParameter("reasonforLeaving");
		System.out.println(reasonforLeaving);

		String remark = request.getParameter("remark");
		System.out.println(remark);

		StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel = new StudentLeavingCertificateRequestModel();
		studentLeavingCertificateRequestModel.setLeavingCertificateDate(LCDate);
		studentLeavingCertificateRequestModel.setLeavingCertificateFlag(1);

		StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
		studentAdmissionModel.setAdmissionRegId(studentId);
		studentLeavingCertificateRequestModel.setStudentAdmissionModel(studentAdmissionModel);

		studentLeavingCertificateRequestModel.setConduct(conduct);
		studentLeavingCertificateRequestModel.setDateOfLeaving(dateOfLeaving);
		studentLeavingCertificateRequestModel.setReasonForLeaving(reasonforLeaving);
		studentLeavingCertificateRequestModel.setRemark(remark);

		downloadServiceInterface.saveLeavingCertificate(studentLeavingCertificateRequestModel);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "LC";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", studentId);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		downloadServiceInterface.updateLeavingCertificateFlag(studentId);

		return new ModelAndView("");

	}
}
