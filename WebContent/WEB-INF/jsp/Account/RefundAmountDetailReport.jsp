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
		<form action="printRefundAmountDetailReport.html" method="get" id=""
			class="form-horizontal" target="_blank">
			<div class="page-header">
				<center>
					<h1><b>Refund Amount Details</b></h1>
				</center>
			</div>
			<div class="row">

				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Refund Id</th>
										<th>Academic Year</th>
										<th>Student Name</th>
										<th>Refund Amount</th>
										<th>Status</th>
									</tr>
								</thead>

								<tbody id="AcdamicTableOpration">

									<c:forEach var="r" items="${refundAmtDetailList}">
										<tr>

											<td><c:out value="${r.refundid}"></c:out></td>
											<td><c:out value="${r.acadamicYear}"></c:out></td>
											<td><c:out
													value="${r.studentFirstName} ${r.studentMiddleName} ${r.studentLastName} "></c:out></td>
											<td><c:out value="${r.refundamount}"></c:out></td>
											<td><c:out value="${r.status}"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
				<center>
					<input type="submit" name="printReport" value="Print"
						class="btn btn-xs btn-success" />
				</center>

			</div>

		</form>
	</div>
	<br><br><br>
</body>
</html>