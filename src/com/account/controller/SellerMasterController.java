package com.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerMasterController {


	@RequestMapping("MasterSellerBillPaymentReport")
	public ModelAndView MasterSellerBillPaymentReport()
	{
		System.out.println("Way to Master Seller Bill payment");
		return new ModelAndView("MasterSellerBillPaymentReportPage");
				
	}
	
	
	@RequestMapping("MasterSellerMaster")
	public ModelAndView MasterSellerMaster()
	{
		System.out.println("Way to Master Seller Master");
		return new ModelAndView("MasterSellerMasterPage");
				
	}
	
	@RequestMapping("MasterSellerReportDateWise")
	public ModelAndView MasterSellerReportDateWise()
	{
		System.out.println("Way to Master Seller Report DateWise");
		return new ModelAndView("MasterSellerReportDateWisePage");
				
	}
	
	@RequestMapping("MasterAllSellerReportBetweenDate")
	public ModelAndView MasterAllSellerReportBetweenDate()
	{
		System.out.println("Way to Master Seller Report Between Date");
		return new ModelAndView("MasterAllSellerReportBetweenDatePage");
				
	}
	
	@RequestMapping("MasterAddAmountToCollege")
	public ModelAndView MasterAddAmountToCollege()
	{
		System.out.println("Way to Master Add Amount To College");
		return new ModelAndView("MasterAddAmountToCollegePage");
				
	}
	
	@RequestMapping("MasterTotalAmountAtCollege")
	public ModelAndView MasterTotalAmountAtCollege()
	{
		System.out.println("Way to Master Total Amount At College");
		return new ModelAndView("MasterTotalAmountAtCollegePage");
				
	}
}
