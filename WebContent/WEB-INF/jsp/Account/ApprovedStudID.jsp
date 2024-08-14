<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approved Student ID Card List</title>
</head>
<body>
<div class="page-content">
			<div class="page-header center">
				<h1><b>Approved Student ID Card List</b></h1>
			</div>
			<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					<div class="table-header"> Student List</div>
						<table id="dynamic-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Standard</th>
									<th>Stream</th>
									<th>Branch</th>
									<th>Mobile no</th>
									<!-- <th>Division</th> -->
									<!-- <th>Approve</th> -->
								</tr>
							</thead>

							 <tbody id="ledgerTable">
								 <c:forEach var="v" items="${ApprovedIDCardList}">

									<tr >
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.standard}"></c:out></td>
										<td><c:out value="${v.streamName}"></c:out></td>
										<td><c:out value="${v.branchName }"></c:out></td>
										<td><c:out value="${v.studentContactNumber }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentDateOfBirth }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.acadamicYear }"></c:out></td>
										<td style="display: none;"><c:out value="${v.studentPermanenetAddress }"></c:out></td>	
								
									</tr>
								</c:forEach> 

							</tbody> 
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<!-- /.row -->
			
	</div>	
	<br><br><br>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null,null,null,null,null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>