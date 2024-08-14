package com.library.dao;

import java.text.ParseException;
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

import com.HOD.model.StaffRegistrationModel;
import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.BookIssueReturnDaoInterface;
import com.library.model.AccessionLibraryRegister;
import com.library.model.IssueAndReturnBookLecturer;
import com.library.model.IssueAndReturnBookStudent;
import com.student.model.StudentAdmissionModel;

@Repository
public class BookIssueReturnDaoClass implements BookIssueReturnDaoInterface {

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
	public List<String> getBookBarcodeInfo(String bookBarcode) {
		// TODO Auto-generated method stub
		List<String> getBookData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionId,l.LibrarySubject,q.BookFor,b.booktype,q.Title,q.Author,q.Edition,q.PublicationYear,q.Publisher FROM quantitydatamaster q left join librarysubjectmaster l on q.LibrarySubjectMasterId=l.LibrarySubjectMasterId left join booktypemaster b on b.booktypeId=q.booktypeId left join accessionlibraryregister a on a.quantityId=q.quantityId where a.availableStatus='Returned' and a.accessionId='"+bookBarcode+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getBookData=query.list();
		return getBookData;
	}

	@Override
	public List<String> getStudentBarcodeInfo(String studentBarcode) {
		// TODO Auto-generated method stub
		List<String> getStudData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId as StudId, a.acadamicYear,stm.streamName,b.branchName,st.standard, s.studentContactNumber, s.studentFirstName ,s.studentLastName, s.studentImage FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster st on st.standardId=s.standardId left join streammaster stm on stm.streamId=s.streamId where studentBarcode='"+studentBarcode+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudData=query.list();
		System.out.println("getStudData in dao" +getStudData);
		return getStudData;
	}

	@Override
	public List<String> getStaffDetails(String staffBarcode) {
		// TODO Auto-generated method stub
		List<String> getStaffData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT staf.staffRegistrationId as staffID,staf.StaffType,staf.SatffDepartment,staf.MobileNumber ,staf.StaffName   FROM staffregistration staf where staf.barcode='"+staffBarcode+" ' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStaffData=query.list();
		System.out.println("getStudData in dao" +getStaffData);
		return getStaffData;
	}

	@Override
	public String getActiveyr() {
		// TODO Auto-generated method stub
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select a.acadamicYear FROM acadamicyear a where a.ActiveAcadamicYr='Active'");

		return query.uniqueResult().toString();
	}

