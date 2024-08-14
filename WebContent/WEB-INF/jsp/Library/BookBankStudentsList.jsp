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
				<h1><b>Book-Bank List</b></h1>
				
			</center>
		</div>
	<div class="row">
			<div class="col-xs-12">
				<form role="form" action="StudentBookBankData.html"
					class="form-horizontal" target="_blank">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="dynamic-table"
								class="table  table-bordered table-hover">
								<thead>
									<tr>
									<th><center>Academic Yr</center></th>
										<th><center>Student ID</center></th>
										<th><center>Student Name</center></th>
										<th><center>Catagory</center></th>
										<th><center>Book AccessionId</center></th>
										<th><center>Title</center></th>
										<th><center>Author</center></th>
										<th><center>IssueDate</center></th>
										<th><center>ReturnDate</center></th>
										<th><center>IssueReturnStatus</center></th>
										<th><center>Fine</center></th>
									</tr>
								</thead>
								<tbody id="BookBankList">
									 <c:forEach var="v" items="${BookBankDataList}">
										<tr>
											<td><c:out value="${v.labacademicyear}"></c:out></td>
											<td><c:out value="${v.admissionRegId}"></c:out></td>
											 <td><c:out
													value="${v.studentFirstName } ${v.studentMiddleName} ${v.studentLastName}"></c:out></td>
											<td><c:out value="${v.studentCategory}"></c:out></td>
											<td><c:out value="${v.bookAccessionId}"></c:out></td>
											<td><c:out value="${v.Title}"></c:out></td>
											<td><c:out value="${v.author}"></c:out></td>
											<td><c:out value="${v.bkIssueDate}"></c:out></td>
											<td><c:out value="${v.bkReturnDate}"></c:out></td> 
											<td><c:out value="${v.IssuedBookStatus}"></c:out></td>
											<td><c:out value="${v.Fine}"></c:out></td>
										</tr>
									</c:forEach> 


								</tbody>
							</table>
						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" name="PrintBookBankList"
								class="btn btn-big btn-success">Generate Report</button>
						</div>
					</div>
				</form>
			</div>
			<!-- /.span -->
		</div></div>
		<br><br><br>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null, null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>
</body>
</html>