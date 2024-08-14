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
import com.library.daoInterface.LibraryReportDaoInterface;

@Repository
public class LibraryReportDaoClass implements LibraryReportDaoInterface{

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
	public List<String> getInvoice(int invoiceno) {
		// TODO Auto-generated method stub
		List<String> getINvoiceData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.Title,q.PrizePerBook,q.Quantity,q.Vendor,a.BookFor,a.QuantityId,t.TotalAmountOfBook,t.TotalDiscountAmount,t.TotalPayableAmount, sum(t.TotalAmountOfBook) as TAOB,sum(t.TotalPayableAmount) as TPA,t.InvoiceDate,a.DiscountRemark FROM quantitydatamaster q left join accessionlibraryregister a on a.QuantityId=q.QuantityId left join transactionmaster t on t.TransactionMasterId=a.TransactionMasterId where InvoiceNo='"+invoiceno+"' group by a.QuantityId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getINvoiceData=	query.list();
		return getINvoiceData;
	}

	@Override
	public List getAuthorList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT distinct author FROM quantitydatamaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List AuthorList=query.list();
		return AuthorList;
	}

	@Override
	public List getTitleList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT distinct title FROM quantitydatamaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List TitleList=query.list();
		return TitleList;
	}

	@Override
	public HashMap getBookType() {
		// TODO Auto-generated method stub
		HashMap vendorNameL=new HashMap<>();
		  List<HashMap> BookTypeList=new ArrayList<>();
		 
		  SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT b.BooktypeId, b.Booktype FROM booktypemaster b");
		 query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		 BookTypeList=query.list();
		  vendorNameL.clear();
		  for(HashMap m:BookTypeList)
		  {
			  vendorNameL.put(m.get("BooktypeId"), m.get("Booktype")); 
		  }
			return vendorNameL;
		
	}

	@Override
	public HashMap getacademicYearList() {
		// TODO Auto-generated method stub
		HashMap academicYearL=new HashMap<>();
		  List<HashMap> AcademicYearList=new ArrayList<>();
		 
		  SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT l.labacademicyearid, l.labacademicyear FROM libraryacademicyearmodel l");
		 query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		 AcademicYearList=query.list();
		 academicYearL.clear();
		  for(HashMap m:AcademicYearList)
		  {
			  academicYearL.put(m.get("labacademicyearid"), m.get("labacademicyear")); 
		  }
			return academicYearL;
		
	}

	@Override
	public HashMap getvendorName() {
		// TODO Auto-generated method stub
		HashMap vendorNameL=new HashMap<>();
		  List<HashMap> VendorList=new ArrayList<>();
		 
		  SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT vendorId,vendorName FROM vendormastermodel");
		 query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		  VendorList=query.list();
		  vendorNameL.clear();
		  for(HashMap m:VendorList)
		  {
			  vendorNameL.put(m.get("vendorId"), m.get("vendorName")); 
		  }
			return vendorNameL;
	}

	@Override
	public HashMap<String, String> bookTypeList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM Booktypemaster");
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
	public List<String> getBookBankData() {
		// TODO Auto-generated method stub
		List<String> BBData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.labacademicyear,s.admissionRegId,s.studentFirstName,s.studentLastName,s.studentCategory,b.bookAccessionId,q.Title,q.author, b.bkIssueDate,b.bkReturnDate , b.IssuedBookStatus ,b.Fine FROM bookbankissuereturn b left join studentadmission s on s.admissionRegId=b.admissionRegId left join  accessionlibraryregister a on  a.AccessionLibraryRegisterId=b.AccessionLibraryRegisterId left join  libraryacademicyearmodel l on l.labacademicyearid=a.labacademicyearid left join quantitydatamaster q on q.QuantityId=a.QuantityId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BBData=	query.list();
		return BBData;
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list = new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT l.labacademicyearid,l.labacademicyear FROM libraryacademicyearmodel l ");
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
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM LibrarySubjectMaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<HashMap> lsmList=query.list();
		HashMap MapOfSubjectList = new HashMap<>();
		for(HashMap map:lsmList)
		{
			MapOfSubjectList.put(map.get("LibrarySubjectMasterId"), map.get("LibrarySubject"));
		}
		return MapOfSubjectList;
	}

	@Override
	public List getPublicationList() {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT Distinct q.Publisher FROM quantitydatamaster q");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List publicationList=query.list();
		System.out.println("The Publisher List: " +publicationList);
		return publicationList;
	}

	@Override
	public List<String> getStaffIssueReturnData() {
		// TODO Auto-generated method stub
		List<String> StaffData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AccessionId ,q.BookFor,s.StaffName,s.SatffDepartment,s.MobileNumber, q.Title ,q.Author ,i.Fine, i.IssueDate, i.IssuedBookStatus,i.ReturnDate FROM issueandreturnbooklecturer i inner join accessionlibraryregister a on a.AccessionLibraryRegisterId=i.AccessionLibraryRegisterId inner join quantitydatamaster q on q.QuantityId=a.QuantityId inner join staffregistration s on s.staffRegistrationId=i.staffRegistrationId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StaffData=	query.list();
		return StaffData;
	}

	@Override
	public List<String> getStudentIssueReturnData() {
		// TODO Auto-generated method stub
		List<String> StudentData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT  i.BookAccessionId,q.BookFor,s.studentFirstName,s.studentLastName,st.streamName,b.branchName,stnd.standard,s.studentContactNumber,q.Title,q.Author,i.IssueDate,i.IssuedBookStatusStud,ifnull(i.ReturnDate,'-') as ReturnDate,i.Fine FROM issueandreturnbookstudent i left join studentadmission s on s.admissionRegId=i.admissionRegId left join  branchmaster b on b.branchId=s.branchId left join streammaster st on st.streamId=s.streamId left join standardmaster stnd on stnd.standardId=s.standardId left join accessionlibraryregister alr on alr.AccessionLibraryRegisterId=i.AccessionLibraryRegisterId left join quantitydatamaster q on q.QuantityId=alr.QuantityId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentData=query.list();
		System.out.println("StudentData in Dao" +StudentData);
		return StudentData;
	}
	
	
}
