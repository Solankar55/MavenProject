package com.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.QuantityDataMaster;
import com.library.serviceInterface.AccessionLibraryRegisterServiceInterface;
import com.student.model.StudentRegistrationModel;

@Controller
public class AccessionLibraryRegisterController {

	@Autowired
	private AccessionLibraryRegisterServiceInterface accessionLibraryRegisterServiceInterface;

	public AccessionLibraryRegisterServiceInterface getAccessionLibraryRegisterServiceInterface() {
		return accessionLibraryRegisterServiceInterface;
	}

	public void setAccessionLibraryRegisterServiceInterface(
			AccessionLibraryRegisterServiceInterface accessionLibraryRegisterServiceInterface) {
		this.accessionLibraryRegisterServiceInterface = accessionLibraryRegisterServiceInterface;
	}

	List<String> purchaseList = new ArrayList<>();

	@RequestMapping("AccessionLibraryRegisterDisplay")
	public ModelAndView BookRegi(Model model, HttpSession session, HttpServletRequest request,
			StudentRegistrationModel studentRegistrationModel) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = accessionLibraryRegisterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = accessionLibraryRegisterServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> LibrarySubjectList = accessionLibraryRegisterServiceInterface.librarySubjectList();
			model.addAttribute("Slist", LibrarySubjectList);
			HashMap<String, String> BTMList = accessionLibraryRegisterServiceInterface.BookTypeList();

			HashMap vendorNameL = new HashMap<>();
			vendorNameL = accessionLibraryRegisterServiceInterface.getvendorName();
			model.addAttribute("vendorNameL", vendorNameL);
			String id = "0";
			model.addAttribute("id", id);
			return new ModelAndView("AccessionLibraryRegisterTP", "BTMList", BTMList);

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "venderDiscountA", method = RequestMethod.GET)
	@ResponseBody
	public List<String> vendorDis(String id) {
		List<String> discountA = new ArrayList<>();
		discountA = accessionLibraryRegisterServiceInterface.vendorDis(id);
		return discountA;
	}

	@RequestMapping(value = "AccessionDataSave", params = "PurchaseBook")
	public ModelAndView purchaseBook(Model model, @ModelAttribute("alr") QuantityDataMaster quantityDataMaster,
			HttpServletRequest req) {

		accessionLibraryRegisterServiceInterface.purchaseBook(quantityDataMaster, req);

		HashMap<String, String> YearList;
		YearList = accessionLibraryRegisterServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> LibrarySubjectList = accessionLibraryRegisterServiceInterface.librarySubjectList();
		model.addAttribute("Slist", LibrarySubjectList);
		String id = "1";
		model.addAttribute("id", id);
		HashMap<String, String> BTMList = accessionLibraryRegisterServiceInterface.BookTypeList();

		HashMap vendorNameL = new HashMap<>();
		vendorNameL = accessionLibraryRegisterServiceInterface.getvendorName();
		model.addAttribute("vendorNameL", vendorNameL);
		purchaseList = accessionLibraryRegisterServiceInterface.getpurchaseBookList();
		model.addAttribute("purchaseList", purchaseList);

		/*
		 * purchaseBookList=accessionLibraryRegisterServiceInterface.
		 * getPurchaseList();
		 */

		System.out.println("anilsssssssssssssssssssssssss");
		return new ModelAndView("AccessionLibraryRegisterTP", "BTMList", BTMList);
	}

	// update PurchaseBook
	@RequestMapping(value = "AccessionDataSave", params = "UopdatePurchaseBook")
	public ModelAndView updateA(Model model, @ModelAttribute("alr") QuantityDataMaster quantityDataMaster,
			HttpServletRequest req) {

		accessionLibraryRegisterServiceInterface.updateBook(quantityDataMaster, req);
		HashMap<String, String> YearList;
		YearList = accessionLibraryRegisterServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> LibrarySubjectList = accessionLibraryRegisterServiceInterface.librarySubjectList();
		model.addAttribute("Slist", LibrarySubjectList);
		String id = "1";
		model.addAttribute("id", id);
		HashMap<String, String> BTMList = accessionLibraryRegisterServiceInterface.BookTypeList();

		HashMap vendorNameL = new HashMap<>();
		vendorNameL = accessionLibraryRegisterServiceInterface.getvendorName();
		model.addAttribute("vendorNameL", vendorNameL);

		purchaseList = accessionLibraryRegisterServiceInterface.getpurchaseBookList();
		model.addAttribute("purchaseList", purchaseList);
		System.out.println("maheshsssssssssss");
		return new ModelAndView("AccessionLibraryRegisterTP", "BTMList", BTMList);
	}

}
