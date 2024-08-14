package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.LibrarySubjectMasterDaoInterface;
import com.library.model.LibrarySubjectMaster;
import com.library.serviceInterface.LibrarySubjectMasterServiceInterface;

@Service
@Transactional
public class LibrarySubjectMasterServiceClass implements LibrarySubjectMasterServiceInterface{

	@Autowired
	private LibrarySubjectMasterDaoInterface subjectMasterDaoInterface;

	public LibrarySubjectMasterDaoInterface getSubjectMasterDaoInterface() {
		return subjectMasterDaoInterface;
	}

	public void setSubjectMasterDaoInterface(LibrarySubjectMasterDaoInterface subjectMasterDaoInterface) {
		this.subjectMasterDaoInterface = subjectMasterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.checkAdmin( username);
	}

	@Override
	public List<LibrarySubjectMaster> librarySubjectSimpleList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.librarySubjectSimpleList();
	}

	@Override
	public void librarySubjectSave(LibrarySubjectMaster lsm) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.librarySubjectSave( lsm);
	}

	@Override
	public void updateLibraryData(int id, String subject) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.updateLibraryData( id,  subject);
	}

	@Override
	public void deleteLibraryData(int id) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.deleteLibraryData( id);
	}
	
	
}
