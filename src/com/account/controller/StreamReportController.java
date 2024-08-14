package com.account.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.account.serviceInterface.StandardReportServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class StreamReportController {

	@Autowired
	private StandardReportServiceInterface standardReportServiceInterface;

	@RequestMapping("Report")
	public ModelAndView ScienceReport(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Standard Report Page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap<String, String> YearList;
			YearList = standardReportServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = standardReportServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("StandardReportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonStandard", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = standardReportServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandard", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = standardReportServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "StudentStandardReport", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardReport(int yearId, int streamid, int branchid, int standardID) {
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList = new ArrayList<>();
		StudentStandardList = standardReportServiceInterface.getStandardWiseList(yearId, streamid, branchid,
				standardID);
		System.out.println(StudentStandardList);

		return StudentStandardList;
	}

	@RequestMapping(value = "GetreportStandard", method = RequestMethod.POST)
	public ModelAndView GetreportStandard(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws JRException, NamingException, SQLException, IOException {
		System.out.println("Get Student Standard List");

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		// session.setAttribute("StreamID",StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		// session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		// session.setAttribute("StandardID",StandardID);

		// CollegeManagementSystem/WebContent/images/report/Capturenew.jpg
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "StandardWiseStudentReportNew";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("YearID", YearID);
		hm.put("streanID", StreanID);
		hm.put("branchID", branchID);
		hm.put("standardID", StandardID);
		hm.put("banner", banner);
		PrintJasperReport.printreport(filename, request, response, hm);

		HashMap<String, String> YearList;
		YearList = standardReportServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = standardReportServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		return new ModelAndView("StandardReportPage");

	}

	@RequestMapping("RefundAmountDetail")
	public ModelAndView RefundAmountDetail(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("RefundAmountDetail");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			List<String> refundAmtDetailList = new ArrayList<>();
			refundAmtDetailList = standardReportServiceInterface.getRefundAmtDetailList();
			model.addAttribute("refundAmtDetailList", refundAmtDetailList);

			return new ModelAndView("RefundAmountDetailPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "printRefundAmountDetailReport", params = "printReport")
	public ModelAndView printRefundAmountDetail(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("printRefundAmountDetailReport");

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "RefundAmountDetailReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("studentPendingFeeReport")
	public ModelAndView studentPendingFeeReport(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("studentPendingFeeReport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap<String, String> YearList;
			YearList = standardReportServiceInterface.getYearListFee();
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = standardReportServiceInterface.getStreamListFee();
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("studentPendingFeeReportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("GetBranchListJsonFee")
	@ResponseBody
	List<String> GetBranchListJsonFee(int id) {
		System.out.println("GetBranchListJsonFee");

		List<String> branchList;
		branchList = standardReportServiceInterface.getBranchListFee(id);
		return branchList;

	}

	@RequestMapping("GetStandardListJSONFee")
	@ResponseBody
	List<String> GetStandardListJSONFee(int branchid) {
		System.out.println("GetStandardListJSONFee");

		List<String> standardList;
		standardList = standardReportServiceInterface.getStandardListFee(branchid);
		return standardList;

	}

	@RequestMapping("StudentPendingFeeRpt")
	@ResponseBody
	public List<String> getStudPendingFee(int yearId, int streamid, int branchid, int standardID)

	{
		System.out.println("StudentPendingFeeRpt JSON called");
		List<String> pendingFeeData = new ArrayList<>();
		pendingFeeData = standardReportServiceInterface.getPendingFee(yearId, streamid, branchid, standardID);
		System.out.println("pendingFeeData" + pendingFeeData);
		return pendingFeeData;

	}

	@RequestMapping(value = "GetreportStudentPendingFees", params = "getFeeReport")
	public ModelAndView GetreportStudentPendingFees(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("GetreportStudentPendingFees");

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		// session.setAttribute("StreamID",StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		// session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		// session.setAttribute("StandardID",StandardID);

		// CollegeManagementSystem/WebContent/images/report/Capturenew.jpg
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Student Pending Fees Report";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("yearID", YearID);
		hm.put("streamID", StreanID);
		hm.put("branchID", branchID);
		hm.put("standardID", StandardID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");

	}

	@RequestMapping("StudentCompleteFeeReport")
	public ModelAndView StudentCompleteFeeReport(Model model, HttpSession session, HttpServletRequest request) {
		System.out.println("StudentCompleteFeeReport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap<String, String> YearList;
			YearList = standardReportServiceInterface.getYearListFee();
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = standardReportServiceInterface.getStreamListFee();
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("StudentCompleteFeeReportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("StudentCompletedFeeRpt")
	@ResponseBody
	public List<String> getStudCompleteFee(int yearId, int streamid, int branchid, int standardID)

	{
		System.out.println("StudentCompletedFeeRpt JSON called");
		List<String> pendingFeeData = new ArrayList<>();
		pendingFeeData = standardReportServiceInterface.getCompletedFee(yearId, streamid, branchid, standardID);
		System.out.println("StudentCompletedFeeRpt" + pendingFeeData);
		return pendingFeeData;

	}

	@RequestMapping(value = "GetreportStudentCompletedFees", params = "getFeeReport")
	public ModelAndView GetreportStudentCompletedFees(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("GetreportStudentPendingFees");

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		// session.setAttribute("StreamID",StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		// session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		// session.setAttribute("StandardID",StandardID);

		// CollegeManagementSystem/WebContent/images/report/Capturenew.jpg
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "StudentCompleted FeeReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("yearID", YearID);
		hm.put("streamID", StreanID);
		hm.put("branchID", branchID);
		hm.put("standardID", StandardID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");

	}

	@RequestMapping("StudentListYearWiseA")
	public ModelAndView StudentListYearWiseA(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("StudentListYearWiseA");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap<String, String> YearList;
			YearList = standardReportServiceInterface.getYearListFee();
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = standardReportServiceInterface.getStreamListFee();
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("StudentListYearWiseAPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "studentReportYearWisePrint", params = "getStudentReport")
	public ModelAndView studentReportYearWisePrint(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("studentReportYearWisePrint");

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		// session.setAttribute("StreamID",StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		// session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		// session.setAttribute("StandardID",StandardID);

		// CollegeManagementSystem/WebContent/images/report/Capturenew.jpg
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "YearwiseStudentList(CastandGender)";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("acadamicYearId", YearID);
		hm.put("streamId", StreanID);
		hm.put("branchId", branchID);
		hm.put("standardId", StandardID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping(value = "StudentTransactionReport")
	public ModelAndView StudentTransactionReport(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("StudentTransactionReport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = standardReportServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("StudentTransactionReportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "getStudentTransaction")
	@ResponseBody
	public List<String> getStudentTransaction(String studentName) {
		System.out.println("getStudentTransaction");
		List<String> studentTrasaction = new ArrayList<>();
		studentTrasaction = standardReportServiceInterface.getStudentTransactionReport(studentName);
		System.out.println("student Transaction" + studentTrasaction);

		return studentTrasaction;
	}

	@RequestMapping(value = "getStudentTransactionReport", params = "downloadStdentTransaction")
	public ModelAndView downloadStdentTransaction(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		System.out.println("downloadStdentTransaction");

		String studentName=request.getParameter("StudentName");
		System.out.println(studentName);
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		System.out.println(studentId);

		/*String acYear = request.getParameter("AcadimicYear");
		System.out.println(acYear);

		String standardName = request.getParameter("standardName");
		System.out.println(standardName);

		String streamName = request.getParameter("streamName");
		System.out.println(streamName);

		String branchName = request.getParameter("branchName");
		System.out.println(branchName);*/
		// CollegeManagementSystem/WebContent/images/report/Capturenew.jpg
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "studentTransactionReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("studentName",studentName);
		hm.put("studentId",studentId);
	/*	hm.put("acadamicYear", acYear);
		hm.put("streamName", streamName);
		hm.put("standardName", standardName);
		hm.put("branchName", branchName);*/
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	public StandardReportServiceInterface getStandardReportServiceInterface() {
		return standardReportServiceInterface;
	}

	public void setStandardReportServiceInterface(StandardReportServiceInterface standardReportServiceInterface) {
		this.standardReportServiceInterface = standardReportServiceInterface;
	}

}
