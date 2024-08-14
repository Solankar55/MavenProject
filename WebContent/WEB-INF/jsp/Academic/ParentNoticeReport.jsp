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
			<h1><b>Parent Notice Page</b></h1>
			<br>
		</div>
		<form action="PrentNoticePrint.html" method="get" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Parent Message Id</th>
										<th>Teacher Name</th>
										<th>Staff Name</th>
										<th>Parent Message</th>
										<th>Message Date</th>
									</tr>
								</thead>
								<tbody id="">
									<c:forEach var="v" items="${ParentNotices}">
										<tr>
											<td><c:out value="${v.parentMessageID}"></c:out></td>
											<td><c:out value="${v.TeacherName}"></c:out></td>
											<td><c:out value="${v.studentFirstName} ${v.studentLastName}"></c:out></td>
											<td><c:out value="${v.parentMessage}"></c:out></td>
											<td><c:out value="${v.parentMessageDate }"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<button type="submit" id="" value="Print" name="PrintList"
				class="btn btn-big btn-success">Print</button>

		</form>
		<!-- /.row -->
	</div>
	<br>
	<br>
	<br>
</body>
</html>