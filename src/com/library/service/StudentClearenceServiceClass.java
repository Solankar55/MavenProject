package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.daoInterface.StudentClearenceDaoInterface;
import com.library.serviceInterface.StudentClearenceServiceInterface;

@Service
@Transactional
public class StudentClearenceServiceClass implements StudentClearenceServiceInterface{

	@Autowired
	private StudentClearenceDaoInterface studentClearenceDaoInterface;

	public StudentClearenceDaoInterface getStudentClearenceDaoInterface() {
		return studentClearenceDaoInterface;
	}

	public void setStudentClearenceDaoInterface(StudentClearenceDaoInterface studentClearenceDaoInterface) {
		this.studentClearenceDaoInterface = studentClearenceDaoInterface;
	}

	@Override
	public HashMap<String, String> getAcadamicYear() {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getAcadamicYear();
	}

	@Override
	public String getYearbyID(String selectedYr) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getYearID(selectedYr);
	}

	@Override
	public List<String> getFinedetailStud(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getFinedetailStud( dateone,  datetwo,  studId);
	}

	@Override
	public int gettotalfine(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.gettotalfine( dateone,  datetwo,  studId);
	}

	@Override
	public List<String> getLostbookdetails(String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getLostbookdetails( studId);
	}

	@Override
	public Double getLostTotal(String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getLostTotal( studId);
	}

	@Override
	public List<String> getNotReturnDetails(String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getNotReturnDetails( studId);
	}

	@Override
	public Double getFineForNotReturn(String studId) {
		// TODO Auto-generated method stub
		return studentClearenceDaoInterface.getFineForNotReturn( studId);
	}
	
	
}
