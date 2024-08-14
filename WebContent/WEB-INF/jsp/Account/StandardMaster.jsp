<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Standard Master Page</title>
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
$(document).ready(function(){
 	 $("#StreamId").change(function(){
 		// alert("sss");
			var id=$("#StreamId").val();
			$("#branchName").empty();
			$("#branchName").append("<option>"+"--Select Branch Name--"+"</option>");
			$.getJSON('GetStreamUsingJson.html',{id:id}).done(function(data){	
			//alert(data[0].branchId);
			for (var i = 0; i<data.length; i++) {
				//alert("sss");
				$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+data[i].branchName+"</option>");
			}
		});
 	});
});
</script>
</head>
<body>
	<div class="page-content">
		<form action="SaveStandard.html" method="post" id="" class="form-horizontal">
			<div class="page-header center">
				<h1><b>Standard Master</b></h1>
			</div>
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Stream Name:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="StreamId" id="StreamId" required>
								<option value="">------Select Stream-------</option>
								 <c:forEach var="v" items="${StreamListForStandard}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach> 
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Branch Name:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="BranchId"
								id="branchName" required>
								<option id="dynamic" value="">------Select Branch-------</option>
								 <%-- <c:forEach var="v" items="${BranchListForStandard}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>  --%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Enter Standard:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="standard" class="col-xs-3" id=""
								placeholder="Standard Name"
								required pattern="[a-z A-Z]+" title="Please Enter Correct Standard" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-4 control-label no-padding-right">
							<button type="submit" name="" id="" value="" class="btn btn-big btn-success">
								Save</button>
						</div>
						<!-- <div class="col-sm-2 control-label no-padding-right">
							<button type="reset" name="" id="" value="" class="btn btn-big btn-success">
								Reset</button>
						</div> -->
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
										<th>Standard Id</th>
										<th>Stream</th>
										<th>Branch </th>
										<th>Standard </th>
									</tr>
								</thead>

								<tbody id="StandardOpration">

									 <c:forEach var="v" items="${StandardListOfStudent}">
										<tr onclick="document.getElementById('Oprations').style.display='block'">
											<td><c:out value="${v.standardId}"></c:out></td>
											<td><c:out value="${v.streamName}"></c:out></td>
											<td><c:out value="${v.branchName }"></c:out></td>
											<td><c:out value="${v.standard}"></c:out></td>
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
	$("#StandardOpration tr").click(function() {
		//alert("HooBhoo");
		
		$("#StndID").val($(this).find("td").eq(0).text());
		$("#StreamName").val($(this).find("td").eq(1).text());
		$("#BranchName").val($(this).find("td").eq(2).text());
		$("#Standard").val($(this).find("td").eq(3).text());
		
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

		<form class="modal-content animate" action="StandardOpration.html"
			method="post" >
			<div class="imgcontainer">
				<span onclick="document.getElementById('Oprations').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<table class="">
					<tr>
						<td><label><b>Standard Id :</b></label></td>
						<td><input type="text" name="StndID" id="StndID"
							readonly="true"></td>
						
						<td><label><b>Stream Name :</b></label></td>
						<td><input type="text" name="StreamName" id="StreamName"
							readonly="true"></td>
							
						<td><label><b>Branch Name :</b></label></td>
						<td><input type="text" name="BranchName"
							id="BranchName" readonly="true"> </td>
					</tr>
				
					<tr>
						
						<td><label><b>Standard :<span style="color:red;">*</span></b></label></td>
						<td><input type="text" name="Standard"
							id="Standard" 
							required pattern="[a-z A-Z]+" title="Please Enter Correct Standard"> </td>
							
					</tr>
			</table>
			<br>
			<center>
				<button type="submit" name="Update" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Update Standard</button>
					
					<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Standard</button>
						
			</center>
			

			</div>
		</form>
	</div>	
		
		
		
	</div>
	<br><br><br>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null,null,null],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>