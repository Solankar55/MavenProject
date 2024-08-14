<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			$.getJSON('GetBranchListJsonMasterSubject.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONMasterSubject.html',{branchid : branchid}).done(function(data) {
				//alert(data[0].branchId);
				
				for (var i = 0; i < data.length; i++) {
				//alert("sss");
				
				$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+ data[i].standard+ "</option>");
				}
			});
		});
	});
	</script>
</head>
<body>
<div class="page-content">
		<div class="page-header center">
			<h1><b>Subject Master Page</b></h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="SaveSubjectHOD.html" method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:<span style="color:red;">*</span></label>

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
							Select Stream Name: <span style="color:red;">*</span></label>
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
							Select Branch Name: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="branchID" id="branchName" required>
								<option id="dynamic" value="">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardName" required>
								<option id="dynamicStd" value="">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Subject Name:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input name="SubjectName" type="text" id="form-field-1"
								placeholder="Subject Name" class="col-xs-10 col-sm-3" 
								required pattern="[a-z A-Z]+" title="Please Enter Correct Subject Name" />
						</div>
					</div>
					<div class="form-group ">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" id="OK" type="submit">
								<i class="ace-icon fa fa-check bigger-110"></i> Create Subject
							</button>

							<!-- &nbsp; &nbsp;
							<button class="btn" type="">
								<i class="ace-icon fa fa-undo bigger-110"></i> Update
							</button> -->
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
						<table id="" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Subject Id</th>
									<th>Subject Name</th>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
								</tr>
							</thead>

							<tbody id="">

								<c:forEach var="A" items="${SubjectList}">
									<tr>
										<td><c:out value="${A.SubjectID}"></c:out></td>
										<td><c:out value="${A.SubjectName}"></c:out></td>
										<td><c:out value="${A.acadamicYear}"></c:out></td>
										<td><c:out value="${A.streamName}"></c:out></td>
										<td><c:out value="${A.branchName}"></c:out></td>
										<td><c:out value="${A.standard}"></c:out></td>
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