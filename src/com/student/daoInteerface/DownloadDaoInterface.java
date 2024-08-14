package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface DownloadDaoInterface {

	List<StudentRegistrationModel> getStudInfo(String username);

	List<String> GetDetailInfo(String studName, String studCon);

	List<String> GetStudDetails(String username);

	List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon, String studEmail);

	int getFlagStud(int studID);

	void updateBonafideFlag(int studID);

	int getDownloadValue(int studID);

	List<String> getStudDetails(String studName, String studCon);

	int checkIDFlag(int studID);

	void updateIDCardFlag(int studentID);

	int checkLeavingCertificateFlag(int studID);

	List<String> GetStudentDetails(String studName, String studCon);

	void updateLeavingCertificateFlag(int studentID);

}
