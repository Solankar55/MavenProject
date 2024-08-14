package com.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessibilityMaster;
import com.library.model.LibraryAcademicYearModel;
import com.library.serviceInterface.AccessibilityMasterServiceInterface;

@Controller
public class AccessibilityMasterController {

	@Autowired
	private AccessibilityMasterServiceInterface accessibilityMasterServiceInterface;

	public AccessibilityMasterServiceInterface getAccessibilityMasterServiceInterface() {
		return accessibilityMasterServiceInterface;
	}

	public void setAccessibilityMasterServiceInterface(
			AccessibilityMasterServiceInterface accessibilityMasterServiceInterface) {
		this.accessibilityMasterServiceInterface = accessibilityMasterServiceInterface;
	}
	
	@RequestMapping("AccessibilityMasterDisplay")
	public ModelAndView BookIssuerPage(@ModelAttribute("") AccessibilityMaster accessibilityMaster,
			HttpServletRequest request, HttpSession session, Model model) {
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = accessibilityMasterServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = accessibilityMasterServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			List<AccessibilityMaster> AMList = accessibilityMasterServiceInterface.accessibilityList();
			return new ModelAndView("AccessibilityMasterTP", "AMList", AMList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value="AccessibilityDataSave")
	public ModelAndView SaveAddAccessibility(Model model,HttpServletRequest request ,@ModelAttribute("am")AccessibilityMaster am )
	{
		System.out.println("in save accessibility");
		
		int Acyear=Integer.parseInt(request.getParameter("Acyear"));
		System.out.println(Acyear);
		
		String Category=request.getParameter("Category");
		System.out.println(Category);
		
		List<String> getValueList;
		getValueList=accessibilityMasterServiceInterface.getValueList(Acyear,Category);
		System.out.println(getValueList);
		
		if(getValueList.size()==0)
		{
			LibraryAcademicYearModel libraryAcademicYearModel=new LibraryAcademicYearModel();
			libraryAcademicYearModel.setLabacademicyearid(Acyear);
			am.setLibraryAcademicYearModel(libraryAcademicYearModel);
			
			//am.setAcadamicYearModel(acadamicYearModel);
			
			accessibilityMasterServiceInterface.accessibilityDataSave(am);
			
			HashMap<String, String> YearList;
			YearList = accessibilityMasterServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);
			
			List<AccessibilityMaster> AMList = accessibilityMasterServiceInterface.accessibilityList();
			System.out.println("from amlist");
			return new ModelAndView("AccessibilityMasterTP","AMList",AMList);
		}
		else
		{
			int canI=Integer.parseInt(request.getParameter("CanIssue"));
			System.out.println(canI);
			
			int NoDayR=Integer.parseInt(request.getParameter("ReturnInDays"));
			System.out.println(NoDayR);
						
			int FCharge=Integer.parseInt(request.getParameter("Fine"));
			System.out.println(FCharge);
			
			accessibilityMasterServiceInterface.updateValues(Acyear,Category,canI,NoDayR,FCharge);
			
			HashMap<String, String> YearList;
			YearList = accessibilityMasterServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);
			
			List<AccessibilityMaster> AMList = accessibilityMasterServiceInterface.accessibilityList();
			System.out.println("from amlist");
			return new ModelAndView("AccessibilityMasterTP","AMList",AMList);
		}
			
	}

	@RequestMapping(value="GetAccessibilityFeeStructure")
	@ResponseBody
	public List<String> GetAccessibilityFeeStructure(int AcYearID ,String category)
	{
		System.out.println("GetAccessibilityFeeStructure");
		
		List<String> getFeeStructure;
		getFeeStructure=accessibilityMasterServiceInterface.getFeeData(AcYearID,category);
		return getFeeStructure;
	}
	
	@RequestMapping("UpdateAccessibilityData")
	public ModelAndView UpdateSubjectData(@RequestParam("AccessibilityId")int id, @RequestParam("Category")String category,@RequestParam("CanIssue")int canissue,@RequestParam("ReturnInDays")int returnindays,@RequestParam("Fine")int fine)
	{
		System.out.println("hiii");
		accessibilityMasterServiceInterface.updateAccessibilityData(id, category, canissue, returnindays, fine);
		List<AccessibilityMaster> AMList = accessibilityMasterServiceInterface.accessibilityList();
		return new ModelAndView("AccessibilityMasterTP","AMList",AMList);	

	}

	
}
