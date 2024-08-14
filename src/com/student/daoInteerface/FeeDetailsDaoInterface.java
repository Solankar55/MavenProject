package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface FeeDetailsDaoInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<Object[]> getCheckStudInfo(String studName, String studCon, String studEmail);

	List<String> getFeeDetails(int studentID, int yearID, int streamID, int branchID, int standardID);

	List<String> GetStudDetails(String username);

}
