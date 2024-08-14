<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Bonafide</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1><b>Student Bonafide</b></h1>
			<center><font color="red">Dear Student Please, Keep in mind that you can apply for <b>Bonafide</b> twice in a year.</b></font></center> 
		</div>
	<s:form action="RequestForBonafide.html" method="post" commandName="RequestBonafide" >	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="" class="table">
						
						<thead><tr>
							<th>Student Id</th>
							<th>Student Name </th>
							<th>Standard </th>
							<!-- <th></th> -->
							<!-- <th>Academic Year</th>
							<th>Birth Date</th> -->
						</tr>
						</thead>						
						<tbody>
						<c:forEach var="v" items="${StudentDetailInfo}">
						<tr>
						<td><input type="text" name="StudentID" id="StudentID" value="${v.admissionRegId }"
										placeholder="Student ID" readonly="true"/></td>
						<td><input type="text" name="" id="" value="${v. studentFirstName} ${v.studentLastName}"
										placeholder="Student Name" readonly="true"></td>
						<td><input type="text" name="" id="standard" value="${v.standard }"
										placeholder=" " readonly="true"></td>
						<!-- <td></td> -->

						<%-- <td><input type="text" name="" id="" value="${v.acadamicYear }"
										placeholder="Academic Year" readonly="true" /></td>
						<td><input type="text"name="" id="" value="${v.studentDateOfBirth }"
							placeholder="Student Birth Date" readonly="true"/></td>
						 --%></tr>
						</c:forEach>
						</tbody>

					</table>
					<table id="" class="table"><thead>
						<tr>
							<th>Current Date</th>
							<th>Academic Year</th>
							<th>Birth Date</th>
							<!-- <th></th> -->
						</tr></thead>
						<tbody>
						<c:forEach var="v" items="${StudentDetailInfo}">
						<tr>
						<td><s:input type="text" path="bonafideDate" id="CurrentDate"
									value="${curentdate }"	placeholder="" readonly="true" /></td>
						<td><input type="text" name="" id="" value="${v.acadamicYear }"
										placeholder="Academic Year" readonly="true" /></td>
						<td><input type="text"name="" id="" value="${v.studentDateOfBirth }"
							placeholder="Student Birth Date" readonly="true"/></td>
						<!-- <td></td>	 -->
						</tr>
						</c:forEach>
						</tbody>

					</table>

					<div class="center">

						<button id="sendReq" type="submit" class="btn btn-sm btn-purple">
						Send Request For Bonafide</button>
					</div>

				</div>
			</div>
		</div>
		<!-- /.span -->
	</div>
	<%-- </c:forEach> --%>
	</s:form>
	</div>
	<br><br><br>
</body>
</html>