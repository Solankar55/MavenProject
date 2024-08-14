<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(document).ready(function(){
	
	 $('#StudentName').autocomplete({
	   
		source : '${pageContext.request.contextPath}/searchStudentNew.html'
	}); 
	 
	 $("#StudentName").change(function(){
		    var	studentName = $("#StudentName").val();
		   // alert(StudentName);
	         $("#StandardData").empty();
		    $.getJSON('getStudentTransaction.html',{studentName:studentName}).done(function(data){
		    	//alert("student details got");
		    	var acYear=data[0].AcademicYear;
		    	var streamName=data[0].streamName;
		    	var standardName=data[0].Standard;
		    	var branchName=data[0].branchName;
		    	
		    	$("#AcadimicYear").val(acYear);
		    	$("#streamName").val(streamName);
		    	$("#standardName").val(standardName);
		    	$("#branchName").val(branchName);
		    	
		    	$("#studentId").val(data[0].admissionRegId);
		    	
		    	var k=0;
		    	for (var i=0;i<data.length;i++)
				{
					k++;
					$("#StandardData").append("<tr><td>"+k+"</td><td>"+data[i].AlreadyPaidFees +"</td><td>"+data[i].PaidFees+"</td><td>"+data[i].PendingFees+"</td><td>"+data[i].totaldiscount+"</td><td>"+data[i].discountReason+"</td><td>"+data[i].feeStatus+"</td><td>"+data[i].totalFee+"</td></tr>");
				
				}
		    });
	 });
});
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1><b>Student Transaction Report</b></h1>
			<br>
		</div>
		<form action="getStudentTransactionReport.html" method="post" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Name</th>
										<th>Academic Year</th>
										<th>Stream Name</th>
										<th>Branch Name</th>
										<th>Standard Name</th>
									</tr>
								</thead>
								<tbody>
									<tr>
						
										<td><input type="text" placeholder="Student Name"
											id="StudentName" name="StudentName">
											<input type="hidden" id="studentId" name="studentId"></td>
										<td><input type="text" placeholder="Acadimic Year"
											id="AcadimicYear" name="AcadimicYear" readonly="true"></td>
										<td><input type="text" placeholder="Stream"
											id="streamName" name="streamName" readonly="true"></td>
										<td><input type="text" placeholder="Branch"
											id="branchName" name="branchName" readonly="true"></td>
										<td><input type="text" placeholder="Standard"
											id="standardName" name="standardName" readonly="true"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>

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
										<th>Fee Id</th>
										<th>Previous Paid</th>
										<th>Last Paid</th>
										<th>Pending</th>
										<th>Total Discount</th>
										<th>Discount Reason</th>
										<th>Fee Status</th>
										<th>Total Fee</th>
									</tr>
								</thead>

								<tbody id="StandardData">
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->

			</div>
			<hr />
			<div class="center">
				<button id="" name="downloadStdentTransaction" type="submit"
					class="btn btn-sm btn-purple">Download Student Transaction</button>
			</div>
		</form>
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
				"aoColumns" : [ null, null,null,null,null,null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>