package com.library.daoInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.VendorMasterModel;

public interface VenderMasterDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getVenderList();

	void submitVendor(VendorMasterModel vendorMasterModel);

	void updateVendor(VendorMasterModel vendorMasterModel);

	void deleteVendor(int id);

}
