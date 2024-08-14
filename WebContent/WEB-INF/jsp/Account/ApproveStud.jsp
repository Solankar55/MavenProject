<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Student Admission Page</title>
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

<%-- 
<script type="text/javascript">
	$(document).ready(function() {
		$("#SearchStudent").blur(function() {
			alert("sss");
			var StudentName=$("#SearchStudent").val();
			$("#StudentTable").empty();
			$.getJSON('GetStudentListJSONAccount.html',{StudentName:StudentName}).done(function(data){
				alert("Student Data Come");
				$("#StudentTable").append("<tr><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName + data[i].studentLastName+ "</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].studentContactNumber+"</td></tr>");
			});
		});
	});
</script>
 --%>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Approve Student Admission</b></h1>
			</center>
		</div>
		<!-- <div class="row">
			<div class="col-xs-12">
				<label class="col-xs-2">
				<b>Search Student By Name:</b>
				</label>
				<div class="col-xs-6">
					<input type="text" id="SearchStudent" class="input-xlarge">
				</div>
			</div>
		</div>
		<hr /> -->
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">Approve/Cancel Student List</div>
						<table id="dynamic-table" class="table  table-bordered table-hover">
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
									<th>Approve/Cancel</th>
								</tr>
							</thead>

							<tbody id="StudentTable">
								<c:forEach var="v" items="${StudentAddmissionList}">

									<tr>
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
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
												value="${v.fatherFirstName} ${v.fatherLastName }"></c:out></td>
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



										<td>
											<div class="hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-success"
													onclick="document.getElementById('id01').style.display='block'"
													style="width: auto;">
													Approve <i class="ace-icon fa fa-check bigger-120"></i>
												</button>
											</div>
											<div class="hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-danger"
													onclick="document.getElementById('id02').style.display='block'"
													style="width: auto;">
													Cancel <i class="ace-icon fa fa-trash-o bigger-120"></i>
												</button>
											</div>

											<div class="hidden-md hidden-lg">
												<div class="inline pos-rel">
													<button class="btn btn-minier btn-primary dropdown-toggle"
														data-toggle="dropdown" data-position="auto">
														<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
													</button>

													<ul
														class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
														<li><button class="tooltip-success"
																onclick="document.getElementById('id01').style.display='block'"
																data-rel="tooltip" title="" id="Approve">
																Approve <span class="green"> <i
																	class="ace-icon fa fa-check bigger-120"></i>
																</span>
															</button></li>

														<li><button class="tooltip-error"
																onclick="document.getElementById('id02').style.display='block'"
																data-rel="tooltip" title="">
																Cancel <span class="red"> <i
																	class="ace-icon fa fa-trash-o bigger-120"></i>
																</span>
															</button></li>
													</ul>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<!-- /.row -->

	</div>

	<div id="id01" class="modal">

		<s:form class="modal-content animate" action="TakeAddmission.html"
			method="get" commandName="TakeAddmission">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<table class="">
					<tr>
						<td><label><b>Student Id :</b></label></td>
						<td><input type="text" name="admissionId" id="admissionId"
							readonly="true"></td>

						<td><label><b>Student Name :</b></label></td>
						<td><input type="text" name="studentName" id="studentName"
							readonly="true"></td>
						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="contactNumber"
							id="contactNumber" readonly="true"></td>

					</tr>

					<tr>

						<td><label><b>Gender :</b></label></td>
						<td><input type="text" name="studentGender"
							id="studentGender" readonly="true"></td>

						<td><label><b>DOB :</b></label></td>
						<td><input type="text" name="dateOfBirth" id="dateOfBirth"
							readonly="true"></td>

						<td><label><b>Nationality :</b></label></td>
						<td><input type="text" name="nationality" id="nationality"
							readonly="true"></td>
					</tr>

					<tr>
						<td><label><b>Student Religion :</b></label></td>
						<td><input type="text" name="" id="religion" readonly="true">
						</td>

						<td><label><b>Student Category :</b></label></td>
						<td><input type="text" name="" id="studentCategory"
							readonly="true"></td>

						<td><label><b>Student Cast :</b></label></td>
						<td><input type="text" name="" id="studentCast"
							readonly="true"></td>
					</tr>
					<!-- <tr>

						<td><label><b>Father Name:</b></label></td>
						<td><input type="text" name="" id="fatherName"
							readonly="true"></td>

						<td><label><b>Father Address :</b></label></td>
						<td><input type="text" name="" id="fatherAddress"
							readonly="true"></td>

						<td><label><b>Occupation :</b></label></td>
						<td><input type="text" name="" id="occupation"
							readonly="true"></td>
					</tr>
					<tr>

						<td><label><b>Father Income :</b></label></td>
						<td><input type="text" name="" id="fatherIncome"
							readonly="true"></td>

						<td><label><b>Father Email :</b></label></td>
						<td><input type="text" name="" id="fatherEmail"
							readonly="true"></td>

						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="" id="fathercontact"
							readonly="true"></td>
					</tr> -->
					<tr>

						<td><label><b>Stream :</b></label></td>
						<td><input type="text" name="" id="studentStream"
							readonly="true"></td>

						<td><label><b>Branch :</b></label></td>
						<td><input type="text" name="" id="studentBranch"
							readonly="true"></td>

						<td><label><b>Standard :</b></label></td>
						<td><input type="text" name="" id="studentStandard"
							readonly="true"></td>
					</tr>
				</table>
				<br>

				<center>
					<button type="submit"
						onclick="document.getElementById('id01').style.display='none'"
						class="btn btn-xs btn-success">Approve</button>
				</center>
			</div>

			<!-- <div class="container" style="background-color:#f1f1f1">
      
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div> -->
		</s:form>
	</div>

	<div id="id02" class="modal">

		<s:form class="modal-content animate" action="CancelStudAddmission.html"
			method="get" commandName="CancelStudAddmission">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			<table class="">
					<tr>
						<td><label><b>Student Id :</b></label></td>
						<td><input type="text" name="admissionId1" id="admissionId1"
							readonly="true"></td>

						<td><label><b>Student Name :</b></label></td>
						<td><input type="text" name="studentName1" id="studentName1"
							readonly="true"></td>
						<td><label><b>Contact Number :</b></label></td>
						<td><input type="text" name="contactNumber"
							id="contactNumber1" readonly="true"></td>

					</tr>

					<tr>

						<td><label><b>Gender :</b></label></td>
						<td><input type="text" name="studentGender"
							id="studentGender1" readonly="true"></td>

						<td><label><b>DOB :</b></label></td>
						<td><input type="text" name="dateOfBirth" id="dateOfBirth1"
							readonly="true"></td>

						<td><label><b>Nationality :</b></label></td>
						<td><input type="text" name="nationality" id="nationality1"
							readonly="true"></td>
					</tr>

					<tr>
						<td><label><b>Student Religion :</b></label></td>
						<td><input type="text" name="" id="religion1" readonly="true">
						</td>

						<td><label><b>Student Category :</b></label></td>
						<td><input type="text" name="" id="studentCategory1"
							readonly="true"></td>

						<td><label><b>Student Cast :</b></label></td>
						<td><input type="text" name="" id="studentCast1"
							readonly="true"></td>
					</tr>
					<tr>

						<td><label><b>Stream :</b></label></td>
						<td><input type="text" name="" id="studentStream1"
							readonly="true"></td>

						<td><label><b>Branch :</b></label></td>
						<td><input type="text" name="" id="studentBranch1"
							readonly="true"></td>

						<td><label><b>Standard :</b></label></td>
						<td><input type="text" name="" id="studentStandard1"
							readonly="true"></td>
					</tr>
				</table>
				<br>

				<center>
					<button type="submit"
						onclick="document.getElementById('id02').style.display='none'"
						class="btn btn-xs btn-success">Cancel</button>
				</center>

			</div>
		</s:form>
		
	</div>
<br><br><br>
	<script>
		// Get the modal
		$("#StudentTable tr").click(function() {

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

		});

		var modal = document.getElementById('id01');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";

			}
		}
		$("#StudentTable tr").click(function() {

			//alert("BHoo");

			$("#admissionId1").val($(this).find("td").eq(0).text());
			$("#studentName1").val($(this).find("td").eq(1).text());
			$("#studentStandard1").val($(this).find("td").eq(2).text());
			$("#studentBranch1").val($(this).find("td").eq(3).text());
			$("#studentStream1").val($(this).find("td").eq(4).text());

			$("#contactNumber1").val($(this).find("td").eq(5).text());
			$("#studentGender1").val($(this).find("td").eq(7).text());
			$("#dateOfBirth1").val($(this).find("td").eq(8).text());
			
			$("#nationality1").val($(this).find("td").eq(9).text());
			$("#religion1").val($(this).find("td").eq(10).text());
			$("#studentCategory1").val($(this).find("td").eq(11).text());
			$("#studentCast1").val($(this).find("td").eq(12).text());

		});	
			
		var modal = document.getElementById('id02');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";

			}
		}
	</script>
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
				                null, null, null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>