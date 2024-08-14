<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
<script type="text/javascript">
	var showData = function($this) {

		$("#vendorid").val($($this).find("td").eq(0).text());
		$("#vendorName").val($($this).find("td").eq(1).text());
	}
</script>

</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>
					<b>Vendor Master </b>
				</h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<s:form action="VendorMaster.html" commandName="VendorMasterC"
					class="form-horizontal">
					<input type="hidden" class="col-xs-3" id="vendorid" name="vendorId"
						value="0">
						
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Vendor Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="vendorName"
								name="vendorName" placeholder="Vendor Name"
								title="Please Enter Correct Vendor Name" />
						</div>
					</div>

					<br>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" name="submitVendor"
								class="btn btn-big btn-success">Submit</button>
						</div>
						<div class="col-sm-3 control-label no-padding-right">

							<button type="submit" name="updateVendor"
								class="btn btn-big btn-success">Update</button>

							<button type="submit" name="deleteVendor"
								class="btn btn-big btn-success">Delete</button>
						</div>
					</div>
				</s:form>


			</div>
		</div>

		<hr />
		<div class="row">

			<div class="col-lg-12">

				<div class="portlet portlet-default">
					<div class="portlet-heading">
						<div class="portlet-title">



							<h4>Product Tables</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="portlet-body">
						<div class="table-responsive">
							<table id="dynamic-table"
								class="table table-striped table-bordered table-hover table-green">
								<thead>
									<tr class="gradeU">
										<td>Id</td>
										<td>Product Name</td>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="tr" items="${VendorList}">
										<tr onclick="showData(this);">
											<td><c:out value="${tr.vendorid}"></c:out></td>
											<td><c:out value="${tr.vendorName}"></c:out></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
					<!-- /.portlet-body -->
				</div>
				<!-- /.portlet -->

			</div>
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
				"aoColumns" : [ null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>