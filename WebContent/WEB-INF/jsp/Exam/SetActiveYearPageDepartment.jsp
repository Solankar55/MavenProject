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
			<h1><b>Set Active Academic Year Master Page</b></h1>
		</div>

		<form action="SaveActiveYearD.html" class="form-horizontal"
			method="get">
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Activate Academic Year:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="ActiveYearID" id="" required>
								<option value="">------Select Academic Year-------</option>
								<c:forEach var="v" items="${AcademicYearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<div class="col-sm-3 control-label no-padding-right">
								<button name="" id="" value="Active Year"
									class="btn btn-big btn-success">Active Year</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<hr />

		<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Year Id</th>
									<th>Active Academic Year</th>
									<th>Status</th>
								</tr>
							</thead>

							<tbody>

								<c:forEach var="A" items="${ActiveYearList}">
									<tr>
										<td><c:out value="${A.acadamicYearId}"></c:out></td>
										<td><c:out value="${A.acadamicyear}"></c:out></td>
										<td><c:out value="${A.ActiveAcadamicYr}"></c:out></td>
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

</body>
</html>