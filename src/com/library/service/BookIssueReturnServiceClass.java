package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookIssueReturnDaoInterface;
import com.library.serviceInterface.BookIssueReturnServiceInterface;

@Service
@Transactional
public class BookIssueReturnServiceClass implements BookIssueReturnServiceInterface{

	@Autowired
	private BookIssueReturnDaoInterface bookIssueReturnDaoInterface;

	public BookIssueReturnDaoInterface getBookIssueReturnDaoInterface() {
		return bookIssueReturnDaoInterface;
	}

	public void setBookIssueReturnDaoInterface(BookIssueReturnDaoInterface bookIssueReturnDaoInterface) {
		this.bookIssueReturnDaoInterface = bookIssueReturnDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.checkAdmin(username);
	}

	@Override
	public HashMap<String, String> getMessageSt(String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getMessageSt(bookId);
	}

	@Override
	public List<String> getBookBarcodeInfo(String bookBarcode) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getBookBarcodeInfo(bookBarcode);
	}

	@Override
	public List<String> getStudentBarcodeInfo(String studentBarcode) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getStudentBarcodeInfo(studentBarcode);
	}

	@Override
	public List<String> getStaffDetails(String staffBarcode) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getStaffDetails(staffBarcode);
	}

	@Override
	public String getActiveyr() {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getActiveyr();
	}

	@Override
	public int getalrIdforPG(String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getAlrIdforPG(bookId);
	}

	@Override
	public List<String> GetbookIssure(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getbookIssure( alrID,  studentId,  readerId,  bookId);
	}

	@Override
	public String getDetails(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getDetails( alrID,  studentId,  readerId,  bookId);
	}

	@Override
	public int getalrIdforDegree(String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getalrIdforDegree(bookId);
	}

	@Override
	public int getalrIdforDiploma(String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getalrIdforDiploma( bookId);
	}

	@Override
	public int getalrIdforOther(String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getalrIdforOther( bookId);
	}

	@Override
	public void issueBookToLecturerPostDegree(int alrID, String readerId, String bookId, int staffID) {
		// TODO Auto-generated method stub
		bookIssueReturnDaoInterface.issueBookToLecturerPostDegree( alrID,  readerId,  bookId,  staffID);
	}

	@Override
	public String getDetailsStaff(int alrID, int staffID, String readerId, String bookId) {
		// TODO Auto-generated method stub
		return bookIssueReturnDaoInterface.getDetailsStaff( alrID,  staffID,  readerId,  bookId);
	}

	@Override
	public void issueBookToLecturerDegree(int alrID, String readerId, String bookId, int staffID) {
		// TODO Auto-generated method stub
		bookIssueReturnDaoInterface.issueBookToLecturerDegree( alrID,  readerId,  bookId,  staffID);
	}
	
	
}
