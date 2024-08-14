package com.webService.daoInterface;

import java.util.List;

public interface WebServiceDaoInterface {

	List<String> getYearList();

	List<String> getStreamList();

	List<String> getBranchList(int streamID);

	List<String> getStandardList(int branchID);

	List<String> getStudentList(int yearID, int streamID, int branchID, int standardID);

	List<String> getUserAutheticationCheck(String userName, String passWord);

}
