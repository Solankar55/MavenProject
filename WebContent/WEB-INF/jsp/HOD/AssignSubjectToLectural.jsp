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
			$.getJSON('GetBranchListJsonAssignSubject.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONAssignSubject.html',{branchid : branchid}).done(function(data) {
				//alert(data[0].branchId);
				
				for (var i = 0; i < data.length; i++) {
				//alert("sss");
				
				$("#standardName").append("<option id='dynamicStd' value='"+data[i].standardId+"'>"+ data[i].standard+ "</option>");
				}
			});
		});
			 $("#standardName").change(function(){
				var YearId=$("#YearID").val();
				var streamId = $("#StreamID").val();
				var branchid = $("#branchName").val();
				var StandardID=$("#standardName").val();
				$("#SubjectID").empty();
				$("#SubjectID").append("<option>"+"--Select Subject Name--"+"</option>");
				$.getJSON('GetTeacherListJSON.html',{YearId:YearId,streamId:streamId,branchid:branchid,StandardID : StandardID}).done(function(data) {
					//alert(data[0].branchId);
					
					for (var i = 0; i < data.length; i++) {
					//alert("sss");
					
					$("#SubjectID").append("<option id='dynamicSubject' value='"+data[i].SubjectID+"'>"+ data[i].SubjectName+ "</option>");
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
				<h1>Assign Subject to Lecturer</h1>
			</center>
			<br>
		</div>
		<form action="AssignSubjectToTeacher.html" method="post" id="AssignSub"
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
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
							<select class="col-xs-3" name="branchID" id="branchName" required>
								<option id="dynamic" value="">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardName" required>
								<option id="dynamicStd" value="">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Subject Name:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="SubjectID" id="SubjectID" required>
								<option id="dynamicSubject" value="">------Select Subject Name-------</option>
								<%-- <c:forEach var="v" items="${SubjectList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach> --%>
							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Teacher Name:<span style="color:red;">*</span></label>
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
					<button type="submit" name="AssignSubject" value="AssignSubject"
						class="btn btn-xs btn-success">Assign Subject
					</button>
					<!-- <button type="submit" name="DisAssignSubject" value="AssignSubject"
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
									<th>Assign Subject Id</th>
									<th>Staff Name</th>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
									<th>Subject Name</th>
								</tr>
							</thead>

							<tbody >

								<c:forEach var="A" items="${AssignTeacherList}">
									<tr>
									
										<td><c:out value="${A.AssignSubjectTeacherID}"></c:out></td>
										<td><c:out value="${A.StaffName}"></c:out></td>
										<td><c:out value="${A.acadamicYear}"></c:out></td>
										<td><c:out value="${A.streamName}"></c:out></td>
										<td><c:out value="${A.branchName}"></c:out></td>
										<td><c:out value="${A.standard}"></c:out></td>
										<td><c:out value="${A.SubjectName}"></c:out></td>
										
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