<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academic Year Master</title>
</head>
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
<body>
	<div class="page-content">
		<form action="SaveAcademicYearDepartMaster.html" 
			method="post" id="" class="form-horizontal">
			<div class="page-header center">
				<h1><b>Academic Year Master Page</b></h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Academic Year: <span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="acadamicYear" class="col-xs-3" id=""
								placeholder="Academic Year" value="${academic }"
								reuired pattern="[0-9]{4}-[0-9]{4}" title="Please Enter Correct Academic Year" />
						</div>
						<div>
							<br>
							<br>
							<div class="form-group ">
								<div class="col-sm-3 control-label no-padding-right">
									<button type="submit" id="" value="ADD" name="AddAcademicYear"
										class="btn btn-big btn-success">ADD</button>
								</div>
								<div class="col-sm-3 control-label no-padding-right">
									<button id="ActiveAction" name="SetActiveYear"										
										class="btn btn-big btn-success">Set Active</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<hr />

		<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Year Id</th>
									<th>Academic Year</th>
									<th>Status</th>
								</tr>
							</thead>

							<tbody id="AcdamicTableOpration">

								<c:forEach var="A" items="${AcademicYearList}">
									<tr
										onclick="document.getElementById('Oprations').style.display='block'">
										<td><c:out value="${A.acadamicYearId}"></c:out></td>
										<td><c:out value="${A.acadamicYear}"></c:out></td>
										<td><c:out value="${A.ActiveAcadamicYr}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>

		<script type="text/javascript">
			$("#AcdamicTableOpration tr").click(function() {
				//alert("HooBhoo");

				$("#AcYearID").val($(this).find("td").eq(0).text());
				$("#AcYear").val($(this).find("td").eq(1).text());

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

			<form class="modal-content animate" action="YearOprationD.html"
				method="post" >
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('Oprations').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<table class="">
						<tr>
							<td><label><b>Academic Year Id :</b></label></td>
							<td><input type="text" name="AcYearID" id="AcYearID"
								readonly="true"></td>

						</tr>

						<tr>

							<td><label><b>Academic Year:<span style="color:red;">*</span></b></label></td>
							<td><input type="text" name="AcYear" id="AcYear" 
							reuired pattern="[0-9]{4}-[0-9]{4}" title="Please Enter Correct Academic Year"></td>

						</tr>
					</table>
					<br>
					<center>
						<button type="submit" name="Update" value=""
							onclick="document.getElementById('Oprations').style.display='none'"
							class="btn btn-xs btn-success">Update Year</button>

						<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button>

					</center>


				</div>
			</form>
		</div>

	</div>
	<br>
	<br>
	<br>
</body>
</html>