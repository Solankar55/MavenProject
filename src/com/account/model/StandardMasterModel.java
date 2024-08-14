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
@Table (name="standardMaster")
public class StandardMasterModel {

	@Id
	@GeneratedValue
	private int standardId;
	private String standard;
	private String stdstatus="On";
	
	@ManyToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel ;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel ;
	
	@OneToMany(mappedBy="standardMasterModel",cascade=CascadeType.ALL)
	List<DivisionMasterModel> divisionMasterModel = new ArrayList<DivisionMasterModel>();

	
	@OneToOne(mappedBy="standardMasterModel")
	private AssignClassInchargeModel assignClassInchargeModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private RegisterNssStudentModel registerNssStudentModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private HODSubjectMasterModel hodSubjectMasterModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentAttendance studentAttendance;
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentAdmissionModel studentAdmissionModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentAssignmentModel studentAssignmentModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentNoticeModel studentNoticeModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentAttendanceNoticeModel studentAttendanceNoticeModel;
	
	@OneToOne(mappedBy="standardMasterModel")
	private ParentMessageModel parentMessageModel;
	
	@OneToMany(mappedBy="standardMasterModel")
	private List<RefundAmountModel> refundAmountModels=new ArrayList<RefundAmountModel>();
	
	@OneToOne(mappedBy="standardMasterModel")
	private StudentExamNoticeModel studentExamNoticeModel;
	
	
	@OneToOne(mappedBy="standardMasterModel")
	private ParentExamNoticeModel  parentExamNoticeModel;
	
	/*----------Getter And Setter ------*/
	
	public int getStandardId() {
		return standardId;
	}
	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}
	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}
	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}
	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
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
	public List<RefundAmountModel> getRefundAmountModels() {
		return refundAmountModels;
	}
	public void setParentMessageModel(ParentMessageModel parentMessageModel) {
		this.parentMessageModel = parentMessageModel;
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
	public String getStdstatus() {
		return stdstatus;
	}
	public void setStdstatus(String stdstatus) {
		this.stdstatus = stdstatus;
	}
	
	
	
}
