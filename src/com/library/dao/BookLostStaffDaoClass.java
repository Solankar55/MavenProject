package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.daoInterface.BookLostStaffDaoInterface;
import com.library.model.LostBookStaff;

@Repository
public class BookLostStaffDaoClass implements BookLostStaffDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getLostStaffBookList() {
		// TODO Auto-generated method stub
		List<String> LostStaffBookList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LostBookStaffId , l.DateLost , alr.AccessionId , alr.BookFor , s.StaffName ,q.Title , q.Author FROM lostbookstaff l left join accessionlibraryregister alr on l.AccessionLibraryRegisterId=alr.AccessionLibraryRegisterId  left join staffregistration s on l.staffRegistrationId=s.staffRegistrationId left join quantitydatamaster q on q.QuantityId=alr.QuantityId ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		LostStaffBookList=query.list();
		return LostStaffBookList;
	}

	@Override
	public List<Object[]> activeYR() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select a.acadamicYear, a.acadamicYearId FROM collegemgmtsystem.acadamicyear a where a.ActiveAcadamicYr='Active'");
		List<Object[]> ListOfActiveYrAndId=query.list();	
		return ListOfActiveYrAndId;
	}

	@Override
	public List checkStaffRegistrationIdAvailability(int staffId) {
		// TODO Auto-generated method stub
		List list = new ArrayList<>();
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM staffregistration where staffRegistrationId = '"+staffId+"'");
		list=query2.list();		
		return list;	
	}

	@Override
	public void saveToDatabase(LostBookStaff lostBookStaff) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(lostBookStaff);
	}

	@Override
	public void updateBookCollegeRemark(int accessionLibraryRegisterId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister a set a.CollegeRemark='Lost' where a.AccessionLibraryRegisterId='"+accessionLibraryRegisterId+"'");
		query.executeUpdate();
	}

	@Override
	public int getAccesssionLibraryRegisterId(String bookId, String bookFor) {
		// TODO Auto-generated method stub
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='"+bookId+"'and a.BookFor='"+bookFor+"'");
		int AccessionLibraryRegisterId = (int) query1.uniqueResult();
		return AccessionLibraryRegisterId;
	}
	
	
}
