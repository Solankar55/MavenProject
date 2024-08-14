package com.library.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AcademicMasterLibraryDaoInterface;
import com.library.model.LibraryAcademicYearModel;

@Repository
public class AcademicMasterLibraryDaoClass implements AcademicMasterLibraryDaoInterface{

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
	public List<String> getYearList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.labacademicyearid,l.labacademicyear FROM libraryacademicyearmodel l where l.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> yearList;
		yearList=query.list();
		
		return yearList;
	}

	@Override
	public void saveLabAcademicMaster(LibraryAcademicYearModel libraryAcademicYearModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(libraryAcademicYearModel);
	}

	@Override
	public void updateYearOfLibrary(int yearId, String yearLab) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update libraryacademicyearmodel l set l.labacademicyear='"+yearLab+"' where l.labacademicyearid='"+yearId+"'");
		query.executeUpdate();
	}

	@Override
	public void deleteYearOfLibrary(int yearId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update libraryacademicyearmodel l set l.status='Inactive' where labacademicyearid='"+yearId+"'");
		query.executeUpdate();
	}
	
	
}
