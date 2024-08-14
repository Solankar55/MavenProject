package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentRegistrationModel;

public interface IDCardDaoInterface {

	List<StudentRegistrationModel> GetInfo(String username);

	List<String> GetStudDetails(String studName, String studCon, String studEmail);

	void SaveIDCardRequest(StudentIDCardRequestModel studentIDCardRequestModel);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getStudentID(String studName, String studCon, String studEmail);

	List<String> getCheackIDRequest(int studID);

}
