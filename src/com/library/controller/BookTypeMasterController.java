package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.BookTypeMaster;
import com.library.serviceInterface.BookTypeMasterServiceInterface;

@Controller
public class BookTypeMasterController {

	@Autowired
	private BookTypeMasterServiceInterface bookTypeMasterServiceInterface;

	public BookTypeMasterServiceInterface getBookTypeMasterServiceInterface() {
		return bookTypeMasterServiceInterface;
	}

	public void setBookTypeMasterServiceInterface(BookTypeMasterServiceInterface bookTypeMasterServiceInterface) {
		this.bookTypeMasterServiceInterface = bookTypeMasterServiceInterface;
	}
	
	@RequestMapping("BookTypeMasterDisplay.html")
	public ModelAndView BookTypePage(HttpServletRequest request, HttpSession session, Model model) {
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = bookTypeMasterServiceInterface.checkAdmin(username);
		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			List<BookTypeMaster> BTMList = bookTypeMasterServiceInterface.bookTypeSimpleList();
			return new ModelAndView("BookTypeMasterTP", "BTMList", BTMList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}

	}
	
	@RequestMapping(value="BookTypeData")
	public ModelAndView SaveBookTypeMaster(@ModelAttribute("SaveBrand") BookTypeMaster book, Model model)
	{		
		bookTypeMasterServiceInterface.bookSave(book);
		List<BookTypeMaster> BTMList = bookTypeMasterServiceInterface.bookTypeSimpleList();
		return new ModelAndView("BookTypeMasterTP","BTMList",BTMList);
	}
	
	@RequestMapping("UpdateBookTypeData")
	public ModelAndView UpdateBookTypeData(@RequestParam("BookTypeId") int id, @RequestParam("BookType") String BookType)
	{
		bookTypeMasterServiceInterface.UpdateBookTypeData(id, BookType);
		List<BookTypeMaster> BTMList = bookTypeMasterServiceInterface.bookTypeSimpleList();
		return new ModelAndView("BookTypeMasterTP","BTMList",BTMList);
	}
	
	@RequestMapping(value="UpdateBookTypeData",params="Delete")
	public ModelAndView DeleteBookTypeData(@RequestParam("BookTypeId") int id, @RequestParam("BookType") String BookType)
	{
		
		bookTypeMasterServiceInterface.deleteBookTypeData(id);
		List<BookTypeMaster> BTMList = bookTypeMasterServiceInterface.bookTypeSimpleList();
		return new ModelAndView("BookTypeMasterTP","BTMList",BTMList);
	}

}
