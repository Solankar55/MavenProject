<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<h1>
					<b>Teaching Staff Login Information</b>
				</h1>
			</center></div>
			
			<div class="row">
				<div class="col-xs-12">
					<form role="form" action="NonTeachingStaffRegistrationInfoPrintP.html"
						class="form-horizontal" target="_blank">
						<!-- PAGE CONTENT BEGINS -->
						<div class="row">
							<div class="col-xs-12">
								<table id="dynamic-table"
									class="table  table-bordered table-hover">
									<thead>
										<tr>
											<th><center>StaffName</center></th>
											<th><center>StaffType</center></th>
											<th><center>Contact</center></th>
											<th><center>Email</center></th>
											<th><center>Barcode</center></th>
											<th><center>UserName</center></th>
											<th><center>Password</center></th>
										
											
										</tr>
									</thead>
									<tbody id="NonTeachingStaffList">
										<c:forEach var="v" items="${NonTeachingStaffRegistrationInfo}">
											<tr>
												<td><center>
														<c:out value="${v.StaffName}"></c:out>
													</center></td>
												<td><center>
														<c:out value="${v.StaffType}"></c:out>
													</center></td>
												<td><center>
														<c:out value="${v.MobileNumber}"></c:out>
													</center></td>
												<td><center>
														<c:out
															value="${v.StaffEmail } "></c:out>
													</center></td>
												<td><center>
														<c:out value="${v.barcode}"></c:out>
													</center></td>
												<td><center>
														<c:out value="${v.UserName}"></c:out>
													</center></td>
												<td><center>
														<c:out value="${v.Password}"></c:out>
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
						"aoColumns" : [ null, null, null, null, null, null,null],
						"aaSorting" : []

					});
		})
	</script>
</body>
</html>