package com.administrator.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface AdministratorServiceInterface {

	void RegAuthorisedUser(AdminRegistrationModel adminRegistrationModel);

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchid);

	List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID);

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getUserNameCheck(String userName);

}
