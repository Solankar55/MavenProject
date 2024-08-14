<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#StreamID").change(function(){
		//alert("Branch");
		var id = $("#StreamID").val();
		$("#branchName").empty();
		$("#StandardData").empty();
		$("#branchName").append("<option>"+"--Select Branch Name--"+"</option>");
		$.getJSON('GetBranchListJsonFee.html',{id : id}).done(function(data) 
				{//alert(data[0].branchId);
				for (var i = 0; i < data.length; i++) {
					//alert("sss");
					$("#branchName").append("<option id='dynamic' value='"+data[i].branchId+"'>"+ data[i].branchName+ "</option>");
						}
				});
		});
	

	$("#branchName").change(function(){
		//alert("Standard");
	var branchid = $("#branchName").val();
	$("#StandardData").empty();
	$("#standardName").empty();
	$("#standardName").append("<option>"+"--Select Standard Name--"+"</option>");
	
	$.getJSON('GetStandardListJSONFee.html',{branchid : branchid}).done(function(data) {
		//alert(data[0].branchId);
		
		for (var i = 0; i < data.length; i++) {
		//alert("sss");
		
		$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+ data[i].standard+ "</option>");
		}
	});
  });
	
	$("#standardName").change(function(){
		//alert("In Standard");
		var yearId = $("#YearID").val();
		var streamid = $("#StreamID").val();
		var branchid = $("#branchName").val();
		var standardID = $("#standardName").val();
		$("#StandardData").empty();
		$.getJSON('StudentCompletedFeeRpt.html',{yearId:yearId,streamid:streamid,branchid : branchid,standardID:standardID}).done(function(data) {
			
			for (var i=0;i<data.length;i++)
				{
					
				$("#StandardData").append("<tr><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" "+ data[i].studentLastName+ "</td><td>"+data[i].AcademicYear+"</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].feeStatus+"</td><td>"+data[i].totalFee+"</td></tr>");
				
				}
			
		});
	});
		
	});


</script>
</head>
<body>
<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Students Completed Fees Report</b></h1>
			</center>
		</div>
		<form action="GetreportStudentCompletedFees.html"  method="post" id=""
			class="form-horizontal" target="_blank">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:<span style="color:red;">*</span></label>

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
					Select	Stream Name:<span style="color:red;">*</span></label>
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
					Select	Branch Name:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="branchName" id="branchName" required>
							<option id="dynamic" value="">------Select Branch Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
					Select	Standard:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="standardName" id="standardName" required>
							<option id="dynamicStd" value="">------Select Standard
								Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group ">
					<div class="col-sm-3 control-label no-padding-right">
						<button type="submit" class="btn btn-big btn-success" name="getFeeReport">
							Genarate Report</button>
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
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Admission Id</th>
									<th>Student Name</th>
									<th>Year</th>
									<th>Stream</th>
									<th>Branch</th>
									<th>Standard</th>
									<th>Status</th>
									<th>Total Fee</th>

								</tr>
							</thead>

							<tbody id="StandardData">
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	</div>
	<br><br><br>
</body>
</html>