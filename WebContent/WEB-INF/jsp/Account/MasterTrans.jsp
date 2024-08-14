<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Transport Page</title>
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
		<div class="page-header">
			<center>
				<h1>Master Transport</h1>
			</center>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="TransportMgmt.html" method="get"
					class="form-horizontal">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Area Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="areaName" name="areaName"
								placeholder="Area Name" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Area Name" />

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Charges:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="charges" name="charges"
								placeholder="Charges" required pattern="[0-9]+"
								title="Please Enter Correct Charges" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button name="saveLedger" id="saveLedger" value="save" style=""
								class="btn btn-big btn-success">Save</button>
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
						<table id="TransportP" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Transport ID</th>
									<th>Area Name</th>
									<th>Charges</th>
								</tr>
							</thead>

							<tbody id="UpdateTranportArea">
								<c:forEach var="tr" items="${listofTransport}">
									<tr
										onclick="document.getElementById('Update').style.display='block'">
										<td><c:out value="${tr.transportId }"></c:out></td>
										<td><c:out value="${tr.areaName}"></c:out></td>
										<td><c:out value="${tr.charges}"></c:out></td>
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
			$("#UpdateTranportArea tr").click(function() {
				//alert("HooBhoo");

				$("#TransID").val($(this).find("td").eq(0).text());
				$("#AreaName").val($(this).find("td").eq(1).text());
				$("#Charges").val($(this).find("td").eq(2).text());

				var modal = document.getElementById('Update');
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					//alert(value);
					if (event.target == modal) {
						modal.style.display = "none";

					}
				}
			});
		</script>
		<div id="Update" class="modal">

			<form class="modal-content animate"
				action="UpdateTransportCharge.html" method="post"
				commandName="masterTransport">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('Update').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<table class="">
						<tr>
							<td><label><b>Transport Id :</b></label></td>
							<td><input type="text" name="TransID" id="TransID"
								readonly="true"></td>

							<td><label><b>Area Name :</b></label></td>
							<td><input type="text" name="AreaName" id="AreaName"
								readonly="true"></td>


						</tr>

						<tr>

							<td><label><b>Charge :</b></label></td>
							<td><input type="text" name="Charges" id="Charges">
							</td>

						</tr>
					</table>
					<br>
					<center>
						<button type="submit" name="Update" value=""
							onclick="document.getElementById('Update').style.display='none'"
							class="btn btn-xs btn-success">Update Charge</button>


						<!-- <button type="submit" name="Delete" value=""
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Delete Charge</button>
						 -->
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