package com.NSS.daoInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface NSSApproveDaoInterface {

	List<String> GetNSSStudentList();

	void updateStudentStatus(String boxValue, String currentDate);

	List<String> GetNSSStudentListDisApproved();

	void updateStudentStatusDisApproved(String boxValue,String currentDate);

	List<String> GetNSSStudentListApproved();

	List<String> GetNSSStudentDisApprovedList();

	List<StaffRegistrationModel> getStaffInfo(String username);

}
