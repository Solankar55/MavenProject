<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Approved Student Details</title>
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
			<h1><b>Approved Student List</b></h1><br>
			<h6 style="color: red;">${StudentUpdateMsg }</h6>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">Approved Student List</div>
						<table id="dynamic-table" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Standard</th>
									<th>Stream</th>
									<th>Branch</th>
									<th>Mobile no</th>
									<!-- <th>Division</th> -->
									<th>Status</th>
									<!-- <th>Approve/Cancel</th> -->
								</tr>
							</thead>

							<tbody id="StudentData">
								<c:forEach var="v" items="${ApprovedAddmissionList}">

									<tr onclick="document.getElementById('Update').style.display='block'">
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.standard}"></c:out></td>
										<td><c:out value="${v.streamName}"></c:out></td>
										<td><c:out value="${v.branchName }"></c:out></td>
										<td><c:out value="${v.studentContactNumber }"></c:out></td>
										<td><c:out value="${v.status }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentGender }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentDateOfBirth }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentNationality }"></c:out></td>

										<td style="display: none;"><c:out
												value="${v.studentReligion }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCategory }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCast }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.fatherFirstName}"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.fatherPermananetAddress }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.fatherOccupation }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.fatherMonthlyIncome }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.fatherEmail }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentParentContactNumber }"></c:out></td>

										<td style="display: none;"><c:out
												value="${v.aadharCardNumber }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.acadamicYear }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.accountNumber }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.admissionDate }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.bankBranch }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.bankIFSCCode }"></c:out></td>
										<td style="display: none;"><c:out value="${v.bankName }"></c:out></td>
										<td style="display: none">
											<c:out value="${v.streamId }"></c:out></td>
										<td style="display:none">
											<c:out value="${v.standardId }"></c:out></td>
										<td style="display:none">
											<c:out value="${v.divisionId }"></c:out></td>
										<td style="display:none ">
											<c:out value="${v.branchId }"></c:out></td>
										<td style="display: none;">
											<c:out value="${v.studentFirstName }"></c:out></td>
										<td style="display: none;">
											<c:out value="${v.studentLastName }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.fathermiddleName }"></c:out></td>
										<td style="display: none;">
											<c:out value="${v.studentSubCast }"></c:out></td>
										<td style="display: none;">
											<c:out value="${v.studentMotherTongue }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.studentMotherName }"></c:out></td>
										<td style="display: none;">
											<c:out value="${v.studentPlaceOfBirth }"></c:out></td>	
											
										<td style="display: none;">
											<c:out value="${v.studentResidentialAddress }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.studentPermanenetAddress }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.studentPinCode }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.studentEmail }"></c:out></td>	
										<td style="display: none;">
											<c:out value="${v.acadamicYearId }"></c:out></td>															
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<div id="Update" class="modal">

		<form class="modal-content animate" action="UpdateApprovedStudentDetails.html"
			method="post" commandName="">
			<div class="imgcontainer">
				<span onclick="document.getElementById('Update').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<table class="">
					<tr>
						<td><label><b>Student Id :</b></label></td>
						<td><input type="text" name="admissionId" id="admissionId"
							readonly="true" class="col-sm-9"></td>

						<td><label><b>Student Name :</b></label></td>
						<td><input type="text" name="StudFirst" id="StudFirst" class="col-sm-9"
							readonly="true"></td>
							<!-- <td><input type="text" name="StudLast" id="StudLast" class="col-sm-9"
							readonly="true"></td> -->
						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="contactNumber" class="col-sm-9"
							id="contactNumber" readonly="true" ></td>

					</tr>

					<tr>

						<td><label><b>Gender :</b></label></td>
						<td><input type="text" name="studentGender"
							id="studentGender" readonly="true" class="col-sm-9"></td>

						<td><label><b>DOB :</b></label></td>
						<td><input type="text" name="dateOfBirth" id="dateOfBirth" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Nationality :</b></label></td>
						<td><input type="text" name="nationality" id="nationality" class="col-sm-9"
							readonly="true"></td>
					</tr>

					<tr>
						<td><label><b>Student Religion :</b></label></td>
						<td><input type="text" name="religion" id="religion" class="col-sm-9" readonly="true" >
						</td>

						<td><label><b>Student Category :</b></label></td>
						<td><input type="text" name="studentCategory" id="studentCategory" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Student Cast :</b></label></td>
						<td><input type="text" name="studentCast" id="studentCast" class="col-sm-9"
							readonly="true"></td>
					</tr>
					<!-- <tr>

						<td><label><b>Father Name:</b></label></td>
						<td><input type="text" name="fatherName" id="fatherName" class="col-sm-9"
							readonly="true"></td>

						<td style="display: none;"><label><b>Father Address :</b></label></td>
						<td><input type="hidden" name="fatherAddress" id="fatherAddress" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Occupation :</b></label></td>
						<td><input type="text" name="occupation" id="occupation" class="col-sm-9"
							readonly="true"></td>
					</tr>
					<tr>

						<td><label><b>Father Income :</b></label></td>
						<td><input type="text" name="fatherIncome" id="fatherIncome" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Father Email :</b></label></td>
						<td><input type="text" name="fatherEmail" id="fatherEmail" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="fathercontact" id="fathercontact" class="col-sm-9"
							readonly="true"></td>
					</tr> -->
					<tr>

						<td><label><b>Stream :</b></label></td>
						<td><input type="text" name="studentStream" id="studentStream" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Branch :</b></label></td>
						<td><input type="text" name="studentBranch" id="studentBranch" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Standard :</b></label></td>
						<td><input type="text" name="studentStandard" id="studentStandard" class="col-sm-9"
							readonly="true"></td>
					</tr>
					<tr style="display: none;">

						<td><label><b>Stream ID :</b></label></td>
						<td><input type="text" name="studentStrID" id="studentStrID" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Branch ID:</b></label></td>
						<td><input type="text" name="studentBrID" id="studentBrID" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Standard ID :</b></label></td>
						<td><input type="text" name="studentStandID" id="studentStandID" class="col-sm-9"
							readonly="true"></td>
					</tr>
					<tr style="display: none;">
					<td><input type="text" name="AccoutNumbers" id="AccoutNumbers"></td>
					<td><input type="text" name="FatherMidle" id="FatherMidle"></td>
					<td><input type="text" name="SubCastStud" id="SubCastStud"></td>
					<td><input type="text" name="studMotherTogu" id="studMotherTogu"></td>
					<td><input type="text" name="studMotherName" id="studMotherName"></td>
					<td><input type="text" name="PlaceDOB" id="PlaceDOB"></td>
					<td><input type="text" name="ResAddress" id="ResAddress"></td>
					<td><input type="text" name="PerAddress" id="PerAddress"></td>
					<td><input type="text" name="PinCode" id="PinCode"></td>
					<td><input type="text" name="studEmail" id="studEmail"></td>
					<td><input type="text" name="AdharNumber" id="AdharNumber"></td>
					<td><input type="text" name="IFScCode" id="IFScCode"></td>
					<td><input type="text" name="BankNamee" id="BankNamee"></td>
					<td><input type="text" name="BranchNamme" id="BranchNamme"></td>
					<td><input type="text" name="AcaYearID" id="AcaYearID"></td>
					</tr>
					
				</table>
				<br>

				<center>
					<button type="submit" name="UpdateInfo"
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Update Student Information</button>
				</center>
			</div>

			<!-- <div class="container" style="background-color:#f1f1f1">
      
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div> -->
		</form>
	</div>

	<script>
		// Get the modal
		$("#StudentData tr").click(function() {

			//alert("Hoo");

			$("#admissionId").val($(this).find("td").eq(0).text());
			$("#studentName").val($(this).find("td").eq(1).text());
			
			$("#studentStandard").val($(this).find("td").eq(2).text());
			$("#studentBranch").val($(this).find("td").eq(3).text());
			$("#studentStream").val($(this).find("td").eq(4).text());

			$("#contactNumber").val($(this).find("td").eq(5).text());
			$("#studentGender").val($(this).find("td").eq(7).text());
			$("#dateOfBirth").val($(this).find("td").eq(8).text());
			
			$("#nationality").val($(this).find("td").eq(9).text());
			$("#religion").val($(this).find("td").eq(10).text());
			$("#studentCategory").val($(this).find("td").eq(11).text());
			$("#studentCast").val($(this).find("td").eq(12).text());

			$("#fatherName").val($(this).find("td").eq(13).text());
			$("#fatherAddress").val($(this).find("td").eq(14).text());
			$("#occupation").val($(this).find("td").eq(15).text());
			
			$("#fatherIncome").val($(this).find("td").eq(16).text());
			$("#fatherEmail").val($(this).find("td").eq(17).text());
			$("#fathercontact").val($(this).find("td").eq(18).text());
		
			$("#AdharNumber").val($.trim($(this).find("td").eq(19).text()));
			$("#AccoutNumbers").val($.trim($(this).find("td").eq(21).text()));
			$("#BranchNamme").val($.trim($(this).find("td").eq(23).text()));
			$("#IFScCode").val($.trim($(this).find("td").eq(24).text()));
			$("#BankNamee").val($.trim($(this).find("td").eq(25).text()));
			
			$("#studentStrID").val(parseInt($(this).find("td").eq(26).text())); 
			$("#studentStandID").val(parseInt($(this).find("td").eq(27).text()));
			$("#studentBrID").val(parseInt($(this).find("td").eq(29).text()));
			
			$("#StudFirst").val($.trim($(this).find("td").eq(1).text()));
			$("#StudLast").val($.trim($(this).find("td").eq(31).text()));
			$("#FatherMidle").val($.trim($(this).find("td").eq(32).text()));
			
			$("#SubCastStud").val($.trim($(this).find("td").eq(33).text()));
			$("#studMotherTogu").val($.trim($(this).find("td").eq(34).text()));
			$("#studMotherName").val($.trim($(this).find("td").eq(35).text()));
			$("#PlaceDOB").val($.trim($(this).find("td").eq(36).text()));
			$("#ResAddress").val($.trim($(this).find("td").eq(37).text()));
			$("#PerAddress").val($.trim($(this).find("td").eq(38).text()));
			$("#PinCode").val($.trim($(this).find("td").eq(39).text()));
			$("#studEmail").val($.trim($(this).find("td").eq(40).text()));
			$("#AcaYearID").val($.trim($(this).find("td").eq(41).text()));
			/* alert($(this).find("td").eq(30).text());
			alert($(this).find("td").eq(31).text()); */
			
					
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
</div>
<br><br><br>
<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>