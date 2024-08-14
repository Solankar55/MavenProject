package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookBankDaoInterface;
import com.library.serviceInterface.BookBankServiceInterface;

@Service
@Transactional
public class BookBankServiceClass implements BookBankServiceInterface{

	@Autowired
	private BookBankDaoInterface bookBankDaoInterface;

	public BookBankDaoInterface getBookBankDaoInterface() {
		return bookBankDaoInterface;
	}

	public void setBookBankDaoInterface(BookBankDaoInterface bookBankDaoInterface) {
		this.bookBankDaoInterface = bookBankDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.checkAdmin(username);
	}

	@Override
	public HashMap<String, String> getMessageSt(String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getMessageSt(bookId);
	}

	@Override
	public List<String> getStudentList(String studentId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getStudentList(studentId);
	}

	@Override
	public List<String> getStudentBookBankList(String studbarcode) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getStudentBookBankList(studbarcode);
	}

	@Override
	public String getActiveyr() {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getActiveyr();
	}

	@Override
	public int getMaxAlrID() {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getMaxAlrID() ;
	}

	@Override
	public int getalrIdforPostDegree(String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getalrIdforPostDegree( bookId);
	}

	@Override
	public List<String> getbookIssure(int alrid, int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getbookIssure( alrid,  alrID,  studentId,  readerId,  bookId);
	}

	@Override
	public String getDetails(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getDetails( alrID,  studentId,  readerId,  bookId);
	}

	@Override
	public int getalrIdforDegree(String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getalrIdforDegree( bookId);
	}

	@Override
	public int getalrIdforDiploma(String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getalrIdforDiploma( bookId);
	}

	@Override
	public int getalrIdforOther(String bookId) {
		// TODO Auto-generated method stub
		return bookBankDaoInterface.getalrIdforOther( bookId);
	}
	
	
}
