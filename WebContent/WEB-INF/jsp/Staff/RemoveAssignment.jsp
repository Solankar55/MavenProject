<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function deletefunction(id)
{
	var assid=id;
	var txt;
	var assignmentID=$("."+assid).html();
	var r = confirm("Are you surely want to Delete Assignment ID: "+assignmentID);
	if (r == true) {
		$.getJSON('deleterowAssignment.html',{assid : assid}).done(function(data) {
			document.getElementById(assid.trim()).remove();
		});
	} 
}

</script>
</head>
<body>
<div class="page-content">
			<div class="page-header center">
				<h1>Remove Assignment Of Student</h1>
				<h4>Click On Assignment And Delete Perticular Assignment</h4>
			</div>
			
			<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Assignment Id</th>
									<th>Assignment Date</th>
									<th>Subject</th>
									<th>Assignment Status</th>
									<th>Assignment</th>
									
									
								</tr>
							</thead>

							<tbody id="">
								<c:forEach var="v" items="${GivenAssignmentList}">

									<tr  id="${v.AssignmentID}" onclick="deletefunction(id)">
										<td class="${v.AssignmentID}"><c:out value="${v.AssignmentID}"></c:out></td>
										<td><c:out value="${v.AssignmentDate}  "></c:out></td>
										<td ><c:out value="${v.SubjectName}"></c:out></td>
										<td><c:out value="${v.AssignmentStatus}"></c:out></td>
										<td><c:out value="${v.AssignmentMessage}"></c:out></td>
										
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
</body>
</html>