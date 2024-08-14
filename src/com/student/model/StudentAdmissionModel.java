package com.student.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.StudentAttendanceNoticeStudentEnteryModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.Exam.model.ParentExamNoticeEnteryModel;
import com.Exam.model.StudentExamNoticeEnteryModel;
import com.account.model.BranchMasterModel;
import com.account.model.DivisionMasterModel;
import com.account.model.LedgerFeeMaster;
import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.account.model.discountModel;
import com.library.model.IssueAndReturnBookStudent;
import com.staff.model.StudentAssignmentEnteryReportModel;
import com.staff.model.StudentEnteryOfAttendance;

@Entity
@Table(name = "StudentAdmission")
public class StudentAdmissionModel {

	@Id
	@GeneratedValue

	private int admissionRegId;
	//private String acadamicYear;
	private String admissionDate;
	private String studentLastName;
	private String studentFirstName;
	private String studentMiddleName;
	private String studentMotherName;
	private String studentImage;
	private String studentGender;
	private String studentDateOfBirth;
	private String studentPlaceOfBirth;
	private String studentNationality;
	private String studentReligion;
	private String studentCategory;
	private String studentCast;
	private String studentSubCast;
	private String studentMotherTongue;
	private String studentResidentialAddress;
	private String studentPermanenetAddress;
	private String studentPinCode;
	private String studentContactNumber;
	private String studentParentContactNumber;
	private String studentEmail;
	private String fatherFirstName;
	private String fatherLastName;
	private String fatherPermananetAddress;
	private String fatherMonthlyIncome;
	private String fatherOccupation;
	private String fatherEmail;
	private String aadharCardNumber;
	private String accountNumber;
	private String bankName;
	private String bankBranch;
	private String bankIFSCCode;
	private String fathermiddleName;
	private String status="Pending";
	
	private int originalAcademicYearID;
	private int originalStandardID;
	private String studentBarcode;
	
	private String studentnamessc;
	private String AddressTaluka;
	private String Addressdistrict;
	private String uniidnumber;
	private String studentHostel;
	private String studentLastYearscholarshipApplied;
	private String studentScholarshipsanctioned;
	private String studentIfYesAmountRs;
	private String studentPreviousschoolName;
	private String studentDomicileofMaharashtra;
	
	private String sscTotalMarks;
	private String sscOutOfMarks;
	private String sscXIIRegNo;
	
	private String hscTotalMarks;
	private String hscOutOfMarks;
	private String hscpcbpcm;
	
	private String hscPCMMarks;
	private String hscPCBMarks;
	private String hscPCMPCBTotalMarks;
	
	private String finbpharmTotalMarks;
	private String finbpharmOutOfMarks;
	private String finbpharmPercentage;
	
	private String tybpharmTotalMarks;
	private String tybpharmOutOfMarks;
	private String tybpharmPercentage;
	
	private String sybpharmTotalMarks;
	private String sybpharmOutOfMarks;
	private String sybpharmPercentage;
	
	private String fybpharmTotalMarks;
	private String fybpharmOutOfMarks;
	private String fybpharmPercentage;
	
	private String fatherEducationalQualification;
	private String fatherDesignation;
	private String fatherOrganization;
	private String fatherContactNumber;
	
	private String motherLastName;
	private String motherFirstName;
	private String mothermiddleName;
	private String motherEducationalQualification;
	private String motherOccupation;
	private String motherDesignation;
	private String motherMonthlyIncome;
	private String motherContactNumber;
	private String motherEmail;
	private String motherOrganization;
	
	private String studentChildNumber;
	private String studentBloodGroup;
	
	private int lastadmissionid;
	
	@OneToOne
	@JoinColumn(name = "streamId")
	private StreamMasterModel streamMasterModel;

	@OneToOne
	@JoinColumn(name = "acadamicYearId")
	private acadamicYearModel acadamicYearModel;

	@OneToOne
	@JoinColumn(name = "divisionId")
	private DivisionMasterModel divisionMasterModel;

	@OneToOne
	@JoinColumn(name = "standardId")
	private StandardMasterModel standardMasterModel;

