<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject</title>
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
<body><!-- SaveSubjectData.html -->
	<div class="page-content">
		<div class="page-header center">

			<h1>
				<b>Subject Master</b>
			</h1>

		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="SaveSubjectData.html" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Subject Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="LibrarySubject"
								name="LibrarySubject" placeholder="Subject Name" required pattern="[a-z A-Z]+"
															title="Please Enter Correct Subject" />
						</div>
					</div>

					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success" name="Add">
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
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
										<tr>
											<th>Id</th>
											<th>Subject</th>
										</tr>
									</thead>
									<tbody id="LibrarySubjectTable">
										<c:forEach var="L" items="${LSMaster}">
											<tr
												onclick="document.getElementById('Oprations').style.display='block'">
												<td><c:out value="${L.LibrarySubjectMasterId}"></c:out></td>
												<td><c:out value="${L.LibrarySubject}"></c:out></td>
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
	<br><br><br>

	
	<script type="text/javascript">
		$("#LibrarySubjectTable tr").click(function() {

			$("#subjectid").val($(this).find("td").eq(0).text());
			$("#subject").val($(this).find("td").eq(1).text());

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

		<form class="modal-content animate" action="UpdateSubjectData.html">

			<div class="imgcontainer">
				<span
					onclick="document.getElementById('Oprations').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
				<div class="form-group">
					<label for="Subject">Subject ID</label> <input type="text"
						class="form-control" id="subjectid" placeholder="SubjectId"
						readonly name="SubjectId"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
				</div>

				<div class="form-group">
					<label for="Subject">Subject<span style="color: red;">*</span></label>
					<input type="text" class="form-control" id="subject"
						placeholder="Subject" name="Subject"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;"
						required pattern="[a-z A-Z]+" title="Please Enter Correct Subject">
				</div>

				<br>
				<center>
					<button type="submit" name="Update"
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Update Subject</button>

					<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button>
				</center>

			</div>
		</form>
	</div>
	
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







