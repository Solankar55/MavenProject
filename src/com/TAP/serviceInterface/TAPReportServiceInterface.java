package com.TAP.serviceInterface;

import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface TAPReportServiceInterface {

	List<String> getStudentTapDetails();

	List<StaffRegistrationModel> getStaffList(String username);

}
