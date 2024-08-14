package com.account.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BranchMasterModel;
import com.account.model.LedgerFeePaidModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.AccountantNextYearStudentAdmissionServiceInterface;
import com.account.serviceInterface.FeePaymentServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

@Controller
public class AccountStudentNextYearAdmissionController {

	@Autowired
	private AccountantNextYearStudentAdmissionServiceInterface accountantNextYearStudentAdmissionServiceInterface;

	@Autowired
	private FeePaymentServiceInterface feePaymentServiceInterface;

	public FeePaymentServiceInterface getFeePaymentServiceInterface() {
		return feePaymentServiceInterface;
	}

	public void setFeePaymentServiceInterface(FeePaymentServiceInterface feePaymentServiceInterface) {
		this.feePaymentServiceInterface = feePaymentServiceInterface;
	}

	public AccountantNextYearStudentAdmissionServiceInterface getAccountantNextYearStudentAdmissionServiceInterface() {
		return accountantNextYearStudentAdmissionServiceInterface;
	}

	public void setAccountantNextYearStudentAdmissionServiceInterface(
			AccountantNextYearStudentAdmissionServiceInterface accountantNextYearStudentAdmissionServiceInterface) {
		this.accountantNextYearStudentAdmissionServiceInterface = accountantNextYearStudentAdmissionServiceInterface;
	}

	@RequestMapping("StudentNextYearAdmissionViaAccountant")
	public ModelAndView StudentNextYearAdmissionViaAccountant(Model model)
	{
		System.out.println("StudentNextYearAdmissionViaAccountant");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String curentdate = sdf.format(d);

		model.addAttribute("curentdate", curentdate);
		
		HashMap<String, String> YearList;
		YearList = accountantNextYearStudentAdmissionServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);
		
