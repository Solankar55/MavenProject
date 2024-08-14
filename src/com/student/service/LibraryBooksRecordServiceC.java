package com.student.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.LibraryBooksRecordDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.LibraryBooksRecordServiceInterface;

@Service
@Transactional
public class LibraryBooksRecordServiceC implements LibraryBooksRecordServiceInterface{

	@Autowired
	private LibraryBooksRecordDaoInterface libraryBooksRecordDaoInterface;

	@Override
	public HashMap<String, String> getBookSubList() {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookSubList();
	}

	@Override
	public HashMap<String, String> getBookTitleList() {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookTitleList();
	}

	@Override
	public HashMap<String, String> getBookAuthorList() {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookAuthourList();
	}

	@Override
	public List<String> getBookInfo(String bookName) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookInfo(bookName);
	}

	@Override
	public List<String> getBookSubInfo(String bookName,String bookfor) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookSubInfo(bookName,bookfor);
	}

	@Override
	public List<String> getBookAuthorInfo(String authorName) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookAuthorInfo(authorName);
	}

	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getStudInfo(username);
	}

	@Override
	public List<String> getBookPublisherInfo(String bookName) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getBookPublisherInfo(bookName);
	}

	@Override
	public List<StudentAdmissionModel> getStudAdmissionInfo(String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getStudAdmissionInfo(studCon,studEmail);
	}

	@Override
	public List<String> getStudDetails(String username1) {
		// TODO Auto-generated method stub
		return libraryBooksRecordDaoInterface.getStudDetails(username1);
	}

}
