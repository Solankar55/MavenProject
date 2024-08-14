package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.CancelLeavingCertificateDaoInterface;
import com.account.serviceInterface.CancelLeavingCertificateServiceInterface;
@Service
public class CancelLeavingCertificateServiceC implements CancelLeavingCertificateServiceInterface {
	
	@Autowired
	private CancelLeavingCertificateDaoInterface cancelLeavingCertificateDaoInterface;

	public CancelLeavingCertificateDaoInterface getCancelLeavingCertificateDaoInterface() {
		return cancelLeavingCertificateDaoInterface;
	}

	public void setCancelLeavingCertificateDaoInterface(
			CancelLeavingCertificateDaoInterface cancelLeavingCertificateDaoInterface) {
		this.cancelLeavingCertificateDaoInterface = cancelLeavingCertificateDaoInterface;
	}

	@Transactional
	@Override
	public List<String> cancelLeavingCertificateList() {
		// TODO Auto-generated method stub
		return cancelLeavingCertificateDaoInterface.cancelLeavingCertificateList();
	}
	
	

}
