<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
$(document).ready(function(){
	
	 $('#StudentName').autocomplete({
	   
		source : '${pageContext.request.contextPath}/searchStudentNew.html'
	});
	 
	 $("#StudentName").change(function(data){
		 var studentName=$("#StudentName").val();
		// alert(studentName);
		 
		 $.getJSON('getStudentDetailsForAnyConditionLC.html',{studentName:studentName}).done(function(data){
			// alert("fdata");
			 $("#studentId").val(data[0].admissionRegId);
			// alert(data[0].admissionRegId);
			 $("#acadimicYear").val(data[0].acadamicYear);
			 $("#studentName").val(data[0].studentnamessc);
			 $("#studentGender").val(data[0].studentGender);
			 $("#dateOfBirth").val(data[0].studentDateOfBirth);
			 $("#studentPlaceOfBirth").val(data[0].studentPlaceOfBirth);
			 $("#studentNationality").val(data[0].studentNationality);
			 $("#studentCategory").val(data[0].studentCategory);
			 $("#studentCast").val(data[0].studentCast);
			 $("#dateOfAdmission").val(data[0].admissionDate);
			 $("#standard").val(data[0].standard);
			 $("#studentReligion").val(data[0].studentReligion);
		 });
	 });
	 
});
</script>
</head>
<body>
<div class="page-content">
		<div class="page-header center">
			<h1><b>Download Student Leaving Certificate Any Condition</b></h1>
			<h3 style="color:red; ">${statusOfStudent }</h3>
			<!-- 	<center><font color="red">If you Request For The <b>Leaving Certificate</b>  And Request Is <b>Approved</b>. Then You <b>Are Not Eligible</b> To Handle This Account AnyMore And You Will <b>Unable</b> To Take All Any College Facility...</font></center> -->
		</div>
		<form action="issueStudentLCAnyCondition.html" method="post">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Name<span style="color:red;">*</span></th>
										<!-- 	<th>L.C.No</th> -->
										<th>Academic Year</th>
										<!-- 	<th>Date</th> -->

									</tr>
								</thead>
								<tbody>
									<tr>
																				
										<td><input type="text" name="StudentName" id="StudentName" placeholder="Student Name"
											required></td>
										<%-- <td><input type="text" name="" id="" 
										readonly="true"></td> --%>

										<td><input type="text" placeholder="Acadimic year" id="acadimicYear" readonly="true" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
							<thead>	<tr>
									<th>Student Name</th>
									<th>Gender</th>
									<th>Date of Birth</th>
									<th>Place of Birth</th>

								</tr></thead>
								<tbody>
									<tr>
										<td><input type="text" placeholder="Student Name" id="studentName" readonly="true"></td>
										<td><input type="text" placeholder="Student Gender" id="studentGender" readonly="true"></td>
										<td><input type="text" placeholder="Date Of Birth" id="dateOfBirth" readonly="true"></td>
										<td><input type="text" placeholder="Place Of Birth" id="studentPlaceOfBirth" readonly="true" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead><tr>
									<th>Nationality</th>
									<th>Category</th>
									<th>Cast</th>
									<!-- <th>Sub Caste</th> -->
								</tr></thead>
								<tbody>
									<tr>
										<td><input type="text" placeholder="Nationality" id="studentNationality" readonly="true" /></td>
										<td><input type="text" placeholder="Category" id="studentCategory" readonly="true" /></td>
										<td><input type="text" placeholder="Cast" id="studentCast" readonly="true" /></td>
										<!-- <td><input type="text" name="" id="" readonly="true" /></td> -->
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead><tr>
									<th>Date Of Admission</th>
									<th>Standard</th>
									<th>Religion</th>
									<!-- <th>Mother Tongue</th> -->
								</tr></thead>
								<tbody>
									<tr>
										<td><input type="text" placeholder="Admission Date" id="dateOfAdmission" readonly="true"></td>
										<td><input type="text" placeholder="Standard" id="standard" readonly="true"></td>
										<td><input type="text" placeholder="Religion" id="studentReligion" readonly="true" /></td>
										<!-- <td><input type="text" name="" id="" readonly="true" /></td> -->

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr>
			<input type="hidden" id="studentId" name="studentId">
			<div class="center">
				<button id="sendReq" name="DownloadCertificate" type="submit"
					class="btn btn-sm btn-purple">Get Leaving Certificate</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>