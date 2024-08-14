package com.TAP.daoInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface TAPReportDaoInterface {

	List<String> getStudentTapDetails();

	List<StaffRegistrationModel> getStaffList(String username);

}
