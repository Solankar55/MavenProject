package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessionLibraryRegister;
import com.library.model.Barcodemodel;
import com.library.serviceInterface.BarcodeServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class BarcodeController {

	@Autowired
	private BarcodeServiceInterface barcodeServiceInterface;

	public BarcodeServiceInterface getBarcodeServiceInterface() {
		return barcodeServiceInterface;
	}

	public void setBarcodeServiceInterface(BarcodeServiceInterface barcodeServiceInterface) {
		this.barcodeServiceInterface = barcodeServiceInterface;
	}
	
	@RequestMapping("Barcode")
	public ModelAndView Barcode(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = barcodeServiceInterface.CheckAdmin(username);
		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("BarcodeTP");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}

	}
	@RequestMapping(value="getBarcodeBook",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getBarcodedBook(String bookFor,String fromDate,String toDate) throws ParseException
	{
		System.out.println("In getBarcodeBook Code  controller : ");
		
		
		List<String> getBarcodedBook1=new ArrayList<>();
			
		getBarcodedBook1=barcodeServiceInterface.getBarcodedBookList(bookFor);
		System.out.println("getBarcodedBook1" +getBarcodedBook1);
		return getBarcodedBook1;
	}
	
	@RequestMapping("Barcode1")
	public ModelAndView Barcode1(@RequestParam Map<String, String> par, Model model, Barcodemodel barcodemodel) {

		String bookfor = par.get("BookFor");
		String inDate = par.get("InDate");

		AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();

		System.out.println("BKfr: " + bookfor);
		System.out.println("indate: " + inDate);

		if (bookfor.equals("Degree")) {
			HashMap<Integer, String> IdandAccessionNo = new HashMap<Integer, String>();
			IdandAccessionNo = barcodeServiceInterface.getAccessionId(bookfor, inDate);

			Iterator itr = IdandAccessionNo.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry object = (Entry) itr.next();
				int AccessionLibraryRegisterId = Integer.parseInt(object.getKey().toString());
				String AccesionId = object.getValue().toString();

				System.out.println("AccesionId: " + AccesionId);
				System.out.println("AccessionLibraryRegisterId: " + AccessionLibraryRegisterId);

				String barcode = "UG".concat(AccesionId);

				System.out.println("barcode:  " + barcode);

				barcodemodel.setBarcode(barcode);
				accessionLibraryRegister.setAccessionLibraryRegisterId(AccessionLibraryRegisterId);
				barcodemodel.setAccessionLibraryRegister(accessionLibraryRegister);
				barcodeServiceInterface.saveBarcode(barcodemodel);
			}

		}
		if (bookfor.equals("Diploma")) {

			HashMap<Integer, String> IdandAccessionNo = new HashMap<Integer, String>();
			IdandAccessionNo = barcodeServiceInterface.getAccessionId(bookfor, inDate);

			Iterator itr = IdandAccessionNo.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry object = (Entry) itr.next();
				int AccessionLibraryRegisterId = Integer.parseInt(object.getKey().toString());
				String AccesionId = object.getValue().toString();

				System.out.println("AccesionId: " + AccesionId);
				System.out.println("AccessionLibraryRegisterId: " + AccessionLibraryRegisterId);

				String barcode = "DP".concat(AccesionId);

				System.out.println("barcode:  " + barcode);

				barcodemodel.setBarcode(barcode);
				accessionLibraryRegister.setAccessionLibraryRegisterId(AccessionLibraryRegisterId);
				barcodemodel.setAccessionLibraryRegister(accessionLibraryRegister);

				barcodeServiceInterface.saveBarcode(barcodemodel);

			}

		}
		if (bookfor.equals("Other")) {

			HashMap<Integer, String> IdandAccessionNo = new HashMap<Integer, String>();
			IdandAccessionNo = barcodeServiceInterface.getAccessionId(bookfor, inDate);

			Iterator itr = IdandAccessionNo.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry object = (Entry) itr.next();
				int AccessionLibraryRegisterId = Integer.parseInt(object.getKey().toString());
				String AccesionId = object.getValue().toString();

				System.out.println("AccesionId: " + AccesionId);
				System.out.println("AccessionLibraryRegisterId: " + AccessionLibraryRegisterId);

				String barcode = "OT".concat(AccesionId);
				barcodemodel.setBarcode(barcode);
				accessionLibraryRegister.setAccessionLibraryRegisterId(AccessionLibraryRegisterId);
				barcodemodel.setAccessionLibraryRegister(accessionLibraryRegister);
				barcodeServiceInterface.saveBarcode(barcodemodel);
			}

		} else {
			return new ModelAndView("BarcodeTP", "message", "Select Proper BookFor");
		}

		return new ModelAndView("BarcodeTP", "message", "Enter Preoper Accession Number Group");
	}

	@RequestMapping(value="Barcode1",params="printDataBarcode")
	public ModelAndView GetreportStandard(Model model,HttpServletRequest request,HttpSession session,HttpServletResponse response) 
	{
		System.out.println("Print Data");
		
		String filename="Barcode";
		String bookFor=request.getParameter("BookFor");
		String fromDate=request.getParameter("fromDate");	
		String toDate=request.getParameter("toDate");
		String fromNumber=request.getParameter("fromNumber");
		String toNumber=request.getParameter("toNumber");
		System.out.println("bookFor" +bookFor);
		System.out.println("fromNumber" +fromNumber);
		System.out.println("toNumber" +toNumber);
		
		HashMap<String, Object> hm=new HashMap<>();
		hm.put("bookFor", bookFor);
		hm.put("fromDate", fromNumber);
		hm.put("toDate", toNumber);
		
	    try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return new ModelAndView("StandardReportPage");
	    
	}
}
