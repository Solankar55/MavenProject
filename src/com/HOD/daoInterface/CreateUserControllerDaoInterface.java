package com.HOD.daoInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.admin.model.AdminRegistrationModel;

public interface CreateUserControllerDaoInterface {

	void saveStaff(StaffRegistrationModel staffRegistrationModel);

	int getStaffID();

	List<AdminRegistrationModel> checkAdmin(String username);

}