	@Override
	public int getAlrIdforPG(String bookId) {
		// TODO Auto-generated method stub
SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionLibraryRegisterId FROM accessionlibraryregister a where a.AccessionId='"+bookId+"' and a.BookFor='PostGraduation' and a.CollegeRemark='Purchased'");
		
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
	public List<String> getbookIssure(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		 System.out.println("fourth");
		SQLQuery query1 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT canIssue FROM accessibilitymaster where Category='Student'");
		int CanIssue = Integer.parseInt(query1.uniqueResult().toString());

		SQLQuery query10 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT ReturnInDays FROM accessibilitymaster where Category='Student'");
		int ReturnInDays = Integer.parseInt(query10.uniqueResult().toString());

		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT Fine FROM accessibilitymaster where Category='Student'");
		int FinePerDay = Integer.parseInt(query.uniqueResult().toString());

		System.out.println("CanIssue :" + CanIssue);
		System.out.println("ReturnInDays :" + ReturnInDays);
		System.out.println("FinePerDay :" + FinePerDay);

		System.out.println("studentId :" + studentId);
		
		/*
		 * query1.setResultTransformer(Transformers.aliasToBean(
		 * AccessibilityMaster.class)); canIssueDetails=query1.list();
		 * 
		 * int canIssue=canIssueDetails.get(0).getCanIssue(); int
		 * returnIndays=canIssueDetails.get(0).getReturnInDays();
		 */

		// List<String> ListIARBTId= new ArrayList<String>();
		SQLQuery query11 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.IssueAndReturnBookStudentId FROM issueandreturnbookstudent i where i.admissionRegId='"
						+ studentId + "' and i.AccessionLibraryRegisterId='" + alrID
						+ "' and i.IssuedBookStatusStud='Issued'");
		Object ListIARBTId = query11.uniqueResult();
		
		SQLQuery query121=sessionFactory.getCurrentSession().createSQLQuery("select AccessionLibraryRegisterId from accessionlibraryregister a where AccessionId='"+bookId+"' and availableStatus='Issued';");
		Object ListIRIssBkId=query121.uniqueResult();
		
		System.out.println("ListIRIssBkId : " +ListIRIssBkId);
		System.out.println("ListIARBTId : " +ListIARBTId);
		
		if(ListIARBTId==null && ListIRIssBkId==null)
		{			 
			System.out.println("third");
			 //String bookID=bookId.substring(2);
				SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Issued' where AccessionId='"+bookId+"'");
				query20.executeUpdate();
			IssueAndReturnBookStudent issueAndReturnBookStudent = new IssueAndReturnBookStudent();
			// issueAndReturnBookStudent.setBookAccessionId(bookAccessionId);

			AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
			accessionLibraryRegister.setAccessionLibraryRegisterId(alrID);
			issueAndReturnBookStudent.setIARBStudentA(accessionLibraryRegister);

			issueAndReturnBookStudent.setBookAccessionId(bookId); // barcode
			issueAndReturnBookStudent.setStudentYearId(readerId);
			issueAndReturnBookStudent.setIssueDate(curentdate);

			// set student
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studentId);
			issueAndReturnBookStudent.setStudentAdmissionModel(studentAdmissionModel);

			SQLQuery query3 = sessionFactory.getCurrentSession().createSQLQuery(
					"select count(IssuedBookStatusStud) from issueandreturnbookstudent where admissionRegId='"
							+ studentId + "' and IssuedBookStatusStud='Issued'");
			int totalbookIssue = Integer.parseInt(query3.uniqueResult().toString());

			System.out.println("totalbookIssue :" + totalbookIssue);

			if (totalbookIssue > CanIssue) {
				issueAndReturnBookStudent.setExtraBookStatusStud("Extra");
				sessionFactory.getCurrentSession().save(issueAndReturnBookStudent);
			} else {
				sessionFactory.getCurrentSession().save(issueAndReturnBookStudent);
			}

			// admission table

		}
		if (!(ListIARBTId == null  && ListIRIssBkId==null)) {
              System.out.println("first");
			SQLQuery query12 = sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT i.Issuedate FROM issueandreturnbookstudent i where i.admissionRegId='"
							+ studentId + "' and i.AccessionLibraryRegisterId='" + alrID
							+ "' and i.IssuedBookStatusStud='Issued'");
			String IssueDate = query12.uniqueResult().toString();
			long diff = 0;
			int ExtraDays = 0;
			int Calculatedfine = 0;

			System.out.println("curentdate :" + curentdate);
			System.out.println("IssueDate :" + IssueDate);

			String ConvertedCurrentDate = DateConvertor(curentdate);
			String ConvertedIssueDate = DateConvertor(IssueDate);

			long days = getDateDiff(ConvertedCurrentDate, ConvertedIssueDate);
			System.out.println("Return Days :" + days);
			System.out.println("ExtraDays"+ExtraDays);
			System.out.println("days"+days);
			System.out.println("ReturnInDays"+ReturnInDays);
			//updateSonali
			//String bookID=bookId.substring(2);
			SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Returned' where AccessionId='"+bookId+"'");
			query20.executeUpdate();
			
