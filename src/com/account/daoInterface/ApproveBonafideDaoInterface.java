package com.account.daoInterface;

import java.util.List;

public interface ApproveBonafideDaoInterface {

	List<String> getRequestBonafideList();

	void TakeBonafideRequest(int studID);

	void CancelBonafide(int studID);

}
