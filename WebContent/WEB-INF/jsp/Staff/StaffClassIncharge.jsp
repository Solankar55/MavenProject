<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery-ui.custom.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/spinbox.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datepicker.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-timepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/js/daterangepicker.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-colorpicker.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.knob.min.js"></script>
<script src="<%=request.getContextPath()%>/js/autosize.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.inputlimiter.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-tag.min.js"></script>

<!-- ace scripts -->
<script src="<%=request.getContextPath()%>/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ace.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#standardID").change(function(){
		//alert("Subject Change Function Call");
		var YearID=$("#YearID").val();
		var StreamID=$("#StreamID").val();
		var branchID=$("#branchID").val();
		var standardID=$("#standardID").val();
		
		$("#StudentData").empty();
		$.getJSON('getStudentListJSONClassInCharge.html',{YearID:YearID,StreamID:StreamID,branchID:branchID,standardID:standardID}).done(function(data){
			
			for (var i=0;i<data.length;i++)
				{
					
				$("#StudentData").append("<tr><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" "+data[i].studentLastName+ "</td><td>"+data[i].acadamicYear+"</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td></tr>");
				
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
<!-- <script type="text/javascript">
	jQuery(function($) {
		$('.date-picker').datepicker({
			autoclose : true,
			todayHighlight : true
		});

		if ($('#date-timepicker1').datetimepicker({
			//format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
			icons : {
				autoclose : true,
				time : 'fa fa-clock-o',
				date : 'fa fa-calendar',
				up : 'fa fa-chevron-up',
				down : 'fa fa-chevron-down',
				previous : 'fa fa-chevron-left',
				next : 'fa fa-chevron-right',
				today : 'fa fa-arrows ',
				clear : 'fa fa-trash',
				close : 'fa fa-times'
			}
		
		}));
		
		if ($('#date-timepicker2').datetimepicker({
			//format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
			icons : {
				time : 'fa fa-clock-o',
				date : 'fa fa-calendar',
				up : 'fa fa-chevron-up',
				down : 'fa fa-chevron-down',
				previous : 'fa fa-chevron-left',
				next : 'fa fa-chevron-right',
				today : 'fa fa-arrows ',
				clear : 'fa fa-trash',
				close : 'fa fa-times'
			}
		}));
	});
</script> -->
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Student Class Attendance Page</h1>
			</center>
			<br>
		</div>
	
	<h3>Select Absent Student List</h3>
		<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Student Id</th>
										<th>Attendance Date</th>
										<th>Number Of Lect</th>
										<th>Student Name</th>
										<th>Lect Start Time Date</th>
										<th>Lect End Time Date</th>
									</tr>
								</thead>

								<tbody id="">
									<c:forEach var="v" items="${AbsentStudentList}">

										<tr>
											<td><c:out value="${v.admissionRegId}"></c:out></td>
											<td><c:out value="${v.CurrentDate}  "></c:out></td>
											<td><c:out value="${v.NumberOfLect}"></c:out></td>
											<td><c:out
													value="${v.studentFirstName} ${v.studentLastName }"></c:out></td>
											<td><c:out value="${v.LectStartTimeDate}"></c:out></td>
											<td><c:out value="${v.LectEndTimeDate}"></c:out></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<!-- /.row -->
		<hr/>
	<h3>Select Present Student List</h3>
		<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Student Id</th>
										<th>Attendance Date</th>
										<th>Number Of Lect</th>
										<th>Student Name</th>
										<th>Lect Start Time Date</th>
										<th>Lect End Time Date</th>
									</tr>
								</thead>

								<tbody id="">
									<%-- <c:forEach var="v" items="${PresentStudent}">

										<tr>
											<td><c:out value="${v.admissionRegId}"></c:out></td>
											<td><c:out value="${v.CurrentDate}  "></c:out></td>
											<td><c:out value="${v.NumberOfLect}"></c:out></td>
											<td><c:out
													value="${v.studentFirstName} ${v.studentLastName }"></c:out></td>
											<td><c:out value="${v.LectStartTimeDate}"></c:out></td>
											<td><c:out value="${v.LectEndTimeDate}"></c:out></td>
										
										</tr>
									</c:forEach> --%>

								</tbody>
							</table>
						
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<!-- /.row -->
	
	
	
	
		<%-- <form action="TakeAttendanceByClassIncharge.html" method="post" id="" class="form-horizontal">
		<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="id-date-picker-1">Date :</label>
						<div class="col-sm-9">
							<input class="col-xs-3 " name="DateCurrent" type="text" value="${currentDate }" readonly="true"/> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker1"> Lecture Start Date/Time :</label>
						<div class="col-sm-9">
							<input id="date-timepicker1" name="LectStartTime" type="text" class="col-xs-3" /> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker2"> Lecture End Date/Time :</label>
						<div class="col-sm-9">
							<input id="date-timepicker2" name="LectEndTime" type="text" class="col-xs-3" /> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker2"> Number Of Lecture :</label>
						<div class="col-sm-9">
							<input type="text" name="NumberOflectSub" class="col-xs-3" /> 
						</div>
					</div>
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
							Select Standard:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardID" required>
								<option value="">------Select Standard Name-------</option>
								<c:forEach var="v" items="${StandardList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach> 
							</select>
						</div>
					</div>
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
									<!-- 	<th><input type="checkbox" id="CheckAll"></th> -->
										<th>Student Id</th>
										<th>Student Name</th>
										<th>Academic Year</th>
										<th>Stream Name</th>
										<th>Branch Name</th>
										<th>Standard Name</th>
										<!-- <th>Subject Name</th> -->
									</tr>
								</thead>

								<tbody id="StudentData">

								</tbody>
							</table>
						<!-- 	<input type="hidden" id="Count" name="CheckCount"> -->
							<button type="submit" class="btn btn-sm btn-success" name="AttendanceByClassIncharge"
								id="SubmitCheck">
								Marked... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
	</form> --%>
	</div>
	<br>
	<br>
	<br>
</body>
</html>