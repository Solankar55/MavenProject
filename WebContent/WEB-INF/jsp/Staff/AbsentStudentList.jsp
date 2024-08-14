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
			<h1>Absent Student List</h1>
			<br>
		</div>
		<form action="PrintAbsentStudentList.html" method="post" target="_blank">
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
									<c:forEach var="v" items="${StudentList}">

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
							<button type="submit" class="btn btn-sm btn-success" name="PrintAbsentStudent"
								id="">
								Print Absent Student List... <i
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
	<br><br><br>
</body>
</html>