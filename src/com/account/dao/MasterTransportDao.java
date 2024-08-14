package com.account.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.MasterTransportDaoInterface;

import com.account.model.TransportMasterModel;
import com.admin.model.AdminRegistrationModel;
@Repository
public class MasterTransportDao implements MasterTransportDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void TransportMgmt(TransportMasterModel transportMasterModel){
		sessionFactory.getCurrentSession().save(transportMasterModel);
	}
	
	@Override
	public List<TransportMasterModel> fetchMasterTransport(){
		List<TransportMasterModel> listofTransport;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from TransportMaster t");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		listofTransport=query.list();
		return listofTransport;
		
	}

	@Override
	public void UpdateTransportCharges(int transID, String transCharge) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update collegemgmtsystem.transportmaster t set t.charges='"+transCharge+"' where t.transportId='"+transID+"'");
		query.executeUpdate();
	}

	@Override
	public void DeleteTransport(int transID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("delete from transportmaster where transportId='"+transID+"'");
		query.executeUpdate();
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId, a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type, a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminList=query.list();
		
		return adminList;
	}

	
}
