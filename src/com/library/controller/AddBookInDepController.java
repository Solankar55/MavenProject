package com.library.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.AccessionLibraryRegister;
import com.library.model.BookInDepartment;
import com.library.model.Department;
import com.library.serviceInterface.AddBookInDepServiceInterface;

@Controller
public class AddBookInDepController {

	@Autowired
	private AddBookInDepServiceInterface addBookInDepServiceInterface;

	public AddBookInDepServiceInterface getAddBookInDepServiceInterface() {
		return addBookInDepServiceInterface;
	}

	public void setAddBookInDepServiceInterface(AddBookInDepServiceInterface addBookInDepServiceInterface) {
		this.addBookInDepServiceInterface = addBookInDepServiceInterface;
	}

	@RequestMapping("AddBookToDepartmentPageDisplay")
	public ModelAndView AddBookToDepartmentPage(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = addBookInDepServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			/*
			 * List<BookInDepartment> BookInDepartmentList =
			 * bookInDepartmentServiceInterface.BookInDepartmentList(); return
			 * new
			 * ModelAndView("BookInDepartmentTP","BIDList",BookInDepartmentList)
			 * ;
			 */
			HashMap<String, String> DepartmentList = addBookInDepServiceInterface.departmentList();
			List<BookInDepartment> BookInDepartmentList = addBookInDepServiceInterface.getBookInDeptList();
			System.out.println("BookInDepartmentList" + BookInDepartmentList);
			model.addAttribute("BIDList", BookInDepartmentList);

			return new ModelAndView("AddBookInDepartmentTP", "DepartmentList", DepartmentList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "AddBookToDepartmentDataSave", params = "addDepartment")
	public ModelAndView SaveBookInDeptt(Model model, HttpServletRequest request) {

		BookInDepartment bookInDepartment = new BookInDepartment();
		System.out.println("sssssssssssssssssssssss");
		String accerId = request.getParameter("AccessionLibraryRegisterId");
		int Department = Integer.parseInt(request.getParameter("Department"));
		System.out.println(accerId + "  maheshhssss " + Department);

		int Accid = addBookInDepServiceInterface.getAccId(accerId);
		AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
		accessionLibraryRegister.setAccessionLibraryRegisterId(Accid);
		bookInDepartment.setAccessionLibraryRegister(accessionLibraryRegister);

		Department department = new Department();
		department.setDepartmentId(Department);
		bookInDepartment.setDepartment(department);
		addBookInDepServiceInterface.saveBookInDepartment(bookInDepartment);
		HashMap<String, String> DepartmentList = addBookInDepServiceInterface.departmentList();
		System.out.println("DepartmentList" + DepartmentList);
		model.addAttribute("DepartmentList", DepartmentList);

		List<BookInDepartment> BookInDepartmentList = addBookInDepServiceInterface.getBookInDeptList();
		System.out.println("BookInDepartmentList" + BookInDepartmentList);
		model.addAttribute("BIDList", BookInDepartmentList);
		return new ModelAndView("AddBookInDepartmentTP");

	}

	@RequestMapping(value="UpdateBookInDepartmentData",params="Update")
	public ModelAndView updateBook(Model model, HttpServletRequest request) {

		System.out.println("Updateeee Update");
		BookInDepartment bookInDepartment = new BookInDepartment();

		int bookDeptId = Integer.parseInt(request.getParameter("BookInDepartmentID"));
		System.out.println("bookDeptId" + bookDeptId);
		String accerId = request.getParameter("BookID");
		// int Department=Integer.parseInt(request.getParameter("Department"));
		System.out.println("accerId" + accerId);

		String Department = request.getParameter("DepartmentID");
		System.out.println("Department" + Department);
		int deptId = addBookInDepServiceInterface.getDeptId(Department);
		System.out.println(accerId + "  sonaliii " + deptId);

		int Accid = addBookInDepServiceInterface.getAccIdUpdate(accerId);
		AccessionLibraryRegister accessionLibraryRegister = new AccessionLibraryRegister();
		accessionLibraryRegister.setAccessionLibraryRegisterId(Accid);
		bookInDepartment.setAccessionLibraryRegister(accessionLibraryRegister);

		/*
		 * int department=Integer.parseInt(request.getParameter("Department"));
		 * System.out.println(accerId+"  sonaliii "+department);
		 */

		Department department1 = new Department();
		department1.setDepartmentId(deptId);
		bookInDepartment.setDepartment(department1);
		bookInDepartment.setBookInDepartmentID(bookDeptId);

		System.out.println("Accid" + Accid);
		System.out.println("deptId" + deptId);
		addBookInDepServiceInterface.updateDepartmentData1(bookInDepartment);

		HashMap<String, String> DepartmentList = addBookInDepServiceInterface.departmentList();
		System.out.println("DepartmentList" + DepartmentList);
		model.addAttribute("DepartmentList", DepartmentList);

		List<BookInDepartment> BookInDepartmentList = addBookInDepServiceInterface.getBookInDeptList();
		System.out.println("BookInDepartmentList" + BookInDepartmentList);
		model.addAttribute("BIDList", BookInDepartmentList);

		return new ModelAndView("AddBookInDepartmentTP");
	}

	@RequestMapping(value="UpdateBookInDepartmentData",params="Delete")
	public ModelAndView updateBookInDepartmentDataDelete(HttpServletRequest request,Model model)
	{
		System.out.println("UpdateBookInDepartmentData");
		
		int bookInDepId=Integer.parseInt(request.getParameter("BookInDepartmentID"));
		System.out.println(bookInDepId);

		String bookname=request.getParameter("bookName");
		System.out.println("bookname" +bookname);
		String departmentName=request.getParameter("departmentName");
		System.out.println("deptname" +departmentName);
		
		addBookInDepServiceInterface.deleteBookFromDepartment(bookInDepId,bookname,departmentName);
		List<BookInDepartment> BookInDepartmentList = addBookInDepServiceInterface.getBookInDeptList();
		System.out.println("BookInDepartmentList" + BookInDepartmentList);
		model.addAttribute("BIDList", BookInDepartmentList);

		return new ModelAndView("AddBookInDepartmentTP");
	}
}
