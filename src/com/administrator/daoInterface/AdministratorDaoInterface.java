package com.administrator.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface AdministratorDaoInterface {

	void saveNewAuthorisedUser(AdminRegistrationModel adminRegistrationModel);

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardlist(int branchid);

	List<String> getStandardWiseReport(int yearId, int streamid, int branchid, int standardID);

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getUserNameCheck(String userName);

}
