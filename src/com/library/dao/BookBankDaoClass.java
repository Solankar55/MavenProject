package com.library.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookBankDaoInterface;
import com.library.model.AccessionLibraryRegister;
import com.library.model.BookBankIssueReturn;
import com.student.model.StudentAdmissionModel;

@Repository
public class BookBankDaoClass implements BookBankDaoInterface{

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
	public HashMap<String, String> getMessageSt(String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT availableStatus FROM accessionlibraryregister where AccessionId='"+bookId+"'");
		String status=(String) query.uniqueResult();
		HashMap<String,String> getMessageList=new HashMap<>();
		System.out.println(status);
		if(status.equals("Issued"))
		{
			getMessageList.put("msg", "This Book has been already Issued");
			System.out.println("Issued");
			return getMessageList;
		}
		else if(status.equals("Lost"))
		{
       getMessageList.put("msg", "This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
       System.out.println("Iost");	
       return getMessageList;
		}
		else
		{
			System.out.println("null");
		   return null;
		}
	}

	@Override
	public List<String> getStudentList(String studentId) {
		// TODO Auto-generated method stub
		List<String> getStudentData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId as StudId, a.acadamicYear,stm.streamName,b.branchName,st.standard,s.studentCategory, s.studentBarcode, s.studentFirstName ,s.studentLastName, s.studentImage FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster st on st.standardId=s.standardId left join streammaster stm on stm.streamId=s.streamId where s.admissionRegId='"+studentId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentData=query.list();
		System.out.println("getStudData in dao" +getStudentData);
		return getStudentData;
	}

	@Override
	public List<String> getStudentBookBankList(String studbarcode) {
		// TODO Auto-generated method stub
		List<String> getStudentBookBankData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT  s.admissionRegId as StudId,a.acadamicYear,b.studentAcYearId, b.bookAccessionId, b.bkIssueDate, b.bkReturnDate , b.IssuedBookStatus,b.Fine,(SELECT count(b.bookBandIssueReturnId) as countTransaction FROM bookbankissuereturn b where b.studentAcYearId='"+studbarcode+"')as totalTransaction FROM bookbankissuereturn b inner join studentadmission s on s.admissionRegId=b.admissionRegId inner join acadamicyear a on a.acadamicYearId=s.acadamicYearId where b.studentAcYearId='"+studbarcode+"' order by b.bookBandIssueReturnId DESC LIMIT 5 ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentBookBankData=query.list();
		System.out.println("getStudentBookBankData in dao" +getStudentBookBankData);
		return getStudentBookBankData;
	}

	@Override
	public String getActiveyr() {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select a.acadamicYear FROM acadamicyear a where a.ActiveAcadamicYr='Active'");
		
		return query.uniqueResult().toString();
		
	}

	@Override
	public int getMaxAlrID() {
		// TODO Auto-generated method stub
		List maxidList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(a.AccessionLibraryRegisterId)  FROM accessionlibraryregister a");
		maxidList=query.list();
		
		int a=0;
		if(maxidList.get(0)==null)
		{
			return a;
		}
		else
		{
			return a=(int)maxidList.get(0);
		}
	}

	@Override
	public int getalrIdforPostDegree(String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='"+bookId+"' and a.BookFor='PostGraduation' and a.CollegeRemark='Purchased' ");

		List abc=new ArrayList<>();
		abc=query.list();
		
		int a=0;
		if(abc.isEmpty())
		{
			return a;
		}
		else
		{
			return a=(int)abc.get(0);
		}
	}

	@Override
	public List<String> getbookIssure(int alridFk,int AlrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		Date d=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String currentdate = sdf.format(d);
		System.out.println(currentdate);
		SQLQuery query11 = sessionFactory.getCurrentSession().createSQLQuery(
				" SELECT b.bookBandIssueReturnId FROM bookbankissuereturn b where b.admissionRegId='"+studentId+"' and b.AccessionLibraryRegisterId='"+AlrID+"' and b.IssuedBookStatus='Issued'");
		Object ListIARBTId = query11.uniqueResult();
		
		SQLQuery query121=sessionFactory.getCurrentSession().createSQLQuery("select AccessionLibraryRegisterId from accessionlibraryregister a where AccessionId='"+bookId+"' and availableStatus='Issued';");
		Object ListIRIssBkId=query121.uniqueResult();
		
		System.out.println("ListIRIssBkId : " +ListIRIssBkId);
		System.out.println("ListIARBTId : " +ListIARBTId);
		
		if(ListIARBTId==null && ListIRIssBkId==null)
		{
		
			System.out.println("@AS1");
			 //String bookID=bookId.substring(2);
				SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Issued' where AccessionId='"+bookId+"'");
				query20.executeUpdate();
			BookBankIssueReturn bookBankIssueReturn=new BookBankIssueReturn();
			// Set AccessionLibraryRegister 
			AccessionLibraryRegister accessionLibrearyRegister=new AccessionLibraryRegister();
			//accessionLibrearyRegister.setAccessionId(AlrID);
			accessionLibrearyRegister.setAccessionLibraryRegisterId(AlrID);
			bookBankIssueReturn.setAccessionLibraryRegister(accessionLibrearyRegister);
			
			// Set Student AdmissionModel Id
			StudentAdmissionModel studentAdmissionModel=new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studentId);
			bookBankIssueReturn.setStudentAdmissionModel(studentAdmissionModel);
			
			bookBankIssueReturn.setBookAccessionId(bookId);
			bookBankIssueReturn.setStudentAcYearId(readerId);
			bookBankIssueReturn.setBkIssueDate(currentdate);
			
			sessionFactory.getCurrentSession().save(bookBankIssueReturn);
		}
		if(!(ListIARBTId==null && ListIRIssBkId==null)) {
				System.out.println("Need to Returned BookIssueReturn ");
				System.out.println("@AS2");
				//String bookID=bookId.substring(2);
				SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Returned' where AccessionId='"+bookId+"'");
				query20.executeUpdate();

				int id = Integer.parseInt(ListIARBTId.toString());
				System.out.println("id " + id);
					SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("select b.bookBandIssueReturnId from bookbankissuereturn b where b.IssuedBookStatus='Issued' and b.bookAccessionId='"+bookId+"'");
				int bkid=(int) query1.uniqueResult();
				System.out.println("bkid " + bkid);
				SQLQuery query2 = sessionFactory.getCurrentSession().createSQLQuery(
						"update bookbankissuereturn b set b.bkReturnDate='"+currentdate+"' , b.IssuedBookStatus='Returned' where b.bookBandIssueReturnId='"+bkid+"' ");
				query2.executeUpdate();
			}
		return null ;
	}

