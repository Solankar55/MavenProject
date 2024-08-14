package com.library.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.daoInterface.LecturerClearenceDaoInterface;

@Repository
public class LecturerClearenceDaoClass implements LecturerClearenceDaoInterface{

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
	public String getYearbyID(String selectedYr) {
		// TODO Auto-generated method stub

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT a.acadamicYear FROM acadamicyear a where a.acadamicYearId='"
						+ selectedYr + "' ");
		return query.uniqueResult().toString();
	}

	@Override
	public List<String> getFinedetails(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		List<String> Alllist = new ArrayList<String>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.BookBarcode, i.IssueDate,i.ReturnDate,i.Fine FROM issueandreturnbooklecturer i where i.staffRegistrationId='"
						+ studId + "' and i.fine>0  and i.IssueDate between '" + dateone + "' and '" + datetwo + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//
		// SELECT i.BookAccessionId, i.IssueDate,i.ReturnDate,i.Fine FROM
		// issueandreturnbookstudent i where i.admissionRegId='1' and i.fine>'0'
		// and i.IssueDate between '12-09-2017' and '13-09-2017' ;

		Alllist = query.list();
		return Alllist;
	}

	@Override
	public int gettotalfine(String dateone, String datetwo, String studId) {
		// TODO Auto-generated method stub
		SQLQuery query1 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(i.Fine) as Totalfine FROM issueandreturnbooklecturer i where i.staffRegistrationId='"
						+ studId + "' and i.IssueDate between '" + dateone + "' and '" + datetwo + "' ");

		return Integer.parseInt(query1.uniqueResult().toString());
	}

	@Override
	public List<String> getLostbookdetails(String studId) {
		// TODO Auto-generated method stub
		List<String> ListOfLostDetails = new ArrayList<String>();
		SQLQuery query12 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT l.DateLost, a.AccessionLibraryRegisterId,q.Author,q.Title,q.PrizePerBook FROM lostbookstaff l left join accessionlibraryregister a on l.AccessionLibraryRegisterId=a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where l.staffRegistrationId='"
						+ studId + "'");
		query12.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ListOfLostDetails = query12.list();
		return ListOfLostDetails;
	}

	@Override
	public Double getLostTotal(String studId) {
		// TODO Auto-generated method stub
		SQLQuery query123 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT Sum(q.PrizePerBook)as PrizePerBook FROM lostbookstaff l left join accessionlibraryregister a on l.AccessionLibraryRegisterId=a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where l.staffRegistrationId='"
						+ studId + "'");
		// TODO Auto-generated method stub
		Double a = (double) 0;
		List abc = new ArrayList<>();

		abc = query123.list();

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
		SQLQuery qr = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.issueDate,a.AccessionId,q.Author,q.PrizePerBook,q.Title,q.BookFor FROM issueandreturnbooklecturer i left Join accessionlibraryregister a on i.AccessionLibraryRegisterId =a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where IssuedBookStatus='Issue' and staffRegistrationId='"
						+ studId + "'");
		qr.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ListnonReturn = qr.list();
		return ListnonReturn;
	}

	@Override
	public Double getFineForNotReturn(String studId) {
		// TODO Auto-generated method stub
		SQLQuery qry = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT sum(q.PrizePerBook)as Prize FROM issueandreturnbooklecturer i left Join accessionlibraryregister a on i.AccessionLibraryRegisterId =a.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=a.QuantityId where IssuedBookStatus='Issue' and staffRegistrationId='"
						+ studId + "'");

		Double a = (double) 0;
		List abc = new ArrayList<>();

		abc = qry.list();

		if (abc.get(0).equals("null")) {
			return a;
		} else {
			return a = (double) abc.get(0);
		}
	}
	
}
