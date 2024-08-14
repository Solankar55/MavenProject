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

import com.library.serviceInterface.StudentClearenceServiceInterface;

@Controller
public class StudentClearenceController {

	@Autowired
	private StudentClearenceServiceInterface studentClearenceServiceInterface;

	public StudentClearenceServiceInterface getStudentClearenceServiceInterface() {
		return studentClearenceServiceInterface;
	}

	public void setStudentClearenceServiceInterface(StudentClearenceServiceInterface studentClearenceServiceInterface) {
		this.studentClearenceServiceInterface = studentClearenceServiceInterface;
	}
	
	@RequestMapping(value = "StudentClearenceee")
	public ModelAndView StudentClearenceee(Model model) {
		System.out.println("student clearence");

		HashMap<String, String> acadamicYr = new HashMap();
		acadamicYr = studentClearenceServiceInterface.getAcadamicYear();

		model.addAttribute("acadamicYr", acadamicYr);
		return new ModelAndView("StudentClearanceTP");

	}
	
	@RequestMapping("GetStudDetails")
	ModelAndView getStudData(@RequestParam Map<String, String> getDetails, Model model) {

		List<HashMap> acadamicYRList = new ArrayList<>();
		System.out.println("inside the Student clearance");
		HashMap<String, String> acadamicYr = new HashMap();
		acadamicYr = studentClearenceServiceInterface.getAcadamicYear();

		String selectedYr = getDetails.get("SelectYear");
		String StudId = getDetails.get("StudRegistrationId");
		String AcadamicYR = studentClearenceServiceInterface.getYearbyID(selectedYr);

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

		List<String> finedetailStud = new ArrayList<String>();
		List<String> LostdetailStud = new ArrayList<String>();
		List<String> NotReturningDetails = new ArrayList<String>();

		finedetailStud = studentClearenceServiceInterface.getFinedetailStud(dateone, datetwo, StudId);
		System.out.println("fine Details Student" + finedetailStud);

		if (finedetailStud.isEmpty()) {
			model.addAttribute("finedetailStud", "Student Has No Fine");
		}
		int totalfineStud = 0;
		try {
			totalfineStud = studentClearenceServiceInterface.gettotalfine(dateone, datetwo, StudId);
		} catch (Exception e) {
			System.out.println(e);
			totalfineStud = 0;
		}
		System.out.println("Total Fine" + totalfineStud);

		LostdetailStud = studentClearenceServiceInterface.getLostbookdetails(StudId);
		System.out.println("Lost details" + LostdetailStud);

		if (LostdetailStud.isEmpty()) {
			model.addAttribute("LostdetailStud", "No Book Lost Deatails");
		}

		Double SetLostTotal = 0d;
		try {
			SetLostTotal = studentClearenceServiceInterface.getLostTotal(StudId);
			System.out.println("Lost Total" + SetLostTotal);
		} catch (Exception e) {
			System.out.println(e);
			SetLostTotal = 0.0;
		}
		NotReturningDetails = studentClearenceServiceInterface.getNotReturnDetails(StudId);

		if (NotReturningDetails.isEmpty()) {
			model.addAttribute("NotReturningDetails", "No Return Details");
		}

		Double FineForNotReturn = 0d;
		try {
			FineForNotReturn = studentClearenceServiceInterface.getFineForNotReturn(StudId);
			System.out.println("Fine Return OR Not" + FineForNotReturn);
		} catch (Exception e) {
			System.out.println(e);
			FineForNotReturn = 0.0;
		}
		Double FinalAmountFine = 0d;
		try {
			FinalAmountFine = totalfineStud + SetLostTotal + FineForNotReturn;
			System.out.println("Total Fine" + FinalAmountFine);
		} catch (Exception e) {
			System.out.println(e);
			FinalAmountFine = 0.0;
		}
		System.out.println("finedetailStud: " + finedetailStud);
		System.out.println("totalfineStud: " + totalfineStud);
		System.out.println("LostdetailStud: " + LostdetailStud);
		System.out.println("SetLostTotal: " + SetLostTotal);
		System.out.println("NotReturningDetails: " + NotReturningDetails);
		System.out.println("FineForNotReturn: " + FineForNotReturn);

		model.addAttribute("finedetailStud", finedetailStud);
		model.addAttribute("totalfineStud", totalfineStud);
		model.addAttribute("LostdetailStud", LostdetailStud);
		model.addAttribute("SetLostTotal", SetLostTotal);
		model.addAttribute("NotReturningDetails", NotReturningDetails);
		model.addAttribute("FineForNotReturn", FineForNotReturn);
		model.addAttribute("FinalAmountFine", FinalAmountFine);

		model.addAttribute("acadamicYr", acadamicYr);
		return new ModelAndView("StudentClearanceTP");

	}

}
