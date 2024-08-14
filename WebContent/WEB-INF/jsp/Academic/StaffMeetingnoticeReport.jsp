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
			<h1><b>Staff Meeting Notice Page</b></h1>
			<br>
		</div>
		<form action="MeetingReportNoticePrint.html" method="get" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Staff Meeting Notice Id</th>
										<th>Staff Department</th>
										<th>Staff Name</th>
										<th>Staff Notice</th>
										<th>Staff Notice Date</th>
										<th>Staff Type</th>
									</tr>
								</thead>

								<tbody id="">
									<c:forEach var="v" items="${StaffMeetingNotice}">

										<tr>
											<td><c:out value="${v.StaffMeetingNoticeID}"></c:out></td>
											<td><c:out value="${v.SatffDepartment}"></c:out></td>
											<td><c:out value="${v.StaffName} "></c:out></td>
											<td><c:out value="${v.StaffNotice}"></c:out></td>
											<td><c:out value="${v.StaffNoticeDate }"></c:out></td>
											<td><c:out value="${v.StaffType }"></c:out></td>
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