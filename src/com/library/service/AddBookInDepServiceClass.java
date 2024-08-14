package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AddBookInDepDaoInterface;
import com.library.model.BookInDepartment;
import com.library.serviceInterface.AddBookInDepServiceInterface;

@Service
@Transactional
public class AddBookInDepServiceClass implements AddBookInDepServiceInterface{

	@Autowired
	private AddBookInDepDaoInterface addBookInDepDaoInterface;

	public AddBookInDepDaoInterface getAddBookInDepDaoInterface() {
		return addBookInDepDaoInterface;
	}

	public void setAddBookInDepDaoInterface(AddBookInDepDaoInterface addBookInDepDaoInterface) {
		this.addBookInDepDaoInterface = addBookInDepDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.checkAdmin(username);
	}

	@Override
	public HashMap<String, String> departmentList() {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.departmentList();
	}

	@Override
	public List<BookInDepartment> getBookInDeptList() {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.getBookInDeptList();
	}

	@Override
	public int getAccId(String accerId) {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.getAccId( accerId);
	}

	@Override
	public void saveBookInDepartment(BookInDepartment bookInDepartment) {
		// TODO Auto-generated method stub
		addBookInDepDaoInterface.saveBookInDepartment( bookInDepartment);
	}

	@Override
	public int getDeptId(String department) {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.getDeptId( department);
	}

	@Override
	public int getAccIdUpdate(String accerId) {
		// TODO Auto-generated method stub
		return addBookInDepDaoInterface.getAccIdUpdate( accerId);
	}

	@Override
	public void updateDepartmentData1(BookInDepartment bookInDepartment) {
		// TODO Auto-generated method stub
		addBookInDepDaoInterface.updateDepartmentData1( bookInDepartment);
	}

	@Override
	public void deleteBookFromDepartment(int bookInDepId,String bookName,String departmentName) {
		// TODO Auto-generated method stub
		addBookInDepDaoInterface.deleteBookFromDepartment( bookInDepId,bookName,departmentName);
	}
	
	
}
