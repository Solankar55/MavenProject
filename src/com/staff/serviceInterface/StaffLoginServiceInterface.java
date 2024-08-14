package com.staff.serviceInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface StaffLoginServiceInterface {

	List<StaffRegistrationModel> getStaffList(String userName, String passWord);

	List<StaffRegistrationModel> getEmailDetails(String userEmail);

}
