package com.student.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BranchMasterModel;
import com.account.model.LedgerFeePaidModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.service.RegisterStudentI;
import com.student.serviceInterface.StudentAdmisssionInterface;
import com.student.serviceInterface.StudentNextYearAdmissionServiceInterface;

@Controller
public class StudentNextYearAdmissionController {

	@Autowired
	private StudentNextYearAdmissionServiceInterface studentNextYearAdmissionServiceInterface;

	@Autowired
	private StudentAdmisssionInterface StudentAdmisssionInterface;

	@Autowired
	private RegisterStudentI registerStudentI;

	public StudentAdmisssionInterface getStudentAdmisssionInterface() {
		return StudentAdmisssionInterface;
	}

	public void setStudentAdmisssionInterface(StudentAdmisssionInterface studentAdmisssionInterface) {
		this.StudentAdmisssionInterface = studentAdmisssionInterface;
	}

	public StudentNextYearAdmissionServiceInterface getStudentNextYearAdmissionServiceInterface() {
		return studentNextYearAdmissionServiceInterface;
	}

	public void setStudentNextYearAdmissionServiceInterface(
			StudentNextYearAdmissionServiceInterface studentNextYearAdmissionServiceInterface) {
		this.studentNextYearAdmissionServiceInterface = studentNextYearAdmissionServiceInterface;
	}

	@RequestMapping(value = "StudentNextYearAdmissionProc", params = "takeNextYearAdmission")
	public ModelAndView StudentNextYearAdmissionProc(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("StudentNextYearAdmissionProc");

		int studId = Integer.parseInt(request.getParameter("studentId"));
		System.out.println(studId);

		String studName = request.getParameter("studentFullName");
		System.out.println(studName);

		Integer studentYearID;
		studentYearID = studentNextYearAdmissionServiceInterface.getStudentInfo(studId);
		System.out.println(studentYearID);

		List<acadamicYearModel> activeYear = new ArrayList<>();
		activeYear = studentNextYearAdmissionServiceInterface.getActiveYear();
		System.out.println(activeYear);

		int activeYearId = activeYear.get(0).getAcadamicYearId();
		System.out.println(activeYearId);

		if (studentYearID == activeYearId) {
			System.out.println("Student Academic Year Same");
			model.addAttribute("StudMsg", "You Already Take Admission For Current Year");
			return new ModelAndView("AlreadyTakeAdmissionPage");
		} else {
			List<LedgerFeePaidModel> feeDetails = new ArrayList<>();
			feeDetails = studentNextYearAdmissionServiceInterface.getFeeDetails(studId);
			System.out.println(feeDetails);
			try {
				String feeStatus = feeDetails.get(0).getFeeStatus();
				System.out.println(feeStatus);
				
				int pendingFee=(int) feeDetails.get(0).getPendingFees();
				System.out.println(pendingFee);

				if (feeStatus.equals("pending")) {
					model.addAttribute("PendingFee",pendingFee+"Rs");																	
					model.addAttribute("StudMsg", "Please pay pending fee...");
					return new ModelAndView("AlreadyTakeAdmissionPage");

				} else {
					System.out.println("Student Year Is Not Same");
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

					String curentdate = sdf.format(d);

					model.addAttribute("curentdate", curentdate);

					HashMap<String, String> YearList;
					YearList = studentNextYearAdmissionServiceInterface.GetYearList();
					System.out.println(YearList);
					model.addAttribute("YearList", YearList);

					model.addAttribute("StudentID", studId);

					HashMap<String, String> streamList;
					streamList = studentNextYearAdmissionServiceInterface.SetStream();
					System.out.println(streamList);
					model.addAttribute("StreamList", streamList);

					List<String> studentInfo;
					studentInfo = studentNextYearAdmissionServiceInterface.getStudentDetailInfo(studId);
					System.out.println(studentInfo);

					model.addAttribute("StudentDetails", studentInfo);

					return new ModelAndView("NextYearAdmissionPage");
				}
			} catch (Exception e) {
				model.addAttribute("StudMsg", "Please pay pending fee...");
				return new ModelAndView("AlreadyTakeAdmissionPage");
			}
		}
	}

