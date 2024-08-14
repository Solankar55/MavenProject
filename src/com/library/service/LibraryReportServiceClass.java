package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.LibraryReportDaoInterface;
import com.library.serviceInterface.LibraryReportServiceInterface;

@Service
@Transactional
public class LibraryReportServiceClass implements LibraryReportServiceInterface{

	@Autowired
	private LibraryReportDaoInterface libraryReportDaoInterface;

	public LibraryReportDaoInterface getLibraryReportDaoInterface() {
		return libraryReportDaoInterface;
	}

	public void setLibraryReportDaoInterface(LibraryReportDaoInterface libraryReportDaoInterface) {
		this.libraryReportDaoInterface = libraryReportDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.checkAdmin(username);
	}

	@Override
	public List<String> getInvoice(int invoiceno) {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getInvoice(invoiceno);
	}

	@Override
	public HashMap<String, String> librarySubjectList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.librarySubjectList();
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getYearList();
	}

	@Override
	public List<String> getBookBankData() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getBookBankData();
	}

	@Override
	public HashMap<String, String> bookTypeList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.bookTypeList();
	}

	@Override
	public HashMap getvendorName() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getvendorName();
	}

	@Override
	public HashMap getacademicYearList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getacademicYearList();
	}

	@Override
	public HashMap getBookType() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getBookType();
	}

	@Override
	public List getPublicationList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getPublicationList();
	}

	@Override
	public List getTitleList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getTitleList();
	}

	@Override
	public List getAuthorList() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getAuthorList();
	}

	@Override
	public List<String> getStaffIssueReturnData() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getStaffIssueReturnData();
	}

	@Override
	public List<String> getStudentIssueReturnData() {
		// TODO Auto-generated method stub
		return libraryReportDaoInterface.getStudentIssueReturnData();
	}
	
	
}
