package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.VendorMasterModel;

public interface VenderMasterServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getVenderList();

	void submitVendor(VendorMasterModel vendorMasterModel);

	void updateVendor(VendorMasterModel vendorMasterModel);

	void deleteVendor(int id);

}
