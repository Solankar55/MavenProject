package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.daoInterface.BookLostStudentDaoInterface;
import com.library.model.LostBookStudent;
import com.library.serviceInterface.BookLostStudentServiceInterface;

@Service
public class BookLostStudentServiceClass implements BookLostStudentServiceInterface{

	@Autowired
	private BookLostStudentDaoInterface bookLostStudentDaoInterface;

	public BookLostStudentDaoInterface getBookLostStudentDaoInterface() {
		return bookLostStudentDaoInterface;
	}

	public void setBookLostStudentDaoInterface(BookLostStudentDaoInterface bookLostStudentDaoInterface) {
		this.bookLostStudentDaoInterface = bookLostStudentDaoInterface;
	}
	
	@Transactional
	@Override
	public void LostBookDataSave(String BookFor, String StudentName, int BookId, int StudentId) {
		// TODO Auto-generated method stub
		bookLostStudentDaoInterface.LostBookDataSave(BookFor, StudentName, BookId, StudentId);
	}

	@Transactional
	@Override
	public List<Object[]> getActiveyr() {
		// TODO Auto-generated method stub
		return bookLostStudentDaoInterface.activeYR();
	}

	@Transactional
	@Override
	public void SaveToDatabase(LostBookStudent lostBookStudent) {
		// TODO Auto-generated method stub
		bookLostStudentDaoInterface.SaveToDatabase(lostBookStudent);
	}

	@Transactional
	@Override
	public int getAccessionLibraryRegisterId(String BookId,String BookFor) {
		// TODO Auto-generated method stub
		return bookLostStudentDaoInterface.getAccessionLibraryRegisterId(BookId,BookFor);
	}

	@Transactional
	@Override
	public List checkStudentRegistrationIdAvailability(int studentRegId) {
		// TODO Auto-generated method stub
		return bookLostStudentDaoInterface.checkStudentRegistrationIdAvailability(studentRegId);
	}

	@Transactional
	@Override
	public void updateBookCollegeRemark(int accessionLibraryRegisterId) {
		// TODO Auto-generated method stub
		bookLostStudentDaoInterface.updateBookCollegeRemark(accessionLibraryRegisterId);
	}

	@Transactional
	@Override
	public List<String> getBookLostList() {
		// TODO Auto-generated method stub
		return bookLostStudentDaoInterface.getBookLostList();
	}

}
