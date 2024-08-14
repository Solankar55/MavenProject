package com.student.serviceInterface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentRegistrationModel;

public interface StudentBonafideRequestInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> GetDetailInfo(String studName, String studCon, String studEmail);

	void SaveRequest(StudentBonafideRequestModel studentBonafideRequestModel);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon, String studEmail);

	int GetBonafideCount(int studID);


}
