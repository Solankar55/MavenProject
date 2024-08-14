<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="form-group">
		<div class="page-content">
			<div class="page-header">
				<center>
					<h1>Assign Department</h1>
				</center>
				<br>
			</div>
			<form action="AssignDepartmentAction.html"
				 class="form-horizontal">
				<div class="row">
					<div class="col-xs-12">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								Select Teacher Name:<span style="color:red;">*</span></label>
							<div class="col-sm-9">
								<select class="col-xs-3" name="TeacherID" id="TeacherID" required>
									<option value="">------Select Teacher Name-------</option>
									<c:forEach var="v" items="${TeacherList}">
										<option value="${v.key}">${v.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								Select Department:<span style="color:red;">*</span></label>
							<div class="col-sm-9">
								<select class="col-xs-3" id="DepartmentId"
									name="Department" required>
									<option value="">------Select Department-------</option>
									<option value="Academic">Academic</option>
									<option value="Exam">Exam</option>
									<option value="Training And Placement">Training And Placement</option>
									<option value="NSS">NSS</option>
									<option value="Alumni">Alumni</option>
									<option value="Cultural">Cultural</option>
								</select>
							</div>
						</div>
					</div>
					<center>
						<button type="submit" name="Assignclass" value="Assign"
							class="btn btn-xs btn-success">Assign Department</button>
						<!-- <button type="submit" name="DisAssignclass" value="Assign"
							class="btn btn-xs btn-success">Remove Authority</button> -->
					</center>
				</div>
			</form>

			<hr />

			<div class="row">

				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="SubledgerTable"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Id</th>
										<th>Department Name</th>
										<th>Staff Name</th>
									</tr>
								</thead>

								<tbody>
									<%
										int i = 1;
									%>
									<c:forEach var="v" items="${GetAssignDepartmentList}">
										<tr>
											<td><% out.print(i++); %></td>
											<td><c:out value="${v.Department}"></c:out></td>
											<td><c:out value="${v.StaffName}"></c:out></td>
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
	</div>
<br><br><br>
</body>
</html>