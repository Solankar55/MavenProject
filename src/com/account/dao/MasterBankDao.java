package com.account.dao;



import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.MasterBankDaoInterface;
import com.account.model.BankMasterModel;
import com.account.model.LedgerMasterModel;

@Repository
public class MasterBankDao implements MasterBankDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveBank(BankMasterModel bankMasterModel){
		sessionFactory.getCurrentSession().save(bankMasterModel);

	}
	@Override
	public List<BankMasterModel> fetchMasterBank() {
		// TODO Auto-generated method stub
	List<BankMasterModel> listofbank;
	SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from BankMaster b where b.status='On'");
	query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	listofbank=query.list();
		return listofbank;
	}

	@Override
	public void UpdateBankDetails(int bankId, String bankAccountNumber, String iFSCCode,String bankName, String branchName) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bankmaster b set b.bankName='"+bankName+"' ,b.branchName='"+branchName+"' ,b.accuntNumber='"+bankAccountNumber+"',b.NEFT_RTGS_IFSC='"+iFSCCode+"' where b.bankId='"+bankId+"'");
		query.executeUpdate();
	}

	@Override
	public void DeleteBank(int bankId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update bankmaster b set b.status='Off' where bankId='"+bankId+"'");
		query.executeUpdate();
	}
	
	
}
