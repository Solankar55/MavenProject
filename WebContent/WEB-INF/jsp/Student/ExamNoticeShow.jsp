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
		<div class="page-header">
			<center>
				<h1><b>Student Exam Notice Page</b></h1>
			</center>
		</div>
		<form action="" method="get">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Exam Notice ID</th>
										<th>Exam Notice</th>
										<th>Exam Notice Date</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="G" items="${ExamNoticeList }">
										<tr>
											<td><c:out value="${G.examniticeid }"></c:out></td>
											<td><c:out value="${G.examnotice }"></c:out></td>
											<td><c:out value="${G.examnoticedate }"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>