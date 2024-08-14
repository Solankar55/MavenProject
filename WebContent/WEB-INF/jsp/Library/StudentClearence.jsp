<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1>
				<b>Student Clearance</b>
			</h1>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="GetStudDetails.html" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Academic Year:<span style="color: red;">*</span>
						</label>

						<div class="col-sm-9">
							<select class="col-xs-3" id="selectYear" name="SelectYear"
								required>
								<option value="">------Select Year-------</option>
								<c:forEach var="acadamicYr" items="${acadamicYr }">
									<option value="${acadamicYr.key }">${acadamicYr.value }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Registration Id:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="StudRegistrationId"
								placeholder="Student Registration Id" name="StudRegistrationId"
								required pattern="[a-z A-Z 0-9]+"
								title="Please Enter Correct Student Id" />
						</div>
					</div>

					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success"
								value="Get Details" onclick="onPurchaseDiscount()">Get
								Details</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr />
		<h4>Book Issue Table</h4>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Book Id</th>
									<th>Author</th>
									<th>Title</th>
									<th>Issue Date</th>
									<th>Price per Book</th>
								</tr>
							</thead>

							<tbody id="ThirdTable">

								<c:forEach var="R3" items="${NotReturningDetails}">
									<tr>
										<td><c:out value="${R3.AccessionLibraryRegisterId}"></c:out></td>
										<td><c:out value="${R3.Author}"></c:out></td>
										<td><c:out value="${R3.Title}"></c:out></td>
										<td><c:out value="${R3.issueDate}"></c:out></td>
										<td><c:out value="${R3.PrizePerBook}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<hr />
		<div class="form-group">

			<label class="col-sm-3 "> Total Fine : </label>
			<div class="col-sm-9">
				<input type="text" class="col-xs-3" id="ThirdID"
					placeholder="Total Fine" name="StudentRegistrationId"
					value="${FineForNotReturn}">
			</div>

		</div>
		<br>
		<hr />
		<h4>Student Book Return Details Table</h4>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table1"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Book Id</th>
									<th>Issue Date</th>
									<th>Return Date</th>
									<th>Fine</th>
								</tr>
							</thead>

							<tbody id="FirstTable">
								<c:forEach var="R" items="${finedetailStud}">
									<tr>
										<td><c:out value="${R.bookAccessionId}"></c:out></td>
										<td><c:out value="${R.IssueDate}"></c:out></td>
										<td><c:out value="${R.ReturnDate}"></c:out></td>
										<td><c:out value="${R.Fine}"></c:out></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<hr />

		<div class="form-group">
			<label class="col-sm-3 ">Total Fine :</label>
			<div class="col-sm-9">
				<input type="text" class="col-xs-3" id="FirstID"
					placeholder="Total Fine" name="StudentRegistrationId"
					value="${totalfineStud}">
			</div>
		</div>

		<br>
		<hr />
		<h4>Book Lost Details</h4>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table2"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Book Id</th>
									<th>Book Name</th>
									<th>Book Author</th>
									<th>Lost Date</th>
									<th>Prize Per Book</th>
								</tr>
							</thead>

							<tbody id="SecondTable">

								<c:forEach var="R1" items="${LostdetailStud}">
									<tr>
										<td><c:out value="${R1.AccessionLibraryRegisterId}"></c:out></td>
										<td><c:out value="${R1.Title}"></c:out></td>
										<td><c:out value="${R1.Author}"></c:out></td>
										<td><c:out value="${R1.DateLost}"></c:out></td>
										<td><c:out value="${R1.PrizePerBook}"></c:out></td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<hr />

		<div class="form-group">
			<label class="col-sm-3 ">Total Price of Book :</label>
			<div class="col-sm-9">
				<input type="text" class="col-xs-3" id="SecondID"
							placeholder="Total Price of Book " name="StudentRegistrationId"
							value="${SetLostTotal}">
			</div>
		</div>

		<br>
		<hr />
		<div class="form-group">
			<label class="col-sm-3 ">Total Fine is Rupess :</label>
			<div class="col-sm-9">
				<input type="text" class="col-xs-3" id="SecondID" placeholder="Total Fine"
							name="" value="${FinalAmountFine}">
			</div>
		</div>

		<br>
		<hr />
		<script>
		$(document).ready(function() {

			var first = $("#FirstID").val();
			var second = $("#SecondID").val();
			var third = $("#ThirdID").val();

		});

		function onPurchaseDiscount() {

			var result = first + second;

			alert("Result is: " + result);
		}
	</script>
	</div>
	<br>
	<br>
	<br>
	<%-- <script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null ],
				"aaSorting" : []

			});
			var myTable = $('#dynamic-table1').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null ],
				"aaSorting" : []

			});
			var myTable = $('#dynamic-table2').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null],
				"aaSorting" : []

			});
		})
	</script> --%>
</body>
</html>