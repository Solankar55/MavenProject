package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AcademicMasterLibraryDaoInterface;
import com.library.model.LibraryAcademicYearModel;
import com.library.serviceInterface.AcademicMasterLibraryServiceInterface;

@Service
@Transactional
public class AcademicMasterLibraryServiceClass implements AcademicMasterLibraryServiceInterface{

	@Autowired
	private AcademicMasterLibraryDaoInterface academicMasterLibraryDaoInterface;

	public AcademicMasterLibraryDaoInterface getAcademicMasterLibraryDaoInterface() {
		return academicMasterLibraryDaoInterface;
	}

	public void setAcademicMasterLibraryDaoInterface(AcademicMasterLibraryDaoInterface academicMasterLibraryDaoInterface) {
		this.academicMasterLibraryDaoInterface = academicMasterLibraryDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return academicMasterLibraryDaoInterface.checkAdmin( username);
	}

	@Override
	public List<String> getYearList() {
		// TODO Auto-generated method stub
		return academicMasterLibraryDaoInterface.getYearList();
	}

	@Override
	public void saveLabAcademicMaster(LibraryAcademicYearModel libraryAcademicYearModel) {
		// TODO Auto-generated method stub
		academicMasterLibraryDaoInterface.saveLabAcademicMaster(libraryAcademicYearModel);
	}

	@Override
	public void updateYearOfLibrary(int yearId, String yearLab) {
		// TODO Auto-generated method stub
		academicMasterLibraryDaoInterface.updateYearOfLibrary( yearId,  yearLab);
	}

	@Override
	public void deleteYearOfLibrary(int yearId) {
		// TODO Auto-generated method stub
		academicMasterLibraryDaoInterface.deleteYearOfLibrary( yearId);
	}
	
	
}