	@RequestMapping(value = "TakeStudentNextYearAdmissionPage", params = "TakeAddmission")
	public ModelAndView TakeStudentNextYearAdmissionPage(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("admission") StudentAdmissionModel studentAdmissionModel) {
		System.out.println("TakeStudentNextYearAdmissionPage");

		/*
		 * String studentsscname=request.getParameter("studentnamessc");
		 * System.out.println("studentnamessc "+studentsscname);
		 * 
		 * String AddressTaluka=request.getParameter("AddressTaluka");
		 * System.out.println("AddressTaluka "+AddressTaluka);
		 * 
		 * String Addressdistrict=request.getParameter("Addressdistrict");
		 * System.out.println("Addressdistrict "+Addressdistrict);
		 * 
		 * String uniidnumber=request.getParameter("uniidnumber");
		 * System.out.println("uniidnumber "+uniidnumber);
		 * 
		 * String studentHostel=request.getParameter("studentHostel");
		 * System.out.println("studentHostel "+studentHostel);
		 * 
		 * String studentLastYearscholarshipApplied=request.getParameter(
		 * "studentLastYearscholarshipApplied"); System.out.println(
		 * "studentLastYearscholarshipApplied "
		 * +studentLastYearscholarshipApplied);
		 * 
		 * String studentScholarshipsanctioned=request.getParameter(
		 * "studentScholarshipsanctioned"); System.out.println(
		 * "studentScholarshipsanctioned "+studentScholarshipsanctioned);
		 * 
		 * String
		 * studentIfYesAmountRs=request.getParameter("studentIfYesAmountRs");
		 * System.out.println("studentIfYesAmountRs "+studentIfYesAmountRs);
		 * 
		 * String studentPreviousschoolName=request.getParameter(
		 * "studentPreviousschoolName"); System.out.println(
		 * "studentPreviousschoolName "+studentPreviousschoolName);
		 * 
		 * String studentDomicileofMaharashtra=request.getParameter(
		 * "studentDomicileofMaharashtra"); System.out.println(
		 * "studentDomicileofMaharashtra "+studentDomicileofMaharashtra);
		 * 
		 * String sscTotalMarks=request.getParameter("sscTotalMarks");
		 * System.out.println("sscTotalMarks "+sscTotalMarks);
		 * 
		 * String sscOutOfMarks=request.getParameter("sscOutOfMarks");
		 * System.out.println("studentDomicileofMaharashtra "+sscOutOfMarks);
		 * 
		 * String sscXIIRegNo=request.getParameter("sscXIIRegNo");
		 * System.out.println("sscXIIRegNo "+sscXIIRegNo);
		 * 
		 * String hscTotalMarks=request.getParameter("hscTotalMarks");
		 * System.out.println("hscTotalMarks "+hscTotalMarks);
		 * 
		 * String hscOutOfMarks=request.getParameter("hscOutOfMarks");
		 * System.out.println("hscOutOfMarks "+hscOutOfMarks);
		 * 
		 * String hscpcbpcm=request.getParameter("hscpcbpcm");
		 * System.out.println("hscpcbpcm "+hscpcbpcm);
		 * 
		 * String hscPCMMarks=request.getParameter("hscPCMMarks");
		 * System.out.println("hscPCMMarks "+hscPCMMarks);
		 */

		/*
		 * String hscPCBMarks=request.getParameter("hscPCBMarks");
		 * System.out.println(hscPCBMarks);
		 */

		/*
		 * String
		 * hscPCMPCBTotalMarks=request.getParameter("hscPCMPCBTotalMarks");
		 * System.out.println("hscPCMPCBTotalMarks "+hscPCMPCBTotalMarks);
		 * 
		 * String
		 * finbpharmTotalMarks=request.getParameter("finbpharmTotalMarks");
		 * System.out.println("finbpharmTotalMarks "+finbpharmTotalMarks);
		 * 
		 * String
		 * finbpharmOutOfMarks=request.getParameter("finbpharmOutOfMarks");
		 * System.out.println("finbpharmOutOfMarks "+finbpharmOutOfMarks);
		 * 
		 * String
		 * finbpharmPercentage=request.getParameter("finbpharmPercentage");
		 * System.out.println("finbpharmPercentage "+finbpharmPercentage);
		 * 
		 * String tybpharmTotalMarks=request.getParameter("tybpharmTotalMarks");
		 * System.out.println("tybpharmTotalMarks "+tybpharmTotalMarks);
		 * 
		 * String tybpharmOutOfMarks=request.getParameter("tybpharmOutOfMarks");
		 * System.out.println("tybpharmOutOfMarks "+tybpharmOutOfMarks);
		 * 
		 * String tybpharmPercentage=request.getParameter("tybpharmPercentage");
		 * System.out.println("tybpharmPercentage "+tybpharmPercentage);
		 * 
		 * String sybpharmTotalMarks=request.getParameter("sybpharmTotalMarks");
		 * System.out.println("sybpharmTotalMarks "+sybpharmTotalMarks);
		 * 
		 * String sybpharmOutOfMarks=request.getParameter("sybpharmOutOfMarks");
		 * System.out.println("sybpharmOutOfMarks "+sybpharmOutOfMarks);
		 * 
		 * String sybpharmPercentage=request.getParameter("sybpharmPercentage");
		 * System.out.println("sybpharmPercentage "+sybpharmPercentage);
		 * 
		 * String fybpharmTotalMarks=request.getParameter("fybpharmTotalMarks");
		 * System.out.println("fybpharmTotalMarks "+fybpharmTotalMarks);
		 * 
		 * String fybpharmOutOfMarks=request.getParameter("fybpharmOutOfMarks");
		 * System.out.println("fybpharmOutOfMarks "+fybpharmOutOfMarks);
		 * 
		 * String fybpharmPercentage=request.getParameter("fybpharmPercentage");
		 * System.out.println("fybpharmPercentage "+fybpharmPercentage);
		 * 
		 * String fatherEducationalQualification=request.getParameter(
		 * "fatherEducationalQualification"); System.out.println(
		 * "fatherEducationalQualification "+fatherEducationalQualification);
		 * 
		 * String fatherDesignation=request.getParameter("fatherDesignation");
		 * System.out.println("fatherDesignation "+fatherDesignation);
		 * 
		 * String fatherOrganization=request.getParameter("fatherOrganization");
		 * System.out.println("fatherOrganization "+fatherOrganization);
		 * 
		 * String
		 * fatherContactNumber=request.getParameter("fatherContactNumber");
		 * System.out.println("fatherContactNumber "+fatherContactNumber);
		 * 
		 * String motherLastName=request.getParameter("motherLastName");
		 * System.out.println("motherLastName "+motherLastName);
		 * 
		 * String motherFirstName=request.getParameter("motherFirstName");
		 * System.out.println("motherFirstName "+motherFirstName);
		 * 
		 * String mothermiddleName=request.getParameter("mothermiddleName");
		 * System.out.println("mothermiddleName "+mothermiddleName);
		 * 
		 * String motherEducationalQualification=request.getParameter(
		 * "motherEducationalQualification"); System.out.println(
		 * "motherEducationalQualification "+motherEducationalQualification);
		 * 
		 * String motherOccupation=request.getParameter("motherOccupation");
		 * System.out.println("motherOccupation "+motherOccupation);
		 * 
		 * String motherDesignation=request.getParameter("motherDesignation");
		 * System.out.println("motherDesignation "+motherDesignation);
		 * 
		 * String
		 * motherMonthlyIncome=request.getParameter("motherMonthlyIncome");
		 * System.out.println("motherMonthlyIncome "+motherMonthlyIncome);
		 * 
		 * String
		 * motherContactNumber=request.getParameter("motherContactNumber");
		 * System.out.println("motherContactNumber "+motherContactNumber);
		 * 
		 * String motherEmail=request.getParameter("motherEmail");
		 * System.out.println("motherEmail "+motherEmail);
		 * 
		 * String motherOrganization=request.getParameter("motherOrganization");
		 * System.out.println("motherOrganization "+motherOrganization);
		 * 
		 * String studentChildNumber=request.getParameter("studentChildNumber");
		 * System.out.println("studentChildNumber "+studentChildNumber);
		 * 
		 * String studentBloodGroup=request.getParameter("studentBloodGroup");
		 * System.out.println("studentBloodGroup "+studentBloodGroup);
		 * 
		 * String studentLastName = request.getParameter("studentLastName");
		 * System.out.println("studentLastName "+studentLastName);
		 * 
		 * String studentFirstName = request.getParameter("studentFirstName");
		 * System.out.println("studentFirstName "+studentFirstName);
		 * 
		 * String studentMidddleName =
		 * request.getParameter("studentMiddleName"); System.out.println(
		 * "studentMiddleName "+studentMidddleName);
		 * 
		 * String MotherName = request.getParameter("studentMotherName");
		 * System.out.println("studentMotherName "+MotherName);
		 * 
		 * String BirthDate = request.getParameter("studentDateOfBirth");
		 * System.out.println("studentDateOfBirth "+BirthDate);
		 * 
		 * String BirthPlace = request.getParameter("studentPlaceOfBirth");
		 * System.out.println("studentPlaceOfBirth "+BirthPlace);
		 * 
		 * String fatherLastName = request.getParameter("fatherLastName");
		 * System.out.println("fatherLastName "+fatherLastName);
		 * 
		 * String fatherFirstName = request.getParameter("fatherFirstName");
		 * System.out.println("fatherFirstName "+fatherFirstName);
		 * 
		 * String fathermiddleName = request.getParameter("fathermiddleName");
		 * System.out.println("fathermiddleName "+fathermiddleName);
		 * 
		 * String FatherPermentAddress =
		 * request.getParameter("fatherPermananetAddress"); System.out.println(
		 * "fatherPermananetAddress "+FatherPermentAddress);
		 * 
		 * String fatherOccupation = request.getParameter("fatherOccupation");
		 * System.out.println("fatherOccupation "+fatherOccupation);
		 * 
		 * String AnnualIncome = request.getParameter("fatherMonthlyIncome");
		 * System.out.println("fatherMonthlyIncome "+AnnualIncome);
		 * 
		 * String FatherMail = request.getParameter("fatherEmail");
		 * System.out.println("fatherEmail "+FatherMail);
		 * 
		 * String StudentCast = request.getParameter("studentCast");
		 * System.out.println("studentCast "+StudentCast);
		 */

		/*
		 * String StudSubCast = request.getParameter("StudSubCast");
		 * System.out.println(StudSubCast);
		 * 
		 * String motherTongue = request.getParameter("motherTongue");
		 * System.out.println(motherTongue);
		 */

		/*
		 * String ResidentialAddress =
		 * request.getParameter("studentResidentialAddress");
		 * System.out.println("studentResidentialAddress "+ResidentialAddress);
		 * 
		 * String PermanentAddress =
		 * request.getParameter("studentPermanenetAddress"); System.out.println(
		 * "studentPermanenetAddress "+PermanentAddress);
		 * 
		 * String pinCode = request.getParameter("studentPinCode");
		 * System.out.println("studentPinCode "+pinCode);
		 * 
		 * String studentNationality=request.getParameter("studentNationality");
		 * System.out.println("studentNationality "+studentNationality);
		 */

		/*
		 * String ContactNumber = request.getParameter("ContactNumber");
		 * System.out.println(ContactNumber);
		 */

		/*
		 * String ParentContactNumber =
		 * request.getParameter("ParentContactNumber"); System.out.println(
		 * "ParentContactNumber "+ParentContactNumber);
		 */

		/*
		 * String studentEmail = request.getParameter("studentEmail");
		 * System.out.println(studentEmail);
		 */

		/*
		 * String studentGender = request.getParameter("studentGender");
		 * System.out.println("studentGender "+studentGender);
		 * 
		 * String StudReligion = request.getParameter("studentReligion");
		 * System.out.println("studentReligion "+StudReligion);
		 * 
		 * String StudCategory = request.getParameter("studentCategory");
		 * System.out.println("studentCategory "+StudCategory);
		 * 
		 * String AadharCardNumber = request.getParameter("aadharCardNumber");
		 * System.out.println("aadharCardNumber "+AadharCardNumber);
		 * 
		 * String AccountNumber = request.getParameter("accountNumber");
		 * System.out.println("accountNumber "+AccountNumber);
		 * 
		 * String BankName = request.getParameter("bankName");
		 * System.out.println("bankName "+BankName);
		 * 
		 * String BranchName = request.getParameter("bankBranch");
		 * System.out.println("bankBranch "+BranchName);
		 * 
		 * String IFSCCode = request.getParameter("bankIFSCCode");
		 * System.out.println("bankIFSCCode "+IFSCCode);
		 */

		/* YearID,streamId,branchId,standardId, */

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
		AcYear = StudentAdmisssionInterface.getStudentACYear(YearID);
		System.out.println(AcYear);

		String ACYear = AcYear.get(0).getAcadamicYear();

		List<StandardMasterModel> StudStandard;
		StudStandard = StudentAdmisssionInterface.getStudentStandard(standardId);
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

		studentNextYearAdmissionServiceInterface.saveBracodeMaster(studentBarcodeMaster);

		studentNextYearAdmissionServiceInterface.saveAdmission(studentAdmissionModel);

		model.addAttribute("StudentMsgOfAdmission",
				"Your Application sucessfully submited.Please Go to Take Admission Page Again And Take Admission Form Print.");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = registerStudentI.GetStudDetails(username);

		model.addAttribute("GetStudInfo", GetStudList);

		return new ModelAndView("StudentHome");

	}

	public RegisterStudentI getRegisterStudentI() {
		return registerStudentI;
	}

	public void setRegisterStudentI(RegisterStudentI registerStudentI) {
		this.registerStudentI = registerStudentI;
	}
}
