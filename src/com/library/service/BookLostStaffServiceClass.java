package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.daoInterface.BookLostStaffDaoInterface;
import com.library.model.LostBookStaff;
import com.library.serviceInterface.BookLostStaffServiceInterface;

@Service
@Transactional
public class BookLostStaffServiceClass implements BookLostStaffServiceInterface{

	@Autowired
	private BookLostStaffDaoInterface bookLostStaffDaoInterface;

	public BookLostStaffDaoInterface getBookLostStaffDaoInterface() {
		return bookLostStaffDaoInterface;
	}

	public void setBookLostStaffDaoInterface(BookLostStaffDaoInterface bookLostStaffDaoInterface) {
		this.bookLostStaffDaoInterface = bookLostStaffDaoInterface;
	}

	@Override
	public List<String> getLostStaffBookList() {
		// TODO Auto-generated method stub
		return bookLostStaffDaoInterface.getLostStaffBookList();
	}

	@Override
	public List<Object[]> activeYR() {
		// TODO Auto-generated method stub
		return bookLostStaffDaoInterface.activeYR();
	}

	@Override
	public List checkStaffRegistrationIdAvailability(int staffId) {
		// TODO Auto-generated method stub
		return bookLostStaffDaoInterface.checkStaffRegistrationIdAvailability( staffId);
	}

	@Override
	public void SaveToDatabase(LostBookStaff lostBookStaff) {
		// TODO Auto-generated method stub
		bookLostStaffDaoInterface.saveToDatabase(lostBookStaff);
	}

	@Override
	public void updateBookCollegeRemark(int accessionLibraryRegisterId) {
		// TODO Auto-generated method stub
		bookLostStaffDaoInterface.updateBookCollegeRemark(accessionLibraryRegisterId);
	}

	@Override
	public int getAccessionLibraryRegisterId(String bookId, String bookFor) {
		// TODO Auto-generated method stub
		return bookLostStaffDaoInterface.getAccesssionLibraryRegisterId(bookId,bookFor);
	}
	
	
}
