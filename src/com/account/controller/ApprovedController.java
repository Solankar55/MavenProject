package com.account.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.account.serviceInterface.ApprovedBonafideServiceInterface;
import com.account.serviceInterface.ApprovedLeavingCertificateServiceInterface;
import com.account.serviceInterface.ApprovedStudentIDCardServiceInterface;
import com.account.serviceInterface.CancelLeavingCertificateServiceInterface;
import com.account.serviceInterface.CancelStudentBonafideServiceInterface;
import com.account.serviceInterface.CancelStudentIDCardServiceInterface;
import com.account.serviceInterface.StudentAddmissionMasterinterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.service.RegisterStudentI;
import com.student.serviceInterface.StudentAdmisssionInterface;

@Controller
public class ApprovedController {

	@Autowired
	StudentAddmissionMasterinterface studentAddmissionMasterInterface;

	@Autowired
	private RegisterStudentI registerStudentI;

	@Autowired
	private StudentAdmisssionInterface StudentAdmisssionInterface;

	@Autowired
	private ApprovedStudentIDCardServiceInterface approvedStudentIDCardServiceInterface;

	@Autowired
	private ApprovedBonafideServiceInterface approvedBonafideServiceInterface;

	@Autowired
	private ApprovedLeavingCertificateServiceInterface approvedLeavingCertificateServiceInterface;

	@Autowired
	private CancelStudentIDCardServiceInterface cancelStudentIDCardServiceInterface;

	@Autowired
	private CancelStudentBonafideServiceInterface cancelStudentBonafideServiceInterface;

	@Autowired
	private CancelLeavingCertificateServiceInterface cancelLeavingCertificateServiceInterface;

