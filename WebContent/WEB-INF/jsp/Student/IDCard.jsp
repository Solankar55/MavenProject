<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student ID Card</title>
</head>
<body>
<div class="page-content">
		<div class="page-header">
			<h1><b>Student ID Card</b></h1>
		</div>
	<s:form action="StudentIDCardRequest.html" method="post" commandName="IDCardRequest">	
	<c:forEach var="v" items="${StudentDetails }">	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="" class="table">
						<tr>
							<th>Student Roll Number</th>
							<th>Student Name</th>
							<th>Date of Birth</th>
							<th>Contact Number</th>
							<th>Address</th>
						</tr>
						<tbody>
							<tr>
								<td><input type="text" name="StudentID" id="StudentID" value="${v.admissionRegId }"
									readonly="true"></td>
								<td><input type="text" name="" id=""  value="${v.studentFirstName } ${v.studentLastName}"
									readonly="true"></td>
								<td><input type="text" name="" id="" value="${v.studentDateOfBirth }"
									readonly="true"></td>
								<td><input type="text" name="" id="" value="${v.studentContactNumber }"
									readonly="true" /></td>
								<td><input type="text" name="" id="" value="${v.studentPermanenetAddress }"
									readonly="true" /></td>
							</tr>	
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- /.span -->
	</div>	
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table">
								<tr>
									<th>Academic Year</th>
									<th>Stream Name</th>
									<th>Branch Name</th>
									<th>Standard Name</th>
								</tr>
							<tbody >
								<tr>
								<td><input type="text" name="" value="${v.acadamicYear }" id=""
										readonly="true"></td>
									<td><input type="text" name=""  value="${v.streamName }" id=""
										readonly="true"></td>
									<td><input type="text" name=""  value="${v.streamName }" id=""
										readonly="true"></td>
									<td><input type="text" name="" value="${v.standard }"  id=""
										readonly="true"></td>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	</c:forEach>	
		<hr>
			<div class="center">
				<button id="sendReq" type="submit" class="btn btn-sm btn-purple">
				Send Request</button>
			</div>
		</s:form>	
	</div>
<br><br><br>
</body>
</html>