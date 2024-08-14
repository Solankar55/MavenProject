package com.library.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.LibrarySubjectMasterDaoInterface;
import com.library.model.LibrarySubjectMaster;

@Repository
public class LibrarySubjectMasterDaoClass implements LibrarySubjectMasterDaoInterface {

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
	public List<LibrarySubjectMaster> librarySubjectSimpleList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM librarysubjectmaster l where l.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<LibrarySubjectMaster> LSMList=query.list();
		return LSMList;
	}

	@Override
	public void librarySubjectSave(LibrarySubjectMaster lsm) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(lsm);
	}

	@Override
	public void updateLibraryData(int id, String subject) {
		// TODO Auto-generated method stub
		SQLQuery quer=sessionFactory.getCurrentSession().createSQLQuery("update librarysubjectmaster l set l.librarysubject='"+subject+"' where l.librarysubjectmasterid='"+id+"'");
		quer.executeUpdate();
	}

	@Override
	public void deleteLibraryData(int id) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update librarysubjectmaster l set l.status='Inactive' where LibrarySubjectMasterId='"+id+"'");
		query.executeUpdate();
	}
	
	
}
