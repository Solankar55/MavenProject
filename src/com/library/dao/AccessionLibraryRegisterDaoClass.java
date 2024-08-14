package com.library.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AccessionLibraryRegisterDaoInterface;
import com.library.model.AccessionLibraryRegister;
import com.library.model.BookTypeMaster;
import com.library.model.LibraryAcademicYearModel;
import com.library.model.LibrarySubjectMaster;
import com.library.model.PurchaceBooKModel;
import com.library.model.QuantityDataMaster;
import com.library.model.VendorMasterModel;

@Repository
public class AccessionLibraryRegisterDaoClass implements AccessionLibraryRegisterDaoInterface {

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
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.Address,a.Email,a.MobileNumber,a.Name,a.Password,a.Type,a.Username from adminregistration a where a.Username='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		adminList = query.list();
		return adminList;
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT l.labacademicyearid,l.labacademicyear FROM libraryacademicyearmodel l where l.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		for (HashMap map : list) {

			mapOfAcadimicYear.put(map.get("labacademicyearid"), map.get("labacademicyear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<String, String> librarySubjectList() {
		// TODO Auto-generated method stub
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM LibrarySubjectMaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<HashMap> lsmList = query.list();
		HashMap MapOfSubjectList = new HashMap<>();
		for (HashMap map : lsmList) {
			MapOfSubjectList.put(map.get("LibrarySubjectMasterId"), map.get("LibrarySubject"));
		}
		return MapOfSubjectList;
	}

	@Override
	public HashMap<String, String> bookTypeList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM Booktypemaster a where a.status='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<HashMap> BTMList=query.list();
		System.out.println(BTMList);
		HashMap MapOfBookTypeList = new HashMap<>();
		for(HashMap map:BTMList)
		{
			MapOfBookTypeList.put(map.get("BooktypeId"), map.get("Booktype"));
		}
		return MapOfBookTypeList;
	}

	@Override
	public HashMap getVendorName() {
		// TODO Auto-generated method stub
		HashMap vendorNameL = new HashMap<>();
		List<HashMap> VendorList = new ArrayList<>();

		SQLQuery query = this.sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT vendorId,vendorName FROM vendormastermodel");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		VendorList = query.list();
		vendorNameL.clear();
		for (HashMap m : VendorList) {
			vendorNameL.put(m.get("vendorId"), m.get("vendorName"));
		}
		return vendorNameL;
	}

	@Override
	public List<String> venderDis(String id) {
		// TODO Auto-generated method stub
		SQLQuery query = this.sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT discountA FROM vendormastermodel where vendorId='" + id + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	@Override
	public void purchaseBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String id = req.getParameter("orignaalInvice");

		String academicYear = req.getParameter("YearID");
		String inviceDate = req.getParameter("InviceDate");
		String inviceNo = req.getParameter("InvoiceNo");
		String purRemark = req.getParameter("purRemark");
		PurchaceBooKModel purchaceBook = new PurchaceBooKModel();
		quantityDataMaster.setPurRemark(purRemark);

		String Id = req.getParameter("BooksID");

		String BookType = req.getParameter("BookType");
		String vendorName = req.getParameter("Vendor");
		/* String vendorIdString=req.getParameter("Vendor"); */

		String subject = req.getParameter("Subject");
		String bookfor = req.getParameter("BookFor");

		/*
		 * SQLQuery
		 * queryVendorName=sessionFactory.getCurrentSession().createSQLQuery(
		 * "SELECT vendorName FROM vendormastermodel  where vendorId='"
		 * +vendorIdString+"'"); String vendorName =
		 * (String)queryVendorName.uniqueResult();
		 */ BookTypeMaster bookTypeMaster = new BookTypeMaster();
		 bookTypeMaster.setBooktypeId(Integer.parseInt(BookType));
		 LibrarySubjectMaster librarySubjectMaster = new LibrarySubjectMaster();
		 librarySubjectMaster.setLibrarySubjectMasterId(Integer.parseInt(subject));

		 VendorMasterModel vendorMasterModel = new VendorMasterModel();
		 vendorMasterModel.setVendorId(Integer.parseInt(vendorName));
		 quantityDataMaster.setVendor(vendorName);
		 quantityDataMaster.setBTMaster(bookTypeMaster);
		 quantityDataMaster.setLSMaster(librarySubjectMaster);
		 quantityDataMaster.setVendorMasterModel(vendorMasterModel);

		 AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
		 LibraryAcademicYearModel libraryAcademicYearModel = new LibraryAcademicYearModel();

		 libraryAcademicYearModel.setLabacademicyearid(Integer.parseInt(academicYear));
		 int quantity = quantityDataMaster.getQuantity();
		 SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery(
				 " SELECT AccessionId FROM accessionlibraryregister where AccessionLibraryRegisterId=(select ifnull(max(AccessionLibraryRegisterId),0) as AccessionId FROM accessionlibraryregister)");

		 String accertionId1 = (String) query1.uniqueResult();
		 int accertionId2 = 0;
		 if (accertionId1 == null) {
			 System.out.println("sssss");
			 accertionId1 = "000";
		 }

		 int accertionId = Integer.valueOf(accertionId1.substring(2));
		 System.out.println("accertionId" + accertionId);
		 accertionId2 = accertionId + 1;
		 System.out.println("aaa" + accertionId2);

		 String accRId = null;
		 if (bookfor.equals("Degree")) {
			 accRId = "UG";
		 } else if (bookfor.equals("Diploma")) {
			 accRId = "DP";

		 } else if (bookfor.equals("Other")) {
			 accRId = "OT";

		 } else if (bookfor.equals("PostGraduation")) {
			 accRId = "PG";

		 }
		 String disco = req.getParameter("DiscountRemark");
		 String total = req.getParameter("vendorDiscountA");
		 if (disco.equals("BalancedDiscountedAmount")) {
			 SQLQuery query6 = this.sessionFactory.getCurrentSession()
					 .createSQLQuery("update  vendormastermodel set discountA='" + total + "' where vendorId='"
							 + vendorMasterModel.getVendorId() + "'");
			 query6.executeUpdate();
		 } else if (disco.equals("WithDiscount")) {

		 } else {
			 SQLQuery query4 = this.sessionFactory.getCurrentSession().createSQLQuery(
					 "SELECT discountA FROM vendormastermodel where vendorId='" + vendorMasterModel.getVendorId() + "'");
			 double discountamount = (double) query4.uniqueResult();
			 double totalAmount = quantityDataMaster.getTotalAmount();
			 double paybleAmount = quantityDataMaster.getPaybleAmount();
			 double dissA = totalAmount - paybleAmount;
			 double dissB = dissA + discountamount;
			 SQLQuery query6 = this.sessionFactory.getCurrentSession()
					 .createSQLQuery("update  vendormastermodel set discountA='" + dissB + "' where vendorId='"
							 + vendorMasterModel.getVendorId() + "'");
			 query6.executeUpdate();
		 }
		 if (id.equals("0")) {
			 purchaceBook.setBook("Purchase");
			 this.sessionFactory.getCurrentSession().save(purchaceBook);
			 quantityDataMaster.setPurchaceBooKModel(purchaceBook);
			 this.sessionFactory.getCurrentSession().save(quantityDataMaster);
			 System.out.println("quantity" + quantity);

			 for (int i = 1; i <= quantity; i++) {

				 String accerstionid = accRId + accertionId2;
				 System.out.println("s" + accerstionid);
				 int qid = quantityDataMaster.getQuantityId();

				 SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(
						 "insert into accessionlibraryregister (AccessionId, BookFor, CollegeRemark, DiscountRemark, availableStatus,labacademicyearid, QuantityId) values('"
								 + accerstionid + "','" + bookfor + "','Purchased','"
								 + quantityDataMaster.getDiscountRemark() + "','Returned','" + academicYear + "','" + qid
								 + "')");
				 query.executeUpdate();
				 accertionId2++;
			 }

		 } else {
			 SQLQuery query = this.sessionFactory.getCurrentSession()
					 .createSQLQuery("SELECT ifnull(max(purId),1) as purId FROM purchacebookmodel");
			 BigInteger purid1 = (BigInteger) query.uniqueResult();
			 int purid = purid1.intValue();
			 purchaceBook.setPurId(purid);
			 quantityDataMaster.setPurchaceBooKModel(purchaceBook);
			 this.sessionFactory.getCurrentSession().save(quantityDataMaster);
			 System.out.println("quantity" + quantity);

			 for (int i = 1; i <= quantity; i++) {

				 String accerstionid = accRId + accertionId2;
				 System.out.println("s" + accerstionid);
				 int qid = quantityDataMaster.getQuantityId();

				 System.out.println("qid" + qid);
				 SQLQuery query8 = this.sessionFactory.getCurrentSession().createSQLQuery(
						 "insert into accessionlibraryregister (AccessionId, BookFor, CollegeRemark, DiscountRemark, availableStatus,labacademicyearid, QuantityId) values('"
								 + accerstionid + "','" + bookfor + "','Purchased','"
								 + quantityDataMaster.getDiscountRemark() + "','Returned','" + academicYear + "','" + qid
								 + "')");
				 query8.executeUpdate();
				 accertionId2++;
			 }

		 }
	}

	@Override
	public List<String> getpurchaseBookList() {
		// TODO Auto-generated method stub
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT * FROM quantitydatamaster where purid=(select max(purid) from purchacebookmodel); ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		return query.list();
	}

	@Override
	public void updateBook(QuantityDataMaster quantityDataMaster, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String id = req.getParameter("orignaalInvice");

		String academicYear = req.getParameter("YearID");
		String inviceDate = req.getParameter("InviceDate");
		String inviceNo = req.getParameter("InvoiceNo");
		String purRemark = req.getParameter("purRemark");
		PurchaceBooKModel purchaceBook = new PurchaceBooKModel();
		quantityDataMaster.setPurRemark(purRemark);
		String Id = req.getParameter("BooksID");
		String BookType = req.getParameter("BookType");
		String vendorName = req.getParameter("Vendor");
		String subject = req.getParameter("Subject");
		String bookfor = req.getParameter("BookFor");
		BookTypeMaster bookTypeMaster = new BookTypeMaster();
		bookTypeMaster.setBooktypeId(Integer.parseInt(BookType));
		LibrarySubjectMaster librarySubjectMaster = new LibrarySubjectMaster();
		librarySubjectMaster.setLibrarySubjectMasterId(Integer.parseInt(subject));
		VendorMasterModel vendorMasterModel = new VendorMasterModel();
		vendorMasterModel.setVendorId(Integer.parseInt(vendorName));
		quantityDataMaster.setBTMaster(bookTypeMaster);
		quantityDataMaster.setLSMaster(librarySubjectMaster);
		quantityDataMaster.setVendorMasterModel(vendorMasterModel);
		AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
		LibraryAcademicYearModel libraryAcademicYearModel = new LibraryAcademicYearModel();
		SQLQuery query = this.sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT max(purId) as purId FROM purchacebookmodel");
		int purid = (int) query.uniqueResult();
		purchaceBook.setPurId(purid);
		quantityDataMaster.setPurchaceBooKModel(purchaceBook);

		this.sessionFactory.getCurrentSession().update(quantityDataMaster);
		int quantity = quantityDataMaster.getQuantityId();

		libraryAcademicYearModel.setLabacademicyearid(Integer.parseInt(academicYear));

		SQLQuery query99 = this.sessionFactory.getCurrentSession()
				.createSQLQuery("delete  from accessionlibraryregister where QuantityId='" + quantity + "'");
		query99.executeUpdate();
		SQLQuery query1 = this.sessionFactory.getCurrentSession().createSQLQuery(
				" SELECT  AccessionId  FROM accessionlibraryregister where AccessionLibraryRegisterId=(select ifnull(max(AccessionLibraryRegisterId),0) as AccessionId FROM accessionlibraryregister)");
		int accertionId2 = 0;
		String accertionId1 = (String) query1.uniqueResult();
		if (accertionId1 == null) {
			accertionId1 = "000";
		}
		int accertionId = Integer.valueOf(accertionId1.substring(2));
		System.out.println("accertionId" + accertionId);
		accertionId2 = accertionId + 1;
		System.out.println("aaa" + accertionId2);

		String accRId = null;
		if (bookfor.equals("Degree")) {
			accRId = "UG";
		} else if (bookfor.equals("Diploma")) {
			accRId = "DP";

		} else if (bookfor.equals("Other")) {
			accRId = "OT";

		} else if (bookfor.equals("PostGraduation")) {
			accRId = "PG";

		}
		String disco = req.getParameter("DiscountRemark");
		String total = req.getParameter("vendorDiscountA");
		if (disco.equals("BalancedDiscountedAmount")) {
			SQLQuery query6 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("update  vendormastermodel set discountA='" + total + "' where vendorId='"
							+ vendorMasterModel.getVendorId() + "'");
			query6.executeUpdate();
		} else if (disco.equals("WithDiscount")) {

		} else if (disco.equals("WithoutDiscount")) {
			SQLQuery query9 = this.sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT discountA FROM vendormastermodel where vendorId='" + vendorMasterModel.getVendorId() + "'");
			double discountamountA = (double) query9.uniqueResult();
			double totalAmount = quantityDataMaster.getTotalAmount();
			double paybleAmount = quantityDataMaster.getPaybleAmount();
			double dissA = totalAmount - paybleAmount;
			double dissB = dissA + discountamountA;
			SQLQuery query6 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("update  vendormastermodel set discountA='" + dissB + "' where vendorId='"
							+ vendorMasterModel.getVendorId() + "'");
			query6.executeUpdate();

		}

		SQLQuery query4 = this.sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT discountA FROM vendormastermodel where vendorId='" + vendorMasterModel.getVendorId() + "'");
		double discountamount = (double) query4.uniqueResult();
		SQLQuery query19 = this.sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT DiscountRemark FROM quantitydatamaster where QuantityId='"
						+ quantityDataMaster.getQuantityId() + "'");
		String status = (String) query19.uniqueResult();
		if (status.equals("WithoutDiscount")) {
			System.out.println("WithoutDiscount");
			SQLQuery query12 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT totalAmount FROM quantitydatamaster where QuantityId='"
							+ quantityDataMaster.getQuantityId() + "'");
			double totalA = (double) query12.uniqueResult();
			SQLQuery query13 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT paybleAmount FROM quantitydatamaster where  QuantityId='"
							+ quantityDataMaster.getQuantityId() + "'");
			double paybleAmoun = (double) query13.uniqueResult();

