package com.account.daoInterface;

import java.util.List;

public interface ApproveStudentIDCardDaoInterface {

	List<String> GetRequestIDCardList();

	void TakeIDCardRequest(int studID);

	void cancelIDCard(int studID);

}
