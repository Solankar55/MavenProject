<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1><b>Traning And Placement Form Submited Student List</b></h1>
		</div>
		<form action="PrintTranindAndPlacmentStudentList.html" method="post">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>TAP Id</th>
										<th>Student Application Date</th>
										<th>Student Name</th>
										<th>Student Email</th>
										<th>Student Contact Number</th>
										<th>Student Qualification</th>
									</tr>
								</thead>

								<tbody id="">
									<c:forEach var="v" items="${StudentTAP}">

										<tr>
											<td><c:out value="${v.TAPId}"></c:out></td>
											<td><c:out value="${v.StudentApplicationDate}  "></c:out></td>
											<td><c:out value="${v.StudentFullName}"></c:out></td>
											<td><c:out value="${v.StudentEmail}"></c:out></td>
											<td><c:out value="${v.StudentContactNumber}"></c:out></td>
											<td><c:out value="${v.StudentQualification}"></c:out></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<button type="submit" class="btn btn-sm btn-success"
								name="PrintTAPReport" id="">
								Print... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<!-- /.row -->
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>