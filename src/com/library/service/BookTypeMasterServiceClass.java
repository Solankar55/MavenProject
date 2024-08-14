package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookTypeMasterDaoInterface;
import com.library.model.BookTypeMaster;
import com.library.serviceInterface.BookTypeMasterServiceInterface;

@Service
@Transactional
public class BookTypeMasterServiceClass implements BookTypeMasterServiceInterface{

	@Autowired
	private BookTypeMasterDaoInterface bookTypeMasterDaoInterface;

	public BookTypeMasterDaoInterface getBookTypeMasterDaoInterface() {
		return bookTypeMasterDaoInterface;
	}

	public void setBookTypeMasterDaoInterface(BookTypeMasterDaoInterface bookTypeMasterDaoInterface) {
		this.bookTypeMasterDaoInterface = bookTypeMasterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return bookTypeMasterDaoInterface.checkAdmin(username);
	}

	@Override
	public List<BookTypeMaster> bookTypeSimpleList() {
		// TODO Auto-generated method stub
		return bookTypeMasterDaoInterface.bookTypeSimpleList();
	}

	@Override
	public void bookSave(BookTypeMaster book) {
		// TODO Auto-generated method stub
		bookTypeMasterDaoInterface.saveBookType(book);
	}

	@Override
	public void UpdateBookTypeData(int id, String bookType) {
		// TODO Auto-generated method stub
		bookTypeMasterDaoInterface.updateBookTypeData(id,bookType);
	}

	@Override
	public void deleteBookTypeData(int id) {
		// TODO Auto-generated method stub
		bookTypeMasterDaoInterface.deleteBookTypeData( id);
	}
	
	
}
