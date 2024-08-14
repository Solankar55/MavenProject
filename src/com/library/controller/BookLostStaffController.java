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

import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;
import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessionLibraryRegister;
import com.library.model.LostBookStaff;
import com.library.serviceInterface.AccessionLibraryRegisterServiceInterface;
import com.library.serviceInterface.BookLostStaffServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class BookLostStaffController {

	@Autowired
	private BookLostStaffServiceInterface bookLostStaffServiceInterface;

	public BookLostStaffServiceInterface getBookLostStaffServiceInterface() {
		return bookLostStaffServiceInterface;
	}

	public void setBookLostStaffServiceInterface(BookLostStaffServiceInterface bookLostStaffServiceInterface) {
		this.bookLostStaffServiceInterface = bookLostStaffServiceInterface;
	}
	
	@Autowired
	private AccessionLibraryRegisterServiceInterface accessionLibraryRegisterServiceInterface;
	
	
	@RequestMapping("StaffLost")
	public ModelAndView StaffBookLost(HttpServletRequest request,HttpSession session,Model model){
		
		session=request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);
		
		List<AdminRegistrationModel> checkAdminDetails ;
		checkAdminDetails=accessionLibraryRegisterServiceInterface.CheckAdmin(username);
		
		
		try {
			
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			
			List<String> LostStaffBookData;
			LostStaffBookData=bookLostStaffServiceInterface.getLostStaffBookList();
			model.addAttribute("LostStaffBookData", LostStaffBookData);
			
			return new ModelAndView("StaffBookLostTP");
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	
	@RequestMapping(value="StaffBookLostData")
	public ModelAndView saveData(@RequestParam Map<String, String> StaffBookLostData, Model model){
		
		LostBookStaff LostBookStaff = new LostBookStaff(); 
		acadamicYearModel acadamicYearModel = new acadamicYearModel();
        List<Object[]> activeYr = bookLostStaffServiceInterface.activeYR();
		
		//ITERATION LOGIC FOR LIST OF OBJECT	
		String acYear = null;
		Integer acYearId = null;
		for (Object[] result : activeYr) {
			acYear = (String) result[0];
			acYearId = (Integer)result[1];  
		}
        
		LostBookStaff.setActiveAcademicYear(acYear);     
		
		acadamicYearModel.setAcadamicYearId(acYearId);
		LostBookStaff.setAcadamicYearModelStaff(acadamicYearModel);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		
		LostBookStaff.setDateLost(curentdate);
		
		int StaffId = Integer.parseInt(StaffBookLostData.get("StaffId"));
		List status = bookLostStaffServiceInterface.checkStaffRegistrationIdAvailability(StaffId);
		StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
		staffRegistrationModel.setStaffRegistrationId(StaffId);
		
		if(status.size()>0){
			
		String BookId = StaffBookLostData.get("BookId");
		String BookFor=StaffBookLostData.get("BookFor");
		System.out.println("BookFor :"+BookFor);
		int AccessionLibraryRegisterId = bookLostStaffServiceInterface.getAccessionLibraryRegisterId(BookId,BookFor);
		
		AccessionLibraryRegister accessionLibraryRegister= new AccessionLibraryRegister();
		accessionLibraryRegister.setAccessionLibraryRegisterId(AccessionLibraryRegisterId);
		LostBookStaff.setALRegisterStaff(accessionLibraryRegister);
		LostBookStaff.setStaffRegistrationModel(staffRegistrationModel);
		
		bookLostStaffServiceInterface.SaveToDatabase(LostBookStaff);
		bookLostStaffServiceInterface.updateBookCollegeRemark(AccessionLibraryRegisterId);
		
		List<String> LostStaffBookData;
		LostStaffBookData=bookLostStaffServiceInterface.getLostStaffBookList();
		model.addAttribute("LostStaffBookData", LostStaffBookData);
		
		model.addAttribute("StaffIdNotPresentMsg","Staff Book Lost Data Entered SuccessFully");
		return new ModelAndView("StaffBookLostTP");
		
		}else{
			model.addAttribute("StaffIdNotPresentMsg", "Please Check Your Staff Id Again");
			return new ModelAndView("StaffBookLostTP");
		}
	}

	@RequestMapping(value="StaffBookLostData",params="PrintStaffBookLost")
	public ModelAndView GetreportStandard(Model model,HttpServletRequest request,HttpSession session,HttpServletResponse response)
	{
		System.out.println("Print Data page of staff ");
		
		String filename="StaffBookLostReport";
		
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
		return null;
	}
	

	
}
