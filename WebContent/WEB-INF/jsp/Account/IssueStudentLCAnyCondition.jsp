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
			<h1>
				<b>Issue Student Leaving Certificate</b></h1>
				<h4 style="color: red;">${pendingFee }</h4>
			
		</div>
		<form action="saveAnyConditionLCDetailsAndGetPrint.html" method="post" target="_blank">
		<c:forEach var="studentInfoLC" items="${studentInfoLC}">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Id</th>
										<th>Student Name</th>
										<th>Student Gender</th>
										<th>Student Date Of Birth</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="StudentId" id="StudentID"
											value="${studentInfoLC.admissionRegId }" readonly="true"></td>
										<td><input type="text" name="StudentName"
											id="StudentName" value="${studentInfoLC.studentnamessc}" readonly="true"></td>
										<td><input type="text" name="studentGender"
											id="studentGender" value="${studentInfoLC.studentGender }" readonly="true"></td>

										<td><input type="text" name="studentDOB" id="studentDOB"
											value="${studentInfoLC.studentDateOfBirth }" readonly="true" /></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Student Academic Year</th>
										<th>Student Stream</th>
										<th>Student Standard</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="StudentYear"
											id="StudentYear" value="${studentInfoLC.acadamicYear}" readonly="true"></td>
										<td><input type="text" name="studentStream"
											id="studentStream" value="${studentInfoLC.streamName}" readonly="true"></td>

										<td><input type="text" name="studentStandard"
											id="studentStandard" value="${studentInfoLC.standard}"
											readonly="true" /></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<thead>
									<tr>
										<th>Conduct<span style="color:red;">*</span></th>
										<th>Date Of Leaving the Institution <span style="color:red;">*</span></th>
										<th>Reason for leaving the Institution <span style="color:red;">*</span></th>
										<th>Remark <span style="color:red;">*</span></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="conduct" id="conduct"
											required pattern="[a-z A-Z]+" title="Please Enter Conduct"></td>
										<td><input type="date" name="dateOfLeaving"
											id="dateOfLeaving" 
											required ></td>

										<td><input type="text" name="reasonforLeaving"
											id="reasonforLeaving"  
											required pattern="[a-z A-Z]+" title="Please Enter Correct Reason For Leaving"/></td>
										<td><input type="text" name="remark" id="remark"
											 required pattern="[a-z A-Z]+" title="Please Enter Correct Remark"/></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="center">
				<button id="" type="submit" name="ApproveLC"
					class="btn btn-sm btn-purple">Approve</button>
			</div>
			</c:forEach>
		</form>
	</div>
</body>
</html>