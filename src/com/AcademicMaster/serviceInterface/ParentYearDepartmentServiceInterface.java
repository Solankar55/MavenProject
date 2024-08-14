package com.AcademicMaster.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.ParentMessageModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

public interface ParentYearDepartmentServiceInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	HashMap<String, String> getYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchid);

	List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID);

	void saveParentMessageModel(ParentMessageModel parentMessageModel);

	int getMaxParentID();

	void saveParentMessageEntryModel(ParentMessageEntryModel parentMessageEntryModel);

	List<StudentAdmissionModel> getStudentContactN(int studID);

}