	@OneToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel;
	
	@OneToMany(mappedBy="studentAdmissionModel")
	private List<LedgerFeeMaster> ledgerFeeMaster=new ArrayList<LedgerFeeMaster>();

	@OneToMany(mappedBy="studentAdmissionModel")
	private List<LedgerFeePaidModel> ledgerFeePaidModel=new ArrayList<LedgerFeePaidModel>();

	@OneToMany(mappedBy="studentAdmissionModel")
	private List<discountModel> DiscountModel=new ArrayList<discountModel>();

	@OneToMany(mappedBy="studentAdmissionModel")
	private List<IssueAndReturnBookStudent> issueAndReturnBookStudent=new ArrayList<IssueAndReturnBookStudent>();
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentEnteryOfAttendance studentEnteryOfAttendance;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private ParentMessageEntryModel parentMessageEntryModel;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentProfilePicModel studentProfilePicModel;
	
	@OneToMany(mappedBy="studentAdmissionModel")
	private List<RefundAmountModel> refundAmountModel=new ArrayList<RefundAmountModel>();
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private StudentExamNoticeEnteryModel studentExamNoticeEnteryModel;
	
	@OneToOne(mappedBy="studentAdmissionModel")
	private ParentExamNoticeEnteryModel parentExamNoticeEnteryModel;
	
	@OneToMany(mappedBy="studentAdmissionModel")
	private List<StudentBarcodeMaster>  studentBarcodeMasters=new ArrayList<StudentBarcodeMaster>();
	
	/* Getter And Setter */

	public List<LedgerFeePaidModel> getLedgerFeePaidModel() {
		return ledgerFeePaidModel;
	}

	public void setLedgerFeePaidModel(List<LedgerFeePaidModel> ledgerFeePaidModel) {
		this.ledgerFeePaidModel = ledgerFeePaidModel;
	}

	public int getAdmissionRegId() {
		return admissionRegId;
	}

	public void setAdmissionRegId(int admissionRegId) {
		this.admissionRegId = admissionRegId;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentMiddleName() {
		return studentMiddleName;
	}

	public void setStudentMiddleName(String studentMiddleName) {
		this.studentMiddleName = studentMiddleName;
	}

	public String getStudentMotherName() {
		return studentMotherName;
	}

	public void setStudentMotherName(String studentMotherName) {
		this.studentMotherName = studentMotherName;
	}

	public String getStudentImage() {
		return studentImage;
	}

	public void setStudentImage(String studentImage) {
		this.studentImage = studentImage;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentDateOfBirth() {
		return studentDateOfBirth;
	}

	public void setStudentDateOfBirth(String studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}

	public String getStudentPlaceOfBirth() {
		return studentPlaceOfBirth;
	}

	public void setStudentPlaceOfBirth(String studentPlaceOfBirth) {
		this.studentPlaceOfBirth = studentPlaceOfBirth;
	}

	public String getStudentNationality() {
		return studentNationality;
	}

	public void setStudentNationality(String studentNationality) {
		this.studentNationality = studentNationality;
	}

	public String getStudentReligion() {
		return studentReligion;
	}

	public void setStudentReligion(String studentReligion) {
		this.studentReligion = studentReligion;
	}

	public String getStudentCategory() {
		return studentCategory;
	}

	public void setStudentCategory(String studentCategory) {
		this.studentCategory = studentCategory;
	}

	public String getStudentCast() {
		return studentCast;
	}

	public void setStudentCast(String studentCast) {
		this.studentCast = studentCast;
	}

	public String getStudentSubCast() {
		return studentSubCast;
	}

	public void setStudentSubCast(String studentSubCast) {
		this.studentSubCast = studentSubCast;
	}

	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}

	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}

	public DivisionMasterModel getDivisionMasterModel() {
		return divisionMasterModel;
	}