	@RequestMapping("ApprovedAdmission")
	public ModelAndView ApprovedAdmission(Model model, @ModelAttribute("") StudentAdmissionModel studentAdmissionModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approved Admission Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> ApprovedStudentList = new ArrayList<>();
			ApprovedStudentList = studentAddmissionMasterInterface.GetApprovedStudentList();
			System.out.println(ApprovedStudentList);

			model.addAttribute("ApprovedAddmissionList", ApprovedStudentList);

			if (ApprovedStudentList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request To Approved/Edit Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("ApprovedAdmissionPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "UpdateApprovedStudentDetails", method = RequestMethod.POST, params = "UpdateInfo")
	public ModelAndView UpdateApprovedStudentDetails(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("Way to Update Student Information");
		int StudentID = Integer.parseInt(request.getParameter("admissionId"));
		System.out.println(StudentID);

		List<String> studentInfo;
		studentInfo = studentAddmissionMasterInterface.getStudentInformation(StudentID);
		System.out.println(studentInfo);

		model.addAttribute("studentInfo", studentInfo);

		// model.addAttribute("StudentID", StudentID);
		/*
		 * String StudFirstName = request.getParameter("StudFirst");
		 * System.out.println(StudFirstName);
		 * model.addAttribute("StudFirstName", StudFirstName); String
		 * StudLastName = request.getParameter("StudLast");
		 * System.out.println(StudLastName); model.addAttribute("StudLastName",
		 * StudLastName); String StudContact =
		 * request.getParameter("contactNumber");
		 * System.out.println(StudContact); model.addAttribute("StudContact",
		 * StudContact); String StudGender =
		 * request.getParameter("studentGender");
		 * System.out.println(StudGender); model.addAttribute("StudGender",
		 * StudGender); String StudDOB = request.getParameter("dateOfBirth");
		 * System.out.println(StudDOB); model.addAttribute("StudDOB", StudDOB);
		 * String StudNationality = request.getParameter("nationality");
		 * System.out.println(StudNationality);
		 * model.addAttribute("StudNationality", StudNationality); String
		 * StudRelision = request.getParameter("religion");
		 * System.out.println(StudRelision); model.addAttribute("StudRelision",
		 * StudRelision); String StudCategory =
		 * request.getParameter("studentCategory");
		 * System.out.println(StudCategory); model.addAttribute("StudCategory",
		 * StudCategory); String StudCast = request.getParameter("studentCast");
		 * System.out.println(StudCast); model.addAttribute("StudCast",
		 * StudCast); String fatherName = request.getParameter("fatherName");
		 * System.out.println(fatherName); model.addAttribute("fatherName",
		 * fatherName); String fatherAddress =
		 * request.getParameter("fatherAddress");
		 * System.out.println(fatherAddress);
		 * request.setAttribute("fatherAddress", fatherAddress);
		 * model.addAttribute("fatherAddress", fatherAddress); String
		 * fatherAccupation = request.getParameter("occupation");
		 * System.out.println(fatherAccupation);
		 * model.addAttribute("fatherAccupation", fatherAccupation); String
		 * fatherIncome = request.getParameter("fatherIncome");
		 * System.out.println(fatherIncome); model.addAttribute("fatherIncome",
		 * fatherIncome); String FatherEmail =
		 * request.getParameter("fatherEmail"); System.out.println(FatherEmail);
		 * model.addAttribute("FatherEmail", FatherEmail); String fatherContact
		 * = request.getParameter("fathercontact");
		 * System.out.println(fatherContact);
		 * model.addAttribute("fatherContact", fatherContact); String StudStream
		 * = request.getParameter("studentStream");
		 * System.out.println(StudStream); model.addAttribute("StudStream",
		 * StudStream); String StudBranch =
		 * request.getParameter("studentBranch");
		 * System.out.println(StudBranch); model.addAttribute("StudBranch",
		 * StudBranch); String StudStandard =
		 * request.getParameter("studentStandard");
		 * System.out.println(StudStandard); model.addAttribute("StudStandard",
		 * StudStandard); int StreamID =
		 * Integer.parseInt(request.getParameter("studentStrID"));
		 * System.out.println(StreamID); model.addAttribute("StreamID",
		 * StreamID); int BranchID =
		 * Integer.parseInt(request.getParameter("studentBrID"));
		 * System.out.println(BranchID); model.addAttribute("BranchID",
		 * BranchID); int StandID =
		 * Integer.parseInt(request.getParameter("studentStandID"));
		 * System.out.println(StandID); model.addAttribute("StandID", StandID);
		 * 
		 * String StudAccountNumber = request.getParameter("AccoutNumbers");
		 * System.out.println(StudAccountNumber);
		 * model.addAttribute("StudAccountNumber", StudAccountNumber); String
		 * StudfatherMiddle = request.getParameter("FatherMidle");
		 * System.out.println(StudfatherMiddle);
		 * model.addAttribute("StudfatherMiddle", StudfatherMiddle); String
		 * StudSubCast = request.getParameter("SubCastStud");
		 * System.out.println(StudSubCast); model.addAttribute("StudSubCast",
		 * StudSubCast); String studMotherTogu =
		 * request.getParameter("studMotherTogu");
		 * System.out.println(studMotherTogu);
		 * model.addAttribute("studMotherTogu", studMotherTogu);
		 * 
		 * String studMotherName = request.getParameter("studMotherName");
		 * System.out.println(studMotherName);
		 * model.addAttribute("studMotherName", studMotherName);
		 * 
		 * String PlaceDOB = request.getParameter("PlaceDOB");
		 * System.out.println(PlaceDOB); model.addAttribute("PlaceDOB",
		 * PlaceDOB); String ResAddress = request.getParameter("ResAddress");
		 * System.out.println(ResAddress); request.setAttribute("ResAddress",
		 * ResAddress); model.addAttribute("ResAddress", ResAddress); String
		 * PerAddress = request.getParameter("PerAddress");
		 * System.out.println(PerAddress); request.setAttribute("PerAddress",
		 * PerAddress); model.addAttribute("PerAddress", PerAddress); String
		 * PinCode = request.getParameter("PinCode");
		 * System.out.println(PinCode); model.addAttribute("PinCode", PinCode);
		 * String studEmail = request.getParameter("studEmail");
		 * System.out.println(studEmail); model.addAttribute("studEmail",
		 * studEmail); String AdharNumber = request.getParameter("AdharNumber");
		 * System.out.println(AdharNumber); model.addAttribute("AdharNumber",
		 * AdharNumber); String IFScCode = request.getParameter("IFScCode");
		 * System.out.println(IFScCode); model.addAttribute("IFScCode",
		 * IFScCode);
		 * 
		 * String BankNamee = request.getParameter("BankNamee");
		 * System.out.println(BankNamee); model.addAttribute("BankNamee",
		 * BankNamee); String BranchNamme = request.getParameter("BranchNamme");
		 * System.out.println(BranchNamme); model.addAttribute("BranchNamme",
		 * BranchNamme); String AcaYearID = request.getParameter("AcaYearID");
		 * System.out.println(AcaYearID); model.addAttribute("AcaYearID",
		 * AcaYearID);
		 */
		/*
		 * studentAddmissionMasterInterface.UpdateStudentInformation(
		 * StudFirstName,StudLastName,StudGender,StudBranch,StudCast,
		 * StudCategory,StudContact,StudDOB,StudNationality,StudRelision,
		 * StudStandard,StudStream,fatherAccupation,fatherAddress,fatherContact,
		 * fatherIncome,fatherName,FatherEmail,StudentID,StreamID,StandID,
		 * BranchID);
		 * 
		 * List<String> ApprovedStudentList=new ArrayList<>();
		 * ApprovedStudentList=studentAddmissionMasterInterface.
		 * GetApprovedStudentList(); System.out.println(ApprovedStudentList);
		 * 
		 * model.addAttribute("ApprovedAddmissionList",ApprovedStudentList);
		 */

		HashMap<String, String> YearList;
		YearList = StudentAdmisssionInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		/* Student Register Information */
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		/*
		 * List<String> GetStudList=new ArrayList<>();
		 * GetStudList=registerStudentI.GetStudDetails(username);
		 * 
		 * model.addAttribute("StudInfo",GetStudList);
		 */

		/* Student Stream information */
		HashMap<String, String> streamList;
		streamList = StudentAdmisssionInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);

		return new ModelAndView("UpdateStudenInfo");
	}

	@RequestMapping(value = "updateStudentInformationDetails", params = "UpdateStudDetails")
	public ModelAndView updateStudentInformationDetails(HttpServletRequest request, Model model,
			@ModelAttribute("") StudentAdmissionModel studentAdmissionModel, HttpSession session) {
		System.out.println("Update Student Information Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);
		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			String studentsscname = request.getParameter("studentnamessc");
			System.out.println(studentsscname);

			String AddressTaluka = request.getParameter("AddressTaluka");
			System.out.println(AddressTaluka);

			String Addressdistrict = request.getParameter("Addressdistrict");
			System.out.println(Addressdistrict);

			String uniidnumber = request.getParameter("uniidnumber");
			System.out.println(uniidnumber);

			String studentHostel = request.getParameter("studentHostel");
			System.out.println(studentHostel);

			String studentLastYearscholarshipApplied = request.getParameter("studentLastYearscholarshipApplied");
			System.out.println(studentLastYearscholarshipApplied);

			String studentScholarshipsanctioned = request.getParameter("studentScholarshipsanctioned");
			System.out.println(studentScholarshipsanctioned);

			String studentIfYesAmountRs = request.getParameter("studentIfYesAmountRs");
			System.out.println(studentIfYesAmountRs);

			String studentPreviousschoolName = request.getParameter("studentPreviousschoolName");
			System.out.println(studentPreviousschoolName);

			String studentDomicileofMaharashtra = request.getParameter("studentDomicileofMaharashtra");
			System.out.println(studentDomicileofMaharashtra);

			String sscTotalMarks = request.getParameter("sscTotalMarks");
			System.out.println(sscTotalMarks);

			String sscOutOfMarks = request.getParameter("sscOutOfMarks");
			System.out.println(sscOutOfMarks);

			String sscXIIRegNo = request.getParameter("sscXIIRegNo");
			System.out.println(sscXIIRegNo);

			String hscTotalMarks = request.getParameter("hscTotalMarks");
			System.out.println(hscTotalMarks);

			String hscOutOfMarks = request.getParameter("hscOutOfMarks");
			System.out.println(hscOutOfMarks);

			String hscpcbpcm = request.getParameter("hscpcbpcm");
			System.out.println(hscpcbpcm);

			String hscPCMMarks = request.getParameter("hscPCMMarks");
			System.out.println(hscPCMMarks);

			/*
			 * String hscPCBMarks=request.getParameter("hscPCBMarks");
			 * System.out.println(hscPCBMarks);
			 */

			String hscPCMPCBTotalMarks = request.getParameter("hscPCMPCBTotalMarks");
			System.out.println(hscPCMPCBTotalMarks);

			String finbpharmTotalMarks = request.getParameter("finbpharmTotalMarks");
			System.out.println(finbpharmTotalMarks);

			String finbpharmOutOfMarks = request.getParameter("finbpharmOutOfMarks");
			System.out.println(finbpharmOutOfMarks);

			String finbpharmPercentage = request.getParameter("finbpharmPercentage");
			System.out.println(finbpharmPercentage);

			String tybpharmTotalMarks = request.getParameter("tybpharmTotalMarks");
			System.out.println(tybpharmTotalMarks);

			String tybpharmOutOfMarks = request.getParameter("tybpharmOutOfMarks");
			System.out.println(tybpharmOutOfMarks);

			String tybpharmPercentage = request.getParameter("tybpharmPercentage");
			System.out.println(tybpharmPercentage);

			String sybpharmTotalMarks = request.getParameter("sybpharmTotalMarks");
			System.out.println(sybpharmTotalMarks);

			String sybpharmOutOfMarks = request.getParameter("sybpharmOutOfMarks");
			System.out.println(sybpharmOutOfMarks);

			String sybpharmPercentage = request.getParameter("sybpharmPercentage");
			System.out.println(sybpharmPercentage);

			String fybpharmTotalMarks = request.getParameter("fybpharmTotalMarks");
			System.out.println(fybpharmTotalMarks);

			String fybpharmOutOfMarks = request.getParameter("fybpharmOutOfMarks");
			System.out.println(fybpharmOutOfMarks);

			String fybpharmPercentage = request.getParameter("fybpharmPercentage");
			System.out.println(fybpharmPercentage);

			String fatherEducationalQualification = request.getParameter("fatherEducationalQualification");
			System.out.println(fatherEducationalQualification);

			String fatherDesignation = request.getParameter("fatherDesignation");
			System.out.println(fatherDesignation);

			String fatherOrganization = request.getParameter("fatherOrganization");
			System.out.println(fatherOrganization);

			String fatherContactNumber = request.getParameter("fatherContactNumber");
			System.out.println(fatherContactNumber);

			String motherLastName = request.getParameter("motherLastName");
			System.out.println(motherLastName);

			String motherFirstName = request.getParameter("motherFirstName");
			System.out.println(motherFirstName);

			String mothermiddleName = request.getParameter("mothermiddleName");
			System.out.println(mothermiddleName);

			String motherEducationalQualification = request.getParameter("motherEducationalQualification");
			System.out.println(motherEducationalQualification);

			String motherOccupation = request.getParameter("motherOccupation");
			System.out.println(motherOccupation);

			String motherDesignation = request.getParameter("motherDesignation");
			System.out.println(motherDesignation);

			String motherMonthlyIncome = request.getParameter("motherMonthlyIncome");
			System.out.println(motherMonthlyIncome);

			String motherContactNumber = request.getParameter("motherContactNumber");
			System.out.println(motherContactNumber);

			String motherEmail = request.getParameter("motherEmail");
			System.out.println(motherEmail);

			String motherOrganization = request.getParameter("motherOrganization");
			System.out.println(motherOrganization);

			String studentChildNumber = request.getParameter("studentChildNumber");
			System.out.println(studentChildNumber);

			String studentBloodGroup = request.getParameter("studentBloodGroup");
			System.out.println(studentBloodGroup);

			String studentLastName = request.getParameter("studentLastName");
			System.out.println(studentLastName);

			String studentFirstName = request.getParameter("studentFirstName");
			System.out.println(studentFirstName);

			String studentMidddleName = request.getParameter("studentMiddleName");
			System.out.println(studentMidddleName);

			String MotherName = request.getParameter("studentMotherName");
			System.out.println(MotherName);

			String BirthDate = request.getParameter("studentDateOfBirth");
			System.out.println(BirthDate);

			String BirthPlace = request.getParameter("studentPlaceOfBirth");
			System.out.println(BirthPlace);

			String fatherLastName = request.getParameter("fatherLastName");
			System.out.println(fatherLastName);

			String fatherFirstName = request.getParameter("fatherFirstName");
			System.out.println(fatherFirstName);

			String fathermiddleName = request.getParameter("fathermiddleName");
			System.out.println(fathermiddleName);

			String FatherPermentAddress = request.getParameter("fatherPermananetAddress");
			System.out.println(FatherPermentAddress);

			String fatherOccupation = request.getParameter("fatherOccupation");
			System.out.println(fatherOccupation);

			String AnnualIncome = request.getParameter("fatherMonthlyIncome");
			System.out.println(AnnualIncome);

			String FatherMail = request.getParameter("fatherEmail");
			System.out.println(FatherMail);

			String StudentCast = request.getParameter("studentCast");
			System.out.println(StudentCast);

			/*
			 * String StudSubCast = request.getParameter("StudSubCast");
			 * System.out.println(StudSubCast);
			 * 
			 * String motherTongue = request.getParameter("motherTongue");
			 * System.out.println(motherTongue);
			 */

			String ResidentialAddress = request.getParameter("studentResidentialAddress");
			System.out.println(ResidentialAddress);

			String PermanentAddress = request.getParameter("studentPermanenetAddress");
			System.out.println(PermanentAddress);

			String pinCode = request.getParameter("studentPinCode");
			System.out.println(pinCode);

			String studentNationality = request.getParameter("studentNationality");
			System.out.println(studentNationality);

			/*
			 * String ContactNumber = request.getParameter("ContactNumber");
			 * System.out.println(ContactNumber);
			 */

			String ParentContactNumber = request.getParameter("ParentContactNumber");
			System.out.println(ParentContactNumber);

			/*
			 * String studentEmail = request.getParameter("studentEmail");
			 * System.out.println(studentEmail);
			 */

			int registrationID = Integer.parseInt(request.getParameter("admissionRegId"));
			System.out.println(registrationID);

			/*
			 * int YearID = Integer.parseInt(request.getParameter("YearName"));
			 * System.out.println(YearID);
			 * 
			 * int streamId =
			 * Integer.parseInt(request.getParameter("streamId"));
			 * System.out.println(streamId);
			 * 
			 * int branchId =
			 * Integer.parseInt(request.getParameter("branchId"));
			 * System.out.println(branchId);
			 * 
			 * int standardId =
			 * Integer.parseInt(request.getParameter("standardId"));
			 * System.out.println(standardId);
			 */

			String studentGender = request.getParameter("studentGender");
			System.out.println(studentGender);

			String StudReligion = request.getParameter("studentReligion");
			System.out.println(StudReligion);

			String StudCategory = request.getParameter("studentCategory");
			System.out.println(StudCategory);

			String AadharCardNumber = request.getParameter("aadharCardNumber");
			System.out.println(AadharCardNumber);

			String AccountNumber = request.getParameter("accountNumber");
			System.out.println(AccountNumber);

			String BankName = request.getParameter("bankName");
			System.out.println(BankName);

			String BranchName = request.getParameter("bankBranch");
			System.out.println(BranchName);

			String IFSCCode = request.getParameter("bankIFSCCode");
			System.out.println(IFSCCode);

			/* YearID, streamId,branchId,standardId, */

			studentAddmissionMasterInterface.updateStudentInformation(studentsscname, AddressTaluka, Addressdistrict,
					uniidnumber, studentHostel, studentLastYearscholarshipApplied, studentScholarshipsanctioned,
					studentIfYesAmountRs, studentPreviousschoolName, studentDomicileofMaharashtra, sscTotalMarks,
					sscOutOfMarks, sscXIIRegNo, hscTotalMarks, hscOutOfMarks, hscpcbpcm, hscPCMMarks,
					hscPCMPCBTotalMarks, finbpharmTotalMarks, finbpharmOutOfMarks, finbpharmPercentage,
					tybpharmTotalMarks, tybpharmOutOfMarks, tybpharmPercentage, sybpharmTotalMarks, sybpharmOutOfMarks,
					sybpharmPercentage, fybpharmTotalMarks, fybpharmOutOfMarks, fybpharmPercentage,
					fatherEducationalQualification, fatherDesignation, fatherOrganization, fatherContactNumber,
					motherLastName, motherFirstName, mothermiddleName, motherEducationalQualification, motherOccupation,
					motherDesignation, motherMonthlyIncome, motherContactNumber, motherEmail, motherOrganization,
					studentChildNumber, studentBloodGroup, studentLastName, studentFirstName, studentMidddleName,
					MotherName, BirthDate, BirthPlace, fatherLastName, fatherFirstName, fathermiddleName,
					FatherPermentAddress, fatherOccupation, AnnualIncome, FatherMail, StudentCast, ResidentialAddress,
					PermanentAddress, pinCode, ParentContactNumber, registrationID, studentGender, StudReligion,
					StudCategory, AadharCardNumber, AccountNumber, BankName, BranchName, IFSCCode, studentNationality);

			// studentAddmissionMasterInterface.updateStudentRegistrationDetails(studentFirstName,username);

			model.addAttribute("StudentUpdateMsg", "Student " + studentsscname + " Information Update Successfully...");

			List<String> ApprovedStudentList = new ArrayList<>();
			ApprovedStudentList = studentAddmissionMasterInterface.GetApprovedStudentList();
			System.out.println(ApprovedStudentList);

			model.addAttribute("ApprovedAddmissionList", ApprovedStudentList);
			return new ModelAndView("ApprovedAdmissionPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("CancelAdmission")
	public ModelAndView CancelAdmission(HttpServletRequest request, Model model,
			@ModelAttribute("") StudentAdmissionModel studentAdmissionModel, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Student Cancel Addmission");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> CancelStudentAdmissionList = new ArrayList<>();
			CancelStudentAdmissionList = studentAddmissionMasterInterface.GetCancelAdmissionList();
			System.out.println(CancelStudentAdmissionList);

			model.addAttribute("CancelAddmissionList", CancelStudentAdmissionList);

			if (CancelStudentAdmissionList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Not Cancel Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("CancelAdmissionPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("ApprovedIDCard")
	public ModelAndView ApproveIDCard(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approved ID Card");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> ApprovedIDCardList = new ArrayList<>();
			ApprovedIDCardList = approvedStudentIDCardServiceInterface.GetStudentIDCardList();
			System.out.println(ApprovedIDCardList);

			model.addAttribute("ApprovedIDCardList", ApprovedIDCardList);
			if (ApprovedIDCardList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Approve For IDCard Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("ApprovedIDCardPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("CanceledIDCard")
	public ModelAndView CanceledIDCard(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Display Cancel ID card List Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> CancelIDCardList = new ArrayList<>();
			CancelIDCardList = cancelStudentIDCardServiceInterface.CancelList();
			System.out.println(CancelIDCardList);

			model.addAttribute("CancelIDCardList", CancelIDCardList);
			if (CancelIDCardList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Cancel For ID Card Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("CanceledIDCardPage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("ApprovedBonafide")
	public ModelAndView ApproveBonafide(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approved Bonafied");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> ApprovedBonafideList = new ArrayList<>();
			ApprovedBonafideList = approvedBonafideServiceInterface.getApprovedBonafideList();
			System.out.println(ApprovedBonafideList);

			model.addAttribute("ApprovedBonafideList", ApprovedBonafideList);

			if (ApprovedBonafideList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Approved For Bonafide Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("ApprovedBonafidePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("CanceledBonafide")
	public ModelAndView CanceledBonafide(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Display Cancel CanceledBonafide List Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> CancelBonafideList = new ArrayList<>();
			CancelBonafideList = cancelStudentBonafideServiceInterface.CancelBonafideList();
			System.out.println(CancelBonafideList);

			model.addAttribute("CancelBonafideList", CancelBonafideList);

			if (CancelBonafideList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Cancel For Bonafide Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("CanceledBonafidePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("ApprovedLeavingCertificate")
	public ModelAndView ApproveLeavingCertificate(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Approved Leaving Certificate");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> ApprovedLeavingCertificateList = new ArrayList<>();
			ApprovedLeavingCertificateList = approvedLeavingCertificateServiceInterface.getApprovedLeavingList();
			System.out.println(ApprovedLeavingCertificateList);

			model.addAttribute("ApprovedLeavingCertificateList", ApprovedLeavingCertificateList);

			if (ApprovedLeavingCertificateList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Approved For Leaving Certificate Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("ApprovedLeavingCertificatePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("CanceledLeavingCertificate")
	public ModelAndView CanceledLeavingCertificate(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Display Cancel Canceled Leaving Certificate List Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = studentAddmissionMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> cancelLeavingCertificateList = new ArrayList<>();
			cancelLeavingCertificateList = cancelLeavingCertificateServiceInterface.cancelLeavingCertificateList();
			System.out.println(cancelLeavingCertificateList);

			model.addAttribute("cancelLeavingCertificateList", cancelLeavingCertificateList);

			if (cancelLeavingCertificateList.size() == 0) {
				model.addAttribute("NoApproved", "No Student Request Is Cancel For Leaving Certificate Yet...");
				return new ModelAndView("AccHome");
			} else {
				return new ModelAndView("CanceledLeavingCertificatePage");
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	public StudentAddmissionMasterinterface getStudentAddmissionMasterInterface() {
		return studentAddmissionMasterInterface;
	}

	public void setStudentAddmissionMasterInterface(StudentAddmissionMasterinterface studentAddmissionMasterInterface) {
		this.studentAddmissionMasterInterface = studentAddmissionMasterInterface;
	}

	public ApprovedStudentIDCardServiceInterface getApprovedStudentIDCardServiceInterface() {
		return approvedStudentIDCardServiceInterface;
	}

	public void setApprovedStudentIDCardServiceInterface(
			ApprovedStudentIDCardServiceInterface approvedStudentIDCardServiceInterface) {
		this.approvedStudentIDCardServiceInterface = approvedStudentIDCardServiceInterface;
	}

	public ApprovedBonafideServiceInterface getApprovedBonafideServiceInterface() {
		return approvedBonafideServiceInterface;
	}

	public void setApprovedBonafideServiceInterface(ApprovedBonafideServiceInterface approvedBonafideServiceInterface) {
		this.approvedBonafideServiceInterface = approvedBonafideServiceInterface;
	}

	public ApprovedLeavingCertificateServiceInterface getApprovedLeavingCertificateServiceInterface() {
		return approvedLeavingCertificateServiceInterface;
	}

	public void setApprovedLeavingCertificateServiceInterface(
			ApprovedLeavingCertificateServiceInterface approvedLeavingCertificateServiceInterface) {
		this.approvedLeavingCertificateServiceInterface = approvedLeavingCertificateServiceInterface;
	}

	public CancelStudentIDCardServiceInterface getCancelStudentIDCardServiceInterface() {
		return cancelStudentIDCardServiceInterface;
	}

	public void setCancelStudentIDCardServiceInterface(
			CancelStudentIDCardServiceInterface cancelStudentIDCardServiceInterface) {
		this.cancelStudentIDCardServiceInterface = cancelStudentIDCardServiceInterface;
	}

	public CancelStudentBonafideServiceInterface getCancelStudentBonafideServiceInterface() {
		return cancelStudentBonafideServiceInterface;
	}

	public void setCancelStudentBonafideServiceInterface(
			CancelStudentBonafideServiceInterface cancelStudentBonafideServiceInterface) {
		this.cancelStudentBonafideServiceInterface = cancelStudentBonafideServiceInterface;
	}

	public CancelLeavingCertificateServiceInterface getCancelLeavingCertificateServiceInterface() {
		return cancelLeavingCertificateServiceInterface;
	}

	public void setCancelLeavingCertificateServiceInterface(
			CancelLeavingCertificateServiceInterface cancelLeavingCertificateServiceInterface) {
		this.cancelLeavingCertificateServiceInterface = cancelLeavingCertificateServiceInterface;
	}

	public RegisterStudentI getRegisterStudentI() {
		return registerStudentI;
	}

	public void setRegisterStudentI(RegisterStudentI registerStudentI) {
		this.registerStudentI = registerStudentI;
	}
}
