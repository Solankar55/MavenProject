package com.account.daoInterface;

import java.util.List;

import com.account.model.LedgerFeePaidModel;

public interface ApproveLeavingDaoInterface {

	List<String> getLeavingList();

	void TakeLeaving(int studID, String conduct, String dateOfLeaving, String reasonOfLeaving, String remark);

	void cancelLeaving(int studID);

	List<LedgerFeePaidModel> getStudentPendingFee(int yearID1, int standardID1, int streamID1, int branchID1,
			int studID);

	void updateStudentStatus(int studID, String conduct, String dateOfLeaving, String reasonOfLeaving, String remark);

}
