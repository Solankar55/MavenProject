<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Student Stand</title>
</head>
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
		$("#StreamID").change(function() {
			//alert("Branch");
			var id = $("#StreamID").val();
			$("#branchName").empty();
			$("#branchName").append("<option>"+"--Select Branch Name--"+"</option>");
				
			$.getJSON('GetBranchListJson.html',{id : id}).done(function(data) {//alert(data[0].branchId);
			
			for (var i = 0; i < data.length; i++) {
			//alert("sss");
			$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+ data[i].branchName + "</option>");
			}
			});
		});
		$("#branchName").change(function() {
		//alert("Standard");
		var branchid = $("#branchName").val();
		$("#standardName").empty();
		$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
		$.getJSON('GetStandardListJSON.html',{branchid : branchid}).done(function(data) {
		//alert(data[0].branchId);
		for (var i = 0; i < data.length; i++) {
			//alert("sss");
			$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+ data[i].standard+ "</option>");
				}
			});
		});

						
});
</script>
<script type="text/javascript">
$(document).ready(function() {
$("#ledgername").change(function(){
	//alert("In ledger");
	var yearId = $("#YearID").val();
	var streamid = $("#StreamID").val();
	var branchid = $("#branchName").val();
	var standardID = $("#standardName").val();
	var ledgername=$("#ledgername").val();
	$("#AddLedgerToDB").empty();
	$.getJSON('getSubledgerForassignFee.html',{yearId:yearId,streamid:streamid,branchid : branchid,standardID:standardID,ledgername:ledgername}).done(function(data) {
		
		//alert("sub ledger");
		
		 for (var i=0;i<data.length;i++)
		{
			
		$("#AddLedgerToDB").append("<tr><td><input type='checkbox' name='legerId"+i+"' value='"+data[i].SubLedgerId+"' required></td><td>"+data[i].SubLedgerId+"</td><td>"+data[i].LedgerName+"</td><td>"+data[i].subledger+"</td><td><input type='text' name='legerFee"+i+"' required pattern='[0-9]+' title='Please Enter Correct Fee' ></td></tr>");
		
		} 
		
	});
});
$("#SubmitCheck").click(function(){
	var numberOfChecked = $('input:checkbox:checked').length;
	$("#Count").val(numberOfChecked);
	//alert("check count"+numberOfChecked);
});	
$("#CheckAll").click(function(){
		$('input:checkbox').not(this).prop('checked', this.checked);
});	
});
</script>
<style type="text/css">
button {
	color: #438EB9;
	width: 150px;
	height: 40px;
}
</style>
<body>
	<div class="page-content">
		<form action="AddSubLedgerFee.html" method="post" id=""
			class="form-horizontal">

			<div class="page-header center">
				<h1><b> Student Standard Fee Master</b></h1>
				<br>
			</div>
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Academic Year:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="YearName" id="YearID" required>
								<option value="">------Select Year-------</option>
								<c:forEach var="v" items="${YearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Stream Name:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="StreamID" id="StreamID" required>
								<option value="">------Select Stream Name-------</option>
								<c:forEach var="v" items="${StreamList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Branch Name:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="branchName" id="branchName" required>
								<option id="dynamic" value="">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard Name:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardName" id="standardName" required>
								<option id="dynamicStd" value="">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Ledger Name:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="ledgername" id="ledgername" required>
								<option value="">------Select Legder Name-------</option>
								<c:forEach var="v" items="${LedgerList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<!-- <div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success">
								Get Sub Ledger</button>
						</div>
					</div> -->
				
				</div>
			</div>
		
		<hr />

		<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table 
							class="table  table-bordered table-hover">
							<thead>
								<tr>
								<th><input type="checkbox" id="CheckAll"></th>
									<th>LedgerID</th>
									<th>Ledger Name</th>
									<th>Sub-Ledger Name</th>
									<th>Ledger Fee</th> 
								</tr>
							</thead>

							<tbody id="AddLedgerToDB">
								<%-- <c:forEach var="SL" items="${SubLedgerList}">
									<tr onclick="document.getElementById('id01').style.display='block'" >
										<td><c:out value="${SL.SubLedgerId}"></c:out></td>
										<td><c:out value="${SL.LedgerName}"></c:out></td>
										<td><c:out value="${SL.subledger}"></c:out></td>
										
									</tr>
								</c:forEach> --%>
							</tbody>
						</table>
					</div>
					<input type="hidden" id="Count" name="CheckCount">
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" name="AssignFeeToSubledger" id="SubmitCheck" class="btn btn-big">
								Assign Fee</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
