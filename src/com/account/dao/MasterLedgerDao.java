package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.MasterLedgerDaoInterface;
import com.account.model.LedgerMasterModel;
import com.account.model.SubLedgerMasterModel;
@Repository
public class MasterLedgerDao implements MasterLedgerDaoInterface {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveMasterLedger(LedgerMasterModel ledgerMasterModel) {
	
	sessionFactory.getCurrentSession().save(ledgerMasterModel);	
	}
	
	@Override
	public List<LedgerMasterModel> fetchMasterLedger() {
		List<LedgerMasterModel> listOfmasterLedger ;
	SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM ledgermaster l where l.lstatus='On'");
	query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	listOfmasterLedger=query.list();
	return listOfmasterLedger;
	}

	@Override
	public HashMap fetchSubMasterLedger() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfsubMasterLedger = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT LedgerId, LedgerName FROM ledgermaster l where l.lstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		System.out.println("listOfmasterLedger"+list);

		for(HashMap map :list){

			mapOfsubMasterLedger.put( map.get("LedgerId"),map.get("LedgerName"));

		}
		return mapOfsubMasterLedger;
	}

	/*save master sub ledger */
	@Override
	public void saveSubLedgerMaster(SubLedgerMasterModel subLedgerMasterModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(subLedgerMasterModel);
	}

	/*fetch subledger list*/
	@Override
	public List<SubLedgerMasterModel> fetchSubledgerInterface() {
		List<SubLedgerMasterModel> subLedgerMasterModel ;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select s.SubLedgerId, s.subledger,l.LedgerName from subledgermaster s left join ledgermaster l on l.LedgerId=s.LedgerId where s.sstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		subLedgerMasterModel=query.list();
		System.out.println("subLedgerMasterModel"+subLedgerMasterModel);
		return subLedgerMasterModel;
		
	}

	@Override
	public void SaveUpdateLedger(int ledgerID, String accType, String ledgerName, String type) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update ledgermaster l set l.AccountType='"+accType+"',l.LedgerName='"+ledgerName+"',l.LedgerType='"+type+"' where l.LedgerId='"+ledgerID+"'");
		query.executeUpdate();
	}

	@Override
	public void DeleteLedger(int ledgerID) {
		// TODO Auto-generated method stub
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update ledgermaster l set l.lstatus='Off'  where LedgerId='"+ledgerID+"' ");
		query.executeUpdate();
	}

	@Override
	public void UpdateSubLedger(int subLedgerID, String subLedgerName) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update subledgermaster s set s.subledger='"+subLedgerName+"' where SubLedgerId='"+subLedgerID+"'");
		query.executeUpdate();
	}

	@Override
	public void DeleteSubLedger(int subLedgerID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update subledgermaster s set s.sstatus='Off' where SubLedgerId='"+subLedgerID+"'");
		query.executeUpdate();
	}
	

	
	
	
}
