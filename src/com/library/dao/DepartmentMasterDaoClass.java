package com.library.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.DepartmentMasterDaoInterface;
import com.library.model.Department;

@Repository
public class DepartmentMasterDaoClass implements DepartmentMasterDaoInterface{

	@Autowired
	private SessionFactory  sessionFactory;

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
	public List<Department> getListOfDepartment() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM LibraryDepartmentMaster l where l.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Department> DList=query.list();
		return DList;
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(department);
	}

	@Override
	public void updateDepartmentData(int id, String department) {
		// TODO Auto-generated method stub
		SQLQuery quer=sessionFactory.getCurrentSession().createSQLQuery("update LibraryDepartmentMaster l set l.Department='"+department+"' where l.DepartmentId='"+id+"'");
		quer.executeUpdate();
	}

	
	public void deleteDepartmentData(int id) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update librarydepartmentmaster l set l.status='Inactive' where DepartmentId='"+id+"' ");
		query.executeUpdate();
	}


}
