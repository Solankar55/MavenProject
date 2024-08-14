package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.daoInterface.BookHolderDaoInterface;
import com.library.serviceInterface.BookHolderServiceInterface;

@Service
@Transactional
public class BookHolderServiceClass implements BookHolderServiceInterface{

	@Autowired
	private BookHolderDaoInterface bookHolderDaoInterface;

	public BookHolderDaoInterface getBookHolderDaoInterface() {
		return bookHolderDaoInterface;
	}

	public void setBookHolderDaoInterface(BookHolderDaoInterface bookHolderDaoInterface) {
		this.bookHolderDaoInterface = bookHolderDaoInterface;
	}

	@Override
	public List<String> getBookHolder(String holder) {
		// TODO Auto-generated method stub
		return bookHolderDaoInterface.getBookHolder(holder);
	}

	@Override
	public List<String> getHOdlerStaff(String holder) {
		// TODO Auto-generated method stub
		return bookHolderDaoInterface.getHolderStaff(holder);
	}
	
	
}
