package com.library.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BooksInDepartmenDaoInterface;

@Repository
public class BooksInDepartmenDaoClass implements BooksInDepartmenDaoInterface{

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
	public HashMap<String, String> departmentList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM librarydepartmentmaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<HashMap> DepartmentList=query.list();
		System.out.println(DepartmentList);
		HashMap MapOfDepartmentList = new HashMap<>();
		
		for(HashMap map:DepartmentList)
		{
			MapOfDepartmentList.put(map.get("DepartmentId"), map.get("Department"));
		}
		return MapOfDepartmentList;
	}

	@Override
	public List getListOfBooksInDepartment(String department) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionId, a.BookFor, q.Author,q.Title,q.Edition FROM librarybookindepartment l inner join accessionlibraryregister a on a.AccessionLibraryRegisterId=l.AccessionLibraryRegisterId inner join quantitydatamaster q on a.QuantityId=q.QuantityId where DepartmentId='"+department+"';");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List ListOfBooks=query.list();
		return ListOfBooks;
	}
	
	
}
