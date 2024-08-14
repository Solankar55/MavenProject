package com.HOD.serviceInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.admin.model.AdminRegistrationModel;

public interface CreateUserControllerServiceInterface {

	void saveStaff(StaffRegistrationModel staffRegistrationModel);

	int getStaffRegID();

	List<AdminRegistrationModel> CheckAdmin(String username);

}
