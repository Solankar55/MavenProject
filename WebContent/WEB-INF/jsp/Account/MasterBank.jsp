<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Bank</title>
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

</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Bank Master </b></h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="saveBank.html" method="get" id=""
					class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Bank Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="bankName" name="bankName"
								placeholder="Bank Name" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Bank Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Branch Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="branchName"
								name="branchName" placeholder="Branch Name" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Branch Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Account Number:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="accuntNumber"
								name="accuntNumber" placeholder="Accunt Number" required
								pattern="[0-9]+" title="Please Enter Correct Account Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							NEFT/RTGS/IFSC:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="NEFT_RTGS_IFSC"
								name="NEFT_RTGS_IFSC" placeholder="NEFT_RTGS_IFSC" required
								pattern="[A-Z]{4}[0-9]{7}"
								title="Please Enter Correct IFSC Code" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success">
								Submit</button>
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
									<th>Bank ID</th>
									<th>Bank Name</th>
									<th>Branch Name</th>
									<th>Account Number</th>
									<th>NEFT/RTGS/IFSC</th>

								</tr>
							</thead>
							<tbody id="UpdateBank">
								<c:forEach var="ba" items="${listofbank}">
									<tr
										onclick="document.getElementById('Update').style.display='block'">
										<td><c:out value="${ba.bankId }"></c:out></td>
										<td><c:out value="${ba.bankName}"></c:out></td>
										<td><c:out value="${ba.branchName}"></c:out></td>
										<td><c:out value="${ba.accuntNumber}"></c:out></td>
										<td><c:out value="${ba.NEFT_RTGS_IFSC}"></c:out></td>
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
			$("#UpdateBank tr").click(function() {
				//alert("HooBhoo");

				$("#BankID").val($(this).find("td").eq(0).text());
				$("#BankName").val($(this).find("td").eq(1).text());
				$("#BranchName").val($(this).find("td").eq(2).text());
				$("#AccountNumber").val($(this).find("td").eq(3).text());
				$("#IFSC").val($(this).find("td").eq(4).text());

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

			<form class="modal-content animate" action="UpdateBankDetails.html"
				method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('Update').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<table class="">
						<tr>
							<td><label><b>Bank Id :</b></label></td>
							<td><input type="text" name="BankID" id="BankID"
								readonly="true"></td>

							<td><label><b>Bank Name :</b></label></td>
							<td><input type="text" name="BankName" id="BankName"
								></td>

							<td><label><b>Branch Name :</b></label></td>
							<td><input type="text" name="BranchName" id="BranchName"
								></td>
						</tr>

						<tr>
							<td><label><b>Account Number :<span
										style="color: red;">*</span></b></label></td>
							<td><input type="text" name="AccountNumber"
								id="AccountNumber" required pattern="[0-9]+"
								title="Please Enter Correct Account Number"></td>

							<td><label><b>NEFT/IFSC :<span
										style="color: red;">*</span></b></label></td>
							<td><input type="text" name="IFSC" id="IFSC" required
								pattern="[A-Z]{4}[0-9]{7}"
								title="Please Enter Correct IFSC Code"></td>

						</tr>
					</table>
					<br>
					<center>
						<button type="submit" name="Update" value=""
							onclick="document.getElementById('Update').style.display='none'"
							class="btn btn-xs btn-success">Update Bank Details</button>


						<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Delete Bank Details</button>
						
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
				"aoColumns" : [ null, null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>