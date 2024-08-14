package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.BookInformationServiceInterface;

@Controller
public class BookInformationController {

	@Autowired
	private BookInformationServiceInterface bookInformationServiceInterface;

	public BookInformationServiceInterface getBookInformationServiceInterface() {
		return bookInformationServiceInterface;
	}

	public void setBookInformationServiceInterface(BookInformationServiceInterface bookInformationServiceInterface) {
		this.bookInformationServiceInterface = bookInformationServiceInterface;
	}
	
	@RequestMapping("bookInformation")
	public ModelAndView bookInfo(Model model,HttpServletRequest request,HttpSession session)
	{	
		System.out.println("on the Book Info page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = bookInformationServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
		
			return new ModelAndView("bookInformationView");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}
	@RequestMapping("searchSubName")
	@ResponseBody
	public List<String> autocomplete(HttpServletRequest request){
		System.out.println("hii searchSubName Called");
		List<String> keyword=new ArrayList<String>();
		keyword=bookInformationServiceInterface.searchSubject(request.getParameter("term"));
		return keyword;
	}
	
	
	@RequestMapping("searchTitleName")
	@ResponseBody
	public List<String> autocompletetitle(HttpServletRequest request){
		System.out.println("hii searchSubName Called");
		List<String> keyword=new ArrayList<String>();
		keyword=bookInformationServiceInterface.searchTitle(request.getParameter("term"));
		return keyword;
	}
	
	
	@RequestMapping("searchAuthorName")
	@ResponseBody
	public List<String> autocompleteauthor(HttpServletRequest request){
		System.out.println("hii searchAName Called");
		List<String> keyword=new ArrayList<String>();
		keyword=bookInformationServiceInterface.searchAuthor(request.getParameter("term"));
		return keyword;
	}
	
	@RequestMapping("getSubjectList")
	@ResponseBody
	public List<String> subBookList(String subjectName)
	{
		List<String> subList=new ArrayList<>();
		subList=bookInformationServiceInterface.getSubjectWiseList(subjectName);
		System.out.println("subList in controller: " +subList);
		return subList;
		
	}
	
	
	@RequestMapping("getTitleList")
	@ResponseBody
	public List<String> getTitleList(String titleName)
	{
		List<String> titleList=new ArrayList<>();
		titleList=bookInformationServiceInterface.getTitleWiseList(titleName);
		System.out.println("subList in controller: " +titleList);
		return titleList;
		
	}
	
	@RequestMapping("getAuthorList")
	@ResponseBody
	public List<String> getAuthorList(String authorName)
	{
		List<String> authorList=new ArrayList<>();
		authorList=bookInformationServiceInterface.getAuthorWiseList(authorName);
		System.out.println("authorList in controller: " +authorList);
		return authorList;
		
	}
	@RequestMapping("getBooksubTitleList")
	@ResponseBody
	public List<String> getBookSubTitle(String subName,String titleName,String authorName)
	{
		List<String> subTitleList=bookInformationServiceInterface.getBookSubTitleInfo(subName,titleName,authorName);
		return subTitleList;
	}
	
	
	@RequestMapping("getBookSubAuthorList")
	@ResponseBody
	public List<String> getBookSubAuthor(String subName,String titleName,String authorName)
	{
		List<String> subAuthorList=bookInformationServiceInterface.getBookSubAuthorInfo(subName,titleName,authorName);
		return subAuthorList;
	}
	
	@RequestMapping("getBookTitleAuthorList")
	@ResponseBody
	public List<String> getBookTitleAuthorList(String subName,String titleName,String authorName)
	{ 
		List<String> titleAuthorList=new ArrayList<>();
		titleAuthorList=bookInformationServiceInterface.getBookTitleAuthorList(subName,titleName,authorName);
		System.out.println("subList in controller: " +titleAuthorList);
		return titleAuthorList;
		
	}
	
	@RequestMapping("getBookDetailList")
	@ResponseBody
	public List<String> getBookInfoList(String subName,String titleName,String authorName)
	{ 
		List<String> titleList=new ArrayList<>();
		titleList=bookInformationServiceInterface.getBookList(subName,titleName,authorName);
		System.out.println("subList in controller: " +titleList);
		return titleList;
		
	}
}