	public void setDivisionMasterModel(DivisionMasterModel divisionMasterModel) {
		this.divisionMasterModel = divisionMasterModel;
	}

	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}

	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public String getStudentMotherTongue() {
		return studentMotherTongue;
	}

	public void setStudentMotherTongue(String studentMotherTongue) {
		this.studentMotherTongue = studentMotherTongue;
	}

	public String getStudentResidentialAddress() {
		return studentResidentialAddress;
	}

	public void setStudentResidentialAddress(String studentResidentialAddress) {
		this.studentResidentialAddress = studentResidentialAddress;
	}

	public String getStudentPermanenetAddress() {
		return studentPermanenetAddress;
	}

	public void setStudentPermanenetAddress(String studentPermanenetAddress) {
		this.studentPermanenetAddress = studentPermanenetAddress;
	}

	public String getStudentPinCode() {
		return studentPinCode;
	}

	public void setStudentPinCode(String studentPinCode) {
		this.studentPinCode = studentPinCode;
	}

	public String getStudentContactNumber() {
		return studentContactNumber;
	}

	public void setStudentContactNumber(String studentContactNumber) {
		this.studentContactNumber = studentContactNumber;
	}

	public String getStudentParentContactNumber() {
		return studentParentContactNumber;
	}

	public void setStudentParentContactNumber(String studentParentContactNumber) {
		this.studentParentContactNumber = studentParentContactNumber;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getFatherPermananetAddress() {
		return fatherPermananetAddress;
	}

	public void setFatherPermananetAddress(String fatherPermananetAddress) {
		this.fatherPermananetAddress = fatherPermananetAddress;
	}

	public String getFatherMonthlyIncome() {
		return fatherMonthlyIncome;
	}

	public void setFatherMonthlyIncome(String fatherMonthlyIncome) {
		this.fatherMonthlyIncome = fatherMonthlyIncome;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getFatherEmail() {
		return fatherEmail;
	}

	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankIFSCCode() {
		return bankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}

	public String getFathermiddleName() {
		return fathermiddleName;
	}

	public void setFathermiddleName(String fathermiddleName) {
		this.fathermiddleName = fathermiddleName;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}

	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}

	public List<LedgerFeeMaster> getLedgerFeeMaster() {
		return ledgerFeeMaster;
	}

	public void setLedgerFeeMaster(List<LedgerFeeMaster> ledgerFeeMaster) {
		this.ledgerFeeMaster = ledgerFeeMaster;
	}

	public List<discountModel> getDiscountModel() {
		return DiscountModel;
	}

	public void setDiscountModel(List<discountModel> discountModel) {
		DiscountModel = discountModel;
	}

	public int getOriginalAcademicYearID() {
		return originalAcademicYearID;
	}

	public void setOriginalAcademicYearID(int originalAcademicYearID) {
		this.originalAcademicYearID = originalAcademicYearID;
	}


	public int getOriginalStandardID() {
		return originalStandardID;
	}

	public void setOriginalStandardID(int originalStandardID) {
		this.originalStandardID = originalStandardID;
	}

	public String getStudentBarcode() {
		return studentBarcode;
	}

	public void setStudentBarcode(String studentBarcode) {
		this.studentBarcode = studentBarcode;
	}

	public List<IssueAndReturnBookStudent> getIssueAndReturnBookStudent() {
		return issueAndReturnBookStudent;
	}

	public void setIssueAndReturnBookStudent(List<IssueAndReturnBookStudent> issueAndReturnBookStudent) {
		this.issueAndReturnBookStudent = issueAndReturnBookStudent;
	}

	public StudentEnteryOfAttendance getStudentEnteryOfAttendance() {
		return studentEnteryOfAttendance;
	}

	public void setStudentEnteryOfAttendance(StudentEnteryOfAttendance studentEnteryOfAttendance) {
		this.studentEnteryOfAttendance = studentEnteryOfAttendance;
	}

	public StudentAssignmentEnteryReportModel getStudentAssignmentEnteryReportModel() {
		return studentAssignmentEnteryReportModel;
	}

	public void setStudentAssignmentEnteryReportModel(
			StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel) {
		this.studentAssignmentEnteryReportModel = studentAssignmentEnteryReportModel;
	}

	public StudentNoticeStudentEnteryModel getStudentNoticeStudentEnteryModel() {
		return studentNoticeStudentEnteryModel;
	}

	public StudentAttendanceNoticeStudentEnteryModel getStudentAttendanceNoticeStudentEnteryModel() {
		return studentAttendanceNoticeStudentEnteryModel;
	}

	public ParentMessageEntryModel getParentMessageEntryModel() {
		return parentMessageEntryModel;
	}

	public void setStudentNoticeStudentEnteryModel(StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel) {
		this.studentNoticeStudentEnteryModel = studentNoticeStudentEnteryModel;
	}

	public void setStudentAttendanceNoticeStudentEnteryModel(
			StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel) {
		this.studentAttendanceNoticeStudentEnteryModel = studentAttendanceNoticeStudentEnteryModel;
	}

	public void setParentMessageEntryModel(ParentMessageEntryModel parentMessageEntryModel) {
		this.parentMessageEntryModel = parentMessageEntryModel;
	}

	public StudentProfilePicModel getStudentProfilePicModel() {
		return studentProfilePicModel;
	}

	public void setStudentProfilePicModel(StudentProfilePicModel studentProfilePicModel) {
		this.studentProfilePicModel = studentProfilePicModel;
	}

	public List<RefundAmountModel> getRefundAmountModel() {
		return refundAmountModel;
	}

	public void setRefundAmountModel(List<RefundAmountModel> refundAmountModel) {
		this.refundAmountModel = refundAmountModel;
	}

	public String getStudentnamessc() {
		return studentnamessc;
	}

	public String getAddressTaluka() {
		return AddressTaluka;
	}

	public String getAddressdistrict() {
		return Addressdistrict;
	}

	public String getUniidnumber() {
		return uniidnumber;
	}

	public String getStudentHostel() {
		return studentHostel;
	}

	public String getStudentLastYearscholarshipApplied() {
		return studentLastYearscholarshipApplied;
	}

	public String getStudentScholarshipsanctioned() {
		return studentScholarshipsanctioned;
	}

	public String getStudentIfYesAmountRs() {
		return studentIfYesAmountRs;
	}

	public String getStudentPreviousschoolName() {
		return studentPreviousschoolName;
	}

	public String getStudentDomicileofMaharashtra() {
		return studentDomicileofMaharashtra;
	}

	public String getSscTotalMarks() {
		return sscTotalMarks;
	}

	public String getSscOutOfMarks() {
		return sscOutOfMarks;
	}

	public String getSscXIIRegNo() {
		return sscXIIRegNo;
	}

	public String getHscTotalMarks() {
		return hscTotalMarks;
	}

	public String getHscOutOfMarks() {
		return hscOutOfMarks;
	}

	public String getHscpcbpcm() {
		return hscpcbpcm;
	}

	public String getHscPCMMarks() {
		return hscPCMMarks;
	}

	public String getHscPCBMarks() {
		return hscPCBMarks;
	}

	public String getHscPCMPCBTotalMarks() {
		return hscPCMPCBTotalMarks;
	}

	public String getFinbpharmTotalMarks() {
		return finbpharmTotalMarks;
	}

	public String getFinbpharmOutOfMarks() {
		return finbpharmOutOfMarks;
	}

	public String getFinbpharmPercentage() {
		return finbpharmPercentage;
	}

	public String getTybpharmTotalMarks() {
		return tybpharmTotalMarks;
	}

	public String getTybpharmOutOfMarks() {
		return tybpharmOutOfMarks;
	}

	public String getTybpharmPercentage() {
		return tybpharmPercentage;
	}

	public String getSybpharmTotalMarks() {
		return sybpharmTotalMarks;
	}

	public String getSybpharmOutOfMarks() {
		return sybpharmOutOfMarks;
	}

	public String getSybpharmPercentage() {
		return sybpharmPercentage;
	}

	public String getFybpharmTotalMarks() {
		return fybpharmTotalMarks;
	}

	public String getFybpharmOutOfMarks() {
		return fybpharmOutOfMarks;
	}

	public String getFybpharmPercentage() {
		return fybpharmPercentage;
	}

	public String getFatherEducationalQualification() {
		return fatherEducationalQualification;
	}

	public String getFatherDesignation() {
		return fatherDesignation;
	}

	public String getFatherOrganization() {
		return fatherOrganization;
	}

	public String getFatherContactNumber() {
		return fatherContactNumber;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public String getMothermiddleName() {
		return mothermiddleName;
	}

	public String getMotherEducationalQualification() {
		return motherEducationalQualification;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public String getMotherDesignation() {
		return motherDesignation;
	}

	public String getMotherMonthlyIncome() {
		return motherMonthlyIncome;
	}

	public String getMotherContactNumber() {
		return motherContactNumber;
	}

	public String getMotherEmail() {
		return motherEmail;
	}

	public String getMotherOrganization() {
		return motherOrganization;
	}

	public String getStudentChildNumber() {
		return studentChildNumber;
	}

	public String getStudentBloodGroup() {
		return studentBloodGroup;
	}

	public void setStudentnamessc(String studentnamessc) {
		this.studentnamessc = studentnamessc;
	}

	public void setAddressTaluka(String addressTaluka) {
		AddressTaluka = addressTaluka;
	}

	public void setAddressdistrict(String addressdistrict) {
		Addressdistrict = addressdistrict;
	}

	public void setUniidnumber(String uniidnumber) {
		this.uniidnumber = uniidnumber;
	}

	public void setStudentHostel(String studentHostel) {
		this.studentHostel = studentHostel;
	}

	public void setStudentLastYearscholarshipApplied(String studentLastYearscholarshipApplied) {
		this.studentLastYearscholarshipApplied = studentLastYearscholarshipApplied;
	}

	public void setStudentScholarshipsanctioned(String studentScholarshipsanctioned) {
		this.studentScholarshipsanctioned = studentScholarshipsanctioned;
	}

	public void setStudentIfYesAmountRs(String studentIfYesAmountRs) {
		this.studentIfYesAmountRs = studentIfYesAmountRs;
	}

	public void setStudentPreviousschoolName(String studentPreviousschoolName) {
		this.studentPreviousschoolName = studentPreviousschoolName;
	}

	public void setStudentDomicileofMaharashtra(String studentDomicileofMaharashtra) {
		this.studentDomicileofMaharashtra = studentDomicileofMaharashtra;
	}

	public void setSscTotalMarks(String sscTotalMarks) {
		this.sscTotalMarks = sscTotalMarks;
	}

	public void setSscOutOfMarks(String sscOutOfMarks) {
		this.sscOutOfMarks = sscOutOfMarks;
	}

	public void setSscXIIRegNo(String sscXIIRegNo) {
		this.sscXIIRegNo = sscXIIRegNo;
	}

	public void setHscTotalMarks(String hscTotalMarks) {
		this.hscTotalMarks = hscTotalMarks;
	}

	public void setHscOutOfMarks(String hscOutOfMarks) {
		this.hscOutOfMarks = hscOutOfMarks;
	}

	public void setHscpcbpcm(String hscpcbpcm) {
		this.hscpcbpcm = hscpcbpcm;
	}

	public void setHscPCMMarks(String hscPCMMarks) {
		this.hscPCMMarks = hscPCMMarks;
	}

	public void setHscPCBMarks(String hscPCBMarks) {
		this.hscPCBMarks = hscPCBMarks;
	}

	public void setHscPCMPCBTotalMarks(String hscPCMPCBTotalMarks) {
		this.hscPCMPCBTotalMarks = hscPCMPCBTotalMarks;
	}

	public void setFinbpharmTotalMarks(String finbpharmTotalMarks) {
		this.finbpharmTotalMarks = finbpharmTotalMarks;
	}

	public void setFinbpharmOutOfMarks(String finbpharmOutOfMarks) {
		this.finbpharmOutOfMarks = finbpharmOutOfMarks;
	}

	public void setFinbpharmPercentage(String finbpharmPercentage) {
		this.finbpharmPercentage = finbpharmPercentage;
	}

	public void setTybpharmTotalMarks(String tybpharmTotalMarks) {
		this.tybpharmTotalMarks = tybpharmTotalMarks;
	}

	public void setTybpharmOutOfMarks(String tybpharmOutOfMarks) {
		this.tybpharmOutOfMarks = tybpharmOutOfMarks;
	}

	public void setTybpharmPercentage(String tybpharmPercentage) {
		this.tybpharmPercentage = tybpharmPercentage;
	}

	public void setSybpharmTotalMarks(String sybpharmTotalMarks) {
		this.sybpharmTotalMarks = sybpharmTotalMarks;
	}

	public void setSybpharmOutOfMarks(String sybpharmOutOfMarks) {
		this.sybpharmOutOfMarks = sybpharmOutOfMarks;
	}

	public void setSybpharmPercentage(String sybpharmPercentage) {
		this.sybpharmPercentage = sybpharmPercentage;
	}

	public void setFybpharmTotalMarks(String fybpharmTotalMarks) {
		this.fybpharmTotalMarks = fybpharmTotalMarks;
	}

	public void setFybpharmOutOfMarks(String fybpharmOutOfMarks) {
		this.fybpharmOutOfMarks = fybpharmOutOfMarks;
	}

	public void setFybpharmPercentage(String fybpharmPercentage) {
		this.fybpharmPercentage = fybpharmPercentage;
	}

	public void setFatherEducationalQualification(String fatherEducationalQualification) {
		this.fatherEducationalQualification = fatherEducationalQualification;
	}

	public void setFatherDesignation(String fatherDesignation) {
		this.fatherDesignation = fatherDesignation;
	}

	public void setFatherOrganization(String fatherOrganization) {
		this.fatherOrganization = fatherOrganization;
	}

	public void setFatherContactNumber(String fatherContactNumber) {
		this.fatherContactNumber = fatherContactNumber;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	public void setMothermiddleName(String mothermiddleName) {
		this.mothermiddleName = mothermiddleName;
	}

	public void setMotherEducationalQualification(String motherEducationalQualification) {
		this.motherEducationalQualification = motherEducationalQualification;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public void setMotherDesignation(String motherDesignation) {
		this.motherDesignation = motherDesignation;
	}

	public void setMotherMonthlyIncome(String motherMonthlyIncome) {
		this.motherMonthlyIncome = motherMonthlyIncome;
	}

	public void setMotherContactNumber(String motherContactNumber) {
		this.motherContactNumber = motherContactNumber;
	}

	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}

	public void setMotherOrganization(String motherOrganization) {
		this.motherOrganization = motherOrganization;
	}

	public void setStudentChildNumber(String studentChildNumber) {
		this.studentChildNumber = studentChildNumber;
	}

	public void setStudentBloodGroup(String studentBloodGroup) {
		this.studentBloodGroup = studentBloodGroup;
	}

	public StudentExamNoticeEnteryModel getStudentExamNoticeEnteryModel() {
		return studentExamNoticeEnteryModel;
	}

	public void setStudentExamNoticeEnteryModel(StudentExamNoticeEnteryModel studentExamNoticeEnteryModel) {
		this.studentExamNoticeEnteryModel = studentExamNoticeEnteryModel;
	}

	public ParentExamNoticeEnteryModel getParentExamNoticeEnteryModel() {
		return parentExamNoticeEnteryModel;
	}

	public void setParentExamNoticeEnteryModel(ParentExamNoticeEnteryModel parentExamNoticeEnteryModel) {
		this.parentExamNoticeEnteryModel = parentExamNoticeEnteryModel;
	}

	public List<StudentBarcodeMaster> getStudentBarcodeMasters() {
		return studentBarcodeMasters;
	}

	public void setStudentBarcodeMasters(List<StudentBarcodeMaster> studentBarcodeMasters) {
		this.studentBarcodeMasters = studentBarcodeMasters;
	}

	public int getLastadmissionid() {
		return lastadmissionid;
	}

	public void setLastadmissionid(int lastadmissionid) {
		this.lastadmissionid = lastadmissionid;
	}

	
}
