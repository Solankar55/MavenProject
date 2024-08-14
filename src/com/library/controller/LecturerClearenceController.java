package com.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.serviceInterface.LecturerClearenceServiceInterface;

@Controller
public class LecturerClearenceController {

	@Autowired
	private LecturerClearenceServiceInterface lecturerClearenceServiceInterface;

	public LecturerClearenceServiceInterface getLecturerClearenceServiceInterface() {
		return lecturerClearenceServiceInterface;
	}

	public void setLecturerClearenceServiceInterface(LecturerClearenceServiceInterface lecturerClearenceServiceInterface) {
		this.lecturerClearenceServiceInterface = lecturerClearenceServiceInterface;
	}
	
	@RequestMapping("StaffClearenceee")
	public ModelAndView StaffClearenceee(Model model) {
		List<HashMap> acadamicYRList = new ArrayList<>();
		System.out.println("inside the staff clera");
		HashMap<String, String> acadamicYr = new HashMap();
		acadamicYr = lecturerClearenceServiceInterface.getAcadamicYear();

		// accessionLibraryRegister.get

		/*
		 * Iterator itr = acadamicYRList.iterator(); while(itr.hasNext()){
		 * Map.Entry map = (Entry) itr.next(); System.out.println("key:"
		 * +map.getKey()); System.out.println("value:"+map.getValue());
		 * 
		 * }
		 */

		/*
		 * for(int i =0;i<acadamicYRList.size();i++){ Map.Entry
		 * entry=(Map.Entry) acadamicYRList.get(i).entrySet();
		 * 
		 * System.out.println("id" +entry.getKey()); System.out.println("value"
		 * +entry.getValue());
		 * 
		 * System.out.println("id"+acadamicYRList.get(i).get("acadamicYearId"))
		 * ;
		 * System.out.println("value"+acadamicYRList.get(i).get("acadamicYr"));
		 * 
		 * }
		 */

		model.addAttribute("acadamicYr", acadamicYr);
		return new ModelAndView("StaffClearancePage");

	}

	@RequestMapping(value = "GetDetails")
	ModelAndView getData(@RequestParam Map<String, String> getDetails, Model model) {

		List<HashMap> acadamicYRList = new ArrayList<>();
		System.out.println("inside the staff clera");
		HashMap<String, String> acadamicYr = new HashMap();
		acadamicYr = lecturerClearenceServiceInterface.getAcadamicYear();

		String selectedYr = getDetails.get("SelectYear");
		String StudId = getDetails.get("StaffRegistrationId");
		String AcadamicYR = lecturerClearenceServiceInterface.getYearbyID(selectedYr);

		String yr[] = AcadamicYR.split("-");
		String dateone = "1-6-" + yr[0];
		String datetwo = "31-5-" + yr[1];

		System.out.println("one yr " + yr[0]);
		System.out.println("second yr " + yr[1]);
		System.out.println("1date" + dateone);
		System.out.println("2date" + datetwo);
		System.out.println("AcadamicYR" + AcadamicYR);
		System.out.println("SelectYear" + selectedYr);
		System.err.println("StudId" + StudId);

		List<String> finedetails = new ArrayList<String>();
		List<String> Lostdetails = new ArrayList<String>();
		List<String> NotReturningDetails = new ArrayList<String>();

		finedetails = lecturerClearenceServiceInterface.getFinedetails(dateone, datetwo, StudId);

		if (finedetails.isEmpty()) {
			model.addAttribute("finedetails", "No Fine Details");
		}
		int totalfine = 0;

		try {
			totalfine = lecturerClearenceServiceInterface.gettotalfine(dateone, datetwo, StudId);
		} catch (Exception e) {
			System.out.println(e);
			totalfine = 0;
		}

		Lostdetails = lecturerClearenceServiceInterface.getLostbookdetails(StudId);

		if (Lostdetails.isEmpty()) {
			model.addAttribute("Lostdetails", "Staff Book Lost Details Not Present");
		}
		Double SetLostTotal = 0d;

		try {
			SetLostTotal = lecturerClearenceServiceInterface.getLostTotal(StudId);
		} catch (Exception e) {
			System.out.println(e);
			SetLostTotal = 0.0;
		}
		NotReturningDetails = lecturerClearenceServiceInterface.getNotReturnDetails(StudId);

		if (NotReturningDetails.isEmpty()) {
			model.addAttribute("NotReturningDetails", "No Return Details");
		}
		Double FineForNotReturn = 0d;
		try {
			FineForNotReturn = lecturerClearenceServiceInterface.getFineForNotReturn(StudId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			FineForNotReturn = 0.0;
		}

		double TotalFineOnBook = totalfine + SetLostTotal + FineForNotReturn;

		System.out.println("finedetails: " + finedetails.toString());
		System.out.println("totalfine: " + totalfine);
		System.out.println("Lostdetails; " + Lostdetails);
		System.out.println("SetLostTotal " + SetLostTotal);
		System.out.println("NotReturningDetails " + NotReturningDetails);
		System.err.println("FineForNotReturn: " + FineForNotReturn);

		model.addAttribute("acadamicYr", acadamicYr);
		model.addAttribute("totalfine", totalfine);
		model.addAttribute("finedetails", finedetails);
		model.addAttribute("Lostdetails", Lostdetails);
		model.addAttribute("SetLostTotal", SetLostTotal);
		model.addAttribute("NotReturningDetails", NotReturningDetails);
		model.addAttribute("FineForNotReturn", FineForNotReturn);
		model.addAttribute("TotalFineOnBook", TotalFineOnBook);

		return new ModelAndView("StaffClearancePage");

	}

}
