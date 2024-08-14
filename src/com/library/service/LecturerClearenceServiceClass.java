package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.daoInterface.LecturerClearenceDaoInterface;
import com.library.serviceInterface.LecturerClearenceServiceInterface;

@Service
@Transactional
public class LecturerClearenceServiceClass implements LecturerClearenceServiceInterface{

	@Autowired
	private LecturerClearenceDaoInterface lecturerClearenceDaoInterface;

	public LecturerClearenceDaoInterface getLecturerClearenceDaoInterface() {
		return lecturerClearenceDaoInterface;
	}

	public void setLecturerClearenceDaoInterface(LecturerClearenceDaoInterface lecturerClearenceDaoInterface) {
		this.lecturerClearenceDaoInterface = lecturerClearenceDaoInterface;
	}

	@Override
	public HashMap<String, String> getAcadamicYear() {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getAcadamicYear();
	}

	@Override
	public String getYearbyID(String selectedYr) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getYearbyID( selectedYr);
	}

	@Override
	public List<String> getFinedetails(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getFinedetails( dateone,  datetwo,  studId);
	}

	@Override
	public int gettotalfine(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.gettotalfine( dateone,  datetwo,  studId);
	}

	@Override
	public List<String> getLostbookdetails(String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getLostbookdetails( studId);
	}

	@Override
	public Double getLostTotal(String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getLostTotal( studId);
	}

	@Override
	public List<String> getNotReturnDetails(String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getNotReturnDetails( studId);
	}

	@Override
	public Double getFineForNotReturn(String studId) {
		// TODO Auto-generated method stub
		return lecturerClearenceDaoInterface.getFineForNotReturn( studId);
	}
	
	
}
