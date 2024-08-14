<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			$.getJSON('GetBranchListJsonClassInCharge.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONClassinCharge.html',{branchid : branchid}).done(function(data) {
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

		function deletefunction(id)
		{

			var elementid=id;
			alert("called"+elementid);
			var txt;
			var brand=$("."+elementid).html();
			alert(brand);
			var r = confirm("Are you surely want to delete:"+brand+  " brand");
			if (r == true) {
				$.getJSON('deleterow.html',{elementid : elementid}).done(function(data) {
					document.getElementById(elementid.trim()).remove();
					alert(data);
				});
			} 
		}
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Assign Class InCharge</h1>
			</center>
			<br>
		</div>
		<form action="AssignClassIncharge.html" method="post" id=""
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="YearID" id="YearID" required>
								<option value="">------Select Year-------</option>
								<c:forEach var="v" items="${YearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Stream Name:</label>
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
							Select Branch Name:</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="branchID" id="branchName" required>
								<option id="dynamic" value="">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard:</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardName" required>
								<option id="dynamicStd" value="">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Teacher Name:</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="TeacherID" id="" required>
								<option value="">------Select Teacher Name-------</option>
								<c:forEach var="v" items="${TeacherList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<br>
				<center>
					<button type="submit" name="Assignclass" value="Assign"
						class="btn btn-xs btn-success">Assign InCharge
					</button>
					<!-- <button type="submit" name="DisAssignclass" value="Assign"
						class="btn btn-xs btn-success">Remove Authority
					</button> -->
				</center>
			</div>
		</form>
		<hr />
		<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Assign Id</th>
									<th>Staff Name</th>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
									<th>Status</th>
								</tr>
							</thead>

							<tbody >

								<c:forEach var="A" items="${getAssignClassInChargeList}">
									<tr id="${tr.AssignClassInchargeId}" onclick="deletefunction(id)">
									
										<td><c:out value="${A.AssignClassInchargeId}"></c:out></td>
										<td><c:out value="${A.StaffName}"></c:out></td>
										<td><c:out value="${A.acadamicYear}"></c:out></td>
										<td><c:out value="${A.streamName}"></c:out></td>
										<td><c:out value="${A.branchName}"></c:out></td>
										<td><c:out value="${A.standard}"></c:out></td>
										<td><c:out value="${A.Status}"></c:out></td>
										
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
</body>
</html>