<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Student LC</title>
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


<script type="text/javascript">
	$(document).ready(function() {
		$("#Approve").click(function() {
			//alert("sss");

		});
	});
</script>

</head>
<body>
<div class="page-content">
		<div class="page-header center">
			<h1><b>Approve Student LC</b></h1><br>
			<h4 style="color: red;">${LCMSG}</h4>
			<h3 style="color: red;">${approvMessage }</h3>
		</div>
	<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					<div class="table-header"> Student List</div>
						<table id="dynamic-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Gender</th>
									<th>Date of Birth</th>
									<th>Nationality</th>
									<th>Academic Year</th>
									<th>Approve/Cancel</th>
								</tr>
							</thead>

							<tbody id="ledgerTable">
								<c:forEach var="v" items="${StudLeavingRequestInfo}">

									<tr>
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.studentGender}"></c:out></td>
										<td><c:out value="${v.studentDateOfBirth}"></c:out></td>
										<td><c:out value="${v.studentNationality }"></c:out></td>
										<td><c:out value="${v.acadamicYear }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.streamName }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.standard }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentSubCast }"></c:out></td>

										<td style="display: none;"><c:out
												value="${v.studentReligion }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCategory }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCast }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentPlaceOfBirth }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentMotherTongue }"></c:out></td>
										
										<!-- Student Details -->
											<td style="display: none;"><c:out
												value="${v.acadamicYearId }"></c:out></td>
											<td style="display: none;"><c:out
												value="${v.standardId }"></c:out></td>
											<td style="display: none;"><c:out
												value="${v.streamId }"></c:out></td>
											<td style="display: none;"><c:out
												value="${v.branchId }"></c:out></td>	
											
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
															data-rel="tooltip" title="" id="Approve">Approve <span
																class="green"> <i
																	class="ace-icon fa fa-check bigger-120"></i>
															</span>
														</button></li>

														<li><button class="tooltip-error"
														onclick="document.getElementById('id02').style.display='block'"
															data-rel="tooltip" title="">Cancel <span class="red">
																	<i class="ace-icon fa fa-trash-o bigger-120"></i>
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

		<s:form class="modal-content animate" action="TakeLeavingCertificate.html"
			method="post" commandName="">
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
						<td><label><b>Gender :</b></label></td>
						<td><input type="text" name="studentGender"
							id="studentGender" readonly="true"></td>

					</tr>

					<tr>

						<td><label><b>Date OF Birth :</b></label></td>
						<td><input type="text" name="dateOfBirth"
							id="dateOfBirth" readonly="true"></td>
						<td><label><b>Nationality :</b></label></td>
						<td><input type="text" name="nationality" id="nationality"
							readonly="true"></td>
						<td><label><b>Academic Year :</b></label></td>
						<td><input type="text" name="academicYear" id="academicYear"
							readonly="true"></td>

						
					</tr>
					<tr>

						<td><label><b>Stream :</b></label></td>
						<td><input type="text" name="studentStream" id="studentStream"
							readonly="true"></td>

						<td><label><b>Standard :</b></label></td>
						<td><input type="text" name="studentStandard" id="studentStandard"
							readonly="true"></td>

					<!-- 	<td><label><b>Student Sub cast :</b></label></td>
						<td><input type="text" name="studentSubCast" id="studentSubCast"
							readonly="true"></td> -->
							<td><label><b>Student Religion :</b></label></td>
						<td><input type="text" name="" id="religion" readonly="true">
						</td>
					</tr>
					<tr>
						

						<td><label><b>Student Category :</b></label></td>
						<td><input type="text" name="" id="studentCategory"
							readonly="true"></td>

						<td><label><b>Student Cast :</b></label></td>
						<td><input type="text" name="" id="studentCast"
							readonly="true"></td>
							
						<td><label><b>Birth Place :</b></label></td>
						<td><input type="text" name="studentPlaceOfBirth" id="studentPlaceOfBirth"
							readonly="true"></td>
					</tr>
					
					<!-- <tr>

						

						<td><label><b>Mother Tongue :</b></label></td>
						<td><input type="text" name="Mothertongue" id="Mothertongue"
							readonly="true"></td>

					</tr> -->
					<tr style="display:none;">
						<td><input type="text" name="yearID1" id="yearID1"
							></td>
						<td><input type="text" name="standardID1" id="standardID1"
							></td>
						<td><input type="text" name="streamID1" id="streamID1"
							></td>
						<td><input type="text" name="branchID1" id="branchID1"
							></td>			
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

	

	<script>
		// Get the modal
		$("#ledgerTable tr").click(function() {

			//alert("Hoo");

			$("#admissionId").val($(this).find("td").eq(0).text());
			$("#studentName").val($(this).find("td").eq(1).text());
			$("#studentGender").val($(this).find("td").eq(2).text());
			$("#dateOfBirth").val($(this).find("td").eq(3).text());
			$("#nationality").val($(this).find("td").eq(4).text());
			$("#academicYear").val($(this).find("td").eq(5).text());
			$("#studentStream").val($(this).find("td").eq(6).text());
			$("#studentStandard").val($(this).find("td").eq(7).text());
			$("#studentSubCast").val($(this).find("td").eq(8).text());
			$("#religion").val($(this).find("td").eq(9).text());
			$("#studentCategory").val($(this).find("td").eq(10).text());
			$("#studentCast").val($(this).find("td").eq(11).text());
			$("#studentPlaceOfBirth").val($(this).find("td").eq(12).text());
			$("#Mothertongue").val($(this).find("td").eq(13).text());

			$("#yearID1").val($(this).find("td").eq(14).text());
			//alert("Year"+$("#yearID1").val($(this).find("td").eq(14).text()));
			$("#standardID1").val($(this).find("td").eq(15).text());
			//alert($("#standardID1").val($(this).find("td").eq(15).text()));
			$("#streamID1").val($(this).find("td").eq(16).text());
			//alert($("#streamID1").val($(this).find("td").eq(16).text()));
			$("#branchID1").val($(this).find("td").eq(17).text());
			//alert($("#branchID1").val($(this).find("td").eq(17).text()));
			
		});

		var modal = document.getElementById('id01');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";

			}
		}
	
		$("#ledgerTable tr").click(function() {

			//alert("Hoo");
			
			$("#admissionId1").val($(this).find("td").eq(0).text());
			$("#studentName1").val($(this).find("td").eq(1).text());
			$("#studentGender1").val($(this).find("td").eq(2).text());
			$("#dateOfBirth1").val($(this).find("td").eq(3).text());
			$("#nationality1").val($(this).find("td").eq(4).text());
			$("#academicYear1").val($(this).find("td").eq(5).text());
			$("#studentStream1").val($(this).find("td").eq(6).text());
			$("#studentStandard1").val($(this).find("td").eq(7).text());
			$("#studentSubCast1").val($(this).find("td").eq(8).text());
			$("#religion1").val($(this).find("td").eq(9).text());
			$("#studentCategory1").val($(this).find("td").eq(10).text());
			$("#studentCast1").val($(this).find("td").eq(11).text());
			$("#studentPlaceOfBirth1").val($(this).find("td").eq(12).text());
			$("#Mothertongue1").val($(this).find("td").eq(13).text());

			/* Student Info */
			/* $("#yearID1").val($(this).find("td").eq(14).text());
			alert("Year"+$("#yearID1").val($(this).find("td").eq(14).text()));
			$("#standardID1").val($(this).find("td").eq(15).text());
			alert($("#standardID1").val($(this).find("td").eq(15).text()));
			$("#streamID1").val($(this).find("td").eq(16).text());
			alert($("#streamID1").val($(this).find("td").eq(16).text()));
			$("#branchID1").val($(this).find("td").eq(17).text());
			alert($("#branchID1").val($(this).find("td").eq(17).text())); */
			
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
	<div id="id02" class="modal">

		<s:form class="modal-content animate" action="LCCancel.html"
			method="post" commandName="">
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
						<td><label><b>Gender :</b></label></td>
						<td><input type="text" name="studentGender1"
							id="studentGender1" readonly="true"></td>

					</tr>

					<tr>

						<td><label><b>Date OF Birth :</b></label></td>
						<td><input type="text" name="dateOfBirth1"
							id="dateOfBirth1" readonly="true"></td>
						<td><label><b>Nationality :</b></label></td>
						<td><input type="text" name="nationality1" id="nationality1"
							readonly="true"></td>
						<td><label><b>Academic Year :</b></label></td>
						<td><input type="text" name="academicYear1" id="academicYear1"
							readonly="true"></td>

						
					</tr>
					<tr>

						<td><label><b>Stream :</b></label></td>
						<td><input type="text" name="studentStream1" id="studentStream1"
							readonly="true"></td>

						<td><label><b>Standard :</b></label></td>
						<td><input type="text" name="studentStandard1" id="studentStandard1"
							readonly="true"></td>
						
						<td><label><b>Student Religion :</b></label></td>
						<td><input type="text" name="" id="religion1" readonly="true">
						</td>
						
					</tr>
					<tr>
						

						<td><label><b>Student Category :</b></label></td>
						<td><input type="text" name="" id="studentCategory1"
							readonly="true"></td>

						<td><label><b>Student Cast :</b></label></td>
						<td><input type="text" name="" id="studentCast1"
							readonly="true"></td>
							
							<td><label><b>Birth Place :</b></label></td>
						<td><input type="text" name="studentPlaceOfBirth1" id="studentPlaceOfBirth1"
							readonly="true"></td>
					</tr>
					
				<!-- 	<tr>

						

						<td><label><b>Mother Tongue :</b></label></td>
						<td><input type="text" name="Mothertongue1" id="Mothertongue1"
							readonly="true"></td>

					</tr> -->
					
					<!-- <tr style="display:none;">
						<td><input type="text" name="yearID1" id="yearID1"
							></td>
						<td><input type="text" name="standardID1" id="standardID1"
							></td>
						<td><input type="text" name="streamID1" id="streamID1"
							></td>
						<td><input type="text" name="branchID1" id="branchID1"
							></td>			
					</tr> -->
					
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
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null,
				                null, null, null, null, null, null, null,
				                null, null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>