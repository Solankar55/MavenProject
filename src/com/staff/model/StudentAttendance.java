package com.staff.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.HOD.model.HODSubjectMasterModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;

@Entity
@Table(name="StudentAttendance")
public class StudentAttendance {

	@Id
	@GeneratedValue
	
	private int AttendanceID;
	private String CurrentDate;
	private String LectStartTimeDate;
	private String LectEndTimeDate;
	private int NumberOfLect;
	
	@OneToOne
	@JoinColumn(name="acadamicYearId")
	private acadamicYearModel acadamicYearModel;
	
	@OneToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel;
	
	@OneToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel;
	
	@OneToOne
	@JoinColumn(name="standardId")
	private StandardMasterModel standardMasterModel;
	
	@OneToOne
	@JoinColumn(name="SubjectID")
	private HODSubjectMasterModel hodSubjectMasterModel;

	@OneToMany(mappedBy="studentAttendance")
	private List<StudentEnteryOfAttendance> studentEnteryOfAttendances=new ArrayList<StudentEnteryOfAttendance>();
	
	
	public int getAttendanceID() {
		return AttendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		AttendanceID = attendanceID;
	}

	public String getCurrentDate() {
		return CurrentDate;
	}

	public void setCurrentDate(String currentDate) {
		CurrentDate = currentDate;
	}

	public String getLectStartTimeDate() {
		return LectStartTimeDate;
	}

	public void setLectStartTimeDate(String lectStartTimeDate) {
		LectStartTimeDate = lectStartTimeDate;
	}

	public String getLectEndTimeDate() {
		return LectEndTimeDate;
	}

	public void setLectEndTimeDate(String lectEndTimeDate) {
		LectEndTimeDate = lectEndTimeDate;
	}

	public int getNumberOfLect() {
		return NumberOfLect;
	}

	public void setNumberOfLect(int numberOfLect) {
		NumberOfLect = numberOfLect;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
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

	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}

	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public HODSubjectMasterModel getHodSubjectMasterModel() {
		return hodSubjectMasterModel;
	}

	public void setHodSubjectMasterModel(HODSubjectMasterModel hodSubjectMasterModel) {
		this.hodSubjectMasterModel = hodSubjectMasterModel;
	}

	public List<StudentEnteryOfAttendance> getStudentEnteryOfAttendances() {
		return studentEnteryOfAttendances;
	}

	public void setStudentEnteryOfAttendances(List<StudentEnteryOfAttendance> studentEnteryOfAttendances) {
		this.studentEnteryOfAttendances = studentEnteryOfAttendances;
	}
	
	
}
