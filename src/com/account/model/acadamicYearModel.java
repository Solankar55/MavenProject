package com.account.model;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Query;

import com.AcademicMaster.model.ParentMessageModel;
import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeModel;
import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.NSS.model.RegisterNssStudentModel;
import com.library.model.AccessibilityMaster;
import com.library.model.AccessionLibraryRegister;
import com.staff.model.StudentAssignmentModel;
import com.staff.model.StudentAttendance;
import com.student.model.StudentAdmissionModel;


@Entity
@Table(name="AcadamicYear")
public class acadamicYearModel {

	@Id
	@GeneratedValue
	
	private int acadamicYearId;
	private String acadamicYear;
	private String ActiveAcadamicYr="Inactive";
	private String UserName;
	private String astatus="On";
	
	public String getActiveAcadamicYr() {
		return ActiveAcadamicYr;
	}
	public void setActiveAcadamicYr(String activeAcadamicYr) {
		ActiveAcadamicYr = activeAcadamicYr;
	}
		
	@OneToOne(mappedBy="acadamicYearModel")
	private AssignClassInchargeModel assignClassInchargeModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private RegisterNssStudentModel registerNssStudentModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private HODSubjectMasterModel hodSubjectMasterModel;
	
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentAttendance studentAttendance;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentAdmissionModel studentAdmissionModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentAssignmentModel studentAssignmentModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentNoticeModel studentNoticeModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentAttendanceNoticeModel studentAttendanceNoticeModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private ParentMessageModel parentMessageModel;
	
	/*@OneToOne(mappedBy="acadamicYearModel")
	private AccessibilityMaster accessibilityMaster;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private AccessionLibraryRegister accessionLibraryRegister;*/
	
	@OneToMany(mappedBy="acadamicYearModel")
	private List<RefundAmountModel> refundAmountModels=new ArrayList<RefundAmountModel>();
	
	@OneToOne(mappedBy="acadamicYearModel")
	private StudentExamNoticeModel studentExamNoticeModel;
	
	@OneToOne(mappedBy="acadamicYearModel")
	private ParentExamNoticeModel parentExamNoticeModel;
	
	/*@OneToMany(mappedBy="AcadamicYearModel")
	private List<LedgerFeePaidModel> ledgerFeePaidModel=new ArrayList<LedgerFeePaidModel>();
*/
	/*Getter And Setter */
	public int getAcadamicYearId() {
		return acadamicYearId;
	}
	public void setAcadamicYearId(int acadamicYearId) {
		this.acadamicYearId = acadamicYearId;
	}
	public String getAcadamicYear() {
		return acadamicYear;
	}
	public void setAcadamicYear(String acadamicYear) {
		this.acadamicYear = acadamicYear;
	}
	public AssignClassInchargeModel getAssignClassInchargeModel() {
		return assignClassInchargeModel;
	}
	public void setAssignClassInchargeModel(AssignClassInchargeModel assignClassInchargeModel) {
		this.assignClassInchargeModel = assignClassInchargeModel;
	}
	public RegisterNssStudentModel getRegisterNssStudentModel() {
		return registerNssStudentModel;
	}
	public void setRegisterNssStudentModel(RegisterNssStudentModel registerNssStudentModel) {
		this.registerNssStudentModel = registerNssStudentModel;
	}
	public AssignSubjectTeacherModel getAssignSubjectTeacherModel() {
		return assignSubjectTeacherModel;
	}
	public void setAssignSubjectTeacherModel(AssignSubjectTeacherModel assignSubjectTeacherModel) {
		this.assignSubjectTeacherModel = assignSubjectTeacherModel;
	}
	public HODSubjectMasterModel getHodSubjectMasterModel() {
		return hodSubjectMasterModel;
	}
	public void setHodSubjectMasterModel(HODSubjectMasterModel hodSubjectMasterModel) {
		this.hodSubjectMasterModel = hodSubjectMasterModel;
	}
	public StudentAttendance getStudentAttendance() {
		return studentAttendance;
	}
	public void setStudentAttendance(StudentAttendance studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}
	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	public StudentAssignmentModel getStudentAssignmentModel() {
		return studentAssignmentModel;
	}
	public void setStudentAssignmentModel(StudentAssignmentModel studentAssignmentModel) {
		this.studentAssignmentModel = studentAssignmentModel;
	}
	public StudentNoticeModel getStudentNoticeModel() {
		return studentNoticeModel;
	}
	public void setStudentNoticeModel(StudentNoticeModel studentNoticeModel) {
		this.studentNoticeModel = studentNoticeModel;
	}
	
	public StudentAttendanceNoticeModel getStudentAttendanceNoticeModel() {
		return studentAttendanceNoticeModel;
	}
	public void setStudentAttendanceNoticeModel(StudentAttendanceNoticeModel studentAttendanceNoticeModel) {
		this.studentAttendanceNoticeModel = studentAttendanceNoticeModel;
	}
	public ParentMessageModel getParentMessageModel() {
		return parentMessageModel;
	}
	public void setParentMessageModel(ParentMessageModel parentMessageModel) {
		this.parentMessageModel = parentMessageModel;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public List<RefundAmountModel> getRefundAmountModels() {
		return refundAmountModels;
	}
	public void setRefundAmountModels(List<RefundAmountModel> refundAmountModels) {
		this.refundAmountModels = refundAmountModels;
	}
	public StudentExamNoticeModel getStudentExamNoticeModel() {
		return studentExamNoticeModel;
	}
	public void setStudentExamNoticeModel(StudentExamNoticeModel studentExamNoticeModel) {
		this.studentExamNoticeModel = studentExamNoticeModel;
	}
	public ParentExamNoticeModel getParentExamNoticeModel() {
		return parentExamNoticeModel;
	}
	public void setParentExamNoticeModel(ParentExamNoticeModel parentExamNoticeModel) {
		this.parentExamNoticeModel = parentExamNoticeModel;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	
	
}
