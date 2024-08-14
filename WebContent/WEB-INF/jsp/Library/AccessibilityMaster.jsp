<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Issuer</title>
<style type="text/css">
button {
	color: blue;
	width: 150px;
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


<script type="text/javascript">
	$(document).ready(function() {
		//alert("Ready");
		$("#category").change(function() {
			//alert("Branch");
			var AcYearID = $("#AcYear").val();
			var category = $("#category").val();

			$.getJSON('GetAccessibilityFeeStructure.html', {
				AcYearID : AcYearID,
				category : category
			}).done(function(data) {
				//alert("hey");
				var canI = data[0].CanIssue;
				//alert(canI);
				$('#AbleToAccess').val(canI);
				var RturnDay = data[0].ReturnInDays;
				//alert(RturnDay);
				$('#ReturnInDays').val(RturnDay);
				var BFine = data[0].Fine;
				//alert(BFine);
				$('#Fine').val(BFine);
			});
		});
	});
</script>

</head>
<body>

	<div class="page-content">
		<div class="page-header center">

			<h1>
				<b>Accessibility Master</b>
			</h1>

		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="AccessibilityDataSave.html" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Academic Year:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="Acyear" id="AcYear" required>
								<option value="">------Select Year-------</option>
								<c:forEach var="v" items="${YearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Category:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" id="category" name="Category" required>
								<option value="">Select Category</option>
								<option value="Student">Student</option>
								<option value="Staff">Staff</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Can
							Issue:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" id="AbleToAccess" name="CanIssue"
								placeholder="10" class="col-xs-3" required pattern="[0-9]+"
								title="Please Enter Correct Number" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Return
							In Days:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" path="ReturnInDays" id="ReturnInDays"
								name="ReturnInDays" placeholder="10" class="col-xs-3" required
								pattern="[0-9]+" title="Please Enter Correct Return Days" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Fine:<span
							style="color: red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" id="Fine" name="Fine" placeholder="100/-"
								class="col-xs-3" required pattern="[0-9]+"
								title="Please Enter Correct Fine" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<input type="submit"
						name="AddAccessibilityMaster" class="btn btn-default" id="btn"
						value="Done">
						</div>
					</div>
				</form>
			</div>
		</div>

		<hr />
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Academic Year</th>
									<th>Category</th>
									<th>Can Issue</th>
									<th>Return In Days</th>
									<th>Fine</th>
								</tr>
							</thead>
							<tbody id="AccessibilityTable">
								<c:forEach var="A" items="${AMList}">
									<tr
										onclick="document.getElementById('Oprations').style.display='block'">
										<td>${A.AccessibilityId }</td>
										<td>${A.labacademicyear }</td>
										<td>${A.Category }</td>
										<td>${A.CanIssue }</td>
										<td>${A.ReturnInDays }</td>
										<td>${A.Fine }</td>
										<td style="display: none;">${A.acadamicYearId }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	</div>
	<br>
	<br>
	<br>

	<%-- <script type="text/javascript">
		$("#AccessibilityTable tr").click(function() {
			//alert("HooBhoo");
			$("#accessibilityid").val($(this).find("td").eq(0).text());
			$("#AcYear").val($(this).find("td").eq(1).text());
			$("#category").val($(this).find("td").eq(2).text());
			$("#canissue").val($(this).find("td").eq(3).text());
			$("#returnindays").val($(this).find("td").eq(4).text());
			$("#fine").val($(this).find("td").eq(5).text());
			$("#AcID").val($(this).find("td").eq(6).text());
			
			var modal = document.getElementById('Oprations');
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				alert(value);
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		});
	</script>


	<div id="Oprations" class="modal">

		<form class="modal-content animate"
			action="UpdateAccessibilityData.html">

			<div class="imgcontainer">
				<span
					onclick="document.getElementById('Oprations').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<div class="form-group">
					<label for="ID">ID</label> <input type="text" class="form-control"
						id="accessibilityid" placeholder="AccessibilityId" readonly
						name="AccessibilityId"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
				</div>

				<div class="form-group">
					<label for="Category">Category<span style="color: red;">*</span></label>
					<input type="text" class="form-control"
						id="accessibilityid" placeholder="AccessibilityId" readonly
						name="AccessibilityId"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
				</div>

				<div class="form-group">
					<label for="CanIssue">Can Issue<span style="color: red;">*</span></label>
					<input type="text" class="form-control" id="canissue"
						placeholder="CanIssue" name="CanIssue"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;"
						required pattern="[0-9]+" title="Please Enter Correct Can Issue">
				</div>

				<div class="form-group">
					<label for="ReturnInDays">Return In Days<span
						style="color: red;">*</span></label> <input type="text"
						class="form-control" id="returnindays" placeholder="ReturnInDays"
						name="ReturnInDays"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;"
						required pattern="[0-9]+"
						title="Please Enter Correct Return In Days">
				</div>

				<div class="form-group">
					<label for="Fine">Fine<span style="color: red;">*</span></label> <input
						type="text" class="form-control" id="fine" placeholder="Fine"
						name="Fine"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;"
						required pattern="[0-9]+" title="Please Enter Correct Fine">
				</div>
				<br>
				<center>
					<button type="submit" name="Update"
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Update Accessibility</button>

					<!-- <button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button> -->
				</center>

			</div>
		</form>
	</div> --%>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null ],
				"aaSorting" : []

			});
		})
	</script>
</body>
</html>