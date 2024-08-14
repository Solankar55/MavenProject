package com.Department.serviceInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface DepartmentServiceInterface {

	List<String> checkStaff(String password, String username, String DepartmentName);

	List<StaffRegistrationModel> getEmailDetails(String emailAddress);

}
