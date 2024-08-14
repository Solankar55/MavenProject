<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#studentId").blur(function(){
		var studentId=$("#studentId").val();
		//alert("studnt id");
		$.getJSON('getStudentDetailsOfAdmissionToNextYear.html',{studentId:studentId}).done(function(data){
			//alert("studentId"+studentId);
			if(data.length==0)
				{
				 alert("Student already take admission for current year/student fees is pending");
				}
			else 
				{
					alert("Student Next Year Admission Page");
					$("#collegeInformationDiv").show();
					
					$("#registrationID").val(studentId);
					$("#nameasper").val(data[0].studentnamessc);
					$("#lastName").val(data[0].studentLastName);
					$("#firstName").val(data[0].studentFirstName);
					$("#middleName").val(data[0].studentMiddleName);
					$("#motherName").val(data[0].studentMotherName);
					$("#bgroup").val(data[0].studentBloodGroup);
					$("#placeOfBirth").val(data[0].studentPlaceOfBirth);
					$("#nationality").val(data[0].studentNationality);
					$("#Email").val(data[0].studentEmail);
					$("#ContactNumber").val(data[0].studentContactNumber);
					$("#ResidentialAddress").val(data[0].studentResidentialAddress);
					$("#PermanentAddress").val(data[0].studentPermanenetAddress);
					$("#tal").val(data[0].AddressTaluka);
					$("#dist").val(data[0].Addressdistrict);
					$("#PinCode").val(data[0].studentPinCode);
					$("#ChildNumber").val(data[0].studentChildNumber);
					$("#AadharCardNumber").val(data[0].aadharCardNumber);
					$("#unino").val(data[0].uniidnumber);
					$("#cast").val(data[0].studentCast);
					
					$("#subCast").val(data[0].studentSubCast);
					$("#motherTongue").val(data[0].studentMotherTongue);
					
					$("#lysa").val(data[0].studentLastYearscholarshipApplied);
					$("#ss").val(data[0].studentScholarshipsanctioned);
					$("#yesamount").val(data[0].studentIfYesAmountRs);
					$("#psna").val(data[0].studentPreviousschoolName);
					$("#fybpharmtm").val(data[0].fybpharmTotalMarks);
					$("#fybpharmoom").val(data[0].fybpharmOutOfMarks);
					$("#fybpharmper").val(data[0].fybpharmPercentage);
					$("#sybpharmtm").val(data[0].sybpharmTotalMarks);
					$("#sybpharmoom").val(data[0].sybpharmOutOfMarks);
					$("#sybpharmper").val(data[0].sybpharmPercentage);
					$("#tybpharmtm").val(data[0].tybpharmTotalMarks);
					$("#tybpharmoom").val(data[0].tybpharmOutOfMarks);
					$("#tybpharmper").val(data[0].tybpharmPercentage);
					$("#finbpharmtm").val(data[0].finbpharmTotalMarks);
					$("#finbpharmoom").val(data[0].finbpharmOutOfMarks);
					$("#finbpharmper").val(data[0].finbpharmPercentage);
					$("#hscPCMMarks").val(data[0].hscPCMMarks);
					$("#hscpcb").val(data[0].hscPCBMarks);
					$("#hscpcmpcb").val(data[0].hscpcbpcm);
					$("#hsctm").val(data[0].hscTotalMarks);
					$("#hscoom").val(data[0].hscOutOfMarks);
					$("#hscper").val(data[0].hscpcbpcm);
					$("#ssctm").val(data[0].sscTotalMarks);
					$("#sscoom").val(data[0].sscOutOfMarks);
					$("#sscper").val(data[0].sscXIIRegNo);
					$("#AccountNumber").val(data[0].accountNumber);
					$("#bankName").val(data[0].bankName);
					$("#bankBranch").val(data[0].bankBranch);
					$("#IFSCCode").val(data[0].bankIFSCCode);
					$("#FlastName").val(data[0].fatherLastName);
					$("#FfirstName").val(data[0].fatherFirstName);
					$("#FmiddleName").val(data[0].fathermiddleName);
					$("#FPermanentAddress").val(data[0].fatherPermananetAddress);
					$("#Qualification").val(data[0].fatherEducationalQualification);
					$("#Occupation").val(data[0].fatherOccupation);
					$("#designation").val(data[0].fatherDesignation);
					$("#organization").val(data[0].fatherOrganization);
					$("#AlternateAnnualIncome").val(data[0].fatherMonthlyIncome);
					$("#fContactNumber").val(data[0].fatherContactNumber);
					$("#ParentEmail").val(data[0].fatherEmail);
					$("#mlastName").val(data[0].motherLastName);
					$("#mfirstName").val(data[0].motherFirstName);
					$("#mmiddleName").val(data[0].mothermiddleName);
					$("#MQualification").val(data[0].motherEducationalQualification);
					$("#MOccupation").val(data[0].motherOccupation);
					$("#Mdesig").val(data[0].motherDesignation);
					$("#organ").val(data[0].motherOrganization);
					$("#MAlternateAnnualIncome").val(data[0].motherMonthlyIncome);
					$("#MContactNumber").val(data[0].motherContactNumber);
					$("#MParentEmail").val(data[0].motherEmail);
					
				}
		});
	});
	
});
</script>
<script type="text/javascript">
$(document).ready(function() {
/*$("#branchName").change(function(){
	var branch=$("#branchName").val();
	alert(branch);
}); */
	
		//alert("Hello");
	 	$("#secPage").click(function() {
			//alert("way to second page");
			$("#FirstPage").hide();
			$("#SecondPage").show();
		});
		$("#FPage").click(function() {
			//alert("way to prvious first Page");
			$("#FirstPage").show();
			$("#SecondPage").hide();
		});
		$("#TPage").click(function() {
			//alert("way to Third Page");
			$("#ThirdPage").show();
			$("#SecondPage").hide();
		});
		$("#SPage").click(function() {
			//alert("way to privoius second page");
			$("#SecondPage").show();
			$("#ThirdPage").hide();
		});
		$("#FoPage").click(function() {
			//alert("Way to Fouth Page");
			$("#FourPage").show();
			$("#ThirdPage").hide();
		});
		$("#ThPage").click(function() {
			//alert("Way to Back Thirrd PAge");
			$("#ThirdPage").show();
			$("#FourPage").hide();
		});

		$("#TakeAddmission").click(function(){
			//alert("Your Addmissiom Request IS Processed....");
		});
		
		$('#checkDeclaration').click(function() {
	        if($(this).is(":checked"))
	        {
	            $('#TakeAddmission').show();
	        } else {
	            $('#TakeAddmission').hide();
	        }
	    });
 	});
