package com.account.serviceInterface;

import java.util.List;

public interface ApproveBonafideServiceInterface {

	List<String> GetRequestBonafide();

	void TakeBonafideRequest(int studID);

	void cancelBonafide(int studID);

}
