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
			$.getJSON('GetBranchListJsonAlumini.html',{id : id}).done(function(data) 
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
			
			$.getJSON('GetStandardListJSONAlumini.html',{branchid : branchid}).done(function(data) {
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
				$.getJSON('StudentListAlumini.html',{yearId:yearId,streamid:streamid,branchid : branchid,standardID:standardID}).done(function(data) {
					
					for (var i=0;i<data.length;i++)
						{
							
							//$("#StandardData").append("<tr><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName + data[i].studentLastName+ "</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].studentContactNumber+"</td></tr>");
							$("#StandardData").append("<tr><td><input type='checkbox' name='StudID"+i+"' value='"+data[i].admissionRegId+"'  ></td><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" "+data[i].studentLastName+ "</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].studentContactNumber+"</td><td>"+data[i].studentEmail+"</td></tr>");
						}
					
				});
			});
			$("#SubmitCheck").click(function(){
				var numberOfChecked = $('input:checkbox:checked').length;
				$("#Count").val(numberOfChecked);
				//alert("check count"+numberOfChecked);
			});		
			$("#SubmitCheck123").click(function(){
				var numberOfChecked = $('input:checkbox:checked').length;
				$("#Count").val(numberOfChecked);
				//alert("check count"+numberOfChecked);
			});	
	$("#CheckAll").click(function(){
		 $('input:checkbox').not(this).prop('checked', this.checked);
	});	
			
});
</script>
</head>
<body>
<div class="page-content">
		<div class="page-header center">
			<h1><b>Send Alumini Link To Student</b></h1>
		</div>

		<form action="SendLinkAlumini.html" method="post"
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="Yearid" id="YearID" required>
								<option value="">------Select Year-------</option>
								<c:forEach var="v" items="${YearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Stream Name:<span style="color: red;">*</span>
						</label>
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
							Select Branch Name:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="branchName" id="branchName"
								required>
								<option id="dynamic" value="">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardName" id="standardName"
								required>
								<option id="dynamicStd" value="">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<!-- <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Mail Address: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="email" name="StudentMail" class="col-xs-3" id=""
								placeholder="Student Mail Address " required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div> -->

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th><input type="checkbox" id="CheckAll"></th>
										<th>Student Id</th>
										<th>Student Name</th>
										<th>Branch</th>
										<th>Standard</th>
										<th>Stream</th>
										<th>Mobile no</th>
										<th>Student Email</th>
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
			<hr />
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
		<h4>For alumini form use metioned link:   http://202.38.172.146/CMS/AluminiRegistrationForm.html</h4>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Message: <span style="color: red;">*</span>
						</label>
						<div class="">
							<textarea class="col-xs-3" name="MessageForStudent"
								placeholder="Student Message " cols="50" rows="9" required></textarea>
						</div>
					</div>
					<div class="form-group ">
						<input type="hidden" id="Count" name="CheckCount">
					<div class="col-sm-3 control-label no-padding-right">
						<button type="submit" class="btn btn-sm btn-success" id="SubmitCheck" value="Send Link" name="SendAluminiMessage"
							class="btn btn-big btn-success">Send Mail...<i
									class="ace-icon fa fa-arrow-left icon-on-left bigger-110"></i></button>
							<button type="submit" class="btn btn-sm btn-success" name="SendSMS"
								id="SubmitCheck123">
								Send SMS... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>


					</div>

				</div>
			</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>