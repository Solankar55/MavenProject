package com.Alumini.serviceInterface;

import java.util.List;

import com.Alumini.model.RegisterAluminiDetailsModel;
import com.HOD.model.StaffRegistrationModel;

public interface AluminiRegistrationserviceInterface {

	void saveEnteredDetails(RegisterAluminiDetailsModel registerAluminiDetailsModel);

	List<StaffRegistrationModel> getStaffList(String username);

}
