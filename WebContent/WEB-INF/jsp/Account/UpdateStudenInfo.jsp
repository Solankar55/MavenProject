<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Admission Profile</title>
<meta name="description" content="and Validation" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/select2.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-rtl.min.css" />

<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/js/ace-extra.min.js"></script>
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
 	});
</script>

<script>
$(document).ready(function(){

$("#streamId").change(function(){
	//alert("sss");
	var id=$("#streamId").val();
	$("#branchName").empty();
	$("#standardName").empty();
	$("#branchName").append("<option>"+"---Select Branch Name---"+"</option>");
	$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
	
	//alert("List Found");
	$.getJSON('GetStreamUsingJson1.html',{id:id}).done(function(data){	
	//alert(data[0].branchId);
		for (var i = 0; i<data.length; i++) {
			//alert("sss");
			$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+data[i].branchName+"</option>");
			//html += "<option value='"+data[i].branchId+"' id='dynamic'>"
					//+ data[i].branchName + "</option>";
		}
	});
	});

		$("#secPage").click(function() {
			//alert("Sa");
			$("#SecondPage").show();
			var str=$("#StreamID").val();
			var branch=$("#BranchId").val();
			var Stand=$("#StandId").val();
			var year=$("#YearrrrID").val();
			/* alert(str);
			alert(branch);
			alert(Stand);
			alert(year); */
		/* 	var gender=$("#Studgender").val();
			var religion=$("#Studreligion").val();
			var category=$("#Studcategory").val(); */
			/* alert(gender);
			alert(religion);
			alert(category); */
			/* $("div.StudGender select").val(gender);
			$("div.StudReligion select").val(religion);
			$("div.StudCategory select").val(category); */
			
			$('#YearID option').eq(year).prop('selected',true);
			$('#streamId option').eq(str).prop('selected',true);
			var id=str;
			//alert("id"+id);
			$.getJSON('GetStreamUsingJson1.html',{id:id}).done(function(data){	
				//alert(data[0].branchId);
					for (var i = 0; i<data.length; i++) {
						//alert("sss");
						$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+data[i].branchName+"</option>");
						//html += "<option value='"+data[i].branchId+"' id='dynamic'>"
								//+ data[i].branchName + "</option>";
					}
					$('#branchName option').eq(branch).prop('selected',true);
				});
			
			
			var id1=branch;
			
			$.getJSON('GetStandardUsingJson1.html',{id:id1}).done(function(data){
				//alert("get stand");
				//alert(data[0].branchId);
				 for (var i = 0; i<data.length; i++) {
					//alert("sss");
					$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+data[i].standard+"</option>");
					
				} 
				// alert(" asjk");
				 $('#standardName option').eq(Stand).prop('selected',true);
			});
			 
		//	$("#FirstDetails1").hide();
		});
	
	
		$("#branchName").change(function(){
	 		// alert("sss");
			var id=$("#branchName").val();
			$("#standardName").empty();
			$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
			//alert("List Found");
			$.getJSON('GetStandardUsingJson1.html',{id:id}).done(function(data){	
				//alert(data[0].branchId);
				 for (var i = 0; i<data.length; i++) {
					//alert("sss");
					$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+data[i].standard+"</option>");
					
				} 
			});
	 	});
		
	var	assignvalue	=function(){ 	
		
	var str=$("#StreamID").val();
	var branch=$("#BranchId").val();
	var Stand=$("#StandId").val();
	var year=$("#YearID").val();
	/* alert(str);
	alert("branch"+branch);
	alert(Stand);
	alert(year); */
	}
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
			<h1>Update Student Information</h1>
			<br>
		</div>
		<form action="updateStudentInformationDetails.html" method="post">
			<c:forEach var="s" items="${studentInfo}">
				<!-- College Information -->
				<!-- First Page -->
				<div class="row" id="FirstPage">

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
											name="studentnamessc" value="${s.studentnamessc }">
									</div>
									<hr />
									<div>
										<input type="text" class="form-control" id="lastName"
											name="studentLastName" value="${s.studentLastName }" /> <br>
										<input type="text" class="form-control" id="firstName"
											name="studentFirstName" value="${s.studentFirstName }" readonly="true"/><br>
										<input type="text" class="form-control" id="middleName"
											name="studentMiddleName" value="${s.studentMiddleName }" />
										<br> <input type="text" class="form-control"
											id="motherName" name="studentMotherName"
											value="${s.studentMotherName }" />
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
											name="studentBloodGroup" value="${s.studentBloodGroup }" />
									</div>
									<hr />
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
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
											placeholder="" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Place Of Birth <span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="placeOfBirth"
											name="studentPlaceOfBirth" value="${s.studentPlaceOfBirth }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Nationality</label> <input
											value="Indian" type="text" class="form-control"
											id="nationality" name="studentNationality" />
									</div>
									<hr />
									<div style="display: none;">
										<label for="form-field-8">Student Email ID</label> <input
											type="text" value="" class="form-control" id="Email"
											name="studentEmail" value="${s.studentEmail }" readonly="true"/>
									</div>
									<!-- <hr /> -->
									<div style="display: none;">
										<label for="form-field-8">Contact Number</label> <input
											type="text" value="" class="form-control" id="ContactNumber"
											name="studentContactNumber"
											value="${s.studentContactNumber }" readonly="true"/>
									</div>
									<!-- <hr /> -->
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br> <br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br> <br>
									<br>
									<br>
									<br>
									<br>

								</div>
							</div>
						</div>
					</div>



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
											name="studentResidentialAddress"> ${s.studentResidentialAddress }</textarea>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Permanent Address<span
											style="color: red;">*</span></label>
										<textarea class="form-control" id="PermanentAddress"
											name="studentPermanenetAddress">${s.studentPermanenetAddress }</textarea>
									</div>
									<hr />
									<div>
										<label for="form-field-8">Taluka<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="tal" name="AddressTaluka"
											value="${s.AddressTaluka }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">District<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="dist" name="Addressdistrict"
											value="${s.Addressdistrict }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Pin Code<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="PinCode" name="studentPinCode"
											value="${s.studentPinCode }" />
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
					<div class="col-xs-12 col-sm-4" id="collegeDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">College Information</h4>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<div >
										<label for="form-field-8">Admission Registration Id</label> <input
											type="text" class="form-control" id="registrationID"
											name="admissionRegId" value="${s.admissionRegId }"
											readonly="true" />
									</div>
									<hr/>
									<div >
										<label for="form-field-8">Admission Date</label> <input
											type="text" class="form-control" id="currentAdmissionDate"
											name="admissionDate" value="${s.admissionDate }" readonly="true" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Academic Year <span
											style="color: red;">*</span></label>
										<%-- <s:input type="text" class="form-control" id="currentAcademicYear" path="acadamicYear" placeholder="Academic year" value="${academic }" /> --%>
										<select class="form-control" name="YearName" id="YearID"
											path="" required>
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
											name="streamId" id="streamId" path="" required>
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
											id="branchName" name="branchId" path="" required>
											<option id="dynamic" value="">....Select Branch....</option>

										</select>
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Standard <span
											style="color: red;">*</span></label> <select class="form-control"
											id="standardName" name="standardId" path="" required>
											<option id="dynamicStd" value="">....Select
												Standard....</option>

										</select>
									</div>
									<hr />
									
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


					<!-- Student Information Continue -->
					<div class="col-xs-12 col-sm-4" id="studDiv" style="">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Student Information</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div>
										<label for="form-field-8">&#2309;&#2346;&#2340;&#2381;&#2351; &#2325;&#2381;&#2352;&#2350;&#2366;&#2306;&#2325; (Serial Number In Siblings) </label><input
											type="text" class="form-control" id="ChildNumber"
											name="studentChildNumber" value="${s.studentChildNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Aadhar Card Number<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="AadharCardNumber" maxlength="12" minlength="12"
											name="aadharCardNumber" value="${s.aadharCardNumber }" />
									</div>
									<hr />

									<div>
										<label for="form-field-8">Eligibility Number</label> <input
											type="text" class="form-control" id="unino"
											name="uniidnumber" value="${s.uniidnumber }" />
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
											value="${s.studentCast }" />
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
											placeholder="Sub Cast" />
									</div>
									<div style="display: none;">
										<label for="form-field-8">Mother Tongue</label> <input
											type="text" class="form-control" id="motherTongue"
											name="studentMotherTongue" placeholder="Mother Tongue" />
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
											value="${s.studentLastYearscholarshipApplied }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Scholarship sanctioned:
											Yes/No</label> <input type="text" class="form-control" id="ss"
											name="studentScholarshipsanctioned"
											value="${s.studentScholarshipsanctioned }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">If Yes,Amount Rs.</label> <input
											type="text" class="form-control" id="yesamount"
											name="studentIfYesAmountRs"
											value="${s.studentIfYesAmountRs }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Previous school Name /
											Address</label> <input type="text" class="form-control" id="psna"
											name="studentPreviousschoolName"
											value="${s.studentPreviousschoolName }" />
									</div>
									<hr />
									<br> <br>
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
									<br> <br>
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
											name="fybpharmTotalMarks" value="${s.fybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/>
										<br> <input type="text" class="form-control"
											id="fybpharmoom" name="fybpharmOutOfMarks"
											value="${s.fybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA" /> <br> <input
											type="text" class="form-control" id="fybpharmper"
											name="fybpharmPercentage" value="${s.fybpharmPercentage }"
											readonly="true" />
									</div>
									<hr />
									<%-- <script>
										$("#fybpharmoom")
												.blur(
														function() {
															var obtainM = $(
																	"#fybpharmoom")
																	.val();
															var totalM = $(
																	"#fybpharmtm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#fybpharmper")
																	.val(n);

														});
									</script> --%>
									<div>
										<label for="form-field-8">S.Y. B.Pharm</label> <input
											type="text" class="form-control" id="sybpharmtm"
											name="sybpharmTotalMarks" value="${s.sybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/>
										<br> <input type="text" class="form-control"
											id="sybpharmoom" name="sybpharmOutOfMarks"
											value="${s.sybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="sybpharmper"
											name="sybpharmPercentage" value="${s.sybpharmPercentage }"
											readonly="true" />
									</div>
									<hr />
									<%-- <script>
										$("#sybpharmoom")
												.blur(
														function() {
															var obtainM = $(
																	"#sybpharmoom")
																	.val();
															var totalM = $(
																	"#sybpharmtm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#sybpharmper")
																	.val(n);

														});
									</script> --%>
									<div>
										<label for="form-field-8">T.Y. B.Pharm</label> <input
											type="text" class="form-control" id="tybpharmtm"
											name="tybpharmTotalMarks" value="${s.tybpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA"/>
										<br> <input type="text" class="form-control"
											id="tybpharmoom" name="tybpharmOutOfMarks"
											value="${s.tybpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="tybpharmper"
											name="tybpharmPercentage" value="${s.tybpharmPercentage }"
											readonly="true" />
									</div>
									<hr />
									<%-- <script>
										$("#tybpharmoom")
												.blur(
														function() {
															var obtainM = $(
																	"#tybpharmoom")
																	.val();
															var totalM = $(
																	"#tybpharmtm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#tybpharmper")
																	.val(n);

														});
									</script>
 --%>
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
									<div>
										<label for="form-field-8">Final B.Pharm</label> <input
											type="text" class="form-control" id="finbpharmtm"
											name="finbpharmTotalMarks" value="${s.finbpharmTotalMarks }" pattern="[0-9.]+" title="Please Enter Correct CGPA" />
										<br> <input type="text" class="form-control"
											id="finbpharmoom" name="finbpharmOutOfMarks"
											value="${s.finbpharmOutOfMarks }" pattern="[0-9.]+" title="Please Enter Correct SGPA"/> <br> <input
											type="text" class="form-control" id="finbpharmper"
											name="finbpharmPercentage" value="${s.finbpharmPercentage }"
											readonly="true" />
									</div>
									<hr />
									<%-- <script>
										$("#finbpharmoom")
												.blur(
														function() {
															var obtainM = $(
																	"#finbpharmoom")
																	.val();
															var totalM = $(
																	"#finbpharmtm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#finbpharmper")
																	.val(n);

														});
									</script> --%>
									<div>
										<label for="form-field-8">MHT-CET<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="hscPCMMarks" name="hscPCMMarks"
											value="${s.hscPCMMarks }" /> <br> <input type="text"
											class="form-control" id="hscpcb" name="hscPCBMarks"
											placeholder=" PCB" value="<%-- ${ } --%>"/> <br> <input
											type="text" class="form-control" id="hscpcmpcb"
											name="hscPCMPCBTotalMarks" placeholder=" PCMB"
											style="display: none;" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">HSC<span style="color: red;">*</span></label>
										<input type="text" class="form-control" id="hsctm"
											name="hscTotalMarks" value="${s.hscTotalMarks }" /> <br>
										<input type="text" class="form-control" id="hscoom"
											name="hscOutOfMarks" value="${s.hscOutOfMarks }" /> <br>
										<input type="text" class="form-control" id="hscper"
											name="hscpcbpcm" value="${s.hscpcbpcm }" readonly="true" />
									</div>
									<hr />
									<br>
									<br>
									<br>
									<script>
										$("#hscoom")
												.blur(
														function() {
															var obtainM = $(
																	"#hscoom")
																	.val();
															var totalM = $(
																	"#hsctm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#hscper").val(
																	n);

														});
									</script>
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
									<div>
										<label for="form-field-8">SSC<span style="color: red;">*</span></label>
										<input type="text" class="form-control" id="ssctm"
											name="sscTotalMarks" value="${s.sscTotalMarks }" /> <br>
										<input type="text" class="form-control" id="sscoom"
											name="sscOutOfMarks" value="${s.sscOutOfMarks }" /> <br>
										<input type="text" class="form-control" id="sscper"
											name="sscXIIRegNo" value="${s.sscXIIRegNo }" readonly="true" />
									</div>
									<script>
										$("#sscoom")
												.blur(
														function() {
															var obtainM = $(
																	"#sscoom")
																	.val();
															var totalM = $(
																	"#ssctm")
																	.val();

															var perM = (+obtainM / +totalM) * 100;
															var n = perM.toFixed(2);
															$("#sscper").val(
																	n);

														});
									</script>
									<hr />
									<div>
										<label for="form-field-8">Account Number</label> <input
											type="text" class="form-control" id="AccountNumber"
											name="accountNumber" value="${s.accountNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-select-1">Bank Name</label> <input
											type="text" class="form-control" id="bankName"
											name="bankName" value="${s.bankName }" />

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
											name="bankBranch" value="${s.bankBranch }" />

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
											class="form-control" id="IFSC Code" name="bankIFSCCode"
											value="${s.bankIFSCCode }" />
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
											name="fatherLastName" value="${s.fatherLastName }" /> <br>
										<input type="text" class="form-control" id="FfirstName"
											name="fatherFirstName" value="${s.fatherFirstName }" /><br>
										<input type="text" class="form-control" id="FmiddleName"
											name="fathermiddleName" value="${s.fathermiddleName }" />
									</div>
									<hr />
									<div style="display: none;">
										<label for="form-field-8">Permanent Address</label>
										<textarea class="form-control" id="FPermanentAddress"
											name="fatherPermananetAddress"
											value="${s.fatherPermananetAddress}"></textarea>
									</div>
									<div>
										<label for="form-field-8">Educational Qualification</label> <input
											type="text" class="form-control" id="Qualification"
											name="fatherEducationalQualification"
											value="${s.fatherEducationalQualification }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Occupation</label> <input
											type="text" class="form-control" id="Occupation"
											name="fatherOccupation" value="${s.fatherOccupation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Designation</label> <input
											type="text" class="form-control" id="designation"
											name="fatherDesignation" value="${s.fatherDesignation}" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Organization</label> <input
											type="text" class="form-control" id="organization"
											name="fatherOrganization" value="${s.fatherOrganization }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Annual Income</label> <input
											type="text" class="form-control" id="AlternateAnnualIncome"
											name="fatherMonthlyIncome" value="${s.fatherMonthlyIncome }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Contact Number<span
											style="color: red;">*</span></label> <input type="text"
											class="form-control" id="fContactNumber"
											name="fatherContactNumber" 
											maxlength="10" title="Please Enter Correct Mobile Number" value="${s.fatherContactNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Email Address</label> <input type="email"
											class="form-control" id="ParentEmail" name="fatherEmail"
											value="${s.fatherEmail }" />
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
											name="motherLastName" value="${s.motherLastName }" /> <br>
										<input type="text" class="form-control" id="mfirstName"
											name="motherFirstName" value="${s.motherFirstName }" /><br>
										<input type="text" class="form-control" id="mmiddleName"
											name="mothermiddleName" value="${s.mothermiddleName }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Educational Qualification</label> <input
											type="text" class="form-control" id="Qualification"
											name="motherEducationalQualification"
											value="${s.motherEducationalQualification }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Occupation</label> <input
											type="text" class="form-control" id="Occupation"
											name="motherOccupation" value="${s.motherOccupation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Designation</label> <input
											type="text" class="form-control" id="desig"
											name="motherDesignation" value="${s.motherDesignation }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Organization</label> <input
											type="text" class="form-control" id="organ"
											name="motherOrganization" value="${s.motherOrganization }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Annual Income</label> <input
											type="text" class="form-control" id="AlternateAnnualIncome"
											name="motherMonthlyIncome" value="${s.motherMonthlyIncome }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Contact Number</label> <input
											type="text" class="form-control" id="fContactNumber"
											name="motherContactNumber"
											maxlength="10" title="Please Enter Correct Mobile Number" value="${s.motherContactNumber }" />
									</div>
									<hr />
									<div>
										<label for="form-field-8">Email Address</label> <input
											type="text" class="form-control" id="ParentEmail"
											name="motherEmail" value="${s.motherEmail }" />
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
									<div class="form-actions center">

										<button type="button" id="ThPage"
											class="btn btn-sm btn-success">
											<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110">
												Previous</i>
										</button>
										<button type="submit" class="btn btn-sm btn-success"
											name="UpdateStudDetails" id="UpdateStudDetails">
											Update Student Details <i
												class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>
									</div>
									<hr />
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>