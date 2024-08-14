package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface StandardReportDaoInterface {

	HashMap<String, String> GetStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	List<String> GetStandardWiseList(int yearId, int streamId, int branchID, int StandardId);

	HashMap<String, String> GetYearList();

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getRefundAmtDetailList();

	HashMap<String, String> getYearListFee();

	HashMap<String, String> getStreamListFee();

	List<String> getBranchListFee(int id);

	List<String> getStandardListFee(int branchid);

	List<String> getPendingFee(int yearId, int streamid, int branchid, int standardID);

	List<String> getCompletedFee(int yearId, int streamid, int branchid, int standardID);

	List<String> getStudentTransactionReport(String studentName);


}
