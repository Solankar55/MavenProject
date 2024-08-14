package com.student.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentProfilePicModel;
import com.student.model.StudentRegistrationModel;
import com.student.service.RegisterStudentI;
import com.student.serviceInterface.StudentAdmisssionInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class AdmissionController {

	@Autowired
	private RegisterStudentI registerStudentI;

	@Autowired
	private StudentAdmisssionInterface StudentAdmisssionInterface;

	@RequestMapping("StudAd")
	public ModelAndView StudAd(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("admission") StudentAdmissionModel studentAdmissionModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Student Addmission");
		/* Addmition Current Date */
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String curentdate = sdf.format(d);

		model.addAttribute("curentdate", curentdate);

		HashMap<String, String> YearList;
		YearList = StudentAdmisssionInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		/* Student Register Information */
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> CheckStudentRequest = new ArrayList<>();
		CheckStudentRequest = registerStudentI.CheckStudent(username);

		try {

			String StudName = CheckStudentRequest.get(0).getStudentName();
			System.out.println(StudName);
			String StudContact = CheckStudentRequest.get(0).getStudentContactNumber();
			System.out.println(StudContact);
			String StudEmail = CheckStudentRequest.get(0).getStudentEmail();
			System.out.println(StudEmail);

			List<StudentAdmissionModel> StudCheckDetails = new ArrayList<>();
			StudCheckDetails = StudentAdmisssionInterface.getStudDetailsToCheckPresentOrNot(StudName, StudContact,
					StudEmail);
			System.out.println(StudCheckDetails);

			try {
				String StatusStud = StudCheckDetails.get(0).getStatus();
				System.out.println("Status" + StatusStud);
				
				int StudentID=StudCheckDetails.get(0).getAdmissionRegId();
				System.out.println(StudentID);
				
				String StudentFullName=StudCheckDetails.get(0).getStudentnamessc();
				System.out.println(StudentFullName);

				int lastStudId=StudCheckDetails.get(0).getLastadmissionid();
				System.out.println(lastStudId);
				
							
				if (StatusStud.equals("Approved")) {
					
					model.addAttribute("StudentID",StudentID);
					model.addAttribute("StudentFullName",StudentFullName);
					return new ModelAndView("StudRequestApprovedExcidePage");
					
				} else if (StatusStud.equals("Pending")) {
					
					model.addAttribute("StudentMessageRegardsAdmission","Application Form Is Pending For Process..Click Below Button To Print Application Form.");
					model.addAttribute("StudentID",StudentID);
					model.addAttribute("StudentFullName",StudentFullName);
					model.addAttribute("StudentLastId",lastStudId);
					return new ModelAndView("StudRequestPresentPendingExcidePage");
				} else if (StatusStud.equals("Cancel")) {
					return new ModelAndView("StudRequestCancelPage");
				} else {
					return new ModelAndView("StudRequestPresentPage");
				}

			} catch (Exception e) {
				System.out.println(e);

				List<String> GetStudList = new ArrayList<>();
				GetStudList = registerStudentI.GetStudDetails(username);

				model.addAttribute("StudInfo", GetStudList);

				int StudentID = 0;
				StudentID = StudentAdmisssionInterface.getStudentID();
				System.out.println(StudentID);
				model.addAttribute("StudentID", StudentID);

				/* Student Stream information */
				HashMap<String, String> streamList;
				streamList = StudentAdmisssionInterface.SetStream();
				System.out.println(streamList);
				model.addAttribute("StreamList", streamList);

				return new ModelAndView("StudAdmission");

			}
		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
		/*
		 * if(!(StudCheckDetails.isEmpty())&& (StudCheckDetails==null)) {
		 * 
		 * } else {
		 * 
		 * 
		 * }
		 */

	}
	
	@RequestMapping("spliteStduentName")
	@ResponseBody
	public List<String> spliteStduentName(String studNameScc)
	{
		System.out.println("spliteStduentName");
		
		List<String> studname=new ArrayList<>();
		String surname=null;
		String fathername=null;
		String myname=null;
		
		String[] arr=studNameScc.split(" ");
		
		surname=arr[0];
		System.out.println("surname" +surname);
		
		myname=arr[1];
		System.out.println("myname"+myname);
		
		fathername=arr[2];
		System.out.println("fathername"+fathername);
		
		studname.add(surname);studname.add(myname);
		studname.add(fathername);
		
		
		return studname;
		
	}
	

	@RequestMapping(value = "AdmissionStudentFinalStage", params = "TakeAddmission")
	public ModelAndView adm(HttpServletResponse response,HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("admission") StudentAdmissionModel studentAdmissionModel
			) throws IOException {
		System.out.println("final admission");

		String StudentID = request.getParameter("admissionRegId");
		System.out.println(StudentID);

		int yearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println(yearID);
		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearID);
		studentAdmissionModel.setAcadamicYearModel(acadamicYearModel);

		studentAdmissionModel.setOriginalAcademicYearID(yearID);

		/*
		 * studentAdmissionModel.setFirstYearAcademicYear(yearID);
		 * studentAdmissionModel.setSecondYearAcademicYear(yearID);
		 * studentAdmissionModel.setThirdYearAcadmicYear(yearID);
		 * studentAdmissionModel.setFourYearAcademicYear(yearID);
		 * studentAdmissionModel.setFifthYearAcademicYear(yearID);
		 */

		int streamId = Integer.parseInt(request.getParameter("streamId"));
		System.out.println(streamId);
		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		studentAdmissionModel.setStreamMasterModel(streamMasterModel);

		int branchId = Integer.parseInt(request.getParameter("branchId"));
		System.out.println(branchId);
		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		studentAdmissionModel.setBranchMasterModel(branchMasterModel);

		int standardId = Integer.parseInt(request.getParameter("standardId"));
		System.out.println(standardId);
		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		studentAdmissionModel.setStandardMasterModel(standardMasterModel);

		studentAdmissionModel.setOriginalStandardID(standardId);

		/* Create Student Barcode */
		List<acadamicYearModel> AcYear;
		AcYear = StudentAdmisssionInterface.getStudentACYear(yearID);
		System.out.println(AcYear);

		String ACYear = AcYear.get(0).getAcadamicYear();

		List<StandardMasterModel> StudStandard;
		StudStandard = StudentAdmisssionInterface.getStudentStandard(standardId);
		System.out.println(StudStandard);

		String STStandard = StudStandard.get(0).getStandard();

		// ACYear.substring(0,3).concat(STStandard.substring(0, 3));

		String studentBarcode = "ST".concat(ACYear.substring(0, 4)).concat(STStandard.substring(0, 3).toUpperCase())
				.concat("APR").concat(StudentID);

		studentAdmissionModel.setStudentBarcode(studentBarcode);

	/*	@RequestParam("image") CommonsMultipartFile file
		session = request.getSession();
		
		String imagePath = session.getServletContext().getRealPath("");
		System.out.println(imagePath);
		String ImageName = file.getOriginalFilename();
		System.out.println(ImageName);
		String path = imagePath + "/StudentPictures/";
		System.out.println(path);
		studentAdmissionModel.setStudentImage(ImageName);

		File file1 = new File(path, ImageName);
		System.out.println("dddd" + file1);
		file.transferTo(file1);
*/
		/*
		 * C:\Users\pranav\workspace\CompanyProject\.metadata\.plugins\org.
		 * eclipse.wst.server.core\tmp2\wtpwebapps\CollegeManagementSystem\
		 * StudentPictures\
		 */

		/*
		 * StudentProfilePicModel studentProfilePicModel=new
		 * StudentProfilePicModel();
		 * 
		 * String path1 = session.getServletContext().getRealPath("");
		 * 
		 * System.out.println("path:" + path1);
		 * 
		 * String filename = file.getOriginalFilename(); String absolutePath =
		 * path1 + "/UploadedFile/" + filename; File savedFile = new
		 * File(path1);
		 * 
		 * savedFile.mkdirs(); try { byte barr[] = file.getBytes();
		 * 
		 * BufferedOutputStream bout = new BufferedOutputStream( new
		 * FileOutputStream(absolutePath)); bout.write(barr); bout.flush();
		 * bout.close(); studentProfilePicModel.setImageName(filename); Date
		 * dNow = new Date(); SimpleDateFormat ft = new SimpleDateFormat(
		 * " dd/MM/yyyy  hh:mm:ss");
		 * 
		 * String currdate = ft.format(dNow);
		 * studentProfilePicModel.setUploadDate(currdate);
		 * 
		 * int ID=Integer.parseInt(StudentID);
		 * 
		 * studentAdmissionModel.setAdmissionRegId(ID);
		 * studentProfilePicModel.setStudentAdmissionModel(studentAdmissionModel
		 * );
		 * 
		 * StudentAdmisssionInterface.imageUpload(studentProfilePicModel);
		 * 
		 * } catch (Exception e) { System.out.println(e); }
		 */

		StudentBarcodeMaster studentBarcodeMaster=new StudentBarcodeMaster();
		studentBarcodeMaster.setStudentbarcode(studentBarcode);
		int studId=Integer.parseInt(StudentID);
		StudentAdmissionModel studentAdmissionModel2=new StudentAdmissionModel();
		studentAdmissionModel2.setAdmissionRegId(studId);
		studentBarcodeMaster.setStudentAdmissionModel(studentAdmissionModel2);
		
		StudentAdmisssionInterface.saveAdmission(studentAdmissionModel);
		
		StudentAdmisssionInterface.saveBracodeMaster(studentBarcodeMaster);

		model.addAttribute("StudentMsgOfAdmission","Your Application sucessfully submited.Please Go to Take Admission Page Again And Take Admission Form Print.");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<String> GetStudList = new ArrayList<>();
		GetStudList = registerStudentI.GetStudDetails(username);

		model.addAttribute("GetStudInfo", GetStudList);

		return new ModelAndView("StudentHome");
		
		
		/*String StudentFullName=request.getParameter("studentnamessc");
		System.out.println(StudentFullName);
		
		model.addAttribute("StudentMessageRegardsAdmission","Application Form Is Pending For Process..Click Below Button To Print Application Form.");
		model.addAttribute("StudentID",StudentID);
		model.addAttribute("StudentFullName",StudentFullName);
		
		return new ModelAndView("WayToPrintAdmissionPage");*/
	}
	
	@RequestMapping(value="DownLoadAdmissionAplicationForm",params="ApplicationForm")
	public ModelAndView DownLoadAdmissionAplicationForm(HttpServletResponse response,HttpSession session,HttpServletRequest request)
	{
		System.out.println("DownLoadAdmissionAplicationForm");
		
		String StudentID=request.getParameter("StudentID");
		System.out.println("Student ID"+StudentID);
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "AdmissionForm";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("admissionRegId", StudentID);
		hm.put("banner", banner);
		
			try {
				PrintJasperReport.printreport(filename, request, response, hm);
			} catch (JRException | NamingException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return new ModelAndView();
	}

	@RequestMapping(value = "GetStreamUsingJson", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = StudentAdmisssionInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStreamUsingJson1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getlist1(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = StudentAdmisssionInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardUsingJson", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStand(int id) {
		System.out.println("Way to Get Standard List");
		System.out.println("ID IS " + id);
		List<String> GetStandardList;
		GetStandardList = StudentAdmisssionInterface.GetStandardList(id);
		System.out.println(GetStandardList);
		return GetStandardList;
	}

	@RequestMapping(value = "GetStandardUsingJson1", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStand1(int id) {
		System.out.println("Way to Get Standard List");
		System.out.println("ID IS " + id);
		List<String> GetStandardList;
		GetStandardList = StudentAdmisssionInterface.GetStandardList(id);
		System.out.println(GetStandardList);
		return GetStandardList;
	}
	/*
	 * @RequestMapping(value="GetDivisionUsingJson", method=RequestMethod.GET)
	 * 
	 * @ResponseBody public List<String> GetDivision(String standardName,String
	 * streamName,String branchName) { System.out.println(
	 * "Way to get Division list"); System.out.println(streamName);
	 * System.out.println(standardName); System.out.println(branchName);
	 * List<String> GetDivisionList;
	 * 
	 * 
	 * return GetDivisionList; }
	 */

	@RequestMapping("NextYearAdmission")
	public ModelAndView NextYearAdmission() {
		System.out.println("Way to Student Next Year Admission Page");
		return new ModelAndView("NextYearAdmissionPage");
	}

	@RequestMapping("StudCancelAdmission")
	public ModelAndView StudCancelAdmission() {
		System.out.println("Way to Student Cancel Admission Page");
		return new ModelAndView("StudCancelAdmissionPage");
	}

	public StudentAdmisssionInterface getStudentAdmisssionInterface() {
		return StudentAdmisssionInterface;
	}

	public void setStudentAdmisssionInterface(StudentAdmisssionInterface studentAdmisssionInterface) {
		StudentAdmisssionInterface = studentAdmisssionInterface;
	}

	public RegisterStudentI getRegisterStudentI() {
		return registerStudentI;
	}

	public void setRegisterStudentI(RegisterStudentI registerStudentI) {
		this.registerStudentI = registerStudentI;
	}

}
