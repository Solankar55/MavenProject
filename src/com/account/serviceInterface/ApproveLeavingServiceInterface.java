package com.account.serviceInterface;

import java.util.List;

import com.account.model.LedgerFeePaidModel;

public interface ApproveLeavingServiceInterface {

	List<String> GetRequestLeaving();

	void TakeLeavingRequest(int studID, String conduct, String dateOfLeaving, String reasonOfLeaving, String remark);

	void cancelLeaving(int studID);

	List<LedgerFeePaidModel> getStudentPendingFee(int yearID1, int standardID1, int streamID1, int branchID1,
			int studID);

	void updateStudentStatus(int studID, String conduct, String dateOfLeaving, String reasonOfLeaving, String remark);


}
