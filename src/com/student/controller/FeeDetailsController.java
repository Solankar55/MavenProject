package com.student.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.FeeDetailsServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class FeeDetailsController {

	@Autowired
	private FeeDetailsServiceInterface feeDetailsServiceInterface;

	public FeeDetailsServiceInterface getFeeDetailsServiceInterface() {
		return feeDetailsServiceInterface;
	}

	public void setFeeDetailsServiceInterface(FeeDetailsServiceInterface feeDetailsServiceInterface) {
		this.feeDetailsServiceInterface = feeDetailsServiceInterface;
	}

	@RequestMapping("PendingFeeStudent")
	public ModelAndView PendingFeeStudent(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To see/Print Pending Fee Student Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = feeDetailsServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String studEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("studEmail" + studEmail);

			List<Object[]> CheckStudDetailst = new ArrayList<>();
			CheckStudDetailst = feeDetailsServiceInterface.getCheckStudInfo(studName, studCon, studEmail);
			System.out.println(CheckStudDetailst);

			Integer StudentID = 0;
			Integer YearID = 0;
			Integer StreamID = 0;
			Integer BranchID = 0;
			Integer StandardID = 0;

			for (Object[] obj : CheckStudDetailst) {
				StudentID = (Integer) obj[0];
				YearID = (Integer) obj[1];
				BranchID = (Integer) obj[2];
				StandardID = (Integer) obj[3];
				StreamID = (Integer) obj[4];
			}

			System.out.println(StudentID);
			System.out.println(YearID);
			System.out.println(StreamID);
			System.out.println(BranchID);
			System.out.println(StandardID);

			List<String> FeeDetails;
			FeeDetails = feeDetailsServiceInterface.getFeeDetails(StudentID, YearID, StreamID, BranchID, StandardID);
			System.out.println(FeeDetails);

			if (FeeDetails.size() == 0) {
				model.addAttribute("MessageOfFee", "You Have Not Any Transaction Yet...");
				session = request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = feeDetailsServiceInterface.GetStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			} else {
				model.addAttribute("FeeDetails", FeeDetails);

				return new ModelAndView("PendingFeeStudentPage");
			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}
	
	@RequestMapping(value="PirntStudentPendingFeeRecipt",params="PrintReciptFee")
	public ModelAndView PrintReciptFee(HttpServletRequest request,HttpSession session,HttpServletResponse response,Model model)
	{
		System.out.println("Print Student Recipt");

		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
		System.out.println(StudentID);
		
		String PendingFee=request.getParameter("PendingFee");
		System.out.println(PendingFee);
		
		String PaidFee=request.getParameter("PaidFee");
		System.out.println(PaidFee);
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
	
		
		String filename = "StudentFee";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("StudentID", StudentID);
		hm.put("PendingFees", PendingFee);
		hm.put("AlreadyPaidFees", PaidFee);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session = request.getSession();
		String username1 = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = feeDetailsServiceInterface.GetStudDetails(username1);

		model.addAttribute("GetStudInfo", GetStudList);
		return new ModelAndView("StudentHome");
	}
}