			if (days > ReturnInDays) {
				 System.out.println("second");
				ExtraDays = (int) (days - ReturnInDays);
				System.out.println("ExtraDays "+ExtraDays);
				Calculatedfine = ExtraDays * FinePerDay;

				int id = Integer.parseInt(ListIARBTId.toString());
				SQLQuery query2 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbookstudent i set i.IssuedBookStatusStud='Returned',i.ReturnDate='"
								+ curentdate + "', i.fine = '" + Calculatedfine
								+ "' where i.IssueAndReturnBookStudentId='" + id + "'");
				query2.executeUpdate();
			} else {
				System.out.println("CalculatedFine is 0");

				int id = Integer.parseInt(ListIARBTId.toString());
				SQLQuery query2 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbookstudent i set i.IssuedBookStatusStud='Returned',i.ReturnDate='"
								+ curentdate + "' where i.IssueAndReturnBookStudentId='" + id + "'");
				query2.executeUpdate();
			}
		}

		return null;
	}
	public static String DateConvertor(String date) {
		String s = "";
		char[] arr = date.toCharArray();

		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] == '-') {
				s = s + " ";
			} else {
				s = s + arr[i];
			}
		}
		return s;
	}
	public static long getDateDiff(String s1, String s2) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = s1;
		String inputString2 = s2;
		long diff = 0;
		long days=0;
		try {
			Date date1 = myFormat.parse(inputString1);
			
			Date date2 = myFormat.parse(inputString2);
			//int diffdays=Days.daysBetween(date1, date2).getDays();
			
			diff = date1.getTime()-date2.getTime() ;
			long sec =diff/1000*60;
			long min = diff/(60*1000)*60;
			long hr=diff/(60*60*1000);
			 days=hr/24;
			//TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			System.out.println(" sec"+sec);
			System.out.println("MIN"+min);
			System.out.println("hr"+hr);
			System.out.println("days"+days);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Diffence Days"+days);
		return days;
	
	}
	@Override
	public String getDetails(int alrID, int studentId, String readerId, String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT i.IssuedBookStatusStud FROM issueandreturnbookstudent i where i.admissionRegId='"+studentId+"' and i.AccessionLibraryRegisterId='"+alrID+"' and i.BookAccessionId='"+bookId+"' and i.IssueAndReturnBookStudentId=(select max(v.IssueAndReturnBookStudentId)as IssueAndReturnBookStudentId from issueandreturnbookstudent v where v.admissionRegId='"+studentId+"' and v.AccessionLibraryRegisterId='"+alrID+"' and v.BookAccessionId='"+bookId+"' )");
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

	@Override
	public void issueBookToLecturerPostDegree(int alrID, String readerId, String bookId, int staffID) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);

		SQLQuery query1 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT canIssue FROM accessibilitymaster where Category='Staff'");
		int CanIssue = Integer.parseInt(query1.uniqueResult().toString());

		
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.IssueAndReturnBookLecturerId FROM issueandreturnbooklecturer i where i.IssuedBookStatus='Issued' and i.AccessionLibraryRegisterId='"
						+ alrID + "' and i.staffRegistrationId='" + staffID + "'");
		Object IssueandReturnBookLectID = query.uniqueResult();

		SQLQuery query121=sessionFactory.getCurrentSession().createSQLQuery("select AccessionLibraryRegisterId from accessionlibraryregister a where AccessionId='"+bookId+"' and availableStatus='Issued';");
		Object ListIRIssBkId=query121.uniqueResult();
		
		System.out.println("ListIRIssBkId : " +ListIRIssBkId);
		
		
		SQLQuery query22 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT ReturnInDays FROM accessibilitymaster where Category='Staff'");
		int ReturnInDays = Integer.parseInt(query22.uniqueResult().toString());

		SQLQuery query23 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT Fine FROM accessibilitymaster where Category='Staff'");
		int FinePerDay = Integer.parseInt(query23.uniqueResult().toString());

		System.out.println(" 3 Queries Executed");

		if (IssueandReturnBookLectID == null && ListIRIssBkId==null) {
			System.out.println("FirstStaff");
			IssueAndReturnBookLecturer issueAndReturnBookLecturer = new IssueAndReturnBookLecturer();
			StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
			AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();

			issueAndReturnBookLecturer.setIssueDate(curentdate);
			issueAndReturnBookLecturer.setLecturerBarcode(readerId);

			accessionLibraryRegister.setAccessionLibraryRegisterId(alrID);
			accessionLibraryRegister.setAccessionId(bookId);
			issueAndReturnBookLecturer.setIARBLecturerA(accessionLibraryRegister);

			staffRegistrationModel.setStaffRegistrationId(staffID);
			issueAndReturnBookLecturer.setStaffRegistrationModel(staffRegistrationModel);

			issueAndReturnBookLecturer.setBookBarcode(bookId);
			
			   // String bookID=bookId.substring(2);
				SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Issued' where AccessionId='"+bookId+"'");
				query20.executeUpdate();
				
			SQLQuery query3 = sessionFactory.getCurrentSession().createSQLQuery(
					"select count(I.IssuedBookStatus) from issueandreturnbooklecturer I where I.staffRegistrationId='"
							+ staffID + "' and I.IssuedBookStatus='Issued'");
			int totalbookIssue = Integer.parseInt(query3.uniqueResult().toString());
			
			if (totalbookIssue > CanIssue) {
				issueAndReturnBookLecturer.setExtraBookStatus("Extra");
				sessionFactory.getCurrentSession().save(issueAndReturnBookLecturer);
			} else {
				sessionFactory.getCurrentSession().save(issueAndReturnBookLecturer);
			}


			// set and save
		} else if (!(IssueandReturnBookLectID == null && ListIRIssBkId==null)) {
			System.out.println("SecondStaff");

			SQLQuery query21 = sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT i.Issuedate FROM issueandreturnbooklecturer i where i.staffRegistrationId='"
							+ staffID + "' and i.AccessionLibraryRegisterId='" + alrID
							+ "' and i.IssuedBookStatus='Issued'");
			String IssueDate = query21.uniqueResult().toString();
			
			//updateSonali
			//String bookID=bookId.substring(2);
			SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Returned' where AccessionId='"+bookId+"'");
			query20.executeUpdate();
			
			long diff = 0;
			int ExtraDays = 0;
			int Calculatedfine = 0;

			System.out.println("curentdate :" + curentdate);
			System.out.println("IssueDate :" + IssueDate);

			String ConvertedCurrentDate = DateConvertor(curentdate);
			String ConvertedIssueDate = DateConvertor(IssueDate);

			long days = getDateDiff(ConvertedCurrentDate, ConvertedIssueDate);
			System.out.println("Return Days :" + days);

			if (days > ReturnInDays) {
				ExtraDays = (int) (days - ReturnInDays);
				System.out.println("ExtraDays"+ExtraDays);
				System.out.println("days"+days);
				System.out.println("ReturnInDays"+ReturnInDays);
				Calculatedfine = ExtraDays * FinePerDay;
				
				System.out.println("ThirdStaff");

				int id = Integer.parseInt(IssueandReturnBookLectID.toString());
				SQLQuery query24 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbooklecturer i set i.IssuedBookStatus='Returned',i.ReturnDate='"
								+ curentdate + "', i.fine = '" + Calculatedfine
								+ "' where i.IssueAndReturnBookLecturerId='" + id + "'");
				query24.executeUpdate();
			}

			else {
				System.out.println("CalculatedFine is 0");
				

				int id = Integer.parseInt(IssueandReturnBookLectID.toString());
				SQLQuery query25 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbooklecturer i set i.IssuedBookStatus='Returned',i.ReturnDate='"
								+ curentdate + "' where i.IssueAndReturnBookLecturerId='" + id + "'");
				query25.executeUpdate();
			}

		}
	}

	@Override
	public String getDetailsStaff(int alrID, int staffID, String readerId, String bookId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT i.IssuedBookStatus FROM issueandreturnbooklecturer i where i.staffRegistrationId='"+staffID+"' and i.AccessionLibraryRegisterId='"+alrID+"' and i.BookBarcode='"+bookId+"' and i.IssueAndReturnBookLecturerId=(select max(v.IssueAndReturnBookLecturerId)as IssueAndReturnBookLecturerId from issueandreturnbooklecturer v where v.staffRegistrationId='"+staffID+"' and v.AccessionLibraryRegisterId='"+alrID+"' and v.BookBarcode='"+bookId+"')");
		
		String Data;
		
		Data=query.uniqueResult().toString();
		
		return Data;
	}

	@Override
	public void issueBookToLecturerDegree(int alrID, String readerId, String bookId, int staffID) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);

		SQLQuery query1 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT canIssue FROM accessibilitymaster where Category='Staff'");
		int CanIssue = Integer.parseInt(query1.uniqueResult().toString());

		
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT i.IssueAndReturnBookLecturerId FROM issueandreturnbooklecturer i where i.IssuedBookStatus='Issued' and i.AccessionLibraryRegisterId='"
						+ alrID + "' and i.staffRegistrationId='" + staffID + "'");
		Object IssueandReturnBookLectID = query.uniqueResult();

		SQLQuery query22 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT ReturnInDays FROM accessibilitymaster where Category='Staff'");
		int ReturnInDays = Integer.parseInt(query22.uniqueResult().toString());

		SQLQuery query23 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT Fine FROM accessibilitymaster where Category='Staff'");
		int FinePerDay = Integer.parseInt(query23.uniqueResult().toString());

		System.out.println(" 3 Queries Executed");

		if (IssueandReturnBookLectID == null) {
			System.out.println("FirstStaff");
			IssueAndReturnBookLecturer issueAndReturnBookLecturer = new IssueAndReturnBookLecturer();
			StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
			AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();

			issueAndReturnBookLecturer.setIssueDate(curentdate);
			issueAndReturnBookLecturer.setLecturerBarcode(readerId);

			accessionLibraryRegister.setAccessionLibraryRegisterId(alrID);
			accessionLibraryRegister.setAccessionId(bookId);
			issueAndReturnBookLecturer.setIARBLecturerA(accessionLibraryRegister);

			staffRegistrationModel.setStaffRegistrationId(staffID);
			issueAndReturnBookLecturer.setStaffRegistrationModel(staffRegistrationModel);

			issueAndReturnBookLecturer.setBookBarcode(bookId);
			
			 //String bookID=bookId.substring(2);
				SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Issued' where AccessionId='"+bookId+"'");
				query20.executeUpdate();
				
			SQLQuery query3 = sessionFactory.getCurrentSession().createSQLQuery(
					"select count(I.IssuedBookStatus) from issueandreturnbooklecturer I where I.staffRegistrationId='"
							+ staffID + "' and I.IssuedBookStatus='Issued'");
			int totalbookIssue = Integer.parseInt(query3.uniqueResult().toString());
			
			if (totalbookIssue > CanIssue) {
				issueAndReturnBookLecturer.setExtraBookStatus("Extra");
				sessionFactory.getCurrentSession().save(issueAndReturnBookLecturer);
			} else {
				sessionFactory.getCurrentSession().save(issueAndReturnBookLecturer);
			}


			// set and save
		} else if (!(IssueandReturnBookLectID == null)) {
			System.out.println("SecondStaff");

			SQLQuery query21 = sessionFactory.getCurrentSession()
					.createSQLQuery("SELECT i.Issuedate FROM issueandreturnbooklecturer i where i.staffRegistrationId='"
							+ staffID + "' and i.AccessionLibraryRegisterId='" + alrID
							+ "' and i.IssuedBookStatus='Issued'");
			String IssueDate = query21.uniqueResult().toString();
			
			//updateSonali
			//String bookID=bookId.substring(2);
			SQLQuery query20=this.sessionFactory.getCurrentSession().createSQLQuery("update accessionlibraryregister set availableStatus='Returned' where AccessionId='"+bookId+"'");
			query20.executeUpdate();
			
			long diff = 0;
			int ExtraDays = 0;
			int Calculatedfine = 0;

			System.out.println("curentdate :" + curentdate);
			System.out.println("IssueDate :" + IssueDate);

			String ConvertedCurrentDate = DateConvertor(curentdate);
			String ConvertedIssueDate = DateConvertor(IssueDate);

			long days = getDateDiff(ConvertedCurrentDate, ConvertedIssueDate);
			System.out.println("Return Days :" + days);

			if (days > ReturnInDays) {
				ExtraDays = (int) (days - ReturnInDays);
				System.out.println("ExtraDays"+ExtraDays);
				System.out.println("days"+days);
				System.out.println("ReturnInDays"+ReturnInDays);
				Calculatedfine = ExtraDays * FinePerDay;
				
				System.out.println("ThirdStaff");

				int id = Integer.parseInt(IssueandReturnBookLectID.toString());
				SQLQuery query24 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbooklecturer i set i.IssuedBookStatus='Returned',i.ReturnDate='"
								+ curentdate + "', i.fine = '" + Calculatedfine
								+ "' where i.IssueAndReturnBookLecturerId='" + id + "'");
				query24.executeUpdate();
			}

			else {
				System.out.println("CalculatedFine is 0");
				

				int id = Integer.parseInt(IssueandReturnBookLectID.toString());
				SQLQuery query25 = sessionFactory.getCurrentSession().createSQLQuery(
						"update issueandreturnbooklecturer i set i.IssuedBookStatus='Returned',i.ReturnDate='"
								+ curentdate + "' where i.IssueAndReturnBookLecturerId='" + id + "'");
				query25.executeUpdate();
			}

		}

	}
	
}
