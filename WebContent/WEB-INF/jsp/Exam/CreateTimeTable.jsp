<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script src=<%=request.getContextPath()%>"/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ace.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			<h1><b>Create Time Table Page</b></h1>
		</div>
		<form action="SaveTimeTable.html" method="post"
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="id-date-picker-1">Date:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input name="TimeTableDate"
								class="col-xs-3 date-picker input-group" id="id-date-picker-1"
								type="text" data-date-format="dd-mm-yyyy"
								required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker1"> From Date/Time:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input id="date-timepicker1" name="FromDate" type="text"
								class="col-xs-3" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="date-timepicker2"> To Date/Time:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input id="date-timepicker2" name="TODate" type="text"
								class="col-xs-3" required />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Event Name:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="text" name="EventName" class="col-xs-3" id=""
								placeholder="" required pattern="[a-z A-Z]+" title="Please Enter Correct Event" />
						</div>
					</div>

					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button name="SaveEvent" id="" value="Add Event" style=""
								class="btn btn-big btn-success">Add Event</button>
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
						<table id="" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Time Table Id</th>
									<th>Date</th>
									<th>Form Date/Time</th>
									<th>To Date/Time</th>
									<th>Event</th>
								</tr>
							</thead>

							<tbody>

								<c:forEach var="A" items="${GetTimeTableList}">
									<tr>
										<td><c:out value="${A.TimeTbaleID}"></c:out></td>
										<td><c:out value="${A.TimeTableDate}"></c:out></td>
										<td><c:out value="${A.FromDate}"></c:out></td>
										<td><c:out value="${A.TODate}"></c:out></td>
										<td><c:out value="${A.EventName}"></c:out></td>

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
	<br>
	<br>
	<br>
</body>
</html>