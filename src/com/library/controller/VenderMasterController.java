package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.VendorMasterModel;
import com.library.serviceInterface.VenderMasterServiceInterface;

@Controller
public class VenderMasterController {

	@Autowired
	private VenderMasterServiceInterface venderMasterServiceInterface;

	public VenderMasterServiceInterface getVenderMasterServiceInterface() {
		return venderMasterServiceInterface;
	}

	public void setVenderMasterServiceInterface(VenderMasterServiceInterface venderMasterServiceInterface) {
		this.venderMasterServiceInterface = venderMasterServiceInterface;
	}
	List<String> VendorList=new ArrayList<>();
	
	@RequestMapping(value="vendorMaster")
	public ModelAndView viewVendorMaster(Model model,HttpServletRequest request,HttpSession session)
	{
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = venderMasterServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

		VendorList=venderMasterServiceInterface.getVenderList();
		model.addAttribute("VendorList",VendorList);
		
		return new ModelAndView("viewVendorMasterPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}
	
	@RequestMapping(value="VendorMaster",params="submitVendor")
	   public ModelAndView submitVendor(Model model,@ModelAttribute("VendorMasterC") VendorMasterModel vendorMasterModel)
	   {
		 venderMasterServiceInterface.submitVendor(vendorMasterModel);
		 VendorList=venderMasterServiceInterface.getVenderList();
			model.addAttribute("VendorList",VendorList);
			return new ModelAndView("viewVendorMasterPage");
	   }
	 @RequestMapping(value="VendorMaster",params="updateVendor")
	   public ModelAndView updateVendor(Model model,@ModelAttribute("VendorMasterC") VendorMasterModel vendorMasterModel)
	   {
		   venderMasterServiceInterface.updateVendor(vendorMasterModel);
		   VendorList=venderMasterServiceInterface.getVenderList();
			model.addAttribute("VendorList",VendorList);
			return new ModelAndView("viewVendorMasterPage");
	   }
	 
	 @RequestMapping(value="VendorMaster",params="deleteVendor")
	   public ModelAndView deleteVendor(Model model,@ModelAttribute("VendorMasterC") VendorMasterModel vendorMasterModel,HttpServletRequest request)
	   {
		   int id=Integer.parseInt(request.getParameter("vendorId"));
		   venderMasterServiceInterface.deleteVendor(id);
		   VendorList=venderMasterServiceInterface.getVenderList();
			model.addAttribute("VendorList",VendorList);
			return new ModelAndView("viewVendorMasterPage");
	   }
}
