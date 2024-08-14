<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book In Department</title>
</head>
<body>

	<div class="page-content">
		<div class="page-header center">

			<h1>
				<b>Books In Department Master</b>
			</h1>

		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="getListOfBooks.html" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Department :<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" id="department" name="Department" required>
								<option value="">---Select Department---</option>
												<c:forEach var="DList" items="${DepartmentList}">
												<option value="${DList.key }">${DList.value}</option>
								</c:forEach>
												
							</select>
						</div>
					</div>

					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success" name="Show">
								Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<hr />
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
									<tr>
										<th>AccessionID</th>
										<th>Book For</th>
										<th>Author</th>
										<th>Title</th>	
										<th>Edition</th>										
									</tr>
								</thead>
								
								<tbody id="BookInDepartmentTable">
									<c:forEach var="B" items="${BList}" >	
									<tr onclick="document.getElementById('Oprations').style.display='block'">
										<td>${B.AccessionId}</td>
										<td>${B.BookFor}</td>
										<td>${B.Author}</td>
										<td>${B.Title}</td>
										<td>${B.Edition}</td>										
									<%-- <td><a href="<c:url value='/Delete.html/${R.RackMasterId}'/>"><span class="glyphicon glyphicon-trash"></span></a></td> --%>
									
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
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null ],
				"aaSorting" : []

			});
		})
	</script>





</body>
</html>