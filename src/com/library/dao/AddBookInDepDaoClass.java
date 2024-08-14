package com.library.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AddBookInDepDaoInterface;
import com.library.model.BookInDepartment;

@Repository
public class AddBookInDepDaoClass implements AddBookInDepDaoInterface{

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
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM librarydepartmentmaster l where l.status='Active' ");
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
	public List<BookInDepartment> getBookInDeptList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT q.title,l.BookInDepartmentID,d.Department FROM quantitydatamaster q inner join accessionlibraryregister a on q.QuantityId=a.QuantityId inner join librarybookindepartment l on l.AccessionLibraryRegisterId=a.AccessionLibraryRegisterId inner join librarydepartmentmaster d on l.DepartmentId=d.DepartmentId where l.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<BookInDepartment> BIDList=query.list();
		return BIDList;
	}

	@Override
	public int getAccId(String accerId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT AccessionLibraryRegisterId FROM accessionlibraryregister where AccessionId='"+accerId+"'");
		int accId=(int) query.uniqueResult();
		return accId;
	}

	@Override
	public void saveBookInDepartment(BookInDepartment bookInDepartment) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(bookInDepartment);
	}

	@Override
	public int getDeptId(String department) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.DepartmentId FROM librarydepartmentmaster l where l.Department='"+department+"'");
		int deptId=(int) query.uniqueResult();
		return deptId;
	}

	@Override
	public int getAccIdUpdate(String accerId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a left join librarybookindepartment l on a.AccessionLibraryRegisterId=l.AccessionLibraryRegisterId where a.AccessionId='"+accerId+"'");
		int accId=(int) query.uniqueResult();
		return accId;
	}

	@Override
	public void updateDepartmentData1(BookInDepartment bookInDepartment) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(bookInDepartment);
	}

	@Override
	public void deleteBookFromDepartment(int bookInDepId,String bookName,String departmentName) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update librarybookindepartment l set l.status='Inactive' where l.BookInDepartmentID='"+bookInDepId+"' ");
		query.executeUpdate();
		
	}
	
	
}
