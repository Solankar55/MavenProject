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
		
		$.getJSON('getstudentBonafideDetails.html',{registrationID : registrationID}).done(function(data) {
		//alert("In Data");
		 if(data.length==0)
		{
		alert("Student Bonafide Request Is Not Approved/Student Bonafide Is Already Downloaded.");
		}
	else
		{
		$("#StudentName").val(data[0].studentFirstName+' '+ data[0].studentLastName);
		$("#DateOfBirth").val(data[0].studentDateOfBirth);
		$("#AcadimicYear").val(data[0].acadamicYear);
		$("#Standard").val(data[0].standard);
		$("#branch").val(data[0].branchName);
		$("#stream").val(data[0].streamName); 
		}
		}); 
	});
});
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1>
				<b>Download Student Bonafide</b>
			</h1>
			<!-- 	<center><font color="red">Dear sir This is Most important Thing Please Notice that you can only Request for <b>Bonafide</b> in <b>one</b> Year at <b>two times only</b>.</font></center> -->
		</div>
		<form action="DwonloadStudentBonafideAC.html" method="post"
			target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Id<span style="color: red;">*</span></th>
										<th>Student Name</th>
										<th>Student Stream</th>
										<th>Student Branch</th>
										<th>Student Standard</th>
										<!-- <th></th> -->
										<!-- <th>Academic Year</th>
							<th>Birth Date</th> -->
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="StudentID" id="StudentID"
											placeholder="Student ID" required /></td>
										<td><input type="text" name="" id="StudentName"
											placeholder="Student Name" readonly="true"></td>
										<td><input type="text" name="" id="stream"
											placeholder="Student Stream" readonly="true"></td>
										<td><input type="text" name="" id="branch"
											placeholder="Student Branch" readonly="true"></td>
										<td><input type="text" name="" id="standard"
											placeholder="Student Standard" readonly="true"></td>
										<!-- <td></td> -->

										<%-- <td><input type="text" name="" id="" value="${v.acadamicYear }"
										placeholder="Academic Year" readonly="true" /></td>
						<td><input type="text"name="" id="" value="${v.studentDateOfBirth }"
							placeholder="Student Birth Date" readonly="true"/></td>
						 --%>
									</tr>
								</tbody>

							</table>
							<table id="" class="table">
								<thead>
									<tr>
										<th>Academic Year</th>
										<th>Birth Date</th>
										<!-- <th></th> -->
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="" id="AcadimicYear"
											placeholder="Academic Year" readonly="true" /></td>
										<td><input type="text" name="" id="DateOfBirth"
											placeholder="Student Birth Date" readonly="true" /></td>
										<!-- <td></td>	 -->
									</tr>
								</tbody>

							</table>
							<hr />
							<div class="center">

								<button id="sendReq" type="submit" name="DownloadB"
									class="btn btn-sm btn-purple">Download Bonafide</button>
							</div>
<hr/>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<%-- </c:forEach> --%>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>