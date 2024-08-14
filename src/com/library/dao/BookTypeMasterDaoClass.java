package com.library.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookTypeMasterDaoInterface;
import com.library.model.BookTypeMaster;

@Repository
public class BookTypeMasterDaoClass implements BookTypeMasterDaoInterface{

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
	public List<BookTypeMaster> bookTypeSimpleList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM Booktypemaster b where b.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<BookTypeMaster> BTMList=query.list();
		return BTMList;
	}

	@Override
	public void saveBookType(BookTypeMaster book) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public void updateBookTypeData(int id, String bookType) {
		// TODO Auto-generated method stub
		SQLQuery quer=sessionFactory.getCurrentSession().createSQLQuery("update booktypemaster b set b.Booktype='"+bookType+"' where b.booktypeid='"+id+"'");
		quer.executeUpdate();
	}

	@Override
	public void deleteBookTypeData(int id) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update booktypemaster b set b.status='Inactive' where b.booktypeid='"+id+"'");
		query.executeUpdate();
	}
	
	
}
