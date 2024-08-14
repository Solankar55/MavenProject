<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Branch Master Page</title>
<style type="text/css">
button {
	color: blue;
	width: 100px;
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
		<form action="AddNewBranch.html" method="post" id=""
			class="form-horizontal">
			<div class="page-header center">
				<h1><b>Branch Master</b></h1>
			</div>

			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Stream Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="streamMasterId"
								id="streamMasterId" required>
								<option value="">------Select Stream-------</option>
								<c:forEach var="StreamListForBranchV"
									items="${StreamListForBranch}">
									<option value="${StreamListForBranchV.key}">${StreamListForBranchV.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Branch Name:<span style="color: red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="branchName" class="col-xs-3" id=""
								placeholder="Branch Name" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Branch Name" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-4 control-label no-padding-right">
							<button type="submit" name="" id="" value=""
								class="btn btn-big btn-success">Save</button>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="row">

				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="dynamic-table" class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Branch Id</th>
										<th>Stream Name</th>
										<th>Branch Name</th>
									</tr>
								</thead>

								<tbody id="BranchOpration">
									<c:forEach var="v" items="${BranchList}">
										<tr
											onclick="document.getElementById('Oprations').style.display='block'">
											<td><c:out value="${v.branchId}"></c:out></td>
											<td><c:out value="${v.streamName}"></c:out></td>
											<td><c:out value="${v.branchName}"></c:out></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>

		</form>

		<script type="text/javascript">
			$("#BranchOpration tr").click(function() {
				//alert("HooBhoo");

				$("#BranchID").val($(this).find("td").eq(0).text());
				$("#StreamName").val($(this).find("td").eq(1).text());
				$("#BranchName").val($(this).find("td").eq(2).text());

				var modal = document.getElementById('Oprations');
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					//alert(value);
					if (event.target == modal) {
						modal.style.display = "none";

					}
				}
			});
		</script>
		<div id="Oprations" class="modal">

			<form class="modal-content animate" action="BranchOpration.html"
				method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('Oprations').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<table class="">
						<tr>
							<td><label><b>Branch Id :</b></label></td>
							<td><input type="text" name="BranchID" id="BranchID"
								readonly="true"></td>

							<td><label><b>Stream Name :</b></label></td>
							<td><input type="text" name="StreamName" id="StreamName"
								readonly="true"></td>
						</tr>

						<tr>

							<td><label><b>Branch Name :</b></label></td>
							<td><input type="text" name="BranchName" id="BranchName"
								required pattern="[a-z A-Z]+"
								title="Please Enter Correct Branch Name"></td>

						</tr>
					</table>
					<br>
					<center>
						<button type="submit" name="Update" value=""
							onclick="document.getElementById('Oprations').style.display='none'"
							class="btn btn-xs btn-success">Update Branch</button>

						<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Branch</button>
						
					</center>


				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
	<br>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null,null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>