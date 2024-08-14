<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1><b>Download Student Leaving Certificate</b></h1>
			<center><font color="red">If you Request For The <b>Leaving Certificate</b>  And Request Is <b>Approved</b>. Then You <b>Are Not Eligible</b> To Handle This Account AnyMore And You Will <b>Unable</b> To Take All Any College Facility...</font></center>
		</div>
	<form action="downloadLeavingCertificateStud.html" method="post" 
target="_blank" >	
		<c:forEach var="v" items="${GetStudentDetails }">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table">
							<thead>
							<tr>
								<th>Student Registration Id</th>
							<!-- 	<th>L.C.No</th> -->
								<th>Academic Year</th>
							<!-- 	<th>Date</th> -->

							</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" name="StudentID" id="StudentID" value="${v.admissionRegId }"
										 readonly="true"></td>
									<%-- <td><input type="text" name="" id="" value="${LCNumber }"
										readonly="true"></td> --%>

									<td><input type="text" name="" id="" value="${v.acadamicYear }"
										 readonly="true" /></td>

									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="" class="table">
						<tr>
							<th>Student Name</th>
							<th>Gender</th>
							<th>Date of Birth</th>
							<th>Place of Birth</th>
							
						</tr>
						<tbody>
							<tr>
								<td><input type="text" name="" id="" value="${v.studentFirstName } ${v.studentLastName }"
									readonly="true"></td>
								<td><input type="text" name="" id=""  value="${v.studentGender }"
									readonly="true"></td>
								<td><input type="text" name="" id="" value="${v.studentDateOfBirth }"
									readonly="true"></td>
								<td><input type="text" name="" id="" value="${v.studentPlaceOfBirth }"
									readonly="true" /></td>

							</tr>	
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- /.span -->
	</div>	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="" class="table">
						<tr>
						<th>Nationality</th>
						<th>Category</th>
						<th>Caste</th>
						<th>Sub Caste</th>
						</tr>
						<tbody>
							<tr>
								<td><input type="text" name="" id="" value="${v.studentNationality }"
									readonly="true" /></td>

								<td><input type="text"  name="" id="" value="${v.studentCategory }"
									readonly="true" /></td>
								<td><input type="text"  name="" id="" value="${v.studentCast }"
										readonly="true" /></td>

								<td><input type="text"  name="" id="" value="${v.studentSubCast }"
										 readonly="true" /></td>
							</tr>			
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- /.span -->
	</div>	
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table">
							<tr>
								<th>Date Of Admission</th>
								<th>Standard</th>
								<th>Religion</th>
								<th>Mother Tongue</th>
							</tr>
							<tbody>
								<tr>
									<td><input type="text" name="" id="" value="${v.admissionDate }"
										readonly="true"></td>
									<td><input type="text" name="" id="" value="${v.standard }"
										readonly="true"></td>

									<td><input type="text" name="" id="" value="${v.studentReligion }"
										readonly="true" /></td>

									<td><input type="text" name="" id="" value="${v.studentMotherTongue }"
										readonly="true" /></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		</c:forEach>
		<hr>
			<div class="center">
				<button id="sendReq" name="DownloadCertificate" type="submit" class="btn btn-sm btn-purple">
				Download Leaving Certificate</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>