package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.acadamicYearModel;
import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessionLibraryRegister;
import com.library.model.LostBookStudent;
import com.library.serviceInterface.AccessionLibraryRegisterServiceInterface;
import com.library.serviceInterface.BookLostStudentServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class BookLostStudentController {

	@Autowired
	private BookLostStudentServiceInterface bookLostStudentServiceInrterface;
	@Autowired
	private AccessionLibraryRegisterServiceInterface accessionLibraryRegisterServiceInterface;

	
	public BookLostStudentServiceInterface getBookLostStudentServiceInrterface() {
		return bookLostStudentServiceInrterface;
	}

	public AccessionLibraryRegisterServiceInterface getAccessionLibraryRegisterServiceInterface() {
		return accessionLibraryRegisterServiceInterface;
	}

	public void setBookLostStudentServiceInrterface(BookLostStudentServiceInterface bookLostStudentServiceInrterface) {
		this.bookLostStudentServiceInrterface = bookLostStudentServiceInrterface;
	}

	public void setAccessionLibraryRegisterServiceInterface(
			AccessionLibraryRegisterServiceInterface accessionLibraryRegisterServiceInterface) {
		this.accessionLibraryRegisterServiceInterface = accessionLibraryRegisterServiceInterface;
	}

	@RequestMapping("StudentLost")
	public ModelAndView StudentBookLost(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = accessionLibraryRegisterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			
			List<String> BookLostDataList;
			BookLostDataList=bookLostStudentServiceInrterface.getBookLostList();
			model.addAttribute("BookLostDataList", BookLostDataList);
			
			return new ModelAndView("BookLostStudentTP");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	@RequestMapping("StudentBookLostData")
	public ModelAndView saveData(@RequestParam Map<String, String> StudentBookLostData, Model model) {

		LostBookStudent lostBookStudent = new LostBookStudent();
		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		List<Object[]> activeYr = bookLostStudentServiceInrterface.getActiveyr();

		// ITERATION LOGIC FOR LIST OF OBJECT
		String acYear = null;
		Integer acYearId = null;
		for (Object[] result : activeYr) {
			acYear = (String) result[0];
			acYearId = (Integer) result[1];
		}

		int studentRegId = Integer.parseInt(StudentBookLostData.get("StudentId"));
		List status = bookLostStudentServiceInrterface.checkStudentRegistrationIdAvailability(studentRegId);

		System.out.println("studentRegId : " + studentRegId);
		if (status.size() > 0) {

			lostBookStudent.setActiveAcademicYear(acYear);

			acadamicYearModel.setAcadamicYearId(acYearId);
			lostBookStudent.setAcadamicYearModel(acadamicYearModel);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);

			lostBookStudent.setDateLost(curentdate);
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studentRegId);

			String BookFor = StudentBookLostData.get("BookFor");
			System.out.println(BookFor);

			//int BookId = Integer.parseInt(StudentBookLostData.get("BookId"));
			String BookId=StudentBookLostData.get("BookId");
			int AccessionLibraryRegisterId = bookLostStudentServiceInrterface.getAccessionLibraryRegisterId(BookId,
					BookFor);

			AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
			accessionLibraryRegister.setAccessionLibraryRegisterId(AccessionLibraryRegisterId);
			lostBookStudent.setALRegister(accessionLibraryRegister);
			lostBookStudent.setStudentAdmissionModel(studentAdmissionModel);
			bookLostStudentServiceInrterface.SaveToDatabase(lostBookStudent);

			bookLostStudentServiceInrterface.updateBookCollegeRemark(AccessionLibraryRegisterId);

			List<String> BookLostDataList;
			BookLostDataList=bookLostStudentServiceInrterface.getBookLostList();
			model.addAttribute("BookLostDataList", BookLostDataList);
			
			model.addAttribute("StudentIdNotPresentMsg", "Student Book Lost Data Entered SuccessFully");
			return new ModelAndView("BookLostStudentTP");
		} else {
			model.addAttribute("StudentIdNotPresentMsg", "Please Check Your Student Id Again");
			return new ModelAndView("BookLostStudentTP");
		}

	}

	@RequestMapping(value="StudentBookLostData",params="PrintStudentBookLost")
	public ModelAndView GetreportStandard(Model model,HttpServletRequest request,HttpSession session,HttpServletResponse response)
	{
		System.out.println("Print Data");
		
		String filename="BookLostStudentReport";
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
	
		HashMap<String, Object> hm=new HashMap<>();
		hm.put("banner", banner);
		
	    try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return new ModelAndView("BookLostStudentTP");
	}
}
