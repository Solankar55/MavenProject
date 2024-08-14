package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.daoInterface.BookLostStudentDaoInterface;
import com.library.model.LostBookStudent;

@Repository
public class BookLostStudentDaoClass implements BookLostStudentDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void LostBookDataSave(String BookFor, String StudentName, int BookId, int StudentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object[]> activeYR() {	 
	SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select a.acadamicYear, a.acadamicYearId FROM collegemgmtsystem.acadamicyear a where a.ActiveAcadamicYr='Active'");
	List<Object[]> ListOfActiveYrAndId=query.list();	
	return ListOfActiveYrAndId;	
	} 

	@Override
	public void SaveToDatabase(LostBookStudent lostBookStudent) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(lostBookStudent);
	}

	@Override
	public int getAccessionLibraryRegisterId(String BookId,String BookFor) {
		// TODO Auto-generated method stub
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='"+BookId+"' and a.BookFor='"+BookFor+"'");
		int AccessionLibraryRegisterId = (int) query1.uniqueResult();
		return AccessionLibraryRegisterId;
	}

	@Override
	public List checkStudentRegistrationIdAvailability(int studentRegId) {
		// TODO Auto-generated method stub
		List list = new ArrayList<>();
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM studentadmission where admissionRegId = '"+studentRegId+"'");
		list=query2.list();		
		return list;
	}

	@Override
	public void updateBookCollegeRemark(int accessionLibraryRegisterId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister a set a.CollegeRemark='Lost' where a.AccessionLibraryRegisterId='"+accessionLibraryRegisterId+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> getBookLostList() {
		// TODO Auto-generated method stub
		List<String> BookLostDataList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LostbookStudentId, l.DateLost , alr.AccessionId ,alr.BookFor , s.studentFirstName,s.studentMiddleName , s.studentLastName , q.Title , q.Author FROM lostbookstudent l left join accessionlibraryregister alr on l.AccessionLibraryRegisterId=alr.AccessionLibraryRegisterId left join studentadmission s on l.admissionRegId=s.admissionRegId left join quantitydatamaster q on q.QuantityId=alr.QuantityId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BookLostDataList=query.list();
		
		return BookLostDataList;
	}



	
}
