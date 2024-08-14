package com.library.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.daoInterface.StudentClearenceDaoInterface;

@Repository
public class StudentClearenceDaoClass implements StudentClearenceDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<String, String> getAcadamicYear() {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfYearList = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT a.acadamicYearId, a.acadamicYear FROM acadamicyear a");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();
		System.out.println("acadamicYear" + list);

		for (HashMap map : list) {

			mapOfYearList.put(map.get("acadamicYearId"), map.get("acadamicYear"));

		}
		return mapOfYearList;
	}

	@Override
	public String getYearID(String selectedYr) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT a.acadamicYear FROM collegemgmtsystem.acadamicyear a where a.acadamicYearId='"
						+ selectedYr + "' ");

		return query.uniqueResult().toString();
	}

	@Override
	public List<String> getFinedetailStud(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		List<String> Alllist = new ArrayList<String>();
		SQLQuery query1 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.bookAccessionId, i.IssueDate,i.ReturnDate,i.Fine FROM issueandreturnbookstudent i where i.admissionRegId='"
						+ studId + "' and i.fine>0  and i.IssueDate between '" + dateone + "' and '" + datetwo + "'");
		query1.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Alllist = query1.list();
		return Alllist;
	}

	@Override
	public int gettotalfine(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		SQLQuery qry1 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(i.Fine) as Totalfine FROM issueandreturnbookstudent i where i.admissionRegId='" + studId
						+ "' and i.IssueDate between '" + dateone + "' and '" + datetwo + "'");
		return Integer.parseInt(qry1.uniqueResult().toString());
		/*
		 * List abc=new ArrayList<>();
		 * 
		 * int Val=0; if(abc.get(0).equals("NULL")) { return Val; } else {
		 * return Val=Integer.parseInt(abc.get(0).toString()); }
		 */
	}

	@Override
	public List<String> getLostbookdetails(String studId) {
		// TODO Auto-generated method stub
		List<String> ListOfLostDetailstud = new ArrayList<String>();
		SQLQuery qry11 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT l.DateLost, a.AccessionLibraryRegisterId,q.Author,q.Title,q.PrizePerBook FROM lostbookstudent l left join accessionlibraryregister a on l.AccessionLibraryRegisterId=a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where l.admissionRegId='"
						+ studId + "'");
		qry11.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ListOfLostDetailstud = qry11.list();
		return ListOfLostDetailstud;
	}

	@Override
	public Double getLostTotal(String studId) {
		// TODO Auto-generated method stub
		SQLQuery q123 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(q.PrizePerBook)as PrizePerBook FROM lostbookstudent l left join accessionlibraryregister a on l.AccessionLibraryRegisterId=a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where l.admissionRegId='"
						+ studId + "'");
		Double a = (double) 0;
		List abc = new ArrayList<>();

		abc = q123.list();

		if (abc.get(0).equals("null")) {
			return a;
		} else {
			return a = (double) abc.get(0);
		}
	}

	@Override
	public List<String> getNotReturnDetails(String studId) {
		// TODO Auto-generated method stub
		List<String> ListnonReturn = new ArrayList<String>();
		SQLQuery qqq = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.issueDate,i.AccessionLibraryRegisterId,q.Author,q.PrizePerBook,q.Title FROM issueandreturnbookstudent i left Join accessionlibraryregister a on i.AccessionLibraryRegisterId =a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where IssuedBookStatusStud='Return' and admissionRegId='"
						+ studId + "'");
		qqq.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ListnonReturn = qqq.list();
		return ListnonReturn;
	}

	@Override
	public Double getFineForNotReturn(String studId) {
		// TODO Auto-generated method stub
		SQLQuery q12 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(q.PrizePerBook)as Prize FROM issueandreturnbookstudent i left Join accessionlibraryregister a on i.AccessionLibraryRegisterId =a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where IssuedBookStatusStud='Return' and admissionRegId='"
						+ studId + "'");

		Double a = (double) 0;
		List abc = new ArrayList<>();

		abc = q12.list();

		if (abc.get(0).equals("null")) {
			return a;
		} else {
			return a = (double) abc.get(0);
		}
	}

}
