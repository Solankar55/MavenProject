package com.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.BooksInDepartmenServiceInterface;

@Controller
public class BooksInDepartmentController {

	@Autowired
	private BooksInDepartmenServiceInterface booksInDepartmenServiceInterface;

	public BooksInDepartmenServiceInterface getBooksInDepartmenServiceInterface() {
		return booksInDepartmenServiceInterface;
	}

	public void setBooksInDepartmenServiceInterface(BooksInDepartmenServiceInterface booksInDepartmenServiceInterface) {
		this.booksInDepartmenServiceInterface = booksInDepartmenServiceInterface;
	}
	
	@RequestMapping("BookInDepartmentPageDisplay")
	public ModelAndView BookInDepartmentPage(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = booksInDepartmenServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			/*
			 * List<BookInDepartment> BookInDepartmentList =
			 * bookInDepartmentServiceInterface.BookInDepartmentList(); return
			 * new
			 * ModelAndView("BookInDepartmentTP","BIDList",BookInDepartmentList)
			 * ;
			 */
			HashMap<String, String> DepartmentList = booksInDepartmenServiceInterface.departmentList();
			return new ModelAndView("BookInDepartmentTP", "DepartmentList", DepartmentList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}
	@RequestMapping(value="getListOfBooks")
	public ModelAndView getListOfBooks(Model model, @RequestParam("Department") String Department)
	{
		HashMap<String,String> DepartmentList = booksInDepartmenServiceInterface.departmentList();
		model.addAttribute("DepartmentList", DepartmentList);
		List ListOfBooks = booksInDepartmenServiceInterface.getListOfBooksInDepartment(Department);
		System.out.println("ListOfBooks :"+ListOfBooks);
		if (ListOfBooks.isEmpty())
		{
			model.addAttribute("NoBooksInDepartmentMsg", "Sorry, Selected department doesn't have any list of books");
			return new ModelAndView("BookInDepartmentTP","BList",ListOfBooks);
			
		}else{
			return new ModelAndView("BookInDepartmentTP","BList",ListOfBooks);
		}
		
	}
}
