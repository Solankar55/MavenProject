package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.LibraryHomeDaoInterface;
import com.library.serviceInterface.LibraryHomeServiceInterface;

@Service
@Transactional
public class LibraryHomeServiceClass implements LibraryHomeServiceInterface{

	@Autowired
	private LibraryHomeDaoInterface libraryHomeDaoInterface;

	public LibraryHomeDaoInterface getLibraryHomeDaoInterface() {
		return libraryHomeDaoInterface;
	}

	public void setLibraryHomeDaoInterface(LibraryHomeDaoInterface libraryHomeDaoInterface) {
		this.libraryHomeDaoInterface = libraryHomeDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return libraryHomeDaoInterface.checkAdmin( username);
	}
	
	
}
