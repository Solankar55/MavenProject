<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#standardID").change(function(){
		//alert("Subject Change Function Call");
		var YearID=$("#YearID").val();
		var StreamID=$("#StreamID").val();
		var branchID=$("#branchID").val();
		var standardID=$("#standardID").val();
		
		//$("#StudentData").empty();
		$.getJSON('getSubjectListJSON.html',{YearID:YearID,StreamID:StreamID,branchID:branchID,standardID:standardID}).done(function(data){
			//alert("fghfg");
			for (var i = 0; i < data.length; i++) {
				//alert("sss");
				
				$("#subjectID").append("<option id='dynamicSub' value='"+data[i].SubjectID+"'>"+ data[i].SubjectName+ "</option>");
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
				<h1>Student Attendance By Class In-charge Page</h1>
			</center>
		</div>
		<form action="getStudentAttendanceBySub.html" method="post" id="" class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="id-date-picker-1">Date :</label>
						<div class="col-sm-9">
							<input class="col-xs-3 " name="DateCurrent" type="text"
								value="${currentDate }" readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:<span style="color: red;">*</span>
						</label>

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
							<select class="col-xs-3" name="branchID" id="branchID" required>
								<option value="">------Select Branch Name-------</option>
								<c:forEach var="v" items="${BranchList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Standard:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardID"
								required>
								<option value="">------Select Standard Name-------</option>
								<c:forEach var="v" items="${StandardList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Subject:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="subjectID" id="subjectID"
								required>
								<option id="dynamicSub" value="">------Select Subject-------</option>
							</select>
						</div>
					</div>
				</div>

			</div>
			<div>

				<button type="submit" class="btn btn-sm btn-success" name="getdata"
					id="getdata">
					Get Data... <i
						class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
				</button>


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
										<!-- 	<th><input type="checkbox" id="CheckAll"></th> -->
										<th>Student Id</th>
										<th>Student Name</th>
										<th>Total lecture</th>
										<th>Present No lecture</th>
									</tr>
								</thead>

								<tbody id="StudentData">

								</tbody>
							</table>
							<!-- 	<input type="hidden" id="Count" name="CheckCount"> -->
							<button type="submit" class="btn btn-sm btn-success"
								name="AttendanceByClassIncharge" id="SubmitCheck">
								Marked... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>