package com.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.LibraryBooksRecordDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class LibraryBooksRecordDaoClass implements LibraryBooksRecordDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public HashMap<String, String> getBookSubList() {
		// TODO Auto-generated method stub
		List<HashMap> booklist =new ArrayList<>();
		HashMap mapOfBookListInfo=new HashMap<>();

		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubjectMasterId,l.LibrarySubject FROM librarysubjectmaster l");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		booklist=query.list();

		System.out.println("booklist : " +booklist);

		for(HashMap map:booklist)
		{
			mapOfBookListInfo.put(map.get("LibrarySubjectMasterId"), map.get("LibrarySubject"));
		}
		return mapOfBookListInfo;
	}

	@Override
	public HashMap<String, String> getBookTitleList() {
		// TODO Auto-generated method stub
		List<HashMap> bookTlist =new ArrayList<>();
		HashMap mapOfBookListInfo=new HashMap<>();

		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.QuantityId ,  q.Title FROM quantitydatamaster q");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		bookTlist=query.list();

		System.out.println("bookTlist : " +bookTlist);

		for(HashMap map:bookTlist)
		{
			mapOfBookListInfo.put(map.get("QuantityId"), map.get("Title"));
		}
		return mapOfBookListInfo;
	}

	@Override
	public HashMap<String, String> getBookAuthourList() {
		// TODO Auto-generated method stub
		List<HashMap> bookAlist =new ArrayList<>();
		HashMap mapOfBookListInfo=new HashMap<>();

		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.QuantityId ,  q.Author FROM quantitydatamaster q");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		bookAlist=query.list();

		System.out.println("bookTlist : " +bookAlist);

		for(HashMap map:bookAlist)
		{
			mapOfBookListInfo.put(map.get("QuantityId"), map.get("Author"));
		}
		return mapOfBookListInfo;
	}

	@Override
	public List<String> getBookInfo(String bookName) {
		// TODO Auto-generated method stub
		List<String> books=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT  q.BookFor, q.Title ,q.Author,   q.Edition  , q.Publisher ,q.PublicationYear, q.quantity,q.PrizePerBook,l.LibrarySubjectMasterId FROM quantitydatamaster q left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where q.Title='"+bookName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		books=query.list();
		System.out.println("books : " +books);
		return books;
	}

	@Override
	public List<String> getBookSubInfo(String bookName,String bookfor) {
		// TODO Auto-generated method stub
		List<String> books=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.BookFor, q.Title ,q.Author,   q.Edition  , q.PublicationYear, q.Publisher ,q.quantity ,q.PrizePerBook,l.LibrarySubjectMasterId FROM quantitydatamaster q left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where q.LibrarySubjectMasterId='"+bookName+"' and q.BookFor like '"+bookfor+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		books=query.list();
		System.out.println("books : " +books);
		return books;
	}

	@Override
	public List<String> getBookAuthorInfo(String authorName) {
		// TODO Auto-generated method stub
		List<String> books=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.BookFor, q.Title ,q.Author,   q.Edition  , q.Publisher ,q.PublicationYear, q.quantity,q.PrizePerBook,l.LibrarySubjectMasterId FROM quantitydatamaster q left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where q.author='"+authorName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		books=query.list();
		System.out.println("books : " +books);
		return books;
	}

	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> studentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId,s.StudentName,s.StudentContactNumber,s.StudentEmail FROM studentregistration s where s.StudentUserName='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		studentList=query.list();

		return studentList;
	}

	@Override
	public List<String> getBookPublisherInfo(String bookName) {
		// TODO Auto-generated method stub
		List<String> books=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT q.BookFor, q.Title ,q.Author,   q.Edition  , q.Publisher ,q.PublicationYear, q.quantity,q.PrizePerBook,l.LibrarySubjectMasterId FROM quantitydatamaster q left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where q.Publisher='"+bookName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		books=query.list();
		System.out.println("publishar books : " +books);
		return books;
	}

	@Override
	public List<StudentAdmissionModel> getStudAdmissionInfo(String studCon, String studEmail) {
		// TODO Auto-generated method stub

		List<StudentAdmissionModel> admissionData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.studentnamessc FROM studentadmission s where s.StudentEmail='"+studEmail+"' and s.StudentContactNumber='"+studCon+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		admissionData=query.list();
		return admissionData;
	}

	@Override
	public List<String> getStudDetails(String username1) {
		// TODO Auto-generated method stub

		List<String> GetStudInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from studentregistration where StudentUserName='"+username1+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStudInfo=query.list();
		return GetStudInfo;

	}



}
