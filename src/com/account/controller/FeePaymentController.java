package com.account.controller;

import java.io.File;
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
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BankMasterModel;
import com.account.model.BranchMasterModel;
import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.TransactionDetailsModel;
import com.account.model.acadamicYearModel;
import com.account.model.discountModel;
import com.account.serviceInterface.AccountantNextYearStudentAdmissionServiceInterface;
import com.account.serviceInterface.AccountantStudentNewAdmissionServiceInterface;
import com.account.serviceInterface.FeePaymentServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentRegistrationModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;
import resource.EnglishNumberToWords;

@Controller
public class FeePaymentController {

	@Autowired
	private FeePaymentServiceInterface feePaymentServiceInterface;

	@Autowired
	private LedgerFeePaidModel ledgerFeePaidModel;

	@Autowired
	private TransactionDetailsModel transactionDetailsModel;

	@Autowired
	private discountModel DiscountModel;

	@Autowired
	private AccountantStudentNewAdmissionServiceInterface accountantStudentNewAdmissionServiceInterface;

	@Autowired
	private AccountantNextYearStudentAdmissionServiceInterface accountantNextYearStudentAdmissionServiceInterface;

	private List<String> FetchDetailInfo = new ArrayList<>();

	@RequestMapping("AccountantStudentNewAdmission")
	public ModelAndView AccountantStudentNewAdmission(Model model,
			@ModelAttribute("StudentAdmissionAccountant") StudentAdmissionModel studentAdmissionModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to take Admission Page Via Accountant");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int admissionID = 0;
			admissionID = accountantStudentNewAdmissionServiceInterface.getStudentID();
			System.out.println(admissionID);
			model.addAttribute("StudentID", admissionID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);
			model.addAttribute("curentdate", curentdate);

			HashMap<String, String> YearList;
			YearList = accountantStudentNewAdmissionServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> streamList;
			streamList = accountantStudentNewAdmissionServiceInterface.SetStream();
			System.out.println(streamList);
			model.addAttribute("StreamList", streamList);

			return new ModelAndView("AccountantTakeStudentAdmissionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("spliteStudName")
	@ResponseBody
	public List<String> splitName(String studNameScc) {
		List<String> studname = new ArrayList<>();
		String surname = null;
		String fathername = null;
		String myname = null;

		String[] arr = studNameScc.split(" ");

		surname = arr[0];
		System.out.println("surname" + surname);

		myname = arr[1];
		System.out.println("myname" + myname);

		fathername = arr[2];
		System.out.println("fathername" + fathername);

		studname.add(surname);
		studname.add(myname);
		studname.add(fathername);

		return studname;
	}

	@RequestMapping(value = "GetStreamUsingJsonA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStreamUsingJsonA(int id) {
		List<String> getBranchList = new ArrayList<>();
		getBranchList = accountantStudentNewAdmissionServiceInterface.getBranchList(id);
		return getBranchList;
	}

	@RequestMapping(value = "GetStandardUsingJsonA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardUsingJsonA(int id) {
		List<String> GetStandardList = new ArrayList<>();
		GetStandardList = accountantStudentNewAdmissionServiceInterface.getStandardList(id);
		return GetStandardList;
	}

	@RequestMapping(value = "TakeStudentAdmiossionByAccountant", params = "TakeAddmission")
	public ModelAndView TakeStudentAdmiossionByAccountant(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("StudentAdmissionAccountant") StudentAdmissionModel studentAdmissionModel)
			throws IOException {
		System.out.println("Student Admission By Accountant");

		String StudentID = request.getParameter("admissionRegId");
		// StudentID=StudentID+1;
		System.out.println("StudentID" + StudentID);

		int yearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println("Year" + yearID);
		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearID);
		studentAdmissionModel.setAcadamicYearModel(acadamicYearModel);

		studentAdmissionModel.setOriginalAcademicYearID(yearID);

		int streamId = Integer.parseInt(request.getParameter("streamId"));
		System.out.println("Stream" + streamId);
		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		studentAdmissionModel.setStreamMasterModel(streamMasterModel);

		int branchId = Integer.parseInt(request.getParameter("branchId"));
		System.out.println("branch" + branchId);
		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		studentAdmissionModel.setBranchMasterModel(branchMasterModel);

		int standardId = Integer.parseInt(request.getParameter("standardId"));
		System.out.println("Standard" + standardId);
		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		studentAdmissionModel.setStandardMasterModel(standardMasterModel);

		studentAdmissionModel.setOriginalStandardID(standardId);

		int studentId = Integer.parseInt(StudentID);
		List<String> checkStudentId = new ArrayList<>();
		checkStudentId = accountantStudentNewAdmissionServiceInterface.getStudentCheckId(studentId);
		if (checkStudentId.size() != 0) {
			StudentID = String.valueOf(studentId + 1);
		}

		/* Create Student Barcode */
		List<acadamicYearModel> AcYear;
		AcYear = accountantStudentNewAdmissionServiceInterface.getStudentACYear(yearID);
		System.out.println(AcYear);

		String ACYear = AcYear.get(0).getAcadamicYear();

		List<StandardMasterModel> StudStandard;
		StudStandard = accountantStudentNewAdmissionServiceInterface.getStudentStandard(standardId);
		System.out.println(StudStandard);

		String STStandard = StudStandard.get(0).getStandard();

		// ACYear.substring(0,3).concat(STStandard.substring(0, 3));

		String studentBarcode = "ST".concat(ACYear.substring(0, 4)).concat(STStandard.substring(0, 3).toUpperCase())
				.concat("APR").concat(StudentID);
		studentAdmissionModel.setStudentBarcode(studentBarcode);

		/*
		 * session = request.getSession(); String imagePath =
		 * session.getServletContext().getRealPath("");
		 * System.out.println(imagePath); String ImageName =
		 * file.getOriginalFilename(); System.out.println(ImageName); String
		 * path = imagePath + "/StudentPictures/"; System.out.println(path);
		 * studentAdmissionModel.setStudentImage(ImageName);
		 * 
		 * File file1 = new File(path, ImageName); System.out.println("dddd" +
		 * file1); file.transferTo(file1);
		 */
		studentAdmissionModel.setStatus("Approved");

		String StudentFirstName = request.getParameter("studentFirstName");
		System.out.println(StudentFirstName);
		String studentPermanenetAddress = request.getParameter("studentPermanenetAddress");
		System.out.println(studentPermanenetAddress);
		String studentContactNumber = request.getParameter("studentContactNumber");
		System.out.println(studentContactNumber);
		String studentEmail1 = request.getParameter("studentEmail");
		System.out.println(studentEmail1);
		String StudentUserName = request.getParameter("Studentusername");
		System.out.println(StudentUserName);
		String StudentPassword = request.getParameter("StudentPassword");
		System.out.println(StudentPassword);

		StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
		studentRegistrationModel.setStudentName(StudentFirstName);
		studentRegistrationModel.setStudentAddress(studentPermanenetAddress);
		studentRegistrationModel.setStudentContactNumber(studentContactNumber);
		studentRegistrationModel.setStudentEmail(studentEmail1);
		studentRegistrationModel.setStudentUserName(StudentUserName);
		studentRegistrationModel.setStudentPassword(StudentPassword);

		StudentBarcodeMaster studentBarcodeMaster = new StudentBarcodeMaster();
		studentBarcodeMaster.setStudentbarcode(studentBarcode);
		int studId = Integer.parseInt(StudentID);
		StudentAdmissionModel studentAdmissionModel2 = new StudentAdmissionModel();
		studentAdmissionModel2.setAdmissionRegId(studId);
		studentBarcodeMaster.setStudentAdmissionModel(studentAdmissionModel2);

		accountantStudentNewAdmissionServiceInterface.saveRegisterDetails(studentRegistrationModel);

		accountantStudentNewAdmissionServiceInterface.saveAdmission(studentAdmissionModel);

		accountantStudentNewAdmissionServiceInterface.saveBracodeMaster(studentBarcodeMaster);
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

		model.addAttribute("StudentID", StudentID);
		return new ModelAndView("PayMakePaymentPage");
	}

	@RequestMapping("NextYearStudentAdmission")
	public ModelAndView NextYearStudentAdmission(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Student Next Year Admission");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = accountantNextYearStudentAdmissionServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = accountantNextYearStudentAdmissionServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("NextYearStudentAdmissionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonStandardA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetBranchListJsonStandard(int id) {
		List<String> GetBranchList = new ArrayList<>();
		GetBranchList = accountantNextYearStudentAdmissionServiceInterface.getBranchList(id);
		return GetBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandardA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardListJSONStandard(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = accountantNextYearStudentAdmissionServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping(value = "StudentStandardReportA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardReportA(int yearId, int streamid, int branchid, int standardID) {
		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = accountantNextYearStudentAdmissionServiceInterface.getStudentDetailsForAdmission(yearId,
				streamid, branchid, standardID);
		return getStudentDetails;
	}

	@RequestMapping(value = "GetStudentListTONextYearAdmission", params = "NextYearAdmission")
	public ModelAndView GetStudentListTONextYearAdmission(HttpServletRequest request, Model model) {
		System.out.println("Take Student Next Year admission");

		int AcademicYearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(AcademicYearID);
		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);
		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);
		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		List<String> GetStudentAdmissionDetailsForNextYearAdmission = new ArrayList<>();
		GetStudentAdmissionDetailsForNextYearAdmission = accountantNextYearStudentAdmissionServiceInterface
				.getStudentDetailsForNextYear(AcademicYearID, StreamID, BranchID, StandardID);
		model.addAttribute("GetStudentDetails", GetStudentAdmissionDetailsForNextYearAdmission);

		HashMap<String, String> YearList;
		YearList = accountantNextYearStudentAdmissionServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = accountantNextYearStudentAdmissionServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		return new ModelAndView("NextYearStudentAdmissionPage");
	}

	@RequestMapping(value = "GetStudentListTONextYearAdmission", params = "TransferStudentAdmission")
	public ModelAndView nextYearStudentTransfer(HttpServletRequest request, Model model) {
		System.out.println("Take Student Next Year Admission");
		int branchID = Integer.parseInt(request.getParameter("branchID1"));
		int StreamID = Integer.parseInt(request.getParameter("StreamID1"));
		int AcadamicYearID = Integer.parseInt(request.getParameter("YearID1"));
		int StandardID = Integer.parseInt(request.getParameter("standardID1"));

		int yearID = AcadamicYearID;
		int standardId = StandardID;

		int AcademicYearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(AcademicYearID);
		int StreamIDs = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);
		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);
		int StandardIDs = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		List<String> GetStudentAdmissionDetailsForNextYearAdmission = new ArrayList<>();
		GetStudentAdmissionDetailsForNextYearAdmission = accountantNextYearStudentAdmissionServiceInterface
				.getStudentDetailsForNextYear(AcademicYearID, StreamIDs, BranchID, StandardIDs);

		/* Create Student Barcode */
		List<acadamicYearModel> AcYear;
		AcYear = accountantNextYearStudentAdmissionServiceInterface.getStudentACYear(yearID);
		System.out.println(AcYear);

		String ACYear = AcYear.get(0).getAcadamicYear();

		List<StandardMasterModel> StudStandard;
		StudStandard = accountantNextYearStudentAdmissionServiceInterface.getStudentStandard(standardId);
		System.out.println(StudStandard);

		String STStandard = StudStandard.get(0).getStandard();

		// ACYear.substring(0,3).concat(STStandard.substring(0, 3));

		int CheckCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println("CheckCount" + CheckCount);

		for (int i = 0; i <= CheckCount; i++) {

			String rergId1 = request.getParameter("StudID" + i);
			if (rergId1 == null) {
				continue;
			}
			int rergId = Integer.parseInt(rergId1);
			String StudentID = (rergId1).toString();
			String studentBarcode = ACYear.substring(0, 4).concat(STStandard.substring(0, 3).toUpperCase())
					.concat("APR").concat(StudentID);
			accountantNextYearStudentAdmissionServiceInterface.transferStrudentToNextYear(rergId, branchID, StreamID,
					AcadamicYearID, StandardID, studentBarcode);
		}

		HashMap<String, String> YearList;
		YearList = accountantNextYearStudentAdmissionServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = accountantNextYearStudentAdmissionServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		return new ModelAndView("NextYearStudentAdmissionPage");
	}