</form>
<hr>
<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>LedgerID</th>
									<th>Account Type</th>
									<th>Ledger Name</th>
									<th>Sub-Ledger Name</th>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
									<th>Ledger Fee</th>
								</tr>
							</thead>

							<tbody id="UpdateLedgerFee">
								<c:forEach var="LF" items="${Ledgerfee}">
									<tr onclick="document.getElementById('Update').style.display='block'" >
										<td><c:out value="${LF.LedgerId}"></c:out></td>
										<td><c:out value="${LF.AccountType}"></c:out></td>
										<td><c:out value="${LF.LedgerName}"></c:out></td>
										<td><c:out value="${LF.subledger }"></c:out></td>
										<td><c:out value="${LF.acadamicYear }"></c:out></td>
										<td><c:out value="${LF.branchName }"></c:out></td>
										<td><c:out value="${LF.streamName }"></c:out></td>
										<td><c:out value="${LF.standard }"></c:out></td>
										<td><c:out value="${LF.fee }"></c:out></td>
										<td style="display: none;"><c:out value="${LF.SubLedgerId }"></c:out></td>
										<td style="display: none;"><c:out value="${LF.StandardFeeId}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	
	<!-- <script type="text/javascript">
	$("#AddLedgerToDB tr").click(function() {

		//alert("Hoo");
		
		$("#SubLedgerID").val($(this).find("td").eq(0).text());
		$("#LedgerName").val($(this).find("td").eq(1).text());
		$("#SubLedgerName").val($(this).find("td").eq(2).text());
		
	var modal = document.getElementById('id01');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			//alert(value);
			if (event.target == modal) {
				modal.style.display = "none";

			}
		}
	});
	
	
	</script> -->
	
	<%-- <div id="id01" class="modal">

		<form class="modal-content animate" action="AddSubLedgerFee.html"
			method="post" >
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<table class="">
					<tr>
						<td><label><b>Ledger Id :</b></label></td>
						<td><input type="text" name="SubLedgerID" id="SubLedgerID" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Ledger Name :</b></label></td>
						<td><input type="text" name="LedgerName" id="LedgerName" class="col-sm-9"
							readonly="true"></td>
						<td><label><b>Sub Ledger Number :</b></label></td>
						<td><input type="text" name="SubLedgerName" class="col-sm-9"
							id="SubLedgerName" readonly="true"></td>

					</tr>
					
					<tr>
						<td><label><b>Ledger FEE :<span style="color:red;">*</span></b></label></td>
						<td><input type="text" path="Fee" name="Fee" id=""
						required pattern="[0-9]+" title="Please Enter Correct Fee" ></td>
					</tr>
			</table>
			<center>
					<button type="submit"
						onclick="document.getElementById('id01').style.display='none'"
						class="btn btn-xs btn-success">Assign Fee</button>
			</center>

			</div>
		</form>
	</div> --%>
	<hr>
	<script type="text/javascript">
	$("#UpdateLedgerFee tr").click(function() {
		//alert("HooBhoo");
		
		$("#LedgerID").val($(this).find("td").eq(0).text());
		$("#AccountType").val($(this).find("td").eq(1).text());
		$("#LedgName").val($(this).find("td").eq(2).text());
		$("#SubLedName").val($(this).find("td").eq(3).text()); 
		$("#LedgerFee").val($(this).find("td").eq(8).text());
		$("#SubLedgerId").val($(this).find("td").eq(9).text());
		$("#StdFeeId").val($(this).find("td").eq(10).text());
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

		<form class="modal-content animate" action="UpdateStnadardFee.html"
			method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('Update').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<table class="">
					<tr>
						<td><label><b>Ledger Id :</b></label></td>
						<td><input type="text" name="LedgerID" id="LedgerID"
							readonly="true"></td>

						<td><label><b>Account Type :</b></label></td>
						<td><input type="text" name="AccountType" id="AccountType"
							readonly="true"></td>
						<td><label><b>Ledger Name :</b></label></td>
						<td><input type="text" name="LedgName"
							id="LedgName" readonly="true"> </td>

					</tr>
				
					<tr>
						<td><label><b>Sub Ledger Name :</b></label></td>
						<td><input type="text" name="SubLedName"
							id="SubLedName" readonly="true" > </td>
						<td><label><b>Ledger Fee :<span style="color:red;">*</span></b></label></td>
						<td><input type="text" name="LedgerFee" id="LedgerFee" 
						required pattern="[0-9]+" title="Please Enter Correct Fee" ></td>
					</tr>
					<tr style="display: none;">
						<td><label><b>Sub Ledger ID :</b></label></td>
						<td><input type="text" name="SubLedgerId"
							id="SubLedgerId" readonly="true" > </td>
					</tr>
					<tr style="display: none;">
						<td><label><b>Std Fee Id :</b></label></td>
						<td><input type="text" name="StdFeeId"
							id="StdFeeId" readonly="true" > </td>
					</tr>
			</table>
			<br>
			<center>
					<button type="submit" name="Update" value=""
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Update Standard Fee</button>
						
			
					<button type="submit" name="Delete" value=""
						onclick="document.getElementById('Update').style.display='none'"
						class="btn btn-xs btn-success">Delete Standard Fee</button>
						
			</center>
			

			</div>
		</form>
	</div>
	</div>
	<br>
	<Br>
	<br>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null, null,null,null,null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>