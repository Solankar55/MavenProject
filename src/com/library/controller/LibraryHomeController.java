package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.LibraryHomeServiceInterface;

@Controller
public class LibraryHomeController {

	@Autowired
	private LibraryHomeServiceInterface libraryHomeServiceInterface;

	public LibraryHomeServiceInterface getLibraryHomeServiceInterface() {
		return libraryHomeServiceInterface;
	}

	public void setLibraryHomeServiceInterface(LibraryHomeServiceInterface libraryHomeServiceInterface) {
		this.libraryHomeServiceInterface = libraryHomeServiceInterface;
	}
	
	@RequestMapping("LibraryHome")
	public ModelAndView LibraryHome(HttpServletRequest request,HttpSession session,Model model) {
		System.out.println("Library Home");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryHomeServiceInterface.checkAdmin(username);
		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
		return new ModelAndView("LibHome");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}
	
}
