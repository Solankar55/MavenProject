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
			<h1><b>Student Notice Page</b></h1>
		</div>
		<form action="PrintStudentNoticeList.html" method="get" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Student Notice Id</th>
										<th>Student Name</th>
										<th>Student Notice.</th>
										<th>Student Notice Date</th>
									</tr>
								</thead>
								<tbody id="">
									<c:forEach var="v" items="${StudentNotice}">

										<tr>
											<td><c:out value="${v.NoticeID}"></c:out></td>
											<td><c:out value="${v.studentFirstName} ${studentLastName}  "></c:out></td>
											<td><c:out value="${v.StudentNotice}"></c:out></td>
											<td><c:out value="${v.NoticeDate}"></c:out></td>
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