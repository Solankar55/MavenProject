package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;

@Repository
public class BookInformationDaoInterface implements com.library.daoInterface.BookInformationDaoInterface {

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
	public List<String> searchSubject(String parameter) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select distinct l.LibrarySubject from librarysubjectmaster l  where l.LibrarySubject like :keyword ");
		query.setString("keyword", "%" + parameter + "%");
		result=query.list();
		return result;

	}

	@Override
	public List<String> searchTitle(String parameter) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT distinct q.Title FROM quantitydatamaster q where q.Title like :keyword ");
		query.setString("keyword", "%" + parameter + "%");
		result=query.list();
		return result;
	}

	@Override
	public List<String> searchAuthor(String parameter) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT distinct q.Author FROM quantitydatamaster q where q.Author like :keyword ");
		query.setString("keyword", "%" + parameter + "%");
		result=query.list();
				return result;
	}
	
	@Override
	public List<String> getSubjectWiseList(String subjectName) {
		// TODO Auto-generated method stub
		List<String> subjectList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,b.Booktype,(select count(q.quantity) from quantitydatamaster q left join accessionlibraryregister a on q.QuantityId=a.QuantityId left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where a.availableStatus='Returned' and l.LibrarySubject='"+subjectName+"') as StockQuantity,q.Edition,q.Author,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and l.LibrarySubject='"+subjectName+"' group by q.author ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		subjectList=query.list();
		System.out.println("subjectList : " +subjectList);
		
		return subjectList;
	}

	@Override
	public List<String> getTitleWiseList(String titleName) {
		// TODO Auto-generated method stub
		List<String> TitletList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,b.Booktype,q.Quantity as StockQuantity,q.Edition,q.Author,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  q.Title='"+titleName+"' group by q.author");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		TitletList=query.list();
		System.out.println("TitletList : " +TitletList);
		return TitletList;
	}

	@Override
	public List<String> getAuthorWiseList(String authorName) {
		// TODO Auto-generated method stub
		List<String> AuthorList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,b.Booktype,q.Quantity as StockQuantity,q.Edition,q.Author,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  q.author='"+authorName+"'group by q.author ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AuthorList=query.list();
		System.out.println("AuthorList : " +AuthorList);
		return AuthorList;
	}
	
	@Override
	public List<String> getBookList(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		List<String> BookDataList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,q.Author,b.Booktype,count(q.Quantity) as StockQuantity,q.Edition,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  l.LibrarySubject='"+subName+"' and q.Title='"+titleName+"'  and q.author='"+authorName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BookDataList=query.list();
		System.out.println("BookDetailList : " +BookDataList);
		return BookDataList;
	}

	@Override
	public List<String> getBookSubTitleInfo(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		List<String> bookSubTitle=new ArrayList<>();
	    SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,q.Author,b.Booktype,(select count(q.quantity) from quantitydatamaster q left join accessionlibraryregister a on q.QuantityId=a.QuantityId left join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId where a.availableStatus='Returned' and l.LibrarySubject='"+subName+"' and q.Title='"+titleName+"' group by q.Title) as StockQuantity,q.Edition,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  l.LibrarySubject='"+subName+"' and q.Title='"+titleName+"' group by q.Title");
	    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    bookSubTitle=query.list();
		return bookSubTitle;
	}

	@Override
	public List<String> getBookSubAuthorInfo(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		List<String> bookSubAuthor=new ArrayList<>();
	    SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,q.Author,b.Booktype,count(q.Quantity) as StockQuantity,q.Edition,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  l.LibrarySubject='"+subName+"' and q.author='"+authorName+"' ");
	    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    bookSubAuthor=query.list();
		return bookSubAuthor;
	}

	@Override
	public List<String> getBookTitleAuthorList(String subName, String titleName, String authorName) {
		// TODO Auto-generated method stub
		List<String> bookTitleAuthor=new ArrayList<>();
	    SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LibrarySubject,q.BookFor,q.Title,q.Author,b.Booktype,count(q.Quantity) as StockQuantity,q.Edition,q.PublicationYear,q.Publisher FROM quantitydatamaster q inner join accessionlibraryregister a on q.quantityid=a.quantityid inner join librarysubjectmaster l on l.LibrarySubjectMasterId=q.LibrarySubjectMasterId inner join booktypemaster b on b.BooktypeId=q.BooktypeId where a.availableStatus='Returned' and  q.Title='"+titleName+"'  and q.author='"+authorName+"' ");
	    query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    bookTitleAuthor=query.list();
		return bookTitleAuthor;
	}

	
	
}
