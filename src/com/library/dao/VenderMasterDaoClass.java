package com.library.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.VenderMasterDaoInterface;
import com.library.model.VendorMasterModel;

@Repository
public class VenderMasterDaoClass implements VenderMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT a.Address,a.Email,a.MobileNumber,a.Name,a.Password,a.Type,a.Username from adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		adminList=query.list();
		return adminList;
	}

	@Override
	public List<String> getVenderList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT vendorid, vendorName FROM vendormastermodel v where v.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	@Override
	public void submitVendor(VendorMasterModel vendorMasterModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(vendorMasterModel);
	}

	@Override
	public void updateVendor(VendorMasterModel vendorMasterModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(vendorMasterModel);
	}

	@Override
	public void deleteVendor(int id) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update vendormastermodel v set v.status='Inactive' where vendorId='"+id+"' ");
		query.executeUpdate();
	}
	
}
