
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Ledger</title>
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
		$("#AccountType").change(function() {
			var val = $(this).val();
			if (val == "Liability") {
				$("#LedgerType").val("Debit");
			}
			if (val == "Assets") {
				$("#LedgerType").val("Credit");
			}
		});

	});
</script>
<style type="text/css">
button {
	color: blue;
	width: 100px;
	height: 40px;
}
</style>

</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Ledger Master </b></h1>
			</center>

		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<form action="saveMasterLedger.html" method="get" id="ledgerMaster"
					class="form-horizontal">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Account Type:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="AccountType" id="AccountType"
								required>
								<option value="">---Select Type---</option>
								<option value="Liability">Liability</option>
								<option value="Assets">Assets</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Ledger Name:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<input type="text" name="LedgerName" class="col-xs-3"
								id="LedgerName" placeholder="Ledger Name" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Ledger Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Type:</label>

						<div class="col-sm-9">
							<input type="text" name="LedgerType" class="col-xs-3"
								id="LedgerType" placeholder="Ledger type" readonly="true" />
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
						<table id="dynamic-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Ledger Id</th>
									<th>Account Type</th>
									<th>Ledger Name</th>
									<th>Type</th>
								</tr>
							</thead>

							<tbody id="UpdateLedger">

								<c:forEach var="v" items="${listOfmasterLedger}">
									<tr
										onclick="document.getElementById('id01').style.display='block'">
										<td><c:out value="${v.LedgerId}"></c:out></td>
										<td><c:out value="${v.AccountType}"></c:out></td>
										<td><c:out value="${v.LedgerName}"></c:out></td>
										<td><c:out value="${v.LedgerType}"></c:out></td>
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
			$("#UpdateLedger tr").click(function() {
				//alert("Hoo");

				$("#LedgerID").val($(this).find("td").eq(0).text());
				$("#AccType").val($(this).find("td").eq(1).text());
				$("#LegderName").val($(this).find("td").eq(2).text());
				$("#Type").val($(this).find("td").eq(3).text());

				var modal = document.getElementById('id01');
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					//alert(value);
					if (event.target == modal) {
						modal.style.display = "none";

					}
				}
			});
		</script>
		<div id="id01" class="modal">

			<form class="modal-content animate" action="UpdateLedger.html"
				method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<table class="">
						<tr>
							<td><label><b>Ledger Id :</b></label></td>
							<td><input type="text" name="LedgerID" id="LedgerID"
								readonly="true"></td>

							<td><label><b>Account Type :</b></label></td>
							<td><input type="text" name="AccType" id="AccType"
								readonly="true"></td>
							<td><label><b>Ledger Name :<span
										style="color: red;">*</span></b></label></td>
							<td><input type="text" name="LegderName" id="LegderName"
								required pattern="[a-z A-Z]+" title="Please Enter Correct Name" />
							</td>

						</tr>

						<tr>
							<td><label><b>Type :</b></label></td>
							<td><input type="text" name="Type" id="Type" readonly="true"></td>
						</tr>
					</table>
					<center>
						<button type="submit" name="Update" value=""
							onclick="document.getElementById('id01').style.display='none'"
							class="btn btn-xs btn-success">Update Legder</button>


						<button type="submit" name="Delete" id="DeleteLege"
							onclick="document.getElementById('id01').style.display='none'"
							class="btn btn-xs btn-success">Delete Legder</button>

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
				"aoColumns" : [ null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>