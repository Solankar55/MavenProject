package com.account.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.serviceInterface.AutoCompleteServiceInterface;

@Controller
public class AutoCompleteController {

	@Autowired
	private AutoCompleteServiceInterface autoCompleteServiceInterface;
	
	public AutoCompleteServiceInterface getAutoCompleteServiceInterface() {
		return autoCompleteServiceInterface;
	}

	public void setAutoCompleteServiceInterface(AutoCompleteServiceInterface autoCompleteServiceInterface) {
		this.autoCompleteServiceInterface = autoCompleteServiceInterface;
	}
	
	@RequestMapping("searchStudentNew")
	@ResponseBody
	public List<String> searchStudentNew(HttpServletRequest request)
	{
		System.out.println("searchStudentNew");
		List<String> keywordList=new ArrayList<>();
		//String keyword=request.getParameter("term");
		keywordList=autoCompleteServiceInterface.serchStudentName(request.getParameter("term"));
		return keywordList;
	}
	
	@RequestMapping("getStudentDetails")
	@ResponseBody
	public List<String> getStudentDetails(String StudentName)
	{
		System.out.println("getStudentDetails");
		List<String> getStudentDetail=new ArrayList<>();
		getStudentDetail=autoCompleteServiceInterface.getStudentAllDataForPayment(StudentName);
		System.out.println(getStudentDetail);
		return getStudentDetail;
	}
}
