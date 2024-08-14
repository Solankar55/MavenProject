<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rack Number</title>

<script src="js/jquery.validate.min.js"></script>


<style type="text/css">

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* .container {
	padding: 16px;
} */

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
</style>




<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: "Open Sans";
	font-size: 14px;
}

.container {
	width: 100px;
	margin: 10px;
}

/* form {
  padding: 40px;
  background: 	#4682B4 ;
  color: #fff;
  -moz-border-radius: 0.5px;
  -webkit-border-radius: 0.5px;
  border-radius: 0.5px;
}  */
form label {
	border: 0;
	margin-bottom: 3px;
	display: block;
	width: 100%;
}
/* form input {
  height: 25px;
  line-height: 25px;
  background: #fff;
  color: #000;
  padding: 0 6px;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
} */
form button {
	height: 30px;
	line-height: 30px;
	background: #e67e22;
	color: #fff;
	margin-top: 10px;
	cursor: pointer;
}

form .error {
	color: #ff0000;
}
</style>



</head>
<body>

	<div id="page-wrapper">

		<div class="page-content">

			<!-- begin PAGE TITLE ROW -->
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1>Add Rack-Number</h1>
						<!-- <ol class="breadcrumb">
							<li>
							</li>
						</ol> -->
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">

				<!-- begin LEFT COLUMN -->
				<div class="col-lg-6">

					<div class="row">

						<!-- Basic Form Example -->
						<div class="col-lg-12">

							<div class="portlet portlet-default">
								<div class="portlet-heading">
									<div class="portlet-title">
										<h4>Rack-Number Form</h4>
									</div>
									<div class="portlet-widgets">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div id="basicFormExample" class="panel-collapse collapse in">
									<div class="portlet-body">


										<form role="form" action="SaveRackData.html" name="Rackadd">

											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label for="Category">Rack-Number:<span
															style="color: red;">*</span></label> <input type="text"
															class="form-control" id="category"
															placeholder="Rack-Number" name="RackNumber" required
															pattern="[a-zA-Z]{2}-[0-9]+"
															title="Please Enter Correct Rack Number (FR-22)">
													</div>
												</div>
											</div>
											<input type="submit" class="btn btn-default" value="Add">
										</form>

									</div>
								</div>
							</div>
							<!-- /.portlet -->
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="row">




				<!-- Category Table -->
				<div class="col-lg-6">
					<div class="portlet portlet-red">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Rack-Number Table</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>Id</th>
											<th>Rack-Number</th>
											<!-- <th>Delete</th>	 -->
										</tr>
									</thead>

									<tbody id="RackTable">
										<c:forEach var="R" items="${RList}">
											<tr
												onclick="document.getElementById('Oprations').style.display='block'">
												<td>${R.RackMasterId}</td>
												<td>${R.RackNumber}</td>
												<%-- <td><a href="<c:url value='/Delete.html/${R.RackMasterId}'/>"><span class="glyphicon glyphicon-trash"></span></a></td> --%>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- /.portlet -->
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>

	<!-- <script>
		var elementid = id;
		alert("Hello "+elementid);
		var r = confirm("Are u sure");
		if(r == true){
		$.getJSON('delete.html',(elementid : elementid)).done(function(data){
			document.getElementById(elementid.trim()).remove();
			alert(data);
		}));
		}
</script> -->

	<!-- <script>
$(document).ready(function(){
	$("#del").click(function(){
		var id = $("#rackid").val($(this).find("td").eq(0).text());
		alert("Hello "+id);
	});
	
});

</script> -->

	<script type="text/javascript">
		$("#RackTable tr").click(function() {
			//alert("HooBhoo");
			$("#rackid").val($(this).find("td").eq(0).text());
			$("#racknumber").val($(this).find("td").eq(1).text());
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

	<div class="container">
		<div id="Oprations" class="modal">

			<div class="panel-collapse collapse in">
				<div class="portlet-body">


					<form class="modal-content animate" action="UpdateRackData.html">

						<div class="imgcontainer">
							<span
								onclick="document.getElementById('Oprations').style.display='none'"
								class="close" title="Close Modal">&times;</span>
						</div>

						<div class="container">
							<div class="form-group">
								<label for="ID">ID</label> <input type="text"
									class="form-control" id="rackid" placeholder="RackId" readonly
									name="RackId"
									style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
							</div>

							<div class="form-group">
								<label for="RackNumber">Rack Number:<span
									style="color: red;">*</span></label> <input type="text"
									class="form-control" id="racknumber" placeholder="RackNumber"
									name="RackNumber"
									style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;"
									required pattern="[a-zA-Z]{2}-[0-9]+"
									title="Please Enter Correct Rack Number (FR-22)">
							</div>
							<br>
							<center>
								<button type="submit" name="Update"
									onclick="document.getElementById('Oprations').style.display='none'"
									class="btn btn-xs btn-success">Update Rack</button>

								<!-- <button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button> -->
							</center>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>