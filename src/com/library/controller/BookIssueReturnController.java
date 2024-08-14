package com.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.BookIssueReturnServiceInterface;

@Controller
public class BookIssueReturnController {

	@Autowired
	private BookIssueReturnServiceInterface bookIssueReturnServiceInterface;

	public BookIssueReturnServiceInterface getBookIssueReturnServiceInterface() {
		return bookIssueReturnServiceInterface;
	}

	public void setBookIssueReturnServiceInterface(BookIssueReturnServiceInterface bookIssueReturnServiceInterface) {
		this.bookIssueReturnServiceInterface = bookIssueReturnServiceInterface;
	}
	
	@RequestMapping("IssueReturnReportLibrary")
	public ModelAndView BookIssuerAndReturn(HttpServletRequest request, HttpSession session, Model model) {
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = bookIssueReturnServiceInterface.checkAdmin(username);

		System.out.println("Issue Return Report Library");
		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			return new ModelAndView("BookAccession");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}

	}
	@RequestMapping(value="getMessageBookId1",method=RequestMethod.GET)
	@ResponseBody
	public org.json.simple.JSONObject getMessageList1(String bookId)
	{
	
		HashMap<String,String> getMessageList=new HashMap<>();
	
		org.json.simple.JSONObject json=new org.json.simple.JSONObject();
		getMessageList=bookIssueReturnServiceInterface.getMessageSt(bookId);
		String Status=getMessageList.get("msg");
		System.out.println(getMessageList+"  "+Status);
		json.put("msg", Status);
		return json;
	}
	
	@RequestMapping("getBookBarcodeData")
	@ResponseBody
	public List<String> getBookDetail(String bookBarcode)
	{
		List<String> authorList=new ArrayList<>();
		authorList=bookIssueReturnServiceInterface.getBookBarcodeInfo(bookBarcode);
		System.out.println("authorList in controller: " +authorList);
		return authorList;
		
	}
	
	@RequestMapping("getStudentBarcodeData")
	@ResponseBody
	public List<String> getStudDetail(String studentBarcode)
	{
		List<String> getStudList=new ArrayList<>();
		getStudList=bookIssueReturnServiceInterface.getStudentBarcodeInfo(studentBarcode);
		System.out.println("StudList in controller: " +getStudList);
		return getStudList;
		
	}
	@RequestMapping("getStaffData")
	@ResponseBody
	public List<String> getStaffDetail(String staffBarcode)
	{
		List<String> getStaffList=new ArrayList<>();
		getStaffList=bookIssueReturnServiceInterface.getStaffDetails(staffBarcode);
		System.out.println("StudList in controller: " +getStaffList);
		return getStaffList;
		
	}
	
	@RequestMapping(value = "IssueOrReturnBook", params = "IssueReturnBook")
	public ModelAndView IssueOrReturnBook(HttpServletRequest request, Model model) {
		System.out.println("IssueReturnBook");

		try
		{
		String bookId = request.getParameter("bookId");
		String ReaderId = request.getParameter("readerId");

		String Active = bookIssueReturnServiceInterface.getActiveyr();
		String Activeyr = Active.substring(0, 4);
		System.out.println(Activeyr);
		List<String> bookissuerList = new ArrayList<>();
		if (ReaderId.contains("ST")) {

			if ((ReaderId.contains(Activeyr))) {
				int StudentId = Integer.parseInt(ReaderId.substring(12));
				if (bookId.contains("PG")) {
					//String bId = bookId.substring(2);
					int AlrID = bookIssueReturnServiceInterface.getalrIdforPG(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookAccession");
					} else {
						bookissuerList = bookIssueReturnServiceInterface.GetbookIssure(AlrID, StudentId, ReaderId, bookId);

						String getDetails;
						getDetails = bookIssueReturnServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookAccession");
					}	

				}
				else if (bookId.contains("UG")) {
					//String bId = bookId.substring(2);
					int AlrID = bookIssueReturnServiceInterface.getalrIdforDegree(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookAccession");
					} else {
						bookissuerList = bookIssueReturnServiceInterface.GetbookIssure(AlrID, StudentId, ReaderId, bookId);

						String getDetails;
						getDetails = bookIssueReturnServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookAccession");
					}	

				} else if (bookId.contains("DP")) {
					//String bId = bookId.substring(2);
					int AlrID = bookIssueReturnServiceInterface.getalrIdforDiploma(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookAccession");
					} else {
						bookissuerList = bookIssueReturnServiceInterface.GetbookIssure(AlrID, StudentId, ReaderId, bookId);// change
																													// method
						String getDetails;
						getDetails = bookIssueReturnServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookAccession");
					}

				} else if (bookId.contains("OT")) {
					//String bId = bookId.substring(2);
					int AlrID = bookIssueReturnServiceInterface.getalrIdforOther(bookId);
					if (AlrID == 0) {
						model.addAttribute("Status",
								"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
						return new ModelAndView("BookAccession");
					} else {
						bookissuerList = bookIssueReturnServiceInterface.GetbookIssure(AlrID, StudentId, ReaderId, bookId); // change
																													// method
						String getDetails;
						getDetails = bookIssueReturnServiceInterface.getDetails(AlrID, StudentId, ReaderId, bookId);
						model.addAttribute("Status", getDetails);
						return new ModelAndView("BookAccession");
					} // for
						// other
				} else {
					// not proper book Id
					model.addAttribute("Status", "Not Proper Book ID");
					return new ModelAndView("BookAccession");
				}

			} else {
				/* not a active Student contact accountent */
				model.addAttribute("Status", "Not A Active Student....Contact To Accountant");
				return new ModelAndView("BookAccession");
			}
		}
		if (ReaderId.contains("LECT")) {
			int StaffID = Integer.parseInt(ReaderId.substring(7));
			
			if (bookId.contains("PG")) {
				//String bId = bookId.substring(2);
				//System.out.println("Book Id" + bId);
				System.out.println("Staff ID: " + StaffID);
				int AlrID = bookIssueReturnServiceInterface.getalrIdforPG(bookId);
				if (AlrID==0) {
					model.addAttribute("Status",
							"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
					return new ModelAndView("BookAccession");
				} else {
					bookIssueReturnServiceInterface.issueBookToLecturerPostDegree(AlrID,  ReaderId, bookId, StaffID);

					String getDetails;
					getDetails = bookIssueReturnServiceInterface.getDetailsStaff(AlrID, StaffID, ReaderId, bookId);
					model.addAttribute("Status", getDetails);
					return new ModelAndView("BookAccession");
				}
			}
			
			else if (bookId.contains("UG")) {
				//String bId = bookId.substring(2);
				//System.out.println("Book Id" + bId);
				System.out.println("Staff ID: " + StaffID);
				int AlrID = bookIssueReturnServiceInterface.getalrIdforDegree(bookId);
				if (AlrID==0) {
					model.addAttribute("Status",
							"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
					return new ModelAndView("BookAccession");
				} else {
					bookIssueReturnServiceInterface.issueBookToLecturerDegree(AlrID,  ReaderId, bookId, StaffID);

					String getDetails;
					getDetails = bookIssueReturnServiceInterface.getDetailsStaff(AlrID, StaffID, ReaderId, bookId);
					model.addAttribute("Status", getDetails);
					return new ModelAndView("BookAccession");
				}
			}
			if (bookId.contains("DP")) {
				//String bId = bookId.substring(2);
				int AlrID = bookIssueReturnServiceInterface.getalrIdforDiploma(bookId);
				if (AlrID == 0) {
					model.addAttribute("Status",
							"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
					return new ModelAndView("BookAccession");
				} else {
					bookIssueReturnServiceInterface.issueBookToLecturerDegree(AlrID, ReaderId, bookId, StaffID);

					String getDetails;
					getDetails = bookIssueReturnServiceInterface.getDetailsStaff(AlrID, StaffID, ReaderId, bookId);
					model.addAttribute("Status", getDetails);
					return new ModelAndView("BookAccession");
				}
			}
			if (bookId.contains("OT")) {
				//String bId = bookId.substring(2);
				int AlrID = bookIssueReturnServiceInterface.getalrIdforOther(bookId);
				if (AlrID == 0) {
					model.addAttribute("Status",
							"This Book Is In Lost Book List,You Can't Issue Or Return This Book...");
					return new ModelAndView("BookAccession");
				} else {
					bookIssueReturnServiceInterface.issueBookToLecturerDegree(AlrID,  ReaderId, bookId, StaffID);

					String getDetails;
					getDetails = bookIssueReturnServiceInterface.getDetailsStaff(AlrID, StaffID, ReaderId, bookId);
					model.addAttribute("Status", getDetails);
					return new ModelAndView("BookAccession");
				}
			} else {
				// not proper book Id
				model.addAttribute("Status", "Not Proper Book ID");
				return new ModelAndView("BookAccession");
			}

		} else {
			// Incorrect Barcode
			model.addAttribute("Status", "Incorrect Barcode");
			return new ModelAndView("BookAccession");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
			model.addAttribute("Status", "Book can't be issue as it is already issued");
			return new ModelAndView("BookAccession");
		}
	}
}
