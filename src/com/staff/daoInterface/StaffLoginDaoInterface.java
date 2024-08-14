package com.staff.daoInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface StaffLoginDaoInterface {

	List<StaffRegistrationModel> GetStaffList(String userName, String passWord);

	List<StaffRegistrationModel> getEmailDetails(String userEmail);

}
