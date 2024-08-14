<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	color: blue;
	width: 200px;
	height: 40px;
	
}
</style>
<style type="text/css">

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.container {
	padding: 16px;
}

/* span.psw {
    float: right;
    padding-top: 16px;
} */

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}
}

/* * Change styles for span and cancel button on extra small screens 
@media screen {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
} */
</style>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1>
				<b>Edit Or Delete Staff Information</b>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Staff Id</th>
									<th>Staff Name</th>
									<th>Qualification</th>
									<th>Satff Department</th>
									<th>Staff Type</th>
									<th>Staff Barcode</th>
									<!-- <th>Division</th> -->
									<!-- <th>Status</th> -->
									<!-- <th>Approve/Cancel</th> -->
								</tr>
							</thead>

							<tbody id="StudentData">
								<c:forEach var="v" items="${StaffInfo}">

									<tr onclick="document.getElementById('Update').style.display='block'">
										<td><c:out value="${v.staffRegistrationId }"></c:out></td>
										<td><c:out value="${v.StaffName}"></c:out></td>
										<td><c:out value="${v.Qalification}"></c:out></td>
										<td><c:out value="${v.SatffDepartment}"></c:out></td>
										<td><c:out value="${v.StaffType }"></c:out></td>
										<td><c:out value="${v.barcode }"></c:out></td>
										
										<td style="display: none;"><c:out value="${v.MobileNumber }"></c:out></td>
										<td style="display: none;"><c:out value="${v.StaffAddress }"></c:out></td>
										<td style="display: none;"><c:out value="${v.StaffEmail }"></c:out></td>
										<td style="display: none;"><c:out value="${v.YearOfExperience }"></c:out></td>
										
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<script>
		// Get the modal
		$("#StudentData tr").click(function() {

			//alert("Hoo");

			$("#StaffId").val($(this).find("td").eq(0).text());
			$("#StaffName").val($(this).find("td").eq(1).text());
			
			$("#StaffQ").val($(this).find("td").eq(2).text());
			$("#StaffD").val($(this).find("td").eq(3).text());
			$("#StaffT").val($(this).find("td").eq(4).text());

			$("#Barcode").val($(this).find("td").eq(5).text());
			$("#StaffMb").val($(this).find("td").eq(6).text());
			$("#StaffAdd").val($(this).find("td").eq(7).text());
			
			$("#StaffEmail").val($(this).find("td").eq(8).text());
			$("#StaffExp").val($(this).find("td").eq(9).text());
		});

		var modal = document.getElementById('Update');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";

			}
		}
		
	</script>
	
	<div id="Update" class="modal">

		<form class="modal-content animate" action="updateStaffInformation.html"
			method="post" >
			<div class="imgcontainer">
				<span onclick="document.getElementById('Update').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<table class="">
					<tr>
						<td><label><b>Staff Id :</b></label></td>
						<td><input type="text" name="StaffId" id="StaffId"
							readonly="true" class="col-sm-9"></td>

						<td><label><b>Staff Name :</b></label></td>
						<td><input type="text" name="StaffName" id="StaffName" class="col-sm-9"
							></td>
							
						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="StaffMb" class="col-sm-9"
							id="StaffMb"></td>

					</tr>

					<tr>

						<td><label><b>Staff Email :</b></label></td>
						<td><input type="text" name="StaffEmail"
							id="StaffEmail" class="col-sm-9"></td>

						<td><label><b>Qualification :</b></label></td>
						<td><input type="text" name="StaffQ" id="StaffQ" class="col-sm-9"
							></td>

						<td><label><b>Department :</b></label></td>
						<td><input type="text" name="StaffD" id="StaffD" class="col-sm-9"
							></td>
					</tr>

					<tr>
						<td><label><b>Staff Type :</b></label></td>
						<td><input type="text" name="StaffT" id="StaffT" class="col-sm-9" readonly="true" >
						</td>

						<td><label><b>Staff Barcode :</b></label></td>
						<td><input type="text" name="Barcode" id="Barcode" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Staff Address :</b></label></td>
						<td><input type="text" name="StaffAdd" id="StaffAdd" class="col-sm-9"
							></td>
					</tr>
					<tr>

						<td><label><b>Year Of Experience:</b></label></td>
						<td><input type="text" name="StaffExp" id="StaffExp" class="col-sm-9"
							></td>

						
					</tr>
					
				</table>
				<br>

			
					<button type="submit" name="UpdateInfo"
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Update Staff Information</button>
				
				
					<button type="submit" name="DeleteInfo"
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Delete Staff Information</button>
				
			</div>

			<!-- <div class="container" style="background-color:#f1f1f1">
      
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div> -->
		</form>
	</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>