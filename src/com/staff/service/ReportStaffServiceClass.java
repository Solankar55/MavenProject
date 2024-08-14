package com.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.staff.daoInterface.ReportStaffDaoInterface;
import com.staff.serviceInterface.ReportStaffServiceInterface;

@Service
public class ReportStaffServiceClass implements ReportStaffServiceInterface{

	@Autowired
	private ReportStaffDaoInterface reportStaffDaoInterface;

	public ReportStaffDaoInterface getReportStaffDaoInterface() {
		return reportStaffDaoInterface;
	}

	public void setReportStaffDaoInterface(ReportStaffDaoInterface reportStaffDaoInterface) {
		this.reportStaffDaoInterface = reportStaffDaoInterface;
	}

	@Transactional
	@Override
	public List<HODSubjectMasterModel> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub
		return reportStaffDaoInterface.GetSubjectList(staffID);
	}

	@Transactional
	@Override
	public List<String> getStudentList(int subjectID) {
		// TODO Auto-generated method stub
		return reportStaffDaoInterface.getStudentList(subjectID);
	}

	@Transactional
	@Override
	public List<Object[]> getPresentStudentList(int subjectID) {
		// TODO Auto-generated method stub
		return reportStaffDaoInterface.getStudentD(subjectID);
	}

	@Transactional
	@Override
	public List<String> getStudentPresentList(Integer attendenceID, Integer yearID, Integer branchID,
			Integer standardID, Integer streamID) {
		// TODO Auto-generated method stub
		return reportStaffDaoInterface.getStudentPresentList(attendenceID, yearID,  branchID,
				 standardID,  streamID);
	}
	
}
