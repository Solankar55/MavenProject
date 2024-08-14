package com.staff.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;

public interface StaffClassInChargeDaoInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	List<String> CheckClassInchargeOrNot(int staffID);

	HashMap<String, String> GetYearList(int staffID);

	HashMap<String, String> GetStreamList(int staffID);

	HashMap<String, String> GetBranchlist(int staffID);

	HashMap<String, String> GetStandardList(int staffID);

	List<String> getStudentList(int yearID, int streamID, int branchID, int standardID);

	List<Object[]> getPresentClassInchargeDetails(int staffID);

	List<String> getStudentAbsentList(Integer yearID, Integer streamID, Integer branchID, Integer standardID);

	List<String> getStudentPresentList(Integer yearID, Integer branchID, Integer standardID, Integer streamID);

}
