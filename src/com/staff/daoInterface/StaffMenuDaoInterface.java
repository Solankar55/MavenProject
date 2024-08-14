package com.staff.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.staff.model.StudentAttendance;
import com.staff.model.StudentEnteryOfAttendance;

public interface StaffMenuDaoInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	List<String> getCheckAvabality(int staffID);

	List<String> CheckClassInchargeOrNot(int staffID);

	HashMap<String, String> GetYearList(int staffID);

	HashMap<String, String> GetStreamList(int staffID);

	HashMap<String, String> GetBranchlist(int staffID);

	HashMap<String, String> GetStandardList(int staffID);

	HashMap<String, String> GetSubjectList(int staffID);

	List<String> GetStudentList(int yearID, int streamID, int branchID, int standardID, int subjectID);

	int getMaxStudentAttendanceID();

	void saveSubjectVisStudentAttendance(StudentAttendance studentAttendance);

	void saveStudentAttendanceBySubjectVis(StudentEnteryOfAttendance studentEnteryOfAttendance);

	
	List<String> getSubjectListStaff(int yearID, int streamID, int branchID, int standardID);

	List<Object[]> getStudentListForAtt(int yrId, int streamId, int branchId, int standId, int subId);

	List gettotalNoOFLect(int yrId, int streamId, int branchId, int standId, int subId);

	
}
