package com.library.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BarcodeDaoInterface;
import com.library.model.Barcodemodel;

@Repository
public class BarcodeDaoClass implements BarcodeDaoInterface {

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
	public List<String> getBarcodedBookList(String bookFor) {
		// TODO Auto-generated method stub
		List<String> getBarcodeBookList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionLibraryRegisterId,a.accessionId,a.bookfor,q.Edition,q.Author, q.title  FROM accessionlibraryregister a inner join quantitydatamaster q on a.QuantityId=q.QuantityId where q.Bookfor='"+bookFor+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getBarcodeBookList=query.list();
		return getBarcodeBookList;
	}

	@Override
	public HashMap<Integer, String> getAccessionId(String bookfor, String inDate) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> ListOfAccession = new HashMap();

		List<HashMap> Listof = new ArrayList<HashMap>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.AccessionId,a.AccessionLibraryRegisterId from accessionlibraryregister a left join  quantitydatamaster q on  a.QuantityId=q.QuantityId where a.BookFor='"
						+ bookfor + "' and  q.InDate='" + inDate + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Listof = query.list();

		for (HashMap map : Listof) {
			int st = Integer.parseInt(map.get("AccessionLibraryRegisterId").toString());
			String AccessionId = map.get("AccessionId").toString();
			ListOfAccession.put(st, AccessionId);

		}

		System.out.println("List of Accession: " + ListOfAccession);
		return ListOfAccession;
	}

	@Override
	public void saveBarcode(Barcodemodel barcodemodel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(barcodemodel);
	}
	

	
}