	@Override
	public String getDetails(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		System.out.println("AlrID" +alrID);
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT b.IssuedBookStatus FROM bookbankissuereturn b where b.admissionRegId='"+studentId+"' and b.AccessionLibraryRegisterId='"+alrID+"' and b.bookAccessionId='"+bookId+"' and b.bookBandIssueReturnId=(select max(v.bookBandIssueReturnId)as bookBandIssueReturnId from bookbankissuereturn v where v.admissionRegId='"+studentId+"' and v.AccessionLibraryRegisterId='"+alrID+"' and v.BookAccessionId='"+bookId+"' )");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		String data;
		data=query.uniqueResult().toString();
		
		return data;
	}

	@Override
	public int getalrIdforDegree(String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='" + bookId
						+ "' and a.BookFor='Degree' and a.CollegeRemark='Purchased' ");

		List abc=new ArrayList<>();
		abc=query.list();
		
		int a=0;
		if(abc.isEmpty())
		{
			return a;
		}
		else
		{
			return a=(int)abc.get(0);
		}
	}

	@Override
	public int getalrIdforDiploma(String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='" + bookId
						+ "' and a.BookFor='Diploma' and a.CollegeRemark='Purchased'");

		List abc=new ArrayList<>();
		abc=query.list();
		
		int a=0;
		if(abc.isEmpty())
		{
			return a;
		}
		else
		{
			return a=(int)abc.get(0);
		}
	}

	@Override
	public int getalrIdforOther(String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='" + bookId
						+ "' and a.BookFor='other' and a.CollegeRemark='Purchased'");

		List abc=new ArrayList<>();
		abc=query.list();
		
		int a=0;
		if(abc.isEmpty())
		{
			return a;
		}
		else
		{
			return a=(int)abc.get(0);
		}
	}
	
	
}
