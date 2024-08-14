package com.Department.daoInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface DepartmentDaoInterface {

	List<String> checkDepartmentLogin(String password, String username, String departmentName);

	List<StaffRegistrationModel> getEmailDetails(String emailAddress);

}
