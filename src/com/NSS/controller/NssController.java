package com.NSS.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.NSS.model.RegisterNssStudentModel;
import com.NSS.serviceInterface.RegisterStudentServiceInterface;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;

@Controller
public class NssController {

	@Autowired
	private RegisterStudentServiceInterface registerStudentServiceInterface;
	
	@RequestMapping("RegisterStudentNSSForm")
	public ModelAndView RegisterNSS(Model model)
	{
		System.out.println("Register New Student NSS");
		
		HashMap<String, String> YearList;
		YearList = registerStudentServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> streamList;
		streamList = registerStudentServiceInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		model.addAttribute("curentdate", curentdate);
		
		return new ModelAndView("RegisterNSSPage");
	}
	
	@RequestMapping("GetBranchListJsonNSS")
	@ResponseBody
	public List<String> GetBranchListJsonNSS(int id)
	{
		List<String> getBranchList = new ArrayList<>();
		getBranchList = registerStudentServiceInterface.getBranchList(id);
		return getBranchList;
	}
	
	@RequestMapping("GetStandardListJSONNSS")
	@ResponseBody
	public List<String> GetStandardListJSONNSS(int branchid)
	{
		List<String> GetStandardList = new ArrayList<>();
		GetStandardList = registerStudentServiceInterface.getStandardList(branchid);
		return GetStandardList;
	}
	
	@RequestMapping(value="SaveNssStudentForm",params="RegistersNSS")
	public ModelAndView RegisterNSsForm(Model model,HttpServletRequest request)
	{
		System.out.println("Register Student NSs");
		
		String StudName=request.getParameter("StudName");
		System.out.println(StudName);
		
		String StudAddress=request.getParameter("StudAddress");
		System.out.println(StudAddress);
		
		String PhoneNumber=request.getParameter("PhoneNumber");
		System.out.println(PhoneNumber);
		
		String MobileNumber=request.getParameter("MobileNumber");
		System.out.println(MobileNumber);
		
		String StudMail=request.getParameter("StudMail");
		System.out.println(StudMail);
		
		String StudCategory=request.getParameter("StudCategory");
		System.out.println(StudCategory);
		
		int StudMark=Integer.parseInt(request.getParameter("StudMark"));
		System.out.println(StudMark);
		
		int StudMarkOutOff=Integer.parseInt(request.getParameter("StudMarkOutOff"));
		System.out.println(StudMarkOutOff);
		
		String StudPercent=request.getParameter("StudPercent");
		System.out.println(StudPercent);
		
		String ApplicaionDate=request.getParameter("ApplicaionDate");
		System.out.println(ApplicaionDate);
		
		String StudPlace=request.getParameter("StudPlace");
		System.out.println(StudPlace);
		
		int YearID=Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);
		
		int StreamID=Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);
		
		int branchID=Integer.parseInt(request.getParameter("branchID"));
		System.out.println(branchID);
		
		int standardID=Integer.parseInt(request.getParameter("standardID"));
		System.out.println(standardID);
		
		int StudMarkPCM=Integer.parseInt(request.getParameter("StudMarkPCM"));
		System.out.println(StudMarkPCM);
		
		int StudMarkPCB=Integer.parseInt(request.getParameter("StudMarkPCB"));
		System.out.println(StudMarkPCB);
		
		int StudMarkPCMB=Integer.parseInt(request.getParameter("StudMarkPCMB"));
		System.out.println(StudMarkPCMB);
		
		RegisterNssStudentModel registerNssStudentModel=new RegisterNssStudentModel();
		
		registerNssStudentModel.setStudName(StudName);
		registerNssStudentModel.setStudAddress(StudAddress);
		registerNssStudentModel.setPhoneNumber(PhoneNumber);
		registerNssStudentModel.setMobileNumber(MobileNumber);
		registerNssStudentModel.setStudMail(StudMail);
		registerNssStudentModel.setStudCategory(StudCategory);
		
		
		acadamicYearModel acadamicYearModel=new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(YearID);
		registerNssStudentModel.setAcadamicYearModel(acadamicYearModel);
		
		StreamMasterModel streamMasterModel=new StreamMasterModel();
		streamMasterModel.setStreamId(StreamID);
		registerNssStudentModel.setStreamMasterModel(streamMasterModel);
		
		BranchMasterModel branchMasterModel=new BranchMasterModel();
		branchMasterModel.setBranchId(branchID);
		registerNssStudentModel.setBranchMasterModel(branchMasterModel);
		
		StandardMasterModel standardMasterModel=new StandardMasterModel();
		standardMasterModel.setStandardId(standardID);
		registerNssStudentModel.setStandardMasterModel(standardMasterModel);
		
		registerNssStudentModel.setStudMark(StudMark);
		registerNssStudentModel.setStudMarkOutOff(StudMarkOutOff);
		registerNssStudentModel.setStudPercent(StudPercent);
		registerNssStudentModel.setApplicaionDate(ApplicaionDate);
		registerNssStudentModel.setStudPlace(StudPlace);
		
		registerNssStudentModel.setStudMarkPCM(StudMarkPCM);
		registerNssStudentModel.setStudMarkPCB(StudMarkPCB);
		registerNssStudentModel.setStudMarkPCMB(StudMarkPCMB);
		
		registerStudentServiceInterface.saveNssUser(registerNssStudentModel);
		
		return new ModelAndView("SuccessRegisterNSSPage");
	}
	
	
}
