<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	
	//alert("Ready");
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
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Approve NSS Student</h1>
			</center>
		</div>
		<form action="ApproveNSSStudent.html" method="get">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th><input type="checkbox" id="CheckAll"></th>
									<th>NSS ID</th>
									<th>Student Name</th>
									<th>Mobile Number</th>
									<th>Student Address</th>
									<th>Student Mail</th>
								</tr>
							</thead>
							<tbody>
							<% int i=0; %>
								<c:forEach var="G" items="${GetNSSStudentList }">
								
									<tr >
										<td><input type="checkbox"  name="NSSStudentCount<%= i %>" value="${G.NSSRegisterID }"></td>
										<td><c:out value="${G.NSSRegisterID }"></c:out></td>
										<td><c:out value="${G.StudName }"></c:out></td>
										<td><c:out value="${G.MobileNumber }"></c:out></td>
										<td><c:out value="${G.StudAddress }"></c:out></td>
										<td><c:out value="${G.StudMail }"></c:out></td>
										
									</tr>
									<% i++; %>
								</c:forEach>
							</tbody>
						</table>
						<input type="hidden" id="Count" name="CheckCount">
						<button type="submit" class="btn btn-sm btn-success"
							name="SubmitStudentNSS" id="SubmitCheck">
							Approve 
							<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
</body>
</html>