<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff Book Lost</title>
</head>
<style>
button {
	color: blue;
	width: 150px;
	height: 40px;
}
</style>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Staff Book Lost</h1>
				<h6 style="color: red;">${StaffIdNotPresentMsg}</h6>
			</center>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<form role="form" action="StaffBookLostData.html"
					name="staffBookLostForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Book For:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select size="1" id="bookfor" class="col-sm-3" name="BookFor" required>
								<option value="">Select Book For</option>
								<option value="PostGraduation">PostGraduation</option>
								<option value="Degree">Degree</option>
								<option value="Diploma">Diploma</option>
								<option value="Other">Other</option>
							</select>
						</div>

					</div>
					<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Book Id:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="bookid" name="BookId"
								placeholder="Book ID"  />
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Staff Id:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-sm-3" id="staffId" name="StaffId"
							placeholder="Staff ID" required pattern="[0-9]+" title="Please Enter Correct Staff ID">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Staff Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-sm-3" id="staffName"
							placeholder="Staff Name"	name="StaffName" required pattern="[a-z A-Z]+" title="Please Enter Correct Staff Name">
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success">
								Book Lost</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-xs-12">
				<form role="form" action="StaffBookLostData.html"
					name="staffBookLostForm" class="form-horizontal" target="_blank">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="simple-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Staff Lostbook Id</th>
										<th>Staff Name</th>
										<th>BookoFor</th>
										<th>Book Id</th>
										<th>Title</th>
										<th>Author</th>
										<th>Lost Date</th>
									</tr>
								</thead>
								<tbody id="LostStaffBookData">
									<c:forEach var="v" items="${LostStaffBookData}">
										<tr>
											<td><c:out value="${v.LostBookStaffId}"></c:out></td>
											<td><c:out value="${v.StaffName}"></c:out></td>
											<td><c:out value="${v.BookFor}"></c:out></td>
											<td><c:out value="${v.AccessionId}"></c:out></td>
											<td><c:out value="${v.Title}"></c:out></td>
											<td><c:out value="${v.Author}"></c:out></td>
											<td><c:out value="${v.DateLost}"></c:out></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" name="PrintStaffBookLost"
								class="btn btn-big btn-success">Print Book Lost</button>
						</div>
					</div>
				</form>
			</div>

			<!-- /.span -->
		</div>
	</div>
	<br>
	<br>
	<br>


</body>
</html>