package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@Table(name="streamMaster")
public class StreamMasterModel {

	@Id
	@GeneratedValue
	private int streamId;
	private String streamName;
	private String strstatus="On";
	
	@OneToMany(mappedBy="streamMasterModel",cascade=CascadeType.ALL)
	List<BranchMasterModel> branchMasterModel = new ArrayList<BranchMasterModel>();

	@OneToMany(mappedBy="streamMasterModel",cascade=CascadeType.ALL)
	List<StandardMasterModel> standardMasterModel = new ArrayList<StandardMasterModel>();
	
	@OneToMany(mappedBy="streamMasterModel",cascade=CascadeType.ALL)
	List<DivisionMasterModel> divisionMasterModel = new ArrayList<DivisionMasterModel>();

	@OneToMany(mappedBy="streamMasterModel",cascade=CascadeType.ALL)
	private List<RefundAmountModel> refundAmountModel=new ArrayList<RefundAmountModel>();
	
	@OneToOne(mappedBy="streamMasterModel")
	private AssignClassInchargeModel assignClassInchargeModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private RegisterNssStudentModel registerNssStudentModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private HODSubjectMasterModel hodSubjectMasterModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentAttendance studentAttendance;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentAdmissionModel studentAdmissionModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentAssignmentModel studentAssignmentModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentNoticeModel studentNoticeModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentAttendanceNoticeModel studentAttendanceNoticeModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private ParentMessageModel parentMessageModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private StudentExamNoticeModel studentExamNoticeModel;
	
	@OneToOne(mappedBy="streamMasterModel")
	private ParentExamNoticeModel parentExamNoticeModel;
	
	/*gettere and setter */
	
	public int getStreamId() {
		return streamId;
	}
	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}
	public String getStreamName() {
		return streamName;
	}
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}
	public List<BranchMasterModel> getBranchMasterModel() {
		return branchMasterModel;
	}
	public void setBranchMasterModel(List<BranchMasterModel> branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
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
	public List<RefundAmountModel> getRefundAmountModel() {
		return refundAmountModel;
	}
	public void setRefundAmountModel(List<RefundAmountModel> refundAmountModel) {
		this.refundAmountModel = refundAmountModel;
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
	public String getStrstatus() {
		return strstatus;
	}
	public void setStrstatus(String strstatus) {
		this.strstatus = strstatus;
	}
	
}