	@RequestMapping(value = "GetBranchListJsonStandardA1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetBranchListJsonStandardA1(int id) {
		List<String> GetBranchList = new ArrayList<>();
		GetBranchList = accountantNextYearStudentAdmissionServiceInterface.getBranchList(id);
		return GetBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandardA1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardListJSONStandardA1(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = accountantNextYearStudentAdmissionServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping("PayMakePayment")
	public ModelAndView PayMakePayment(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Make Payment");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
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

			return new ModelAndView("PayMakePaymentPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "FetchStudentInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<String> FetchStudentInfo(int registrationID) {
		System.out.println("IN JSON");
		System.out.println(registrationID);

		List<String> FetchStudentInfoList = new ArrayList<>();
		FetchStudentInfoList = feePaymentServiceInterface.fetchListOfStudInfo(registrationID);

		return FetchStudentInfoList;
	}

	@RequestMapping(value = "CheckStudentFee", method = RequestMethod.GET)
	@ResponseBody
	public List<String> CheckStudentFee(int StudId) {
		System.out.println("Check Student");
		List<String> CheckStudent = new ArrayList<>();
		CheckStudent = feePaymentServiceInterface.CheckStudent(StudId);
		System.out.println(CheckStudent.isEmpty());
		return CheckStudent;
	}

	@RequestMapping(value = "FetchDetailInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<String> FetchDetailInfo(int StudId, String standard, String AcYear, String Stream, String Branch) {
		System.out.println("Fetch Detail Information");
		System.out.println(StudId);
		System.out.println(standard);
		System.out.println(AcYear);
		System.out.println(Stream);
		System.out.println(Branch);

		/* List<String> FetchDetailInfo=new ArrayList<>(); */
		FetchDetailInfo = feePaymentServiceInterface.GetDetailInformation(StudId, standard, AcYear, Stream, Branch);

		System.out.println(FetchDetailInfo);
		return FetchDetailInfo;
	}

	@RequestMapping(value = "GetFeeDetailInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetFeeDetailInfo(int StudId, String standard, String AcYear, String Stream, String Branch) {
		System.out.println("Fetch FEE Detail Information");
		System.out.println(StudId);
		System.out.println(standard);
		System.out.println(AcYear);
		System.out.println(Stream);
		System.out.println(Branch);

		List<String> FetchFEEDetailInfo = new ArrayList<>();
		FetchFEEDetailInfo = feePaymentServiceInterface.GetFEEDetailInformation(StudId, standard, AcYear, Stream,
				Branch);

		System.out.println(FetchFEEDetailInfo);
		return FetchFEEDetailInfo;
	}

	@RequestMapping("getRefundamt")
	@ResponseBody
	public List<String> getRefundamt(int studID) {
		System.out.println("getRefundamt");

		List<String> getFee;
		getFee = feePaymentServiceInterface.getStudentRefundAmt(studID);
		System.out.println(getFee);
		return getFee;

	}

	@RequestMapping("GetRefundFeeDetailInfo")
	@ResponseBody
	public List<String> GetRefundFeeDetailInfo(int StudId, String standard, String AcYear, String Stream,
			String Branch) {
		System.out.println("Fetch refund FEE Detail Information");
		System.out.println(StudId);
		System.out.println(standard);
		System.out.println(AcYear);
		System.out.println(Stream);
		System.out.println(Branch);

		List<String> FetchrefundFEEDetailInfo = new ArrayList<>();
		FetchrefundFEEDetailInfo = feePaymentServiceInterface.GetFEERefundDetailInformation(StudId, standard, AcYear,
				Stream, Branch);

		System.out.println(FetchrefundFEEDetailInfo);
		return FetchrefundFEEDetailInfo;
	}

	@RequestMapping(value = "FetchOldFeeDetail", method = RequestMethod.GET)
	@ResponseBody
	public List<String> FetchOldFeeDetail(int StudId, String standard, String AcYear, String Stream) {
		System.out.println("Old Fee Detail Fetch");
		List<String> OldFeeList = new ArrayList<>();
		OldFeeList = feePaymentServiceInterface.FetchOldFeeDetails(StudId, standard, AcYear, Stream);

		return OldFeeList;
	}

	@RequestMapping(value = "GetAccountNumberJson", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetAccountNumberJson(int Bankid) {
		System.out.println("Way to get Account number");
		List<String> GetAccountNumberList = new ArrayList<>();
		GetAccountNumberList = feePaymentServiceInterface.GetAccNumberList(Bankid);

		return GetAccountNumberList;
	}

	@RequestMapping(value = "MakePaymentSave", method = RequestMethod.POST, params = "makePayment")
	public ModelAndView MakePaymentSave(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException, NamingException, SQLException {

		StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();

		System.out.println("Student Ledger And Fee" + FetchDetailInfo);

		int RegId = Integer.parseInt(request.getParameter("registrationID"));
		System.out.println(RegId);
		int StreamID = Integer.parseInt(request.getParameter("StreamIDStud"));
		System.out.println(StreamID);
		int StandardID = Integer.parseInt(request.getParameter("StandIDStud"));
		System.out.println(StandardID);
		int AcademicYearID = Integer.parseInt(request.getParameter("AcademicYearIDStud"));
		System.out.println(AcademicYearID);
		int BranchID = Integer.parseInt(request.getParameter("BranchIDStud"));
		System.out.println(BranchID);
		String StudName = request.getParameter("StudentName");
		System.out.println(StudName);
		String Stand = request.getParameter("Standard");
		System.out.println(Stand);
		String AdmissionDate = request.getParameter("AdmissionDate");
		System.out.println(AdmissionDate);
		String AcYear = request.getParameter("AcadimicYear");
		System.out.println(AcYear);

		int RecNumber = Integer.parseInt(request.getParameter("ReceiptNumber"));
		System.out.println(RecNumber);
		String Currentdate = request.getParameter("CurrentDate");
		System.out.println(Currentdate);
		String BankID = request.getParameter("BankID");
		System.out.println("BankID" + BankID);
		String AccNumber = request.getParameter("AccountNumber");
		System.out.println(AccNumber);

		String DisMode = request.getParameter("DiscountMode");
		System.out.println(DisMode);
		String DisResaon = request.getParameter("DiscountReason");
		System.out.println(DisResaon);
		String OtherRes = request.getParameter("OtherReson");
		System.out.println(OtherRes);
		String TotalDis = request.getParameter("TotalDiscount");
		System.out.println(TotalDis);

		String TotFee = (String) request.getParameter("TotalFee");
		System.out.println(TotFee);
		String AlreadyFee = request.getParameter("AlreadyPaidFee");
		System.out.println(AlreadyFee);
		String PaidFees = request.getParameter("PaidFee");
		System.out.println(PaidFees);
		String PendFee = request.getParameter("PendingFee");
		System.out.println(PendFee);

		if (PendFee.equals("0")) {
			ledgerFeePaidModel.setFeeStatus("Completed");
			feePaymentServiceInterface.updatePendingS(RegId);
		} else {
			feePaymentServiceInterface.updatePendingStatus(TotFee, PendFee, RegId);
		}

		String PayMode = request.getParameter("PaymentMode");
		System.out.println(PayMode);
		String TranNumber = request.getParameter("transactionNumber");
		System.out.println(TranNumber);
		String Transdate = request.getParameter("transactionDate");
		System.out.println(Transdate);
		String bankname = request.getParameter("bankName");
		System.out.println(bankname);

		/* saving data in transcation model */
		BankMasterModel bankMasterModel = new BankMasterModel();

		transactionDetailsModel.setBankName(bankname);
		transactionDetailsModel.setPaymentMode(PayMode);
		transactionDetailsModel.setReceiptDate(Currentdate);
		transactionDetailsModel.setReceiptNo(RecNumber);
		transactionDetailsModel.setTransactionDate(Transdate);
		transactionDetailsModel.setTransactionNumber(TranNumber);
		bankMasterModel.setBankId(Integer.parseInt(BankID));
		transactionDetailsModel.setBankMasterModel(bankMasterModel);

		/* saving value in discount */
		DiscountModel.setStandard(Stand);
		DiscountModel.setDiscountReason(DisResaon);
		DiscountModel.setOtherreason(OtherRes);
		DiscountModel.setTotaldiscount(TotalDis);
		studentAdmissionModel.setAdmissionRegId(RegId);
		DiscountModel.setStudentAdmissionModel(studentAdmissionModel);

		/* Save Ledger Fee MAster Deatails value */
		ledgerFeePaidModel.setAcademicYear(AcYear);
		ledgerFeePaidModel.setAcdemicYearID(AcademicYearID);
		ledgerFeePaidModel.setStreamID(StreamID);
		ledgerFeePaidModel.setStandardID(StandardID);
		ledgerFeePaidModel.setBranchID(BranchID);
		ledgerFeePaidModel.setAlreadyPaidFees(Float.parseFloat(AlreadyFee));
		ledgerFeePaidModel.setPaidFees(Float.parseFloat(PaidFees));
		ledgerFeePaidModel.setPendingFees(Float.parseFloat(PendFee));
		ledgerFeePaidModel.setStandard(Stand);
		ledgerFeePaidModel.setTotalFee(Float.parseFloat(TotFee));

		int disId = DiscountModel.getDiscountId();
		DiscountModel.setDiscountId(disId);
		ledgerFeePaidModel.setDiscountModel(DiscountModel);
		/* admisssion reg id */
		studentAdmissionModel.setAdmissionRegId(RegId);
		ledgerFeePaidModel.setStudentAdmissionModel(studentAdmissionModel);
		/* transxaction details id */

		int tranxId = transactionDetailsModel.getTransactionDetailsId();
		transactionDetailsModel.setTransactionDetailsId(tranxId);
		ledgerFeePaidModel.setTransactionDetailsModels(transactionDetailsModel);

		System.out.println("ledgerFeePaidModel" + ledgerFeePaidModel);
		System.out.println("transactionDetailsModel" + transactionDetailsModel);
		System.out.println("DiscountModel" + DiscountModel);

		feePaymentServiceInterface.saveTransactionModel(transactionDetailsModel);
		feePaymentServiceInterface.saveDiscountModel(DiscountModel);

		String refundAmount = request.getParameter("RefoundAmount");
		System.out.println(refundAmount);
		if (refundAmount.equals("0")) {

		} else {
			RefundAmountModel refundAmountModel = new RefundAmountModel();
			refundAmountModel.setRefundamount(Float.parseFloat(refundAmount));

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(AcademicYearID);
			refundAmountModel.setAcadamicYearModel(acadamicYearModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(BranchID);
			refundAmountModel.setBranchMasterModel(branchMasterModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(StreamID);
			refundAmountModel.setStreamMasterModel(streamMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(StandardID);
			refundAmountModel.setStandardMasterModel(standardMasterModel);

			StudentAdmissionModel studentAdmissionModel2 = new StudentAdmissionModel();
			studentAdmissionModel2.setAdmissionRegId(RegId);
			refundAmountModel.setStudentAdmissionModel(studentAdmissionModel2);

			/*
			 * TransactionDetailsModel transactionDetailsModel=new
			 * TransactionDetailsModel();
			 * transactionDetailsModel.setTransactionDetailsId(tranxId);
			 * refundAmountModel.setTransactionDetailsModels(
			 * transactionDetailsModel);
			 * 
			 * discountModel discountModel=new discountModel();
			 * discountModel.setDiscountId(disId);
			 * refundAmountModel.setDiscountModel(discountModel);
			 */

			feePaymentServiceInterface.saveRefoundModel(refundAmountModel);

		}

		feePaymentServiceInterface.saveLedgerFeeModel(ledgerFeePaidModel);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename1 = "StuedentFeeRecipt";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", RegId);
		hm.put("StreamID", StreamID);
		hm.put("BranchID", BranchID);
		hm.put("StandardID", StandardID);
		hm.put("AcademicYearID", AcademicYearID);
		hm.put("AlreadyFee", AlreadyFee);
		hm.put("PaidFees", PaidFees);

		if (PayMode.equals("Cash")) {
			TranNumber = "No Number";
			Transdate = "No Date";
			bankname = "No Bank";
		}

		if (TotalDis.equals("")) {
			TotalDis = "No Discount";
		}

		String rfAmt = refundAmount;
		if (rfAmt == "0") {
			rfAmt = "No Refund";
		} else {
			rfAmt = refundAmount;
		}
		System.out.println(rfAmt);

		hm.put("Discount", TotalDis);
		hm.put("PaymentMode", PayMode);
		hm.put("TranNumber", TranNumber);
		hm.put("TraDate", Transdate);
		hm.put("TraBank", bankname);
		hm.put("RefundAmount", rfAmt);
		hm.put("banner", banner);
		/*
		 * long paidamount=Long.parseLong(PaidFees); String
		 * world=EnglishNumberToWords.convert(paidamount); hm.put("world",
		 * world);
		 */

		if (PendFee.equals("0")) {
			hm.put("PendFee", "Completed");
		} else {
			hm.put("PendFee", PendFee);
		}

		System.out.println(hm);
		PrintJasperReport.printreport(filename1, request, response, hm);

		/*
		 * Iterator ITR = FetchDetailInfo.iterator(); while (ITR.hasNext()) {
		 * HashMap h = (HashMap) ITR.next(); Iterator itr1 =
		 * h.entrySet().iterator(); while (itr1.hasNext()) { Map.Entry e =
		 * (Entry) itr1.next(); hm.put((String) e.getKey(), e.getValue()); } }
		 */

		/*
		 * HashMap<String, String> BankList; BankList =
		 * feePaymentServiceInterface.GetBankList();
		 * System.out.println(BankList); System.out.println(BankList.get(0));
		 * 
		 * model.addAttribute("BankList", BankList);
		 * 
		 * int ReceiptNumber = 0; ReceiptNumber =
		 * feePaymentServiceInterface.getReceiptNumber();
		 * System.out.println(ReceiptNumber);
		 * model.addAttribute("ReceiptNumber", ReceiptNumber);
		 */

		return new ModelAndView("AccHome");
	}

	@RequestMapping("PayPrintChallan")
	public ModelAndView PayPrintChallan() {
		System.out.println("Way to Payment print Challan");
		return new ModelAndView("PayPrintChallanPage");

	}

	@RequestMapping("PayPrintReceipt")
	public ModelAndView PayPrintReceipt(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Payment print Receipt");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("PayPrintReceiptPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetStudentInformation", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStudentInformation(int StudID) {
		List<String> StudentInfo = new ArrayList<>();
		StudentInfo = feePaymentServiceInterface.getStudentInformation(StudID);
		return StudentInfo;
	}

	@RequestMapping("getLedgerDetails")
	@ResponseBody
	public List<String> getLedgerDetails(int StudId, int standard, int AcYear, int Stream, int Branch) {
		List<String> getLedgerFees = new ArrayList<>();
		System.out.println(StudId + "" + standard + "" + AcYear + "" + Stream + "" + Branch);
		getLedgerFees = feePaymentServiceInterface.getLedgerFeeAndLedger(StudId, standard, Stream, AcYear, Branch);
		return getLedgerFees;
	}

	@RequestMapping("getFeePaidDetails")
	@ResponseBody
	public List<String> getFeePaidDetails(int StudId, int standard, int AcYear, int Stream, int Branch) {
		List<String> getTransactionDetails = new ArrayList<>();
		System.out.println(StudId + "" + standard + "" + AcYear + "" + Stream + "" + Branch);
		getTransactionDetails = feePaymentServiceInterface.getTransactionDetailsToPrint(StudId, standard, Stream,
				AcYear, Branch);
		return getTransactionDetails;
	}

	@RequestMapping(value = "PrintStudentReceipt")
	public ModelAndView PrintStudentReceipt(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("PrintStudentReceipt");

		try {
			int RegId = Integer.parseInt(request.getParameter("registrationID"));
			System.out.println(RegId);
			int StreamID = Integer.parseInt(request.getParameter("StreamIDStud"));
			System.out.println(StreamID);
			int StandardID = Integer.parseInt(request.getParameter("StandIDStud"));
			System.out.println(StandardID);
			int AcademicYearID = Integer.parseInt(request.getParameter("AcademicYearIDStud"));
			System.out.println(AcademicYearID);
			int BranchID = Integer.parseInt(request.getParameter("BranchIDStud"));
			System.out.println(BranchID);

			String TotalDiscount = request.getParameter("TotalDiscount");
			System.out.println(TotalDiscount);
			int AlreadyPaidFee = Integer.parseInt(request.getParameter("AlreadyPaidFee"));
			System.out.println(AlreadyPaidFee);
			int PaidFee = Integer.parseInt(request.getParameter("PaidFee"));
			System.out.println(PaidFee);
			int PendingFee = Integer.parseInt(request.getParameter("PendingFee"));
			System.out.println(PendingFee);
			String PaymentMode = request.getParameter("PaymentModel");
			System.out.println(PaymentMode);
			String transactionNumber = request.getParameter("transactionNumber");
			System.out.println(transactionNumber);
			String transactionDate = request.getParameter("transactionDate");
			System.out.println(transactionDate);
			String bankName = request.getParameter("bankName");
			System.out.println(bankName);

			if (PaymentMode.equals("Cash")) {
				transactionNumber = "No Number";
				transactionDate = "No Date";
				bankName = "No Bank";
			}

			if (TotalDiscount.equals("")) {
				TotalDiscount = "No Discount";
			}

			ServletContext context = session.getServletContext();
			String banner = context.getRealPath("/images/report/Capturenew.jpg");

			String filename1 = "PrintStudentPaymentRecipt";

			HashMap<String, Object> hm = new HashMap<>();
			hm.put("StudentID", RegId);
			hm.put("StreamID", StreamID);
			hm.put("BranchID", BranchID);
			hm.put("StandardID", StandardID);
			hm.put("AcademicYearID", AcademicYearID);

			hm.put("Discount", TotalDiscount);
			hm.put("AlPaid", AlreadyPaidFee);
			hm.put("PrivousPaid", PaidFee);
			hm.put("Pending", PendingFee);
			hm.put("PaymentMode", PaymentMode);
			hm.put("TranNumber", transactionNumber);
			hm.put("TraDate", transactionDate);
			hm.put("TraBank", bankName);
			hm.put("banner", banner);
			// hm.put("", );
			// hm.put("AlreadyFee", AlreadyFee);

			System.out.println(hm);
			try {
				PrintJasperReport.printreport(filename1, request, response, hm);
			} catch (JRException | NamingException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return new ModelAndView();
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("PayPrintReceiptPage");
		}
	}

	@RequestMapping("PayStudentTransferFee")
	public ModelAndView PayStudentTransferFee() {
		System.out.println("Way to Payment Student Transfer");
		return new ModelAndView("PayStudentTransferFeePage");

	}

	@RequestMapping("refoundStudentAmount")
	public ModelAndView refoundStudentAmount(HttpSession session, Model model, HttpServletRequest request) {
		System.out.println("refoundStudentAmount");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("refoundStudentAmountPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "getStudentRefoundDate")
	@ResponseBody
	public List<String> getStudentRefoundDate(String StudentName ) {
		System.out.println("getStudentRefoundDate");

		List<String> getStudentData;
		getStudentData = feePaymentServiceInterface.getStudentdata(StudentName);
		return getStudentData;
	}

	@RequestMapping(value = "SubmitStudentRefundAmount")
	public ModelAndView SubmitStudentRefundAmount(HttpSession session, HttpServletResponse response, Model model,
			HttpServletRequest request) {
		System.out.println("SubmitStudentRefundAmount");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = feePaymentServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int refundId = Integer.parseInt(request.getParameter("refundID"));
			System.out.println(refundId);

			int StudentID = Integer.parseInt(request.getParameter("registrationID"));
			System.out.println(StudentID);

			String BankName = request.getParameter("BankName");
			System.out.println(BankName);

			String BranchName = request.getParameter("BranchName");
			System.out.println(BranchName);

			String CheckNumber = request.getParameter("CheckNumber");
			System.out.println(CheckNumber);

			String IFSCCode = request.getParameter("IFSCCode");
			System.out.println(IFSCCode);

			String CheckDate = request.getParameter("CheckDate");
			System.out.println(CheckDate);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String refundAmtDate = sdf.format(d);

			model.addAttribute("MessageRefundAmt", "Student Refund Amount Details Save Sucessfully");
			feePaymentServiceInterface.updateRefundData(refundId, BankName, BranchName, CheckNumber, CheckDate,
					IFSCCode, StudentID, refundAmtDate);

			ServletContext context = session.getServletContext();
			String banner = context.getRealPath("/images/report/Capturenew.jpg");

			String filename = "RefoundAmountReport";
			HashMap<String, Object> hm = new HashMap<>();
			hm.put("StudentID", StudentID);
			hm.put("BankName", BankName);
			hm.put("BranchName", BranchName);
			hm.put("CheckNumber", CheckNumber);
			hm.put("CheckDate", CheckDate);
			hm.put("IFSCCode", IFSCCode);
			hm.put("banner", banner);
			try {
				PrintJasperReport.printreport(filename, request, response, hm);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// model.addAttribute("MessageRefundAmt","Student Refund Amount
			// Details Save Sucessfully");
			return new ModelAndView("refoundStudentAmountPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	public FeePaymentServiceInterface getFeePaymentServiceInterface() {
		return feePaymentServiceInterface;
	}

	public void setFeePaymentServiceInterface(FeePaymentServiceInterface feePaymentServiceInterface) {
		this.feePaymentServiceInterface = feePaymentServiceInterface;
	}

	public LedgerFeePaidModel getLedgerFeePaidModel() {
		return ledgerFeePaidModel;
	}

	public void setLedgerFeePaidModel(LedgerFeePaidModel ledgerFeePaidModel) {
		this.ledgerFeePaidModel = ledgerFeePaidModel;
	}

	public TransactionDetailsModel getTransactionDetailsModel() {
		return transactionDetailsModel;
	}

	public void setTransactionDetailsModel(TransactionDetailsModel transactionDetailsModel) {
		this.transactionDetailsModel = transactionDetailsModel;
	}

	public discountModel getDiscountModel() {
		return DiscountModel;
	}

	public void setDiscountModel(discountModel discountModel) {
		DiscountModel = discountModel;
	}

	public AccountantStudentNewAdmissionServiceInterface getAccountantStudentNewAdmissionServiceInterface() {
		return accountantStudentNewAdmissionServiceInterface;
	}

	public void setAccountantStudentNewAdmissionServiceInterface(
			AccountantStudentNewAdmissionServiceInterface accountantStudentNewAdmissionServiceInterface) {
		this.accountantStudentNewAdmissionServiceInterface = accountantStudentNewAdmissionServiceInterface;
	}

	public List<String> getFetchDetailInfo() {
		return FetchDetailInfo;
	}

	public void setFetchDetailInfo(List<String> fetchDetailInfo) {
		FetchDetailInfo = fetchDetailInfo;
	}

	public AccountantNextYearStudentAdmissionServiceInterface getAccountantNextYearStudentAdmissionServiceInterface() {
		return accountantNextYearStudentAdmissionServiceInterface;
	}

	public void setAccountantNextYearStudentAdmissionServiceInterface(
			AccountantNextYearStudentAdmissionServiceInterface accountantNextYearStudentAdmissionServiceInterface) {
		this.accountantNextYearStudentAdmissionServiceInterface = accountantNextYearStudentAdmissionServiceInterface;
	}
}
