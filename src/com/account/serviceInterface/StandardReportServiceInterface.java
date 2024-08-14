package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface StandardReportServiceInterface {

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchid);

	List<String> getStandardWiseList(int streanID, int branchID, int standardID, int yearId);

	HashMap<String, String> GetYearList();

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getRefundAmtDetailList();

	HashMap<String, String> getYearListFee();

	HashMap<String, String> getStreamListFee();

	List<String> getBranchListFee(int id);

	List<String> getStandardListFee(int branchid);

	List<String> getPendingFee(int yearId, int streamid, int branchid, int standardID);

	List<String> getCompletedFee(int yearId, int streamid, int branchid, int standardID);

	List<String> getStudentTransactionReport(String studentName);


}
