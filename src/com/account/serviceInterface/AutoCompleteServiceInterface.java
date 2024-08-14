package com.account.serviceInterface;

import java.util.List;

public interface AutoCompleteServiceInterface {

	List<String> serchStudentName(String keyword);

	List<String> getStudentAllDataForPayment(String studentName);

}