</script>
<script type="text/javascript">
$(document).ready(function(){
 	 $("#streamId").change(function(){
 		// alert("sss");
		var id=$("#streamId").val();
		$("#branchName").empty();
		$("#standardName").empty();
		$("#branchName").append("<option>"+"---Select Branch Name---"+"</option>");
		$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
		
		//alert("List Found");
		$.getJSON('GetStreamUsingJson.html',{id:id}).done(function(data){	
			//alert(data[0].branchId);
			for (var i = 0; i<data.length; i++) {
				//alert("sss");
				$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+data[i].branchName+"</option>");
				//html += "<option value='"+data[i].branchId+"' id='dynamic'>"
						//+ data[i].branchName + "</option>";
			}
		});
 	});
 	$("#branchName").change(function(){
 		// alert("sss");
		var id=$("#branchName").val();
		$("#standardName").empty();
		$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
		//alert("List Found");
		$.getJSON('GetStandardUsingJson.html',{id:id}).done(function(data){	
			//alert(data[0].branchId);
			 for (var i = 0; i<data.length; i++) {
				//alert("sss");
				$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+data[i].standard+"</option>");
				
			} 
		});
 	});
 	/* $("#standardName").change(function(){
 		 alert("sss");
		var standardname=$("#standardName").val();
		var streamname=$("#streamName").val();
		var branchname=$("#branchName").val();
		$("#divisionName").find("option").remove("#dynamicDiv");
		alert("List Found");
		$.getJSON('GetDivisionUsingJson.html',{standardName:standardName,streamName:streamName,branchName:branchName}).done(function(data){	
			//alert(data[0].branchId);
			 /* for (var i = 0; i<data.length; i++) {
				//alert("sss");
				$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+data[i].standard+"</option>");
				
			}  
		 }); 
 	}); */
 	
 	$("#nameasper").blur(function(){
 		var studNameScc=$("#nameasper").val();
 		
 		$.getJSON('spliteStduentName.html',{studNameScc:studNameScc}).done(function(data){
 			//alert("check");
 			var srname=data[0];
 			//alert("srname" +srname);
 			
 			var fname=data[2];
 			//alert("fname" +fname);
 			
 			var myname=data[1];
 			//alert("myname" +myname);
 			
 			$("#lastName").val(srname);
 			$("#middleName").val(fname);
 			$("#firstName").val(myname);
 			
 			$("#FlastName").val(srname);
 			$("#FfirstName").val(fname);
 			$("#mlastName").val(srname);
 			$("#mmiddleName").val(fatherName);
 		});
 		
 	});
	 
 	$("#motherName").blur(function(){
 		var motherName=$("#motherName").val();
 		$("#mfirstName").val(motherName);
 	});
 	
 });
 </script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1>
				<b>Student Next Year Admission</b>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
							Student Previous Admission Id:<span style="color: red;">*</span>
						</label>
					<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="studentId" name="studentId"
								placeholder="Student Previous admission id" required pattern="[0-9]+"
								title="Please Enter Correct Student Id" />
					</div>
				</div>
			</div>
		</div>
		<hr/>
	<form action="studentNextYearAdmissionViaAccountSave.html" method="post">	
		<!-- College Information -->
		<div id="collegeInformationDiv" style="display: none;"> 
				<!-- First Page -->
				<div class="row" id="FirstPage">
					<div class="col-xs-12 col-sm-4" id="collegeDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">College Information</h4>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div style="display: none;">
										<label for="form-field-8">Admission Registration Id</label> <input
											type="text" class="form-control" id="registrationID"
											name="admissionRegId" placeholder="Admission Registration Id"
											value="${StudentID }" readonly="true" />
									</div>
									<div>
										<label for="form-field-8">Admission Date</label> <input
											type="text" class="form-control" id="currentAdmissionDate"
											name="admissionDate" placeholder="Admission Date"
											value="${curentdate}" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Academic Year <span
											style="color: red;">*</span></label>
										<%-- <s:input type="text" class="form-control" id="currentAcademicYear" path="acadamicYear" placeholder="Academic year" value="${academic }" /> --%>
										<select class="form-control" name="YearName" id="YearID"
											required>
											<option value="">....Select Academic Year....</option>
											<c:forEach var="v" items="${YearList}">
												<option value="${v.key}">${v.value}</option>
											</c:forEach>
										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Stream Name <span
											style="color: red;">*</span></label> <select class="form-control"
											name="streamId" id="streamId" required>
											<option value="">....Select Stream....</option>
											<c:forEach var="v" items="${StreamList}">
												<option value="${v.key}">${v.value}</option>
											</c:forEach>
										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Branch Name <span
											style="color: red;">*</span></label> <select class="form-control"
											id="branchName" name="branchId" required>
											<option id="dynamic" value="">....Select Branch....</option>

										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Standard <span
											style="color: red;">*</span></label> <select class="form-control"
											id="standardName" name="standardId" required>
											<option id="dynamicStd" value="">....Select
												Standard....</option>

										</select>
									</div>
									<hr />
									<br>
									<%-- <div>
										<label for="form-field-select-1">Division</label> 
								<s:select class="form-control" id="divisionName" name="divisionId" path="">
											<s:option id="dynamicDiv" value="0">....Select Division....</s:option>
											
								</s:select>
									</div>
							<hr/> --%>
								</div>
							</div>
						</div>
					</div>


					<!-- Student Information Div -->

					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>

							<div class="widget-body">
								<div class="widget-main">

									<div>
										<label for="form-field-8">Full Name (As Per the SSC
											mark sheet)<span style="color: red;">*</span>
										</label> <input type="text" class="form-control" id="nameasper"
											name="studentnamessc"
											placeholder="Surname middlename Fathername"
											pattern="[a-z A-Z]+" title="Please Enter Correct Name"
											value="${StudInfo.studentnamessc }">
									</div>
									<hr />
									<div>
										<input type="text" class="form-control" id="lastName"
											name="studentLastName" placeholder="Last Name"
											readonly="true" value="${StudInfo.studentLastName }" /> <br>
										<input type="text" class="form-control" id="firstName"
											name="studentFirstName" placeholder=" First Name"
											readonly="true" value="${StudInfo.studentFirstName}" /><br>
										<input type="text" class="form-control" id="middleName"
											name="studentMiddleName" placeholder=" Middle Name"
											readonly="true" value="${StudInfo.studentMiddleName }" /> <br>
										<input type="text" class="form-control" id="motherName"
											name="studentMotherName" placeholder=" Mother Name"
											value="${StudInfo.studentMotherName }" />
									</div>
									<!-- <hr />
								<div>
									<label for="form-field-8">Select Image</label> <input
										type="file" class="form-control" id="studentimage"
										name="image" placeholder="Student Image"
										accept="image/x-png, image/gif, image/jpeg" />
									<input type="hidden" name="image" id="image" accept="image/x-png, image/gif, image/jpeg"/>
								</div> -->
									<hr />
									<div>
										<label for="form-field-select-1">Gender <span
											style="color: red;">*</span></label> <select class="form-control"
											id="form-field-select-1" name="studentGender" required>
											<option value="">Select Gender...</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Blood Group </label> <input
											type="text" class="form-control" id="bgroup"
											name="studentBloodGroup" placeholder="Blood Group"
											value="${StudInfo.studentBloodGroup }" />
									</div>
									<hr />
								</div>
							</div>
						</div>
					</div>

					<!-- Student Other Information -->

					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">Date Of Birth <span
											style="color: red;">*</span></label> <input type="date"
											class="form-control" id="dob" name="studentDateOfBirth"
											placeholder="" value="${StudInfo.studentDateOfBirth }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Place Of Birth <span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="placeOfBirth"
											name="studentPlaceOfBirth" placeholder="Place Of Birth"
											value="${StudInfo.studentPlaceOfBirth }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Nationality</label> <input
											value="Indian" type="text" class="form-control"
											id="nationality" name="studentNationality"
											value="${StudInfo.studentNationality }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Student Email ID</label> <input
											type="text" value="${StudInfo.studentEmail}"
											class="form-control" id="Email" name="studentEmail"
											placeholder="Email" readonly="true" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Contact Number</label> <input
											type="text" value="${StudInfo.studentContactNumber}"
											class="form-control" id="ContactNumber"
											name="studentContactNumber" placeholder="Contact Number"
											readonly="true" />
									</div>
									<hr />

									<center>
										<button type="button" id="secPage"
											class="btn btn-sm btn-success">
											Next <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>
									</center>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Second Page Start -->

				<div class="row" id="SecondPage" style="display: none;">
					<div class="col-xs-12 col-sm-4" id="" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">Residential Address<span
											style="color: red;">*</span></label>
										<textarea class="form-control" id="ResidentialAddress"
											name="studentResidentialAddress"
											placeholder="Residential Address">${StudInfo.studentResidentialAddress }</textarea>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Permanent Address<span
											style="color: red;">*</span></label>
										<textarea class="form-control" id="PermanentAddress"
											name="studentPermanenetAddress"
											placeholder="Permanent Address">${StudInfo.studentPermanenetAddress }</textarea>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Taluka<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="tal" name="AddressTaluka"
											placeholder="Taluka" value="${StudInfo.AddressTaluka }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">District<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="dist" name="Addressdistrict"
											placeholder="District" value="${StudInfo.Addressdistrict }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Pin Code<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="PinCode" name="studentPinCode"
											placeholder="Pin Code" value="${StudInfo.studentPinCode }" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Are you Domicile of
											Maharashtra<span style="color: red;">*</span>
										</label> <select class="form-control" id="form-field-select-1"
											name="studentDomicileofMaharashtra">
											<option value="">Select ...</option>
											<option value="Yes">Yes</option>
											<option value="No">No</option>
										</select>
									</div>
									<hr />
								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">&#2309;&#2346;&#2340;&#2381;&#2351;
											&#2325;&#2381;&#2352;&#2350;&#2366;&#2306;&#2325; (Serial
											Number In Siblings) </label> <input type="text" class="form-control"
											id="ChildNumber" name="studentChildNumber"
											placeholder="Your Number In Siblingss"
											value="${StudInfo.studentChildNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Aadhar Card Number<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="AadharCardNumber"
											name="aadharCardNumber" placeholder="Aadhar Card Number"
											maxlength="12" minlength="12"
											title="Please Enter Correct Aadhar Number"
											value="${StudInfo.aadharCardNumber }" />
									</div>
									<hr />

									<div>
										<label for="form-field-8">Eligibility Number</label> <input
											type="text" class="form-control" id="unino"
											name="uniidnumber" placeholder="Eligibility Number"
											value="${StudInfo.uniidnumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Religion<span
											style="color: red;">*</span></label> <select class="form-control"
											id="form-field-select-1" name="studentReligion" required>
											<option value="">---Select Religion---</option>
											<option value="Hindu">Hindu</option>
											<option value="Muslim">Muslim</option>
											<option value="Christian">Christian</option>
											<option value="Christian">Sikh</option>
											<option value="Other">Other</option>

										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Cast<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="cast" name="studentCast"
											placeholder="Cast" value="${StudInfo.studentCast }" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Category<span
											style="color: red;">*</span></label> <select class="form-control"
											id="form-field-select-1" name="studentCategory" required>
											<option value="">---Select Category---</option>
											<option value="Open">Open</option>
											<option value="OBC">OBC</option>
											<option value="SBC">SBC</option>
											<option value="ST">ST</option>
											<option value="VJ-NT">VJ-NT</option>
											<option value="NT-B">NT-B</option>
											<option value="NT-C">NT-C</option>
											<option value="NT-D">NT-D</option>
											<option value="SC">SC</option>
											<option value="Minority">Minority</option>
											<option value="Other">Other</option>


										</select>
									</div>


									<div style="display: none;">
										<label for="form-field-8">Sub Cast</label> <input type="text"
											class="form-control" id="subCast" name="studentSubCast"
											placeholder="Sub Cast" value="${StudInfo.studentSubCast}" />
									</div>
									<div style="display: none;">
										<label for="form-field-8">Mother Tongue</label> <input
											type="text" class="form-control" id="motherTongue"
											name="studentMotherTongue" placeholder="Mother Tongue"
											value="${StudInfo.studentMotherTongue }" />
									</div>
									<hr />

								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-select-1">Hostel<span
											style="color: red;">*</span></label> <select class="form-control"
											id="form-field-select-1" name="studentHostel">
											<option value="">Select Hostel...</option>
											<option value="Yes">Yes</option>
											<option value="No">No</option>
										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Last Year scholarship
											Applied</label> <input type="text" class="form-control" id="lysa"
											name="studentLastYearscholarshipApplied"
											placeholder="Last Year scholarship Applied"
											value="${StudInfo.studentLastYearscholarshipApplied }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Scholarship sanctioned:
											Yes/No</label> <input type="text" class="form-control" id="ss"
											name="studentScholarshipsanctioned"
											placeholder="Last Year scholarship Applied"
											value="${StudInfo.studentScholarshipsanctioned }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">If Yes,Amount Rs.</label> <input
											type="text" class="form-control" id="yesamount"
											name="studentIfYesAmountRs" placeholder="If Yes,Amount Rs."
											value="${StudInfo.studentIfYesAmountRs }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Previous school Name and
											Address</label> <input type="text" class="form-control" id="psna"
											name="studentPreviousschoolName"
											placeholder="Previous school Name & Address"
											value="${StudInfo.studentPreviousschoolName }" />
									</div>
									<hr />
									<br>
									<br>
									<center>
										<button type="button" id="FPage"
											class="btn btn-sm btn-success">
											Previous <i
												class="ace-icon fa fa-arrow-left icon-on-left bigger-110"></i>
										</button>

										<button type="button" id="TPage"
											class="btn btn-sm btn-success">
											Next <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>

									</center>
									<br>
									<br>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Third Page Start -->

				<div class="row" id="ThirdPage" style="display: none;">
					<div class="col-xs-12 col-sm-4" id="" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Educational Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">F.Y. B.Pharm</label> <input
											type="text" class="form-control" id="fybpharmtm"
											name="fybpharmTotalMarks" placeholder="CGPA"
											value="${StudInfo.fybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/> <br> <%-- <input
											type="text" class="form-control" id="fybpharmoom"
											name="fybpharmOutOfMarks" placeholder="SGPA"
											value="${StudInfo.fybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="fybpharmper"
											name="fybpharmPercentage" placeholder=" Percentage"
											readonly="true" value="${StudInfo.fybpharmPercentage }" /> --%>
									</div>
									<hr />
									<!-- <script>
										$("#fybpharmoom").blur(function(){
											var obtainM=$("#fybpharmoom").val();
											var totalM=$("#fybpharmtm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#fybpharmper").val(n);
											
										});
										
									</script> -->
									<div>
										<label for="form-field-8">S.Y. B.Pharm</label> <input
											type="text" class="form-control" id="sybpharmtm"
											name="sybpharmTotalMarks" placeholder="CGPA"
											value="${StudInfo.sybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/> <br> <%-- <input
											type="text" class="form-control" id="sybpharmoom"
											name="sybpharmOutOfMarks" placeholder="SGPA"
											value="${StudInfo.sybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA" /> <br> <input
											type="text" class="form-control" id="sybpharmper"
											name="sybpharmPercentage" placeholder=" Percentage"
											readonly="true" value="${StudInfo.sybpharmPercentage }" /> --%>
									</div>
									<hr />
									<!-- <script>
										$("#sybpharmoom").blur(function(){
											var obtainM=$("#sybpharmoom").val();
											var totalM=$("#sybpharmtm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#sybpharmper").val(n);
											
										});
										
									</script> -->
									<div>
										<label for="form-field-8">T.Y. B.Pharm</label> <input
											type="text" class="form-control" id="tybpharmtm"
											name="tybpharmTotalMarks" placeholder="CGPA"
											value="${StudInfo.tybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/> <br><%--  <input
											type="text" class="form-control" id="tybpharmoom"
											name="tybpharmOutOfMarks" placeholder="SGPA"
											value="${StudInfo.tybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="tybpharmper"
											name="tybpharmPercentage" placeholder=" Percentage"
											readonly="true" value="${StudInfo.tybpharmPercentage }" /> --%>
									</div>
									<hr />
									<!-- <script>
										$("#tybpharmoom").blur(function(){
											var obtainM=$("#tybpharmoom").val();
											var totalM=$("#tybpharmtm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#tybpharmper").val(n);
											
										});
										
									</script>
 -->
 									<div>
										<label for="form-field-8">Final B.Pharm</label> <input
											type="text" class="form-control" id="finbpharmtm"
											name="finbpharmTotalMarks" placeholder="CGPA"
											value="${StudInfo.finbpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/> <br><%--  <input
											type="text" class="form-control" id="finbpharmoom"
											name="finbpharmOutOfMarks" placeholder="SGPA"
											value="${StudInfo.finbpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="finbpharmper"
											name="finbpharmPercentage" placeholder=" Percentage"
											readonly="true" value="${StudInfo.finbpharmPercentage}" /> --%>
									</div>
									<hr />
									<!-- <script>
										$("#finbpharmoom").blur(function(){
											var obtainM=$("#finbpharmoom").val();
											var totalM=$("#finbpharmtm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#finbpharmper").val(n);
											
										});
										
									</script> -->
								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Educational Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<%-- <div>
										<label for="form-field-8">Final B.Pharm</label> <input
											type="text" class="form-control" id="finbpharmtm"
											name="finbpharmTotalMarks" placeholder="CGPA"
											value="${StudInfo.finbpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/> <br> <input
											type="text" class="form-control" id="finbpharmoom"
											name="finbpharmOutOfMarks" placeholder="SGPA"
											value="${StudInfo.finbpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="finbpharmper"
											name="finbpharmPercentage" placeholder=" Percentage"
											readonly="true" value="${StudInfo.finbpharmPercentage}" />
									</div>
									<hr />
									<!-- <script>
										$("#finbpharmoom").blur(function(){
											var obtainM=$("#finbpharmoom").val();
											var totalM=$("#finbpharmtm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#finbpharmper").val(n);
											
										});
										
									</script> --> --%>
									<div>
										<label for="form-field-8">MHT-CET<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="hscPCMMarks" name="hscPCMMarks"
											placeholder="PCM " value="${StudInfo.hscPCMMarks }" /> <br>
										<input type="text" class="form-control" id="hscpcb"
											name="hscPCBMarks" placeholder=" PCB"
											value="${StudInfo.hscPCBMarks}" /> <br> <input
											type="text" class="form-control" id="hscpcmpcb"
											name="hscPCMPCBTotalMarks" placeholder=" PCMB"
											style="display: none;"
											value="${StudInfo.hscPCMPCBTotalMarks }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">HSC<span style="color: red;">*</span></label>
										<input type="text" class="form-control" id="hsctm"
											name="hscTotalMarks" placeholder="Total Marks"
											value="${StudInfo.hscTotalMarks}" /> <br> <input
											type="text" class="form-control" id="hscoom"
											name="hscOutOfMarks" placeholder=" Obtain Marks"
											value="${StudInfo.hscOutOfMarks }" /> <br> <input
											type="text" class="form-control" id="hscper" name="hscpcbpcm"
											placeholder=" HSC Percentage %" readonly="true"
											value="${StudInfo.hscpcbpcm }" />
									</div>
									<hr />
									<script>
										$("#hscoom").blur(function(){
											var obtainM=$("#hscoom").val();
											var totalM=$("#hsctm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#hscper").val(n);
											
										});
										
									</script>
									<div>
										<label for="form-field-8">SSC<span style="color: red;">*</span></label>
										<input type="text" class="form-control" id="ssctm"
											name="sscTotalMarks" placeholder="Total Marks"
											value="${StudInfo.sscTotalMarks}" /> <br> <input
											type="text" class="form-control" id="sscoom"
											name="sscOutOfMarks" placeholder=" Obtain Marks"
											value="${StudInfo.sscOutOfMarks }" /> <br> <input
											type="text" class="form-control" id="sscper"
											name="sscXIIRegNo" placeholder=" SSC Percentage"
											readonly="true" value="${StudInfo.sscXIIRegNo }" />
									</div>
									<script>
										$("#sscoom").blur(function(){
											var obtainM=$("#sscoom").val();
											var totalM=$("#ssctm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#sscper").val(n);
											
										});
										
									</script>
									<hr />
								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Account Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<%-- <div>
										<label for="form-field-8">SSC<span style="color: red;">*</span></label>
										<input type="text" class="form-control" id="ssctm"
											name="sscTotalMarks" placeholder="Total Marks"
											value="${StudInfo.sscTotalMarks}" /> <br> <input
											type="text" class="form-control" id="sscoom"
											name="sscOutOfMarks" placeholder=" Obtain Marks"
											value="${StudInfo.sscOutOfMarks }" /> <br> <input
											type="text" class="form-control" id="sscper"
											name="sscXIIRegNo" placeholder=" SSC Percentage"
											readonly="true" value="${StudInfo.sscXIIRegNo }" />
									</div>
									<script>
										$("#sscoom").blur(function(){
											var obtainM=$("#sscoom").val();
											var totalM=$("#ssctm").val();
											
											var perM = (+obtainM / +totalM) * 100;
											var n = perM.toFixed(2);
											$("#sscper").val(n);
											
										});
										
									</script>
									<hr /> --%>
									<div>
										<label for="form-field-8">Account Number</label> <input
											type="text" class="form-control" id="AccountNumber"
											name="accountNumber" placeholder="Account Number"
											value="${StudInfo.accountNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Bank Name</label> <input
											type="text" class="form-control" id="bankName"
											name="bankName" placeholder="Bank Name" pattern="[a-z A-Z]+"
											title="Please Enter Correct Name"
											value="${StudInfo.bankName }" />

										<%-- 
										
										
										<select
											class="form-control" id="form-field-select-1" name="bankName" >
											<option value="">---Select Bank Name---</option>
											<option value="Bank Of Maharashtra">Bank Of
												Maharashtra</option>
											<option value="Sate Bank Of India">Sate Bank Of
												India</option>
											<option value="Bank Of India">Bank Of India</option>
											<option value="ICICI Bank">ICICI Bank</option>
											<option value="Union Bank Of India">Union Bank Of
												India</option>

										</select> --%>
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Bank Branch</label> <input
											type="text" class="form-control" id="bankBranch"
											name="bankBranch" placeholder="Branch Name"
											pattern="[a-z A-Z]+" title="Please Enter Correct Name"
											value="${StudInfo.bankBranch }" />

										<%-- 	<select
											class="form-control" id="form-field-select-1"
											name="bankBranch">
											<option value="">--- Select Branch Name---</option>
											<option value="Pune">Pune</option>
											<option value="Nashik">Nashik</option>
											<option value="Sanagmner">Sanagmner</option>
											<option value="Mumbai">Mumbai</option>
											<option value="Other">Other</option>

										</select> --%>
									</div>
									<hr />
									<div>
										<label for="form-field-8">IFSC Code</label> <input type="text"
											class="form-control" id="IFSCCode" name="bankIFSCCode"
											placeholder="IFSC Code"
											title="Please Enter Correct IFSC Code"
											value="${StudInfo.bankIFSCCode }" />
									</div>
									<hr />
									<center>
										<button type="button" id="SPage"
											class="btn btn-sm btn-success">
											Previous <i
												class="ace-icon fa fa-arrow-left icon-on-left bigger-110"></i>
										</button>

										<button type="button" id="FoPage"
											class="btn btn-sm btn-success">
											Next <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>

									</center>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Forth Page Start -->

				<div class="row" id="FourPage" style="display: none;">
					<div class="col-xs-12 col-sm-4" id="" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Father Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">Father's Name </label> <input
											type="text" class="form-control" id="FlastName"
											name="fatherLastName" placeholder="Last Name" readonly="true"
											value="${StudInfo.fatherLastName }" /> <br> <input
											type="text" class="form-control" id="FfirstName"
											name="fatherFirstName" placeholder="First Name"
											readonly="true" value="${StudInfo.fatherFirstName }" /><br>
										<input type="text" class="form-control" id="FmiddleName"
											name="fathermiddleName" placeholder="Middle Name"
											value="${StudInfo.fathermiddleName }" />
									</div>
									<hr />
									<div style="display: none;">
										<label for="form-field-8">Permanent Address</label>
										<textarea class="form-control" id="FPermanentAddress"
											name="fatherPermananetAddress"
											placeholder="Father Permanent Address">${StudInfo.fatherPermananetAddress}</textarea>
									</div>
									<div>
										<label for="form-field-8">Educational Qualification</label> <input
											type="text" class="form-control" id="Qualification"
											name="fatherEducationalQualification"
											placeholder="Educational Qualification"
											value="${StudInfo.fatherEducationalQualification }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Occupation</label> <input
											type="text" class="form-control" id="Occupation"
											name="fatherOccupation" placeholder="Occupation"
											value="${StudInfo.fatherOccupation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Designation</label> <input
											type="text" class="form-control" id="designation"
											name="fatherDesignation" placeholder="Designation"
											value="${StudInfo.fatherDesignation}" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Organization</label> <input
											type="text" class="form-control" id="organization"
											name="fatherOrganization" placeholder="Organization"
											value="${StudInfo.fatherOrganization }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Annual Income</label> <input
											type="text" class="form-control" id="AlternateAnnualIncome"
											name="fatherMonthlyIncome" placeholder="Annual Income"
											value="${StudInfo.fatherMonthlyIncome }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Contact Number<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="fContactNumber"
											name="fatherContactNumber" placeholder="Contact Number"
											maxlength="10" title="Please Enter Correct Mobile Number"
											value="${StudInfo.fatherContactNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Email Address</label> <input
											type="text" class="form-control" id="ParentEmail"
											name="fatherEmail" placeholder="Email Address"
											value="${StudInfo.fatherEmail }" />
									</div>
									<hr />

								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Mother Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">Mother's Name </label> <input
											type="text" class="form-control" id="mlastName"
											name="motherLastName" placeholder="Last Name" readonly="true"
											value="${StudInfo.motherLastName }" /> <br> <input
											type="text" class="form-control" id="mfirstName"
											name="motherFirstName" placeholder="Mother  Name"
											value="${StudInfo.motherFirstName }" /><br> <input
											type="text" class="form-control" id="mmiddleName"
											name="mothermiddleName" placeholder="Middle Name"
											value="${StudInfo.mothermiddleName }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Educational Qualification</label> <input
											type="text" class="form-control" id="MQualification"
											name="motherEducationalQualification"
											placeholder="Educational Qualification"
											value="${StudInfo.motherEducationalQualification }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Occupation</label> <input
											type="text" class="form-control" id="MOccupation"
											name="motherOccupation" placeholder="Occupation"
											value="${StudInfo.motherOccupation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Designation</label> <input
											type="text" class="form-control" id="Mdesig"
											name="motherDesignation" placeholder="Designation"
											value="${StudInfo.motherDesignation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Organization</label> <input
											type="text" class="form-control" id="organ"
											name="motherOrganization" placeholder="Organization"
											value="${StudInfo.motherOrganization }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Annual Income</label> <input
											type="text" class="form-control" id="MAlternateAnnualIncome"
											name="motherMonthlyIncome" placeholder="Annual Income"
											value="${StudInfo.motherMonthlyIncome }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Contact Number</label> <input
											type="text" class="form-control" id="MContactNumber"
											name="motherContactNumber" placeholder="Contact Number"
											maxlength="10" pattern="[789][0-9]{9}"
											title="Please Enter Correct Mobile Number"
											value="${StudInfo.motherContactNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Email Address</label> <input
											type="text" class="form-control" id="MParentEmail"
											name="motherEmail" placeholder="Email Address"
											value="${StudInfo.motherEmail}" />
									</div>
									<hr />
								</div>
							</div>
						</div>
					</div>

					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Declaration</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<label for="form-field-8"><b>Declaration Of Student</b></label><br>

									<h5>
										<p>
											<input type="checkbox" id="checkDeclaration" /> I am aware of
											the Maharashtra Prohibition of Ragging Act, 1999 and I state
											that I will abide by all the rules and regulations of the
											said Act.
										</p>
									</h5>
									<%-- <script type="text/javascript">
								$(document).ready(function() {    
								    
								});
									
								</script> --%>
									<hr />
									<div class="form-actions center">

										<button type="button" id="ThPage"
											class="btn btn-sm btn-success">
											<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110">
												Previous</i>
										</button>
										<button type="submit" class="btn btn-sm btn-success"
											name="TakeNextAddmission" id="TakeAddmission"
											style="display: none;">
											Submit <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>
									</div>
									<hr />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>