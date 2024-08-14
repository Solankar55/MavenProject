package com.Alumini.daoInterface;

import java.util.List;

import com.Alumini.model.RegisterAluminiDetailsModel;
import com.HOD.model.StaffRegistrationModel;

public interface AluminiRegistrationDaoInterface {

	void saveEnteredDetails(RegisterAluminiDetailsModel registerAluminiDetailsModel);

	List<StaffRegistrationModel> getStaffList(String username);

}
