package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.admin.model.AdminRegistrationModel;
import com.library.model.QuantityDataMaster;

public interface AccessionLibraryRegisterServiceInterface {

	List<AdminRegistrationModel> CheckAdmin(String username);

	HashMap<String, String> GetYearList();

	HashMap<String, String> librarySubjectList();

	HashMap<String, String> BookTypeList();

	HashMap getvendorName();

	List<String> vendorDis(String id);

	void purchaseBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req);

	List<String> getpurchaseBookList();

	void updateBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req);

}
