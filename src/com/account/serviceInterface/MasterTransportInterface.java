package com.account.serviceInterface;

import java.util.List;

import com.account.model.TransportMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface MasterTransportInterface {

	void TransportMgmt(TransportMasterModel transportMasterModel);

	List<TransportMasterModel> fetchMasterTransport();

	void UpdateTransportCharges(int transID, String transCharge);

	void DeleteTransportCharges(int transID);

	List<AdminRegistrationModel> CheckAdmin(String username);

}
