package com.account.daoInterface;

import java.util.List;

public interface AutoCompleteDaoInterface {

	List<String> serchStudentName(String keyword);

	List<String> getStudentAllDataForPayment(String studentName);

}
