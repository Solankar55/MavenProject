package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.admin.model.AdminRegistrationModel;
import com.library.model.QuantityDataMaster;

public interface AccessionLibraryRegisterDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> getYearList();

	HashMap<String, String> librarySubjectList();

	HashMap<String, String> bookTypeList();

	HashMap getVendorName();

	List<String> venderDis(String id);

	void purchaseBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req);

	List<String> getpurchaseBookList();

	void updateBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req);

}
