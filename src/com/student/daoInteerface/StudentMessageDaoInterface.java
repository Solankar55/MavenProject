package com.student.daoInteerface;

import java.util.List;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

public interface StudentMessageDaoInterface {

	List<Object[]> getStudDetailsToCheckPresentOrNot(String studName, String studContact,
			String studEmail);

	List<String> getNoticeDetails(int studID, String studStatus, int studYear, int studBranch, int studStandard,
			int studStream);

	List<StudentRegistrationModel> CheckStudent(String username);

	List<String> GetStudDetails(String username1);

	List<StudentRegistrationModel> getStudInfo(String userName);

	List<Object[]> getStudDetailList(String sName, String sContact, String sEmail);

	List<String> getAttendenceNoticeDetail(Integer studID, Integer studYear, String studStatus, Integer studBranch,
			Integer studStandard, Integer studStream);

	List<String> getAssignmentDetails(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream);

	List<String> getExamNoticeList(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream);


}
