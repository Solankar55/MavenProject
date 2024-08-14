package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessibilityMaster;

public interface AccessibilityMasterDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> getYearList();

	List<AccessibilityMaster> accessibilityList();

	List<String> getValueList(int acyear, String category);

	void accessibilityDataSave(AccessibilityMaster am);

	void updateValues(int acyear, String category, int canI, int noDayR, int fCharge);

	List<String> getFeeData(int acYearID, String category);

	void updateAccessibilityData(int id, String category, int canissue, int returnindays, int fine);

}
