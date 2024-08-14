package com.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.serviceInterface.BookHolderServiceInterface;

@Controller
public class BookHolderController {

	@Autowired
	private BookHolderServiceInterface bookHolderServiceInterface;

	public BookHolderServiceInterface getBookHolderServiceInterface() {
		return bookHolderServiceInterface;
	}

	public void setBookHolderServiceInterface(BookHolderServiceInterface bookHolderServiceInterface) {
		this.bookHolderServiceInterface = bookHolderServiceInterface;
	}
	
	@RequestMapping("ExtraBook")
	ModelAndView extrabook(@RequestParam Map<String, String> getdetail,Model model){
		
		List<String> TableData= new ArrayList<String>();
		
		model.addAttribute("TableData", TableData);
		return new ModelAndView("ExtraBookHolderPage");	
	}
	
	@RequestMapping("GetHolderDetails")
	ModelAndView extrabookOnClick(@RequestParam Map<String, String> getdetail, Model model){
		
		String holder=getdetail.get("Category");
		List<String> TableDataStud= new ArrayList<String>();
		List<String> tabledataStaff= new ArrayList<String>();
		if (holder.equals("Student")){
		    TableDataStud=bookHolderServiceInterface.getBookHolder(holder);
		    /*model.addAttribute("TableData", TableDataStud);*/
		       if(TableDataStud.isEmpty())
		           {
					        model.addAttribute("StudentDataNotPresentMsg", "Sorry, No record for this selection");
		           }else{
							model.addAttribute("TableData", TableDataStud);
		           }
		
		
		}else{
			
			tabledataStaff=bookHolderServiceInterface.getHOdlerStaff(holder);
			/*model.addAttribute("tabledataStaff", tabledataStaff);*/
			
			if(tabledataStaff.isEmpty())
	           {
				        model.addAttribute("StaffDataNotPresentMsg", "Sorry, No record for this selection");
	           }else{
	        	        model.addAttribute("tabledataStaff", tabledataStaff);
	           }	
		}
		
		 return new ModelAndView("ExtraBookHolderPage");
		
	}
}
