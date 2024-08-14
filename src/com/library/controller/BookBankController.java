package com.library.controller;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.BookBankServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class BookBankController {

	@Autowired
	private BookBankServiceInterface bookBankServiceInterface;

	public BookBankServiceInterface getBookBankServiceInterface() {
		return bookBankServiceInterface;
	}

	public void setBookBankServiceInterface(BookBankServiceInterface bookBankServiceInterface) {
		this.bookBankServiceInterface = bookBankServiceInterface;
	}
	
	@RequestMapping("bookBank")
	public ModelAndView bookBank(Model model,HttpServletRequest request,HttpSession session)
	
	{
		System.out.println("On Book Bank Page");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = bookBankServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
		
		return new ModelAndView("BookBankPageView");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}
	
	/*@RequestMapping(value="getMessageBookId1",method=RequestMethod.GET)
	@ResponseBody
	public org.json.simple.JSONObject getMessageList1(String bookId)
	{
	
		HashMap<String,String> getMessageList=new HashMap<>();
	
		org.json.simple.JSONObject json=new org.json.simple.JSONObject();
		getMessageList=bookBankServiceInterface.getMessageSt(bookId);
		String Status=getMessageList.get("msg");
		System.out.println(getMessageList+"  "+Status);
		json.put("msg", Status);
		return json;
	}
*/
	@RequestMapping(value = "BookBankIsssueReturn",params="IssueReturnBook")
	public ModelAndView bookBankIssueReturn(Model model,HttpServletRequest request)
	{
		System.out.println("clicked on Issue/Return Book");
		try
		{
		
		String bookId = request.getParameter("bookId");
		String ReaderId = request.getParameter("readerId");

		String Active = bookBankServiceInterface.getActiveyr();
		String Activeyr = Active.substring(0, 4);
		System.out.println(Activeyr);
		List<String> bookissuerList = new ArrayList<>();
		if (ReaderId.contains("ST")) {

			if ((ReaderId.contains(Activeyr))) {
				int StudentId = Integer.parseInt(ReaderId.substring(12));
				int alrid=0;
				alrid=bookBankServiceInterface.getMaxAlrID();
				System.out.println("FK alrid :" +alrid);
				if (bookId.contains("PG")) {
					//String bId = bookId.substring(2);
					int AlrID = bookBankServiceInterface.getalrIdforPostDegree(bookId);
					System.out.println("AlrID :" +AlrID);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookBankPageView");
					} else {
						
						//set foreign keys
						
						
						bookissuerList = bookBankServiceInterface.getbookIssure(alrid,AlrID, StudentId, ReaderId, bookId);

						String getDetails;
						getDetails = bookBankServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookBankPageView");
					}	

				}
				else if (bookId.contains("UG")) {
					//String bId = bookId.substring(2);
					int AlrID = bookBankServiceInterface.getalrIdforDegree(bookId);
					System.out.println("AlrID :" +AlrID);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookBankPageView");
					} else {
						
						//set foreign keys
						
						
						bookissuerList = bookBankServiceInterface.getbookIssure(alrid,AlrID, StudentId, ReaderId, bookId);

						String getDetails;
						getDetails = bookBankServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookBankPageView");
					}	

				} else if (bookId.contains("DP")) {
					//String bId = bookId.substring(2);
					int AlrID = bookBankServiceInterface.getalrIdforDiploma(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookBankPageView");
					} else {
						bookissuerList = bookBankServiceInterface.getbookIssure(alrid,AlrID, StudentId, ReaderId, bookId);// change
																													// method
						String getDetails;
						getDetails = bookBankServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookBankPageView");
					}

				} else if (bookId.contains("OT")) {
					//String bId = bookId.substring(2);
					int AlrID = bookBankServiceInterface.getalrIdforOther(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookBankPageView");
					} else {
						bookissuerList = bookBankServiceInterface.getbookIssure(alrid,AlrID, StudentId, ReaderId, bookId); // change
																													// method
						String getDetails;
						getDetails = bookBankServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookBankPageView");
					} // for
						// other
				} else {
					// not proper book Id
					model.addAttribute("Status", "Not Proper Book ID");
					return new ModelAndView("BookBankPageView");
				}

			} else {
				/* not a active Student contact accountent */
				model.addAttribute("Status", "Not A Active Student....Contact To Accountant");
				return new ModelAndView("BookBankPageView");
			}
		}
 else {
			// Incorrect Barcode
			model.addAttribute("Status", "Incorrect Barcode");
			return new ModelAndView("BookBankPageView");
		}
		}
		catch(Exception exception)
		{
			System.out.println(exception);
			model.addAttribute("Status", "Book can't be issue as its already issued");
			return new ModelAndView("BookBankPageView");
		}
	}
	
	@RequestMapping(value="BookBankIsssueReturn",params="ss")
	public ModelAndView print(Model model,HttpServletRequest request)
	{
		System.out.println("clicked on ss ");
		return new ModelAndView("BookBankPageView");
	}
	@RequestMapping("getStudentDetail")
	@ResponseBody
	public List<String> subBookList(String studentId)
	//public List<String> subBookList(String studName,String contactNum)
	{
		List<String> studentList=new ArrayList<>();
		studentList=bookBankServiceInterface.getStudentList(studentId);
		System.out.println("subList in controller: " +studentList);
		return studentList;
		
	}
	
	@RequestMapping("getStudentBookBank")
	@ResponseBody
	public List<String> bookBankList(String studbarcode)
	{
		List<String> bookbankList=new ArrayList<>();
		bookbankList=bookBankServiceInterface.getStudentBookBankList(studbarcode);
		System.out.println("bookbankList in controller: " +bookbankList);
		return bookbankList;
		
	}
	
	@RequestMapping(value="getTransactionStud" ,params="printTransaction")
	public ModelAndView printTransaction(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession)
	{
		System.out.println("printTransaction");
		
		String studentBarcode=request.getParameter("barcodeStudent");
		System.out.println(studentBarcode);
		
		ServletContext context = httpSession.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "BookBankTransactionReport";
		
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("studentBarcode", studentBarcode);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView();
	}
}
