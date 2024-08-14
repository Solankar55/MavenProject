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
		
		$.getJSON('getstudentIDCardDetails.html',{registrationID : registrationID}).done(function(data) {
		//alert("In Data");
		 if(data.length==0)
		{
		alert("Student ID Card Request Is Not Approved/Student ID Card Is Already Downloaded.");
		}
	else
		{
		$("#StudentName").val(data[0].studentFirstName+' '+ data[0].studentLastName);
		$("#DateOfBirth").val(data[0].studentDateOfBirth);
		$("#AcadimicYear").val(data[0].acadamicYear);
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
			<h1><b>Download Student ID Card</b></h1>
			<br>
		</div>
		<form action="DownloadStudentIDCardAC.html" method="post" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
							<thead>
								<tr>
									<th>Student Roll Number<span style="color:red;">*</span></th>
									<th>Student Name</th>
									<th>Date of Birth</th>
									<th>Contact Number</th>
									<th>Address</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="StudentID" id="StudentID"
											required></td>
										<td><input type="text" placeholder="Student Name" id="StudentName" readonly="true"></td>
										<td><input type="text" placeholder="Date Of Birth" id="DateOfBirth" readonly="true"></td>
										<td><input type="text" placeholder="Contact Number" id="studentContactNumber" readonly="true" /></td>
										<td><input type="text" placeholder="Permanent Address" id="studentPermanenetAddress" readonly="true" /></td>
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
							<table id="simple-table" class="table">
							<thead>
								<tr>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" placeholder="Acadimic Year" id="AcadimicYear" readonly="true"></td>
										<td><input type="text" placeholder="Stream" id="stream" readonly="true"></td>
										<td><input type="text" placeholder="Branch" id="branch" readonly="true"></td>
										<td><input type="text" placeholder="Standard" id="Standard" readonly="true"></td>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr>
			<div class="center">
				<button id="sendReq" name="DownloadIDCard" type="submit"
					class="btn btn-sm btn-purple">Download ID Card</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>