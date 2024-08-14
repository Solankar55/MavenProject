package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BooksInDepartmenDaoInterface;
import com.library.serviceInterface.BooksInDepartmenServiceInterface;

@Service
@Transactional
public class BooksInDepartmenServiceClass implements BooksInDepartmenServiceInterface{

	@Autowired
	private BooksInDepartmenDaoInterface booksInDepartmenDaoInterface;

	public BooksInDepartmenDaoInterface getBooksInDepartmenDaoInterface() {
		return booksInDepartmenDaoInterface;
	}

	public void setBooksInDepartmenDaoInterface(BooksInDepartmenDaoInterface booksInDepartmenDaoInterface) {
		this.booksInDepartmenDaoInterface = booksInDepartmenDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return booksInDepartmenDaoInterface.checkAdmin(username);
	}

	@Override
	public HashMap<String, String> departmentList() {
		// TODO Auto-generated method stub
		return booksInDepartmenDaoInterface.departmentList();
	}

	@Override
	public List getListOfBooksInDepartment(String department) {
		// TODO Auto-generated method stub
		return booksInDepartmenDaoInterface.getListOfBooksInDepartment( department);
	}
	
	
}
