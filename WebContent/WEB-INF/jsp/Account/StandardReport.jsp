<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>standard Report Page</title>

<script type="text/javascript">
	$(document).ready(function() 
	{
		//alert("Ready");
		$("#StreamID").change(function(){
			//alert("Branch");
			var id = $("#StreamID").val();
			$("#branchName").empty();
			$("#StandardData").empty();
			$("#branchName").append("<option>"+"--Select Branch Name--"+"</option>");
			$.getJSON('GetBranchListJsonStandard.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONStandard.html',{branchid : branchid}).done(function(data) {
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
				$.getJSON('StudentStandardReport.html',{yearId:yearId,streamid:streamid,branchid : branchid,standardID:standardID}).done(function(data) {
					
					for (var i=0;i<data.length;i++)
						{
							
							$("#StandardData").append("<tr><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" " + data[i].studentLastName+ "</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].studentContactNumber+"</td></tr>");
						
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
				<h1><b>standard wise Report Page</b></h1>
			</center>
		</div>
		<form action="GetreportStandard.html"  method="post" id=""
			class="form-horizontal" target="_blank">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
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
							<option id="dynamic" value="0">------Select Branch Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
					Select	Standard:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="standardName" id="standardName" required>
							<option id="dynamicStd" value="0">------Select Standard
								Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group ">
					<div class="col-sm-3 control-label no-padding-right">
						<button type="submit" class="btn btn-big btn-success">
							Get Report</button>
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
						<table id="dynamic-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Branch</th>
									<th>Standard</th>
									<th>Stream</th>
									<th>Mobile no</th>

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
									</tr>
								<%-- <c:forEach var="v" items="${StudentStandardList}">

									<tr>
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.standard}"></c:out></td>
										<td><c:out value="${v.streamName}"></c:out></td>
										<td><c:out value="${v.branchName }"></c:out></td>
										<td><c:out value="${v.studentContactNumber }"></c:out></td>
									</tr>
								</c:forEach>
 --%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
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
				"aoColumns" : [ null, null,null,null,null,null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>