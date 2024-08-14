package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookInformationDaoInterface;
import com.library.serviceInterface.BookInformationServiceInterface;

@Service
@Transactional
public class BookInformationServiceClass  implements BookInformationServiceInterface{

	@Autowired
	private BookInformationDaoInterface bookInformationDaoInterface;

	public BookInformationDaoInterface getBookInformationDaoInterface() {
		return bookInformationDaoInterface;
	}

	public void setBookInformationDaoInterface(BookInformationDaoInterface bookInformationDaoInterface) {
		this.bookInformationDaoInterface = bookInformationDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.checkAdmin(username);
	}

	@Override
	public List<String> searchSubject(String parameter) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.searchSubject( parameter);
	}

	@Override
	public List<String> searchTitle(String parameter) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.searchTitle( parameter);
	}

	@Override
	public List<String> searchAuthor(String parameter) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.searchAuthor( parameter);
	}

	@Override
	public List<String> getSubjectWiseList(String subjectName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getSubjectWiseList( subjectName);
	}

	@Override
	public List<String> getTitleWiseList(String titleName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getTitleWiseList(titleName);
	}

	@Override
	public List<String> getAuthorWiseList(String authorName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getAuthorWiseList( authorName);
	}

	@Override
	public List<String> getBookSubTitleInfo(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getBookSubTitleInfo( subName,  titleName,  authorName);
	}

	@Override
	public List<String> getBookSubAuthorInfo(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getBookSubAuthorInfo( subName,  titleName,  authorName);
	}

	@Override
	public List<String> getBookTitleAuthorList(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getBookTitleAuthorList( subName,  titleName,  authorName);
	}

	@Override
	public List<String> getBookList(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		return bookInformationDaoInterface.getBookList( subName,  titleName,  authorName) ;
	}
	
	
}