			double calculate = totalA - paybleAmoun;
			double totCal = discountamount - calculate;
			SQLQuery query15 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("update  vendormastermodel set discountA='" + totCal + "' where vendorId='"
							+ vendorMasterModel.getVendorId() + "'");
			query15.executeUpdate();
		} else if (status.equals("BalancedDiscountedAmount")) {
			SQLQuery query12 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT totalAmount FROM quantitydatamaster where QuantityId='"
							+ quantityDataMaster.getQuantityId() + "'");
			double totalA = (double) query12.uniqueResult();
			SQLQuery query13 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT paybleAmount FROM quantitydatamaster where  QuantityId='"
							+ quantityDataMaster.getQuantityId() + "'");
			double paybleAmoun = (double) query13.uniqueResult();
			SQLQuery query20 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT discount FROM quantitydatamaster where  QuantityId='"
							+ quantityDataMaster.getQuantityId() + "'");
			double discount = (double) query20.uniqueResult();

			double totDiscountA = totalA * discount / 100;
			System.out.println("totDiscountA " + totDiscountA);
			double paybleVendorA = totalA - totDiscountA;

			double discountVendor = paybleVendorA - paybleAmoun;
			System.out.println("mahesh2" + discountVendor + "   " + paybleVendorA);
			SQLQuery query9 = this.sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT discountA FROM vendormastermodel where vendorId='" + vendorMasterModel.getVendorId() + "'");
			double discountamountA = (double) query9.uniqueResult();

			System.out.println("discountamountAdiscountamountA" + discountamountA);
			double addDiscountA = discountamountA + discountVendor;

			SQLQuery query6 = this.sessionFactory.getCurrentSession()
					.createSQLQuery("update  vendormastermodel set discountA='" + addDiscountA + "' where vendorId='"
							+ vendorMasterModel.getVendorId() + "'");
			query6.executeUpdate();

		}

		int qid1 = quantityDataMaster.getQuantity();
		for (int i = 1; i <= qid1; i++) {

			String accerstionid = accRId + accertionId2;
			System.out.println("s" + accerstionid);
			int qid = quantityDataMaster.getQuantityId();

			System.out.println("qid" + qid);
			SQLQuery query8 = this.sessionFactory.getCurrentSession().createSQLQuery(
					"insert into accessionlibraryregister (AccessionId, BookFor, CollegeRemark, DiscountRemark, availableStatus,labacademicyearid, QuantityId) values('"
							+ accerstionid + "','" + bookfor + "','Purchased','"
							+ quantityDataMaster.getDiscountRemark() + "','Returned','" + academicYear + "','" + qid
							+ "')");
			query8.executeUpdate();
			accertionId2++;
		}

	}

}
