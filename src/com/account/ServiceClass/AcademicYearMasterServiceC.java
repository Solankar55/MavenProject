package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.AcademicYearMasterDaoInterface;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.AcademicYearMasterServiceInterface;
@Service
public class AcademicYearMasterServiceC implements AcademicYearMasterServiceInterface {

	@Autowired
	private AcademicYearMasterDaoInterface academicYearMasterDaoInterface;

	public AcademicYearMasterDaoInterface getAcademicYearMasterDaoInterface() {
		return academicYearMasterDaoInterface;
	}

	public void setAcademicYearMasterDaoInterface(AcademicYearMasterDaoInterface academicYearMasterDaoInterface) {
		this.academicYearMasterDaoInterface = academicYearMasterDaoInterface;
	}

	@Transactional
	@Override
	public void SaveYear(acadamicYearModel acadamicYearModel) {
		// TODO Auto-generated method stub
		academicYearMasterDaoInterface.saveYear(acadamicYearModel);
	}

	@Transactional
	@Override
	public List<String> GetAcademicYearList() {
		// TODO Auto-generated method stub
		return academicYearMasterDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public void UpadteYear(int yearId, String year) {
		// TODO Auto-generated method stub
		academicYearMasterDaoInterface.UpdateYear(yearId,year);
	}

	@Transactional
	@Override
	public void DeleteYear(int yearId) {
		// TODO Auto-generated method stub
		academicYearMasterDaoInterface.DeleteYear(yearId);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetAcademicYearListKeyValue() {
		// TODO Auto-generated method stub
		return academicYearMasterDaoInterface.GetAcademicYearListKeyValue();
	}

	@Transactional
	@Override
	public void setActiveYear(int yearID) {
		// TODO Auto-generated method stub
		academicYearMasterDaoInterface.setActiveYear(yearID);
	}

	@Transactional
	@Override
	public List<String> ActiveYearList() {
		// TODO Auto-generated method stub
		return academicYearMasterDaoInterface.ActiveYearList();
	}
	
}
