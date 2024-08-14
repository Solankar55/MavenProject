<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$("#document").ready(function(){
	$("#StudentID").blur(function() {
		//alert("kasdg");
		var registrationID = $("#StudentID").val();
		//alert(registrationID);
		
		$.getJSON('getstudentLCDetails.html',{registrationID : registrationID}).done(function(data) {
		//alert("In Data");
		 if(data.length==0)
		{
		alert("Student LC Request Is Not Approved/Student LC Is Already Downloaded.");
		}
	else
		{
		$("#StudentName").val(data[0].studentFirstName+' '+ data[0].studentLastName);
		$("#DateOfBirth").val(data[0].studentDateOfBirth);
		$("#studentGender").val(data[0].studentGender);
		$("#AcadimicYear").val(data[0].acadamicYear);
		$("#studentPlaceOfBirth").val(data[0].studentPlaceOfBirth);
		
		$("#studentNationality").val(data[0].studentNationality);
		$("#studentCategory").val(data[0].studentCategory);
		$("#studentCast").val(data[0].studentCast);
		$("#admissionDate").val(data[0].admissionDate);
		$("#studentReligion").val(data[0].studentReligion);
		/* $("#").val(data[0].);  */
		$("#Standard").val(data[0].standard);
		$("#branch").val(data[0].branchName);
		$("#stream").val(data[0].streamName); 
		$("#studentContactNumber").val(data[0].studentContactNumber);
		$("#studentPermanenetAddress").val(data[0].studentPermanenetAddress);
		}
		}); 
	});
});
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1><b>Download Student Leaving Certificate</b></h1>
			<!-- 	<center><font color="red">If you Request For The <b>Leaving Certificate</b>  And Request Is <b>Approved</b>. Then You <b>Are Not Eligible</b> To Handle This Account AnyMore And You Will <b>Unable</b> To Take All Any College Facility...</font></center> -->
		</div>
		<form action="DownloadLCAC.html" method="post" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Registration Id<span style="color:red;">*</span></th>
										<!-- 	<th>L.C.No</th> -->
										<th>Academic Year</th>
										<!-- 	<th>Date</th> -->

									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="StudentID" id="StudentID"
											required></td>
										<%-- <td><input type="text" name="" id="" 
										readonly="true"></td> --%>

										<td><input type="text" placeholder="Acadimic year" id="AcadimicYear" readonly="true" /></td>
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
										<td><input type="text" placeholder="Student Name" id="StudentName" readonly="true"></td>
										<td><input type="text" placeholder="Student Gender" id="studentGender" readonly="true"></td>
										<td><input type="text" placeholder="Date Of Birth" id="DateOfBirth" readonly="true"></td>
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
										<td><input type="text" placeholder="Admission Date" id="admissionDate" readonly="true"></td>
										<td><input type="text" placeholder="Standard" id="Standard" readonly="true"></td>
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
			<div class="center">
				<button id="sendReq" name="DownloadCertificate" type="submit"
					class="btn btn-sm btn-purple">Download Leaving Certificate</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>