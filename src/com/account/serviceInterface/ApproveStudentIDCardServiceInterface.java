package com.account.serviceInterface;

import java.util.List;

public interface ApproveStudentIDCardServiceInterface {

	List<String> GetRequestListIDCard();

	void TakeIDCardRequest(int studID);

	void cancelIDCrard(int studID);

}
