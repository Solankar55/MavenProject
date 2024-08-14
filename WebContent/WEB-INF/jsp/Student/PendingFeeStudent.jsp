<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Pending Fee</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1><b>Student Pending Fee/Print Receipt</b></h1>
		</div>
		<form action="PirntStudentPendingFeeRecipt.html" method="post" target="_blank">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table">
							<tr>
								<th>Student Id</th>
								<th>Already Paid Fee</th>
								<th>Pending Fee</th>
								<th>Total Fee</th>
							</tr>
							<tbody>
								<c:forEach var="v" items="${FeeDetails}">
									<tr>
										<td><input type="text" name="StudentID" id="StudentID"
											value="${v.StudentID }" 
											readonly="true" /></td>
										<td><input type="text" name="PaidFee" value="${v.PaidFees}"
											readonly="true" /></td>
										<td><input type="text" name="PendingFee" id=""
											value="${v.PendingFees }" readonly="true" /></td>
										<td><input type="text" name="" id=""
											value="${v.totalFee}" readonly="true" /></td>

									</tr>
								</c:forEach>
							</tbody>

						</table>
						<hr/>
						
						<div class="center">

							<button name="PrintReciptFee" type="submit" class="btn btn-sm btn-purple">
								Print</button>
						</div>

					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>