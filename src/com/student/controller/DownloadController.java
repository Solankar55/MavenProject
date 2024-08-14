package com.student.controller;

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
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.DownloadServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class DownloadController {

	@Autowired
	private DownloadServiceInterface downloadServiceInterface;

	@RequestMapping("DownloadIDCard")
	public ModelAndView DownloadIDCard(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to download ID card");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = downloadServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String studEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("studEmail" + studEmail);

			List<String> StudentDetails = new ArrayList<>();
			StudentDetails = downloadServiceInterface.getStudDetails(studName, studCon);
			model.addAttribute("StudentDetails", StudentDetails);

			List<StudentAdmissionModel> CheckStudRequest = new ArrayList<>();
			CheckStudRequest = downloadServiceInterface.getRequestStudInfo(studName, studCon, studEmail);
			System.out.println(CheckStudRequest);
			int StudID = 0;
			try {
				StudID = CheckStudRequest.get(0).getAdmissionRegId();
				System.out.println(StudID);

				int checkIDFlag = 0;
				checkIDFlag = downloadServiceInterface.checkIDFlag(StudID);
				System.out.println(checkIDFlag);

				if (checkIDFlag == 0) {
					model.addAttribute("MessageOfDownload", "Your Request is Not Approve For ID Card...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = downloadServiceInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				} else if (checkIDFlag == 1) {
					return new ModelAndView("DownLoadIDCardPage");

				} else {
					return new ModelAndView("DownloadAlreadyIDCardPage");
				}
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("RequestIDCardFirstPage");
			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "downloadIDCardStud", params = "DownloadIDCard")
	public ModelAndView downloadIDCardStud(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) throws JRException, NamingException, SQLException, IOException {
		System.out.println("Download ID Card Student ");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudentID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "id";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("banner", banner);
		PrintJasperReport.printreport(filename, request, response, hm);

		downloadServiceInterface.updateIDCardFlag(StudentID);

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = downloadServiceInterface.GetStudDetails(username);

		model.addAttribute("GetStudInfo", GetStudList);

		return new ModelAndView("StudentHome");
	}

	@RequestMapping("DownloadBonafide")
	public ModelAndView DownloadBonafide(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("way to Download bonfide certificate");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = downloadServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);

			List<String> StudentDetailInfo = new ArrayList<>();
			StudentDetailInfo = downloadServiceInterface.GetDetailInfo(studName, studCon);
			model.addAttribute("StudentDetailInfo", StudentDetailInfo);

			List<StudentAdmissionModel> CheckStudRequest = new ArrayList<>();
			CheckStudRequest = downloadServiceInterface.getRequestStudInfo(studName, studCon, StudEmail);
			System.out.println(CheckStudRequest);
			int StudID = 0;
			try {
				StudID = CheckStudRequest.get(0).getAdmissionRegId();
				System.out.println(StudID);

				int CheckFlag = 0;
				CheckFlag = downloadServiceInterface.getStudFlag(StudID);
				System.out.println(CheckFlag);
				if (CheckFlag == 0) {
					model.addAttribute("MessageOfDownload", "Your Request is Not Approve For Bonafide...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = downloadServiceInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				} else if (CheckFlag == 1) {
					int DownladCount = 0;
					DownladCount = downloadServiceInterface.getDownLoadValue(StudID);
					System.out.println(DownladCount);
					if (DownladCount < 2) {
						return new ModelAndView("DownLoadBonafidePage");
					} else {
						return new ModelAndView("DownloadAlreadyBonafidePage");
					}
				} else {
					return new ModelAndView("DownloadAlreadyBonafidePage");
				}

			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("RequestBonafideFirstPage");

			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "DownLoadBonafideStud", params = "DownloadB")
	public ModelAndView DownLoadBonafideStud(HttpSession session, HttpServletResponse response,
			HttpServletRequest request, Model model) throws JRException, NamingException, SQLException, IOException {
		System.out.println("DownLoad");

		int StudID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudID);
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "NewBonafide";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudID);
		hm.put("banner", banner);
		
		PrintJasperReport.printreport(filename, request, response, hm);

		downloadServiceInterface.UpdateBonafideFlag(StudID);

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = downloadServiceInterface.GetStudDetails(username);

		model.addAttribute("GetStudInfo", GetStudList);

		return new ModelAndView("StudentHome");
	}

	@RequestMapping("DownloadLeavingCertificate")
	public ModelAndView DownloadLeavingCertificate(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Download Leaving Certificate");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = downloadServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);

			List<String> GetStudentDetails = new ArrayList<>();
			GetStudentDetails = downloadServiceInterface.GetStudentDetails(studName, studCon);
			model.addAttribute("GetStudentDetails", GetStudentDetails);
			System.out.println(GetStudentDetails);

			List<StudentAdmissionModel> CheckStudRequest = new ArrayList<>();
			CheckStudRequest = downloadServiceInterface.getRequestStudInfo(studName, studCon, StudEmail);
			System.out.println(CheckStudRequest);
			int StudID = 0;
			try {
				StudID = CheckStudRequest.get(0).getAdmissionRegId();
				System.out.println(StudID);

				int checkLeavingCertificateFlag = 0;
				checkLeavingCertificateFlag = downloadServiceInterface.checkLeavingCertificateFlag(StudID);
				System.out.println(checkLeavingCertificateFlag);
				if (checkLeavingCertificateFlag == 0) {
					model.addAttribute("MessageOfDownload", "Your Request is Not Approve For Leaving Certificate...");
					session = request.getSession();
					String username1 = (String) session.getAttribute("Username");

					List<String> GetStudList = new ArrayList<>();
					GetStudList = downloadServiceInterface.GetStudDetails(username1);

					model.addAttribute("GetStudInfo", GetStudList);
					return new ModelAndView("StudentHome");
				} else if (checkLeavingCertificateFlag == 1) {
					return new ModelAndView("DownLoadLeavingCertificatePage");
				} else {
					return new ModelAndView("DownloadAlreadyLeavingCertificatePage");
				}
			} catch (Exception e) {
				System.out.println(e);
				return new ModelAndView("RequestLeavingFirstPage");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "downloadLeavingCertificateStud", params = "DownloadCertificate")
	public ModelAndView downloadLeavingCertificateStud(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws JRException, NamingException, SQLException, IOException {
		System.out.println(" Download Leaving Certificate ");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudentID);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "LC";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("banner", banner);
		
		PrintJasperReport.printreport(filename, request, response, hm);

		downloadServiceInterface.updateLeavingCertificateFlag(StudentID);

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = downloadServiceInterface.GetStudDetails(username);

		model.addAttribute("GetStudInfo", GetStudList);

		return new ModelAndView("StudentHome");
	}

	public DownloadServiceInterface getDownloadServiceInterface() {
		return downloadServiceInterface;
	}

	public void setDownloadServiceInterface(DownloadServiceInterface downloadServiceInterface) {
		this.downloadServiceInterface = downloadServiceInterface;
	}

}
