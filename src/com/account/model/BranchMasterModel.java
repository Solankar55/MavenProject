package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.AcademicMaster.model.ParentMessageModel;
import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeModel;
import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.NSS.model.RegisterNssStudentModel;
import com.staff.model.StudentAssignmentModel;
import com.staff.model.StudentAttendance;
import com.student.model.StudentAdmissionModel;



@Entity
@Table(name="branchMaster")
public class BranchMasterModel {
	
	@Id
	@GeneratedValue
	private int branchId;	
	private String branchName;
	private String bstatus="On";


	@ManyToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel ;
	
	@OneToMany(mappedBy="branchMasterModel",cascade=CascadeType.ALL)
	List<StandardMasterModel> standardMasterModel = new ArrayList<StandardMasterModel>();
	
	
	@OneToMany(mappedBy="branchMasterModel",cascade=CascadeType.ALL)
	List<DivisionMasterModel> divisionMasterModel = new ArrayList<DivisionMasterModel>();

	@OneToOne(mappedBy="branchMasterModel")
	private AssignClassInchargeModel assignClassInchargeModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private RegisterNssStudentModel registerNssStudentModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private HODSubjectMasterModel hodSubjectMasterModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentAttendance studentAttendance;
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentAdmissionModel studentAdmissionModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentAssignmentModel studentAssignmentModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentNoticeModel studentNoticeModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentAttendanceNoticeModel studentAttendanceNoticeModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private ParentMessageModel parentMessageModel;
	
	@OneToMany(mappedBy="branchMasterModel")
	private List<RefundAmountModel> refundAmountModels=new ArrayList<RefundAmountModel>();
	
	
	@OneToOne(mappedBy="branchMasterModel")
	private StudentExamNoticeModel studentExamNoticeModel;
	
	@OneToOne(mappedBy="branchMasterModel")
	private ParentExamNoticeModel parentExamNoticeModel;
	
	
	/*----------Getter And Setter ------*/
	
	
	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}

	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}

	public List<StandardMasterModel> getStandardMasterModel() {
		return standardMasterModel;
	}

	public void setStandardMasterModel(List<StandardMasterModel> standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public List<DivisionMasterModel> getDivisionMasterModel() {
		return divisionMasterModel;
	}

	public void setDivisionMasterModel(List<DivisionMasterModel> divisionMasterModel) {
		this.divisionMasterModel = divisionMasterModel;
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

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	
	

}
