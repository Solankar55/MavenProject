package com.staff.serviceInterface;

import java.util.List;

import com.HOD.model.HODSubjectMasterModel;

public interface AssignmentManagementServiceInterface {

	List<String> getGivenAssignMentList(String subjectName);

	List<String> getRemoveAssignmentList(String subjectName);

	String deleteAssignment(int assid);

	List<HODSubjectMasterModel> GetSubjectList(int staffID);

	List<String> getGivenAssignMentListToRemove(String subjectName);

}
