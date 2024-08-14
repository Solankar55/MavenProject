package com.webService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.webService.serviceinterface.WebServiceServiceInterface;

@Controller
public class WebServiceController {

	@Autowired
	private WebServiceServiceInterface webServiceServiceInterface;

	public WebServiceServiceInterface getWebServiceServiceInterface() {
		return webServiceServiceInterface;
	}

	public void setWebServiceServiceInterface(WebServiceServiceInterface webServiceServiceInterface) {
		this.webServiceServiceInterface = webServiceServiceInterface;
	}

	/*
	 * http://localhost:8082/CollegeManagementSystem/GetAcademicYearList.html
	 */ @RequestMapping("GetAcademicYearList")
	@ResponseBody
	public List<String> GetAcademicYearList() {
		System.out.println("Academic Year Web Service");
		List<String> GetYearlist;
		GetYearlist = webServiceServiceInterface.getYearList();
		return GetYearlist;
	}

	/*
	 * http://localhost:8082/CollegeManagementSystem/GetStreamList.html
	 */ @RequestMapping("GetStreamList")
	@ResponseBody
	public List<String> getStreamList() {
		System.out.println("Stream List Web Service");
		List<String> StreamList;
		StreamList = webServiceServiceInterface.getStreamList();
		return StreamList;
	}

	/*
	 * http://localhost:8082/CollegeManagementSystem/GetBranchList.html?StreamID
	 * =1
	 */ @RequestMapping("GetBranchList")
	@ResponseBody
	public JSONObject GetBranchList(int StreamID) {
		List<String> BranchList = new ArrayList<>();
		BranchList = webServiceServiceInterface.getBranchList(StreamID);
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("BranchList", BranchList);
		return jSONObject;
	}

	/*
	 * http://localhost:8082/CollegeManagementSystem/GetStandardList.html?
	 * BranchID=1
	 */ @RequestMapping("GetStandardList")
	@ResponseBody
	public JSONObject GetStandardList(int BranchID) {
		List<String> StandardList = new ArrayList<>();
		StandardList = webServiceServiceInterface.getStandardList(BranchID);
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("StandardList", StandardList);
		return jSONObject;
	}

	/*
	 * http://localhost:8082/CollegeManagementSystem/GetStudentList.html?YearID=
	 * 1&StreamID=1&BranchID=1&StandardID=1
	 */ @RequestMapping("GetStudentList")
	@ResponseBody
	public JSONObject GetStudentList(int YearID, int StreamID, int BranchID, int StandardID) {
		List<String> StudentList = new ArrayList<>();
		StudentList = webServiceServiceInterface.getStudentList(YearID, StreamID, BranchID, StandardID);
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("StudentList", StudentList);
		return jSONObject;
	}

	/*
	 * http://localhost:8080/CollegeManagementSystem/UserAuthentication.html?
	 * UserName=Pranav&PassWord=Pranav
	 */ @RequestMapping("UserAuthentication")
	@ResponseBody
	public JSONObject UserAuthentication(String UserName, String PassWord) {
		System.out.println("User Authetication Page");

		List<String> UserDetails = new ArrayList<>();
		UserDetails = webServiceServiceInterface.getUserAuthenticationCheck(UserName, PassWord);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("UserDetails", UserDetails);
		return jsonObject;
	}

	 
}
