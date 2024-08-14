<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="page-content">
			<div class="page-header center">
				<h1>Given Assignment List</h1>
				<br>
			</div>
			
			<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Assignment Id</th>
									<th>Assignment Date</th>
									<th>Assignment</th>
								<!-- 	<th>Stream</th>
									<th>Branch</th>
									<th>Standard</th> -->
									<th>Student Name</th>
									<th>Subject</th>
									<th>Assignment Status</th>
								</tr>
							</thead>

							<tbody id="">
								<c:forEach var="v" items="${GivenAssignmentList}">

									<tr>
										<td><c:out value="${v.AssignmentID}"></c:out></td>
										<td><c:out value="${v.AssignmentDate}  "></c:out></td>
										<td><c:out value="${v.AssignmentMessage}"></c:out></td>
										<%-- <td><c:out value="${v.streamName}"></c:out></td>
										<td><c:out value="${v.branchName}"></c:out></td>
										<td><c:out value="${v.standard}"></c:out></td> --%>
										<td><c:out value="${v.studentFirstName} ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.SubjectName}"></c:out></td>
										<td><c:out value="${v.AssignmentStatus}"></c:out></td>

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
	</div>
	<br><br><br>
</body>
</html>