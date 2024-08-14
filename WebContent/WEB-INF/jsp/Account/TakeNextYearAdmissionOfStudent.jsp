<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Next Year Admission</title>
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
			$.getJSON('GetBranchListJsonStandardA.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONStandardA.html',{branchid : branchid}).done(function(data) {
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
				$.getJSON('StudentStandardReportA.html',{yearId:yearId,streamid:streamid,branchid : branchid,standardID:standardID}).done(function(data) {
					
					for (var i=0;i<data.length;i++)
						{
							
							$("#StandardData").append("<tr><td><input type='checkbox' name='StudID"+i+"' value='"+data[i].admissionRegId+"'  ></td><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" "+data[i].studentLastName+ "</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].acadamicYear+"</td></tr>");
						
						}
					
				});
			});   
		 	$("#StreamID1").change(function(){
					//alert("Branch");
			var id = $("#StreamID1").val();
			$("#branchName1").empty();
					//$("#StandardData").empty();
			$("#branchName1").append("<option>"+"--Select Branch Name--"+"</option>");
			$.getJSON('GetBranchListJsonStandardA1.html',{id : id}).done(function(data) 
							{//alert(data[0].branchId);
				for (var i = 0; i < data.length; i++) {
									//alert("sss");
						$("#branchName1").append("<option id='dynamic1' value='"+data[i].branchId+"'>"+ data[i].branchName+ "</option>");
							}
					});
			});
			$("#branchName1").change(function(){
				//alert("Standard");
			var branchid = $("#branchName1").val();
			//$("#StandardData").empty();
			$("#standardName1").empty();
			$("#standardName1").append("<option>"+"--Select Standard Name--"+"</option>");
			
			$.getJSON('GetStandardListJSONStandardA1.html',{branchid : branchid}).done(function(data) {
				//alert(data[0].branchId);
				
				for (var i = 0; i < data.length; i++) {
				//alert("sss");
				
				$("#standardName1").append("<option id='dynamicStd1' value='"+data[i].standardId+"'>"+ data[i].standard+ "</option>");
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
	
	/* $("#TransferStudentAdmission").click(function(){
		alert("Next Year Student Transfermation process Completed...");
	}); */
});
</script>


</head>
<body>
<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Student Next Year Admission</b></h1>
			</center>
		</div>
		<form action="GetStudentListTONextYearAdmission.html"  method="post" id="" class="form-horizontal">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Academic Year:<span style="color:red;">*</span></label>

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
					Select Branch Name:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="branchID" id="branchName" required>
							<option id="dynamic" value="0">------Select Branch Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
					Select Standard:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="standardID" id="standardName" required>
							<option id="dynamicStd" value="0">------Select Standard
								Name-------</option>

						</select>
					</div>
				</div>
				
			</div>
		</div>
		<!-- <button type="submit" class="btn btn-sm btn-success" name="NextYearAdmission" id="NextYearAdmission">
									Get Student List <i
										class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
		</button> -->
		
	<hr />
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th><input type="checkbox" id="CheckAll"></th>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Branch</th>
									<th>Standard</th>
									<th>Stream</th>
									<th>Academic Year</th>

								</tr>
							</thead>

							<tbody id="StandardData">
								<%-- <c:forEach var="v" items="${GetStudentDetails}">

									<tr >
										<td><input type="checkbox" name="StudentIDs" value='StudentIDs${v.admissionRegId }'></td>
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.standard}"></c:out></td>
										<td><c:out value="${v.streamName}"></c:out></td>
										<td><c:out value="${v.branchName }"></c:out></td>
										<td><c:out value="${v.acadamicYear }"></c:out></td>
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
		<hr/>
		
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Academic Year:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="YearID1" id="YearID1" required>
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
						<select class="col-xs-3" name="StreamID1" id="StreamID1" required>
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
						<select class="col-xs-3" name="branchID1" id="branchName1" required>
							<option id="dynamic1" value="0">------Select Branch Name-------</option>

						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
					Select	Standard:<span style="color:red;">*</span></label>

					<div class="col-sm-9">
						<select class="col-xs-3" name="standardID1" id="standardName1" required>
							<option id="dynamicStd1" value="0">------Select Standard
								Name-------</option>

						</select>
					</div>
				</div>
				
			</div>
		</div>
		<input type="hidden" id="Count" name="CheckCount">
		<button type="submit" class="btn btn-sm btn-success" name="TransferStudentAdmission" id="SubmitCheck">
		Transfer Student To Next Year <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
		</button>
		</form>
		</div>
		
		
	
	<br><br><br>
</body>
</html>