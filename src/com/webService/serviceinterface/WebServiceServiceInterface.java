package com.webService.serviceinterface;

import java.util.List;

public interface WebServiceServiceInterface {

	List<String> getYearList();

	List<String> getStreamList();

	List<String> getBranchList(int streamID);

	List<String> getStandardList(int branchID);

	List<String> getStudentList(int yearID, int streamID, int branchID, int standardID);

	List<String> getUserAuthenticationCheck(String userName, String passWord);


}
