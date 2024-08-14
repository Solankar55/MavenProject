package com.Alumini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Alumini.daoInterface.AluminiRegistrationDaoInterface;
import com.Alumini.model.RegisterAluminiDetailsModel;
import com.Alumini.serviceInterface.AluminiRegistrationserviceInterface;
import com.HOD.model.StaffRegistrationModel;

@Service
public class AluminiRegistrationservice implements AluminiRegistrationserviceInterface{

	@Autowired
	private AluminiRegistrationDaoInterface aluminiRegistrationDaoInterface;

	public AluminiRegistrationDaoInterface getAluminiRegistrationDaoInterface() {
		return aluminiRegistrationDaoInterface;
	}

	public void setAluminiRegistrationDaoInterface(AluminiRegistrationDaoInterface aluminiRegistrationDaoInterface) {
		this.aluminiRegistrationDaoInterface = aluminiRegistrationDaoInterface;
	}

	@Transactional
	@Override
	public void saveEnteredDetails(RegisterAluminiDetailsModel registerAluminiDetailsModel) {
		// TODO Auto-generated method stub
		aluminiRegistrationDaoInterface.saveEnteredDetails(registerAluminiDetailsModel);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return aluminiRegistrationDaoInterface.getStaffList(username);
	}
	
	
}
