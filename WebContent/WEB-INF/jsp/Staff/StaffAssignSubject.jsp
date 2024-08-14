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
	//alert("Ready");
	
	$("#SubjectID").change(function(){
		//alert("Subject Change Function Call");
		var YearID=$("#YearID").val();
		var StreamID=$("#StreamID").val();
		var branchID=$("#branchID").val();
		var standardID=$("#standardID").val();
		var SubjectID=$("#SubjectID").val();
		$("#StudentData").empty();
		$.getJSON('getStudentListJSONSubjectAssignStaff.html',{YearID:YearID,StreamID:StreamID,branchID:branchID,standardID:standardID,SubjectID:SubjectID}).done(function(data){
			
			for (var i=0;i<data.length;i++)
				{
					
				$("#StudentData").append("<tr><td><input type='checkbox' name='StudID"+i+"' value='"+data[i].admissionRegId+"'  ></td><td>"+data[i].admissionRegId+"</td><td>"+data[i].studentFirstName +" "+data[i].studentLastName+ "</td><td>"+data[i].acadamicYear+"</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td></tr>");
				
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
<script type="text/javascript">
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
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
				<h1>Student Attendance By Subject Page</h1>
		</div>
		<form action="TakeAttendanceSubjectVis.html" method="post" id=""
			class="form-horizontal">
			<!-- Lecture Information -->
			<!-- First Page -->
			<div class="row" id="FirstPage">
				<div class="col-xs-12 col-sm-4" id="" style="">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Lecture Information</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div>

									<label for="form-field-8">Date</label> <input type="text"
										class="form-control" id="" name="DateCurrent"
										placeholder="Current Date" value="${currentDate }"
										readonly="true" />

								</div>
								<hr />

								<div>
									<label for="form-field-8">Lecture Start Date/Time</label> <input
										type="text" class="form-control" id="date-timepicker1"
										name="LectStartTime" placeholder="Lect Start Time" required
										pattern="\d{1,2}/\d{1,2}/\d{4} \d{1,2}:\d{1,2} \w{PM,AM}"
										title="Please Select Correct Date" />
								</div>
								<hr />

								<div>
									<label for="form-field-8">Lecture End Date/Time</label> <input
										type="text" placeholder="Lect End Time" class="form-control"
										id="date-timepicker2" name="LectEndTime" required
										pattern="\d{1,2}/\d{1,2}/\d{4} \d{1,2}:\d{1,2} \w{PM,AM}"
										title="Please Select Correct Date" />
								</div>

								<hr />

								<div>
									<label for="form-field-8">Number Of Lecture</label> <input
										type="text" class="form-control" id="" name="NumberOflectSub"
										required pattern="[0-9]"
										title="Please Enter Correct Number Of Lect."
										placeholder="Number Of Lect" />
								</div>
								<hr />

							</div>
						</div>
					</div>
				</div>


				<!-- Account Information Div -->

				<div class="col-xs-12 col-sm-4" id="" style="">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Official Information</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div>
									<label for="form-field-select-1">Academic Year <span
										style="color: red;">*</span></label>
									<%-- <s:input type="text" class="form-control" id="currentAcademicYear" path="acadamicYear" placeholder="Academic year" value="${academic }" /> --%>
									<select class="form-control" name="YearID" id="YearID" required>
										<option value="">------Select Year-------</option>
										<c:forEach var="v" items="${YearList}">
											<option value="${v.key}">${v.value}</option>
										</c:forEach>
									</select>
								</div>
								<hr />

								<div>
									<label for="form-field-select-1">Stream Name <span
										style="color: red;">*</span></label>
									<%-- <s:input type="text" class="form-control" id="currentAcademicYear" path="acadamicYear" placeholder="Academic year" value="${academic }" /> --%>
									<select class="form-control" name="StreamID" id="StreamID"
										required>
										<option value="">------Select Stream Name-------</option>
										<c:forEach var="v" items="${StreamList}">
											<option value="${v.key}">${v.value}</option>
										</c:forEach>
									</select>
								</div>
								<hr />

								<div>
									<label for="form-field-select-1">Branch Name <span
										style="color: red;">*</span></label> <select class="form-control"
										name="branchID" id="branchID" required>
										<option value="">------Select Branch Name-------</option>
										<c:forEach var="v" items="${BranchList}">
											<option value="${v.key}">${v.value}</option>
										</c:forEach>
									</select>
								</div>
								<hr />

								<div>
									<label for="form-field-select-1">Standard Name <span
										style="color: red;">*</span></label> <select class="form-control"
										name="standardID" id="standardID" required>
										<option value="">------Select Standard Name-------</option>
										<c:forEach var="v" items="${StandardList}">
											<option value="${v.key}">${v.value}</option>
										</c:forEach>
									</select>
								</div>
								<hr />
							</div>
						</div>
					</div>
				</div>

				<!-- Student Other Information -->

				<div class="col-xs-12 col-sm-4" id="studDiv" style="">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Official Information</h4>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div>
									<label for="form-field-select-1">Subject Name <span
										style="color: red;">*</span></label> <select class="form-control"
										name="SubjectID" id="SubjectID" required>
										<option id="dynamicSubject" value="">------Select
											Subject Name-------</option>
										<c:forEach var="v" items="${SubjectList}">
											<option value="${v.key}">${v.value}</option>
										</c:forEach>
									</select>
								</div>
								<hr />
								<%-- <center>
									<button type="button" id="secPage"
										class="btn btn-sm btn-success">
										Next <i
											class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
								</center> --%>
							</div>
						</div>
					</div>
				</div>
			</div>

			<hr />
			<%-- <form action="TakeAttendanceSubjectVis.html" method="post" id=""
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="id-date-picker-1">Date:</label>
						<div class="col-sm-9">
							<input class="col-xs-3 " name="DateCurrent" type="text" value="${currentDate }" readonly="true"/> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker1"> Lecture Start Date/Time:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input id="date-timepicker1" name="LectStartTime" type="text" class="col-xs-3" 
							required pattern="\d{1,2}/\d{1,2}/\d{4} \d{1,2}:\d{1,2} \w{PM,AM}" title="Please Select Correct Date"/> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker2"> Lecture End Date/Time:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input id="date-timepicker2" name="LectEndTime" type="text" class="col-xs-3" 
							required pattern="\d{1,2}/\d{1,2}/\d{4} \d{1,2}:\d{1,2} \w{PM,AM}" title="Please Select Correct Date"/> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker2"> Number Of Lecture:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="NumberOflectSub" class="col-xs-3" 
							required pattern="[0-9]" title="Please Enter Correct Number Of Lect." /> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Year:<span style="color:red;">*</span></label>

						<div class="col-sm-9" required>
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
						<div class="col-sm-9" >
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
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Select Subject Name:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="SubjectID" id="SubjectID" required>
								<option id="dynamicSubject" value="">------Select Subject Name-------</option>
								<c:forEach var="v" items="${SubjectList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
				</div>
				
			</div>
		
		<hr /> --%>
			<div class="row">

				<div class="col-xs-12">
					<h3>Select Absent Student</h3>
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table  table-bordered table-hover">

								<thead>
									<tr>
										<th><input type="checkbox" id="CheckAll"></th>
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
							<input type="hidden" id="Count" name="CheckCount">
							<button type="submit" class="btn btn-sm btn-success"
								name="SubjectVisAttendence" id="SubmitCheck">
								Mark Absent ... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>