package com.AcademicMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AcademicMaster.daoInterface.AcademicYearReportDaoInterface;
import com.AcademicMaster.serviceInterface.AcademicYearReportServiceInterface;

@Service
public class AcademicYearReportServiceClass implements AcademicYearReportServiceInterface{

	@Autowired
	private AcademicYearReportDaoInterface academicYearReportDaoInterface;

	public AcademicYearReportDaoInterface getAcademicYearReportDaoInterface() {
		return academicYearReportDaoInterface;
	}

	public void setAcademicYearReportDaoInterface(AcademicYearReportDaoInterface academicYearReportDaoInterface) {
		this.academicYearReportDaoInterface = academicYearReportDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStudentNoticeList() {
		// TODO Auto-generated method stub
		return academicYearReportDaoInterface.getStudentNoticeList();
	}

	@Transactional
	@Override
	public List<String> getAttendenceNoticeList() {
		// TODO Auto-generated method stub
		return academicYearReportDaoInterface.getAttendenceNoticeList();
	}

	@Transactional
	@Override
	public List<String> getStaffNoticeList() {
		// TODO Auto-generated method stub
		return academicYearReportDaoInterface.getStaffNoticeList();
	}

	@Transactional
	@Override
	public List<String> getStaffProgramNoticeList() {
		// TODO Auto-generated method stub
		return academicYearReportDaoInterface.getStaffProgramNoticeList();
	}

	@Transactional
	@Override
	public List<String> getParentNoticeList() {
		// TODO Auto-generated method stub
		return academicYearReportDaoInterface.getParentNoticeList();
	}
	
	
}
