package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.daoInterface.BookHolderDaoInterface;

@Repository
public class BookHolderDaoClass implements BookHolderDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getBookHolder(String holder) {
		// TODO Auto-generated method stub
		System.out.println("Query for Student fired:");
		List<String> listReturnStudent = new ArrayList<String>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.BookAccessionId,i.IssueDate,s.studentFirstName,s.studentLastName,q.Author,q.Title FROM issueandreturnbookstudent i left join studentadmission s on  s.admissionRegId=i.admissionRegId left join accessionlibraryregister a on a.AccessionLibraryRegisterId=i.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where i.ExtraBookStatusStud='Extra'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		listReturnStudent = query.list();
		return listReturnStudent;

	}

	@Override
	public List<String> getHolderStaff(String holder) {
		// TODO Auto-generated method stub
		System.out.println("Query for Student fired:");
		List<String> listReturnStaff = new ArrayList<String>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.BookBarcode,i.IssueDate,s.StaffName,q.Author,q.Title FROM issueandreturnbooklecturer i left join staffregistration s on s.staffRegistrationId=i.staffRegistrationId left join accessionlibraryregister a on a.AccessionLibraryRegisterId=i.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where i.ExtraBookStatus='Extra'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		listReturnStaff = query.list();
		return listReturnStaff;
	}
}
