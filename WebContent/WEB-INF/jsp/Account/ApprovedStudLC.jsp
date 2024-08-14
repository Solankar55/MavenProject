<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approved Student Leaving Certificate List</title>
</head>
<body>
<div class="page-content">
			<div class="page-header">
				<h1><b>Approved Student Leaving Certificate List</b></h1>
			</div>
			<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Student Id</th>
									<th>Student Name</th>
									<th>Gender</th>
									<th>Date of Birth</th>
									<th>Nationality</th>
									<th>Academic Year</th>
									<!-- <th>Approve/Cancel</th> -->
								</tr>
							</thead>

							<tbody id="ledgerTable">
								<c:forEach var="v" items="${ApprovedLeavingCertificateList}">

									<tr>
										<td><c:out value="${v.admissionRegId }"></c:out></td>
										<td><c:out
												value="${v.studentFirstName}  ${v.studentLastName }"></c:out></td>
										<td><c:out value="${v.studentGender}"></c:out></td>
										<td><c:out value="${v.studentDateOfBirth}"></c:out></td>
										<td><c:out value="${v.studentNationality }"></c:out></td>
										<td><c:out value="${v.acadamicYear }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.streamName }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.standard }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentSubCast }"></c:out></td>

										<td style="display: none;"><c:out
												value="${v.studentReligion }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCategory }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentCast }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentPlaceOfBirth }"></c:out></td>
										<td style="display: none;"><c:out
												value="${v.studentMotherTongue }"></c:out></td>
														
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
</body>
</html>