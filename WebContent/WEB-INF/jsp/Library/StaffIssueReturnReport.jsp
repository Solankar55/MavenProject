<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Staff Book Issue-Return Report</b></h1>
			</center>
		</div>
		<div class="row">
			<div class="col-xs-12">
			<div class="col-xs-3"></div>
			<div class="col-xs-8">
				<!-- PAGE CONTENT BEGINS -->
				<form action="printStaffIssueReturnR.html" method="get" id=""
					class="form-horizontal" target="_blank">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							From Date:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="date" class="col-sm-3" id="InDate"
									data-date-format="DD MMMM YYYY" name="InDate">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							To Date:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="date" class="col-sm-3" id="ToDate"
									data-date-format="DD MMMM YYYY" name="ToDate">
						</div>
					</div>
					<div class="col-xs-2"></div>
					<div class="form-group">
						<div class="col-sm-3 ">
							<button type="submit" name="printRpt" class="btn ">Print
									Report</button>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>

		<hr />
		
		<div class="page-header">
		
			<center>
				<h1><b>Staff Issued-Returned List</b></h1>
			</center>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<form role="form" action="StaffIssueReturnDataPrint.html"
					class="form-horizontal" target="_blank">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="dynamic-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th><center>Book Accession ID</center></th>
										<th><center>BookFor</center></th>
										<th><center>Staff Name</center></th>
										<th><center>Department</center></th>
										<th><center>Contact</center></th>
										<th><center>Title</center></th>
										<th><center>Author</center></th>
										<th><center>IssueDate</center></th>
										<th><center>IssueReturnStatus</center></th>
										<th><center>ReturnDate</center></th>
										<th><center>Fine</center></th>
									</tr>
								</thead>
								<tbody id="StaffIssuedReturnedList">
									<c:forEach var="v" items="${StaffIssueReturnDataList}">
										<tr>
											<td><center>
													<c:out value="${v.AccessionId}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.BookFor}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.StaffName }"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.SatffDepartment}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.MobileNumber}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.Title}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.Author}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.IssueDate}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.IssuedBookStatus}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.ReturnDate}"></c:out>
												</center></td>
											<td><center>
													<c:out value="${v.Fine}"></c:out>
												</center></td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" name="PrintAllStaffList"
								class="btn btn-big btn-success">Generate Report</button>
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
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable(
					{
						bAutoWidth : false,
						"aoColumns" : [ null, null, null, null, null, null,
								null, null, null, null, null ],
						"aaSorting" : []

					});
		})
	</script>



</body>
</html>