		HashMap<String, String> streamList;
		streamList = accountantNextYearStudentAdmissionServiceInterface.getStreamList();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);
		
		return new ModelAndView("StudentNextYearAdmissionViaAccountantPage");
	}
	
	@RequestMapping(value="getStudentDetailsOfAdmissionToNextYear")
	@ResponseBody
	public List<String> getStudentDetailsOfAdmissionToNextYear(int studentId)
	{
		System.out.println("getStudentDetailsOfAdmissionToNextYear");
		List<String> StudentInfo=new ArrayList<>();
		
		Integer studentYearID;
		studentYearID = accountantNextYearStudentAdmissionServiceInterface.getStudentInfo(studentId);
		System.out.println(studentYearID);

		List<acadamicYearModel> activeYear = new ArrayList<>();
		activeYear = accountantNextYearStudentAdmissionServiceInterface.getActiveYear();
		System.out.println(activeYear);

		int activeYearId = activeYear.get(0).getAcadamicYearId();
		System.out.println(activeYearId);

		if (studentYearID == activeYearId) {
			System.out.println("Student Academic Year Same");
			//model.addAttribute("StudMsg", "You Already Take Admission For Current Year");
			return StudentInfo;
		} else {
			List<LedgerFeePaidModel> feeDetails = new ArrayList<>();
			feeDetails = accountantNextYearStudentAdmissionServiceInterface.getFeeDetails(studentId);
			System.out.println(feeDetails);
			try {
				String feeStatus = feeDetails.get(0).getFeeStatus();
				System.out.println(feeStatus);
				
				int pendingFee=(int) feeDetails.get(0).getPendingFees();
				System.out.println(pendingFee);

				List<String> studFee=new ArrayList<>();
				studFee.add(feeStatus);
			
				if (feeStatus.equals("pending")) {
					System.out.println("Pending fee");
				//	StudentInfo.addAll(studFee);
					System.out.println("Student Fee Pend"+StudentInfo);
					return StudentInfo;

				} else {
					System.out.println("Student Year Is Not Same");
					

					//model.addAttribute("StudentID", studId);

					List<String> studentInfo;
					studentInfo = accountantNextYearStudentAdmissionServiceInterface.getStudentDetailInfo(studentId);
					System.out.println("Studnet Infor"+studentInfo);

					//model.addAttribute("StudentDetails", studentInfo);
					StudentInfo.addAll(studentInfo);
					System.out.println("Main List"+StudentInfo);
					return StudentInfo;
				}
			} catch (Exception e) {
				//model.addAttribute("StudMsg", "Please pay pending fee...");
				return StudentInfo;
			}
		}
	}
	
	@RequestMapping(value="studentNextYearAdmissionViaAccountSave",params="TakeNextAddmission")
	public ModelAndView studentNextYearAdmissionViaAccountSave(Model model,@ModelAttribute("")StudentAdmissionModel studentAdmissionModel,HttpServletRequest request)
	{
		System.out.println("studentNextYearAdmissionViaAccountSave");
		
		
		int registrationID = Integer.parseInt(request.getParameter("admissionRegId"));
		System.out.println("admissionRegId " + registrationID);

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println("YearName " + YearID);

		int streamId = Integer.parseInt(request.getParameter("streamId"));
		System.out.println("streamId " + streamId);

		int branchId = Integer.parseInt(request.getParameter("branchId"));
		System.out.println("branchId " + branchId);

		int standardId = Integer.parseInt(request.getParameter("standardId"));
		System.out.println("standardId " + standardId);

		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(YearID);
		studentAdmissionModel.setAcadamicYearModel(acadamicYearModel);

		studentAdmissionModel.setOriginalAcademicYearID(YearID);

		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		studentAdmissionModel.setStreamMasterModel(streamMasterModel);

		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		studentAdmissionModel.setBranchMasterModel(branchMasterModel);

		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		studentAdmissionModel.setStandardMasterModel(standardMasterModel);

		studentAdmissionModel.setOriginalStandardID(standardId);

		/* Create Student Barcode */
		List<acadamicYearModel> AcYear;
		AcYear = accountantNextYearStudentAdmissionServiceInterface.getStudentACYear(YearID);
		System.out.println(AcYear);

		String ACYear = AcYear.get(0).getAcadamicYear();

		List<StandardMasterModel> StudStandard;
		StudStandard = accountantNextYearStudentAdmissionServiceInterface.getStudentStandard(standardId);
		System.out.println(StudStandard);

		String STStandard = StudStandard.get(0).getStandard();

		// ACYear.substring(0,3).concat(STStandard.substring(0, 3));

		String StudentID = request.getParameter("admissionRegId");
		System.out.println(StudentID);

		String studentBarcode = "ST".concat(ACYear.substring(0, 4)).concat(STStandard.substring(0, 3).toUpperCase())
				.concat("APR").concat(StudentID);

		studentAdmissionModel.setStudentBarcode(studentBarcode);

		StudentBarcodeMaster studentBarcodeMaster = new StudentBarcodeMaster();
		studentBarcodeMaster.setStudentbarcode(studentBarcode);
		int studId = Integer.parseInt(StudentID);
		StudentAdmissionModel studentAdmissionModel2 = new StudentAdmissionModel();
		studentAdmissionModel2.setAdmissionRegId(studId);
		studentBarcodeMaster.setStudentAdmissionModel(studentAdmissionModel2);

		studentAdmissionModel.setLastadmissionid(registrationID);

		studentAdmissionModel.setStatus("Approved");
		accountantNextYearStudentAdmissionServiceInterface.saveBracodeMaster(studentBarcodeMaster);

		accountantNextYearStudentAdmissionServiceInterface.saveAdmission(studentAdmissionModel);
		
		Integer studentId=0;
		studentId=accountantNextYearStudentAdmissionServiceInterface.getStudentId(registrationID);
		System.out.println(studentId);
		
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

		model.addAttribute("StudentID",studentId);
		return new ModelAndView("PayMakePaymentPage");
		
	}
}
