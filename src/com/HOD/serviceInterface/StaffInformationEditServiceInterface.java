package com.HOD.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface StaffInformationEditServiceInterface {

	List<String> getStaffInformation();

	void updateStaffInfo(int staffId, String staffName, String staffMb, String staffEmail, String staffQ, String staffD,
			String staffT, String barcode, String staffAdd, String staffExp);

	void deleteStaffInfo(int staffId);

	List<AdminRegistrationModel> CheckAdmin(String username);

}
