package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentRegistrationModel;

public interface StudentBonafideDeoInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> getDetailInfo(String studName, String studCon, String studEmail);

	void SaveRequest(StudentBonafideRequestModel studentBonafideRequestModel);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getStudInfoOfRequest(String studName, String studCon, String emailstud);

	int getBonafideCount(int studID);


}
